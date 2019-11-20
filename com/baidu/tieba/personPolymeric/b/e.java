package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext ceu;
    private com.baidu.tieba.c.f fMY;
    private final BaseFragmentActivity fxV;
    private BaseFragment iqk;
    private final boolean iql;
    private d iqm;
    private final PersonPolymericModel iqn;
    private final c iqo;
    private final BlackListModel iqp;
    private a iqq;
    private g iqr;
    private boolean iqt;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean iqs = false;
    private final d.b iqu = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cH(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.iqk = baseFragment;
        this.fxV = this.iqk.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.iqt = z3;
        this.isHost = z;
        this.iql = z2;
        this.ceu = this.fxV.getPageContext();
        this.iqo = new c(this.iqk.getPageContext(), bdUniqueId);
        this.iqm = new d(this.iqk.getPageContext(), view);
        this.iqm.a(this.iqu);
        this.iqn = new PersonPolymericModel(this.fxV, bdUniqueId, z);
        this.iqn.a(this);
        this.iqn.a(this.iqo);
        this.iqp = new BlackListModel(this.fxV.getPageContext(), bdUniqueId);
        this.iqr = new g(this.fxV.getPageContext(), bdUniqueId, z);
        this.iqr.a(this.iqn);
        caR();
        loadData();
    }

    public a caL() {
        return this.iqq;
    }

    public g caM() {
        return this.iqr;
    }

    public PersonPolymericModel caN() {
        return this.iqn;
    }

    public BlackListModel caO() {
        return this.iqp;
    }

    public c caP() {
        return this.iqo;
    }

    public d caQ() {
        return this.iqm;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.iqm.bsV();
        } else if (j.isNetworkAvailableForImmediately()) {
            this.iqm.p(false, -1);
            this.iqm.py(true);
            this.iqn.dM(this.mUserId);
            this.iqn.dL(this.mUserId);
        } else {
            this.iqm.hideLoadingView();
            this.iqm.xx(8);
            this.iqm.aj(this.iqk.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.iqm.bsV();
        } else if (j.isNetworkAvailableForImmediately()) {
            this.iqn.dL(this.mUserId);
        } else {
            this.iqm.hideLoadingView();
            l.showToast(this.ceu.getContext(), this.ceu.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.iqm.aKi();
            this.iqm.ee(arrayList);
            this.iqm.caK();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a pz(boolean z) {
        if (z) {
            this.iqs = z;
            if (j.isNetworkAvailableForImmediately()) {
                this.iqn.dL(this.mUserId);
            }
        }
        return this.iqn.cbo();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.iqm.hideLoadingView();
        if (this.iqq != null) {
            this.iqq.a(aVar);
        }
        if (this.iqs && aVar != null && aVar.irA != null && aVar.irA.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.irA.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
        if (aVar != null) {
            this.iqm.d(aVar.getUserData());
        }
    }

    private void caR() {
        this.iqq = new i();
        this.iqq.a(this.fxV, this, this.mPageId, this.mUserId, this.isHost, this.iql);
        this.iqq.pw(this.iqt);
        this.iqq.b(this.iqk);
        this.iqq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.fxV).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fMY == null) {
            this.fMY = new com.baidu.tieba.c.f(this.fxV.getPageContext(), (NavigationBarCoverTip) this.fxV.findViewById(R.id.navigation_cover_tip));
        }
        this.fMY.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iqq != null) {
                this.iqq.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.iqq != null) {
            this.iqq.onDestroy();
        }
        if (this.iqn != null) {
            this.iqn.destroy();
        }
    }

    public void jJ(boolean z) {
        if (this.iqq != null) {
            this.iqq.jJ(z);
        }
    }

    public void onResume() {
        if (this.iqq != null) {
            this.iqq.onResume();
        }
    }
}
