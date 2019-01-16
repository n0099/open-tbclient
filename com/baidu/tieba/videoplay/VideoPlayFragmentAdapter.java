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
    public String bVu;
    public String ecD;
    private QuickVideoView.c gGB;
    private j.b gGl;
    private boolean hPV;
    private a hPW;
    private long hPX;
    private SparseArray<VideoPlayFragment> hPY;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hPX = -1L;
        this.hPY = new SparseArray<>();
        this.hPW = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.gGl);
        videoPlayFragment.setVideoStatusListener(this.gGB);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) v.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.bVu);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.ecD);
        if (this.hPV) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hPV = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.gGB = cVar;
    }

    public void a(j.b bVar) {
        this.gGl = bVar;
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
        this.hPY.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hPY.put(i, videoPlayFragment);
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

    public VideoPlayFragment wZ(int i) {
        return this.hPY.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hPV = true;
        this.mRect = rect;
    }

    public void bNc() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hPX > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hPX);
        }
    }

    public void xa(int i) {
        List<String> list;
        String str;
        VideoPlayFragment wZ;
        VideoPlayFragment wZ2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hPY.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (v.H(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bNa();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bNa = (i + (-1) < 0 || (wZ2 = wZ(i + (-1))) == null) ? null : wZ2.bNa();
        if (i + 1 < getCount() && (wZ = wZ(i + 1)) != null) {
            str2 = wZ.bNa();
        }
        ArrayList arrayList = new ArrayList();
        int H = v.H(list);
        for (int i2 = 0; i2 < H; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bNa) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!v.I(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
