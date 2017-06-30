package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.i;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext aat;
    private final boolean boT;
    private BaseFragment bzm;
    private final PersonPolymericModel bzq;
    private final BaseFragmentActivity bzr;
    private i bzt;
    private final boolean eVa;
    private final b eVb;
    private final BlackListModel eVc;
    private a eVd;
    private z eVe;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private final HashMap<String, a> eVf = new HashMap<>(2);
    private final i.a eVg = new p(this);

    public o(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bzm = baseFragment;
        this.bzr = this.bzm.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.boT = z;
        this.eVa = z2;
        this.aat = this.bzr.getPageContext();
        this.eVb = new b(this.bzm.getPageContext());
        this.bzt = new i(this.bzm.getPageContext(), view);
        this.bzt.a(this.eVg);
        this.bzq = new PersonPolymericModel(this.bzr, bdUniqueId, z);
        this.bzq.a(this);
        this.bzq.a(this.eVb);
        this.eVc = new BlackListModel(this.bzr.getPageContext(), bdUniqueId);
        this.eVe = new z(this.bzr.getPageContext(), bdUniqueId, z);
        this.eVe.a(this.bzq);
        a(this.bzm.getPageContext(), this.mPageId, this.mUserId);
    }

    private void a(com.baidu.adp.base.g<?> gVar, BdUniqueId bdUniqueId, long j) {
        q qVar = new q(this);
        com.baidu.tieba.bigv.a aVar = new com.baidu.tieba.bigv.a(gVar, bdUniqueId);
        aVar.a(qVar);
        aVar.aJ(j);
    }

    public a aVb() {
        return this.eVd;
    }

    public z aVc() {
        return this.eVe;
    }

    public PersonPolymericModel aVd() {
        return this.bzq;
    }

    public BlackListModel aVe() {
        return this.eVc;
    }

    public b aVf() {
        return this.eVb;
    }

    public i aVg() {
        return this.bzt;
    }

    public void OZ() {
        if (!TbadkCoreApplication.isLogin() && this.boT) {
            this.bzt.aUZ();
        } else if (com.baidu.adp.lib.util.i.gX()) {
            this.bzt.h(false, -1);
            this.bzt.jR(true);
            this.bzq.ct(this.mUserId);
            this.bzq.cs(this.mUserId);
        } else {
            this.bzt.Nm();
            this.bzt.kj(8);
            this.bzt.J(this.bzm.getString(w.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.boT) {
            this.bzt.aUZ();
        } else if (com.baidu.adp.lib.util.i.gX()) {
            this.bzq.cs(this.mUserId);
        } else {
            this.bzt.Nm();
            com.baidu.adp.lib.util.k.showToast(this.aat.getContext(), this.aat.getString(w.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.boT = this.boT;
            arrayList.add(iVar);
            this.bzt.WU();
            this.bzt.cq(arrayList);
            this.bzt.aVa();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.bzt.Nm();
        if (this.eVd != null) {
            this.eVd.a(aVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void jS(boolean z) {
        jT(z);
        if (this.eVd != null && this.bzm != null && this.bzm.isPrimary()) {
            this.eVd.dq(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT(boolean z) {
        if (z) {
            aVi();
        } else {
            aVh();
        }
    }

    private void aVh() {
        a aVar = this.eVf.get("key_normal");
        if (aVar != null) {
            this.eVd = aVar;
        } else {
            ak akVar = new ak();
            this.eVd = akVar;
            akVar.a(this.bzr, this, this.mPageId, this.mUserId, this.boT, this.eVa);
            akVar.a(this.bzm);
            akVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            this.eVf.put("key_normal", akVar);
        }
        if (this.eVd instanceof com.baidu.tieba.model.b) {
            ((com.baidu.tieba.model.b) this.eVd).resetData();
        }
    }

    private void aVi() {
        a aVar = this.eVf.get("key_bigv");
        if (aVar != null) {
            this.eVd = aVar;
            return;
        }
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a aVar2 = (a) customMessage.getData();
        if (aVar2 != null) {
            this.eVd = aVar2;
            aVar2.a(this.bzr, this, this.mPageId, this.mUserId, this.boT, this.eVa);
            aVar2.a(this.bzm);
            aVar2.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            this.eVf.put("key_bigv", aVar2);
            return;
        }
        aVh();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eVd != null) {
                this.eVd.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.eVd != null) {
            this.eVd.onDestroy();
        }
    }

    public void dq(boolean z) {
        if (this.eVd != null) {
            this.eVd.dq(z);
        }
    }

    public void onResume() {
        if (this.eVd != null) {
            this.eVd.onResume();
        }
    }
}
