package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
/* loaded from: classes16.dex */
public class a extends o<b, c> {
    public View.OnClickListener fro;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cq */
    public c b(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) cVar);
        if (cVar != null && cVar.hjT != null) {
            if (this.fro != null) {
                cVar.hjT.setOnClickListener(this.fro);
            }
            if (cVar.aiB != TbadkCoreApplication.getInst().getSkinType()) {
                cVar.aiB = TbadkCoreApplication.getInst().getSkinType();
                ap.setViewTextColor(cVar.hjT, R.color.cp_cont_f);
                ap.setBackgroundResource(cVar.hjT, R.drawable.more_all);
                ap.setBackgroundResource(cVar.dividerLine, R.color.cp_bg_line_c);
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fro = onClickListener;
    }
}
