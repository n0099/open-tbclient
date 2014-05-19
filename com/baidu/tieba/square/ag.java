package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ag extends BaseAdapter implements com.baidu.tieba.view.t {
    private ah a;
    private ArrayList<at> b = new ArrayList<>();

    public ag(Context context) {
        this.a = null;
        this.a = new ah(context);
    }

    public void a(ArrayList<at> arrayList) {
        this.b = arrayList;
        this.a.a(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.b == null || this.b.size() <= 1) ? 0 : 1;
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
        return this.a;
    }

    @Override // com.baidu.tieba.view.t
    public void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.baidu.tieba.view.t
    public void a(View view, int i, int i2) {
        if (this.a != null) {
            this.a.a(this.a, 0, 0);
        }
    }
}
