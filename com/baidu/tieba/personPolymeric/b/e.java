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
    private com.baidu.tieba.d.e dmO;
    private final BaseFragmentActivity epk;
    private BaseFragment fIF;
    private final boolean fIG;
    private d fIH;
    private final PersonPolymericModel fII;
    private final c fIJ;
    private final BlackListModel fIK;
    private a fIL;
    private g fIM;
    private boolean fIO;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fIN = false;
    private final d.b fIP = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bm(View view2) {
            e.this.OT();
        }
    };

    public e(BaseFragment baseFragment, View view2, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.fIF = baseFragment;
        this.epk = this.fIF.getBaseFragmentActivity();
        this.mRootView = view2;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.fIO = z3;
        this.isHost = z;
        this.fIG = z2;
        this.adf = this.epk.getPageContext();
        this.fIJ = new c(this.fIF.getPageContext(), bdUniqueId);
        this.fIH = new d(this.fIF.getPageContext(), view2);
        this.fIH.a(this.fIP);
        this.fII = new PersonPolymericModel(this.epk, bdUniqueId, z);
        this.fII.a(this);
        this.fII.a(this.fIJ);
        this.fIK = new BlackListModel(this.epk.getPageContext(), bdUniqueId);
        this.fIM = new g(this.epk.getPageContext(), bdUniqueId, z);
        this.fIM.a(this.fII);
        bfi();
        OT();
    }

    public a bfc() {
        return this.fIL;
    }

    public g bfd() {
        return this.fIM;
    }

    public PersonPolymericModel bfe() {
        return this.fII;
    }

    public BlackListModel bff() {
        return this.fIK;
    }

    public c bfg() {
        return this.fIJ;
    }

    public d bfh() {
        return this.fIH;
    }

    public void OT() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fIH.axf();
        } else if (com.baidu.adp.lib.util.j.gD()) {
            this.fIH.g(false, -1);
            this.fIH.le(true);
            this.fII.cN(this.mUserId);
            this.fII.cM(this.mUserId);
        } else {
            this.fIH.Ou();
            this.fIH.rh(8);
            this.fIH.E(this.fIF.getString(d.k.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fIH.axf();
        } else if (com.baidu.adp.lib.util.j.gD()) {
            this.fII.cM(this.mUserId);
        } else {
            this.fIH.Ou();
            l.showToast(this.adf.getContext(), this.adf.getString(d.k.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fIH.Qq();
            this.fIH.cU(arrayList);
            this.fIH.bfb();
        }
    }

    public void lf(boolean z) {
        if (z) {
            this.fIN = z;
            if (com.baidu.adp.lib.util.j.gD()) {
                this.fII.cM(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fIH.Ou();
        if (this.fIL != null) {
            this.fIL.a(aVar);
        }
        if (this.fIN && aVar != null && aVar.fKh != null && aVar.fKh.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fKh.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.fIH.f(aVar.getUserData());
        }
    }

    private void bfi() {
        this.fIL = new i();
        this.fIL.a(this.epk, this, this.mPageId, this.mUserId, this.isHost, this.fIG);
        this.fIL.lc(this.fIO);
        this.fIL.b(this.fIF);
        this.fIL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || an.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.epk).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dmO == null) {
            this.dmO = new com.baidu.tieba.d.e(this.epk.getPageContext(), (NavigationBarCoverTip) this.epk.findViewById(d.g.navigation_cover_tip));
        }
        this.dmO.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fIL != null) {
                this.fIL.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fIL != null) {
            this.fIL.onDestroy();
        }
        if (this.fII != null) {
            this.fII.destroy();
        }
    }

    public void fV(boolean z) {
        if (this.fIL != null) {
            this.fIL.fV(z);
        }
    }

    public void onResume() {
        if (this.fIL != null) {
            this.fIL.onResume();
        }
    }
}
