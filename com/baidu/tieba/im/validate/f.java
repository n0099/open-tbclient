package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class f extends BaseAdapter {
    ValidateActivity a;
    com.baidu.tieba.util.i b;
    List<ValidateItemData> c = new ArrayList();

    public f(ValidateActivity validateActivity) {
        this.b = null;
        this.a = validateActivity;
        this.b = new com.baidu.tieba.util.i(this.a);
    }

    public final void a() {
        this.a = null;
    }

    public final void a(List<ValidateItemData> list) {
        if (list != null) {
            this.c.addAll(list);
            com.baidu.adp.lib.util.e.e("size:" + this.c.size());
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        g gVar = null;
        if (view != null) {
            gVar = (g) view.getTag();
        }
        g gVar2 = gVar == null ? new g(this.a) : gVar;
        gVar2.a(this.c.get(i));
        gVar2.d();
        return gVar2.a();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public final List<ValidateItemData> b() {
        return this.c;
    }
}
