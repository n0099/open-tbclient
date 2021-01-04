package com.baidu.tieba.yuyinala.adapter;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> gtq;
    private AlaRankListActivity ojJ;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.ojJ = alaRankListActivity;
        VG(str);
    }

    private void VG(String str) {
        this.gtq = new ArrayList<>();
        this.gtq.add(new com.baidu.tieba.yuyinala.b.a(this.ojJ, str));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.gtq != null) {
            return this.gtq.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.gtq;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
