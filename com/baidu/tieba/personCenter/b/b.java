package com.baidu.tieba.personCenter.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.i;
import com.baidu.tieba.j.b;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.personCenter.view.c;
/* loaded from: classes.dex */
public class b implements c.a {
    private PersonCenterModel fae;
    private com.baidu.tieba.personCenter.view.c faf;
    PersonCenterModel.a fag = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(com.baidu.tieba.personCenter.c.c cVar) {
            b.this.faf.Oc();
            b.this.faf.b(cVar);
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.fae.mIsDataLoaded) {
                b.this.faf.S(i, str);
            } else {
                b.this.faf.Pf();
            }
        }
    };
    private CustomMessageListener fah = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                com.baidu.tieba.j.b bVar = (com.baidu.tieba.j.b) customResponsedMessage.getData();
                if (bVar.fHQ != null && bVar.fHQ.size() > 0) {
                    b.a aVar = bVar.fHQ.get(2);
                    b.a aVar2 = bVar.fHQ.get(3);
                    if (b.this.fae.aVs() != null) {
                        if (aVar2 != null) {
                            b.this.fae.aVs().kd(aVar2.dZp);
                        }
                        if (aVar != null) {
                            b.this.fae.aVs().ke(aVar.dZp);
                        }
                    }
                    b.a aVar3 = bVar.fHQ.get(5);
                    if (aVar3 != null) {
                        b.this.faf.y(5, aVar3.dZp);
                    }
                    b.a aVar4 = bVar.fHQ.get(6);
                    if (aVar4 != null) {
                        b.this.faf.y(6, aVar4.dZp);
                    }
                    b.this.faf.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener aYz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.j.a.bgO().lI(false);
            }
        }
    };
    private CustomMessageListener fai = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null) {
                if (b.this.fae.aVs() != null) {
                    b.this.fae.aVs().setUserPendantData(iVar);
                    b.this.faf.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.faf = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.faf.a(this);
        this.fae = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.fae.a(this.fag);
        com.baidu.tieba.j.a.bgO();
        this.fah.setTag(bdUniqueId);
        this.aYz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fah);
        MessageManager.getInstance().registerListener(this.aYz);
        this.fai.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fai);
    }

    public void refreshView() {
        this.fae.LoadData();
    }

    public void initView() {
        this.faf.initView();
        this.fae.LoadData();
    }

    public void onDestroy() {
        this.faf.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.faf.onChangeSkinType(i);
    }

    public void aVo() {
        this.faf.aVm();
    }

    public void aVp() {
        this.faf.aVn();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void br(View view) {
        this.fae.LoadData();
    }
}
