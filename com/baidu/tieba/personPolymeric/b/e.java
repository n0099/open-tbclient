package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private final BaseFragmentActivity bqF;
    private com.baidu.tieba.c.f dxn;
    private BaseFragment fVg;
    private final boolean fVh;
    private d fVi;
    private final PersonPolymericModel fVj;
    private final c fVk;
    private final BlackListModel fVl;
    private a fVm;
    private g fVn;
    private boolean fVp;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fVo = false;
    private final d.b fVq = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bp(View view) {
            e.this.So();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.fVg = baseFragment;
        this.bqF = this.fVg.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.fVp = z3;
        this.isHost = z;
        this.fVh = z2;
        this.mContext = this.bqF.getPageContext();
        this.fVk = new c(this.fVg.getPageContext(), bdUniqueId);
        this.fVi = new d(this.fVg.getPageContext(), view);
        this.fVi.a(this.fVq);
        this.fVj = new PersonPolymericModel(this.bqF, bdUniqueId, z);
        this.fVj.a(this);
        this.fVj.a(this.fVk);
        this.fVl = new BlackListModel(this.bqF.getPageContext(), bdUniqueId);
        this.fVn = new g(this.bqF.getPageContext(), bdUniqueId, z);
        this.fVn.a(this.fVj);
        bki();
        So();
    }

    public a bkc() {
        return this.fVm;
    }

    public g bkd() {
        return this.fVn;
    }

    public PersonPolymericModel bke() {
        return this.fVj;
    }

    public BlackListModel bkf() {
        return this.fVl;
    }

    public c bkg() {
        return this.fVk;
    }

    public d bkh() {
        return this.fVi;
    }

    public void So() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fVi.aBW();
        } else if (com.baidu.adp.lib.util.j.jr()) {
            this.fVi.g(false, -1);
            this.fVi.ll(true);
            this.fVj.cT(this.mUserId);
            this.fVj.cS(this.mUserId);
        } else {
            this.fVi.hideLoadingView();
            this.fVi.rs(8);
            this.fVi.E(this.fVg.getString(d.k.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fVi.aBW();
        } else if (com.baidu.adp.lib.util.j.jr()) {
            this.fVj.cS(this.mUserId);
        } else {
            this.fVi.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fVi.TL();
            this.fVi.dc(arrayList);
            this.fVi.bkb();
        }
    }

    public void lm(boolean z) {
        if (z) {
            this.fVo = z;
            if (com.baidu.adp.lib.util.j.jr()) {
                this.fVj.cS(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fVi.hideLoadingView();
        if (this.fVm != null) {
            this.fVm.a(aVar);
        }
        if (this.fVo && aVar != null && aVar.fWz != null && aVar.fWz.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fWz.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.fVi.f(aVar.getUserData());
        }
    }

    private void bki() {
        this.fVm = new i();
        this.fVm.a(this.bqF, this, this.mPageId, this.mUserId, this.isHost, this.fVh);
        this.fVm.lj(this.fVp);
        this.fVm.b(this.fVg);
        this.fVm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bqF).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dxn == null) {
            this.dxn = new com.baidu.tieba.c.f(this.bqF.getPageContext(), (NavigationBarCoverTip) this.bqF.findViewById(d.g.navigation_cover_tip));
        }
        this.dxn.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fVm != null) {
                this.fVm.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fVm != null) {
            this.fVm.onDestroy();
        }
        if (this.fVj != null) {
            this.fVj.destroy();
        }
    }

    public void fw(boolean z) {
        if (this.fVm != null) {
            this.fVm.fw(z);
        }
    }

    public void onResume() {
        if (this.fVm != null) {
            this.fVm.onResume();
        }
    }
}
