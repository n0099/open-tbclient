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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private f.b lbN;
    private List<VideoItemData> mDatas;
    public String mFrom;
    public String mFromPage;
    private Rect mRect;
    private boolean mnG;
    private a mnH;
    private long mnI;
    public String mnJ;
    private SparseArray<VideoPlayFragment> mnK;
    private VideoPlayFragment.a mnz;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mnI = -1L;
        this.mnK = new SparseArray<>();
        this.mnH = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.lbN);
        videoPlayFragment.a(this.mnz);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) x.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.mnJ);
        if (this.mnG) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.mnG = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.mnz = aVar;
    }

    public void a(f.b bVar) {
        this.lbN = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (x.isEmpty(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.mnK.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.mnK.put(i, videoPlayFragment);
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

    public VideoPlayFragment GN(int i) {
        return this.mnK.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.mnG = true;
        this.mRect = rect;
    }

    public void dtl() {
        int i = b.aZP().getInt("nani_key_download_show_rate", 2);
        if (this.mnI > 0 && i != 1) {
            b.aZP().putLong("key_vertical_shown_time", this.mnI);
        }
    }

    public void GO(int i) {
        List<String> list;
        String str;
        VideoPlayFragment GN;
        VideoPlayFragment GN2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.mnK.get(i);
        if (videoPlayFragment != null) {
            List<String> dtg = videoPlayFragment.dtg();
            if (x.getCount(dtg) >= 5) {
                list = dtg;
                str = videoPlayFragment.dth();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dth = (i + (-1) < 0 || (GN2 = GN(i + (-1))) == null) ? null : GN2.dth();
        if (i + 1 < getCount() && (GN = GN(i + 1)) != null) {
            str2 = GN.dth();
        }
        ArrayList arrayList = new ArrayList();
        int count = x.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dth) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!x.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
