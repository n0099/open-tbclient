package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eWx;
    private View.OnClickListener fnL;
    private c luH;
    private List<String> luI;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.eWx = tbPageContext;
        this.luI = new ArrayList();
        this.luH = cVar;
        this.luI = this.luH.dgq();
        this.fnL = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.luI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return this.luI.get(i);
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
            view = bVar2.gA(this.eWx.getPageActivity());
            bVar2.setOnClickListener(this.fnL);
            bVar2.onChangeSkinType(this.eWx);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        String str = this.luI.get(i);
        bVar.setColor(str);
        bVar.tW(this.luH.dgp().equals(str));
        return view;
    }
}
