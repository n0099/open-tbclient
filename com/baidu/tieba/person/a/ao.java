package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ao extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.n, com.baidu.tieba.person.b.b> {
    private BaseFragmentActivity bfw;
    private boolean chd;
    private String ehl;
    private String ehm;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.chd = false;
        this.ehl = "c10433";
        this.ehm = "c10434";
        this.bfw = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bK */
    public com.baidu.tieba.person.b.b a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.b(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_card_membership, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.n nVar, com.baidu.tieba.person.b.b bVar) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.aMF) {
            a(bVar, nVar);
            this.aMF = false;
        }
        com.baidu.tbadk.j.a.a(this.bfw.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.b bVar, com.baidu.tieba.person.data.n nVar) {
        if (nVar != null) {
            LinearLayout linearLayout = (LinearLayout) bVar.getView();
            this.chd = nVar.chd;
            if (this.chd) {
                bVar.ejJ.setVisibility(0);
                bVar.ejJ.c(nVar.mVipIcon, 10, false);
                bVar.ejK.setText(nVar.mTitle);
                if (!StringUtils.isNull(nVar.mContent)) {
                    bVar.ejL.setText(nVar.mContent);
                }
            } else {
                linearLayout.setVisibility(8);
            }
            linearLayout.setOnClickListener(new ap(this, nVar));
        }
    }
}
