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
    private TbPageContext adf;
    private com.baidu.tieba.d.e dmR;
    private final BaseFragmentActivity epn;
    private BaseFragment fII;
    private final boolean fIJ;
    private d fIK;
    private final PersonPolymericModel fIL;
    private final c fIM;
    private final BlackListModel fIN;
    private a fIO;
    private g fIP;
    private boolean fIR;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fIQ = false;
    private final d.b fIS = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bm(View view2) {
            e.this.OT();
        }
    };

    public e(BaseFragment baseFragment, View view2, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.fII = baseFragment;
        this.epn = this.fII.getBaseFragmentActivity();
        this.mRootView = view2;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.fIR = z3;
        this.isHost = z;
        this.fIJ = z2;
        this.adf = this.epn.getPageContext();
        this.fIM = new c(this.fII.getPageContext(), bdUniqueId);
        this.fIK = new d(this.fII.getPageContext(), view2);
        this.fIK.a(this.fIS);
        this.fIL = new PersonPolymericModel(this.epn, bdUniqueId, z);
        this.fIL.a(this);
        this.fIL.a(this.fIM);
        this.fIN = new BlackListModel(this.epn.getPageContext(), bdUniqueId);
        this.fIP = new g(this.epn.getPageContext(), bdUniqueId, z);
        this.fIP.a(this.fIL);
        bfi();
        OT();
    }

    public a bfc() {
        return this.fIO;
    }

    public g bfd() {
        return this.fIP;
    }

    public PersonPolymericModel bfe() {
        return this.fIL;
    }

    public BlackListModel bff() {
        return this.fIN;
    }

    public c bfg() {
        return this.fIM;
    }

    public d bfh() {
        return this.fIK;
    }

    public void OT() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fIK.axf();
        } else if (com.baidu.adp.lib.util.j.gD()) {
            this.fIK.g(false, -1);
            this.fIK.le(true);
            this.fIL.cN(this.mUserId);
            this.fIL.cM(this.mUserId);
        } else {
            this.fIK.Ou();
            this.fIK.ri(8);
            this.fIK.E(this.fII.getString(d.k.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fIK.axf();
        } else if (com.baidu.adp.lib.util.j.gD()) {
            this.fIL.cM(this.mUserId);
        } else {
            this.fIK.Ou();
            l.showToast(this.adf.getContext(), this.adf.getString(d.k.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fIK.Qq();
            this.fIK.cU(arrayList);
            this.fIK.bfb();
        }
    }

    public void lf(boolean z) {
        if (z) {
            this.fIQ = z;
            if (com.baidu.adp.lib.util.j.gD()) {
                this.fIL.cM(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fIK.Ou();
        if (this.fIO != null) {
            this.fIO.a(aVar);
        }
        if (this.fIQ && aVar != null && aVar.fKk != null && aVar.fKk.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fKk.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.fIK.f(aVar.getUserData());
        }
    }

    private void bfi() {
        this.fIO = new i();
        this.fIO.a(this.epn, this, this.mPageId, this.mUserId, this.isHost, this.fIJ);
        this.fIO.lc(this.fIR);
        this.fIO.b(this.fII);
        this.fIO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || an.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.epn).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dmR == null) {
            this.dmR = new com.baidu.tieba.d.e(this.epn.getPageContext(), (NavigationBarCoverTip) this.epn.findViewById(d.g.navigation_cover_tip));
        }
        this.dmR.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fIO != null) {
                this.fIO.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fIO != null) {
            this.fIO.onDestroy();
        }
        if (this.fIL != null) {
            this.fIL.destroy();
        }
    }

    public void fV(boolean z) {
        if (this.fIO != null) {
            this.fIO.fV(z);
        }
    }

    public void onResume() {
        if (this.fIO != null) {
            this.fIO.onResume();
        }
    }
}
