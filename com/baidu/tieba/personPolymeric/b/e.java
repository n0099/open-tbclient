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
    private boolean ffB;
    private BaseFragment ffs;
    private final boolean fft;
    private d ffu;
    private final PersonPolymericModel ffv;
    private final c ffw;
    private final BlackListModel ffx;
    private a ffy;
    private g ffz;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean ffA = false;
    private final d.b ffC = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void br(View view) {
            e.this.Qj();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.ffs = baseFragment;
        this.esL = this.ffs.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.ffB = z3;
        this.isHost = z;
        this.fft = z2;
        this.abz = this.esL.getPageContext();
        this.ffw = new c(this.ffs.getPageContext(), bdUniqueId);
        this.ffu = new d(this.ffs.getPageContext(), view);
        this.ffu.a(this.ffC);
        this.ffv = new PersonPolymericModel(this.esL, bdUniqueId, z);
        this.ffv.a(this);
        this.ffv.a(this.ffw);
        this.ffx = new BlackListModel(this.esL.getPageContext(), bdUniqueId);
        this.ffz = new g(this.esL.getPageContext(), bdUniqueId, z);
        this.ffz.a(this.ffv);
        aWK();
        Qj();
    }

    public a aWE() {
        return this.ffy;
    }

    public g aWF() {
        return this.ffz;
    }

    public PersonPolymericModel aWG() {
        return this.ffv;
    }

    public BlackListModel aWH() {
        return this.ffx;
    }

    public c aWI() {
        return this.ffw;
    }

    public d aWJ() {
        return this.ffu;
    }

    public void Qj() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ffu.aoP();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.ffu.h(false, -1);
            this.ffu.kk(true);
            this.ffv.cq(this.mUserId);
            this.ffv.cp(this.mUserId);
        } else {
            this.ffu.NZ();
            this.ffu.qn(8);
            this.ffu.J(this.ffs.getString(d.l.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ffu.aoP();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.ffv.cp(this.mUserId);
        } else {
            this.ffu.NZ();
            l.showToast(this.abz.getContext(), this.abz.getString(d.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.ffu.YW();
            this.ffu.cE(arrayList);
            this.ffu.aWD();
        }
    }

    public void kl(boolean z) {
        if (z) {
            this.ffA = z;
            if (com.baidu.adp.lib.util.j.gV()) {
                this.ffv.cp(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ffu.NZ();
        if (this.ffy != null) {
            this.ffy.a(aVar);
        }
        if (this.ffA && aVar != null && aVar.fgP != null && aVar.fgP.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fgP.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
        if (aVar != null) {
            this.ffu.d(aVar.getUserData());
        }
    }

    private void aWK() {
        this.ffy = new i();
        this.ffy.a(this.esL, this, this.mPageId, this.mUserId, this.isHost, this.fft);
        this.ffy.kj(this.ffB);
        this.ffy.b(this.ffs);
        this.ffy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ffy != null) {
                this.ffy.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ffy != null) {
            this.ffy.onDestroy();
        }
    }

    public void ki(boolean z) {
        if (this.ffy != null) {
            this.ffy.ki(z);
        }
    }

    public void onResume() {
        if (this.ffy != null) {
            this.ffy.onResume();
        }
    }
}
