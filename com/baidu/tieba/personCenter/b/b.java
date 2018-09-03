package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.i;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes2.dex */
public class b implements c.a {
    private PersonCenterModel fUl;
    private com.baidu.tieba.personCenter.view.c fUm;
    PersonCenterModel.a fUn = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(e eVar) {
            b.this.fUm.Un();
            b.this.fUm.b(eVar);
            if (eVar != null && eVar.getUserData() != null) {
                com.baidu.tbadk.core.a.e.a(eVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fUl.mIsDataLoaded) {
                b.this.fUm.D(i, str);
            } else {
                b.this.fUm.Um();
            }
        }
    };
    private CustomMessageListener fUo = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.gwy != null && bVar.gwy.size() > 0) {
                    b.a aVar = bVar.gwy.get(2);
                    b.a aVar2 = bVar.gwy.get(3);
                    b.a aVar3 = bVar.gwy.get(9);
                    b.a aVar4 = bVar.gwy.get(10);
                    if (b.this.fUl.bhJ() != null) {
                        if (aVar2 != null) {
                            b.this.fUl.bhJ().kX(aVar2.eUT);
                        }
                        if (aVar != null) {
                            b.this.fUl.bhJ().la(aVar.eUT);
                        }
                        if (aVar3 != null) {
                            b.this.fUl.bhJ().kZ(aVar3.eUT);
                        }
                        if (aVar4 != null) {
                            b.this.fUl.bhJ().kY(aVar4.eUT);
                        }
                    }
                    b.a aVar5 = bVar.gwy.get(5);
                    if (aVar5 != null) {
                        b.this.fUm.B(5, aVar5.eUT);
                    }
                    b.a aVar6 = bVar.gwy.get(6);
                    if (aVar6 != null) {
                        b.this.fUm.B(6, aVar6.eUT);
                    }
                    b.this.fUm.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener bmA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.boy().lK(false);
            }
        }
    };
    private CustomMessageListener fUp = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null) {
                if (b.this.fUl.bhJ() != null) {
                    b.this.fUl.bhJ().b(iVar);
                    b.this.fUm.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fUm = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fUm.a(this);
        this.fUl = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fUl.a(this.fUn);
        com.baidu.tieba.o.a.boy();
        this.fUo.setTag(bdUniqueId);
        this.bmA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fUo);
        MessageManager.getInstance().registerListener(this.bmA);
        this.fUp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fUp);
    }

    public void refreshView() {
        this.fUl.LoadData();
    }

    public void initView() {
        this.fUm.initView();
        this.fUl.LoadData();
    }

    public void kW(boolean z) {
        this.fUl.kW(z);
    }

    public void onDestroy() {
        this.fUm.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fUm.onChangeSkinType(i);
    }

    public void bhD() {
        this.fUm.bhB();
    }

    public void bhE() {
        this.fUm.bhC();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void bt(View view) {
        this.fUl.LoadData();
    }
}
