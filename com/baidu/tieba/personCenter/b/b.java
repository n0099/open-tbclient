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
    private PersonCenterModel fig;
    private com.baidu.tieba.personCenter.view.c fih;
    PersonCenterModel.a fii = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(com.baidu.tieba.personCenter.data.c cVar) {
            b.this.fih.Oc();
            b.this.fih.b(cVar);
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fig.mIsDataLoaded) {
                b.this.fih.U(i, str);
            } else {
                b.this.fih.Pj();
            }
        }
    };
    private CustomMessageListener fij = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                com.baidu.tieba.j.b bVar = (com.baidu.tieba.j.b) customResponsedMessage.getData();
                if (bVar.fQr != null && bVar.fQr.size() > 0) {
                    b.a aVar = bVar.fQr.get(2);
                    b.a aVar2 = bVar.fQr.get(3);
                    if (b.this.fig.aYq() != null) {
                        if (aVar2 != null) {
                            b.this.fig.aYq().jW(aVar2.egM);
                        }
                        if (aVar != null) {
                            b.this.fig.aYq().jX(aVar.egM);
                        }
                    }
                    b.a aVar3 = bVar.fQr.get(5);
                    if (aVar3 != null) {
                        b.this.fih.z(5, aVar3.egM);
                    }
                    b.a aVar4 = bVar.fQr.get(6);
                    if (aVar4 != null) {
                        b.this.fih.z(6, aVar4.egM);
                    }
                    b.this.fih.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener aYC = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.j.a.bjW().lC(false);
            }
        }
    };
    private CustomMessageListener fik = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null) {
                if (b.this.fig.aYq() != null) {
                    b.this.fig.aYq().setUserPendantData(kVar);
                    b.this.fih.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fih = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fih.a(this);
        this.fig = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fig.a(this.fii);
        com.baidu.tieba.j.a.bjW();
        this.fij.setTag(bdUniqueId);
        this.aYC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fij);
        MessageManager.getInstance().registerListener(this.aYC);
        this.fik.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fik);
    }

    public void refreshView() {
        this.fig.LoadData();
    }

    public void initView() {
        this.fih.initView();
        this.fig.LoadData();
    }

    public void onDestroy() {
        this.fih.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fih.onChangeSkinType(i);
    }

    public void aYm() {
        this.fih.aYk();
    }

    public void aYn() {
        this.fih.aYl();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bu(View view) {
        this.fig.LoadData();
    }
}
