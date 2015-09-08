package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bq extends bj<com.baidu.tbadk.core.data.ab, bp> {
    private View.OnClickListener bJG;

    /* JADX INFO: Access modifiers changed from: protected */
    public bq(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public bp a(ViewGroup viewGroup) {
        return new bp(LayoutInflater.from(this.mContext).inflate(i.g.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ab abVar, bp bpVar) {
        super.a(i, view, viewGroup, (ViewGroup) abVar, (com.baidu.tbadk.core.data.ab) bpVar);
        if (abVar != null) {
            bpVar.cdz.setOnClickListener(this.bJG);
            bpVar.cdz.setText(abVar.getSummary());
            bpVar.cdz.setTag(abVar);
            com.baidu.tbadk.core.util.al.i(bpVar.cdA, i.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.b(bpVar.cdz, i.c.cp_cont_b, 1);
            bpVar.cdz.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void r(View.OnClickListener onClickListener) {
        this.bJG = onClickListener;
    }
}
