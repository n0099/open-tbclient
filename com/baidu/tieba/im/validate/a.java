package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> dkO = new ArrayList();
    ValidateActivity gtu;

    public a(ValidateActivity validateActivity) {
        this.gtu = validateActivity;
    }

    public void destroy() {
        this.gtu = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.dkO.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dkO == null) {
            return 0;
        }
        return this.dkO.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gtu) : bVar;
        bVar2.f(this.dkO.get(i));
        return bVar2.fY();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dkO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.dkO;
    }
}
