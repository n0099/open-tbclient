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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public String bBL;
    private j.b gfg;
    private QuickVideoView.c gfw;
    private boolean hnB;
    private a hnC;
    private long hnD;
    public String hnE;
    private SparseArray<VideoPlayFragment> hnF;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hnD = -1L;
        this.hnF = new SparseArray<>();
        this.hnC = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.gfg);
        videoPlayFragment.setVideoStatusListener(this.gfw);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) w.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.bBL);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.hnE);
        if (this.hnB) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hnB = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gfw = cVar;
    }

    public void a(j.b bVar) {
        this.gfg = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (w.z(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.hnF.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hnF.put(i, videoPlayFragment);
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

    public VideoPlayFragment uW(int i) {
        return this.hnF.get(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hnC.gt(true)) {
            if (this.hnC.aBf() < 0) {
                this.hnC.uY(i);
            } else if (this.hnC.aBf() == i) {
                A((VideoPlayFragment) obj);
            }
        }
    }

    private void A(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hnD = videoPlayFragment.bDS();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hnB = true;
        this.mRect = rect;
    }

    public void bDW() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hnD > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hnD);
        }
    }

    public void uX(int i) {
        List<String> list;
        String str;
        VideoPlayFragment uW;
        VideoPlayFragment uW2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hnF.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (w.y(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bDU();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bDU = (i + (-1) < 0 || (uW2 = uW(i + (-1))) == null) ? null : uW2.bDU();
        if (i + 1 < getCount() && (uW = uW(i + 1)) != null) {
            str2 = uW.bDU();
        }
        ArrayList arrayList = new ArrayList();
        int y = w.y(list);
        for (int i2 = 0; i2 < y; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bDU) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!w.z(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
