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
    private final BaseFragmentActivity dmS;
    private com.baidu.tieba.c.f fOv;
    private BaseFragment isB;
    private final boolean isC;
    private d isD;
    private final PersonPolymericModel isE;
    private final c isF;
    private final BlackListModel isG;
    private a isH;
    private final boolean isHost;
    private g isI;
    private boolean isK;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean isJ = false;
    private final d.b isL = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cL(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.isB = baseFragment;
        this.dmS = this.isB.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.isK = z3;
        this.isHost = z;
        this.isC = z2;
        this.mContext = this.dmS.getPageContext();
        this.isF = new c(this.isB.getPageContext(), bdUniqueId);
        this.isD = new d(this.isB.getPageContext(), view);
        this.isD.a(this.isL);
        this.isE = new PersonPolymericModel(this.dmS, bdUniqueId, z);
        this.isE.a(this);
        this.isE.a(this.isF);
        this.isG = new BlackListModel(this.dmS.getPageContext(), bdUniqueId);
        this.isI = new g(this.dmS.getPageContext(), bdUniqueId, z);
        this.isI.a(this.isE);
        cdS();
        loadData();
    }

    public a cdM() {
        return this.isH;
    }

    public g cdN() {
        return this.isI;
    }

    public PersonPolymericModel cdO() {
        return this.isE;
    }

    public BlackListModel cdP() {
        return this.isG;
    }

    public c cdQ() {
        return this.isF;
    }

    public d cdR() {
        return this.isD;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.isD.bvS();
        } else if (j.jQ()) {
            this.isD.o(false, -1);
            this.isD.pQ(true);
            this.isE.es(this.mUserId);
            this.isE.er(this.mUserId);
        } else {
            this.isD.hideLoadingView();
            this.isD.yT(8);
            this.isD.an(this.isB.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.isD.bvS();
        } else if (j.jQ()) {
            this.isE.er(this.mUserId);
        } else {
            this.isD.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.isD.aKQ();
            this.isD.dR(arrayList);
            this.isD.cdL();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a pR(boolean z) {
        if (z) {
            this.isJ = z;
            if (j.jQ()) {
                this.isE.er(this.mUserId);
            }
        }
        return this.isE.ceo();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.isD.hideLoadingView();
        if (this.isH != null) {
            this.isH.a(aVar);
        }
        if (this.isJ && aVar != null && aVar.itR != null && aVar.itR.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.itR.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.isD.e(aVar.getUserData());
        }
    }

    private void cdS() {
        this.isH = new i();
        this.isH.a(this.dmS, this, this.mPageId, this.mUserId, this.isHost, this.isC);
        this.isH.pO(this.isK);
        this.isH.b(this.isB);
        this.isH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.dmS).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fOv == null) {
            this.fOv = new com.baidu.tieba.c.f(this.dmS.getPageContext(), (NavigationBarCoverTip) this.dmS.findViewById(R.id.navigation_cover_tip));
        }
        this.fOv.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.isH != null) {
                this.isH.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.isH != null) {
            this.isH.onDestroy();
        }
        if (this.isE != null) {
            this.isE.destroy();
        }
    }

    public void jV(boolean z) {
        if (this.isH != null) {
            this.isH.jV(z);
        }
    }

    public void onResume() {
        if (this.isH != null) {
            this.isH.onResume();
        }
    }
}
