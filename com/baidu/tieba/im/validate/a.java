package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> bWQ = new ArrayList();
    ValidateActivity kEw;

    public a(ValidateActivity validateActivity) {
        this.kEw = validateActivity;
    }

    public void destroy() {
        this.kEw = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.bWQ.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bWQ == null) {
            return 0;
        }
        return this.bWQ.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.kEw) : bVar;
        bVar2.e(this.bWQ.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bWQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.bWQ;
    }
}
