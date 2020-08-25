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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private f.b lsf;
    private List<VideoItemData> mDatas;
    private SparseArray<VideoPlayFragment> mFA;
    private VideoPlayFragment.a mFp;
    public String mFrom;
    public String mFromPage;
    private boolean mFw;
    private a mFx;
    private long mFy;
    public String mFz;
    private Rect mRect;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mFy = -1L;
        this.mFA = new SparseArray<>();
        this.mFx = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.lsf);
        videoPlayFragment.a(this.mFp);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) y.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable("page_from", this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.mFz);
        if (this.mFw) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.mFw = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.mFp = aVar;
    }

    public void a(f.b bVar) {
        this.lsf = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (y.isEmpty(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.mFA.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.mFA.put(i, videoPlayFragment);
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

    public VideoPlayFragment Jj(int i) {
        return this.mFA.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.mFw = true;
        this.mRect = rect;
    }

    public void dEH() {
        int i = b.bik().getInt("nani_key_download_show_rate", 2);
        if (this.mFy > 0 && i != 1) {
            b.bik().putLong("key_vertical_shown_time", this.mFy);
        }
    }

    public void Jk(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Jj;
        VideoPlayFragment Jj2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.mFA.get(i);
        if (videoPlayFragment != null) {
            List<String> dEC = videoPlayFragment.dEC();
            if (y.getCount(dEC) >= 5) {
                list = dEC;
                str = videoPlayFragment.dED();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dED = (i + (-1) < 0 || (Jj2 = Jj(i + (-1))) == null) ? null : Jj2.dED();
        if (i + 1 < getCount() && (Jj = Jj(i + 1)) != null) {
            str2 = Jj.dED();
        }
        ArrayList arrayList = new ArrayList();
        int count = y.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dED) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!y.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
