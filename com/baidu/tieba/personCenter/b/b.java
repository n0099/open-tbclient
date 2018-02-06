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
    private PersonCenterModel gjf;
    private com.baidu.tieba.personCenter.view.c gjg;
    PersonCenterModel.a gjh = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(d dVar) {
            b.this.gjg.XN();
            b.this.gjg.b(dVar);
            if (dVar != null && dVar.getUserData() != null) {
                f.a(dVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gjf.mIsDataLoaded) {
                b.this.gjg.ac(i, str);
            } else {
                b.this.gjg.XM();
            }
        }
    };
    private CustomMessageListener gji = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                com.baidu.tieba.m.b bVar = (com.baidu.tieba.m.b) customResponsedMessage.getData();
                if (bVar.gJT != null && bVar.gJT.size() > 0) {
                    b.a aVar = bVar.gJT.get(2);
                    b.a aVar2 = bVar.gJT.get(3);
                    b.a aVar3 = bVar.gJT.get(9);
                    b.a aVar4 = bVar.gJT.get(10);
                    if (b.this.gjf.biM() != null) {
                        if (aVar2 != null) {
                            b.this.gjf.biM().lq(aVar2.fgg);
                        }
                        if (aVar != null) {
                            b.this.gjf.biM().lt(aVar.fgg);
                        }
                        if (aVar3 != null) {
                            b.this.gjf.biM().ls(aVar3.fgg);
                        }
                        if (aVar4 != null) {
                            b.this.gjf.biM().lr(aVar4.fgg);
                        }
                    }
                    b.a aVar5 = bVar.gJT.get(5);
                    if (aVar5 != null) {
                        b.this.gjg.Q(5, aVar5.fgg);
                    }
                    b.a aVar6 = bVar.gJT.get(6);
                    if (aVar6 != null) {
                        b.this.gjg.Q(6, aVar6.fgg);
                    }
                    b.this.gjg.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bSm = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.m.a.bpm().mc(false);
            }
        }
    };
    private CustomMessageListener gjj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null) {
                if (b.this.gjf.biM() != null) {
                    b.this.gjf.biM().setUserPendantData(hVar);
                    b.this.gjg.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gjg = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gjg.a(this);
        this.gjf = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gjf.a(this.gjh);
        com.baidu.tieba.m.a.bpm();
        this.gji.setTag(bdUniqueId);
        this.bSm.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gji);
        MessageManager.getInstance().registerListener(this.bSm);
        this.gjj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gjj);
    }

    public void refreshView() {
        this.gjf.LoadData();
    }

    public void initView() {
        this.gjg.initView();
        this.gjf.LoadData();
    }

    public void onDestroy() {
        this.gjg.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gjg.onChangeSkinType(i);
    }

    public void biI() {
        this.gjg.biG();
    }

    public void biJ() {
        this.gjg.biH();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cG(View view) {
        this.gjf.LoadData();
    }
}
