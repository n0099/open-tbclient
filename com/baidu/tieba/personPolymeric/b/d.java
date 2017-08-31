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
    private BaseFragment bIg;
    private final PersonPolymericModel bIk;
    private final BaseFragmentActivity bIl;
    private c bIn;
    private final boolean bvm;
    private final boolean fjb;
    private final b fjc;
    private final BlackListModel fjd;
    private a fje;
    private f fjf;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fjg = false;
    private final HashMap<String, a> fjh = new HashMap<>(2);
    private final c.a fji = new c.a() { // from class: com.baidu.tieba.personPolymeric.b.d.1
        @Override // com.baidu.tieba.personPolymeric.b.c.a
        public void aa(View view) {
            d.this.PN();
        }
    };

    public d(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bIg = baseFragment;
        this.bIl = this.bIg.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.bvm = z;
        this.fjb = z2;
        this.aby = this.bIl.getPageContext();
        this.fjc = new b(this.bIg.getPageContext(), bdUniqueId);
        this.bIn = new c(this.bIg.getPageContext(), view);
        this.bIn.a(this.fji);
        this.bIk = new PersonPolymericModel(this.bIl, bdUniqueId, z);
        this.bIk.a(this);
        this.bIk.a(this.fjc);
        this.fjd = new BlackListModel(this.bIl.getPageContext(), bdUniqueId);
        this.fjf = new f(this.bIl.getPageContext(), bdUniqueId, z);
        this.fjf.a(this.bIk);
        a(this.bIg.getPageContext(), this.mPageId, this.mUserId);
    }

    private void a(com.baidu.adp.base.e<?> eVar, BdUniqueId bdUniqueId, long j) {
        a.InterfaceC0078a interfaceC0078a = new a.InterfaceC0078a() { // from class: com.baidu.tieba.personPolymeric.b.d.2
            @Override // com.baidu.tieba.bigv.a.InterfaceC0078a
            public void a(int i, String str, long j2, boolean z) {
                d.this.kt(z);
                if (d.this.fjb && d.this.fje != null) {
                    d.this.fje.dD(true);
                }
            }
        };
        com.baidu.tieba.bigv.a aVar = new com.baidu.tieba.bigv.a(eVar, bdUniqueId);
        aVar.a(interfaceC0078a);
        aVar.aL(j);
    }

    public a aXV() {
        return this.fje;
    }

    public f aXW() {
        return this.fjf;
    }

    public PersonPolymericModel aXX() {
        return this.bIk;
    }

    public BlackListModel aXY() {
        return this.fjd;
    }

    public b aXZ() {
        return this.fjc;
    }

    public c aYa() {
        return this.bIn;
    }

    public void PN() {
        if (!TbadkCoreApplication.isLogin() && this.bvm) {
            this.bIn.aXT();
        } else if (com.baidu.adp.lib.util.i.gW()) {
            this.bIn.h(false, -1);
            this.bIn.kq(true);
            this.bIk.cs(this.mUserId);
            this.bIk.cr(this.mUserId);
        } else {
            this.bIn.ND();
            this.bIn.kP(8);
            this.bIn.M(this.bIg.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.bvm) {
            this.bIn.aXT();
        } else if (com.baidu.adp.lib.util.i.gW()) {
            this.bIk.cr(this.mUserId);
        } else {
            this.bIn.ND();
            k.showToast(this.aby.getContext(), this.aby.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.bvm = this.bvm;
            arrayList.add(iVar);
            this.bIn.Zc();
            this.bIn.cH(arrayList);
            this.bIn.aXU();
        }
    }

    public void kr(boolean z) {
        if (z) {
            this.fjg = z;
            if (com.baidu.adp.lib.util.i.gW()) {
                this.bIk.cr(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.bIn.ND();
        if (this.fje != null) {
            this.fje.a(aVar);
        }
        if (this.fjg && aVar != null && aVar.fkx != null && aVar.fkx.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fkx.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void ks(boolean z) {
        kt(z);
        if (this.fje != null && this.bIg != null && this.bIg.isPrimary()) {
            this.fje.dD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt(boolean z) {
        if (z) {
            aYc();
        } else {
            aYb();
        }
    }

    private void aYb() {
        a aVar = this.fjh.get("key_normal");
        if (aVar != null) {
            this.fje = aVar;
        } else {
            h hVar = new h();
            this.fje = hVar;
            hVar.a(this.bIl, this, this.mPageId, this.mUserId, this.bvm, this.fjb);
            hVar.b(this.bIg);
            hVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fjh.put("key_normal", hVar);
        }
        if (this.fje instanceof com.baidu.tieba.model.a) {
            ((com.baidu.tieba.model.a) this.fje).resetData();
        }
    }

    private void aYc() {
        a aVar = this.fjh.get("key_bigv");
        if (aVar != null) {
            this.fje = aVar;
            return;
        }
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a aVar2 = (a) customMessage.getData();
        if (aVar2 != null) {
            this.fje = aVar2;
            aVar2.a(this.bIl, this, this.mPageId, this.mUserId, this.bvm, this.fjb);
            aVar2.b(this.bIg);
            aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fjh.put("key_bigv", aVar2);
            return;
        }
        aYb();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fje != null) {
                this.fje.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fje != null) {
            this.fje.onDestroy();
        }
    }

    public void dD(boolean z) {
        if (this.fje != null) {
            this.fje.dD(z);
        }
    }

    public void onResume() {
        if (this.fje != null) {
            this.fje.onResume();
        }
    }
}
