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
    private final BaseFragmentActivity dlh;
    private com.baidu.tieba.c.f fMG;
    private BaseFragment iqC;
    private final boolean iqD;
    private d iqE;
    private final PersonPolymericModel iqF;
    private final c iqG;
    private final BlackListModel iqH;
    private a iqI;
    private g iqJ;
    private boolean iqL;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean iqK = false;
    private final d.b iqM = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cL(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.iqC = baseFragment;
        this.dlh = this.iqC.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.iqL = z3;
        this.isHost = z;
        this.iqD = z2;
        this.mContext = this.dlh.getPageContext();
        this.iqG = new c(this.iqC.getPageContext(), bdUniqueId);
        this.iqE = new d(this.iqC.getPageContext(), view);
        this.iqE.a(this.iqM);
        this.iqF = new PersonPolymericModel(this.dlh, bdUniqueId, z);
        this.iqF.a(this);
        this.iqF.a(this.iqG);
        this.iqH = new BlackListModel(this.dlh.getPageContext(), bdUniqueId);
        this.iqJ = new g(this.dlh.getPageContext(), bdUniqueId, z);
        this.iqJ.a(this.iqF);
        cde();
        loadData();
    }

    public a ccY() {
        return this.iqI;
    }

    public g ccZ() {
        return this.iqJ;
    }

    public PersonPolymericModel cda() {
        return this.iqF;
    }

    public BlackListModel cdb() {
        return this.iqH;
    }

    public c cdc() {
        return this.iqG;
    }

    public d cdd() {
        return this.iqE;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.iqE.bve();
        } else if (j.jQ()) {
            this.iqE.o(false, -1);
            this.iqE.pN(true);
            this.iqF.ep(this.mUserId);
            this.iqF.eo(this.mUserId);
        } else {
            this.iqE.hideLoadingView();
            this.iqE.yQ(8);
            this.iqE.an(this.iqC.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.iqE.bve();
        } else if (j.jQ()) {
            this.iqF.eo(this.mUserId);
        } else {
            this.iqE.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.iqE.aKm();
            this.iqE.dR(arrayList);
            this.iqE.ccX();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a pO(boolean z) {
        if (z) {
            this.iqK = z;
            if (j.jQ()) {
                this.iqF.eo(this.mUserId);
            }
        }
        return this.iqF.cdA();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.iqE.hideLoadingView();
        if (this.iqI != null) {
            this.iqI.a(aVar);
        }
        if (this.iqK && aVar != null && aVar.irS != null && aVar.irS.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.irS.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.iqE.e(aVar.getUserData());
        }
    }

    private void cde() {
        this.iqI = new i();
        this.iqI.a(this.dlh, this, this.mPageId, this.mUserId, this.isHost, this.iqD);
        this.iqI.pL(this.iqL);
        this.iqI.b(this.iqC);
        this.iqI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.dlh).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fMG == null) {
            this.fMG = new com.baidu.tieba.c.f(this.dlh.getPageContext(), (NavigationBarCoverTip) this.dlh.findViewById(R.id.navigation_cover_tip));
        }
        this.fMG.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iqI != null) {
                this.iqI.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.iqI != null) {
            this.iqI.onDestroy();
        }
        if (this.iqF != null) {
            this.iqF.destroy();
        }
    }

    public void jS(boolean z) {
        if (this.iqI != null) {
            this.iqI.jS(z);
        }
    }

    public void onResume() {
        if (this.iqI != null) {
            this.iqI.onResume();
        }
    }
}
