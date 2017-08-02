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
    private TbPageContext aaS;
    private BaseFragment bDs;
    private final PersonPolymericModel bDw;
    private final BaseFragmentActivity bDx;
    private c bDz;
    private final boolean bsZ;
    private final b fhA;
    private final BlackListModel fhB;
    private a fhC;
    private f fhD;
    private final boolean fhz;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private final HashMap<String, a> fhE = new HashMap<>(2);
    private final c.a fhF = new c.a() { // from class: com.baidu.tieba.personPolymeric.b.d.1
        @Override // com.baidu.tieba.personPolymeric.b.c.a
        public void T(View view) {
            d.this.Pm();
        }
    };

    public d(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bDs = baseFragment;
        this.bDx = this.bDs.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.bsZ = z;
        this.fhz = z2;
        this.aaS = this.bDx.getPageContext();
        this.fhA = new b(this.bDs.getPageContext());
        this.bDz = new c(this.bDs.getPageContext(), view);
        this.bDz.a(this.fhF);
        this.bDw = new PersonPolymericModel(this.bDx, bdUniqueId, z);
        this.bDw.a(this);
        this.bDw.a(this.fhA);
        this.fhB = new BlackListModel(this.bDx.getPageContext(), bdUniqueId);
        this.fhD = new f(this.bDx.getPageContext(), bdUniqueId, z);
        this.fhD.a(this.bDw);
        a(this.bDs.getPageContext(), this.mPageId, this.mUserId);
    }

    private void a(com.baidu.adp.base.e<?> eVar, BdUniqueId bdUniqueId, long j) {
        a.InterfaceC0075a interfaceC0075a = new a.InterfaceC0075a() { // from class: com.baidu.tieba.personPolymeric.b.d.2
            @Override // com.baidu.tieba.bigv.a.InterfaceC0075a
            public void a(int i, String str, long j2, boolean z) {
                d.this.ko(z);
                if (d.this.fhz && d.this.fhC != null) {
                    d.this.fhC.dz(true);
                }
            }
        };
        com.baidu.tieba.bigv.a aVar = new com.baidu.tieba.bigv.a(eVar, bdUniqueId);
        aVar.a(interfaceC0075a);
        aVar.aL(j);
    }

    public a aXW() {
        return this.fhC;
    }

    public f aXX() {
        return this.fhD;
    }

    public PersonPolymericModel aXY() {
        return this.bDw;
    }

    public BlackListModel aXZ() {
        return this.fhB;
    }

    public b aYa() {
        return this.fhA;
    }

    public c aYb() {
        return this.bDz;
    }

    public void Pm() {
        if (!TbadkCoreApplication.isLogin() && this.bsZ) {
            this.bDz.aXU();
        } else if (com.baidu.adp.lib.util.i.gV()) {
            this.bDz.g(false, -1);
            this.bDz.km(true);
            this.bDw.cx(this.mUserId);
            this.bDw.cw(this.mUserId);
        } else {
            this.bDz.Ni();
            this.bDz.ks(8);
            this.bDz.L(this.bDs.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.bsZ) {
            this.bDz.aXU();
        } else if (com.baidu.adp.lib.util.i.gV()) {
            this.bDw.cw(this.mUserId);
        } else {
            this.bDz.Ni();
            k.showToast(this.aaS.getContext(), this.aaS.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.bsZ = this.bsZ;
            arrayList.add(iVar);
            this.bDz.XC();
            this.bDz.cH(arrayList);
            this.bDz.aXV();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.bDz.Ni();
        if (this.fhC != null) {
            this.fhC.a(aVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void kn(boolean z) {
        ko(z);
        if (this.fhC != null && this.bDs != null && this.bDs.isPrimary()) {
            this.fhC.dz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(boolean z) {
        if (z) {
            aYd();
        } else {
            aYc();
        }
    }

    private void aYc() {
        a aVar = this.fhE.get("key_normal");
        if (aVar != null) {
            this.fhC = aVar;
        } else {
            h hVar = new h();
            this.fhC = hVar;
            hVar.a(this.bDx, this, this.mPageId, this.mUserId, this.bsZ, this.fhz);
            hVar.b(this.bDs);
            hVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fhE.put("key_normal", hVar);
        }
        if (this.fhC instanceof com.baidu.tieba.model.a) {
            ((com.baidu.tieba.model.a) this.fhC).resetData();
        }
    }

    private void aYd() {
        a aVar = this.fhE.get("key_bigv");
        if (aVar != null) {
            this.fhC = aVar;
            return;
        }
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a aVar2 = (a) customMessage.getData();
        if (aVar2 != null) {
            this.fhC = aVar2;
            aVar2.a(this.bDx, this, this.mPageId, this.mUserId, this.bsZ, this.fhz);
            aVar2.b(this.bDs);
            aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fhE.put("key_bigv", aVar2);
            return;
        }
        aYc();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fhC != null) {
                this.fhC.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fhC != null) {
            this.fhC.onDestroy();
        }
    }

    public void dz(boolean z) {
        if (this.fhC != null) {
            this.fhC.dz(z);
        }
    }

    public void onResume() {
        if (this.fhC != null) {
            this.fhC.onResume();
        }
    }
}
