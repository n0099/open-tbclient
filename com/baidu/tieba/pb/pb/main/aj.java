package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class aj extends l<com.baidu.tieba.pb.data.k, ak> {
    private View.OnClickListener cNL;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public ak onCreateViewHolder(ViewGroup viewGroup) {
        ak akVar = new ak(LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_title_layout, viewGroup, false));
        a(akVar);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.k kVar, ak akVar) {
        super.onFillViewHolder(i, view, viewGroup, kVar, akVar);
        if (kVar != null && akVar != null) {
            switch (kVar.mType) {
                case 0:
                    akVar.ePH.setSelected(false);
                    akVar.ePH.setClickable(false);
                    akVar.ePH.setText(this.mContext.getString(d.l.god_reply));
                    akVar.evX.setVisibility(8);
                    akVar.ePI.setVisibility(8);
                    break;
                case 1:
                    akVar.ePH.setClickable(true);
                    akVar.ePH.setText(this.mContext.getString(d.l.all_reply));
                    akVar.evX.setVisibility(0);
                    akVar.ePI.setVisibility(0);
                    akVar.jE(kVar.eGv);
                    akVar.jD(kVar.aFX);
                    akVar.D(this.cNL);
                    break;
            }
        }
        a(akVar);
        return view;
    }

    private void a(ak akVar) {
        if (akVar != null) {
            if (akVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.c(akVar.ePH, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.k(akVar.cSQ, d.e.cp_bg_line_c);
            }
            akVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cNL = onClickListener;
    }
}
