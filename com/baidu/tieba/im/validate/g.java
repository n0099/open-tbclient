package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    List<ValidateItemData> aKa = new ArrayList();
    ValidateActivity bjg;

    public g(ValidateActivity validateActivity) {
        this.bjg = validateActivity;
    }

    public void destroy() {
        this.bjg = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.aKa.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aKa == null) {
            return 0;
        }
        return this.aKa.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar = null;
        if (view != null) {
            hVar = (h) view.getTag();
        }
        h hVar2 = hVar == null ? new h(this.bjg) : hVar;
        hVar2.f(this.aKa.get(i));
        return hVar2.O();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aKa.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.aKa;
    }
}
