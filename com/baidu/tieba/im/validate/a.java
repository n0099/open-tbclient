package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    List<ValidateItemData> acz = new ArrayList();
    ValidateActivity hKk;

    public a(ValidateActivity validateActivity) {
        this.hKk = validateActivity;
    }

    public void destroy() {
        this.hKk = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.acz.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acz == null) {
            return 0;
        }
        return this.acz.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.hKk) : bVar;
        bVar2.e(this.acz.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.acz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.acz;
    }
}
