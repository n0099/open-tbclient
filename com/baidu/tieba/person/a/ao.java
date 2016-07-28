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
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.person.f;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ao extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.s, com.baidu.tieba.person.holder.w> {
    private BaseFragmentActivity bgI;
    private ak ero;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public com.baidu.tieba.person.holder.w a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.w(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_wallet_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.s sVar, com.baidu.tieba.person.holder.w wVar) {
        if (this.aNz) {
            a(wVar, sVar);
            this.aNz = false;
            this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
            com.baidu.tbadk.j.a.a(this.bgI.getPageContext(), view);
        }
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.j.a.a(this.bgI.getPageContext(), view);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.w wVar, com.baidu.tieba.person.data.s sVar) {
        if (sVar != null) {
            if (!StringUtils.isNull(sVar.getIcon())) {
                wVar.exj.c(sVar.getIcon(), 10, false);
            } else {
                wVar.exj.c(null, 10, false);
            }
            wVar.beS.setText(sVar.getName());
            wVar.exk.setText(sVar.aNS());
            this.ero = new ak(this.bgI.getPageContext());
            this.ero.U(sVar.aNU());
            wVar.exl.setAdapter((ListAdapter) this.ero);
            wVar.exi.setOnClickListener(new ap(this, sVar));
            wVar.exl.setOnItemClickListener(new aq(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                bi.us().c(this.bgI.getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.f.a(this.bgI.getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.a aVar) {
        if (aVar.epy) {
            aVar.epy = false;
            this.ero.notifyDataSetChanged();
            com.baidu.adp.lib.cache.o<String> N = com.baidu.tbadk.core.b.a.rO().N("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount());
            if (N != null) {
                N.l(aVar.title, new StringBuilder(String.valueOf(aVar.yg)).toString());
            }
        }
    }
}
