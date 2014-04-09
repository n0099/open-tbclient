package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.editortool.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class h extends BaseAdapter {
    ValidateActivity a;
    ab b;
    List<ValidateItemData> c = new ArrayList();

    public h(ValidateActivity validateActivity) {
        this.b = null;
        this.a = validateActivity;
        this.b = new ab(this.a);
    }

    public final void a() {
        this.a = null;
    }

    public final void a(List<ValidateItemData> list) {
        if (list != null) {
            this.c.addAll(list);
            com.baidu.adp.lib.util.f.e("size:" + this.c.size());
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        i iVar = null;
        if (view != null) {
            iVar = (i) view.getTag();
        }
        i iVar2 = iVar == null ? new i(this.a) : iVar;
        iVar2.a(this.c.get(i));
        iVar2.d();
        return iVar2.a();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public final List<ValidateItemData> b() {
        return this.c;
    }
}
