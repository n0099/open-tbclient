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
/* loaded from: classes2.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> mFragments;
    private List<String> mbI;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.mbI == null) {
            this.mbI = new ArrayList();
        }
        this.mbI.clear();
        if (com.baidu.tbadk.a.d.biO()) {
            this.mbI.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        } else {
            this.mbI.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
            this.mbI.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        }
        if (this.mFragments == null) {
            this.mFragments = new ArrayList<>();
        }
        this.mFragments.clear();
        if (com.baidu.tbadk.a.d.biO()) {
            this.mFragments.add(DetailInfoAndReplyFragment.ac(videoPbFragment));
            return;
        }
        this.mFragments.add(DetailInfoFragment.ad(videoPbFragment));
        this.mFragments.add(ReplyFragment.ae(videoPbFragment));
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return Gd(i);
    }

    public BaseFragment Gd(int i) {
        if (this.mFragments == null || i >= this.mFragments.size()) {
            return null;
        }
        return this.mFragments.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.mFragments == null) {
            return 0;
        }
        return this.mFragments.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.mbI == null || i < 0 || i >= this.mbI.size()) {
            return null;
        }
        return this.mbI.get(i);
    }

    public ArrayList<BaseFragment> dse() {
        return this.mFragments;
    }

    public void Ge(int i) {
        if (this.mFragments != null) {
            int i2 = 0;
            while (i2 < this.mFragments.size()) {
                if (this.mFragments.get(i2) != null) {
                    this.mFragments.get(i2).setPrimary(i2 == i);
                }
                i2++;
            }
        }
    }
}
