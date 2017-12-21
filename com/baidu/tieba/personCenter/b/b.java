package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.f;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.m.b;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes.dex */
public class b implements c.a {
    private PersonCenterModel fsE;
    private com.baidu.tieba.personCenter.view.c fsF;
    PersonCenterModel.a fsG = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(com.baidu.tieba.personCenter.data.c cVar) {
            b.this.fsF.Pr();
            b.this.fsF.b(cVar);
            if (cVar != null && cVar.getUserData() != null) {
                f.a(cVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fsE.mIsDataLoaded) {
                b.this.fsF.aa(i, str);
            } else {
                b.this.fsF.QD();
            }
        }
    };
    private CustomMessageListener fsH = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gdK != null && bVar.gdK.size() > 0) {
                    b.a aVar = bVar.gdK.get(2);
                    b.a aVar2 = bVar.gdK.get(3);
                    b.a aVar3 = bVar.gdK.get(9);
                    if (b.this.fsE.baj() != null) {
                        if (aVar2 != null) {
                            b.this.fsE.baj().kB(aVar2.enR);
                        }
                        if (aVar != null) {
                            b.this.fsE.baj().kD(aVar.enR);
                        }
                        if (aVar3 != null) {
                            b.this.fsE.baj().kC(aVar3.enR);
                        }
                    }
                    b.a aVar4 = bVar.gdK.get(5);
                    if (aVar4 != null) {
                        b.this.fsF.z(5, aVar4.enR);
                    }
                    b.a aVar5 = bVar.gdK.get(6);
                    if (aVar5 != null) {
                        b.this.fsF.z(6, aVar5.enR);
                    }
                    b.this.fsF.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bcc = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.bmN().ml(false);
            }
        }
    };
    private CustomMessageListener fsI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null) {
                if (b.this.fsE.baj() != null) {
                    b.this.fsE.baj().setUserPendantData(kVar);
                    b.this.fsF.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fsF = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fsF.a(this);
        this.fsE = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fsE.a(this.fsG);
        com.baidu.tieba.m.a.bmN();
        this.fsH.setTag(bdUniqueId);
        this.bcc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fsH);
        MessageManager.getInstance().registerListener(this.bcc);
        this.fsI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fsI);
    }

    public void refreshView() {
        this.fsE.LoadData();
    }

    public void initView() {
        this.fsF.initView();
        this.fsE.LoadData();
    }

    public void onDestroy() {
        this.fsF.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fsF.onChangeSkinType(i);
    }

    public void baf() {
        this.fsF.bad();
    }

    public void bag() {
        this.fsF.bae();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bu(View view) {
        this.fsE.LoadData();
    }
}
