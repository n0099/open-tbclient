package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> aAp = new ArrayList();
    ValidateActivity iKy;

    public a(ValidateActivity validateActivity) {
        this.iKy = validateActivity;
    }

    public void destroy() {
        this.iKy = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.aAp.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAp == null) {
            return 0;
        }
        return this.aAp.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.iKy) : bVar;
        bVar2.e(this.aAp.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aAp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.aAp;
    }
}
