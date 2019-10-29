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
    private TbPageContext cfl;
    private com.baidu.tieba.c.f fNP;
    private final BaseFragmentActivity fyM;
    private BaseFragment irb;
    private final boolean irc;
    private d ird;
    private final PersonPolymericModel ire;
    private final c irf;
    private final BlackListModel irg;
    private a irh;
    private g iri;
    private boolean irk;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean irj = false;
    private final d.b irl = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cH(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.irb = baseFragment;
        this.fyM = this.irb.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.irk = z3;
        this.isHost = z;
        this.irc = z2;
        this.cfl = this.fyM.getPageContext();
        this.irf = new c(this.irb.getPageContext(), bdUniqueId);
        this.ird = new d(this.irb.getPageContext(), view);
        this.ird.a(this.irl);
        this.ire = new PersonPolymericModel(this.fyM, bdUniqueId, z);
        this.ire.a(this);
        this.ire.a(this.irf);
        this.irg = new BlackListModel(this.fyM.getPageContext(), bdUniqueId);
        this.iri = new g(this.fyM.getPageContext(), bdUniqueId, z);
        this.iri.a(this.ire);
        caT();
        loadData();
    }

    public a caN() {
        return this.irh;
    }

    public g caO() {
        return this.iri;
    }

    public PersonPolymericModel caP() {
        return this.ire;
    }

    public BlackListModel caQ() {
        return this.irg;
    }

    public c caR() {
        return this.irf;
    }

    public d caS() {
        return this.ird;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ird.bsX();
        } else if (j.isNetworkAvailableForImmediately()) {
            this.ird.p(false, -1);
            this.ird.py(true);
            this.ire.dN(this.mUserId);
            this.ire.dM(this.mUserId);
        } else {
            this.ird.hideLoadingView();
            this.ird.xy(8);
            this.ird.aj(this.irb.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ird.bsX();
        } else if (j.isNetworkAvailableForImmediately()) {
            this.ire.dM(this.mUserId);
        } else {
            this.ird.hideLoadingView();
            l.showToast(this.cfl.getContext(), this.cfl.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.ird.aKk();
            this.ird.ee(arrayList);
            this.ird.caM();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a pz(boolean z) {
        if (z) {
            this.irj = z;
            if (j.isNetworkAvailableForImmediately()) {
                this.ire.dM(this.mUserId);
            }
        }
        return this.ire.cbq();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ird.hideLoadingView();
        if (this.irh != null) {
            this.irh.a(aVar);
        }
        if (this.irj && aVar != null && aVar.isr != null && aVar.isr.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.isr.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
        if (aVar != null) {
            this.ird.d(aVar.getUserData());
        }
    }

    private void caT() {
        this.irh = new i();
        this.irh.a(this.fyM, this, this.mPageId, this.mUserId, this.isHost, this.irc);
        this.irh.pw(this.irk);
        this.irh.b(this.irb);
        this.irh.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.fyM).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fNP == null) {
            this.fNP = new com.baidu.tieba.c.f(this.fyM.getPageContext(), (NavigationBarCoverTip) this.fyM.findViewById(R.id.navigation_cover_tip));
        }
        this.fNP.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.irh != null) {
                this.irh.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.irh != null) {
            this.irh.onDestroy();
        }
        if (this.ire != null) {
            this.ire.destroy();
        }
    }

    public void jJ(boolean z) {
        if (this.irh != null) {
            this.irh.jJ(z);
        }
    }

    public void onResume() {
        if (this.irh != null) {
            this.irh.onResume();
        }
    }
}
