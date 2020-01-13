package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes7.dex */
public class b implements c.a {
    private PersonCenterModel jfZ;
    private com.baidu.tieba.personCenter.view.c jga;
    PersonCenterModel.a jgb = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.jga.baf();
            b.this.jga.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jfZ.mIsDataLoaded) {
                b.this.jga.as(i, str);
            } else {
                b.this.jga.bae();
            }
        }
    };
    private CustomMessageListener jgc = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.jNM != null && bVar.jNM.size() > 0) {
                    b.a aVar = bVar.jNM.get(2);
                    b.a aVar2 = bVar.jNM.get(3);
                    b.a aVar3 = bVar.jNM.get(9);
                    b.a aVar4 = bVar.jNM.get(10);
                    if (b.this.jfZ.ctR() != null) {
                        if (aVar2 != null) {
                            b.this.jfZ.ctR().re(aVar2.dCc);
                        }
                        if (aVar != null) {
                            b.this.jfZ.ctR().rh(aVar.dCc);
                        }
                        if (aVar3 != null) {
                            b.this.jfZ.ctR().rg(aVar3.dCc);
                        }
                        if (aVar4 != null) {
                            b.this.jfZ.ctR().rf(aVar4.dCc);
                        }
                    }
                    b.a aVar5 = bVar.jNM.get(5);
                    if (aVar5 != null) {
                        b.this.jga.Q(5, aVar5.dCc);
                    }
                    b.a aVar6 = bVar.jNM.get(6);
                    if (aVar6 != null) {
                        b.this.jga.Q(6, aVar6.dCc);
                    }
                    b.this.jga.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dTI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.cCk().sf(false);
            }
        }
    };
    private CustomMessageListener jgd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.jfZ.ctR() != null) {
                    b.this.jfZ.ctR().a(mVar);
                    b.this.jga.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jga = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jga.a(this);
        this.jfZ = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jfZ.a(this.jgb);
        com.baidu.tieba.o.a.cCk();
        this.jgc.setTag(bdUniqueId);
        this.dTI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jgc);
        MessageManager.getInstance().registerListener(this.dTI);
        this.jgd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jgd);
    }

    public void Gp(String str) {
        f ctR = this.jfZ.ctR();
        if (ctR != null && ctR.getUserData() != null) {
            ctR.getUserData().setName_show(str);
            this.jga.notifyDataSetChanged();
        }
    }

    public void Gq(String str) {
        f ctR = this.jfZ.ctR();
        if (ctR != null && ctR.getUserData() != null) {
            ctR.getUserData().setPortrait(str);
            this.jga.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.jfZ.LoadData();
    }

    public void initView() {
        this.jga.initView();
    }

    public void rd(boolean z) {
        this.jfZ.rd(z);
    }

    public void onDestroy() {
        this.jga.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jga.onChangeSkinType(i);
    }

    public void ctI() {
        this.jga.ctG();
    }

    public void ctJ() {
        this.jga.ctH();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cI(View view) {
        this.jfZ.LoadData();
    }
}
