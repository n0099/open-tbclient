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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private final BaseFragmentActivity cYJ;
    private com.baidu.tieba.c.f fqv;
    private BaseFragment hQp;
    private final boolean hQq;
    private d hQr;
    private final PersonPolymericModel hQs;
    private final c hQt;
    private final BlackListModel hQu;
    private a hQv;
    private g hQw;
    private boolean hQy;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean hQx = false;
    private final d.b hQz = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cy(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.hQp = baseFragment;
        this.cYJ = this.hQp.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.hQy = z3;
        this.isHost = z;
        this.hQq = z2;
        this.mContext = this.cYJ.getPageContext();
        this.hQt = new c(this.hQp.getPageContext(), bdUniqueId);
        this.hQr = new d(this.hQp.getPageContext(), view);
        this.hQr.a(this.hQz);
        this.hQs = new PersonPolymericModel(this.cYJ, bdUniqueId, z);
        this.hQs.a(this);
        this.hQs.a(this.hQt);
        this.hQu = new BlackListModel(this.cYJ.getPageContext(), bdUniqueId);
        this.hQw = new g(this.cYJ.getPageContext(), bdUniqueId, z);
        this.hQw.a(this.hQs);
        bRS();
        loadData();
    }

    public a bRM() {
        return this.hQv;
    }

    public g bRN() {
        return this.hQw;
    }

    public PersonPolymericModel bRO() {
        return this.hQs;
    }

    public BlackListModel bRP() {
        return this.hQu;
    }

    public c bRQ() {
        return this.hQt;
    }

    public d bRR() {
        return this.hQr;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.hQr.blp();
        } else if (j.kM()) {
            this.hQr.o(false, -1);
            this.hQr.oI(true);
            this.hQs.dH(this.mUserId);
            this.hQs.dG(this.mUserId);
        } else {
            this.hQr.hideLoadingView();
            this.hQr.xb(8);
            this.hQr.ah(this.hQp.getString(d.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.hQr.blp();
        } else if (j.kM()) {
            this.hQs.dG(this.mUserId);
        } else {
            this.hQr.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.hQr.aCt();
            this.hQr.dG(arrayList);
            this.hQr.bRL();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a oJ(boolean z) {
        if (z) {
            this.hQx = z;
            if (j.kM()) {
                this.hQs.dG(this.mUserId);
            }
        }
        return this.hQs.bSo();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.hQr.hideLoadingView();
        if (this.hQv != null) {
            this.hQv.a(aVar);
        }
        if (this.hQx && aVar != null && aVar.hRF != null && aVar.hRF.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.hRF.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.hQr.e(aVar.getUserData());
        }
    }

    private void bRS() {
        this.hQv = new i();
        this.hQv.a(this.cYJ, this, this.mPageId, this.mUserId, this.isHost, this.hQq);
        this.hQv.oG(this.hQy);
        this.hQv.b(this.hQp);
        this.hQv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.cYJ).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fqv == null) {
            this.fqv = new com.baidu.tieba.c.f(this.cYJ.getPageContext(), (NavigationBarCoverTip) this.cYJ.findViewById(d.g.navigation_cover_tip));
        }
        this.fqv.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hQv != null) {
                this.hQv.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.hQv != null) {
            this.hQv.onDestroy();
        }
        if (this.hQs != null) {
            this.hQs.destroy();
        }
    }

    public void iY(boolean z) {
        if (this.hQv != null) {
            this.hQv.iY(z);
        }
    }

    public void onResume() {
        if (this.hQv != null) {
            this.hQv.onResume();
        }
    }
}
