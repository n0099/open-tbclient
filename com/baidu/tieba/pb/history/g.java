package com.baidu.tieba.pb.history;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private final List<ak> a = new ArrayList();

    public void a(List<ak> list) {
        this.a.clear();
        if (list != null) {
            this.a.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ak getItem(int i) {
        if (i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar;
        if (view == null) {
            view = com.baidu.adp.lib.e.b.a().a(TbadkApplication.m252getInst(), v.pb_history_list_item, null);
            hVar = new h(view);
            view.setTag(hVar);
        } else {
            hVar = (h) view.getTag();
        }
        hVar.a(getItem(i));
        return view;
    }
}
