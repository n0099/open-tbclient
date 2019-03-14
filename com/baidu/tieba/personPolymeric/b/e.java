package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private final BaseFragmentActivity cYG;
    private com.baidu.tieba.c.f fqJ;
    private BaseFragment hQD;
    private final boolean hQE;
    private d hQF;
    private final PersonPolymericModel hQG;
    private final c hQH;
    private final BlackListModel hQI;
    private a hQJ;
    private g hQK;
    private boolean hQM;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean hQL = false;
    private final d.b hQN = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cy(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.hQD = baseFragment;
        this.cYG = this.hQD.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.hQM = z3;
        this.isHost = z;
        this.hQE = z2;
        this.mContext = this.cYG.getPageContext();
        this.hQH = new c(this.hQD.getPageContext(), bdUniqueId);
        this.hQF = new d(this.hQD.getPageContext(), view);
        this.hQF.a(this.hQN);
        this.hQG = new PersonPolymericModel(this.cYG, bdUniqueId, z);
        this.hQG.a(this);
        this.hQG.a(this.hQH);
        this.hQI = new BlackListModel(this.cYG.getPageContext(), bdUniqueId);
        this.hQK = new g(this.cYG.getPageContext(), bdUniqueId, z);
        this.hQK.a(this.hQG);
        bRW();
        loadData();
    }

    public a bRQ() {
        return this.hQJ;
    }

    public g bRR() {
        return this.hQK;
    }

    public PersonPolymericModel bRS() {
        return this.hQG;
    }

    public BlackListModel bRT() {
        return this.hQI;
    }

    public c bRU() {
        return this.hQH;
    }

    public d bRV() {
        return this.hQF;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.hQF.bls();
        } else if (j.kM()) {
            this.hQF.o(false, -1);
            this.hQF.oI(true);
            this.hQG.dH(this.mUserId);
            this.hQG.dG(this.mUserId);
        } else {
            this.hQF.hideLoadingView();
            this.hQF.xf(8);
            this.hQF.ah(this.hQD.getString(d.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.hQF.bls();
        } else if (j.kM()) {
            this.hQG.dG(this.mUserId);
        } else {
            this.hQF.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.hQF.aCw();
            this.hQF.dJ(arrayList);
            this.hQF.bRP();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a oJ(boolean z) {
        if (z) {
            this.hQL = z;
            if (j.kM()) {
                this.hQG.dG(this.mUserId);
            }
        }
        return this.hQG.bSs();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.hQF.hideLoadingView();
        if (this.hQJ != null) {
            this.hQJ.a(aVar);
        }
        if (this.hQL && aVar != null && aVar.hRT != null && aVar.hRT.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.hRT.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.hQF.e(aVar.getUserData());
        }
    }

    private void bRW() {
        this.hQJ = new i();
        this.hQJ.a(this.cYG, this, this.mPageId, this.mUserId, this.isHost, this.hQE);
        this.hQJ.oG(this.hQM);
        this.hQJ.b(this.hQD);
        this.hQJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.cYG).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fqJ == null) {
            this.fqJ = new com.baidu.tieba.c.f(this.cYG.getPageContext(), (NavigationBarCoverTip) this.cYG.findViewById(d.g.navigation_cover_tip));
        }
        this.fqJ.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hQJ != null) {
                this.hQJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.hQJ != null) {
            this.hQJ.onDestroy();
        }
        if (this.hQG != null) {
            this.hQG.destroy();
        }
    }

    public void iY(boolean z) {
        if (this.hQJ != null) {
            this.hQJ.iY(z);
        }
    }

    public void onResume() {
        if (this.hQJ != null) {
            this.hQJ.onResume();
        }
    }
}
