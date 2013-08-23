package com.baidu.tieba.square;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.data.bc;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class aa extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.g f1736a;
    private ArrayList b;
    private t c;
    private h d;

    public aa(com.baidu.tieba.g gVar) {
        this.f1736a = null;
        this.b = null;
        this.c = null;
        this.f1736a = gVar;
        this.b = new ArrayList();
        this.c = new t(this.f1736a);
        this.d = new h(this.f1736a);
        a(this.c);
        a(this.d);
    }

    public void a(BaseAdapter baseAdapter) {
        this.b.add(baseAdapter);
    }

    public void a(bc bcVar) {
        if (this.c != null) {
            this.c.a(bcVar.b());
        }
        if (this.d != null) {
            this.d.a(bcVar.a());
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        Iterator it = this.b.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = ((BaseAdapter) it.next()).getCount() + i2;
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
            if (i3 < this.b.size()) {
                BaseAdapter baseAdapter = (BaseAdapter) this.b.get(i3);
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
        Iterator it = this.b.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = ((BaseAdapter) it.next()).getViewTypeCount() + i;
        }
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            BaseAdapter baseAdapter = (BaseAdapter) this.b.get(i3);
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
            if (i3 < this.b.size()) {
                BaseAdapter baseAdapter = (BaseAdapter) this.b.get(i3);
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

    public void a(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
        notifyDataSetChanged();
    }
}
