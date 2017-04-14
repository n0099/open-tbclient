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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.person.f;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.c, com.baidu.tieba.person.b.e> {
    private TbPageContext bID;
    private h ezJ;
    protected int mSkinType;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.bID = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public com.baidu.tieba.person.b.e onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.e(LayoutInflater.from(this.mContext).inflate(w.j.personinfo_wallet_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.c cVar, com.baidu.tieba.person.b.e eVar) {
        a(eVar, cVar);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.m.a.a(this.bID, view);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.e eVar, com.baidu.tieba.person.data.c cVar) {
        if (cVar != null) {
            eVar.eAk.c(cVar.getIcon(), 10, false);
            eVar.ceG.setText(cVar.getName());
            eVar.eAl.setText(cVar.aQm());
            this.ezJ = new h(this.bID);
            this.ezJ.aB(cVar.aQo());
            eVar.eAm.setAdapter((ListAdapter) this.ezJ);
            eVar.eAj.setOnClickListener(new j(this, cVar));
            eVar.eAm.setOnItemClickListener(new k(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                bb.wn().c(this.bID, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.f.b(this.bID.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.a aVar) {
        if (aVar.ezv) {
            aVar.ezv = false;
            this.ezJ.notifyDataSetChanged();
            o<String> M = com.baidu.tbadk.core.c.a.tM().M("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount());
            if (M != null) {
                M.l(aVar.title, new StringBuilder(String.valueOf(aVar.GX)).toString());
            }
        }
    }
}
