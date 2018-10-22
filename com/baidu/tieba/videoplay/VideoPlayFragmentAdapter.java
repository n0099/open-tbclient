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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public String bQf;
    private j.b gua;
    private QuickVideoView.c guq;
    private boolean hCH;
    private a hCI;
    private long hCJ;
    public String hCK;
    private SparseArray<VideoPlayFragment> hCL;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hCJ = -1L;
        this.hCL = new SparseArray<>();
        this.hCI = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.gua);
        videoPlayFragment.setVideoStatusListener(this.guq);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.bQf);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.hCK);
        if (this.hCH) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hCH = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.guq = cVar;
    }

    public void a(j.b bVar) {
        this.gua = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.J(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.hCL.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hCL.put(i, videoPlayFragment);
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

    public VideoPlayFragment vT(int i) {
        return this.hCL.get(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hCI.hj(true)) {
            if (this.hCI.aGC() < 0) {
                this.hCI.vV(i);
            } else if (this.hCI.aGC() == i) {
                D((VideoPlayFragment) obj);
            }
        }
    }

    private void D(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hCJ = videoPlayFragment.bJX();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hCH = true;
        this.mRect = rect;
    }

    public void bKb() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hCJ > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hCJ);
        }
    }

    public void vU(int i) {
        List<String> list;
        String str;
        VideoPlayFragment vT;
        VideoPlayFragment vT2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hCL.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.I(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bJZ();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bJZ = (i + (-1) < 0 || (vT2 = vT(i + (-1))) == null) ? null : vT2.bJZ();
        if (i + 1 < getCount() && (vT = vT(i + 1)) != null) {
            str2 = vT.bJZ();
        }
        ArrayList arrayList = new ArrayList();
        int I = v.I(list);
        for (int i2 = 0; i2 < I; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bJZ) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.J(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
