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
    private PersonCenterModel hLn;
    private com.baidu.tieba.personCenter.view.c hLo;
    PersonCenterModel.a hLp = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.hLo.aBq();
            b.this.hLo.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.hLn.mIsDataLoaded) {
                b.this.hLo.S(i, str);
            } else {
                b.this.hLo.aBp();
            }
        }
    };
    private CustomMessageListener hLq = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.ioY != null && bVar.ioY.size() > 0) {
                    b.a aVar = bVar.ioY.get(2);
                    b.a aVar2 = bVar.ioY.get(3);
                    b.a aVar3 = bVar.ioY.get(9);
                    b.a aVar4 = bVar.ioY.get(10);
                    if (b.this.hLn.bQy() != null) {
                        if (aVar2 != null) {
                            b.this.hLn.bQy().oy(aVar2.gLN);
                        }
                        if (aVar != null) {
                            b.this.hLn.bQy().oB(aVar.gLN);
                        }
                        if (aVar3 != null) {
                            b.this.hLn.bQy().oA(aVar3.gLN);
                        }
                        if (aVar4 != null) {
                            b.this.hLn.bQy().oz(aVar4.gLN);
                        }
                    }
                    b.a aVar5 = bVar.ioY.get(5);
                    if (aVar5 != null) {
                        b.this.hLo.I(5, aVar5.gLN);
                    }
                    b.a aVar6 = bVar.ioY.get(6);
                    if (aVar6 != null) {
                        b.this.hLo.I(6, aVar6.gLN);
                    }
                    b.this.hLo.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener cMB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bXS().ps(false);
            }
        }
    };
    private CustomMessageListener hLr = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.hLn.bQy() != null) {
                    b.this.hLn.bQy().a(lVar);
                    b.this.hLo.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLo = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.hLo.a(this);
        this.hLn = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.hLn.a(this.hLp);
        com.baidu.tieba.o.a.bXS();
        this.hLq.setTag(bdUniqueId);
        this.cMB.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLq);
        MessageManager.getInstance().registerListener(this.cMB);
        this.hLr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hLr);
    }

    public void Aw(String str) {
        e bQy = this.hLn.bQy();
        if (bQy != null && bQy.getUserData() != null) {
            bQy.getUserData().setName_show(str);
            this.hLo.notifyDataSetChanged();
        }
    }

    public void Ax(String str) {
        e bQy = this.hLn.bQy();
        if (bQy != null && bQy.getUserData() != null) {
            bQy.getUserData().setPortrait(str);
            this.hLo.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.hLn.LoadData();
    }

    public void initView() {
        this.hLo.initView();
        this.hLn.LoadData();
    }

    public void ox(boolean z) {
        this.hLn.ox(z);
    }

    public void onDestroy() {
        this.hLo.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.hLo.onChangeSkinType(i);
    }

    public void bQr() {
        this.hLo.bQp();
    }

    public void bQs() {
        this.hLo.bQq();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cy(View view) {
        this.hLn.LoadData();
    }
}
