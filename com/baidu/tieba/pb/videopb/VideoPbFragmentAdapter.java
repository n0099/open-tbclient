package com.baidu.tieba.pb.videopb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {
    private List<String> kxG;
    private ArrayList<BaseFragment> mFragments;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.kxG == null) {
            this.kxG = new ArrayList();
        }
        this.kxG.clear();
        this.kxG.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
        this.kxG.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        if (this.mFragments == null) {
            this.mFragments = new ArrayList<>();
        }
        this.mFragments.clear();
        this.mFragments.add(DetailInfoFragment.ab(videoPbFragment));
        this.mFragments.add(ReplyFragment.ac(videoPbFragment));
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return BU(i);
    }

    public BaseFragment BU(int i) {
        if (this.mFragments == null || i >= this.mFragments.size()) {
            return null;
        }
        return this.mFragments.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mFragments == null) {
            return 0;
        }
        return this.mFragments.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.kxG == null || i < 0 || i >= this.kxG.size()) {
            return null;
        }
        return this.kxG.get(i);
    }

    public ArrayList<BaseFragment> cPI() {
        return this.mFragments;
    }

    public void BV(int i) {
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
