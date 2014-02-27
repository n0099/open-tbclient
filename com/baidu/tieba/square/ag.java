package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.view.bg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ag extends BaseAdapter implements bg {
    private ah a;
    private ArrayList<av> b = new ArrayList<>();

    public ag(Context context) {
        this.a = null;
        this.a = new ah(context);
    }

    public final void a(ArrayList<av> arrayList) {
        this.b = arrayList;
        this.a.a(arrayList);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return (this.b == null || this.b.size() <= 1) ? 0 : 1;
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
        return this.a;
    }

    @Override // com.baidu.tieba.view.bg
    public final void d() {
        if (this.a != null) {
            this.a.d();
        }
    }

    @Override // com.baidu.tieba.view.bg
    public final void a(View view, int i, int i2) {
        if (this.a != null) {
            this.a.a(this.a, 0, 0);
        }
    }
}
