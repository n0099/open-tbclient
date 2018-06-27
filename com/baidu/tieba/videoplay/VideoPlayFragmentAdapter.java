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
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    public String bBe;
    public boolean hmf;
    private boolean hmn;
    private a hmo;
    private long hmp;
    public String hmq;
    private SparseArray<VideoPlayFragment> hmr;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hmp = -1L;
        this.hmr = new SparseArray<>();
        this.hmo = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) w.d(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FIRST_IN, Boolean.valueOf(this.hmf));
        bundle.putSerializable("from", this.bBe);
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.hmq);
        if (this.hmn) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hmn = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (w.A(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.hmr.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.hmr.put(i, videoPlayFragment);
        return videoPlayFragment;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle = (Bundle) super.saveState();
        bundle.putParcelableArray("states", null);
        return bundle;
    }

    public VideoPlayFragment uX(int i) {
        return this.hmr.get(i);
    }

    public SparseArray<VideoPlayFragment> bFp() {
        return this.hmr;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hmo.gr(true)) {
            if (this.hmo.aAw() < 0) {
                this.hmo.uZ(i);
            } else if (this.hmo.aAw() == i) {
                z((VideoPlayFragment) obj);
            }
        }
    }

    private void z(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hmp = videoPlayFragment.bFl();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hmn = true;
        this.mRect = rect;
    }

    public void bFq() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hmp > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hmp);
        }
    }

    public void uY(int i) {
        List<String> list;
        String str;
        VideoPlayFragment uX;
        VideoPlayFragment uX2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.hmr.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (w.z(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bFn();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bFn = (i + (-1) < 0 || (uX2 = uX(i + (-1))) == null) ? null : uX2.bFn();
        if (i + 1 < getCount() && (uX = uX(i + 1)) != null) {
            str2 = uX.bFn();
        }
        ArrayList arrayList = new ArrayList();
        int z = w.z(list);
        for (int i2 = 0; i2 < z; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bFn) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!w.A(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
