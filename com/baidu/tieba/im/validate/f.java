package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    ValidateActivity f1899a;
    com.baidu.tieba.util.i b;
    List<ValidateItemData> c = new ArrayList();

    public f(ValidateActivity validateActivity) {
        this.b = null;
        this.f1899a = validateActivity;
        this.b = new com.baidu.tieba.util.i(this.f1899a);
    }

    public void a() {
        this.f1899a = null;
    }

    public void a(List<ValidateItemData> list) {
        if (list != null) {
            this.c.addAll(list);
            com.baidu.adp.lib.h.e.d("size:" + this.c.size());
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar = null;
        if (view != null) {
            gVar = (g) view.getTag();
        }
        g gVar2 = gVar == null ? new g(this.f1899a) : gVar;
        gVar2.a(this.c.get(i));
        return gVar2.a();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> b() {
        return this.c;
    }
}
