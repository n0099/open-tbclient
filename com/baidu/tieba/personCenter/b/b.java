package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.p.b;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes9.dex */
public class b implements c.a {
    private PersonCenterModel jSZ;
    private com.baidu.tieba.personCenter.view.c jTa;
    PersonCenterModel.a jTb = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.jTa.blr();
            b.this.jTa.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.cGc().fe(System.currentTimeMillis() - currentTimeMillis);
            long cGe = com.baidu.tieba.personCenter.a.cGc().cGe();
            if (cGe > 0) {
                com.baidu.tieba.personCenter.a.cGc().setRefreshTime(System.currentTimeMillis() - cGe);
                com.baidu.tieba.personCenter.a.cGc().ff(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jSZ.mIsDataLoaded) {
                b.this.jTa.aJ(i, str);
            } else {
                b.this.jTa.blq();
            }
        }
    };
    private CustomMessageListener jTc = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.kzV != null && bVar.kzV.size() > 0) {
                    b.a aVar = bVar.kzV.get(2);
                    b.a aVar2 = bVar.kzV.get(3);
                    b.a aVar3 = bVar.kzV.get(9);
                    b.a aVar4 = bVar.kzV.get(10);
                    if (b.this.jSZ.cGq() != null) {
                        if (aVar2 != null) {
                            b.this.jSZ.cGq().ss(aVar2.egw);
                        }
                        if (aVar != null) {
                            b.this.jSZ.cGq().sv(aVar.egw);
                        }
                        if (aVar3 != null) {
                            b.this.jSZ.cGq().su(aVar3.egw);
                        }
                        if (aVar4 != null) {
                            b.this.jSZ.cGq().st(aVar4.egw);
                        }
                    }
                    b.a aVar5 = bVar.kzV.get(5);
                    if (aVar5 != null) {
                        b.this.jTa.V(5, aVar5.egw);
                    }
                    b.a aVar6 = bVar.kzV.get(6);
                    if (aVar6 != null) {
                        b.this.jTa.V(6, aVar6.egw);
                    }
                    b.this.jTa.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eyt = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.cOJ().tp(false);
            }
        }
    };
    private CustomMessageListener jTd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null) {
                if (b.this.jSZ.cGq() != null) {
                    b.this.jSZ.cGq().a(kVar);
                    b.this.jTa.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jTa = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jTa.a(this);
        this.jSZ = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jSZ.a(this.jTb);
        com.baidu.tieba.p.a.cOJ();
        this.jTc.setTag(bdUniqueId);
        this.eyt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jTc);
        MessageManager.getInstance().registerListener(this.eyt);
        this.jTd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jTd);
    }

    public void Io(String str) {
        f cGq = this.jSZ.cGq();
        if (cGq != null && cGq.getUserData() != null) {
            cGq.getUserData().setName_show(str);
            this.jTa.notifyDataSetChanged();
        }
    }

    public void Ip(String str) {
        f cGq = this.jSZ.cGq();
        if (cGq != null && cGq.getUserData() != null) {
            cGq.getUserData().setPortrait(str);
            this.jTa.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.cGc().ff(System.currentTimeMillis());
        this.jSZ.LoadData();
    }

    public void initView() {
        this.jTa.initView();
    }

    public void sr(boolean z) {
        this.jSZ.sr(z);
    }

    public void onDestroy() {
        this.jTa.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jTa.onChangeSkinType(i);
    }

    public void cGh() {
        this.jTa.cGf();
    }

    public void cGi() {
        this.jTa.cGg();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cR(View view) {
        this.jSZ.LoadData();
    }
}
