package com.baidu.tieba.interestlabel.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.interestlabel.view.LabelItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tieba.interestlabel.b.a> haI = new ArrayList();
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list) {
        if (!v.aa(list)) {
            this.haI = list;
            notifyDataSetChanged();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.haI.size();
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
        LabelItemView labelItemView;
        if (view == null) {
            labelItemView = new LabelItemView(this.mContext);
        } else {
            labelItemView = (LabelItemView) view;
        }
        int i2 = i * 3;
        labelItemView.setData(this.haI.subList(i2, Math.min(this.haI.size(), i2 + 3)), i == getCount() + (-1));
        labelItemView.setOnClickListener(this.mOnClickListener);
        return labelItemView;
    }
}
