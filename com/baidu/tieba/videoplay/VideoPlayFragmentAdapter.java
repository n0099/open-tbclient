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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private j.b kyV;
    private QuickVideoView.c kzn;
    public String lMA;
    private SparseArray<VideoPlayFragment> lMB;
    private boolean lMx;
    private a lMy;
    private long lMz;
    private List<VideoItemData> mDatas;
    public String mFrom;
    public String mFromPage;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.lMz = -1L;
        this.lMB = new SparseArray<>();
        this.lMy = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.kyV);
        videoPlayFragment.setVideoStatusListener(this.kzn);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.lMA);
        if (this.lMx) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.lMx = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.kzn = cVar;
    }

    public void a(j.b bVar) {
        this.kyV = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (v.isEmpty(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.lMB.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.lMB.put(i, videoPlayFragment);
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

    public VideoPlayFragment Fn(int i) {
        return this.lMB.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.lMx = true;
        this.mRect = rect;
    }

    public void dlM() {
        int i = b.aTX().getInt("nani_key_download_show_rate", 2);
        if (this.lMz > 0 && i != 1) {
            b.aTX().putLong("key_vertical_shown_time", this.lMz);
        }
    }

    public void Fo(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Fn;
        VideoPlayFragment Fn2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.lMB.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.getCount(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.dlI();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dlI = (i + (-1) < 0 || (Fn2 = Fn(i + (-1))) == null) ? null : Fn2.dlI();
        if (i + 1 < getCount() && (Fn = Fn(i + 1)) != null) {
            str2 = Fn.dlI();
        }
        ArrayList arrayList = new ArrayList();
        int count = v.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dlI) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
