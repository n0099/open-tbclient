package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    List<ValidateItemData> aJN = new ArrayList();
    ValidateActivity biS;

    public g(ValidateActivity validateActivity) {
        this.biS = validateActivity;
    }

    public void destroy() {
        this.biS = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.aJN.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJN == null) {
            return 0;
        }
        return this.aJN.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        h hVar = null;
        if (view != null) {
            hVar = (h) view.getTag();
        }
        h hVar2 = hVar == null ? new h(this.biS) : hVar;
        hVar2.f(this.aJN.get(i));
        return hVar2.O();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aJN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.aJN;
    }
}
