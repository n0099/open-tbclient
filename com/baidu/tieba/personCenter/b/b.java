package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes5.dex */
public class b implements c.a {
    private PersonCenterModel guk;
    private com.baidu.tieba.personCenter.view.c gul;
    PersonCenterModel.a gum = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.gul.aba();
            b.this.gul.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.guk.mIsDataLoaded) {
                b.this.gul.y(i, str);
            } else {
                b.this.gul.aaZ();
            }
        }
    };
    private CustomMessageListener gun = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gWy != null && bVar.gWy.size() > 0) {
                    b.a aVar = bVar.gWy.get(2);
                    b.a aVar2 = bVar.gWy.get(3);
                    b.a aVar3 = bVar.gWy.get(9);
                    b.a aVar4 = bVar.gWy.get(10);
                    if (b.this.guk.bpu() != null) {
                        if (aVar2 != null) {
                            b.this.guk.bpu().mb(aVar2.fvb);
                        }
                        if (aVar != null) {
                            b.this.guk.bpu().me(aVar.fvb);
                        }
                        if (aVar3 != null) {
                            b.this.guk.bpu().md(aVar3.fvb);
                        }
                        if (aVar4 != null) {
                            b.this.guk.bpu().mc(aVar4.fvb);
                        }
                    }
                    b.a aVar5 = bVar.gWy.get(5);
                    if (aVar5 != null) {
                        b.this.gul.C(5, aVar5.fvb);
                    }
                    b.a aVar6 = bVar.gWy.get(6);
                    if (aVar6 != null) {
                        b.this.gul.C(6, aVar6.fvb);
                    }
                    b.this.gul.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bAG = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.bww().mS(false);
            }
        }
    };
    private CustomMessageListener guo = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j jVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && (jVar = (j) customResponsedMessage.getData()) != null) {
                if (b.this.guk.bpu() != null) {
                    b.this.guk.bpu().b(jVar);
                    b.this.gul.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gul = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.gul.a(this);
        this.guk = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.guk.a(this.gum);
        com.baidu.tieba.o.a.bww();
        this.gun.setTag(bdUniqueId);
        this.bAG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gun);
        MessageManager.getInstance().registerListener(this.bAG);
        this.guo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.guo);
    }

    public void tC(String str) {
        e bpu = this.guk.bpu();
        if (bpu != null && bpu.getUserData() != null) {
            bpu.getUserData().setName_show(str);
            this.gul.notifyDataSetChanged();
        }
    }

    public void tD(String str) {
        e bpu = this.guk.bpu();
        if (bpu != null && bpu.getUserData() != null) {
            bpu.getUserData().setPortrait(str);
            this.gul.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.guk.LoadData();
    }

    public void initView() {
        this.gul.initView();
        this.guk.LoadData();
    }

    public void ma(boolean z) {
        this.guk.ma(z);
    }

    public void onDestroy() {
        this.gul.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.gul.onChangeSkinType(i);
    }

    public void bpo() {
        this.gul.bpm();
    }

    public void bpp() {
        this.gul.bpn();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bL(View view) {
        this.guk.LoadData();
    }
}
