package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bq extends bj<com.baidu.tbadk.core.data.z, bp> {
    private View.OnClickListener bIZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public bq(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public bp a(ViewGroup viewGroup) {
        return new bp(LayoutInflater.from(this.mContext).inflate(i.g.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, bp bpVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) bpVar);
        if (zVar != null) {
            bpVar.ccC.setOnClickListener(this.bIZ);
            bpVar.ccC.setText(zVar.getSummary());
            bpVar.ccC.setTag(zVar);
            com.baidu.tbadk.core.util.al.j(bpVar.ccD, i.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.b(bpVar.ccC, i.c.cp_cont_b, 1);
            bpVar.ccC.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void s(View.OnClickListener onClickListener) {
        this.bIZ = onClickListener;
    }
}
