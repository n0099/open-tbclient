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
/* loaded from: classes6.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {
    private List<String> iTR;
    private ArrayList<BaseFragment> mFragments;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.iTR == null) {
            this.iTR = new ArrayList();
        }
        this.iTR.clear();
        this.iTR.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
        this.iTR.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        if (this.mFragments == null) {
            this.mFragments = new ArrayList<>();
        }
        this.mFragments.clear();
        this.mFragments.add(DetailInfoFragment.S(videoPbFragment));
        this.mFragments.add(ReplyFragment.T(videoPbFragment));
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return zl(i);
    }

    public BaseFragment zl(int i) {
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
        if (this.iTR == null || i < 0 || i >= this.iTR.size()) {
            return null;
        }
        return this.iTR.get(i);
    }

    public ArrayList<BaseFragment> cqz() {
        return this.mFragments;
    }
}
