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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private f.b lbP;
    private List<VideoItemData> mDatas;
    public String mFrom;
    public String mFromPage;
    private Rect mRect;
    private VideoPlayFragment.a mnB;
    private boolean mnI;
    private a mnJ;
    private long mnK;
    public String mnL;
    private SparseArray<VideoPlayFragment> mnM;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mnK = -1L;
        this.mnM = new SparseArray<>();
        this.mnJ = new a();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.lbP);
        videoPlayFragment.a(this.mnB);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) x.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable(VideoPlayActivityConfig.PAGE_FROM, this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.mnL);
        if (this.mnI) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.mnI = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.mnB = aVar;
    }

    public void a(f.b bVar) {
        this.lbP = bVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (x.isEmpty(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.mnM.remove(i);
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.mnM.put(i, videoPlayFragment);
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

    public VideoPlayFragment GN(int i) {
        return this.mnM.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.mnI = true;
        this.mRect = rect;
    }

    public void dtm() {
        int i = b.aZP().getInt("nani_key_download_show_rate", 2);
        if (this.mnK > 0 && i != 1) {
            b.aZP().putLong("key_vertical_shown_time", this.mnK);
        }
    }

    public void GO(int i) {
        List<String> list;
        String str;
        VideoPlayFragment GN;
        VideoPlayFragment GN2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.mnM.get(i);
        if (videoPlayFragment != null) {
            List<String> dth = videoPlayFragment.dth();
            if (x.getCount(dth) >= 5) {
                list = dth;
                str = videoPlayFragment.dti();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dti = (i + (-1) < 0 || (GN2 = GN(i + (-1))) == null) ? null : GN2.dti();
        if (i + 1 < getCount() && (GN = GN(i + 1)) != null) {
            str2 = GN.dti();
        }
        ArrayList arrayList = new ArrayList();
        int count = x.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dti) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!x.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
