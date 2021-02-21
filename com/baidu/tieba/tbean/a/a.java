package com.baidu.tieba.tbean.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbean.b.b;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private int jlJ;
    private LinkedList<b> kau = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setDatas(List<b> list) {
        if (!y.isEmpty(list)) {
            this.kau.clear();
            this.kau.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void JX(int i) {
        this.jlJ = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.kau);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JY */
    public b getItem(int i) {
        return (b) y.getItem(this.kau, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.tbean.view.a aVar;
        if (view == null) {
            aVar = new com.baidu.tieba.tbean.view.a(this.mPageContext, this.jlJ);
            view = aVar.getView();
            view.setTag(aVar);
        } else {
            aVar = (com.baidu.tieba.tbean.view.a) view.getTag();
        }
        aVar.a(getItem(i));
        return view;
    }
}
