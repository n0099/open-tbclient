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
    private PersonCenterModel jSV;
    private com.baidu.tieba.personCenter.view.c jSW;
    PersonCenterModel.a jSX = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.jSW.blt();
            b.this.jSW.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.cGe().fe(System.currentTimeMillis() - currentTimeMillis);
            long cGg = com.baidu.tieba.personCenter.a.cGe().cGg();
            if (cGg > 0) {
                com.baidu.tieba.personCenter.a.cGe().setRefreshTime(System.currentTimeMillis() - cGg);
                com.baidu.tieba.personCenter.a.cGe().ff(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.jSV.mIsDataLoaded) {
                b.this.jSW.aJ(i, str);
            } else {
                b.this.jSW.bls();
            }
        }
    };
    private CustomMessageListener jSY = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.kzR != null && bVar.kzR.size() > 0) {
                    b.a aVar = bVar.kzR.get(2);
                    b.a aVar2 = bVar.kzR.get(3);
                    b.a aVar3 = bVar.kzR.get(9);
                    b.a aVar4 = bVar.kzR.get(10);
                    if (b.this.jSV.cGs() != null) {
                        if (aVar2 != null) {
                            b.this.jSV.cGs().ss(aVar2.egr);
                        }
                        if (aVar != null) {
                            b.this.jSV.cGs().sv(aVar.egr);
                        }
                        if (aVar3 != null) {
                            b.this.jSV.cGs().su(aVar3.egr);
                        }
                        if (aVar4 != null) {
                            b.this.jSV.cGs().st(aVar4.egr);
                        }
                    }
                    b.a aVar5 = bVar.kzR.get(5);
                    if (aVar5 != null) {
                        b.this.jSW.V(5, aVar5.egr);
                    }
                    b.a aVar6 = bVar.kzR.get(6);
                    if (aVar6 != null) {
                        b.this.jSW.V(6, aVar6.egr);
                    }
                    b.this.jSW.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener eyo = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.cOL().tp(false);
            }
        }
    };
    private CustomMessageListener jSZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null) {
                if (b.this.jSV.cGs() != null) {
                    b.this.jSV.cGs().a(kVar);
                    b.this.jSW.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jSW = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.jSW.a(this);
        this.jSV = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.jSV.a(this.jSX);
        com.baidu.tieba.p.a.cOL();
        this.jSY.setTag(bdUniqueId);
        this.eyo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jSY);
        MessageManager.getInstance().registerListener(this.eyo);
        this.jSZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.jSZ);
    }

    public void Il(String str) {
        f cGs = this.jSV.cGs();
        if (cGs != null && cGs.getUserData() != null) {
            cGs.getUserData().setName_show(str);
            this.jSW.notifyDataSetChanged();
        }
    }

    public void Im(String str) {
        f cGs = this.jSV.cGs();
        if (cGs != null && cGs.getUserData() != null) {
            cGs.getUserData().setPortrait(str);
            this.jSW.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.cGe().ff(System.currentTimeMillis());
        this.jSV.LoadData();
    }

    public void initView() {
        this.jSW.initView();
    }

    public void sr(boolean z) {
        this.jSV.sr(z);
    }

    public void onDestroy() {
        this.jSW.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.jSW.onChangeSkinType(i);
    }

    public void cGj() {
        this.jSW.cGh();
    }

    public void cGk() {
        this.jSW.cGi();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cR(View view) {
        this.jSV.LoadData();
    }
}
