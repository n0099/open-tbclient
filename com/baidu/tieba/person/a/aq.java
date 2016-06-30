package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.person.bs;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class aq extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.t, com.baidu.tieba.person.b.w> {
    private BaseFragmentActivity bfw;
    private am ehp;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public aq(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bfw = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public com.baidu.tieba.person.b.w a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.w(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_wallet_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.t tVar, com.baidu.tieba.person.b.w wVar) {
        if (this.aMF) {
            a(wVar, tVar);
            this.aMF = false;
            this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
            com.baidu.tbadk.j.a.a(this.bfw.getPageContext(), view);
        }
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.j.a.a(this.bfw.getPageContext(), view);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.w wVar, com.baidu.tieba.person.data.t tVar) {
        if (tVar != null) {
            if (!StringUtils.isNull(tVar.getIcon())) {
                wVar.emK.c(tVar.getIcon(), 10, false);
            } else {
                wVar.emK.c(null, 10, false);
            }
            wVar.bdG.setText(tVar.getName());
            wVar.emL.setText(tVar.aLp());
            this.ehp = new am(this.bfw.getPageContext());
            this.ehp.U(tVar.aLr());
            wVar.emM.setAdapter((ListAdapter) this.ehp);
            wVar.emJ.setOnClickListener(new ar(this, tVar));
            wVar.emM.setOnItemClickListener(new as(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                bi.us().c(this.bfw.getPageContext(), new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                f.a(this.bfw.getPageContext().getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bs.a aVar) {
        if (aVar.efy) {
            aVar.efy = false;
            this.ehp.notifyDataSetChanged();
            com.baidu.adp.lib.cache.o<String> N = com.baidu.tbadk.core.b.a.rP().N("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount());
            if (N != null) {
                N.f(aVar.title, new StringBuilder(String.valueOf(aVar.xF)).toString());
            }
        }
    }
}
