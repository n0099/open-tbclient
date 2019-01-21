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
    private final BaseFragmentActivity bMH;
    private com.baidu.tieba.c.f ede;
    private BaseFragment gAE;
    private final boolean gAF;
    private d gAG;
    private final PersonPolymericModel gAH;
    private final c gAI;
    private final BlackListModel gAJ;
    private a gAK;
    private g gAL;
    private boolean gAN;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean gAM = false;
    private final d.b gAO = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bL(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gAE = baseFragment;
        this.bMH = this.gAE.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.gAN = z3;
        this.isHost = z;
        this.gAF = z2;
        this.mContext = this.bMH.getPageContext();
        this.gAI = new c(this.gAE.getPageContext(), bdUniqueId);
        this.gAG = new d(this.gAE.getPageContext(), view);
        this.gAG.a(this.gAO);
        this.gAH = new PersonPolymericModel(this.bMH, bdUniqueId, z);
        this.gAH.a(this);
        this.gAH.a(this.gAI);
        this.gAJ = new BlackListModel(this.bMH.getPageContext(), bdUniqueId);
        this.gAL = new g(this.bMH.getPageContext(), bdUniqueId, z);
        this.gAL.a(this.gAH);
        bry();
        loadData();
    }

    public a brs() {
        return this.gAK;
    }

    public g brt() {
        return this.gAL;
    }

    public PersonPolymericModel bru() {
        return this.gAH;
    }

    public BlackListModel brv() {
        return this.gAJ;
    }

    public c brw() {
        return this.gAI;
    }

    public d brx() {
        return this.gAG;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gAG.aLo();
        } else if (j.kK()) {
            this.gAG.i(false, -1);
            this.gAG.ml(true);
            this.gAH.dc(this.mUserId);
            this.gAH.db(this.mUserId);
        } else {
            this.gAG.hideLoadingView();
            this.gAG.tw(8);
            this.gAG.N(this.gAE.getString(e.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gAG.aLo();
        } else if (j.kK()) {
            this.gAH.db(this.mUserId);
        } else {
            this.gAG.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gAG.abA();
            this.gAG.dv(arrayList);
            this.gAG.brr();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a mm(boolean z) {
        if (z) {
            this.gAM = z;
            if (j.kK()) {
                this.gAH.db(this.mUserId);
            }
        }
        return this.gAH.brU();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gAG.hideLoadingView();
        if (this.gAK != null) {
            this.gAK.a(aVar);
        }
        if (this.gAM && aVar != null && aVar.gBU != null && aVar.gBU.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gBU.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gAG.f(aVar.getUserData());
        }
    }

    private void bry() {
        this.gAK = new i();
        this.gAK.a(this.bMH, this, this.mPageId, this.mUserId, this.isHost, this.gAF);
        this.gAK.mj(this.gAN);
        this.gAK.b(this.gAE);
        this.gAK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bMH).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.ede == null) {
            this.ede = new com.baidu.tieba.c.f(this.bMH.getPageContext(), (NavigationBarCoverTip) this.bMH.findViewById(e.g.navigation_cover_tip));
        }
        this.ede.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gAK != null) {
                this.gAK.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gAK != null) {
            this.gAK.onDestroy();
        }
        if (this.gAH != null) {
            this.gAH.destroy();
        }
    }

    public void gA(boolean z) {
        if (this.gAK != null) {
            this.gAK.gA(z);
        }
    }

    public void onResume() {
        if (this.gAK != null) {
            this.gAK.onResume();
        }
    }
}
