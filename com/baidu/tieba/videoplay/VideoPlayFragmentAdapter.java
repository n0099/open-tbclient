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
/* loaded from: classes8.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {
    private f.b mCH;
    private List<VideoItemData> mDatas;
    public String mFrom;
    public String mFromPage;
    private Rect mRect;
    private VideoPlayFragment.a nPY;
    private boolean nQf;
    private a nQg;
    private long nQh;
    public String nQi;
    private SparseArray<VideoPlayFragment> nQj;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.nQh = -1L;
        this.nQj = new SparseArray<>();
        this.nQg = new a();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.a(this.mCH);
        videoPlayFragment.a(this.nPY);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) x.getItem(this.mDatas, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable("page_from", this.mFrom);
        bundle.putSerializable("from", this.mFromPage);
        bundle.putSerializable("obj_id", this.nQi);
        if (this.nQf) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.mRect);
            this.nQf = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public void a(VideoPlayFragment.a aVar) {
        this.nPY = aVar;
    }

    public void a(f.b bVar) {
        this.mCH = bVar;
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
        this.nQj.remove(i);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.nQj.put(i, videoPlayFragment);
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

    public VideoPlayFragment Mg(int i) {
        return this.nQj.get(i);
    }

    public void a(List<VideoItemData> list, Rect rect) {
        this.mDatas = list;
        this.nQf = true;
        this.mRect = rect;
    }

    public void dXe() {
        int i = b.bvr().getInt("nani_key_download_show_rate", 2);
        if (this.nQh > 0 && i != 1) {
            b.bvr().putLong("key_vertical_shown_time", this.nQh);
        }
    }

    public void Mh(int i) {
        List<String> list;
        String str;
        VideoPlayFragment Mg;
        VideoPlayFragment Mg2;
        String str2 = null;
        VideoPlayFragment videoPlayFragment = this.nQj.get(i);
        if (videoPlayFragment != null) {
            List<String> dWZ = videoPlayFragment.dWZ();
            if (x.getCount(dWZ) >= 5) {
                list = dWZ;
                str = videoPlayFragment.dXa();
            } else {
                return;
            }
        } else {
            list = null;
            str = null;
        }
        String dXa = (i + (-1) < 0 || (Mg2 = Mg(i + (-1))) == null) ? null : Mg2.dXa();
        if (i + 1 < getCount() && (Mg = Mg(i + 1)) != null) {
            str2 = Mg.dXa();
        }
        ArrayList arrayList = new ArrayList();
        int count = x.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            String str3 = list.get(i2);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, dXa) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (!x.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER, arrayList));
        }
    }
}
