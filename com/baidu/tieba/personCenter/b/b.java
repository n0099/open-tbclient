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
import com.baidu.tieba.p.b;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes2.dex */
public class b implements c.a {
    private PersonCenterModel mtI;
    private com.baidu.tieba.personCenter.view.c mtJ;
    PersonCenterModel.a mtK = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.mtJ.WZ();
            b.this.mtJ.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dwA().ht(System.currentTimeMillis() - currentTimeMillis);
            long dwC = com.baidu.tieba.personCenter.a.dwA().dwC();
            if (dwC > 0) {
                com.baidu.tieba.personCenter.a.dwA().setRefreshTime(System.currentTimeMillis() - dwC);
                com.baidu.tieba.personCenter.a.dwA().hu(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.mtI.mIsDataLoaded) {
                b.this.mtJ.bn(i, str);
            } else {
                b.this.mtJ.bRB();
            }
        }
    };
    private CustomMessageListener mtL = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.nch != null && bVar.nch.size() > 0) {
                    b.a aVar = bVar.nch.get(2);
                    b.a aVar2 = bVar.nch.get(3);
                    b.a aVar3 = bVar.nch.get(9);
                    b.a aVar4 = bVar.nch.get(10);
                    if (b.this.mtI.dwQ() != null) {
                        if (aVar2 != null) {
                            b.this.mtI.dwQ().wG(aVar2.drR);
                        }
                        if (aVar != null) {
                            b.this.mtI.dwQ().wJ(aVar.drR);
                        }
                        if (aVar3 != null) {
                            b.this.mtI.dwQ().wI(aVar3.drR);
                        }
                        if (aVar4 != null) {
                            b.this.mtI.dwQ().wH(aVar4.drR);
                        }
                    }
                    b.a aVar5 = bVar.nch.get(5);
                    if (aVar5 != null) {
                        b.this.mtJ.ae(5, aVar5.drR);
                    }
                    b.a aVar6 = bVar.nch.get(6);
                    if (aVar6 != null) {
                        b.this.mtJ.ae(6, aVar6.drR);
                    }
                    b.this.mtJ.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener gge = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dFe().xJ(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null) {
                if (b.this.mtI.dwQ() != null) {
                    b.this.mtI.dwQ().a(nVar);
                    b.this.mtJ.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mtJ = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.mtJ.a(this);
        this.mtI = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.mtI.a(this.mtK);
        com.baidu.tieba.p.a.dFe();
        this.mtL.setTag(bdUniqueId);
        this.gge.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mtL);
        MessageManager.getInstance().registerListener(this.gge);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Qk(String str) {
        f dwQ = this.mtI.dwQ();
        if (dwQ != null && dwQ.getUserData() != null) {
            dwQ.getUserData().setName_show(str);
            this.mtJ.notifyDataSetChanged();
        }
    }

    public void Ql(String str) {
        f dwQ = this.mtI.dwQ();
        if (dwQ != null && dwQ.getUserData() != null) {
            dwQ.getUserData().setPortrait(str);
            this.mtJ.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dwA().hu(System.currentTimeMillis());
        this.mtI.LoadData();
    }

    public void initView() {
        this.mtJ.initView();
    }

    public void wF(boolean z) {
        this.mtI.wF(z);
    }

    public void onDestroy() {
        this.mtJ.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.mtJ.onChangeSkinType(i);
    }

    public void dwH() {
        this.mtJ.dwF();
    }

    public void dwI() {
        this.mtJ.dwG();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dV(View view) {
        this.mtI.LoadData();
    }
}
