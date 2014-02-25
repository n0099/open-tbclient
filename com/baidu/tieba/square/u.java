package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.view.bg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends BaseAdapter implements bg {
    private Context a;
    private y b = null;
    private ArrayList<av> c = new ArrayList<>();
    private v d;

    public u(Context context) {
        this.a = null;
        this.d = null;
        this.a = context;
        this.d = new v(context);
    }

    public void a(ArrayList<av> arrayList) {
        this.c = arrayList;
        this.d.a(arrayList);
        this.b = this.d.getPagerAdapter();
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
        return (this.c != null ? this.c.size() + 0 : 0) > 0 ? 1 : 0;
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
        return this.d;
    }

    @Override // com.baidu.tieba.view.bg
    public void d() {
        if (this.b != null) {
            this.b.d();
        }
    }

    @Override // com.baidu.tieba.view.bg
    public void a(View view, int i, int i2) {
        if (this.b != null) {
            this.b.a(this.d, 0, 0);
        }
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }
}
