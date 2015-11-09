package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cg extends bz<com.baidu.tbadk.core.data.aa, cf> {
    private View.OnClickListener bNr;

    /* JADX INFO: Access modifiers changed from: protected */
    public cg(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public cf a(ViewGroup viewGroup) {
        return new cf(LayoutInflater.from(this.mContext).inflate(i.g.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bz, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aa aaVar, cf cfVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (com.baidu.tbadk.core.data.aa) cfVar);
        if (aaVar != null) {
            cfVar.cll.setOnClickListener(this.bNr);
            cfVar.cll.setText(aaVar.getSummary());
            cfVar.cll.setTag(aaVar);
            com.baidu.tbadk.core.util.an.j(cfVar.clm, i.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.an.b(cfVar.cll, i.c.cp_cont_b, 1);
            cfVar.cll.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void r(View.OnClickListener onClickListener) {
        this.bNr = onClickListener;
    }
}
