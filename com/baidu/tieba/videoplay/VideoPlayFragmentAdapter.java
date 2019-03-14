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
/* loaded from: classes6.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public String dku;
    private QuickVideoView.c hWE;
    private j.b hWn;
    private boolean jgv;
    private a jgw;
    private long jgx;
    public String jgy;
    private SparseArray<VideoPlayFragment> jgz;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.jgx = -1L;
        this.jgz = new SparseArray<>();
        this.jgw = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.hWn);
        videoPlayFragment.setVideoStatusListener(this.hWE);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.c(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.dku);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.jgy);
        if (this.jgv) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.jgv = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.hWE = cVar;
    }

    public void a(j.b bVar) {
        this.hWn = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.T(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.jgz.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.jgz.put(i, videoPlayFragment);
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

    public VideoPlayFragment AL(int i) {
        return this.jgz.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.jgv = true;
        this.mRect = rect;
    }

    public void cmG() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.jgx > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.jgx);
        }
    }

    public void AM(int i) {
        List<String> list;
        String str;
        VideoPlayFragment AL;
        VideoPlayFragment AL2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.jgz.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.S(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.cmE();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String cmE = (i + (-1) < 0 || (AL2 = AL(i + (-1))) == null) ? null : AL2.cmE();
        if (i + 1 < getCount() && (AL = AL(i + 1)) != null) {
            str2 = AL.cmE();
        }
        ArrayList arrayList = new ArrayList();
        int S = v.S(list);
        for (int i2 = 0; i2 < S; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, cmE) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.T(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
