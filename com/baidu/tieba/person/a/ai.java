package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ai extends c<com.baidu.tieba.person.data.q, com.baidu.tieba.person.b.p> {
    private BaseFragmentActivity cZG;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ai(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cZG = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
    public com.baidu.tieba.person.b.p b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.p(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_wallet_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.q qVar, com.baidu.tieba.person.b.p pVar) {
        if (this.aXE) {
            a(pVar, qVar);
            this.aXE = false;
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            com.baidu.tbadk.i.a.a(this.cZG.getPageContext(), view);
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.i.a.a(this.cZG.getPageContext(), view);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.p pVar, com.baidu.tieba.person.data.q qVar) {
        if (qVar != null) {
            if (!StringUtils.isNull(qVar.getIcon())) {
                pVar.dgk.d(qVar.getIcon(), 10, false);
            } else {
                pVar.dgk.d(null, 10, false);
            }
            pVar.dgl.setText(qVar.getName());
            pVar.dgm.setText(qVar.aut());
            af afVar = new af(this.cZG.getPageContext());
            afVar.as(qVar.auv());
            pVar.dgn.setAdapter((ListAdapter) afVar);
            pVar.dgj.setOnClickListener(new aj(this, qVar));
            pVar.dgn.setOnItemClickListener(new ak(this, afVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                be.wt().c(this.cZG.getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.f.a(this.cZG.getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }
}
