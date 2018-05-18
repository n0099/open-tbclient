package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private final BaseFragmentActivity biB;
    private com.baidu.tieba.d.e dnW;
    private BaseFragment fJL;
    private final boolean fJM;
    private d fJN;
    private final PersonPolymericModel fJO;
    private final c fJP;
    private final BlackListModel fJQ;
    private a fJR;
    private g fJS;
    private boolean fJU;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fJT = false;
    private final d.b fJV = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bm(View view2) {
            e.this.OQ();
        }
    };

    public e(BaseFragment baseFragment, View view2, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.fJL = baseFragment;
        this.biB = this.fJL.getBaseFragmentActivity();
        this.mRootView = view2;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.fJU = z3;
        this.isHost = z;
        this.fJM = z2;
        this.mContext = this.biB.getPageContext();
        this.fJP = new c(this.fJL.getPageContext(), bdUniqueId);
        this.fJN = new d(this.fJL.getPageContext(), view2);
        this.fJN.a(this.fJV);
        this.fJO = new PersonPolymericModel(this.biB, bdUniqueId, z);
        this.fJO.a(this);
        this.fJO.a(this.fJP);
        this.fJQ = new BlackListModel(this.biB.getPageContext(), bdUniqueId);
        this.fJS = new g(this.biB.getPageContext(), bdUniqueId, z);
        this.fJS.a(this.fJO);
        bfi();
        OQ();
    }

    public a bfc() {
        return this.fJR;
    }

    public g bfd() {
        return this.fJS;
    }

    public PersonPolymericModel bfe() {
        return this.fJO;
    }

    public BlackListModel bff() {
        return this.fJQ;
    }

    public c bfg() {
        return this.fJP;
    }

    public d bfh() {
        return this.fJN;
    }

    public void OQ() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fJN.axe();
        } else if (com.baidu.adp.lib.util.j.gD()) {
            this.fJN.g(false, -1);
            this.fJN.lf(true);
            this.fJO.cN(this.mUserId);
            this.fJO.cM(this.mUserId);
        } else {
            this.fJN.Os();
            this.fJN.rg(8);
            this.fJN.E(this.fJL.getString(d.k.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fJN.axe();
        } else if (com.baidu.adp.lib.util.j.gD()) {
            this.fJO.cM(this.mUserId);
        } else {
            this.fJN.Os();
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fJN.Qn();
            this.fJN.cX(arrayList);
            this.fJN.bfb();
        }
    }

    public void lg(boolean z) {
        if (z) {
            this.fJT = z;
            if (com.baidu.adp.lib.util.j.gD()) {
                this.fJO.cM(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fJN.Os();
        if (this.fJR != null) {
            this.fJR.a(aVar);
        }
        if (this.fJT && aVar != null && aVar.fLn != null && aVar.fLn.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fLn.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.fJN.f(aVar.getUserData());
        }
    }

    private void bfi() {
        this.fJR = new i();
        this.fJR.a(this.biB, this, this.mPageId, this.mUserId, this.isHost, this.fJM);
        this.fJR.ld(this.fJU);
        this.fJR.b(this.fJL);
        this.fJR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || an.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.biB).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dnW == null) {
            this.dnW = new com.baidu.tieba.d.e(this.biB.getPageContext(), (NavigationBarCoverTip) this.biB.findViewById(d.g.navigation_cover_tip));
        }
        this.dnW.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fJR != null) {
                this.fJR.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fJR != null) {
            this.fJR.onDestroy();
        }
        if (this.fJO != null) {
            this.fJO.destroy();
        }
    }

    public void fW(boolean z) {
        if (this.fJR != null) {
            this.fJR.fW(z);
        }
    }

    public void onResume() {
        if (this.fJR != null) {
            this.fJR.onResume();
        }
    }
}
