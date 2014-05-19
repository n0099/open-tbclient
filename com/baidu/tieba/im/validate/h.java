package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.editortool.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    ValidateActivity a;
    ab b;
    List<ValidateItemData> c = new ArrayList();

    public h(ValidateActivity validateActivity) {
        this.b = null;
        this.a = validateActivity;
        this.b = new ab(this.a);
    }

    public void a() {
        this.a = null;
    }

    public void a(List<ValidateItemData> list) {
        if (list != null) {
            this.c.addAll(list);
            BdLog.d("size:" + this.c.size());
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
