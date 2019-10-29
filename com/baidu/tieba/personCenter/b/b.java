package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes4.dex */
public class b implements c.a {
    private PersonCenterModel ilu;
    private com.baidu.tieba.personCenter.view.c ilv;
    PersonCenterModel.a ilw = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            b.this.ilv.aJo();
            b.this.ilv.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.ilu.mIsDataLoaded) {
                b.this.ilv.aa(i, str);
            } else {
                b.this.ilv.aJn();
            }
        }
    };
    private CustomMessageListener ilx = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                com.baidu.tieba.o.b bVar = (com.baidu.tieba.o.b) customResponsedMessage.getData();
                if (bVar.iQI != null && bVar.iQI.size() > 0) {
                    b.a aVar = bVar.iQI.get(2);
                    b.a aVar2 = bVar.iQI.get(3);
                    b.a aVar3 = bVar.iQI.get(9);
                    b.a aVar4 = bVar.iQI.get(10);
                    if (b.this.ilu.bZu() != null) {
                        if (aVar2 != null) {
                            b.this.ilu.bZu().pp(aVar2.hko);
                        }
                        if (aVar != null) {
                            b.this.ilu.bZu().ps(aVar.hko);
                        }
                        if (aVar3 != null) {
                            b.this.ilu.bZu().pr(aVar3.hko);
                        }
                        if (aVar4 != null) {
                            b.this.ilu.bZu().pq(aVar4.hko);
                        }
                    }
                    b.a aVar5 = bVar.iQI.get(5);
                    if (aVar5 != null) {
                        b.this.ilv.O(5, aVar5.hko);
                    }
                    b.a aVar6 = bVar.iQI.get(6);
                    if (aVar6 != null) {
                        b.this.ilv.O(6, aVar6.hko);
                    }
                    b.this.ilv.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener dgF = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.o.a.chd().qk(false);
            }
        }
    };
    private CustomMessageListener ily = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null) {
                if (b.this.ilu.bZu() != null) {
                    b.this.ilu.bZu().a(lVar);
                    b.this.ilv.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ilv = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.ilv.a(this);
        this.ilu = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.ilu.a(this.ilw);
        com.baidu.tieba.o.a.chd();
        this.ilx.setTag(bdUniqueId);
        this.dgF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ilx);
        MessageManager.getInstance().registerListener(this.dgF);
        this.ily.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ily);
    }

    public void Bu(String str) {
        f bZu = this.ilu.bZu();
        if (bZu != null && bZu.getUserData() != null) {
            bZu.getUserData().setName_show(str);
            this.ilv.notifyDataSetChanged();
        }
    }

    public void Bv(String str) {
        f bZu = this.ilu.bZu();
        if (bZu != null && bZu.getUserData() != null) {
            bZu.getUserData().setPortrait(str);
            this.ilv.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        this.ilu.LoadData();
    }

    public void initView() {
        this.ilv.initView();
    }

    public void po(boolean z) {
        this.ilu.po(z);
    }

    public void onDestroy() {
        this.ilv.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.ilv.onChangeSkinType(i);
    }

    public void bZl() {
        this.ilv.bZj();
    }

    public void bZm() {
        this.ilv.bZk();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void cH(View view) {
        this.ilu.LoadData();
    }
}
