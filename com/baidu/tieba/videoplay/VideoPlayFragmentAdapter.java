package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private List<VideoItemData> mDatas;
    public String mFrom;
    public String mFromPage;
    private Rect mRect;
    private f.b mxr;
    private VideoPlayFragment.a nMC;
    private boolean nMJ;
    private a nMK;
    private long nML;
    public String nMM;
    private SparseArray<VideoPlayFragment> nMN;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.nML = -1L;
        this.nMN = new SparseArray<>();
        this.nMK = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.mxr);
        videoPlayFragment.a(this.nMC);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) y.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable("page_from", this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.nMM);
        if (this.nMJ) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.nMJ = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.nMC = aVar;
    }

    public void a(f.b bVar) {
        this.mxr = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (y.isEmpty(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.nMN.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.nMN.put(i, videoPlayFragment);
        return videoPlayFragment;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle = (Bundle) super.saveState();
        if (bundle != null) {
            bundle.putParcelableArray("states", null);
        }
        return bundle;
    }

    public VideoPlayFragment Mt(int i) {
        return this.nMN.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.nMJ = true;
        this.mRect = rect;
    }

    public void dXz() {
        int i = b.bsO().getInt("nani_key_download_show_rate", 2);
        if (this.nML > 0 && i != 1) {
            b.bsO().putLong("key_vertical_shown_time", this.nML);
        }
    }

    public void Mu(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Mt;
        VideoPlayFragment Mt2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.nMN.get(i);
        if (videoPlayFragment != null) {
            List<String> dXu = videoPlayFragment.dXu();
            if (y.getCount(dXu) >= 5) {
                list = dXu;
                str = videoPlayFragment.dXv();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dXv = (i + (-1) < 0 || (Mt2 = Mt(i + (-1))) == null) ? null : Mt2.dXv();
        if (i + 1 < getCount() && (Mt = Mt(i + 1)) != null) {
            str2 = Mt.dXv();
        }
        ArrayList arrayList = new ArrayList();
        int count = y.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dXv) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!y.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
