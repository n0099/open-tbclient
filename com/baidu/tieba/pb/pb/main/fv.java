package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fv extends du<com.baidu.tieba.pb.data.k, fw> {
    private View.OnClickListener cDj;

    /* JADX INFO: Access modifiers changed from: protected */
    public fv(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public fw onCreateViewHolder(ViewGroup viewGroup) {
        fw fwVar = new fw(LayoutInflater.from(this.mContext).inflate(w.j.pb_reply_title_layout, viewGroup, false));
        a(fwVar);
        return fwVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.k kVar, fw fwVar) {
        super.onFillViewHolder(i, view, viewGroup, kVar, fwVar);
        if (kVar != null && fwVar != null) {
            switch (kVar.mType) {
                case 0:
                    fwVar.eBq.setSelected(false);
                    fwVar.eBq.setClickable(false);
                    fwVar.eBq.setText(this.mContext.getString(w.l.god_reply));
                    fwVar.ehz.setVisibility(8);
                    fwVar.eBr.setVisibility(8);
                    break;
                case 1:
                    fwVar.eBq.setClickable(true);
                    fwVar.eBq.setText(this.mContext.getString(w.l.all_reply));
                    fwVar.ehz.setVisibility(0);
                    fwVar.eBr.setVisibility(0);
                    fwVar.jh(kVar.esd);
                    fwVar.jg(kVar.aDG);
                    fwVar.J(this.cDj);
                    break;
            }
        }
        a(fwVar);
        return view;
    }

    private void a(fw fwVar) {
        if (fwVar != null) {
            if (fwVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.as.c(fwVar.eBq, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.as.k(fwVar.dSM, w.e.cp_bg_line_c);
            }
            fwVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cDj = onClickListener;
    }
}
