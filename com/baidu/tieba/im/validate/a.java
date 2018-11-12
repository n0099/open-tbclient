package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> bRk = new ArrayList();
    ValidateActivity eSU;

    public a(ValidateActivity validateActivity) {
        this.eSU = validateActivity;
    }

    public void destroy() {
        this.eSU = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.bRk.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bRk == null) {
            return 0;
        }
        return this.bRk.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eSU) : bVar;
        bVar2.f(this.bRk.get(i));
        return bVar2.gb();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bRk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.bRk;
    }
}
