package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
/* loaded from: classes4.dex */
public class a extends k<b, c> {
    public View.OnClickListener cPX;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.h.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bVar, cVar);
        if (cVar != null && cVar.eij != null) {
            if (this.cPX != null) {
                cVar.eij.setOnClickListener(this.cPX);
            }
            if (cVar.bUN != TbadkCoreApplication.getInst().getSkinType()) {
                cVar.bUN = TbadkCoreApplication.getInst().getSkinType();
                al.j(cVar.eij, d.C0277d.cp_cont_f);
                al.k(cVar.eij, d.f.more_all);
                al.k(cVar.dividerLine, d.C0277d.cp_bg_line_c);
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cPX = onClickListener;
    }
}
