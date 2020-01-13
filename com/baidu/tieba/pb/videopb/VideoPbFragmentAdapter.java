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
/* loaded from: classes7.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {
    private List<String> iXu;
    private ArrayList<BaseFragment> mFragments;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.iXu == null) {
            this.iXu = new ArrayList();
        }
        this.iXu.clear();
        this.iXu.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
        this.iXu.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        if (this.mFragments == null) {
            this.mFragments = new ArrayList<>();
        }
        this.mFragments.clear();
        this.mFragments.add(DetailInfoFragment.S(videoPbFragment));
        this.mFragments.add(ReplyFragment.T(videoPbFragment));
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return zq(i);
    }

    public BaseFragment zq(int i) {
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
        if (this.iXu == null || i < 0 || i >= this.iXu.size()) {
            return null;
        }
        return this.iXu.get(i);
    }

    public ArrayList<BaseFragment> crG() {
        return this.mFragments;
    }
}
