package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class ax extends BaseAdapter implements com.baidu.tieba.view.q {
    private ArrayList<BaseAdapter> a;
    private com.baidu.tbadk.editortool.ab b;
    private u c;
    private ag d;
    private ac e;
    private i f;

    public ax(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = new ArrayList<>();
        this.b = new com.baidu.tbadk.editortool.ab(context);
        this.c = new u(context);
        this.d = new ag(context);
        this.e = new ac(context);
        this.f = new i(context);
        this.a.add(this.c);
        this.a.add(this.d);
        this.a.add(this.e);
        this.a.add(this.f);
    }

    public final void a(aq aqVar) {
        if (aqVar != null) {
            if (this.c != null) {
                this.c.a(aqVar.b());
            }
            if (this.d != null) {
                this.d.a(aqVar.c());
            }
            if (this.e != null) {
                this.e.a(aqVar.d());
            }
            if (this.f != null) {
                this.f.a(aqVar.e());
            }
        }
    }

    public final void a(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
        notifyDataSetChanged();
    }

    public final void a() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public final void c() {
        if (this.c != null) {
            this.c.c();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
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
    public final Object getItem(int i) {
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
    public final int getViewTypeCount() {
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
    public final int getItemViewType(int i) {
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
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
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

    @Override // com.baidu.tieba.view.q
    public final void b() {
        Iterator<BaseAdapter> it = this.a.iterator();
        while (it.hasNext()) {
            BaseAdapter next = it.next();
            if (next instanceof com.baidu.tieba.view.q) {
                ((com.baidu.tieba.view.q) next).b();
            }
        }
    }

    @Override // com.baidu.tieba.view.q
    public final void a(View view, int i, int i2) {
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            BaseAdapter baseAdapter = this.a.get(i3);
            if (baseAdapter instanceof com.baidu.tieba.view.q) {
                ((com.baidu.tieba.view.q) baseAdapter).a(view, i < 0 ? 0 : i, i2 > baseAdapter.getCount() + (-1) ? baseAdapter.getCount() - 1 : i2);
            }
            com.baidu.adp.lib.util.f.a(getClass().getName(), "startLoadImage", "start:" + i + "en:" + i2);
            i -= baseAdapter.getCount();
            i2 -= baseAdapter.getCount();
            if (i2 < 0) {
                return;
            }
        }
    }
}
