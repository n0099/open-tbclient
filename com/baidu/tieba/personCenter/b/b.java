package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.i;
import com.baidu.tieba.j.b;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes.dex */
public class b implements c.a {
    private PersonCenterModel eZQ;
    private com.baidu.tieba.personCenter.view.c eZR;
    PersonCenterModel.a eZS = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(com.baidu.tieba.personCenter.c.c cVar) {
            b.this.eZR.NW();
            b.this.eZR.b(cVar);
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.eZQ.mIsDataLoaded) {
                b.this.eZR.S(i, str);
            } else {
                b.this.eZR.OZ();
            }
        }
    };
    private CustomMessageListener eZT = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                com.baidu.tieba.j.b bVar = (com.baidu.tieba.j.b) customResponsedMessage.getData();
                if (bVar.fHC != null && bVar.fHC.size() > 0) {
                    b.a aVar = bVar.fHC.get(2);
                    b.a aVar2 = bVar.fHC.get(3);
                    if (b.this.eZQ.aVn() != null) {
                        if (aVar2 != null) {
                            b.this.eZQ.aVn().kc(aVar2.dZb);
                        }
                        if (aVar != null) {
                            b.this.eZQ.aVn().kd(aVar.dZb);
                        }
                    }
                    b.a aVar3 = bVar.fHC.get(5);
                    if (aVar3 != null) {
                        b.this.eZR.y(5, aVar3.dZb);
                    }
                    b.a aVar4 = bVar.fHC.get(6);
                    if (aVar4 != null) {
                        b.this.eZR.y(6, aVar4.dZb);
                    }
                    b.this.eZR.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener aYm = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.j.a.bgJ().lH(false);
            }
        }
    };
    private CustomMessageListener eZU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null) {
                if (b.this.eZQ.aVn() != null) {
                    b.this.eZQ.aVn().setUserPendantData(iVar);
                    b.this.eZR.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eZR = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.eZR.a(this);
        this.eZQ = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.eZQ.a(this.eZS);
        com.baidu.tieba.j.a.bgJ();
        this.eZT.setTag(bdUniqueId);
        this.aYm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eZT);
        MessageManager.getInstance().registerListener(this.aYm);
        this.eZU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eZU);
    }

    public void refreshView() {
        this.eZQ.LoadData();
    }

    public void initView() {
        this.eZR.initView();
        this.eZQ.LoadData();
    }

    public void onDestroy() {
        this.eZR.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.eZR.onChangeSkinType(i);
    }

    public void aVj() {
        this.eZR.aVh();
    }

    public void aVk() {
        this.eZR.aVi();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void br(View view) {
        this.eZQ.LoadData();
    }
}
