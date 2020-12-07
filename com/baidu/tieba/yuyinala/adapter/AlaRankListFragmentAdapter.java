package com.baidu.tieba.yuyinala.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> giR;
    private AlaRankListActivity ohZ;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.ohZ = alaRankListActivity;
        Wg(str);
    }

    private void Wg(String str) {
        this.giR = new ArrayList<>();
        this.giR.add(new com.baidu.tieba.yuyinala.b.a(this.ohZ, str));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.giR != null) {
            return this.giR.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.giR;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
