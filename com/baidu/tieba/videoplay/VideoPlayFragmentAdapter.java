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
    public String bUG;
    public String dZg;
    private QuickVideoView.c gCG;
    private j.b gCq;
    private boolean hLD;
    private a hLE;
    private long hLF;
    private SparseArray<VideoPlayFragment> hLG;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hLF = -1L;
        this.hLG = new SparseArray<>();
        this.hLE = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.gCq);
        videoPlayFragment.setVideoStatusListener(this.gCG);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.bUG);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.dZg);
        if (this.hLD) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hLD = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gCG = cVar;
    }

    public void a(j.b bVar) {
        this.gCq = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.I(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.hLG.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hLG.put(i, videoPlayFragment);
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

    public VideoPlayFragment wJ(int i) {
        return this.hLG.get(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hLE.hv(true)) {
            if (this.hLE.aHM() < 0) {
                this.hLE.wL(i);
            } else if (this.hLE.aHM() == i) {
                C((VideoPlayFragment) obj);
            }
        }
    }

    private void C(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hLF = videoPlayFragment.bLA();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hLD = true;
        this.mRect = rect;
    }

    public void bLE() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hLF > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hLF);
        }
    }

    public void wK(int i) {
        List<String> list;
        String str;
        VideoPlayFragment wJ;
        VideoPlayFragment wJ2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hLG.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.H(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bLC();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bLC = (i + (-1) < 0 || (wJ2 = wJ(i + (-1))) == null) ? null : wJ2.bLC();
        if (i + 1 < getCount() && (wJ = wJ(i + 1)) != null) {
            str2 = wJ.bLC();
        }
        ArrayList arrayList = new ArrayList();
        int H = v.H(list);
        for (int i2 = 0; i2 < H; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bLC) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.I(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
