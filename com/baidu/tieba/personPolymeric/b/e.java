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
    private final BaseFragmentActivity cYK;
    private com.baidu.tieba.c.f fqv;
    private BaseFragment hQq;
    private final boolean hQr;
    private d hQs;
    private final PersonPolymericModel hQt;
    private final c hQu;
    private final BlackListModel hQv;
    private a hQw;
    private g hQx;
    private boolean hQz;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean hQy = false;
    private final d.b hQA = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cy(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.hQq = baseFragment;
        this.cYK = this.hQq.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.hQz = z3;
        this.isHost = z;
        this.hQr = z2;
        this.mContext = this.cYK.getPageContext();
        this.hQu = new c(this.hQq.getPageContext(), bdUniqueId);
        this.hQs = new d(this.hQq.getPageContext(), view);
        this.hQs.a(this.hQA);
        this.hQt = new PersonPolymericModel(this.cYK, bdUniqueId, z);
        this.hQt.a(this);
        this.hQt.a(this.hQu);
        this.hQv = new BlackListModel(this.cYK.getPageContext(), bdUniqueId);
        this.hQx = new g(this.cYK.getPageContext(), bdUniqueId, z);
        this.hQx.a(this.hQt);
        bRS();
        loadData();
    }

    public a bRM() {
        return this.hQw;
    }

    public g bRN() {
        return this.hQx;
    }

    public PersonPolymericModel bRO() {
        return this.hQt;
    }

    public BlackListModel bRP() {
        return this.hQv;
    }

    public c bRQ() {
        return this.hQu;
    }

    public d bRR() {
        return this.hQs;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.hQs.blp();
        } else if (j.kM()) {
            this.hQs.o(false, -1);
            this.hQs.oI(true);
            this.hQt.dH(this.mUserId);
            this.hQt.dG(this.mUserId);
        } else {
            this.hQs.hideLoadingView();
            this.hQs.xb(8);
            this.hQs.ah(this.hQq.getString(d.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.hQs.blp();
        } else if (j.kM()) {
            this.hQt.dG(this.mUserId);
        } else {
            this.hQs.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.hQs.aCt();
            this.hQs.dG(arrayList);
            this.hQs.bRL();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a oJ(boolean z) {
        if (z) {
            this.hQy = z;
            if (j.kM()) {
                this.hQt.dG(this.mUserId);
            }
        }
        return this.hQt.bSo();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.hQs.hideLoadingView();
        if (this.hQw != null) {
            this.hQw.a(aVar);
        }
        if (this.hQy && aVar != null && aVar.hRG != null && aVar.hRG.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.hRG.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.hQs.e(aVar.getUserData());
        }
    }

    private void bRS() {
        this.hQw = new i();
        this.hQw.a(this.cYK, this, this.mPageId, this.mUserId, this.isHost, this.hQr);
        this.hQw.oG(this.hQz);
        this.hQw.b(this.hQq);
        this.hQw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.cYK).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fqv == null) {
            this.fqv = new com.baidu.tieba.c.f(this.cYK.getPageContext(), (NavigationBarCoverTip) this.cYK.findViewById(d.g.navigation_cover_tip));
        }
        this.fqv.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hQw != null) {
                this.hQw.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.hQw != null) {
            this.hQw.onDestroy();
        }
        if (this.hQt != null) {
            this.hQt.destroy();
        }
    }

    public void iY(boolean z) {
        if (this.hQw != null) {
            this.hQw.iY(z);
        }
    }

    public void onResume() {
        if (this.hQw != null) {
            this.hQw.onResume();
        }
    }
}
