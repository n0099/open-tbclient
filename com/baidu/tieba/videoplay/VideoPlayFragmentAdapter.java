package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private List<VideoItemData> mDatas;
    public String mFrom;
    public String mFromPage;
    private Rect mRect;
    private f.b myb;
    private boolean nLB;
    private a nLC;
    private long nLD;
    public String nLE;
    private SparseArray<VideoPlayFragment> nLF;
    private VideoPlayFragment.a nLu;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.nLD = -1L;
        this.nLF = new SparseArray<>();
        this.nLC = new a();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.myb);
        videoPlayFragment.a(this.nLu);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) x.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable("page_from", this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.nLE);
        if (this.nLB) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.nLB = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.nLu = aVar;
    }

    public void a(f.b bVar) {
        this.myb = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (x.isEmpty(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.nLF.remove(i);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.nLF.put(i, videoPlayFragment);
        return videoPlayFragment;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle = (Bundle) super.saveState();
        if (bundle != null) {
            bundle.putParcelableArray("states", null);
        }
        return bundle;
    }

    public VideoPlayFragment Kz(int i) {
        return this.nLF.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.nLB = true;
        this.mRect = rect;
    }

    public void dTm() {
        int i = b.brx().getInt("nani_key_download_show_rate", 2);
        if (this.nLD > 0 && i != 1) {
            b.brx().putLong("key_vertical_shown_time", this.nLD);
        }
    }

    public void KA(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Kz;
        VideoPlayFragment Kz2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.nLF.get(i);
        if (videoPlayFragment != null) {
            List<String> dTh = videoPlayFragment.dTh();
            if (x.getCount(dTh) >= 5) {
                list = dTh;
                str = videoPlayFragment.dTi();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dTi = (i + (-1) < 0 || (Kz2 = Kz(i + (-1))) == null) ? null : Kz2.dTi();
        if (i + 1 < getCount() && (Kz = Kz(i + 1)) != null) {
            str2 = Kz.dTi();
        }
        ArrayList arrayList = new ArrayList();
        int count = x.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dTi) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!x.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
