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
    private PersonCenterModel hLm;
    private com.baidu.tieba.personCenter.view.c hLn;
    PersonCenterModel.a hLo = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.hLn.aBq();
            b.this.hLn.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.hLm.mIsDataLoaded) {
                b.this.hLn.S(i, str);
            } else {
                b.this.hLn.aBp();
            }
        }
    };
    private CustomMessageListener hLp = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.ioX != null && bVar.ioX.size() > 0) {
                    b.a aVar = bVar.ioX.get(2);
                    b.a aVar2 = bVar.ioX.get(3);
                    b.a aVar3 = bVar.ioX.get(9);
                    b.a aVar4 = bVar.ioX.get(10);
                    if (b.this.hLm.bQy() != null) {
                        if (aVar2 != null) {
                            b.this.hLm.bQy().oy(aVar2.gLM);
                        }
                        if (aVar != null) {
                            b.this.hLm.bQy().oB(aVar.gLM);
                        }
                        if (aVar3 != null) {
                            b.this.hLm.bQy().oA(aVar3.gLM);
                        }
                        if (aVar4 != null) {
                            b.this.hLm.bQy().oz(aVar4.gLM);
                        }
                    }
                    b.a aVar5 = bVar.ioX.get(5);
                    if (aVar5 != null) {
                        b.this.hLn.I(5, aVar5.gLM);
                    }
                    b.a aVar6 = bVar.ioX.get(6);
                    if (aVar6 != null) {
                        b.this.hLn.I(6, aVar6.gLM);
                    }
                    b.this.hLn.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cMA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bXS().ps(false);
            }
        }
    };
    private CustomMessageListener hLq = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.hLm.bQy() != null) {
                    b.this.hLm.bQy().a(lVar);
                    b.this.hLn.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLn = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.hLn.a(this);
        this.hLm = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.hLm.a(this.hLo);
        com.baidu.tieba.o.a.bXS();
        this.hLp.setTag(bdUniqueId);
        this.cMA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLp);
        MessageManager.getInstance().registerListener(this.cMA);
        this.hLq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLq);
    }

    public void Aw(String str) {
        e bQy = this.hLm.bQy();
        if (bQy != null && bQy.getUserData() != null) {
            bQy.getUserData().setName_show(str);
            this.hLn.notifyDataSetChanged();
        }
    }

    public void Ax(String str) {
        e bQy = this.hLm.bQy();
        if (bQy != null && bQy.getUserData() != null) {
            bQy.getUserData().setPortrait(str);
            this.hLn.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.hLm.LoadData();
    }

    public void initView() {
        this.hLn.initView();
        this.hLm.LoadData();
    }

    public void ox(boolean z) {
        this.hLm.ox(z);
    }

    public void onDestroy() {
        this.hLn.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.hLn.onChangeSkinType(i);
    }

    public void bQr() {
        this.hLn.bQp();
    }

    public void bQs() {
        this.hLn.bQq();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cy(View view) {
        this.hLm.LoadData();
    }
}
