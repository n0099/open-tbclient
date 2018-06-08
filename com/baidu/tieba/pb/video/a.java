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
/* loaded from: classes2.dex */
public class a extends k<b, c> {
    public View.OnClickListener bnQ;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.i.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bVar, cVar);
        if (cVar != null && cVar.cyO != null) {
            if (this.bnQ != null) {
                cVar.cyO.setOnClickListener(this.bnQ);
            }
            if (cVar.ayX != TbadkCoreApplication.getInst().getSkinType()) {
                cVar.ayX = TbadkCoreApplication.getInst().getSkinType();
                al.h(cVar.cyO, d.C0141d.cp_cont_f);
                al.i(cVar.cyO, d.f.more_all);
                al.i(cVar.bir, d.C0141d.cp_bg_line_c);
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bnQ = onClickListener;
    }
}
