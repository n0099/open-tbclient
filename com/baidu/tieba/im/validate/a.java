package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> eIs = new ArrayList();
    ValidateActivity eNG;

    public a(ValidateActivity validateActivity) {
        this.eNG = validateActivity;
    }

    public void destroy() {
        this.eNG = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.eIs.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIs == null) {
            return 0;
        }
        return this.eIs.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eNG) : bVar;
        bVar2.f(this.eIs.get(i));
        return bVar2.jK();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eIs.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.eIs;
    }
}
