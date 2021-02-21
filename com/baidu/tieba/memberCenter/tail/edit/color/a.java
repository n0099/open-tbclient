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
    private c lsE;
    private List<String> lsF;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.eUY = tbPageContext;
        this.lsF = new ArrayList();
        this.lsE = cVar;
        this.lsF = this.lsE.dgh();
        this.fml = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lsF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return this.lsF.get(i);
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
        String str = this.lsF.get(i);
        bVar.setColor(str);
        bVar.tW(this.lsE.dgg().equals(str));
        return view;
    }
}
