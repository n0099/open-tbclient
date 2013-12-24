package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ay extends BaseAdapter implements com.baidu.tieba.view.ai {
    private ArrayList<BaseAdapter> a;
    private Context b;
    private com.baidu.tieba.util.i c;
    private u d;
    private ae e;
    private aa f;
    private ai g;
    private i h;

    public ay(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.b = context;
        this.a = new ArrayList<>();
        this.c = new com.baidu.tieba.util.i(context);
        this.d = new u(context);
        this.e = new ae(context);
        this.f = new aa(context);
        this.g = new ai(context);
        this.h = new i(context);
        this.a.add(this.d);
        this.a.add(this.e);
        this.a.add(this.f);
        this.a.add(this.h);
        this.a.add(this.g);
    }

    public void a(ar arVar) {
        if (arVar != null) {
            if (this.d != null) {
                this.d.a(arVar.b());
            }
            if (this.e != null) {
                this.e.a(arVar.c());
            }
            if (this.f != null) {
                this.f.a(arVar.d());
            }
            if (this.g != null) {
                this.g.a(arVar.e());
            }
            if (this.h != null) {
                this.h.a(arVar.f());
            }
        }
    }

    public void a(int i) {
        if (this.g != null) {
            this.g.a(i);
        }
        if (this.d != null) {
            this.d.a(i);
        }
        notifyDataSetChanged();
    }

    public void a() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public void b() {
        if (this.d != null) {
            this.d.b();
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

    @Override // com.baidu.tieba.view.ai
    public void d() {
        Iterator<BaseAdapter> it = this.a.iterator();
        while (it.hasNext()) {
            BaseAdapter next = it.next();
            if (next instanceof com.baidu.tieba.view.ai) {
                ((com.baidu.tieba.view.ai) next).d();
            }
        }
    }

    @Override // com.baidu.tieba.view.ai
    public void a(View view, int i, int i2) {
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            BaseAdapter baseAdapter = this.a.get(i3);
            if (baseAdapter instanceof com.baidu.tieba.view.ai) {
                ((com.baidu.tieba.view.ai) baseAdapter).a(view, i < 0 ? 0 : i, i2 > baseAdapter.getCount() + (-1) ? baseAdapter.getCount() - 1 : i2);
            }
            com.baidu.tieba.util.be.a(getClass().getName(), "startLoadImage", "start:" + i + "en:" + i2);
            i -= baseAdapter.getCount();
            i2 -= baseAdapter.getCount();
            if (i2 < 0) {
                return;
            }
        }
    }
}
