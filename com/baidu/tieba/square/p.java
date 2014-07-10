package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements com.baidu.tieba.view.u {
    private t a = null;
    private ArrayList<ap> b = new ArrayList<>();
    private q c;

    public p(Context context) {
        this.c = null;
        this.c = new q(context);
    }

    public void a(ArrayList<ap> arrayList) {
        this.b = arrayList;
        this.c.a(arrayList);
        this.a = this.c.getPagerAdapter();
        notifyDataSetChanged();
    }

    public void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.b();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.b != null ? this.b.size() + 0 : 0) > 0 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.c;
    }

    @Override // com.baidu.tieba.view.u
    public void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.baidu.tieba.view.u
    public void a(View view, int i, int i2) {
        if (this.a != null) {
            this.a.a(this.c, 0, 0);
        }
    }

    public void a(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }
}
