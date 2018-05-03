package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
/* loaded from: classes2.dex */
public class a extends k<b, c> {
    public View.OnClickListener bfI;

    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bu */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.i.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, b bVar, c cVar) {
        super.onFillViewHolder(i, view2, viewGroup, bVar, cVar);
        if (cVar != null && cVar.cpb != null) {
            if (this.bfI != null) {
                cVar.cpb.setOnClickListener(this.bfI);
            }
            if (cVar.aqQ != TbadkCoreApplication.getInst().getSkinType()) {
                cVar.aqQ = TbadkCoreApplication.getInst().getSkinType();
                ak.h(cVar.cpb, d.C0126d.cp_cont_f);
                ak.i(cVar.cpb, d.f.more_all);
                ak.i(cVar.bae, d.C0126d.cp_bg_line_c);
            }
        }
        return view2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bfI = onClickListener;
    }
}
