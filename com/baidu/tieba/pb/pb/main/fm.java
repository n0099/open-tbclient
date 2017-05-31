package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fm extends dn<com.baidu.tieba.pb.data.k, fn> {
    private View.OnClickListener cvw;

    /* JADX INFO: Access modifiers changed from: protected */
    public fm(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public fn onCreateViewHolder(ViewGroup viewGroup) {
        fn fnVar = new fn(LayoutInflater.from(this.mContext).inflate(w.j.pb_reply_title_layout, viewGroup, false));
        a(fnVar);
        return fnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.k kVar, fn fnVar) {
        super.onFillViewHolder(i, view, viewGroup, kVar, fnVar);
        if (kVar != null && fnVar != null) {
            switch (kVar.mType) {
                case 0:
                    fnVar.esf.setSelected(false);
                    fnVar.esf.setClickable(false);
                    fnVar.esf.setText(this.mContext.getString(w.l.god_reply));
                    fnVar.dYG.setVisibility(8);
                    fnVar.esg.setVisibility(8);
                    break;
                case 1:
                    fnVar.esf.setClickable(true);
                    fnVar.esf.setText(this.mContext.getString(w.l.all_reply));
                    fnVar.dYG.setVisibility(0);
                    fnVar.esg.setVisibility(0);
                    fnVar.iL(kVar.ejf);
                    fnVar.iK(kVar.aCC);
                    fnVar.I(this.cvw);
                    break;
            }
        }
        a(fnVar);
        return view;
    }

    private void a(fn fnVar) {
        if (fnVar != null) {
            if (fnVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.c(fnVar.esf, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aq.k(fnVar.bvl, w.e.cp_bg_line_c);
            }
            fnVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cvw = onClickListener;
    }
}
