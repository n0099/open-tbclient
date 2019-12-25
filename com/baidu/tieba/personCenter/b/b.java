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
/* loaded from: classes6.dex */
public class b implements c.a {
    private PersonCenterModel jcw;
    private com.baidu.tieba.personCenter.view.c jcx;
    PersonCenterModel.a jcy = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.jcx.aZK();
            b.this.jcx.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jcw.mIsDataLoaded) {
                b.this.jcx.ao(i, str);
            } else {
                b.this.jcx.aZJ();
            }
        }
    };
    private CustomMessageListener jcz = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.jKk != null && bVar.jKk.size() > 0) {
                    b.a aVar = bVar.jKk.get(2);
                    b.a aVar2 = bVar.jKk.get(3);
                    b.a aVar3 = bVar.jKk.get(9);
                    b.a aVar4 = bVar.jKk.get(10);
                    if (b.this.jcw.csK() != null) {
                        if (aVar2 != null) {
                            b.this.jcw.csK().qR(aVar2.dBS);
                        }
                        if (aVar != null) {
                            b.this.jcw.csK().qU(aVar.dBS);
                        }
                        if (aVar3 != null) {
                            b.this.jcw.csK().qT(aVar3.dBS);
                        }
                        if (aVar4 != null) {
                            b.this.jcw.csK().qS(aVar4.dBS);
                        }
                    }
                    b.a aVar5 = bVar.jKk.get(5);
                    if (aVar5 != null) {
                        b.this.jcx.Q(5, aVar5.dBS);
                    }
                    b.a aVar6 = bVar.jKk.get(6);
                    if (aVar6 != null) {
                        b.this.jcx.Q(6, aVar6.dBS);
                    }
                    b.this.jcx.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dTz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.cBe().rT(false);
            }
        }
    };
    private CustomMessageListener jcA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null) {
                if (b.this.jcw.csK() != null) {
                    b.this.jcw.csK().a(mVar);
                    b.this.jcx.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jcx = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jcx.a(this);
        this.jcw = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jcw.a(this.jcy);
        com.baidu.tieba.o.a.cBe();
        this.jcz.setTag(bdUniqueId);
        this.dTz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jcz);
        MessageManager.getInstance().registerListener(this.dTz);
        this.jcA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jcA);
    }

    public void Gf(String str) {
        f csK = this.jcw.csK();
        if (csK != null && csK.getUserData() != null) {
            csK.getUserData().setName_show(str);
            this.jcx.notifyDataSetChanged();
        }
    }

    public void Gg(String str) {
        f csK = this.jcw.csK();
        if (csK != null && csK.getUserData() != null) {
            csK.getUserData().setPortrait(str);
            this.jcx.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.jcw.LoadData();
    }

    public void initView() {
        this.jcx.initView();
    }

    public void qQ(boolean z) {
        this.jcw.qQ(z);
    }

    public void onDestroy() {
        this.jcx.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jcx.onChangeSkinType(i);
    }

    public void csB() {
        this.jcx.csz();
    }

    public void csC() {
        this.jcx.csA();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cD(View view) {
        this.jcw.LoadData();
    }
}
