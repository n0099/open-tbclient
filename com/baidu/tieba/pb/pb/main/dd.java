package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dd extends cl<com.baidu.tbadk.core.data.al, dc> {
    private View.OnClickListener ckV;

    /* JADX INFO: Access modifiers changed from: protected */
    public dd(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public dc b(ViewGroup viewGroup) {
        return new dc(LayoutInflater.from(this.mContext).inflate(t.h.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.al alVar, dc dcVar) {
        super.a(i, view, viewGroup, (ViewGroup) alVar, (com.baidu.tbadk.core.data.al) dcVar);
        if (alVar != null) {
            dcVar.cPE.setOnClickListener(this.ckV);
            dcVar.cPE.setText(alVar.getSummary());
            dcVar.cPE.setTag(alVar);
            com.baidu.tbadk.core.util.ar.l(dcVar.cPF, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.b(dcVar.cPE, t.d.cp_cont_b, 1);
            dcVar.cPE.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void x(View.OnClickListener onClickListener) {
        this.ckV = onClickListener;
    }
}
