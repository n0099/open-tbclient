package com.baidu.tieba.im.validate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.ValidateItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    ValidateActivity bou;
    List<ValidateItemData> datas = new ArrayList();

    public h(ValidateActivity validateActivity) {
        this.bou = validateActivity;
    }

    public void destroy() {
        this.bou = null;
    }

    public void setData(List<ValidateItemData> list) {
        if (list != null) {
            this.datas.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.datas == null) {
            return 0;
        }
        return this.datas.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar = null;
        if (view != null) {
            iVar = (i) view.getTag();
        }
        i iVar2 = iVar == null ? new i(this.bou) : iVar;
        iVar2.f(this.datas.get(i));
        return iVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.datas.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<ValidateItemData> getDatas() {
        return this.datas;
    }
}
