package com.baidu.tieba.yuyinala.adapter;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> goJ;
    private AlaRankListActivity ofc;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.ofc = alaRankListActivity;
        Ux(str);
    }

    private void Ux(String str) {
        this.goJ = new ArrayList<>();
        this.goJ.add(new com.baidu.tieba.yuyinala.b.a(this.ofc, str));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.goJ != null) {
            return this.goJ.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.goJ;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
