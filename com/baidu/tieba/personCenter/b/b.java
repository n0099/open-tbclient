package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.m.b;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes.dex */
public class b implements c.a {
    private PersonCenterModel frA;
    private com.baidu.tieba.personCenter.view.c frB;
    PersonCenterModel.a frC = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(com.baidu.tieba.personCenter.data.c cVar) {
            b.this.frB.Pr();
            b.this.frB.b(cVar);
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.frA.mIsDataLoaded) {
                b.this.frB.aa(i, str);
            } else {
                b.this.frB.QD();
            }
        }
    };
    private CustomMessageListener frD = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gaZ != null && bVar.gaZ.size() > 0) {
                    b.a aVar = bVar.gaZ.get(2);
                    b.a aVar2 = bVar.gaZ.get(3);
                    b.a aVar3 = bVar.gaZ.get(9);
                    if (b.this.frA.baa() != null) {
                        if (aVar2 != null) {
                            b.this.frA.baa().kA(aVar2.emH);
                        }
                        if (aVar != null) {
                            b.this.frA.baa().kC(aVar.emH);
                        }
                        if (aVar3 != null) {
                            b.this.frA.baa().kB(aVar3.emH);
                        }
                    }
                    b.a aVar4 = bVar.gaZ.get(5);
                    if (aVar4 != null) {
                        b.this.frB.z(5, aVar4.emH);
                    }
                    b.a aVar5 = bVar.gaZ.get(6);
                    if (aVar5 != null) {
                        b.this.frB.z(6, aVar5.emH);
                    }
                    b.this.frB.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bbX = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.bmh().mj(false);
            }
        }
    };
    private CustomMessageListener frE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null) {
                if (b.this.frA.baa() != null) {
                    b.this.frA.baa().setUserPendantData(kVar);
                    b.this.frB.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.frB = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.frB.a(this);
        this.frA = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.frA.a(this.frC);
        com.baidu.tieba.m.a.bmh();
        this.frD.setTag(bdUniqueId);
        this.bbX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.frD);
        MessageManager.getInstance().registerListener(this.bbX);
        this.frE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.frE);
    }

    public void refreshView() {
        this.frA.LoadData();
    }

    public void initView() {
        this.frB.initView();
        this.frA.LoadData();
    }

    public void onDestroy() {
        this.frB.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.frB.onChangeSkinType(i);
    }

    public void aZW() {
        this.frB.aZU();
    }

    public void aZX() {
        this.frB.aZV();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bq(View view) {
        this.frA.LoadData();
    }
}
