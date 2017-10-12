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
    private TbPageContext abz;
    private final BaseFragmentActivity esL;
    private boolean ffA;
    private BaseFragment ffr;
    private final boolean ffs;
    private d fft;
    private final PersonPolymericModel ffu;
    private final c ffv;
    private final BlackListModel ffw;
    private a ffx;
    private g ffy;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean ffz = false;
    private final d.b ffB = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void br(View view) {
            e.this.Qj();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.ffr = baseFragment;
        this.esL = this.ffr.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.ffA = z3;
        this.isHost = z;
        this.ffs = z2;
        this.abz = this.esL.getPageContext();
        this.ffv = new c(this.ffr.getPageContext(), bdUniqueId);
        this.fft = new d(this.ffr.getPageContext(), view);
        this.fft.a(this.ffB);
        this.ffu = new PersonPolymericModel(this.esL, bdUniqueId, z);
        this.ffu.a(this);
        this.ffu.a(this.ffv);
        this.ffw = new BlackListModel(this.esL.getPageContext(), bdUniqueId);
        this.ffy = new g(this.esL.getPageContext(), bdUniqueId, z);
        this.ffy.a(this.ffu);
        aWJ();
        Qj();
    }

    public a aWD() {
        return this.ffx;
    }

    public g aWE() {
        return this.ffy;
    }

    public PersonPolymericModel aWF() {
        return this.ffu;
    }

    public BlackListModel aWG() {
        return this.ffw;
    }

    public c aWH() {
        return this.ffv;
    }

    public d aWI() {
        return this.fft;
    }

    public void Qj() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fft.aoP();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.fft.h(false, -1);
            this.fft.kk(true);
            this.ffu.cq(this.mUserId);
            this.ffu.cp(this.mUserId);
        } else {
            this.fft.NZ();
            this.fft.qn(8);
            this.fft.J(this.ffr.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fft.aoP();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.ffu.cp(this.mUserId);
        } else {
            this.fft.NZ();
            l.showToast(this.abz.getContext(), this.abz.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fft.YW();
            this.fft.cE(arrayList);
            this.fft.aWC();
        }
    }

    public void kl(boolean z) {
        if (z) {
            this.ffz = z;
            if (com.baidu.adp.lib.util.j.gV()) {
                this.ffu.cp(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fft.NZ();
        if (this.ffx != null) {
            this.ffx.a(aVar);
        }
        if (this.ffz && aVar != null && aVar.fgO != null && aVar.fgO.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fgO.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
        if (aVar != null) {
            this.fft.d(aVar.getUserData());
        }
    }

    private void aWJ() {
        this.ffx = new i();
        this.ffx.a(this.esL, this, this.mPageId, this.mUserId, this.isHost, this.ffs);
        this.ffx.kj(this.ffA);
        this.ffx.b(this.ffr);
        this.ffx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ffx != null) {
                this.ffx.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ffx != null) {
            this.ffx.onDestroy();
        }
    }

    public void ki(boolean z) {
        if (this.ffx != null) {
            this.ffx.ki(z);
        }
    }

    public void onResume() {
        if (this.ffx != null) {
            this.ffx.onResume();
        }
    }
}
