package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eUY;
    private View.OnClickListener fml;
    private c lsq;
    private List<String> lsr;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.eUY = tbPageContext;
        this.lsr = new ArrayList();
        this.lsq = cVar;
        this.lsr = this.lsq.dga();
        this.fml = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lsr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return this.lsr.get(i);
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
            view = bVar2.gB(this.eUY.getPageActivity());
            bVar2.setOnClickListener(this.fml);
            bVar2.onChangeSkinType(this.eUY);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        String str = this.lsr.get(i);
        bVar.setColor(str);
        bVar.tW(this.lsq.dfZ().equals(str));
        return view;
    }
}
