package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.j.b;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes.dex */
public class b implements c.a {
    private PersonCenterModel fiD;
    private com.baidu.tieba.personCenter.view.c fiE;
    PersonCenterModel.a fiF = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(com.baidu.tieba.personCenter.data.c cVar) {
            b.this.fiE.On();
            b.this.fiE.b(cVar);
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fiD.mIsDataLoaded) {
                b.this.fiE.U(i, str);
            } else {
                b.this.fiE.Pu();
            }
        }
    };
    private CustomMessageListener fiG = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                com.baidu.tieba.j.b bVar = (com.baidu.tieba.j.b) customResponsedMessage.getData();
                if (bVar.fRt != null && bVar.fRt.size() > 0) {
                    b.a aVar = bVar.fRt.get(2);
                    b.a aVar2 = bVar.fRt.get(3);
                    b.a aVar3 = bVar.fRt.get(9);
                    if (b.this.fiD.aYy() != null) {
                        if (aVar2 != null) {
                            b.this.fiD.aYy().kc(aVar2.egQ);
                        }
                        if (aVar != null) {
                            b.this.fiD.aYy().ke(aVar.egQ);
                        }
                        if (aVar3 != null) {
                            b.this.fiD.aYy().kd(aVar3.egQ);
                        }
                    }
                    b.a aVar4 = bVar.fRt.get(5);
                    if (aVar4 != null) {
                        b.this.fiE.A(5, aVar4.egQ);
                    }
                    b.a aVar5 = bVar.fRt.get(6);
                    if (aVar5 != null) {
                        b.this.fiE.A(6, aVar5.egQ);
                    }
                    b.this.fiE.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener aYL = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.j.a.bkh().lK(false);
            }
        }
    };
    private CustomMessageListener fiH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null) {
                if (b.this.fiD.aYy() != null) {
                    b.this.fiD.aYy().setUserPendantData(kVar);
                    b.this.fiE.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fiE = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fiE.a(this);
        this.fiD = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fiD.a(this.fiF);
        com.baidu.tieba.j.a.bkh();
        this.fiG.setTag(bdUniqueId);
        this.aYL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fiG);
        MessageManager.getInstance().registerListener(this.aYL);
        this.fiH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fiH);
    }

    public void refreshView() {
        this.fiD.LoadData();
    }

    public void initView() {
        this.fiE.initView();
        this.fiD.LoadData();
    }

    public void onDestroy() {
        this.fiE.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fiE.onChangeSkinType(i);
    }

    public void aYu() {
        this.fiE.aYs();
    }

    public void aYv() {
        this.fiE.aYt();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bv(View view) {
        this.fiD.LoadData();
    }
}
