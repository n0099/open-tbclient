package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dx extends db<com.baidu.tbadk.core.data.aw, dw> {
    private View.OnClickListener bKS;

    /* JADX INFO: Access modifiers changed from: protected */
    public dx(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ay */
    public dw b(ViewGroup viewGroup) {
        return new dw(LayoutInflater.from(this.mContext).inflate(t.h.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.aw awVar, dw dwVar) {
        super.a(i, view, viewGroup, (ViewGroup) awVar, (com.baidu.tbadk.core.data.aw) dwVar);
        if (awVar != null) {
            dwVar.djU.setOnClickListener(this.bKS);
            dwVar.djU.setText(awVar.getSummary());
            dwVar.djU.setTag(awVar);
            com.baidu.tbadk.core.util.at.l(dwVar.djV, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.b(dwVar.djU, t.d.cp_cont_b, 1);
            dwVar.djU.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void y(View.OnClickListener onClickListener) {
        this.bKS = onClickListener;
    }
}
