package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eSJ;
    private View.OnClickListener fjU;
    private c lkk;
    private List<String> lkl;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.eSJ = tbPageContext;
        this.lkl = new ArrayList();
        this.lkk = cVar;
        this.lkl = this.lkk.dea();
        this.fjU = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lkl.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return this.lkl.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            b bVar2 = new b();
            view = bVar2.gA(this.eSJ.getPageActivity());
            bVar2.setOnClickListener(this.fjU);
            bVar2.onChangeSkinType(this.eSJ);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        String str = this.lkl.get(i);
        bVar.setColor(str);
        bVar.tJ(this.lkk.ddZ().equals(str));
        return view;
    }
}
