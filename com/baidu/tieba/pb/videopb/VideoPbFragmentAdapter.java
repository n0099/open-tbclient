package com.baidu.tieba.pb.videopb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class VideoPbFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> mFragments;
    private List<String> mba;

    public VideoPbFragmentAdapter(FragmentManager fragmentManager, VideoPbFragment videoPbFragment) {
        super(fragmentManager);
        if (this.mba == null) {
            this.mba = new ArrayList();
        }
        this.mba.clear();
        if (com.baidu.tbadk.a.d.bkt()) {
            this.mba.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        } else {
            this.mba.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_info));
            this.mba.add(TbadkCoreApplication.getInst().getString(R.string.pb_video_reply));
        }
        if (this.mFragments == null) {
            this.mFragments = new ArrayList<>();
        }
        this.mFragments.clear();
        if (com.baidu.tbadk.a.d.bkt()) {
            this.mFragments.add(DetailInfoAndReplyFragment.ac(videoPbFragment));
            return;
        }
        this.mFragments.add(DetailInfoFragment.ad(videoPbFragment));
        this.mFragments.add(ReplyFragment.ae(videoPbFragment));
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return HQ(i);
    }

    public BaseFragment HQ(int i) {
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
        if (this.mba == null || i < 0 || i >= this.mba.size()) {
            return null;
        }
        return this.mba.get(i);
    }

    public ArrayList<BaseFragment> dwf() {
        return this.mFragments;
    }

    public void HR(int i) {
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
