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
    private PersonCenterModel faf;
    private com.baidu.tieba.personCenter.view.c fag;
    PersonCenterModel.a fah = new PersonCenterModel.a() { // from class: com.baidu.tieba.personCenter.b.b.1
        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void a(com.baidu.tieba.personCenter.c.c cVar) {
            b.this.fag.Oc();
            b.this.fag.b(cVar);
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.a
        public void onFail(int i, String str) {
            if (i != -1 || b.this.faf.mIsDataLoaded) {
                b.this.fag.S(i, str);
            } else {
                b.this.fag.Pf();
            }
        }
    };
    private CustomMessageListener fai = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personCenter.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                com.baidu.tieba.j.b bVar = (com.baidu.tieba.j.b) customResponsedMessage.getData();
                if (bVar.fHR != null && bVar.fHR.size() > 0) {
                    b.a aVar = bVar.fHR.get(2);
                    b.a aVar2 = bVar.fHR.get(3);
                    if (b.this.faf.aVs() != null) {
                        if (aVar2 != null) {
                            b.this.faf.aVs().kd(aVar2.dZp);
                        }
                        if (aVar != null) {
                            b.this.faf.aVs().ke(aVar.dZp);
                        }
                    }
                    b.a aVar3 = bVar.fHR.get(5);
                    if (aVar3 != null) {
                        b.this.fag.y(5, aVar3.dZp);
                    }
                    b.a aVar4 = bVar.fHR.get(6);
                    if (aVar4 != null) {
                        b.this.fag.y(6, aVar4.dZp);
                    }
                    b.this.fag.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener aYz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personCenter.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                com.baidu.tieba.j.a.bgP().lI(false);
            }
        }
    };
    private CustomMessageListener faj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personCenter.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null) {
                if (b.this.faf.aVs() != null) {
                    b.this.faf.aVs().setUserPendantData(iVar);
                    b.this.fag.notifyDataSetChanged();
                    return;
                }
                b.this.refreshView();
            }
        }
    };

    public b(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fag = new com.baidu.tieba.personCenter.view.c(view, tbPageContext, bdUniqueId);
        this.fag.a(this);
        this.faf = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.faf.a(this.fah);
        com.baidu.tieba.j.a.bgP();
        this.fai.setTag(bdUniqueId);
        this.aYz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fai);
        MessageManager.getInstance().registerListener(this.aYz);
        this.faj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.faj);
    }

    public void refreshView() {
        this.faf.LoadData();
    }

    public void initView() {
        this.fag.initView();
        this.faf.LoadData();
    }

    public void onDestroy() {
        this.fag.onDestroy();
    }

    public void onChangeSkinType(int i) {
        this.fag.onChangeSkinType(i);
    }

    public void aVo() {
        this.fag.aVm();
    }

    public void aVp() {
        this.fag.aVn();
    }

    @Override // com.baidu.tieba.personCenter.view.c.a
    public void br(View view) {
        this.faf.LoadData();
    }
}
