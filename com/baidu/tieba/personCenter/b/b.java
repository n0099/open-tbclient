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
    private PersonCenterModel mtt;
    private com.baidu.tieba.personCenter.view.c mtu;
    PersonCenterModel.a mtv = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.mtu.WZ();
            b.this.mtu.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.dwt().ht(System.currentTimeMillis() - currentTimeMillis);
            long dwv = com.baidu.tieba.personCenter.a.dwt().dwv();
            if (dwv > 0) {
                com.baidu.tieba.personCenter.a.dwt().setRefreshTime(System.currentTimeMillis() - dwv);
                com.baidu.tieba.personCenter.a.dwt().hu(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.mtt.mIsDataLoaded) {
                b.this.mtu.bn(i, str);
            } else {
                b.this.mtu.bRu();
            }
        }
    };
    private CustomMessageListener mtw = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.nbH != null && bVar.nbH.size() > 0) {
                    b.a aVar = bVar.nbH.get(2);
                    b.a aVar2 = bVar.nbH.get(3);
                    b.a aVar3 = bVar.nbH.get(9);
                    b.a aVar4 = bVar.nbH.get(10);
                    if (b.this.mtt.dwJ() != null) {
                        if (aVar2 != null) {
                            b.this.mtt.dwJ().wG(aVar2.drR);
                        }
                        if (aVar != null) {
                            b.this.mtt.dwJ().wJ(aVar.drR);
                        }
                        if (aVar3 != null) {
                            b.this.mtt.dwJ().wI(aVar3.drR);
                        }
                        if (aVar4 != null) {
                            b.this.mtt.dwJ().wH(aVar4.drR);
                        }
                    }
                    b.a aVar5 = bVar.nbH.get(5);
                    if (aVar5 != null) {
                        b.this.mtu.ae(5, aVar5.drR);
                    }
                    b.a aVar6 = bVar.nbH.get(6);
                    if (aVar6 != null) {
                        b.this.mtu.ae(6, aVar6.drR);
                    }
                    b.this.mtu.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener gfZ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dEW().xJ(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null) {
                if (b.this.mtt.dwJ() != null) {
                    b.this.mtt.dwJ().a(nVar);
                    b.this.mtu.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mtu = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.mtu.a(this);
        this.mtt = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.mtt.a(this.mtv);
        com.baidu.tieba.p.a.dEW();
        this.mtw.setTag(bdUniqueId);
        this.gfZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mtw);
        MessageManager.getInstance().registerListener(this.gfZ);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Qj(String str) {
        f dwJ = this.mtt.dwJ();
        if (dwJ != null && dwJ.getUserData() != null) {
            dwJ.getUserData().setName_show(str);
            this.mtu.notifyDataSetChanged();
        }
    }

    public void Qk(String str) {
        f dwJ = this.mtt.dwJ();
        if (dwJ != null && dwJ.getUserData() != null) {
            dwJ.getUserData().setPortrait(str);
            this.mtu.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.dwt().hu(System.currentTimeMillis());
        this.mtt.LoadData();
    }

    public void initView() {
        this.mtu.initView();
    }

    public void wF(boolean z) {
        this.mtt.wF(z);
    }

    public void onDestroy() {
        this.mtu.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.mtu.onChangeSkinType(i);
    }

    public void dwA() {
        this.mtu.dwy();
    }

    public void dwB() {
        this.mtu.dwz();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dV(View view) {
        this.mtt.LoadData();
    }
}
