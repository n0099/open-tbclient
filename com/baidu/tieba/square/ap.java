package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ap extends BaseAdapter implements com.baidu.tieba.view.s {
    private ArrayList<BaseAdapter> bNh;
    private k bNi;
    private v bNj;
    private r bNk;
    private g bNl;

    public ap(Context context) {
        this.bNh = null;
        this.bNi = null;
        this.bNj = null;
        this.bNk = null;
        this.bNl = null;
        this.bNh = new ArrayList<>();
        this.bNi = new k(context);
        this.bNj = new v(context);
        this.bNk = new r(context);
        this.bNl = new g(context);
        this.bNh.add(this.bNi);
        this.bNh.add(this.bNj);
        this.bNh.add(this.bNk);
        this.bNh.add(this.bNl);
    }

    public void b(ah ahVar) {
        if (ahVar != null) {
            if (this.bNi != null) {
                this.bNi.setData(ahVar.ads());
            }
            if (this.bNj != null) {
                this.bNj.setData(ahVar.adt());
            }
            if (this.bNk != null) {
                this.bNk.a(ahVar.adu());
            }
            if (this.bNl != null) {
                this.bNl.a(ahVar.adv());
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNi != null) {
            this.bNi.onChangeSkinType(i);
        }
        notifyDataSetChanged();
    }

    public void onResume() {
        if (this.bNi != null) {
            this.bNi.startMarqueen();
        }
    }

    public void onPause() {
        if (this.bNi != null) {
            this.bNi.stopMarqueen();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        Iterator<BaseAdapter> it = this.bNh.iterator();
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
            if (i3 < this.bNh.size()) {
                BaseAdapter baseAdapter = this.bNh.get(i3);
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
        Iterator<BaseAdapter> it = this.bNh.iterator();
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
        for (int i3 = 0; i3 < this.bNh.size(); i3++) {
            BaseAdapter baseAdapter = this.bNh.get(i3);
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
            if (i3 < this.bNh.size()) {
                BaseAdapter baseAdapter = this.bNh.get(i3);
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
    public void adn() {
        Iterator<BaseAdapter> it = this.bNh.iterator();
        while (it.hasNext()) {
            BaseAdapter next = it.next();
            if (next instanceof com.baidu.tieba.view.s) {
                ((com.baidu.tieba.view.s) next).adn();
            }
        }
    }

    @Override // com.baidu.tieba.view.s
    public void g(View view, int i, int i2) {
        for (int i3 = 0; i3 < this.bNh.size(); i3++) {
            BaseAdapter baseAdapter = this.bNh.get(i3);
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
