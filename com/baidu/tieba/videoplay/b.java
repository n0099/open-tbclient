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
    private boolean hIe;
    private Rect lQ;
    private List<VideoItemData> mDatas;
    public String mFrom;

    public b(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.f(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        if (this.hIe) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.lQ);
            this.hIe = false;
        }
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.G(this.mDatas)) {
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

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hIe = true;
        this.lQ = rect;
    }

    public VideoItemData yy(int i) {
        return (VideoItemData) v.f(this.mDatas, i);
    }
}
