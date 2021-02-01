package com.baidu.tieba.yuyinala.adapter;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> grs;
    private AlaRankListActivity ooW;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.ooW = alaRankListActivity;
        Vw(str);
    }

    private void Vw(String str) {
        this.grs = new ArrayList<>();
        this.grs.add(new com.baidu.tieba.yuyinala.b.a(this.ooW, str));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.grs != null) {
            return this.grs.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.grs;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
