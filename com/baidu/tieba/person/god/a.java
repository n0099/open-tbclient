package com.baidu.tieba.person.god;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.a.o;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdUniqueId aTm;
    private List<com.baidu.adp.widget.ListView.a> bCN = new ArrayList();
    private CustomMessageListener bKG = new b(this, CmdConfigCustom.CMD_GOD_LIST_ADD_ADAPTER);
    private BdTypeListView bqG;
    private TbPageContext<?> dEt;
    public com.baidu.tieba.person.god.a.d epQ;
    public com.baidu.tieba.person.god.a.b epS;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        a(tbPageContext, bdTypeListView);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dEt = tbPageContext;
        this.aTm = tbPageContext.getUniqueId();
        this.bqG = bdTypeListView;
        this.epQ = new com.baidu.tieba.person.god.a.d(tbPageContext, o.aWx);
        this.epS = new com.baidu.tieba.person.god.a.b(tbPageContext, m.OB);
        this.bCN.add(this.epQ);
        this.bCN.add(this.epS);
        this.bKG.setPriority(1);
        this.bKG.setSelfListener(true);
        this.dEt.registerListener(this.bKG);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GOD_LIST_ADD_ADAPTER, new LinkedList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GOD_LIST_ADD_ADAPTER);
        customMessage.setTag(this.dEt.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        this.bqG.g(this.bCN);
        setPageUniqueId(this.aTm);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTm = bdUniqueId;
        if (this.epQ != null) {
            this.epQ.setPageUniqueId(bdUniqueId);
        }
        if (this.epQ != null) {
            this.epS.setPageUniqueId(bdUniqueId);
        }
    }

    public void cz(List<v> list) {
        if (list != null && this.bqG != null) {
            this.bqG.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bqG.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bqG.getAdapter()).notifyDataSetChanged();
        }
    }
}
