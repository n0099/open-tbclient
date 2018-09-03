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
import com.baidu.tieba.f;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private final BaseFragmentActivity bsQ;
    private com.baidu.tieba.c.f dDk;
    private BaseFragment fZA;
    private final boolean fZB;
    private d fZC;
    private final PersonPolymericModel fZD;
    private final c fZE;
    private final BlackListModel fZF;
    private a fZG;
    private g fZH;
    private boolean fZJ;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fZI = false;
    private final d.b fZK = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bt(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.fZA = baseFragment;
        this.bsQ = this.fZA.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.fZJ = z3;
        this.isHost = z;
        this.fZB = z2;
        this.mContext = this.bsQ.getPageContext();
        this.fZE = new c(this.fZA.getPageContext(), bdUniqueId);
        this.fZC = new d(this.fZA.getPageContext(), view);
        this.fZC.a(this.fZK);
        this.fZD = new PersonPolymericModel(this.bsQ, bdUniqueId, z);
        this.fZD.a(this);
        this.fZD.a(this.fZE);
        this.fZF = new BlackListModel(this.bsQ.getPageContext(), bdUniqueId);
        this.fZH = new g(this.bsQ.getPageContext(), bdUniqueId, z);
        this.fZH.a(this.fZD);
        bje();
        loadData();
    }

    public a biY() {
        return this.fZG;
    }

    public g biZ() {
        return this.fZH;
    }

    public PersonPolymericModel bja() {
        return this.fZD;
    }

    public BlackListModel bjb() {
        return this.fZF;
    }

    public c bjc() {
        return this.fZE;
    }

    public d bjd() {
        return this.fZC;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fZC.aDh();
        } else if (j.js()) {
            this.fZC.g(false, -1);
            this.fZC.lh(true);
            this.fZD.cK(this.mUserId);
            this.fZD.cJ(this.mUserId);
        } else {
            this.fZC.hideLoadingView();
            this.fZC.ry(8);
            this.fZC.E(this.fZA.getString(f.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fZC.aDh();
        } else if (j.js()) {
            this.fZD.cJ(this.mUserId);
        } else {
            this.fZC.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(f.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fZC.Uq();
            this.fZC.dc(arrayList);
            this.fZC.biX();
        }
    }

    public void li(boolean z) {
        if (z) {
            this.fZI = z;
            if (j.js()) {
                this.fZD.cJ(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fZC.hideLoadingView();
        if (this.fZG != null) {
            this.fZG.a(aVar);
        }
        if (this.fZI && aVar != null && aVar.gaQ != null && aVar.gaQ.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gaQ.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.fZC.f(aVar.getUserData());
        }
    }

    private void bje() {
        this.fZG = new i();
        this.fZG.a(this.bsQ, this, this.mPageId, this.mUserId, this.isHost, this.fZB);
        this.fZG.lf(this.fZJ);
        this.fZG.b(this.fZA);
        this.fZG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bsQ).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dDk == null) {
            this.dDk = new com.baidu.tieba.c.f(this.bsQ.getPageContext(), (NavigationBarCoverTip) this.bsQ.findViewById(f.g.navigation_cover_tip));
        }
        this.dDk.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fZG != null) {
                this.fZG.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fZG != null) {
            this.fZG.onDestroy();
        }
        if (this.fZD != null) {
            this.fZD.destroy();
        }
    }

    public void fA(boolean z) {
        if (this.fZG != null) {
            this.fZG.fA(z);
        }
    }

    public void onResume() {
        if (this.fZG != null) {
            this.fZG.onResume();
        }
    }
}
