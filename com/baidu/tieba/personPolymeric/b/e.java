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
    private TbPageContext abm;
    private final BaseFragmentActivity esx;
    private BaseFragment ffd;
    private final boolean ffe;
    private d fff;
    private final PersonPolymericModel ffg;
    private final c ffh;
    private final BlackListModel ffi;
    private a ffj;
    private g ffk;
    private boolean ffm;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean ffl = false;
    private final d.b ffn = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void br(View view) {
            e.this.Qf();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.ffd = baseFragment;
        this.esx = this.ffd.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.ffm = z3;
        this.isHost = z;
        this.ffe = z2;
        this.abm = this.esx.getPageContext();
        this.ffh = new c(this.ffd.getPageContext(), bdUniqueId);
        this.fff = new d(this.ffd.getPageContext(), view);
        this.fff.a(this.ffn);
        this.ffg = new PersonPolymericModel(this.esx, bdUniqueId, z);
        this.ffg.a(this);
        this.ffg.a(this.ffh);
        this.ffi = new BlackListModel(this.esx.getPageContext(), bdUniqueId);
        this.ffk = new g(this.esx.getPageContext(), bdUniqueId, z);
        this.ffk.a(this.ffg);
        aWE();
        Qf();
    }

    public a aWy() {
        return this.ffj;
    }

    public g aWz() {
        return this.ffk;
    }

    public PersonPolymericModel aWA() {
        return this.ffg;
    }

    public BlackListModel aWB() {
        return this.ffi;
    }

    public c aWC() {
        return this.ffh;
    }

    public d aWD() {
        return this.fff;
    }

    public void Qf() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fff.aoK();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.fff.h(false, -1);
            this.fff.kj(true);
            this.ffg.cr(this.mUserId);
            this.ffg.cq(this.mUserId);
        } else {
            this.fff.NT();
            this.fff.qm(8);
            this.fff.J(this.ffd.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fff.aoK();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.ffg.cq(this.mUserId);
        } else {
            this.fff.NT();
            l.showToast(this.abm.getContext(), this.abm.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fff.YS();
            this.fff.cE(arrayList);
            this.fff.aWx();
        }
    }

    public void kk(boolean z) {
        if (z) {
            this.ffl = z;
            if (com.baidu.adp.lib.util.j.gV()) {
                this.ffg.cq(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fff.NT();
        if (this.ffj != null) {
            this.ffj.a(aVar);
        }
        if (this.ffl && aVar != null && aVar.fgA != null && aVar.fgA.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fgA.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
        if (aVar != null) {
            this.fff.d(aVar.getUserData());
        }
    }

    private void aWE() {
        this.ffj = new i();
        this.ffj.a(this.esx, this, this.mPageId, this.mUserId, this.isHost, this.ffe);
        this.ffj.ki(this.ffm);
        this.ffj.b(this.ffd);
        this.ffj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ffj != null) {
                this.ffj.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ffj != null) {
            this.ffj.onDestroy();
        }
    }

    public void kh(boolean z) {
        if (this.ffj != null) {
            this.ffj.kh(z);
        }
    }

    public void onResume() {
        if (this.ffj != null) {
            this.ffj.onResume();
        }
    }
}
