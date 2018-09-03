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
    public String bBN;
    private j.b gff;
    private QuickVideoView.c gfv;
    private boolean hnC;
    private a hnD;
    private long hnE;
    public String hnF;
    private SparseArray<VideoPlayFragment> hnG;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hnE = -1L;
        this.hnG = new SparseArray<>();
        this.hnD = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.gff);
        videoPlayFragment.setVideoStatusListener(this.gfv);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) w.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.bBN);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.hnF);
        if (this.hnC) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hnC = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gfv = cVar;
    }

    public void a(j.b bVar) {
        this.gff = bVar;
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
        this.hnG.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hnG.put(i, videoPlayFragment);
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
        return this.hnG.get(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hnD.gt(true)) {
            if (this.hnD.aBc() < 0) {
                this.hnD.uY(i);
            } else if (this.hnD.aBc() == i) {
                A((VideoPlayFragment) obj);
            }
        }
    }

    private void A(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hnE = videoPlayFragment.bDU();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hnC = true;
        this.mRect = rect;
    }

    public void bDY() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hnE > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hnE);
        }
    }

    public void uX(int i) {
        List<String> list;
        String str;
        VideoPlayFragment uW;
        VideoPlayFragment uW2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hnG.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (w.y(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bDW();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bDW = (i + (-1) < 0 || (uW2 = uW(i + (-1))) == null) ? null : uW2.bDW();
        if (i + 1 < getCount() && (uW = uW(i + 1)) != null) {
            str2 = uW.bDW();
        }
        ArrayList arrayList = new ArrayList();
        int y = w.y(list);
        for (int i2 = 0; i2 < y; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bDW) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!w.z(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
