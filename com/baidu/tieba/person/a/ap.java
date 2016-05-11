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
public class ap extends c<com.baidu.tieba.person.data.t, com.baidu.tieba.person.b.s> {
    private BaseFragmentActivity cSp;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ap(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cSp = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public com.baidu.tieba.person.b.s b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.s(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_wallet_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.t tVar, com.baidu.tieba.person.b.s sVar) {
        if (this.bUL) {
            a(sVar, tVar);
            this.bUL = false;
            this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
            com.baidu.tbadk.i.a.a(this.cSp.getPageContext(), view);
        }
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.i.a.a(this.cSp.getPageContext(), view);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.s sVar, com.baidu.tieba.person.data.t tVar) {
        if (tVar != null) {
            if (!StringUtils.isNull(tVar.getIcon())) {
                sVar.dDR.c(tVar.getIcon(), 10, false);
            } else {
                sVar.dDR.c(null, 10, false);
            }
            sVar.bxj.setText(tVar.getName());
            sVar.dDS.setText(tVar.aCt());
            am amVar = new am(this.cSp.getPageContext());
            amVar.au(tVar.aCv());
            sVar.dDT.setAdapter((ListAdapter) amVar);
            sVar.dDQ.setOnClickListener(new aq(this, tVar));
            sVar.dDT.setOnItemClickListener(new ar(this, amVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mt(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                bg.us().c(this.cSp.getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.f.a(this.cSp.getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }
}
