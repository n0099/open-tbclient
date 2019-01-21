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
/* loaded from: classes5.dex */
public class b implements c.a {
    private PersonCenterModel gvp;
    private com.baidu.tieba.personCenter.view.c gvq;
    PersonCenterModel.a gvr = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.gvq.abx();
            b.this.gvq.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gvp.mIsDataLoaded) {
                b.this.gvq.A(i, str);
            } else {
                b.this.gvq.abw();
            }
        }
    };
    private CustomMessageListener gvs = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gXE != null && bVar.gXE.size() > 0) {
                    b.a aVar = bVar.gXE.get(2);
                    b.a aVar2 = bVar.gXE.get(3);
                    b.a aVar3 = bVar.gXE.get(9);
                    b.a aVar4 = bVar.gXE.get(10);
                    if (b.this.gvp.bqd() != null) {
                        if (aVar2 != null) {
                            b.this.gvp.bqd().mb(aVar2.fvW);
                        }
                        if (aVar != null) {
                            b.this.gvp.bqd().me(aVar.fvW);
                        }
                        if (aVar3 != null) {
                            b.this.gvp.bqd().md(aVar3.fvW);
                        }
                        if (aVar4 != null) {
                            b.this.gvp.bqd().mc(aVar4.fvW);
                        }
                    }
                    b.a aVar5 = bVar.gXE.get(5);
                    if (aVar5 != null) {
                        b.this.gvq.C(5, aVar5.fvW);
                    }
                    b.a aVar6 = bVar.gXE.get(6);
                    if (aVar6 != null) {
                        b.this.gvq.C(6, aVar6.fvW);
                    }
                    b.this.gvq.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bBu = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bxf().mT(false);
            }
        }
    };
    private CustomMessageListener gvt = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.gvp.bqd() != null) {
                    b.this.gvp.bqd().b(lVar);
                    b.this.gvq.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gvq = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gvq.a(this);
        this.gvp = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gvp.a(this.gvr);
        com.baidu.tieba.o.a.bxf();
        this.gvs.setTag(bdUniqueId);
        this.bBu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gvs);
        MessageManager.getInstance().registerListener(this.bBu);
        this.gvt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gvt);
    }

    public void tS(String str) {
        e bqd = this.gvp.bqd();
        if (bqd != null && bqd.getUserData() != null) {
            bqd.getUserData().setName_show(str);
            this.gvq.notifyDataSetChanged();
        }
    }

    public void tT(String str) {
        e bqd = this.gvp.bqd();
        if (bqd != null && bqd.getUserData() != null) {
            bqd.getUserData().setPortrait(str);
            this.gvq.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.gvp.LoadData();
    }

    public void initView() {
        this.gvq.initView();
    }

    public void ma(boolean z) {
        this.gvp.ma(z);
    }

    public void onDestroy() {
        this.gvq.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gvq.onChangeSkinType(i);
    }

    public void bpX() {
        this.gvq.bpV();
    }

    public void bpY() {
        this.gvq.bpW();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bL(View view) {
        this.gvp.LoadData();
    }
}
