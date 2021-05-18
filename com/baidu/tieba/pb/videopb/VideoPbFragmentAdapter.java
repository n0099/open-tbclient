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
    public List<String> f19531a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BaseFragment> f19532b;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.f19531a == null) {
            this.f19531a = new ArrayList();
        }
        this.f19531a.clear();
        if (videoPbFragment.A3()) {
            this.f19531a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
            this.f19531a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        } else {
            this.f19531a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        }
        if (this.f19532b == null) {
            this.f19532b = new ArrayList<>();
        }
        this.f19532b.clear();
        if (videoPbFragment.A3()) {
            this.f19532b.add(DetailInfoFragment.P0(videoPbFragment));
            this.f19532b.add(ReplyFragment.e1(videoPbFragment));
            return;
        }
        this.f19532b.add(DetailInfoAndReplyFragment.h1(videoPbFragment));
    }

    public BaseFragment b(int i2) {
        ArrayList<BaseFragment> arrayList = this.f19532b;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f19532b.get(i2);
    }

    public ArrayList<BaseFragment> c() {
        return this.f19532b;
    }

    public void d(int i2) {
        if (this.f19532b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f19532b.size()) {
            if (this.f19532b.get(i3) != null) {
                this.f19532b.get(i3).setPrimary(i3 == i2);
            }
            i3++;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<BaseFragment> arrayList = this.f19532b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        return b(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        List<String> list = this.f19531a;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.f19531a.get(i2);
    }
}
