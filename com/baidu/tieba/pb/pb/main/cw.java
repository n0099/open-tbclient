package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cw extends ce<com.baidu.tbadk.core.data.ad, cv> {
    private View.OnClickListener cgv;

    /* JADX INFO: Access modifiers changed from: protected */
    public cw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public cv a(ViewGroup viewGroup) {
        return new cv(LayoutInflater.from(this.mContext).inflate(n.h.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ce, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ad adVar, cv cvVar) {
        super.a(i, view, viewGroup, (ViewGroup) adVar, (com.baidu.tbadk.core.data.ad) cvVar);
        if (adVar != null) {
            cvVar.cHV.setOnClickListener(this.cgv);
            cvVar.cHV.setText(adVar.getSummary());
            cvVar.cHV.setTag(adVar);
            com.baidu.tbadk.core.util.as.j(cvVar.cHW, n.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.as.b(cvVar.cHV, n.d.cp_cont_b, 1);
            cvVar.cHV.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void r(View.OnClickListener onClickListener) {
        this.cgv = onClickListener;
    }
}
