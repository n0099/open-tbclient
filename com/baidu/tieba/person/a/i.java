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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.person.f;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.c, com.baidu.tieba.person.holder.f> {
    private TbPageContext bBE;
    private h eyd;
    protected int mSkinType;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.bBE = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public com.baidu.tieba.person.holder.f onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.f(LayoutInflater.from(this.mContext).inflate(r.j.personinfo_wallet_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.holder.f fVar) {
        a(fVar, cVar);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.i.a.a(this.bBE, view);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.f fVar, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            fVar.eyQ.c(cVar.getIcon(), 10, false);
            fVar.bYK.setText(cVar.getName());
            fVar.eyR.setText(cVar.aQA());
            this.eyd = new h(this.bBE);
            this.eyd.aK(cVar.aQC());
            fVar.eyS.setAdapter((ListAdapter) this.eyd);
            fVar.eyP.setOnClickListener(new j(this, cVar));
            fVar.eyS.setOnItemClickListener(new k(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oI(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                ba.vt().c(this.bBE, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.f.a(this.bBE.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.a aVar) {
        if (aVar.exP) {
            aVar.exP = false;
            this.eyd.notifyDataSetChanged();
            o<String> N = com.baidu.tbadk.core.c.a.sR().N("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount());
            if (N != null) {
                N.l(aVar.title, new StringBuilder(String.valueOf(aVar.Aj)).toString());
            }
        }
    }
}
