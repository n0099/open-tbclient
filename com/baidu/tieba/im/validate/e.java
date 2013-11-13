package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    ValidateActivity f1808a;
    com.baidu.tieba.util.i b;
    List<ValidateItemData> c = new ArrayList();

    public e(ValidateActivity validateActivity) {
        this.b = null;
        this.f1808a = validateActivity;
        this.b = new com.baidu.tieba.util.i(this.f1808a);
    }

    public void a() {
        this.f1808a = null;
    }

    public void a(List<ValidateItemData> list) {
        if (list != null) {
            this.c = list;
            com.baidu.adp.lib.h.d.d("size:" + this.c.size());
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVar = null;
        if (view != null) {
            fVar = (f) view.getTag();
        }
        f fVar2 = fVar == null ? new f(this.f1808a) : fVar;
        fVar2.a(this.c.get(i));
        return fVar2.a();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> b() {
        return this.c;
    }
}
