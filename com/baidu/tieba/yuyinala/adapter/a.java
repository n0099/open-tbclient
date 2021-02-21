package com.baidu.tieba.yuyinala.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.data.c;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<c> grE;
    private String mRoomId;
    private AlaRankListActivity opx;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.opx = alaRankListActivity;
        this.mRoomId = str;
    }

    public void setData(ArrayList<c> arrayList) {
        if (this.grE == null) {
            this.grE = new ArrayList<>();
        } else {
            this.grE.clear();
        }
        if (arrayList != null) {
            this.grE.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.grE == null) {
            return 0;
        }
        return this.grE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.grE == null) {
            return null;
        }
        return this.grE.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.grE == null || this.grE.size() == 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.yuyinala.view.c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.opx).inflate(a.g.yuyin_ala_rank_list_item_view, (ViewGroup) null);
            com.baidu.tieba.yuyinala.view.c cVar2 = new com.baidu.tieba.yuyinala.view.c(this.opx, view);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (com.baidu.tieba.yuyinala.view.c) view.getTag();
        }
        cVar.a(this.grE.get(i), i);
        return view;
    }
}
