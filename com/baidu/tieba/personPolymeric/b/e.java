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
    private final BaseFragmentActivity byH;
    private com.baidu.tieba.c.f dKa;
    private BaseFragment ggR;
    private final boolean ggS;
    private d ggT;
    private final PersonPolymericModel ggU;
    private final c ggV;
    private final BlackListModel ggW;
    private a ggX;
    private g ggY;
    private boolean gha;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean ggZ = false;
    private final d.b ghb = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bG(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.ggR = baseFragment;
        this.byH = this.ggR.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.gha = z3;
        this.isHost = z;
        this.ggS = z2;
        this.mContext = this.byH.getPageContext();
        this.ggV = new c(this.ggR.getPageContext(), bdUniqueId);
        this.ggT = new d(this.ggR.getPageContext(), view);
        this.ggT.a(this.ghb);
        this.ggU = new PersonPolymericModel(this.byH, bdUniqueId, z);
        this.ggU.a(this);
        this.ggU.a(this.ggV);
        this.ggW = new BlackListModel(this.byH.getPageContext(), bdUniqueId);
        this.ggY = new g(this.byH.getPageContext(), bdUniqueId, z);
        this.ggY.a(this.ggU);
        blF();
        loadData();
    }

    public a blz() {
        return this.ggX;
    }

    public g blA() {
        return this.ggY;
    }

    public PersonPolymericModel blB() {
        return this.ggU;
    }

    public BlackListModel blC() {
        return this.ggW;
    }

    public c blD() {
        return this.ggV;
    }

    public d blE() {
        return this.ggT;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ggT.aFu();
        } else if (j.ky()) {
            this.ggT.g(false, -1);
            this.ggT.lD(true);
            this.ggU.cO(this.mUserId);
            this.ggU.cN(this.mUserId);
        } else {
            this.ggT.hideLoadingView();
            this.ggT.rV(8);
            this.ggT.F(this.ggR.getString(e.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ggT.aFu();
        } else if (j.ky()) {
            this.ggU.cN(this.mUserId);
        } else {
            this.ggT.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.ggT.Wd();
            this.ggT.dd(arrayList);
            this.ggT.bly();
        }
    }

    public void lE(boolean z) {
        if (z) {
            this.ggZ = z;
            if (j.ky()) {
                this.ggU.cN(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ggT.hideLoadingView();
        if (this.ggX != null) {
            this.ggX.a(aVar);
        }
        if (this.ggZ && aVar != null && aVar.gii != null && aVar.gii.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gii.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.ggT.f(aVar.getUserData());
        }
    }

    private void blF() {
        this.ggX = new i();
        this.ggX.a(this.byH, this, this.mPageId, this.mUserId, this.isHost, this.ggS);
        this.ggX.lB(this.gha);
        this.ggX.b(this.ggR);
        this.ggX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.byH).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dKa == null) {
            this.dKa = new com.baidu.tieba.c.f(this.byH.getPageContext(), (NavigationBarCoverTip) this.byH.findViewById(e.g.navigation_cover_tip));
        }
        this.dKa.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ggX != null) {
                this.ggX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ggX != null) {
            this.ggX.onDestroy();
        }
        if (this.ggU != null) {
            this.ggU.destroy();
        }
    }

    public void fR(boolean z) {
        if (this.ggX != null) {
            this.ggX.fR(z);
        }
    }

    public void onResume() {
        if (this.ggX != null) {
            this.ggX.onResume();
        }
    }
}
