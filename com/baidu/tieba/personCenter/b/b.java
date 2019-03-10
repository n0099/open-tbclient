package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes4.dex */
public class b implements c.a {
    private PersonCenterModel hLG;
    private com.baidu.tieba.personCenter.view.c hLH;
    PersonCenterModel.a hLI = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.hLH.aBu();
            b.this.hLH.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.hLG.mIsDataLoaded) {
                b.this.hLH.Q(i, str);
            } else {
                b.this.hLH.aBt();
            }
        }
    };
    private CustomMessageListener hLJ = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.ipu != null && bVar.ipu.size() > 0) {
                    b.a aVar = bVar.ipu.get(2);
                    b.a aVar2 = bVar.ipu.get(3);
                    b.a aVar3 = bVar.ipu.get(9);
                    b.a aVar4 = bVar.ipu.get(10);
                    if (b.this.hLG.bQA() != null) {
                        if (aVar2 != null) {
                            b.this.hLG.bQA().oy(aVar2.gMa);
                        }
                        if (aVar != null) {
                            b.this.hLG.bQA().oB(aVar.gMa);
                        }
                        if (aVar3 != null) {
                            b.this.hLG.bQA().oA(aVar3.gMa);
                        }
                        if (aVar4 != null) {
                            b.this.hLG.bQA().oz(aVar4.gMa);
                        }
                    }
                    b.a aVar5 = bVar.ipu.get(5);
                    if (aVar5 != null) {
                        b.this.hLH.I(5, aVar5.gMa);
                    }
                    b.a aVar6 = bVar.ipu.get(6);
                    if (aVar6 != null) {
                        b.this.hLH.I(6, aVar6.gMa);
                    }
                    b.this.hLH.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cMB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bXU().ps(false);
            }
        }
    };
    private CustomMessageListener hLK = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.hLG.bQA() != null) {
                    b.this.hLG.bQA().a(lVar);
                    b.this.hLH.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLH = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.hLH.a(this);
        this.hLG = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.hLG.a(this.hLI);
        com.baidu.tieba.o.a.bXU();
        this.hLJ.setTag(bdUniqueId);
        this.cMB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLJ);
        MessageManager.getInstance().registerListener(this.cMB);
        this.hLK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLK);
    }

    public void Az(String str) {
        e bQA = this.hLG.bQA();
        if (bQA != null && bQA.getUserData() != null) {
            bQA.getUserData().setName_show(str);
            this.hLH.notifyDataSetChanged();
        }
    }

    public void AA(String str) {
        e bQA = this.hLG.bQA();
        if (bQA != null && bQA.getUserData() != null) {
            bQA.getUserData().setPortrait(str);
            this.hLH.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.hLG.LoadData();
    }

    public void initView() {
        this.hLH.initView();
        this.hLG.LoadData();
    }

    public void ox(boolean z) {
        this.hLG.ox(z);
    }

    public void onDestroy() {
        this.hLH.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.hLH.onChangeSkinType(i);
    }

    public void bQt() {
        this.hLH.bQr();
    }

    public void bQu() {
        this.hLH.bQs();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cy(View view) {
        this.hLG.LoadData();
    }
}
