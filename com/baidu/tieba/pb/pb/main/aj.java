package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class aj extends l<com.baidu.tieba.pb.data.k, ak> {
    private View.OnClickListener cKt;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
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
                    akVar.eMy.setSelected(false);
                    akVar.eMy.setClickable(false);
                    akVar.eMy.setText(this.mContext.getString(d.l.god_reply));
                    akVar.esJ.setVisibility(8);
                    akVar.eMz.setVisibility(8);
                    break;
                case 1:
                    akVar.eMy.setClickable(true);
                    akVar.eMy.setText(this.mContext.getString(d.l.all_reply));
                    akVar.esJ.setVisibility(0);
                    akVar.eMz.setVisibility(0);
                    akVar.jB(kVar.eDm);
                    akVar.jA(kVar.aEF);
                    akVar.H(this.cKt);
                    break;
            }
        }
        a(akVar);
        return view;
    }

    private void a(ak akVar) {
        if (akVar != null) {
            if (akVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.c(akVar.eMy, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.k(akVar.cPy, d.e.cp_bg_line_c);
            }
            akVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cKt = onClickListener;
    }
}
