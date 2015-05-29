package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bv extends bn<com.baidu.tbadk.core.data.aa, bu> {
    private View.OnClickListener mItemClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public bv(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public bu a(ViewGroup viewGroup) {
        return new bu(com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aa aaVar, bu buVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (com.baidu.tbadk.core.data.aa) buVar);
        if (aaVar != null) {
            buVar.bMa.setOnClickListener(this.mItemClickListener);
            buVar.bMa.setText(aaVar.getSummary());
            buVar.bMa.setTag(aaVar);
            com.baidu.tbadk.core.util.ay.j(buVar.bMb, com.baidu.tieba.n.cp_bg_line_b);
            com.baidu.tbadk.core.util.ay.b(buVar.bMa, com.baidu.tieba.n.cp_cont_b, 1);
            buVar.bMa.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mItemClickListener = onClickListener;
    }
}
