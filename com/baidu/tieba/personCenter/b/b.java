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
    private PersonCenterModel mvK;
    private com.baidu.tieba.personCenter.view.c mvL;
    PersonCenterModel.a mvM = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.mvL.Xc();
            b.this.mvL.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dwJ().ht(System.currentTimeMillis() - currentTimeMillis);
            long dwL = com.baidu.tieba.personCenter.a.dwJ().dwL();
            if (dwL > 0) {
                com.baidu.tieba.personCenter.a.dwJ().setRefreshTime(System.currentTimeMillis() - dwL);
                com.baidu.tieba.personCenter.a.dwJ().hu(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.mvK.mIsDataLoaded) {
                b.this.mvL.bn(i, str);
            } else {
                b.this.mvL.bRH();
            }
        }
    };
    private CustomMessageListener mvN = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.nel != null && bVar.nel.size() > 0) {
                    b.a aVar = bVar.nel.get(2);
                    b.a aVar2 = bVar.nel.get(3);
                    b.a aVar3 = bVar.nel.get(9);
                    b.a aVar4 = bVar.nel.get(10);
                    if (b.this.mvK.dwZ() != null) {
                        if (aVar2 != null) {
                            b.this.mvK.dwZ().wG(aVar2.dtu);
                        }
                        if (aVar != null) {
                            b.this.mvK.dwZ().wJ(aVar.dtu);
                        }
                        if (aVar3 != null) {
                            b.this.mvK.dwZ().wI(aVar3.dtu);
                        }
                        if (aVar4 != null) {
                            b.this.mvK.dwZ().wH(aVar4.dtu);
                        }
                    }
                    b.a aVar5 = bVar.nel.get(5);
                    if (aVar5 != null) {
                        b.this.mvL.ae(5, aVar5.dtu);
                    }
                    b.a aVar6 = bVar.nel.get(6);
                    if (aVar6 != null) {
                        b.this.mvL.ae(6, aVar6.dtu);
                    }
                    b.this.mvL.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener ghH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dFm().xJ(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null) {
                if (b.this.mvK.dwZ() != null) {
                    b.this.mvK.dwZ().a(nVar);
                    b.this.mvL.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mvL = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.mvL.a(this);
        this.mvK = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.mvK.a(this.mvM);
        com.baidu.tieba.p.a.dFm();
        this.mvN.setTag(bdUniqueId);
        this.ghH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mvN);
        MessageManager.getInstance().registerListener(this.ghH);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Qq(String str) {
        f dwZ = this.mvK.dwZ();
        if (dwZ != null && dwZ.getUserData() != null) {
            dwZ.getUserData().setName_show(str);
            this.mvL.notifyDataSetChanged();
        }
    }

    public void Qr(String str) {
        f dwZ = this.mvK.dwZ();
        if (dwZ != null && dwZ.getUserData() != null) {
            dwZ.getUserData().setPortrait(str);
            this.mvL.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dwJ().hu(System.currentTimeMillis());
        this.mvK.LoadData();
    }

    public void initView() {
        this.mvL.initView();
    }

    public void wF(boolean z) {
        this.mvK.wF(z);
    }

    public void onDestroy() {
        this.mvL.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.mvL.onChangeSkinType(i);
    }

    public void dwQ() {
        this.mvL.dwO();
    }

    public void dwR() {
        this.mvL.dwP();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dV(View view) {
        this.mvK.LoadData();
    }
}
