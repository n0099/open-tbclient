package com.baidu.tieba.yuyinala.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> fVi;
    private AlaRankListActivity nLE;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.nLE = alaRankListActivity;
        UP(str);
    }

    private void UP(String str) {
        this.fVi = new ArrayList<>();
        this.fVi.add(new com.baidu.tieba.yuyinala.b.a(this.nLE, str));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fVi != null) {
            return this.fVi.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.fVi;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
