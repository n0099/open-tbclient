package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
/* loaded from: classes9.dex */
public class a extends l<b, c> {
    public View.OnClickListener eCs;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public c b(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) cVar);
        if (cVar != null && cVar.gpz != null) {
            if (this.eCs != null) {
                cVar.gpz.setOnClickListener(this.eCs);
            }
            if (cVar.afT != TbadkCoreApplication.getInst().getSkinType()) {
                cVar.afT = TbadkCoreApplication.getInst().getSkinType();
                am.setViewTextColor(cVar.gpz, (int) R.color.cp_cont_f);
                am.setBackgroundResource(cVar.gpz, R.drawable.more_all);
                am.setBackgroundResource(cVar.dividerLine, R.color.cp_bg_line_c);
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eCs = onClickListener;
    }
}
