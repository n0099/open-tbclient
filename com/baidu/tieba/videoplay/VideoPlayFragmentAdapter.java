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
    private boolean gVC;
    private a gVD;
    private long gVE;
    public String gVF;
    private SparseArray<VideoPlayFragment> gVG;
    public boolean gVu;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.gVE = -1L;
        this.gVG = new SparseArray<>();
        this.gVD = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.c(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FIRST_IN, Boolean.valueOf(this.gVu));
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.gVF);
        if (this.gVC) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.gVC = false;
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
        this.gVG.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.gVG.put(i, videoPlayFragment);
        return videoPlayFragment;
    }

    public VideoPlayFragment uD(int i) {
        return this.gVG.get(i);
    }

    public SparseArray<VideoPlayFragment> bzM() {
        return this.gVG;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.gVD.gb(true)) {
            if (this.gVD.avH() < 0) {
                this.gVD.uF(i);
            } else if (this.gVD.avH() == i) {
                y((VideoPlayFragment) obj);
            }
        }
    }

    private void y(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.gVE = videoPlayFragment.bzI();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.gVC = true;
        this.mRect = rect;
    }

    public void bzN() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.gVE > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.gVE);
        }
    }

    public void uE(int i) {
        List<String> list;
        String str;
        VideoPlayFragment uD;
        VideoPlayFragment uD2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.gVG.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.v(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bzK();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bzK = (i + (-1) < 0 || (uD2 = uD(i + (-1))) == null) ? null : uD2.bzK();
        if (i + 1 < getCount() && (uD = uD(i + 1)) != null) {
            str2 = uD.bzK();
        }
        ArrayList arrayList = new ArrayList();
        int v = v.v(list);
        for (int i2 = 0; i2 < v; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bzK) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.w(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
