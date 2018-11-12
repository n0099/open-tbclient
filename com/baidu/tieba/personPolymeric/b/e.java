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
    private final BaseFragmentActivity bIb;
    private com.baidu.tieba.c.f dTd;
    private BaseFragment gpS;
    private final boolean gpT;
    private d gpU;
    private final PersonPolymericModel gpV;
    private final c gpW;
    private final BlackListModel gpX;
    private a gpY;
    private g gpZ;
    private boolean gqb;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean gqa = false;
    private final d.b gqc = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bI(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gpS = baseFragment;
        this.bIb = this.gpS.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.gqb = z3;
        this.isHost = z;
        this.gpT = z2;
        this.mContext = this.bIb.getPageContext();
        this.gpW = new c(this.gpS.getPageContext(), bdUniqueId);
        this.gpU = new d(this.gpS.getPageContext(), view);
        this.gpU.a(this.gqc);
        this.gpV = new PersonPolymericModel(this.bIb, bdUniqueId, z);
        this.gpV.a(this);
        this.gpV.a(this.gpW);
        this.gpX = new BlackListModel(this.bIb.getPageContext(), bdUniqueId);
        this.gpZ = new g(this.bIb.getPageContext(), bdUniqueId, z);
        this.gpZ.a(this.gpV);
        bol();
        loadData();
    }

    public a bof() {
        return this.gpY;
    }

    public g bog() {
        return this.gpZ;
    }

    public PersonPolymericModel boh() {
        return this.gpV;
    }

    public BlackListModel boi() {
        return this.gpX;
    }

    public c boj() {
        return this.gpW;
    }

    public d bok() {
        return this.gpU;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gpU.aIk();
        } else if (j.kK()) {
            this.gpU.h(false, -1);
            this.gpU.mf(true);
            this.gpV.cQ(this.mUserId);
            this.gpV.cP(this.mUserId);
        } else {
            this.gpU.hideLoadingView();
            this.gpU.sL(8);
            this.gpU.M(this.gpS.getString(e.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gpU.aIk();
        } else if (j.kK()) {
            this.gpV.cP(this.mUserId);
        } else {
            this.gpU.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gpU.ZV();
            this.gpU.dp(arrayList);
            this.gpU.boe();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a mg(boolean z) {
        if (z) {
            this.gqa = z;
            if (j.kK()) {
                this.gpV.cP(this.mUserId);
            }
        }
        return this.gpV.boH();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gpU.hideLoadingView();
        if (this.gpY != null) {
            this.gpY.a(aVar);
        }
        if (this.gqa && aVar != null && aVar.gri != null && aVar.gri.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gri.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gpU.f(aVar.getUserData());
        }
    }

    private void bol() {
        this.gpY = new i();
        this.gpY.a(this.bIb, this, this.mPageId, this.mUserId, this.isHost, this.gpT);
        this.gpY.md(this.gqb);
        this.gpY.b(this.gpS);
        this.gpY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bIb).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dTd == null) {
            this.dTd = new com.baidu.tieba.c.f(this.bIb.getPageContext(), (NavigationBarCoverTip) this.bIb.findViewById(e.g.navigation_cover_tip));
        }
        this.dTd.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gpY != null) {
                this.gpY.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gpY != null) {
            this.gpY.onDestroy();
        }
        if (this.gpV != null) {
            this.gpV.destroy();
        }
    }

    public void gt(boolean z) {
        if (this.gpY != null) {
            this.gpY.gt(z);
        }
    }

    public void onResume() {
        if (this.gpY != null) {
            this.gpY.onResume();
        }
    }
}
