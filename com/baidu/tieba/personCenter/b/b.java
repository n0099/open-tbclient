package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
import com.baidu.tieba.q.b;
/* loaded from: classes22.dex */
public class b implements c.a {
    private PersonCenterModel mjM;
    private com.baidu.tieba.personCenter.view.c mjN;
    PersonCenterModel.a mjO = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.mjN.Yb();
            b.this.mjN.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dyl().ht(System.currentTimeMillis() - currentTimeMillis);
            long dyn = com.baidu.tieba.personCenter.a.dyl().dyn();
            if (dyn > 0) {
                com.baidu.tieba.personCenter.a.dyl().setRefreshTime(System.currentTimeMillis() - dyn);
                com.baidu.tieba.personCenter.a.dyl().hu(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.mjM.mIsDataLoaded) {
                b.this.mjN.bf(i, str);
            } else {
                b.this.mjN.bSe();
            }
        }
    };
    private CustomMessageListener mjP = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.q.b)) {
                com.baidu.tieba.q.b bVar = (com.baidu.tieba.q.b) customResponsedMessage.getData();
                if (bVar.mRu != null && bVar.mRu.size() > 0) {
                    b.a aVar = bVar.mRu.get(2);
                    b.a aVar2 = bVar.mRu.get(3);
                    b.a aVar3 = bVar.mRu.get(9);
                    b.a aVar4 = bVar.mRu.get(10);
                    if (b.this.mjM.dyB() != null) {
                        if (aVar2 != null) {
                            b.this.mjM.dyB().ws(aVar2.dpw);
                        }
                        if (aVar != null) {
                            b.this.mjM.dyB().wv(aVar.dpw);
                        }
                        if (aVar3 != null) {
                            b.this.mjM.dyB().wu(aVar3.dpw);
                        }
                        if (aVar4 != null) {
                            b.this.mjM.dyB().wt(aVar4.dpw);
                        }
                    }
                    b.a aVar5 = bVar.mRu.get(5);
                    if (aVar5 != null) {
                        b.this.mjN.ag(5, aVar5.dpw);
                    }
                    b.a aVar6 = bVar.mRu.get(6);
                    if (aVar6 != null) {
                        b.this.mjN.ag(6, aVar6.dpw);
                    }
                    b.this.mjN.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fYK = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.q.a.dGN().xt(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null) {
                if (b.this.mjM.dyB() != null) {
                    b.this.mjM.dyB().a(nVar);
                    b.this.mjN.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mjN = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.mjN.a(this);
        this.mjM = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.mjM.a(this.mjO);
        com.baidu.tieba.q.a.dGN();
        this.mjP.setTag(bdUniqueId);
        this.fYK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mjP);
        MessageManager.getInstance().registerListener(this.fYK);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void QU(String str) {
        f dyB = this.mjM.dyB();
        if (dyB != null && dyB.getUserData() != null) {
            dyB.getUserData().setName_show(str);
            this.mjN.notifyDataSetChanged();
        }
    }

    public void QV(String str) {
        f dyB = this.mjM.dyB();
        if (dyB != null && dyB.getUserData() != null) {
            dyB.getUserData().setPortrait(str);
            this.mjN.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dyl().hu(System.currentTimeMillis());
        this.mjM.LoadData();
    }

    public void initView() {
        this.mjN.initView();
    }

    public void wr(boolean z) {
        this.mjM.wr(z);
    }

    public void onDestroy() {
        this.mjN.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.mjN.onChangeSkinType(i);
    }

    public void dys() {
        this.mjN.dyq();
    }

    public void dyt() {
        this.mjN.dyr();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dN(View view) {
        this.mjM.LoadData();
    }
}
