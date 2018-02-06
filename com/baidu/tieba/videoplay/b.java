package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.VideoItemData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends FragmentStatePagerAdapter {
    private boolean hzr;
    private com.baidu.tieba.videoplay.a.a hzs;
    private long hzt;
    private Rect lQ;
    private List<VideoItemData> mDatas;
    public String mFrom;

    public b(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hzt = -1L;
        this.hzs = new com.baidu.tieba.videoplay.a.a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.f(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        if (this.hzr) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.lQ);
            this.hzr = false;
        }
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.E(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hzs.gw(true)) {
            if (this.hzs.aAK() < 0) {
                this.hzs.xa(i);
            } else if (this.hzs.aAK() == i) {
                t((a) obj);
            }
        }
    }

    private void t(a aVar) {
        if (aVar != null) {
            this.hzt = aVar.bEy();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hzr = true;
        this.lQ = rect;
    }

    public VideoItemData wZ(int i) {
        return (VideoItemData) v.f(this.mDatas, i);
    }

    public void bEz() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hzt > 0 && i != 1) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_vertical_shown_time", this.hzt);
        }
    }
}
