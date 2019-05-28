package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> dvA = new ArrayList();
    ValidateActivity gKw;

    public a(ValidateActivity validateActivity) {
        this.gKw = validateActivity;
    }

    public void destroy() {
        this.gKw = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.dvA.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvA == null) {
            return 0;
        }
        return this.dvA.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gKw) : bVar;
        bVar2.f(this.dvA.get(i));
        return bVar2.eR();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dvA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.dvA;
    }
}
