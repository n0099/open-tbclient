package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.person.g;
import com.baidu.tieba.person.holder.i;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.c, i> {
    private TbPageContext bNR;
    private h eKv;
    protected int mSkinType;

    public l(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.bNR = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public i a(ViewGroup viewGroup) {
        return new i(LayoutInflater.from(this.mContext).inflate(r.h.personinfo_wallet_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, i iVar) {
        a(iVar, cVar);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.i.a.a(this.bNR, view);
        }
        return view;
    }

    private void a(i iVar, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            iVar.eLz.c(cVar.getIcon(), 10, false);
            iVar.btu.setText(cVar.getName());
            iVar.eLA.setText(cVar.aUL());
            this.eKv = new h(this.bNR);
            this.eKv.M(cVar.aUN());
            iVar.eLB.setAdapter((ListAdapter) this.eKv);
            iVar.eLy.setOnClickListener(new m(this, cVar));
            iVar.eLB.setOnItemClickListener(new n(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                bf.vP().c(this.bNR, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.f.a(this.bNR.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g.a aVar) {
        if (aVar.eKe) {
            aVar.eKe = false;
            this.eKv.notifyDataSetChanged();
            o<String> N = com.baidu.tbadk.core.b.a.tm().N("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount());
            if (N != null) {
                N.l(aVar.title, new StringBuilder(String.valueOf(aVar.At)).toString());
            }
        }
    }
}
