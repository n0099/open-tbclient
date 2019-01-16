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
    private PersonCenterModel gvo;
    private com.baidu.tieba.personCenter.view.c gvp;
    PersonCenterModel.a gvq = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.gvp.abx();
            b.this.gvp.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.gvo.mIsDataLoaded) {
                b.this.gvp.A(i, str);
            } else {
                b.this.gvp.abw();
            }
        }
    };
    private CustomMessageListener gvr = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gXD != null && bVar.gXD.size() > 0) {
                    b.a aVar = bVar.gXD.get(2);
                    b.a aVar2 = bVar.gXD.get(3);
                    b.a aVar3 = bVar.gXD.get(9);
                    b.a aVar4 = bVar.gXD.get(10);
                    if (b.this.gvo.bqd() != null) {
                        if (aVar2 != null) {
                            b.this.gvo.bqd().mb(aVar2.fvV);
                        }
                        if (aVar != null) {
                            b.this.gvo.bqd().me(aVar.fvV);
                        }
                        if (aVar3 != null) {
                            b.this.gvo.bqd().md(aVar3.fvV);
                        }
                        if (aVar4 != null) {
                            b.this.gvo.bqd().mc(aVar4.fvV);
                        }
                    }
                    b.a aVar5 = bVar.gXD.get(5);
                    if (aVar5 != null) {
                        b.this.gvp.C(5, aVar5.fvV);
                    }
                    b.a aVar6 = bVar.gXD.get(6);
                    if (aVar6 != null) {
                        b.this.gvp.C(6, aVar6.fvV);
                    }
                    b.this.gvp.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bBt = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bxf().mT(false);
            }
        }
    };
    private CustomMessageListener gvs = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.gvo.bqd() != null) {
                    b.this.gvo.bqd().b(lVar);
                    b.this.gvp.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gvp = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gvp.a(this);
        this.gvo = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.gvo.a(this.gvq);
        com.baidu.tieba.o.a.bxf();
        this.gvr.setTag(bdUniqueId);
        this.bBt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gvr);
        MessageManager.getInstance().registerListener(this.bBt);
        this.gvs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gvs);
    }

    public void tS(String str) {
        e bqd = this.gvo.bqd();
        if (bqd != null && bqd.getUserData() != null) {
            bqd.getUserData().setName_show(str);
            this.gvp.notifyDataSetChanged();
        }
    }

    public void tT(String str) {
        e bqd = this.gvo.bqd();
        if (bqd != null && bqd.getUserData() != null) {
            bqd.getUserData().setPortrait(str);
            this.gvp.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.gvo.LoadData();
    }

    public void initView() {
        this.gvp.initView();
    }

    public void ma(boolean z) {
        this.gvo.ma(z);
    }

    public void onDestroy() {
        this.gvp.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gvp.onChangeSkinType(i);
    }

    public void bpX() {
        this.gvp.bpV();
    }

    public void bpY() {
        this.gvp.bpW();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bL(View view) {
        this.gvo.LoadData();
    }
}
