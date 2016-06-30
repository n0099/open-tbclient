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
    private BdUniqueId aSq;
    private TbPageContext<?> bCb;
    private BdTypeListView bou;
    public com.baidu.tieba.person.god.a.d efR;
    public com.baidu.tieba.person.god.a.b efT;
    private List<com.baidu.adp.widget.ListView.a> bAz = new ArrayList();
    private CustomMessageListener bJb = new b(this, CmdConfigCustom.CMD_GOD_LIST_ADD_ADAPTER);

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        a(tbPageContext, bdTypeListView);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.bCb = tbPageContext;
        this.aSq = tbPageContext.getUniqueId();
        this.bou = bdTypeListView;
        this.efR = new com.baidu.tieba.person.god.a.d(tbPageContext, o.aVz);
        this.efT = new com.baidu.tieba.person.god.a.b(tbPageContext, m.Op);
        this.bAz.add(this.efR);
        this.bAz.add(this.efT);
        this.bJb.setPriority(1);
        this.bJb.setSelfListener(true);
        this.bCb.registerListener(this.bJb);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GOD_LIST_ADD_ADAPTER, new LinkedList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GOD_LIST_ADD_ADAPTER);
        customMessage.setTag(this.bCb.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        this.bou.g(this.bAz);
        setPageUniqueId(this.aSq);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSq = bdUniqueId;
        if (this.efR != null) {
            this.efR.setPageUniqueId(bdUniqueId);
        }
        if (this.efR != null) {
            this.efT.setPageUniqueId(bdUniqueId);
        }
    }

    public void cm(List<v> list) {
        if (list != null && this.bou != null) {
            this.bou.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bou.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bou.getAdapter()).notifyDataSetChanged();
        }
    }
}
