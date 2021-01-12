package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.p.b;
import com.baidu.tieba.personCenter.c.f;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes2.dex */
public class b implements c.a {
    private PersonCenterModel mkr;
    private com.baidu.tieba.personCenter.view.c mks;
    PersonCenterModel.a mkt = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(f fVar) {
            long currentTimeMillis = System.currentTimeMillis();
            b.this.mks.Vq();
            b.this.mks.b(fVar);
            if (fVar != null && fVar.getUserData() != null) {
                e.a(fVar.getUserData().getPersonPrivate());
            }
            com.baidu.tieba.personCenter.a.duk().ho(System.currentTimeMillis() - currentTimeMillis);
            long dum = com.baidu.tieba.personCenter.a.duk().dum();
            if (dum > 0) {
                com.baidu.tieba.personCenter.a.duk().setRefreshTime(System.currentTimeMillis() - dum);
                com.baidu.tieba.personCenter.a.duk().hp(0L);
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.mkr.mIsDataLoaded) {
                b.this.mks.bi(i, str);
            } else {
                b.this.mks.bQQ();
            }
        }
    };
    private CustomMessageListener mku = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                com.baidu.tieba.p.b bVar = (com.baidu.tieba.p.b) customResponsedMessage.getData();
                if (bVar.mSk != null && bVar.mSk.size() > 0) {
                    b.a aVar = bVar.mSk.get(2);
                    b.a aVar2 = bVar.mSk.get(3);
                    b.a aVar3 = bVar.mSk.get(9);
                    b.a aVar4 = bVar.mSk.get(10);
                    if (b.this.mkr.duA() != null) {
                        if (aVar2 != null) {
                            b.this.mkr.duA().wp(aVar2.dpG);
                        }
                        if (aVar != null) {
                            b.this.mkr.duA().ws(aVar.dpG);
                        }
                        if (aVar3 != null) {
                            b.this.mkr.duA().wr(aVar3.dpG);
                        }
                        if (aVar4 != null) {
                            b.this.mkr.duA().wq(aVar4.dpG);
                        }
                    }
                    b.a aVar5 = bVar.mSk.get(5);
                    if (aVar5 != null) {
                        b.this.mks.ae(5, aVar5.dpG);
                    }
                    b.a aVar6 = bVar.mSk.get(6);
                    if (aVar6 != null) {
                        b.this.mks.ae(6, aVar6.dpG);
                    }
                    b.this.mks.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener gdK = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.p.a.dCM().xq(false);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null) {
                if (b.this.mkr.duA() != null) {
                    b.this.mkr.duA().a(nVar);
                    b.this.mks.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mks = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.mks.a(this);
        this.mkr = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.mkr.a(this.mkt);
        com.baidu.tieba.p.a.dCM();
        this.mku.setTag(bdUniqueId);
        this.gdK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mku);
        MessageManager.getInstance().registerListener(this.gdK);
        this.mUpdatePendantListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUpdatePendantListener);
    }

    public void Pr(String str) {
        f duA = this.mkr.duA();
        if (duA != null && duA.getUserData() != null) {
            duA.getUserData().setName_show(str);
            this.mks.notifyDataSetChanged();
        }
    }

    public void Ps(String str) {
        f duA = this.mkr.duA();
        if (duA != null && duA.getUserData() != null) {
            duA.getUserData().setPortrait(str);
            this.mks.notifyDataSetChanged();
        }
    }

    public void refreshView() {
        com.baidu.tieba.personCenter.a.duk().hp(System.currentTimeMillis());
        this.mkr.LoadData();
    }

    public void initView() {
        this.mks.initView();
    }

    public void wo(boolean z) {
        this.mkr.wo(z);
    }

    public void onDestroy() {
        this.mks.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.mks.onChangeSkinType(i);
    }

    public void dur() {
        this.mks.dup();
    }

    public void dus() {
        this.mks.duq();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void dX(View view) {
        this.mkr.LoadData();
    }
}
