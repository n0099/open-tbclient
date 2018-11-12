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
    public String bQP;
    private j.b gvA;
    private QuickVideoView.c gvQ;
    private boolean hEr;
    private a hEs;
    private long hEt;
    public String hEu;
    private SparseArray<VideoPlayFragment> hEv;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hEt = -1L;
        this.hEv = new SparseArray<>();
        this.hEs = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.gvA);
        videoPlayFragment.setVideoStatusListener(this.gvQ);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.bQP);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.hEu);
        if (this.hEr) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hEr = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gvQ = cVar;
    }

    public void a(j.b bVar) {
        this.gvA = bVar;
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
        this.hEv.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hEv.put(i, videoPlayFragment);
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

    public VideoPlayFragment wm(int i) {
        return this.hEv.get(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hEs.ht(true)) {
            if (this.hEs.aGa() < 0) {
                this.hEs.wo(i);
            } else if (this.hEs.aGa() == i) {
                D((VideoPlayFragment) obj);
            }
        }
    }

    private void D(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hEt = videoPlayFragment.bJw();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hEr = true;
        this.mRect = rect;
    }

    public void bJA() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hEt > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hEt);
        }
    }

    public void wn(int i) {
        List<String> list;
        String str;
        VideoPlayFragment wm;
        VideoPlayFragment wm2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hEv.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.H(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bJy();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bJy = (i + (-1) < 0 || (wm2 = wm(i + (-1))) == null) ? null : wm2.bJy();
        if (i + 1 < getCount() && (wm = wm(i + 1)) != null) {
            str2 = wm.bJy();
        }
        ArrayList arrayList = new ArrayList();
        int H = v.H(list);
        for (int i2 = 0; i2 < H; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bJy) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.I(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
