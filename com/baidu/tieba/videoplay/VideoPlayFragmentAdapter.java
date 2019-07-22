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
    public String dxn;
    private j.b ivg;
    private QuickVideoView.c ivx;
    private boolean jFr;
    private a jFs;
    private long jFt;
    public String jFu;
    private SparseArray<VideoPlayFragment> jFv;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.jFt = -1L;
        this.jFv = new SparseArray<>();
        this.jFs = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.ivg);
        videoPlayFragment.setVideoStatusListener(this.ivx);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.c(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.dxn);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.jFu);
        if (this.jFr) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.jFr = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.ivx = cVar;
    }

    public void a(j.b bVar) {
        this.ivg = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.aa(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.jFv.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.jFv.put(i, videoPlayFragment);
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

    public VideoPlayFragment Cw(int i) {
        return this.jFv.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.jFr = true;
        this.mRect = rect;
    }

    public void cxx() {
        int i = b.ahO().getInt("nani_key_download_show_rate", 2);
        if (this.jFt > 0 && i != 1) {
            b.ahO().putLong("key_vertical_shown_time", this.jFt);
        }
    }

    public void Cx(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Cw;
        VideoPlayFragment Cw2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.jFv.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.Z(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.cxv();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String cxv = (i + (-1) < 0 || (Cw2 = Cw(i + (-1))) == null) ? null : Cw2.cxv();
        if (i + 1 < getCount() && (Cw = Cw(i + 1)) != null) {
            str2 = Cw.cxv();
        }
        ArrayList arrayList = new ArrayList();
        int Z = v.Z(list);
        for (int i2 = 0; i2 < Z; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, cxv) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.aa(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
