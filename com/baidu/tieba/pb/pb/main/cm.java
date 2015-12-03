package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cm extends cb<com.baidu.tbadk.core.data.ad, cl> {
    private View.OnClickListener ccv;

    /* JADX INFO: Access modifiers changed from: protected */
    public cm(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public cl a(ViewGroup viewGroup) {
        return new cl(LayoutInflater.from(this.mContext).inflate(n.g.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cb, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ad adVar, cl clVar) {
        super.a(i, view, viewGroup, (ViewGroup) adVar, (com.baidu.tbadk.core.data.ad) clVar);
        if (adVar != null) {
            clVar.cDW.setOnClickListener(this.ccv);
            clVar.cDW.setText(adVar.getSummary());
            clVar.cDW.setTag(adVar);
            com.baidu.tbadk.core.util.as.j(clVar.cDX, n.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.as.b(clVar.cDW, n.c.cp_cont_b, 1);
            clVar.cDW.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void r(View.OnClickListener onClickListener) {
        this.ccv = onClickListener;
    }
}
