package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.f;
import com.baidu.tbadk.data.h;
import com.baidu.tieba.m.b;
import com.baidu.tieba.personCenter.data.d;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes.dex */
public class b implements c.a {
    private PersonCenterModel gjk;
    private com.baidu.tieba.personCenter.view.c gjl;
    PersonCenterModel.a gjm = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.gjl.XN();
            b.this.gjl.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gjk.mIsDataLoaded) {
                b.this.gjl.ac(i, str);
            } else {
                b.this.gjl.XM();
            }
        }
    };
    private CustomMessageListener gjn = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gJU != null && bVar.gJU.size() > 0) {
                    b.a aVar = bVar.gJU.get(2);
                    b.a aVar2 = bVar.gJU.get(3);
                    b.a aVar3 = bVar.gJU.get(9);
                    b.a aVar4 = bVar.gJU.get(10);
                    if (b.this.gjk.biM() != null) {
                        if (aVar2 != null) {
                            b.this.gjk.biM().lv(aVar2.fgi);
                        }
                        if (aVar != null) {
                            b.this.gjk.biM().ly(aVar.fgi);
                        }
                        if (aVar3 != null) {
                            b.this.gjk.biM().lx(aVar3.fgi);
                        }
                        if (aVar4 != null) {
                            b.this.gjk.biM().lw(aVar4.fgi);
                        }
                    }
                    b.a aVar5 = bVar.gJU.get(5);
                    if (aVar5 != null) {
                        b.this.gjl.Q(5, aVar5.fgi);
                    }
                    b.a aVar6 = bVar.gJU.get(6);
                    if (aVar6 != null) {
                        b.this.gjl.Q(6, aVar6.fgi);
                    }
                    b.this.gjl.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bSc = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.bpm().mh(false);
            }
        }
    };
    private CustomMessageListener gjo = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.gjk.biM() != null) {
                    b.this.gjk.biM().setUserPendantData(hVar);
                    b.this.gjl.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gjl = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gjl.a(this);
        this.gjk = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gjk.a(this.gjm);
        com.baidu.tieba.m.a.bpm();
        this.gjn.setTag(bdUniqueId);
        this.bSc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gjn);
        MessageManager.getInstance().registerListener(this.bSc);
        this.gjo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gjo);
    }

    public void refreshView() {
        this.gjk.LoadData();
    }

    public void initView() {
        this.gjl.initView();
        this.gjk.LoadData();
    }

    public void onDestroy() {
        this.gjl.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gjl.onChangeSkinType(i);
    }

    public void biI() {
        this.gjl.biG();
    }

    public void biJ() {
        this.gjl.biH();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cG(View view) {
        this.gjk.LoadData();
    }
}
