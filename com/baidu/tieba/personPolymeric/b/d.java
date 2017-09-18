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
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.bigv.a;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.c;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext aby;
    private BaseFragment bIX;
    private final PersonPolymericModel bJb;
    private final BaseFragmentActivity bJc;
    private c bJe;
    private final boolean bwa;
    private final boolean fjU;
    private final b fjV;
    private final BlackListModel fjW;
    private a fjX;
    private f fjY;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fjZ = false;
    private final HashMap<String, a> fka = new HashMap<>(2);
    private final c.a fkb = new c.a() { // from class: com.baidu.tieba.personPolymeric.b.d.1
        @Override // com.baidu.tieba.personPolymeric.b.c.a
        public void aa(View view) {
            d.this.PP();
        }
    };

    public d(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bIX = baseFragment;
        this.bJc = this.bIX.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.bwa = z;
        this.fjU = z2;
        this.aby = this.bJc.getPageContext();
        this.fjV = new b(this.bIX.getPageContext(), bdUniqueId);
        this.bJe = new c(this.bIX.getPageContext(), view);
        this.bJe.a(this.fkb);
        this.bJb = new PersonPolymericModel(this.bJc, bdUniqueId, z);
        this.bJb.a(this);
        this.bJb.a(this.fjV);
        this.fjW = new BlackListModel(this.bJc.getPageContext(), bdUniqueId);
        this.fjY = new f(this.bJc.getPageContext(), bdUniqueId, z);
        this.fjY.a(this.bJb);
        a(this.bIX.getPageContext(), this.mPageId, this.mUserId);
    }

    private void a(com.baidu.adp.base.e<?> eVar, BdUniqueId bdUniqueId, long j) {
        a.InterfaceC0077a interfaceC0077a = new a.InterfaceC0077a() { // from class: com.baidu.tieba.personPolymeric.b.d.2
            @Override // com.baidu.tieba.bigv.a.InterfaceC0077a
            public void a(int i, String str, long j2, boolean z) {
                d.this.ku(z);
                if (d.this.fjU && d.this.fjX != null) {
                    d.this.fjX.dE(true);
                }
            }
        };
        com.baidu.tieba.bigv.a aVar = new com.baidu.tieba.bigv.a(eVar, bdUniqueId);
        aVar.a(interfaceC0077a);
        aVar.aL(j);
    }

    public a aYg() {
        return this.fjX;
    }

    public f aYh() {
        return this.fjY;
    }

    public PersonPolymericModel aYi() {
        return this.bJb;
    }

    public BlackListModel aYj() {
        return this.fjW;
    }

    public b aYk() {
        return this.fjV;
    }

    public c aYl() {
        return this.bJe;
    }

    public void PP() {
        if (!TbadkCoreApplication.isLogin() && this.bwa) {
            this.bJe.aYe();
        } else if (com.baidu.adp.lib.util.i.gW()) {
            this.bJe.h(false, -1);
            this.bJe.kr(true);
            this.bJb.cs(this.mUserId);
            this.bJb.cr(this.mUserId);
        } else {
            this.bJe.NE();
            this.bJe.kR(8);
            this.bJe.M(this.bIX.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.bwa) {
            this.bJe.aYe();
        } else if (com.baidu.adp.lib.util.i.gW()) {
            this.bJb.cr(this.mUserId);
        } else {
            this.bJe.NE();
            k.showToast(this.aby.getContext(), this.aby.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.bwa = this.bwa;
            arrayList.add(iVar);
            this.bJe.Zn();
            this.bJe.cI(arrayList);
            this.bJe.aYf();
        }
    }

    public void ks(boolean z) {
        if (z) {
            this.fjZ = z;
            if (com.baidu.adp.lib.util.i.gW()) {
                this.bJb.cr(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.bJe.NE();
        if (this.fjX != null) {
            this.fjX.a(aVar);
        }
        if (this.fjZ && aVar != null && aVar.flq != null && aVar.flq.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.flq.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void kt(boolean z) {
        ku(z);
        if (this.fjX != null && this.bIX != null && this.bIX.isPrimary()) {
            this.fjX.dE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ku(boolean z) {
        if (z) {
            aYn();
        } else {
            aYm();
        }
    }

    private void aYm() {
        a aVar = this.fka.get("key_normal");
        if (aVar != null) {
            this.fjX = aVar;
        } else {
            h hVar = new h();
            this.fjX = hVar;
            hVar.a(this.bJc, this, this.mPageId, this.mUserId, this.bwa, this.fjU);
            hVar.b(this.bIX);
            hVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fka.put("key_normal", hVar);
        }
        if (this.fjX instanceof com.baidu.tieba.model.a) {
            ((com.baidu.tieba.model.a) this.fjX).resetData();
        }
    }

    private void aYn() {
        a aVar = this.fka.get("key_bigv");
        if (aVar != null) {
            this.fjX = aVar;
            return;
        }
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a aVar2 = (a) customMessage.getData();
        if (aVar2 != null) {
            this.fjX = aVar2;
            aVar2.a(this.bJc, this, this.mPageId, this.mUserId, this.bwa, this.fjU);
            aVar2.b(this.bIX);
            aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fka.put("key_bigv", aVar2);
            return;
        }
        aYm();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fjX != null) {
                this.fjX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fjX != null) {
            this.fjX.onDestroy();
        }
    }

    public void dE(boolean z) {
        if (this.fjX != null) {
            this.fjX.dE(z);
        }
    }

    public void onResume() {
        if (this.fjX != null) {
            this.fjX.onResume();
        }
    }
}
