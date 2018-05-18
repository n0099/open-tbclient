package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private boolean gWG;
    private a gWH;
    private long gWI;
    public String gWJ;
    private SparseArray<VideoPlayFragment> gWK;
    public boolean gWy;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.gWI = -1L;
        this.gWK = new SparseArray<>();
        this.gWH = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.c(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FIRST_IN, Boolean.valueOf(this.gWy));
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.gWJ);
        if (this.gWG) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.gWG = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.w(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.gWK.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.gWK.put(i, videoPlayFragment);
        return videoPlayFragment;
    }

    public VideoPlayFragment uC(int i) {
        return this.gWK.get(i);
    }

    public SparseArray<VideoPlayFragment> bzK() {
        return this.gWK;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.gWH.gc(true)) {
            if (this.gWH.avG() < 0) {
                this.gWH.uE(i);
            } else if (this.gWH.avG() == i) {
                y((VideoPlayFragment) obj);
            }
        }
    }

    private void y(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.gWI = videoPlayFragment.bzG();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.gWG = true;
        this.mRect = rect;
    }

    public void bzL() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.gWI > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.gWI);
        }
    }

    public void uD(int i) {
        List<String> list;
        String str;
        VideoPlayFragment uC;
        VideoPlayFragment uC2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.gWK.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.v(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bzI();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bzI = (i + (-1) < 0 || (uC2 = uC(i + (-1))) == null) ? null : uC2.bzI();
        if (i + 1 < getCount() && (uC = uC(i + 1)) != null) {
            str2 = uC.bzI();
        }
        ArrayList arrayList = new ArrayList();
        int v = v.v(list);
        for (int i2 = 0; i2 < v; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bzI) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.w(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
