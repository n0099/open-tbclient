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
    private f.b mxt;
    private VideoPlayFragment.a nME;
    private boolean nML;
    private a nMM;
    private long nMN;
    public String nMO;
    private SparseArray<VideoPlayFragment> nMP;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.nMN = -1L;
        this.nMP = new SparseArray<>();
        this.nMM = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.mxt);
        videoPlayFragment.a(this.nME);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) y.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable("page_from", this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.nMO);
        if (this.nML) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.nML = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.nME = aVar;
    }

    public void a(f.b bVar) {
        this.mxt = bVar;
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
        this.nMP.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.nMP.put(i, videoPlayFragment);
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
        return this.nMP.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.nML = true;
        this.mRect = rect;
    }

    public void dXA() {
        int i = b.bsO().getInt("nani_key_download_show_rate", 2);
        if (this.nMN > 0 && i != 1) {
            b.bsO().putLong("key_vertical_shown_time", this.nMN);
        }
    }

    public void Mu(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Mt;
        VideoPlayFragment Mt2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.nMP.get(i);
        if (videoPlayFragment != null) {
            List<String> dXv = videoPlayFragment.dXv();
            if (y.getCount(dXv) >= 5) {
                list = dXv;
                str = videoPlayFragment.dXw();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dXw = (i + (-1) < 0 || (Mt2 = Mt(i + (-1))) == null) ? null : Mt2.dXw();
        if (i + 1 < getCount() && (Mt = Mt(i + 1)) != null) {
            str2 = Mt.dXw();
        }
        ArrayList arrayList = new ArrayList();
        int count = y.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dXw) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!y.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
