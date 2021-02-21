package com.baidu.tieba.yuyinala.adapter;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> grG;
    private AlaRankListActivity opx;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.opx = alaRankListActivity;
        VI(str);
    }

    private void VI(String str) {
        this.grG = new ArrayList<>();
        this.grG.add(new com.baidu.tieba.yuyinala.b.a(this.opx, str));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.grG != null) {
            return this.grG.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.grG;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
