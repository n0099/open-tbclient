package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fd extends dh<com.baidu.tieba.pb.data.j, fe> {
    private View.OnClickListener coZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public fd(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public fe onCreateViewHolder(ViewGroup viewGroup) {
        fe feVar = new fe(LayoutInflater.from(this.mContext).inflate(w.j.pb_reply_title_layout, viewGroup, false));
        a(feVar);
        return feVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, fe feVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, feVar);
        if (jVar != null && feVar != null) {
            switch (jVar.mType) {
                case 0:
                    feVar.ems.setSelected(false);
                    feVar.ems.setClickable(false);
                    feVar.ems.setText(this.mContext.getString(w.l.god_reply));
                    feVar.dTl.setVisibility(8);
                    feVar.emt.setVisibility(8);
                    break;
                case 1:
                    feVar.ems.setClickable(true);
                    feVar.ems.setText(this.mContext.getString(w.l.all_reply));
                    feVar.dTl.setVisibility(0);
                    feVar.emt.setVisibility(0);
                    feVar.iv(jVar.edF);
                    feVar.iu(jVar.aCP);
                    feVar.I(this.coZ);
                    break;
            }
        }
        a(feVar);
        return view;
    }

    private void a(fe feVar) {
        if (feVar != null) {
            if (feVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.c(feVar.ems, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aq.k(feVar.dES, w.e.cp_bg_line_c);
            }
            feVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.coZ = onClickListener;
    }
}
