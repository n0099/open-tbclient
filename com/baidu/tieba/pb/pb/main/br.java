package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class br extends bk<com.baidu.tbadk.core.data.aa, bq> {
    private View.OnClickListener bMW;

    /* JADX INFO: Access modifiers changed from: protected */
    public br(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public bq a(ViewGroup viewGroup) {
        return new bq(LayoutInflater.from(this.mContext).inflate(i.g.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bk, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aa aaVar, bq bqVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (com.baidu.tbadk.core.data.aa) bqVar);
        if (aaVar != null) {
            bqVar.cjY.setOnClickListener(this.bMW);
            bqVar.cjY.setText(aaVar.getSummary());
            bqVar.cjY.setTag(aaVar);
            com.baidu.tbadk.core.util.an.j(bqVar.cjZ, i.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.an.b(bqVar.cjY, i.c.cp_cont_b, 1);
            bqVar.cjY.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void r(View.OnClickListener onClickListener) {
        this.bMW = onClickListener;
    }
}
