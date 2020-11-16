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
    private ArrayList<c> gaE;
    private String mRoomId;
    private AlaRankListActivity nTb;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.nTb = alaRankListActivity;
        this.mRoomId = str;
    }

    public void setData(ArrayList<c> arrayList) {
        if (this.gaE == null) {
            this.gaE = new ArrayList<>();
        } else {
            this.gaE.clear();
        }
        if (arrayList != null) {
            this.gaE.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gaE == null) {
            return 0;
        }
        return this.gaE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gaE == null) {
            return null;
        }
        return this.gaE.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.gaE == null || this.gaE.size() == 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.yuyinala.view.c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.nTb).inflate(a.g.yuyin_ala_rank_list_item_view, (ViewGroup) null);
            com.baidu.tieba.yuyinala.view.c cVar2 = new com.baidu.tieba.yuyinala.view.c(this.nTb, view);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (com.baidu.tieba.yuyinala.view.c) view.getTag();
        }
        cVar.a(this.gaE.get(i), i);
        return view;
    }
}
