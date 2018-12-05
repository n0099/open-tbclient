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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.e;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private final BaseFragmentActivity bLQ;
    private com.baidu.tieba.c.f dZG;
    private BaseFragment gwI;
    private final boolean gwJ;
    private d gwK;
    private final PersonPolymericModel gwL;
    private final c gwM;
    private final BlackListModel gwN;
    private a gwO;
    private g gwP;
    private boolean gwR;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean gwQ = false;
    private final d.b gwS = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bI(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gwI = baseFragment;
        this.bLQ = this.gwI.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.gwR = z3;
        this.isHost = z;
        this.gwJ = z2;
        this.mContext = this.bLQ.getPageContext();
        this.gwM = new c(this.gwI.getPageContext(), bdUniqueId);
        this.gwK = new d(this.gwI.getPageContext(), view);
        this.gwK.a(this.gwS);
        this.gwL = new PersonPolymericModel(this.bLQ, bdUniqueId, z);
        this.gwL.a(this);
        this.gwL.a(this.gwM);
        this.gwN = new BlackListModel(this.bLQ.getPageContext(), bdUniqueId);
        this.gwP = new g(this.bLQ.getPageContext(), bdUniqueId, z);
        this.gwP.a(this.gwL);
        bqe();
        loadData();
    }

    public a bpY() {
        return this.gwO;
    }

    public g bpZ() {
        return this.gwP;
    }

    public PersonPolymericModel bqa() {
        return this.gwL;
    }

    public BlackListModel bqb() {
        return this.gwN;
    }

    public c bqc() {
        return this.gwM;
    }

    public d bqd() {
        return this.gwK;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gwK.aKb();
        } else if (j.kK()) {
            this.gwK.i(false, -1);
            this.gwK.mi(true);
            this.gwL.cX(this.mUserId);
            this.gwL.cW(this.mUserId);
        } else {
            this.gwK.hideLoadingView();
            this.gwK.tf(8);
            this.gwK.O(this.gwI.getString(e.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gwK.aKb();
        } else if (j.kK()) {
            this.gwL.cW(this.mUserId);
        } else {
            this.gwK.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gwK.abb();
            this.gwK.dt(arrayList);
            this.gwK.bpX();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a mj(boolean z) {
        if (z) {
            this.gwQ = z;
            if (j.kK()) {
                this.gwL.cW(this.mUserId);
            }
        }
        return this.gwL.bqA();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gwK.hideLoadingView();
        if (this.gwO != null) {
            this.gwO.a(aVar);
        }
        if (this.gwQ && aVar != null && aVar.gxY != null && aVar.gxY.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gxY.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gwK.f(aVar.getUserData());
        }
    }

    private void bqe() {
        this.gwO = new i();
        this.gwO.a(this.bLQ, this, this.mPageId, this.mUserId, this.isHost, this.gwJ);
        this.gwO.mg(this.gwR);
        this.gwO.b(this.gwI);
        this.gwO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bLQ).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dZG == null) {
            this.dZG = new com.baidu.tieba.c.f(this.bLQ.getPageContext(), (NavigationBarCoverTip) this.bLQ.findViewById(e.g.navigation_cover_tip));
        }
        this.dZG.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gwO != null) {
                this.gwO.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gwO != null) {
            this.gwO.onDestroy();
        }
        if (this.gwL != null) {
            this.gwL.destroy();
        }
    }

    public void gu(boolean z) {
        if (this.gwO != null) {
            this.gwO.gu(z);
        }
    }

    public void onResume() {
        if (this.gwO != null) {
            this.gwO.onResume();
        }
    }
}
