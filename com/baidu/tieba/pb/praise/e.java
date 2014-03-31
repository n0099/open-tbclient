package com.baidu.tieba.pb.praise;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public final class e extends BaseAdapter {
    private PraiseListActivity a;
    private List<a> b = null;

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
        a.a(item.b(), item.c());
        this.a.changSkinType(a.a());
        return a.a();
    }
}
