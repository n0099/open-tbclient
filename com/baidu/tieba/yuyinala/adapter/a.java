package com.baidu.tieba.yuyinala.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.data.c;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<c> gtn;
    private String mRoomId;
    private AlaRankListActivity orD;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.orD = alaRankListActivity;
        this.mRoomId = str;
    }

    public void setData(ArrayList<c> arrayList) {
        if (this.gtn == null) {
            this.gtn = new ArrayList<>();
        } else {
            this.gtn.clear();
        }
        if (arrayList != null) {
            this.gtn.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gtn == null) {
            return 0;
        }
        return this.gtn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gtn == null) {
            return null;
        }
        return this.gtn.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.gtn == null || this.gtn.size() == 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.yuyinala.view.c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.orD).inflate(a.g.yuyin_ala_rank_list_item_view, (ViewGroup) null);
            com.baidu.tieba.yuyinala.view.c cVar2 = new com.baidu.tieba.yuyinala.view.c(this.orD, view);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (com.baidu.tieba.yuyinala.view.c) view.getTag();
        }
        cVar.a(this.gtn.get(i), i);
        return view;
    }
}
