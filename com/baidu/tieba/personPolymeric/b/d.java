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
    private BaseFragment bFl;
    private final PersonPolymericModel bFp;
    private final BaseFragmentActivity bFq;
    private c bFs;
    private final boolean buA;
    private final boolean fkG;
    private final b fkH;
    private final BlackListModel fkI;
    private a fkJ;
    private f fkK;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private final HashMap<String, a> fkL = new HashMap<>(2);
    private final c.a fkM = new c.a() { // from class: com.baidu.tieba.personPolymeric.b.d.1
        @Override // com.baidu.tieba.personPolymeric.b.c.a
        public void T(View view) {
            d.this.Py();
        }
    };

    public d(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bFl = baseFragment;
        this.bFq = this.bFl.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.buA = z;
        this.fkG = z2;
        this.acr = this.bFq.getPageContext();
        this.fkH = new b(this.bFl.getPageContext());
        this.bFs = new c(this.bFl.getPageContext(), view);
        this.bFs.a(this.fkM);
        this.bFp = new PersonPolymericModel(this.bFq, bdUniqueId, z);
        this.bFp.a(this);
        this.bFp.a(this.fkH);
        this.fkI = new BlackListModel(this.bFq.getPageContext(), bdUniqueId);
        this.fkK = new f(this.bFq.getPageContext(), bdUniqueId, z);
        this.fkK.a(this.bFp);
        a(this.bFl.getPageContext(), this.mPageId, this.mUserId);
    }

    private void a(com.baidu.adp.base.e<?> eVar, BdUniqueId bdUniqueId, long j) {
        a.InterfaceC0075a interfaceC0075a = new a.InterfaceC0075a() { // from class: com.baidu.tieba.personPolymeric.b.d.2
            @Override // com.baidu.tieba.bigv.a.InterfaceC0075a
            public void a(int i, String str, long j2, boolean z) {
                d.this.kr(z);
                if (d.this.fkG && d.this.fkJ != null) {
                    d.this.fkJ.dA(true);
                }
            }
        };
        com.baidu.tieba.bigv.a aVar = new com.baidu.tieba.bigv.a(eVar, bdUniqueId);
        aVar.a(interfaceC0075a);
        aVar.aL(j);
    }

    public a aYO() {
        return this.fkJ;
    }

    public f aYP() {
        return this.fkK;
    }

    public PersonPolymericModel aYQ() {
        return this.bFp;
    }

    public BlackListModel aYR() {
        return this.fkI;
    }

    public b aYS() {
        return this.fkH;
    }

    public c aYT() {
        return this.bFs;
    }

    public void Py() {
        if (!TbadkCoreApplication.isLogin() && this.buA) {
            this.bFs.aYM();
        } else if (com.baidu.adp.lib.util.i.hf()) {
            this.bFs.g(false, -1);
            this.bFs.kp(true);
            this.bFp.cx(this.mUserId);
            this.bFp.cw(this.mUserId);
        } else {
            this.bFs.Nn();
            this.bFs.kB(8);
            this.bFs.L(this.bFl.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.buA) {
            this.bFs.aYM();
        } else if (com.baidu.adp.lib.util.i.hf()) {
            this.bFp.cw(this.mUserId);
        } else {
            this.bFs.Nn();
            k.showToast(this.acr.getContext(), this.acr.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.buA = this.buA;
            arrayList.add(iVar);
            this.bFs.Yc();
            this.bFs.cK(arrayList);
            this.bFs.aYN();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.bFs.Nn();
        if (this.fkJ != null) {
            this.fkJ.a(aVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void kq(boolean z) {
        kr(z);
        if (this.fkJ != null && this.bFl != null && this.bFl.isPrimary()) {
            this.fkJ.dA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(boolean z) {
        if (z) {
            aYV();
        } else {
            aYU();
        }
    }

    private void aYU() {
        a aVar = this.fkL.get("key_normal");
        if (aVar != null) {
            this.fkJ = aVar;
        } else {
            h hVar = new h();
            this.fkJ = hVar;
            hVar.a(this.bFq, this, this.mPageId, this.mUserId, this.buA, this.fkG);
            hVar.b(this.bFl);
            hVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fkL.put("key_normal", hVar);
        }
        if (this.fkJ instanceof com.baidu.tieba.model.a) {
            ((com.baidu.tieba.model.a) this.fkJ).resetData();
        }
    }

    private void aYV() {
        a aVar = this.fkL.get("key_bigv");
        if (aVar != null) {
            this.fkJ = aVar;
            return;
        }
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a aVar2 = (a) customMessage.getData();
        if (aVar2 != null) {
            this.fkJ = aVar2;
            aVar2.a(this.bFq, this, this.mPageId, this.mUserId, this.buA, this.fkG);
            aVar2.b(this.bFl);
            aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fkL.put("key_bigv", aVar2);
            return;
        }
        aYU();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fkJ != null) {
                this.fkJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fkJ != null) {
            this.fkJ.onDestroy();
        }
    }

    public void dA(boolean z) {
        if (this.fkJ != null) {
            this.fkJ.dA(z);
        }
    }

    public void onResume() {
        if (this.fkJ != null) {
            this.fkJ.onResume();
        }
    }
}
