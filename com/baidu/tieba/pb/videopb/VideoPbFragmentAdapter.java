package com.baidu.tieba.pb.videopb;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f20063a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BaseFragment> f20064b;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.f20063a == null) {
            this.f20063a = new ArrayList();
        }
        this.f20063a.clear();
        if (videoPbFragment.w3()) {
            this.f20063a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
            this.f20063a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        } else {
            this.f20063a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        }
        if (this.f20064b == null) {
            this.f20064b = new ArrayList<>();
        }
        this.f20064b.clear();
        if (videoPbFragment.w3()) {
            this.f20064b.add(DetailInfoFragment.Q0(videoPbFragment));
            this.f20064b.add(ReplyFragment.f1(videoPbFragment));
            return;
        }
        this.f20064b.add(DetailInfoAndReplyFragment.g1(videoPbFragment));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<BaseFragment> arrayList = this.f20064b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return i(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        List<String> list = this.f20063a;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f20063a.get(i);
    }

    public BaseFragment i(int i) {
        ArrayList<BaseFragment> arrayList = this.f20064b;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return this.f20064b.get(i);
    }

    public ArrayList<BaseFragment> j() {
        return this.f20064b;
    }

    public void k(int i) {
        if (this.f20064b == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.f20064b.size()) {
            if (this.f20064b.get(i2) != null) {
                this.f20064b.get(i2).setPrimary(i2 == i);
            }
            i2++;
        }
    }
}
