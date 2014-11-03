package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ap extends BaseAdapter implements com.baidu.tieba.view.s {
    private g bNA;
    private ArrayList<BaseAdapter> bNw;
    private k bNx;
    private v bNy;
    private r bNz;

    public ap(Context context) {
        this.bNw = null;
        this.bNx = null;
        this.bNy = null;
        this.bNz = null;
        this.bNA = null;
        this.bNw = new ArrayList<>();
        this.bNx = new k(context);
        this.bNy = new v(context);
        this.bNz = new r(context);
        this.bNA = new g(context);
        this.bNw.add(this.bNx);
        this.bNw.add(this.bNy);
        this.bNw.add(this.bNz);
        this.bNw.add(this.bNA);
    }

    public void b(ah ahVar) {
        if (ahVar != null) {
            if (this.bNx != null) {
                this.bNx.setData(ahVar.adv());
            }
            if (this.bNy != null) {
                this.bNy.setData(ahVar.adw());
            }
            if (this.bNz != null) {
                this.bNz.a(ahVar.adx());
            }
            if (this.bNA != null) {
                this.bNA.a(ahVar.ady());
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNx != null) {
            this.bNx.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    public void onResume() {
        if (this.bNx != null) {
            this.bNx.startMarqueen();
        }
    }

    public void onPause() {
        if (this.bNx != null) {
            this.bNx.stopMarqueen();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        Iterator<BaseAdapter> it = this.bNw.iterator();
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
            if (i3 < this.bNw.size()) {
                BaseAdapter baseAdapter = this.bNw.get(i3);
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
        Iterator<BaseAdapter> it = this.bNw.iterator();
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
        for (int i3 = 0; i3 < this.bNw.size(); i3++) {
            BaseAdapter baseAdapter = this.bNw.get(i3);
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
            if (i3 < this.bNw.size()) {
                BaseAdapter baseAdapter = this.bNw.get(i3);
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
    public void adq() {
        Iterator<BaseAdapter> it = this.bNw.iterator();
        while (it.hasNext()) {
            BaseAdapter next = it.next();
            if (next instanceof com.baidu.tieba.view.s) {
                ((com.baidu.tieba.view.s) next).adq();
            }
        }
    }

    @Override // com.baidu.tieba.view.s
    public void g(View view, int i, int i2) {
        for (int i3 = 0; i3 < this.bNw.size(); i3++) {
            BaseAdapter baseAdapter = this.bNw.get(i3);
            if (baseAdapter instanceof com.baidu.tieba.view.s) {
                ((com.baidu.tieba.view.s) baseAdapter).g(view, i < 0 ? 0 : i, i2 > baseAdapter.getCount() + (-1) ? baseAdapter.getCount() - 1 : i2);
            }
            i -= baseAdapter.getCount();
            i2 -= baseAdapter.getCount();
            if (i2 < 0) {
                return;
            }
        }
    }
}
