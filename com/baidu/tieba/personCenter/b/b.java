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
    private PersonCenterModel jge;
    private com.baidu.tieba.personCenter.view.c jgf;
    PersonCenterModel.a jgg = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.jgf.baf();
            b.this.jgf.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jge.mIsDataLoaded) {
                b.this.jgf.as(i, str);
            } else {
                b.this.jgf.bae();
            }
        }
    };
    private CustomMessageListener jgh = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.jNR != null && bVar.jNR.size() > 0) {
                    b.a aVar = bVar.jNR.get(2);
                    b.a aVar2 = bVar.jNR.get(3);
                    b.a aVar3 = bVar.jNR.get(9);
                    b.a aVar4 = bVar.jNR.get(10);
                    if (b.this.jge.ctT() != null) {
                        if (aVar2 != null) {
                            b.this.jge.ctT().re(aVar2.dCc);
                        }
                        if (aVar != null) {
                            b.this.jge.ctT().rh(aVar.dCc);
                        }
                        if (aVar3 != null) {
                            b.this.jge.ctT().rg(aVar3.dCc);
                        }
                        if (aVar4 != null) {
                            b.this.jge.ctT().rf(aVar4.dCc);
                        }
                    }
                    b.a aVar5 = bVar.jNR.get(5);
                    if (aVar5 != null) {
                        b.this.jgf.Q(5, aVar5.dCc);
                    }
                    b.a aVar6 = bVar.jNR.get(6);
                    if (aVar6 != null) {
                        b.this.jgf.Q(6, aVar6.dCc);
                    }
                    b.this.jgf.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dTI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.cCm().sf(false);
            }
        }
    };
    private CustomMessageListener jgi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.jge.ctT() != null) {
                    b.this.jge.ctT().a(mVar);
                    b.this.jgf.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jgf = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jgf.a(this);
        this.jge = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jge.a(this.jgg);
        com.baidu.tieba.o.a.cCm();
        this.jgh.setTag(bdUniqueId);
        this.dTI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jgh);
        MessageManager.getInstance().registerListener(this.dTI);
        this.jgi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jgi);
    }

    public void Gp(String str) {
        f ctT = this.jge.ctT();
        if (ctT != null && ctT.getUserData() != null) {
            ctT.getUserData().setName_show(str);
            this.jgf.notifyDataSetChanged();
        }
    }

    public void Gq(String str) {
        f ctT = this.jge.ctT();
        if (ctT != null && ctT.getUserData() != null) {
            ctT.getUserData().setPortrait(str);
            this.jgf.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.jge.LoadData();
    }

    public void initView() {
        this.jgf.initView();
    }

    public void rd(boolean z) {
        this.jge.rd(z);
    }

    public void onDestroy() {
        this.jgf.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jgf.onChangeSkinType(i);
    }

    public void ctK() {
        this.jgf.ctI();
    }

    public void ctL() {
        this.jgf.ctJ();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cI(View view) {
        this.jge.LoadData();
    }
}
