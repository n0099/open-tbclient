package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.os.Bundle;
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
    public boolean hhZ;
    private boolean hii;
    private a hij;
    private long hik;
    public String hil;
    private SparseArray<VideoPlayFragment> him;
    private List<VideoItemData> mDatas;
    public String mFrom;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hik = -1L;
        this.him = new SparseArray<>();
        this.hij = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) w.c(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FIRST_IN, Boolean.valueOf(this.hhZ));
        bundle.putSerializable(VideoPlayActivityConfig.OBJ_ID, this.hil);
        if (this.hii) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.hii = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
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
        this.him.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.him.put(i, videoPlayFragment);
        return videoPlayFragment;
    }

    public VideoPlayFragment uP(int i) {
        return this.him.get(i);
    }

    public SparseArray<VideoPlayFragment> bEP() {
        return this.him;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.hij.gh(true)) {
            if (this.hij.azP() < 0) {
                this.hij.uR(i);
            } else if (this.hij.azP() == i) {
                y((VideoPlayFragment) obj);
            }
        }
    }

    private void y(VideoPlayFragment videoPlayFragment) {
        if (videoPlayFragment != null) {
            this.hik = videoPlayFragment.bEL();
        }
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.hii = true;
        this.mRect = rect;
    }

    public void bEQ() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.hik > 0 && i != 1) {
            b.getInstance().putLong("key_vertical_shown_time", this.hik);
        }
    }

    public void uQ(int i) {
        List<String> list;
        String str;
        VideoPlayFragment uP;
        VideoPlayFragment uP2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.him.get(i);
        if (videoPlayFragment != null) {
            List<String> mediaIDs = videoPlayFragment.getMediaIDs();
            if (w.y(mediaIDs) >= 5) {
                list = mediaIDs;
                str = videoPlayFragment.bEN();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String bEN = (i + (-1) < 0 || (uP2 = uP(i + (-1))) == null) ? null : uP2.bEN();
        if (i + 1 < getCount() && (uP = uP(i + 1)) != null) {
            str2 = uP.bEN();
        }
        ArrayList arrayList = new ArrayList();
        int y = w.y(list);
        for (int i2 = 0; i2 < y; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, bEN) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!w.z(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
    }
}
