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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes11.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private j.b kSS;
    private QuickVideoView.c kTk;
    private List<VideoItemData> mDatas;
    public String mFrom;
    public String mFromPage;
    private Rect mRect;
    private boolean mgr;
    private a mgs;
    private long mgt;
    public String mgu;
    private SparseArray<VideoPlayFragment> mgv;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mgt = -1L;
        this.mgv = new SparseArray<>();
        this.mgs = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.kSS);
        videoPlayFragment.setVideoStatusListener(this.kTk);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) w.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.mgu);
        if (this.mgr) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.mgr = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.kTk = cVar;
    }

    public void a(j.b bVar) {
        this.kSS = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (w.isEmpty(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.mgv.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.mgv.put(i, videoPlayFragment);
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

    public VideoPlayFragment Gr(int i) {
        return this.mgv.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.mgr = true;
        this.mRect = rect;
    }

    public void dqc() {
        int i = b.aVP().getInt("nani_key_download_show_rate", 2);
        if (this.mgt > 0 && i != 1) {
            b.aVP().putLong("key_vertical_shown_time", this.mgt);
        }
    }

    public void Gs(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Gr;
        VideoPlayFragment Gr2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.mgv.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (w.getCount(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.dpY();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dpY = (i + (-1) < 0 || (Gr2 = Gr(i + (-1))) == null) ? null : Gr2.dpY();
        if (i + 1 < getCount() && (Gr = Gr(i + 1)) != null) {
            str2 = Gr.dpY();
        }
        ArrayList arrayList = new ArrayList();
        int count = w.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dpY) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!w.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
