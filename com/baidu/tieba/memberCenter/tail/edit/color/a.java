package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eXu;
    private View.OnClickListener foD;
    private c loU;
    private List<String> loV;

    public a(TbPageContext<?> tbPageContext, c cVar, View.OnClickListener onClickListener) {
        this.eXu = tbPageContext;
        this.loV = new ArrayList();
        this.loU = cVar;
        this.loV = this.loU.dhS();
        this.foD = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.loV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return this.loV.get(i);
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
            view = bVar2.gC(this.eXu.getPageActivity());
            bVar2.setOnClickListener(this.foD);
            bVar2.onChangeSkinType(this.eXu);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        String str = this.loV.get(i);
        bVar.setColor(str);
        bVar.tN(this.loU.dhR().equals(str));
        return view;
    }
}
