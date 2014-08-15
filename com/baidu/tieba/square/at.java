package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class at extends BaseAdapter implements com.baidu.tieba.view.s {
    private ArrayList<BaseAdapter> a;
    private p b;
    private ab c;
    private x d;
    private g e;

    public at(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = new ArrayList<>();
        this.b = new p(context);
        this.c = new ab(context);
        this.d = new x(context);
        this.e = new g(context);
        this.a.add(this.b);
        this.a.add(this.c);
        this.a.add(this.d);
        this.a.add(this.e);
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.b != null) {
                this.b.a(amVar.b());
            }
            if (this.c != null) {
                this.c.a(amVar.c());
            }
            if (this.d != null) {
                this.d.a(amVar.d());
            }
            if (this.e != null) {
                this.e.a(amVar.e());
            }
        }
    }

    public void a(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
        notifyDataSetChanged();
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
        }
    }

    public void c() {
        if (this.b != null) {
            this.b.c();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        Iterator<BaseAdapter> it = this.a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getCount() + i2;
            } else {
                return i2;
            }
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.a.size()) {
                BaseAdapter baseAdapter = this.a.get(i3);
                if (i < baseAdapter.getCount()) {
                    return baseAdapter.getItem(i);
                }
                i -= baseAdapter.getCount();
                i2 = i3 + 1;
            } else {
                return null;
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        int i;
        int i2 = 0;
        Iterator<BaseAdapter> it = this.a.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = it.next().getViewTypeCount() + i;
        }
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            BaseAdapter baseAdapter = this.a.get(i3);
            if (i < baseAdapter.getCount()) {
                return baseAdapter.getItemViewType(i) + i2;
            }
            i2 += baseAdapter.getViewTypeCount();
            i -= baseAdapter.getCount();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.a.size()) {
                BaseAdapter baseAdapter = this.a.get(i3);
                if (i < baseAdapter.getCount()) {
                    return baseAdapter.getView(i, view, viewGroup);
                }
                i -= baseAdapter.getCount();
                i2 = i3 + 1;
            } else {
                return null;
            }
        }
    }

    @Override // com.baidu.tieba.view.s
    public void b() {
        Iterator<BaseAdapter> it = this.a.iterator();
        while (it.hasNext()) {
            BaseAdapter next = it.next();
            if (next instanceof com.baidu.tieba.view.s) {
                ((com.baidu.tieba.view.s) next).b();
            }
        }
    }

    @Override // com.baidu.tieba.view.s
    public void a(View view, int i, int i2) {
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            BaseAdapter baseAdapter = this.a.get(i3);
            if (baseAdapter instanceof com.baidu.tieba.view.s) {
                ((com.baidu.tieba.view.s) baseAdapter).a(view, i < 0 ? 0 : i, i2 > baseAdapter.getCount() + (-1) ? baseAdapter.getCount() - 1 : i2);
            }
            i -= baseAdapter.getCount();
            i2 -= baseAdapter.getCount();
            if (i2 < 0) {
                return;
            }
        }
    }
}
