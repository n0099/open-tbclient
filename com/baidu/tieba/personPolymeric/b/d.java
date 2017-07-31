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
    private TbPageContext acp;
    private BaseFragment bEC;
    private final PersonPolymericModel bEG;
    private final BaseFragmentActivity bEH;
    private c bEJ;
    private final boolean buk;
    private final boolean fiN;
    private final b fiO;
    private final BlackListModel fiP;
    private a fiQ;
    private f fiR;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private final HashMap<String, a> fiS = new HashMap<>(2);
    private final c.a fiT = new c.a() { // from class: com.baidu.tieba.personPolymeric.b.d.1
        @Override // com.baidu.tieba.personPolymeric.b.c.a
        public void T(View view) {
            d.this.Pr();
        }
    };

    public d(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bEC = baseFragment;
        this.bEH = this.bEC.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.buk = z;
        this.fiN = z2;
        this.acp = this.bEH.getPageContext();
        this.fiO = new b(this.bEC.getPageContext());
        this.bEJ = new c(this.bEC.getPageContext(), view);
        this.bEJ.a(this.fiT);
        this.bEG = new PersonPolymericModel(this.bEH, bdUniqueId, z);
        this.bEG.a(this);
        this.bEG.a(this.fiO);
        this.fiP = new BlackListModel(this.bEH.getPageContext(), bdUniqueId);
        this.fiR = new f(this.bEH.getPageContext(), bdUniqueId, z);
        this.fiR.a(this.bEG);
        a(this.bEC.getPageContext(), this.mPageId, this.mUserId);
    }

    private void a(com.baidu.adp.base.e<?> eVar, BdUniqueId bdUniqueId, long j) {
        a.InterfaceC0075a interfaceC0075a = new a.InterfaceC0075a() { // from class: com.baidu.tieba.personPolymeric.b.d.2
            @Override // com.baidu.tieba.bigv.a.InterfaceC0075a
            public void a(int i, String str, long j2, boolean z) {
                d.this.ko(z);
                if (d.this.fiN && d.this.fiQ != null) {
                    d.this.fiQ.dz(true);
                }
            }
        };
        com.baidu.tieba.bigv.a aVar = new com.baidu.tieba.bigv.a(eVar, bdUniqueId);
        aVar.a(interfaceC0075a);
        aVar.aL(j);
    }

    public a aYh() {
        return this.fiQ;
    }

    public f aYi() {
        return this.fiR;
    }

    public PersonPolymericModel aYj() {
        return this.bEG;
    }

    public BlackListModel aYk() {
        return this.fiP;
    }

    public b aYl() {
        return this.fiO;
    }

    public c aYm() {
        return this.bEJ;
    }

    public void Pr() {
        if (!TbadkCoreApplication.isLogin() && this.buk) {
            this.bEJ.aYf();
        } else if (com.baidu.adp.lib.util.i.hf()) {
            this.bEJ.g(false, -1);
            this.bEJ.km(true);
            this.bEG.cx(this.mUserId);
            this.bEG.cw(this.mUserId);
        } else {
            this.bEJ.Nn();
            this.bEJ.kr(8);
            this.bEJ.K(this.bEC.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.buk) {
            this.bEJ.aYf();
        } else if (com.baidu.adp.lib.util.i.hf()) {
            this.bEG.cw(this.mUserId);
        } else {
            this.bEJ.Nn();
            k.showToast(this.acp.getContext(), this.acp.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.buk = this.buk;
            arrayList.add(iVar);
            this.bEJ.XH();
            this.bEJ.cH(arrayList);
            this.bEJ.aYg();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.bEJ.Nn();
        if (this.fiQ != null) {
            this.fiQ.a(aVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void kn(boolean z) {
        ko(z);
        if (this.fiQ != null && this.bEC != null && this.bEC.isPrimary()) {
            this.fiQ.dz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(boolean z) {
        if (z) {
            aYo();
        } else {
            aYn();
        }
    }

    private void aYn() {
        a aVar = this.fiS.get("key_normal");
        if (aVar != null) {
            this.fiQ = aVar;
        } else {
            h hVar = new h();
            this.fiQ = hVar;
            hVar.a(this.bEH, this, this.mPageId, this.mUserId, this.buk, this.fiN);
            hVar.b(this.bEC);
            hVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fiS.put("key_normal", hVar);
        }
        if (this.fiQ instanceof com.baidu.tieba.model.a) {
            ((com.baidu.tieba.model.a) this.fiQ).resetData();
        }
    }

    private void aYo() {
        a aVar = this.fiS.get("key_bigv");
        if (aVar != null) {
            this.fiQ = aVar;
            return;
        }
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a aVar2 = (a) customMessage.getData();
        if (aVar2 != null) {
            this.fiQ = aVar2;
            aVar2.a(this.bEH, this, this.mPageId, this.mUserId, this.buk, this.fiN);
            aVar2.b(this.bEC);
            aVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fiS.put("key_bigv", aVar2);
            return;
        }
        aYn();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fiQ != null) {
                this.fiQ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fiQ != null) {
            this.fiQ.onDestroy();
        }
    }

    public void dz(boolean z) {
        if (this.fiQ != null) {
            this.fiQ.dz(z);
        }
    }

    public void onResume() {
        if (this.fiQ != null) {
            this.fiQ.onResume();
        }
    }
}
