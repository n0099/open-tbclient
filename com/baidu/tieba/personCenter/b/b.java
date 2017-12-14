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
    private com.baidu.tieba.personCenter.view.c fsA;
    private PersonCenterModel fsz;
    PersonCenterModel.a fsB = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(com.baidu.tieba.personCenter.data.c cVar) {
            b.this.fsA.Pr();
            b.this.fsA.b(cVar);
            if (cVar != null && cVar.getUserData() != null) {
                f.a(cVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fsz.mIsDataLoaded) {
                b.this.fsA.aa(i, str);
            } else {
                b.this.fsA.QD();
            }
        }
    };
    private CustomMessageListener fsC = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gdF != null && bVar.gdF.size() > 0) {
                    b.a aVar = bVar.gdF.get(2);
                    b.a aVar2 = bVar.gdF.get(3);
                    b.a aVar3 = bVar.gdF.get(9);
                    if (b.this.fsz.baj() != null) {
                        if (aVar2 != null) {
                            b.this.fsz.baj().kB(aVar2.enN);
                        }
                        if (aVar != null) {
                            b.this.fsz.baj().kD(aVar.enN);
                        }
                        if (aVar3 != null) {
                            b.this.fsz.baj().kC(aVar3.enN);
                        }
                    }
                    b.a aVar4 = bVar.gdF.get(5);
                    if (aVar4 != null) {
                        b.this.fsA.z(5, aVar4.enN);
                    }
                    b.a aVar5 = bVar.gdF.get(6);
                    if (aVar5 != null) {
                        b.this.fsA.z(6, aVar5.enN);
                    }
                    b.this.fsA.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bbY = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.bmN().ml(false);
            }
        }
    };
    private CustomMessageListener fsD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null) {
                if (b.this.fsz.baj() != null) {
                    b.this.fsz.baj().setUserPendantData(kVar);
                    b.this.fsA.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fsA = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fsA.a(this);
        this.fsz = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fsz.a(this.fsB);
        com.baidu.tieba.m.a.bmN();
        this.fsC.setTag(bdUniqueId);
        this.bbY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fsC);
        MessageManager.getInstance().registerListener(this.bbY);
        this.fsD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fsD);
    }

    public void refreshView() {
        this.fsz.LoadData();
    }

    public void initView() {
        this.fsA.initView();
        this.fsz.LoadData();
    }

    public void onDestroy() {
        this.fsA.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fsA.onChangeSkinType(i);
    }

    public void baf() {
        this.fsA.bad();
    }

    public void bag() {
        this.fsA.bae();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bt(View view) {
        this.fsz.LoadData();
    }
}
