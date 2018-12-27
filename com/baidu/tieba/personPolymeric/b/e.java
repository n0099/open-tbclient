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
    private final BaseFragmentActivity bLT;
    private com.baidu.tieba.c.f ecx;
    private final boolean gzA;
    private d gzB;
    private final PersonPolymericModel gzC;
    private final c gzD;
    private final BlackListModel gzE;
    private a gzF;
    private g gzG;
    private boolean gzI;
    private BaseFragment gzz;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean gzH = false;
    private final d.b gzJ = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bL(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gzz = baseFragment;
        this.bLT = this.gzz.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.gzI = z3;
        this.isHost = z;
        this.gzA = z2;
        this.mContext = this.bLT.getPageContext();
        this.gzD = new c(this.gzz.getPageContext(), bdUniqueId);
        this.gzB = new d(this.gzz.getPageContext(), view);
        this.gzB.a(this.gzJ);
        this.gzC = new PersonPolymericModel(this.bLT, bdUniqueId, z);
        this.gzC.a(this);
        this.gzC.a(this.gzD);
        this.gzE = new BlackListModel(this.bLT.getPageContext(), bdUniqueId);
        this.gzG = new g(this.bLT.getPageContext(), bdUniqueId, z);
        this.gzG.a(this.gzC);
        bqP();
        loadData();
    }

    public a bqJ() {
        return this.gzF;
    }

    public g bqK() {
        return this.gzG;
    }

    public PersonPolymericModel bqL() {
        return this.gzC;
    }

    public BlackListModel bqM() {
        return this.gzE;
    }

    public c bqN() {
        return this.gzD;
    }

    public d bqO() {
        return this.gzB;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gzB.aKQ();
        } else if (j.kK()) {
            this.gzB.i(false, -1);
            this.gzB.ml(true);
            this.gzC.dc(this.mUserId);
            this.gzC.db(this.mUserId);
        } else {
            this.gzB.hideLoadingView();
            this.gzB.ts(8);
            this.gzB.O(this.gzz.getString(e.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gzB.aKQ();
        } else if (j.kK()) {
            this.gzC.db(this.mUserId);
        } else {
            this.gzB.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gzB.abd();
            this.gzB.du(arrayList);
            this.gzB.bqI();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a mm(boolean z) {
        if (z) {
            this.gzH = z;
            if (j.kK()) {
                this.gzC.db(this.mUserId);
            }
        }
        return this.gzC.brl();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gzB.hideLoadingView();
        if (this.gzF != null) {
            this.gzF.a(aVar);
        }
        if (this.gzH && aVar != null && aVar.gAP != null && aVar.gAP.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gAP.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gzB.f(aVar.getUserData());
        }
    }

    private void bqP() {
        this.gzF = new i();
        this.gzF.a(this.bLT, this, this.mPageId, this.mUserId, this.isHost, this.gzA);
        this.gzF.mj(this.gzI);
        this.gzF.b(this.gzz);
        this.gzF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bLT).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.ecx == null) {
            this.ecx = new com.baidu.tieba.c.f(this.bLT.getPageContext(), (NavigationBarCoverTip) this.bLT.findViewById(e.g.navigation_cover_tip));
        }
        this.ecx.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gzF != null) {
                this.gzF.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gzF != null) {
            this.gzF.onDestroy();
        }
        if (this.gzC != null) {
            this.gzC.destroy();
        }
    }

    public void gx(boolean z) {
        if (this.gzF != null) {
            this.gzF.gx(z);
        }
    }

    public void onResume() {
        if (this.gzF != null) {
            this.gzF.onResume();
        }
    }
}
