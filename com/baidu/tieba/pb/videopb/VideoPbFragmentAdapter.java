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
/* loaded from: classes3.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f20243a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BaseFragment> f20244b;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.f20243a == null) {
            this.f20243a = new ArrayList();
        }
        this.f20243a.clear();
        if (videoPbFragment.B3()) {
            this.f20243a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
            this.f20243a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        } else {
            this.f20243a.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        }
        if (this.f20244b == null) {
            this.f20244b = new ArrayList<>();
        }
        this.f20244b.clear();
        if (videoPbFragment.B3()) {
            this.f20244b.add(DetailInfoFragment.Q0(videoPbFragment));
            this.f20244b.add(ReplyFragment.f1(videoPbFragment));
            return;
        }
        this.f20244b.add(DetailInfoAndReplyFragment.i1(videoPbFragment));
    }

    public BaseFragment b(int i2) {
        ArrayList<BaseFragment> arrayList = this.f20244b;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f20244b.get(i2);
    }

    public ArrayList<BaseFragment> c() {
        return this.f20244b;
    }

    public void d(int i2) {
        if (this.f20244b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f20244b.size()) {
            if (this.f20244b.get(i3) != null) {
                this.f20244b.get(i3).setPrimary(i3 == i2);
            }
            i3++;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<BaseFragment> arrayList = this.f20244b;
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
        List<String> list = this.f20243a;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.f20243a.get(i2);
    }
}
