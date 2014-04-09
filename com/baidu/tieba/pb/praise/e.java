package com.baidu.tieba.pb.praise;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public final class e extends BaseAdapter implements AbsListView.OnScrollListener {
    private PraiseListActivity a;
    private List<a> b = null;
    private volatile boolean c;

    public e(PraiseListActivity praiseListActivity) {
        this.a = null;
        this.a = praiseListActivity;
    }

    public final void a(List<a> list) {
        this.b = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public a getItem(int i) {
        if (this.b != null) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        b a = b.a(this.a, view);
        a item = getItem(i);
        a.a(item.b(), item.c(), item.e(), this.c);
        this.a.changSkinType(a.a());
        return a.a();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.c = false;
            notifyDataSetChanged();
            return;
        }
        this.c = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
