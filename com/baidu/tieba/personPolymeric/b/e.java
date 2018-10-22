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
    private final BaseFragmentActivity bHp;
    private com.baidu.tieba.c.f dRX;
    private g goA;
    private boolean goC;
    private BaseFragment got;
    private final boolean gou;
    private d gov;
    private final PersonPolymericModel gow;
    private final c gox;
    private final BlackListModel goy;
    private a goz;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean goB = false;
    private final d.b goD = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bG(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.got = baseFragment;
        this.bHp = this.got.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.goC = z3;
        this.isHost = z;
        this.gou = z2;
        this.mContext = this.bHp.getPageContext();
        this.gox = new c(this.got.getPageContext(), bdUniqueId);
        this.gov = new d(this.got.getPageContext(), view);
        this.gov.a(this.goD);
        this.gow = new PersonPolymericModel(this.bHp, bdUniqueId, z);
        this.gow.a(this);
        this.gow.a(this.gox);
        this.goy = new BlackListModel(this.bHp.getPageContext(), bdUniqueId);
        this.goA = new g(this.bHp.getPageContext(), bdUniqueId, z);
        this.goA.a(this.gow);
        boQ();
        loadData();
    }

    public a boK() {
        return this.goz;
    }

    public g boL() {
        return this.goA;
    }

    public PersonPolymericModel boM() {
        return this.gow;
    }

    public BlackListModel boN() {
        return this.goy;
    }

    public c boO() {
        return this.gox;
    }

    public d boP() {
        return this.gov;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gov.aIM();
        } else if (j.kM()) {
            this.gov.h(false, -1);
            this.gov.lU(true);
            this.gow.cV(this.mUserId);
            this.gow.cU(this.mUserId);
        } else {
            this.gov.hideLoadingView();
            this.gov.ss(8);
            this.gov.M(this.got.getString(e.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gov.aIM();
        } else if (j.kM()) {
            this.gow.cU(this.mUserId);
        } else {
            this.gov.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gov.ZL();
            this.gov.dr(arrayList);
            this.gov.boJ();
        }
    }

    public void lV(boolean z) {
        if (z) {
            this.goB = z;
            if (j.kM()) {
                this.gow.cU(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gov.hideLoadingView();
        if (this.goz != null) {
            this.goz.a(aVar);
        }
        if (this.goB && aVar != null && aVar.gpJ != null && aVar.gpJ.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gpJ.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gov.f(aVar.getUserData());
        }
    }

    private void boQ() {
        this.goz = new i();
        this.goz.a(this.bHp, this, this.mPageId, this.mUserId, this.isHost, this.gou);
        this.goz.lS(this.goC);
        this.goz.b(this.got);
        this.goz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bHp).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dRX == null) {
            this.dRX = new com.baidu.tieba.c.f(this.bHp.getPageContext(), (NavigationBarCoverTip) this.bHp.findViewById(e.g.navigation_cover_tip));
        }
        this.dRX.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.goz != null) {
                this.goz.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.goz != null) {
            this.goz.onDestroy();
        }
        if (this.gow != null) {
            this.gow.destroy();
        }
    }

    public void gj(boolean z) {
        if (this.goz != null) {
            this.goz.gj(z);
        }
    }

    public void onResume() {
        if (this.goz != null) {
            this.goz.onResume();
        }
    }
}
