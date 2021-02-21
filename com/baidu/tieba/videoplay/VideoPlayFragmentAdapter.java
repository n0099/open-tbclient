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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private List<VideoItemData> mDatas;
    public String mFrom;
    public String mFromPage;
    private f.b mHw;
    private Rect mRect;
    private VideoPlayFragment.a nVD;
    private boolean nVO;
    private a nVP;
    private long nVQ;
    public String nVR;
    private SparseArray<VideoPlayFragment> nVS;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.nVQ = -1L;
        this.nVS = new SparseArray<>();
        this.nVP = new a();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.mHw);
        videoPlayFragment.a(this.nVD);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) y.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable("page_from", this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.nVR);
        if (this.nVO) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.nVO = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.nVD = aVar;
    }

    public void a(f.b bVar) {
        this.mHw = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (y.isEmpty(this.mDatas)) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.nVS.remove(i);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.nVS.put(i, videoPlayFragment);
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

    public VideoPlayFragment KU(int i) {
        return this.nVS.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.nVO = true;
        this.mRect = rect;
    }

    public void dVF() {
        int i = b.brQ().getInt("nani_key_download_show_rate", 2);
        if (this.nVQ > 0 && i != 1) {
            b.brQ().putLong("key_vertical_shown_time", this.nVQ);
        }
    }

    public void KV(int i) {
        List<String> list;
        String str;
        VideoPlayFragment KU;
        VideoPlayFragment KU2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.nVS.get(i);
        if (videoPlayFragment != null) {
            List<String> dVA = videoPlayFragment.dVA();
            if (y.getCount(dVA) >= 5) {
                list = dVA;
                str = videoPlayFragment.dVB();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dVB = (i + (-1) < 0 || (KU2 = KU(i + (-1))) == null) ? null : KU2.dVB();
        if (i + 1 < getCount() && (KU = KU(i + 1)) != null) {
            str2 = KU.dVB();
        }
        ArrayList arrayList = new ArrayList();
        int count = y.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dVB) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!y.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
