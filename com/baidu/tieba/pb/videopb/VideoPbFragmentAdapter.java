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
    private List<String> mla;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.mla == null) {
            this.mla = new ArrayList();
        }
        this.mla.clear();
        if (com.baidu.tbadk.a.d.bja()) {
            this.mla.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        } else {
            this.mla.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
            this.mla.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        }
        if (this.mFragments == null) {
            this.mFragments = new ArrayList<>();
        }
        this.mFragments.clear();
        if (com.baidu.tbadk.a.d.bja()) {
            this.mFragments.add(DetailInfoAndReplyFragment.ac(videoPbFragment));
            return;
        }
        this.mFragments.add(DetailInfoFragment.ad(videoPbFragment));
        this.mFragments.add(ReplyFragment.ae(videoPbFragment));
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return Gw(i);
    }

    public BaseFragment Gw(int i) {
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
        if (this.mla == null || i < 0 || i >= this.mla.size()) {
            return null;
        }
        return this.mla.get(i);
    }

    public ArrayList<BaseFragment> dux() {
        return this.mFragments;
    }

    public void Gx(int i) {
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
