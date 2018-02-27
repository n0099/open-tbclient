package com.baidu.tieba.interestlabel.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tieba.interestlabel.b.a> eXi = new ArrayList();
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (!v.E(list)) {
            this.eXi = list;
            notifyDataSetChanged();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.eXi.size();
        if (size % 3 == 0) {
            return size / 3;
        }
        return (size / 3) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.interestlabel.view.a aVar;
        if (view == null) {
            aVar = new com.baidu.tieba.interestlabel.view.a(this.mContext);
        } else {
            aVar = (com.baidu.tieba.interestlabel.view.a) view;
        }
        int i2 = i * 3;
        aVar.setData(this.eXi.subList(i2, Math.min(this.eXi.size(), i2 + 3)), i == getCount() + (-1));
        aVar.setOnClickListener(this.mOnClickListener);
        return aVar;
    }
}
