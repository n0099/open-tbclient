package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext abI;
    private final BaseFragmentActivity eAH;
    private g fnA;
    private boolean fnC;
    private BaseFragment fnt;
    private final boolean fnu;
    private d fnv;
    private final PersonPolymericModel fnw;
    private final c fnx;
    private final BlackListModel fny;
    private a fnz;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fnB = false;
    private final d.b fnD = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bu(View view) {
            e.this.Rx();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.fnt = baseFragment;
        this.eAH = this.fnt.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.fnC = z3;
        this.isHost = z;
        this.fnu = z2;
        this.abI = this.eAH.getPageContext();
        this.fnx = new c(this.fnt.getPageContext(), bdUniqueId);
        this.fnv = new d(this.fnt.getPageContext(), view);
        this.fnv.a(this.fnD);
        this.fnw = new PersonPolymericModel(this.eAH, bdUniqueId, z);
        this.fnw.a(this);
        this.fnw.a(this.fnx);
        this.fny = new BlackListModel(this.eAH.getPageContext(), bdUniqueId);
        this.fnA = new g(this.eAH.getPageContext(), bdUniqueId, z);
        this.fnA.a(this.fnw);
        aZH();
        Rx();
    }

    public a aZB() {
        return this.fnz;
    }

    public g aZC() {
        return this.fnA;
    }

    public PersonPolymericModel aZD() {
        return this.fnw;
    }

    public BlackListModel aZE() {
        return this.fny;
    }

    public c aZF() {
        return this.fnx;
    }

    public d aZG() {
        return this.fnv;
    }

    public void Rx() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fnv.arj();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.fnv.g(false, -1);
            this.fnv.kd(true);
            this.fnw.cs(this.mUserId);
            this.fnw.cr(this.mUserId);
        } else {
            this.fnv.MZ();
            this.fnv.qC(8);
            this.fnv.H(this.fnt.getString(d.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fnv.arj();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.fnw.cr(this.mUserId);
        } else {
            this.fnv.MZ();
            l.showToast(this.abI.getContext(), this.abI.getString(d.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fnv.abc();
            this.fnv.cF(arrayList);
            this.fnv.aZA();
        }
    }

    public void ke(boolean z) {
        if (z) {
            this.fnB = z;
            if (com.baidu.adp.lib.util.j.gV()) {
                this.fnw.cr(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fnv.MZ();
        if (this.fnz != null) {
            this.fnz.a(aVar);
        }
        if (this.fnB && aVar != null && aVar.foY != null && aVar.foY.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.foY.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
        if (aVar != null) {
            this.fnv.e(aVar.getUserData());
        }
    }

    private void aZH() {
        this.fnz = new i();
        this.fnz.a(this.eAH, this, this.mPageId, this.mUserId, this.isHost, this.fnu);
        this.fnz.kc(this.fnC);
        this.fnz.b(this.fnt);
        this.fnz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fnz != null) {
                this.fnz.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fnz != null) {
            this.fnz.onDestroy();
        }
    }

    public void kb(boolean z) {
        if (this.fnz != null) {
            this.fnz.kb(z);
        }
    }

    public void onResume() {
        if (this.fnz != null) {
            this.fnz.onResume();
        }
    }
}
