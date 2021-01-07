package com.baidu.tieba.yuyinala.adapter;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> gtq;
    private AlaRankListActivity ojI;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.ojI = alaRankListActivity;
        VF(str);
    }

    private void VF(String str) {
        this.gtq = new ArrayList<>();
        this.gtq.add(new com.baidu.tieba.yuyinala.b.a(this.ojI, str));
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
