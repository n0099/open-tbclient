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
/* loaded from: classes6.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public String hcu;
    private j.b iwM;
    private QuickVideoView.c ixd;
    private boolean jIL;
    private a jIM;
    private long jIN;
    public String jIO;
    private SparseArray<VideoPlayFragment> jIP;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.jIN = -1L;
        this.jIP = new SparseArray<>();
        this.jIM = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.iwM);
        videoPlayFragment.setVideoStatusListener(this.ixd);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.hcu);
        bundle.putSerializable("obj_id", this.jIO);
        if (this.jIL) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.jIL = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.ixd = cVar;
    }

    public void a(j.b bVar) {
        this.iwM = bVar;
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
        this.jIP.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.jIP.put(i, videoPlayFragment);
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

    public VideoPlayFragment Bi(int i) {
        return this.jIP.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.jIL = true;
        this.mRect = rect;
    }

    public void cww() {
        int i = b.alR().getInt("nani_key_download_show_rate", 2);
        if (this.jIN > 0 && i != 1) {
            b.alR().putLong("key_vertical_shown_time", this.jIN);
        }
    }

    public void Bj(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Bi;
        VideoPlayFragment Bi2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.jIP.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.getCount(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.cwu();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String cwu = (i + (-1) < 0 || (Bi2 = Bi(i + (-1))) == null) ? null : Bi2.cwu();
        if (i + 1 < getCount() && (Bi = Bi(i + 1)) != null) {
            str2 = Bi.cwu();
        }
        ArrayList arrayList = new ArrayList();
        int count = v.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, cwu) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
