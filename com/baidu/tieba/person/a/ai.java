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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ai extends c<com.baidu.tieba.person.data.q, com.baidu.tieba.person.b.p> {
    private BaseFragmentActivity duj;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ai(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.duj = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.person.b.p b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.p(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_wallet_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.q qVar, com.baidu.tieba.person.b.p pVar) {
        if (this.bcn) {
            a(pVar, qVar);
            this.bcn = false;
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            com.baidu.tbadk.i.a.a(this.duj.getPageContext(), view);
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.i.a.a(this.duj.getPageContext(), view);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.p pVar, com.baidu.tieba.person.data.q qVar) {
        if (qVar != null) {
            if (!StringUtils.isNull(qVar.getIcon())) {
                pVar.dAJ.c(qVar.getIcon(), 10, false);
            } else {
                pVar.dAJ.c(null, 10, false);
            }
            pVar.dAK.setText(qVar.getName());
            pVar.dAL.setText(qVar.aBZ());
            af afVar = new af(this.duj.getPageContext());
            afVar.aw(qVar.aCb());
            pVar.dAM.setAdapter((ListAdapter) afVar);
            pVar.dAI.setOnClickListener(new aj(this, qVar));
            pVar.dAM.setOnItemClickListener(new ak(this, afVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                bg.wM().c(this.duj.getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.f.a(this.duj.getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }
}
