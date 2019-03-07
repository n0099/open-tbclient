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
    private PersonCenterModel hLF;
    private com.baidu.tieba.personCenter.view.c hLG;
    PersonCenterModel.a hLH = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.hLG.aBt();
            b.this.hLG.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.hLF.mIsDataLoaded) {
                b.this.hLG.Q(i, str);
            } else {
                b.this.hLG.aBs();
            }
        }
    };
    private CustomMessageListener hLI = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.ipt != null && bVar.ipt.size() > 0) {
                    b.a aVar = bVar.ipt.get(2);
                    b.a aVar2 = bVar.ipt.get(3);
                    b.a aVar3 = bVar.ipt.get(9);
                    b.a aVar4 = bVar.ipt.get(10);
                    if (b.this.hLF.bQz() != null) {
                        if (aVar2 != null) {
                            b.this.hLF.bQz().oy(aVar2.gLZ);
                        }
                        if (aVar != null) {
                            b.this.hLF.bQz().oB(aVar.gLZ);
                        }
                        if (aVar3 != null) {
                            b.this.hLF.bQz().oA(aVar3.gLZ);
                        }
                        if (aVar4 != null) {
                            b.this.hLF.bQz().oz(aVar4.gLZ);
                        }
                    }
                    b.a aVar5 = bVar.ipt.get(5);
                    if (aVar5 != null) {
                        b.this.hLG.I(5, aVar5.gLZ);
                    }
                    b.a aVar6 = bVar.ipt.get(6);
                    if (aVar6 != null) {
                        b.this.hLG.I(6, aVar6.gLZ);
                    }
                    b.this.hLG.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cMB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bXT().ps(false);
            }
        }
    };
    private CustomMessageListener hLJ = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.hLF.bQz() != null) {
                    b.this.hLF.bQz().a(lVar);
                    b.this.hLG.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLG = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.hLG.a(this);
        this.hLF = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.hLF.a(this.hLH);
        com.baidu.tieba.o.a.bXT();
        this.hLI.setTag(bdUniqueId);
        this.cMB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLI);
        MessageManager.getInstance().registerListener(this.cMB);
        this.hLJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLJ);
    }

    public void Ay(String str) {
        e bQz = this.hLF.bQz();
        if (bQz != null && bQz.getUserData() != null) {
            bQz.getUserData().setName_show(str);
            this.hLG.notifyDataSetChanged();
        }
    }

    public void Az(String str) {
        e bQz = this.hLF.bQz();
        if (bQz != null && bQz.getUserData() != null) {
            bQz.getUserData().setPortrait(str);
            this.hLG.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.hLF.LoadData();
    }

    public void initView() {
        this.hLG.initView();
        this.hLF.LoadData();
    }

    public void ox(boolean z) {
        this.hLF.ox(z);
    }

    public void onDestroy() {
        this.hLG.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.hLG.onChangeSkinType(i);
    }

    public void bQs() {
        this.hLG.bQq();
    }

    public void bQt() {
        this.hLG.bQr();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cy(View view) {
        this.hLF.LoadData();
    }
}
