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
    private final BaseFragmentActivity dla;
    private com.baidu.tieba.c.f fLS;
    private d ipA;
    private final PersonPolymericModel ipB;
    private final c ipC;
    private final BlackListModel ipD;
    private a ipE;
    private g ipF;
    private boolean ipH;
    private BaseFragment ipy;
    private final boolean ipz;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean ipG = false;
    private final d.b ipI = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cJ(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.ipy = baseFragment;
        this.dla = this.ipy.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.ipH = z3;
        this.isHost = z;
        this.ipz = z2;
        this.mContext = this.dla.getPageContext();
        this.ipC = new c(this.ipy.getPageContext(), bdUniqueId);
        this.ipA = new d(this.ipy.getPageContext(), view);
        this.ipA.a(this.ipI);
        this.ipB = new PersonPolymericModel(this.dla, bdUniqueId, z);
        this.ipB.a(this);
        this.ipB.a(this.ipC);
        this.ipD = new BlackListModel(this.dla.getPageContext(), bdUniqueId);
        this.ipF = new g(this.dla.getPageContext(), bdUniqueId, z);
        this.ipF.a(this.ipB);
        ccM();
        loadData();
    }

    public a ccG() {
        return this.ipE;
    }

    public g ccH() {
        return this.ipF;
    }

    public PersonPolymericModel ccI() {
        return this.ipB;
    }

    public BlackListModel ccJ() {
        return this.ipD;
    }

    public c ccK() {
        return this.ipC;
    }

    public d ccL() {
        return this.ipA;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ipA.buR();
        } else if (j.jQ()) {
            this.ipA.o(false, -1);
            this.ipA.pM(true);
            this.ipB.ep(this.mUserId);
            this.ipB.eo(this.mUserId);
        } else {
            this.ipA.hideLoadingView();
            this.ipA.yO(8);
            this.ipA.an(this.ipy.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ipA.buR();
        } else if (j.jQ()) {
            this.ipB.eo(this.mUserId);
        } else {
            this.ipA.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.ipA.aKk();
            this.ipA.dS(arrayList);
            this.ipA.ccF();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a pN(boolean z) {
        if (z) {
            this.ipG = z;
            if (j.jQ()) {
                this.ipB.eo(this.mUserId);
            }
        }
        return this.ipB.cdi();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ipA.hideLoadingView();
        if (this.ipE != null) {
            this.ipE.a(aVar);
        }
        if (this.ipG && aVar != null && aVar.iqO != null && aVar.iqO.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.iqO.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.ipA.e(aVar.getUserData());
        }
    }

    private void ccM() {
        this.ipE = new i();
        this.ipE.a(this.dla, this, this.mPageId, this.mUserId, this.isHost, this.ipz);
        this.ipE.pK(this.ipH);
        this.ipE.b(this.ipy);
        this.ipE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.dla).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fLS == null) {
            this.fLS = new com.baidu.tieba.c.f(this.dla.getPageContext(), (NavigationBarCoverTip) this.dla.findViewById(R.id.navigation_cover_tip));
        }
        this.fLS.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ipE != null) {
                this.ipE.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ipE != null) {
            this.ipE.onDestroy();
        }
        if (this.ipB != null) {
            this.ipB.destroy();
        }
    }

    public void jS(boolean z) {
        if (this.ipE != null) {
            this.ipE.jS(z);
        }
    }

    public void onResume() {
        if (this.ipE != null) {
            this.ipE.onResume();
        }
    }
}
