package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> bBz = new ArrayList();
    ValidateActivity eyO;

    public a(ValidateActivity validateActivity) {
        this.eyO = validateActivity;
    }

    public void destroy() {
        this.eyO = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.bBz.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBz == null) {
            return 0;
        }
        return this.bBz.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eyO) : bVar;
        bVar2.f(this.bBz.get(i));
        return bVar2.eC();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bBz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.bBz;
    }
}
