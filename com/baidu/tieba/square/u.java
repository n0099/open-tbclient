package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class u extends BaseAdapter implements com.baidu.tieba.view.q {
    private y a = null;
    private ArrayList<at> b = new ArrayList<>();
    private v c;

    public u(Context context) {
        this.c = null;
        this.c = new v(context);
    }

    public final void a(ArrayList<at> arrayList) {
        this.b = arrayList;
        this.c.a(arrayList);
        this.a = this.c.getPagerAdapter();
        notifyDataSetChanged();
    }

    public final void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public final void c() {
        if (this.c != null) {
            this.c.b();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return (this.b != null ? this.b.size() + 0 : 0) > 0 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.c;
    }

    @Override // com.baidu.tieba.view.q
    public final void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.baidu.tieba.view.q
    public final void a(View view, int i, int i2) {
        if (this.a != null) {
            this.a.a(this.c, 0, 0);
        }
    }

    public final void a(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }
}
