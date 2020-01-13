package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.m;
/* loaded from: classes7.dex */
public class a extends m<b, c> {
    public View.OnClickListener dXX;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public c b(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) cVar);
        if (cVar != null && cVar.fHy != null) {
            if (this.dXX != null) {
                cVar.fHy.setOnClickListener(this.dXX);
            }
            if (cVar.MH != TbadkCoreApplication.getInst().getSkinType()) {
                cVar.MH = TbadkCoreApplication.getInst().getSkinType();
                am.setViewTextColor(cVar.fHy, (int) R.color.cp_cont_f);
                am.setBackgroundResource(cVar.fHy, R.drawable.more_all);
                am.setBackgroundResource(cVar.dividerLine, R.color.cp_bg_line_c);
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dXX = onClickListener;
    }
}
