package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.bigv.a;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.c;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext acr;
    private BaseFragment bFm;
    private final PersonPolymericModel bFq;
    private final BaseFragmentActivity bFr;
    private c bFt;
    private final boolean buB;
    private final boolean fkI;
    private final b fkJ;
    private final BlackListModel fkK;
    private a fkL;
    private f fkM;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private final HashMap<String, a> fkN = new HashMap<>(2);
    private final c.a fkO = new c.a() { // from class: com.baidu.tieba.personPolymeric.b.d.1
        @Override // com.baidu.tieba.personPolymeric.b.c.a
        public void S(View view) {
            d.this.Px();
        }
    };

    public d(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bFm = baseFragment;
        this.bFr = this.bFm.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.buB = z;
        this.fkI = z2;
        this.acr = this.bFr.getPageContext();
        this.fkJ = new b(this.bFm.getPageContext());
        this.bFt = new c(this.bFm.getPageContext(), view);
        this.bFt.a(this.fkO);
        this.bFq = new PersonPolymericModel(this.bFr, bdUniqueId, z);
        this.bFq.a(this);
        this.bFq.a(this.fkJ);
        this.fkK = new BlackListModel(this.bFr.getPageContext(), bdUniqueId);
        this.fkM = new f(this.bFr.getPageContext(), bdUniqueId, z);
        this.fkM.a(this.bFq);
        a(this.bFm.getPageContext(), this.mPageId, this.mUserId);
    }

    private void a(com.baidu.adp.base.e<?> eVar, BdUniqueId bdUniqueId, long j) {
        a.InterfaceC0075a interfaceC0075a = new a.InterfaceC0075a() { // from class: com.baidu.tieba.personPolymeric.b.d.2
            @Override // com.baidu.tieba.bigv.a.InterfaceC0075a
            public void a(int i, String str, long j2, boolean z) {
                d.this.kr(z);
                if (d.this.fkI && d.this.fkL != null) {
                    d.this.fkL.dA(true);
                }
            }
        };
        com.baidu.tieba.bigv.a aVar = new com.baidu.tieba.bigv.a(eVar, bdUniqueId);
        aVar.a(interfaceC0075a);
        aVar.aL(j);
    }

    public a aYJ() {
        return this.fkL;
    }

    public f aYK() {
        return this.fkM;
    }

    public PersonPolymericModel aYL() {
        return this.bFq;
    }

    public BlackListModel aYM() {
        return this.fkK;
    }

    public b aYN() {
        return this.fkJ;
    }

    public c aYO() {
        return this.bFt;
    }

    public void Px() {
        if (!TbadkCoreApplication.isLogin() && this.buB) {
            this.bFt.aYH();
        } else if (com.baidu.adp.lib.util.i.hf()) {
            this.bFt.g(false, -1);
            this.bFt.kp(true);
            this.bFq.cx(this.mUserId);
            this.bFq.cw(this.mUserId);
        } else {
            this.bFt.Nn();
            this.bFt.kB(8);
            this.bFt.L(this.bFm.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.buB) {
            this.bFt.aYH();
        } else if (com.baidu.adp.lib.util.i.hf()) {
            this.bFq.cw(this.mUserId);
        } else {
            this.bFt.Nn();
            k.showToast(this.acr.getContext(), this.acr.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.buB = this.buB;
            arrayList.add(iVar);
            this.bFt.XZ();
            this.bFt.cK(arrayList);
            this.bFt.aYI();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.bFt.Nn();
        if (this.fkL != null) {
            this.fkL.a(aVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void kq(boolean z) {
        kr(z);
        if (this.fkL != null && this.bFm != null && this.bFm.isPrimary()) {
            this.fkL.dA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(boolean z) {
        if (z) {
            aYQ();
        } else {
            aYP();
        }
    }

    private void aYP() {
        a aVar = this.fkN.get("key_normal");
        if (aVar != null) {
            this.fkL = aVar;
        } else {
            h hVar = new h();
            this.fkL = hVar;
            hVar.a(this.bFr, this, this.mPageId, this.mUserId, this.buB, this.fkI);
            hVar.b(this.bFm);
            hVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fkN.put("key_normal", hVar);
        }
        if (this.fkL instanceof com.baidu.tieba.model.a) {
            ((com.baidu.tieba.model.a) this.fkL).resetData();
        }
    }

    private void aYQ() {
        a aVar = this.fkN.get("key_bigv");
        if (aVar != null) {
            this.fkL = aVar;
            return;
        }
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a aVar2 = (a) customMessage.getData();
        if (aVar2 != null) {
            this.fkL = aVar2;
            aVar2.a(this.bFr, this, this.mPageId, this.mUserId, this.buB, this.fkI);
            aVar2.b(this.bFm);
            aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fkN.put("key_bigv", aVar2);
            return;
        }
        aYP();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fkL != null) {
                this.fkL.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fkL != null) {
            this.fkL.onDestroy();
        }
    }

    public void dA(boolean z) {
        if (this.fkL != null) {
            this.fkL.dA(z);
        }
    }

    public void onResume() {
        if (this.fkL != null) {
            this.fkL.onResume();
        }
    }
}
