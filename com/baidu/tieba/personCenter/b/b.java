package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes4.dex */
public class b implements c.a {
    private PersonCenterModel ikD;
    private com.baidu.tieba.personCenter.view.c ikE;
    PersonCenterModel.a ikF = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.ikE.aJm();
            b.this.ikE.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.ikD.mIsDataLoaded) {
                b.this.ikE.Z(i, str);
            } else {
                b.this.ikE.aJl();
            }
        }
    };
    private CustomMessageListener ikG = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.iPR != null && bVar.iPR.size() > 0) {
                    b.a aVar = bVar.iPR.get(2);
                    b.a aVar2 = bVar.iPR.get(3);
                    b.a aVar3 = bVar.iPR.get(9);
                    b.a aVar4 = bVar.iPR.get(10);
                    if (b.this.ikD.bZs() != null) {
                        if (aVar2 != null) {
                            b.this.ikD.bZs().pp(aVar2.hjx);
                        }
                        if (aVar != null) {
                            b.this.ikD.bZs().ps(aVar.hjx);
                        }
                        if (aVar3 != null) {
                            b.this.ikD.bZs().pr(aVar3.hjx);
                        }
                        if (aVar4 != null) {
                            b.this.ikD.bZs().pq(aVar4.hjx);
                        }
                    }
                    b.a aVar5 = bVar.iPR.get(5);
                    if (aVar5 != null) {
                        b.this.ikE.O(5, aVar5.hjx);
                    }
                    b.a aVar6 = bVar.iPR.get(6);
                    if (aVar6 != null) {
                        b.this.ikE.O(6, aVar6.hjx);
                    }
                    b.this.ikE.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dfO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.chb().qk(false);
            }
        }
    };
    private CustomMessageListener ikH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.ikD.bZs() != null) {
                    b.this.ikD.bZs().a(lVar);
                    b.this.ikE.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ikE = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.ikE.a(this);
        this.ikD = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.ikD.a(this.ikF);
        com.baidu.tieba.o.a.chb();
        this.ikG.setTag(bdUniqueId);
        this.dfO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ikG);
        MessageManager.getInstance().registerListener(this.dfO);
        this.ikH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ikH);
    }

    public void Bu(String str) {
        f bZs = this.ikD.bZs();
        if (bZs != null && bZs.getUserData() != null) {
            bZs.getUserData().setName_show(str);
            this.ikE.notifyDataSetChanged();
        }
    }

    public void Bv(String str) {
        f bZs = this.ikD.bZs();
        if (bZs != null && bZs.getUserData() != null) {
            bZs.getUserData().setPortrait(str);
            this.ikE.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.ikD.LoadData();
    }

    public void initView() {
        this.ikE.initView();
    }

    public void po(boolean z) {
        this.ikD.po(z);
    }

    public void onDestroy() {
        this.ikE.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.ikE.onChangeSkinType(i);
    }

    public void bZj() {
        this.ikE.bZh();
    }

    public void bZk() {
        this.ikE.bZi();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cH(View view) {
        this.ikD.LoadData();
    }
}
