package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> eer = new ArrayList();
    ValidateActivity ejG;

    public a(ValidateActivity validateActivity) {
        this.ejG = validateActivity;
    }

    public void destroy() {
        this.ejG = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.eer.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eer == null) {
            return 0;
        }
        return this.eer.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar = null;
        if (view2 != null) {
            bVar = (b) view2.getTag();
        }
        b bVar2 = bVar == null ? new b(this.ejG) : bVar;
        bVar2.f(this.eer.get(i));
        return bVar2.bO();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eer.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.eer;
    }
}
