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
    private PersonCenterModel mjO;
    private com.baidu.tieba.personCenter.view.c mjP;
    PersonCenterModel.a mjQ = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.mjP.Yb();
            b.this.mjP.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dym().ht(System.currentTimeMillis() - currentTimeMillis);
            long dyo = com.baidu.tieba.personCenter.a.dym().dyo();
            if (dyo > 0) {
                com.baidu.tieba.personCenter.a.dym().setRefreshTime(System.currentTimeMillis() - dyo);
                com.baidu.tieba.personCenter.a.dym().hu(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.mjO.mIsDataLoaded) {
                b.this.mjP.bf(i, str);
            } else {
                b.this.mjP.bSf();
            }
        }
    };
    private CustomMessageListener mjR = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.q.b)) {
                com.baidu.tieba.q.b bVar = (com.baidu.tieba.q.b) customResponsedMessage.getData();
                if (bVar.mRw != null && bVar.mRw.size() > 0) {
                    b.a aVar = bVar.mRw.get(2);
                    b.a aVar2 = bVar.mRw.get(3);
                    b.a aVar3 = bVar.mRw.get(9);
                    b.a aVar4 = bVar.mRw.get(10);
                    if (b.this.mjO.dyC() != null) {
                        if (aVar2 != null) {
                            b.this.mjO.dyC().ws(aVar2.dpw);
                        }
                        if (aVar != null) {
                            b.this.mjO.dyC().wv(aVar.dpw);
                        }
                        if (aVar3 != null) {
                            b.this.mjO.dyC().wu(aVar3.dpw);
                        }
                        if (aVar4 != null) {
                            b.this.mjO.dyC().wt(aVar4.dpw);
                        }
                    }
                    b.a aVar5 = bVar.mRw.get(5);
                    if (aVar5 != null) {
                        b.this.mjP.ag(5, aVar5.dpw);
                    }
                    b.a aVar6 = bVar.mRw.get(6);
                    if (aVar6 != null) {
                        b.this.mjP.ag(6, aVar6.dpw);
                    }
                    b.this.mjP.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener fYM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.q.a.dGO().xt(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null) {
                if (b.this.mjO.dyC() != null) {
                    b.this.mjO.dyC().a(nVar);
                    b.this.mjP.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mjP = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.mjP.a(this);
        this.mjO = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.mjO.a(this.mjQ);
        com.baidu.tieba.q.a.dGO();
        this.mjR.setTag(bdUniqueId);
        this.fYM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mjR);
        MessageManager.getInstance().registerListener(this.fYM);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void QU(String str) {
        f dyC = this.mjO.dyC();
        if (dyC != null && dyC.getUserData() != null) {
            dyC.getUserData().setName_show(str);
            this.mjP.notifyDataSetChanged();
        }
    }

    public void QV(String str) {
        f dyC = this.mjO.dyC();
        if (dyC != null && dyC.getUserData() != null) {
            dyC.getUserData().setPortrait(str);
            this.mjP.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dym().hu(System.currentTimeMillis());
        this.mjO.LoadData();
    }

    public void initView() {
        this.mjP.initView();
    }

    public void wr(boolean z) {
        this.mjO.wr(z);
    }

    public void onDestroy() {
        this.mjP.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.mjP.onChangeSkinType(i);
    }

    public void dyt() {
        this.mjP.dyr();
    }

    public void dyu() {
        this.mjP.dys();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dN(View view) {
        this.mjO.LoadData();
    }
}
