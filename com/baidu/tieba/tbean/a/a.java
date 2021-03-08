package com.baidu.tieba.tbean.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbean.b.b;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private int jnt;
    private LinkedList<b> kcw = new LinkedList<>();
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setDatas(List<b> list) {
        if (!y.isEmpty(list)) {
            this.kcw.clear();
            this.kcw.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void Kc(int i) {
        this.jnt = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.kcw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kd */
    public b getItem(int i) {
        return (b) y.getItem(this.kcw, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.tbean.view.a aVar;
        if (view == null) {
            aVar = new com.baidu.tieba.tbean.view.a(this.mPageContext, this.jnt);
            view = aVar.getView();
            view.setTag(aVar);
        } else {
            aVar = (com.baidu.tieba.tbean.view.a) view.getTag();
        }
        aVar.a(getItem(i));
        return view;
    }
}
