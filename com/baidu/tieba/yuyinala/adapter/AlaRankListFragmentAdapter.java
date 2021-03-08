package com.baidu.tieba.yuyinala.adapter;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> gtp;
    private AlaRankListActivity orD;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.orD = alaRankListActivity;
        VP(str);
    }

    private void VP(String str) {
        this.gtp = new ArrayList<>();
        this.gtp.add(new com.baidu.tieba.yuyinala.b.a(this.orD, str));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.gtp != null) {
            return this.gtp.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.gtp;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
