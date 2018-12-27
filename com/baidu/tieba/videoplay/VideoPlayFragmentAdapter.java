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
    public String bUJ;
    public String ebX;
    private j.b gFh;
    private QuickVideoView.c gFx;
    private boolean hOO;
    private a hOP;
    private long hOQ;
    private SparseArray<VideoPlayFragment> hOR;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hOQ = -1L;
        this.hOR = new SparseArray<>();
        this.hOP = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.gFh);
        videoPlayFragment.setVideoStatusListener(this.gFx);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.bUJ);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.ebX);
        if (this.hOO) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hOO = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gFx = cVar;
    }

    public void a(j.b bVar) {
        this.gFh = bVar;
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
        this.hOR.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hOR.put(i, videoPlayFragment);
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

    public VideoPlayFragment wW(int i) {
        return this.hOR.get(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hOP.hy(true)) {
            if (this.hOP.aIB() < 0) {
                this.hOP.wY(i);
            } else if (this.hOP.aIB() == i) {
                C((VideoPlayFragment) obj);
            }
        }
    }

    private void C(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hOQ = videoPlayFragment.bMq();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hOO = true;
        this.mRect = rect;
    }

    public void bMu() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hOQ > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hOQ);
        }
    }

    public void wX(int i) {
        List<String> list;
        String str;
        VideoPlayFragment wW;
        VideoPlayFragment wW2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hOR.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.H(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bMs();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bMs = (i + (-1) < 0 || (wW2 = wW(i + (-1))) == null) ? null : wW2.bMs();
        if (i + 1 < getCount() && (wW = wW(i + 1)) != null) {
            str2 = wW.bMs();
        }
        ArrayList arrayList = new ArrayList();
        int H = v.H(list);
        for (int i2 = 0; i2 < H; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bMs) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.I(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
