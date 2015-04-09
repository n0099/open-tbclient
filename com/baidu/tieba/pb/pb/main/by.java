package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class by extends bq<com.baidu.tbadk.core.data.aa, bx> {
    private View.OnClickListener bsw;

    /* JADX INFO: Access modifiers changed from: protected */
    public by(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public bx a(ViewGroup viewGroup) {
        return new bx(com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aa aaVar, bx bxVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (com.baidu.tbadk.core.data.aa) bxVar);
        if (aaVar != null) {
            bxVar.bJU.setOnClickListener(this.bsw);
            bxVar.bJU.setText(aaVar.getSummary());
            bxVar.bJU.setTag(aaVar);
            com.baidu.tbadk.core.util.ba.j(bxVar.bJV, com.baidu.tieba.s.cp_bg_line_b);
            com.baidu.tbadk.core.util.ba.b(bxVar.bJU, com.baidu.tieba.s.cp_cont_b, 1);
            bxVar.bJU.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void w(View.OnClickListener onClickListener) {
        this.bsw = onClickListener;
    }
}
