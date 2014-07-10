package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.editortool.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    ValidateActivity a;
    aa b;
    List<ValidateItemData> c = new ArrayList();

    public h(ValidateActivity validateActivity) {
        this.b = null;
        this.a = validateActivity;
        this.b = new aa(this.a);
    }

    public void a() {
        this.a = null;
    }

    public void a(List<ValidateItemData> list) {
        if (list != null) {
            this.c.addAll(list);
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
        i iVar = null;
        if (view != null) {
            iVar = (i) view.getTag();
        }
        i iVar2 = iVar == null ? new i(this.a) : iVar;
        iVar2.a(this.c.get(i));
        return iVar2.a();
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
