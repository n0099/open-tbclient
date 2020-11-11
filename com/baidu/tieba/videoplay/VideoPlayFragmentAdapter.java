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
    private f.b miU;
    private boolean nxB;
    private a nxC;
    private long nxD;
    public String nxE;
    private SparseArray<VideoPlayFragment> nxF;
    private VideoPlayFragment.a nxu;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.nxD = -1L;
        this.nxF = new SparseArray<>();
        this.nxC = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.miU);
        videoPlayFragment.a(this.nxu);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) y.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable("page_from", this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.nxE);
        if (this.nxB) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.nxB = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.nxu = aVar;
    }

    public void a(f.b bVar) {
        this.miU = bVar;
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
        this.nxF.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.nxF.put(i, videoPlayFragment);
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

    public VideoPlayFragment KY(int i) {
        return this.nxF.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.nxB = true;
        this.mRect = rect;
    }

    public void dSg() {
        int i = b.bqh().getInt("nani_key_download_show_rate", 2);
        if (this.nxD > 0 && i != 1) {
            b.bqh().putLong("key_vertical_shown_time", this.nxD);
        }
    }

    public void KZ(int i) {
        List<String> list;
        String str;
        VideoPlayFragment KY;
        VideoPlayFragment KY2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.nxF.get(i);
        if (videoPlayFragment != null) {
            List<String> dSb = videoPlayFragment.dSb();
            if (y.getCount(dSb) >= 5) {
                list = dSb;
                str = videoPlayFragment.dSc();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dSc = (i + (-1) < 0 || (KY2 = KY(i + (-1))) == null) ? null : KY2.dSc();
        if (i + 1 < getCount() && (KY = KY(i + 1)) != null) {
            str2 = KY.dSc();
        }
        ArrayList arrayList = new ArrayList();
        int count = y.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dSc) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!y.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
