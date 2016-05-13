package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.t;
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends cm<com.baidu.tbadk.core.data.bc, dn> {
    private View.OnClickListener bxd;

    /* JADX INFO: Access modifiers changed from: protected */
    public Cdo(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public dn b(ViewGroup viewGroup) {
        return new dn(LayoutInflater.from(this.mContext).inflate(t.h.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.bc bcVar, dn dnVar) {
        super.a(i, view, viewGroup, (ViewGroup) bcVar, (com.baidu.tbadk.core.data.bc) dnVar);
        if (bcVar != null) {
            dnVar.dmq.setOnClickListener(this.bxd);
            dnVar.dmq.setText(bcVar.rC());
            dnVar.dmq.setTag(bcVar);
            com.baidu.tbadk.core.util.at.l(dnVar.dmr, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.c(dnVar.dmq, t.d.cp_cont_b, 1);
            dnVar.dmq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void u(View.OnClickListener onClickListener) {
        this.bxd = onClickListener;
    }
}
