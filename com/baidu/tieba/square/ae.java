package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends BaseAdapter implements com.baidu.tieba.view.ah {

    /* renamed from: a  reason: collision with root package name */
    private af f2358a;
    private ArrayList<au> b = new ArrayList<>();

    public ae(Context context) {
        this.f2358a = null;
        this.f2358a = new af(context);
    }

    public void a(ArrayList<au> arrayList) {
        this.b = arrayList;
        this.f2358a.a(arrayList);
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
        return this.f2358a;
    }

    @Override // com.baidu.tieba.view.ah
    public void d() {
        if (this.f2358a != null) {
            this.f2358a.d();
        }
    }

    @Override // com.baidu.tieba.view.ah
    public void a(View view, int i, int i2) {
        if (this.f2358a != null) {
            this.f2358a.a(this.f2358a, 0, 0);
        }
    }
}
