package com.baidu.tieba.pb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    String[] a;
    LayoutInflater b;

    public a(Context context, String[] strArr) {
        this.b = null;
        this.b = LayoutInflater.from(context);
        this.a = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a != null) {
            return this.a.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || i < 0 || i >= getCount()) {
            return null;
        }
        return this.a[i];
    }

    public void a(int i, String str) {
        if (this.a != null && i >= 0 && i < getCount()) {
            this.a[i] = str;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.b.inflate(R.layout.context_menu_item, (ViewGroup) null) : view;
        ((TextView) inflate).setText(this.a[i]);
        return inflate;
    }
}
