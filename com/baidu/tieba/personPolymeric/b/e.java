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
    private final BaseFragmentActivity bMG;
    private com.baidu.tieba.c.f edd;
    private BaseFragment gAD;
    private final boolean gAE;
    private d gAF;
    private final PersonPolymericModel gAG;
    private final c gAH;
    private final BlackListModel gAI;
    private a gAJ;
    private g gAK;
    private boolean gAM;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean gAL = false;
    private final d.b gAN = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bL(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gAD = baseFragment;
        this.bMG = this.gAD.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.gAM = z3;
        this.isHost = z;
        this.gAE = z2;
        this.mContext = this.bMG.getPageContext();
        this.gAH = new c(this.gAD.getPageContext(), bdUniqueId);
        this.gAF = new d(this.gAD.getPageContext(), view);
        this.gAF.a(this.gAN);
        this.gAG = new PersonPolymericModel(this.bMG, bdUniqueId, z);
        this.gAG.a(this);
        this.gAG.a(this.gAH);
        this.gAI = new BlackListModel(this.bMG.getPageContext(), bdUniqueId);
        this.gAK = new g(this.bMG.getPageContext(), bdUniqueId, z);
        this.gAK.a(this.gAG);
        bry();
        loadData();
    }

    public a brs() {
        return this.gAJ;
    }

    public g brt() {
        return this.gAK;
    }

    public PersonPolymericModel bru() {
        return this.gAG;
    }

    public BlackListModel brv() {
        return this.gAI;
    }

    public c brw() {
        return this.gAH;
    }

    public d brx() {
        return this.gAF;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gAF.aLo();
        } else if (j.kK()) {
            this.gAF.i(false, -1);
            this.gAF.ml(true);
            this.gAG.dc(this.mUserId);
            this.gAG.db(this.mUserId);
        } else {
            this.gAF.hideLoadingView();
            this.gAF.tw(8);
            this.gAF.N(this.gAD.getString(e.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gAF.aLo();
        } else if (j.kK()) {
            this.gAG.db(this.mUserId);
        } else {
            this.gAF.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gAF.abA();
            this.gAF.dv(arrayList);
            this.gAF.brr();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a mm(boolean z) {
        if (z) {
            this.gAL = z;
            if (j.kK()) {
                this.gAG.db(this.mUserId);
            }
        }
        return this.gAG.brU();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gAF.hideLoadingView();
        if (this.gAJ != null) {
            this.gAJ.a(aVar);
        }
        if (this.gAL && aVar != null && aVar.gBT != null && aVar.gBT.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gBT.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gAF.f(aVar.getUserData());
        }
    }

    private void bry() {
        this.gAJ = new i();
        this.gAJ.a(this.bMG, this, this.mPageId, this.mUserId, this.isHost, this.gAE);
        this.gAJ.mj(this.gAM);
        this.gAJ.b(this.gAD);
        this.gAJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bMG).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.edd == null) {
            this.edd = new com.baidu.tieba.c.f(this.bMG.getPageContext(), (NavigationBarCoverTip) this.bMG.findViewById(e.g.navigation_cover_tip));
        }
        this.edd.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gAJ != null) {
                this.gAJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gAJ != null) {
            this.gAJ.onDestroy();
        }
        if (this.gAG != null) {
            this.gAG.destroy();
        }
    }

    public void gA(boolean z) {
        if (this.gAJ != null) {
            this.gAJ.gA(z);
        }
    }

    public void onResume() {
        if (this.gAJ != null) {
            this.gAJ.onResume();
        }
    }
}
