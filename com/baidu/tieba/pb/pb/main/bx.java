package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bx extends bp<com.baidu.tbadk.core.data.aa, bw> {
    private View.OnClickListener bsg;

    /* JADX INFO: Access modifiers changed from: protected */
    public bx(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public bw a(ViewGroup viewGroup) {
        return new bw(com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aa aaVar, bw bwVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (com.baidu.tbadk.core.data.aa) bwVar);
        if (aaVar != null) {
            bwVar.bJF.setOnClickListener(this.bsg);
            bwVar.bJF.setText(aaVar.getSummary());
            bwVar.bJF.setTag(aaVar);
            com.baidu.tbadk.core.util.ba.j(bwVar.bJG, com.baidu.tieba.s.cp_bg_line_b);
            com.baidu.tbadk.core.util.ba.b(bwVar.bJF, com.baidu.tieba.s.cp_cont_b, 1);
            bwVar.bJF.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void v(View.OnClickListener onClickListener) {
        this.bsg = onClickListener;
    }
}
