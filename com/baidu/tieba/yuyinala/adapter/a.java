package com.baidu.tieba.yuyinala.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.data.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<c> giP;
    private String mRoomId;
    private AlaRankListActivity ohZ;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ohZ = alaRankListActivity;
        this.mRoomId = str;
    }

    public void setData(ArrayList<c> arrayList) {
        if (this.giP == null) {
            this.giP = new ArrayList<>();
        } else {
            this.giP.clear();
        }
        if (arrayList != null) {
            this.giP.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.giP == null) {
            return 0;
        }
        return this.giP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.giP == null) {
            return null;
        }
        return this.giP.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.giP == null || this.giP.size() == 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.yuyinala.view.c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.ohZ).inflate(a.g.yuyin_ala_rank_list_item_view, (ViewGroup) null);
            com.baidu.tieba.yuyinala.view.c cVar2 = new com.baidu.tieba.yuyinala.view.c(this.ohZ, view);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (com.baidu.tieba.yuyinala.view.c) view.getTag();
        }
        cVar.a(this.giP.get(i), i);
        return view;
    }
}
