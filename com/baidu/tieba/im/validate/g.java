package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    ValidateActivity a;
    List<ValidateItemData> b = new ArrayList();

    public g(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    public void a() {
        this.a = null;
    }

    public void a(List<ValidateItemData> list) {
        if (list != null) {
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar = null;
        if (view != null) {
            hVar = (h) view.getTag();
        }
        h hVar2 = hVar == null ? new h(this.a) : hVar;
        hVar2.a(this.b.get(i));
        return hVar2.a();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> b() {
        return this.b;
    }
}
