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
/* loaded from: classes21.dex */
public class a extends o<b, c> {
    public View.OnClickListener fUG;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cs */
    public c c(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) cVar);
        if (cVar != null && cVar.hYO != null) {
            if (this.fUG != null) {
                cVar.hYO.setOnClickListener(this.fUG);
            }
            if (cVar.ajv != TbadkCoreApplication.getInst().getSkinType()) {
                cVar.ajv = TbadkCoreApplication.getInst().getSkinType();
                ap.setViewTextColor(cVar.hYO, R.color.CAM_X0106);
                ap.setBackgroundResource(cVar.hYO, R.drawable.more_all);
                ap.setBackgroundResource(cVar.dividerLine, R.color.CAM_X0204);
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fUG = onClickListener;
    }
}
