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
/* loaded from: classes2.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public String bHC;
    private QuickVideoView.c gmN;
    private j.b gmx;
    private boolean hvu;
    private a hvv;
    private long hvw;
    public String hvx;
    private SparseArray<VideoPlayFragment> hvy;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hvw = -1L;
        this.hvy = new SparseArray<>();
        this.hvv = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.gmx);
        videoPlayFragment.setVideoStatusListener(this.gmN);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.bHC);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.hvx);
        if (this.hvu) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hvu = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gmN = cVar;
    }

    public void a(j.b bVar) {
        this.gmx = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.z(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.hvy.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hvy.put(i, videoPlayFragment);
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

    public VideoPlayFragment vw(int i) {
        return this.hvy.get(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hvv.gR(true)) {
            if (this.hvv.aDk() < 0) {
                this.hvv.vy(i);
            } else if (this.hvv.aDk() == i) {
                D((VideoPlayFragment) obj);
            }
        }
    }

    private void D(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hvw = videoPlayFragment.bGL();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hvu = true;
        this.mRect = rect;
    }

    public void bGP() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hvw > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hvw);
        }
    }

    public void vx(int i) {
        List<String> list;
        String str;
        VideoPlayFragment vw;
        VideoPlayFragment vw2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hvy.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.y(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bGN();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bGN = (i + (-1) < 0 || (vw2 = vw(i + (-1))) == null) ? null : vw2.bGN();
        if (i + 1 < getCount() && (vw = vw(i + 1)) != null) {
            str2 = vw.bGN();
        }
        ArrayList arrayList = new ArrayList();
        int y = v.y(list);
        for (int i2 = 0; i2 < y; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bGN) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.z(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
