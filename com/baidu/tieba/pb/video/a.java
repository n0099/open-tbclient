package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
/* loaded from: classes2.dex */
public class a extends k<b, c> {
    public View.OnClickListener bpq;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.i.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bVar, cVar);
        if (cVar != null && cVar.cwI != null) {
            if (this.bpq != null) {
                cVar.cwI.setOnClickListener(this.bpq);
            }
            if (cVar.azP != TbadkCoreApplication.getInst().getSkinType()) {
                cVar.azP = TbadkCoreApplication.getInst().getSkinType();
                am.h(cVar.cwI, d.C0142d.cp_cont_f);
                am.i(cVar.cwI, d.f.more_all);
                am.i(cVar.bjR, d.C0142d.cp_bg_line_c);
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bpq = onClickListener;
    }
}
