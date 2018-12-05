package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> bVb = new ArrayList();
    ValidateActivity eZJ;

    public a(ValidateActivity validateActivity) {
        this.eZJ = validateActivity;
    }

    public void destroy() {
        this.eZJ = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.bVb.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bVb == null) {
            return 0;
        }
        return this.bVb.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eZJ) : bVar;
        bVar2.f(this.bVb.get(i));
        return bVar2.gb();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bVb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.bVb;
    }
}
