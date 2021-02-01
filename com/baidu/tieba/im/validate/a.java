package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> caS = new ArrayList();
    ValidateActivity kMB;

    public a(ValidateActivity validateActivity) {
        this.kMB = validateActivity;
    }

    public void destroy() {
        this.kMB = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.caS.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.caS == null) {
            return 0;
        }
        return this.caS.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.kMB) : bVar;
        bVar2.e(this.caS.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.caS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.caS;
    }
}
