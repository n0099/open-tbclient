package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> epG = new ArrayList();
    ValidateActivity euX;

    public a(ValidateActivity validateActivity) {
        this.euX = validateActivity;
    }

    public void destroy() {
        this.euX = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.epG.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.epG == null) {
            return 0;
        }
        return this.epG.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.euX) : bVar;
        bVar2.f(this.epG.get(i));
        return bVar2.eC();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.epG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.epG;
    }
}
