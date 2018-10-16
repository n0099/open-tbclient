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
    private com.baidu.tieba.c.f dRW;
    private boolean goB;
    private BaseFragment gos;
    private final boolean got;
    private d gou;
    private final PersonPolymericModel gov;
    private final c gow;
    private final BlackListModel gox;
    private a goy;
    private g goz;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean goA = false;
    private final d.b goC = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bG(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gos = baseFragment;
        this.bHp = this.gos.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.goB = z3;
        this.isHost = z;
        this.got = z2;
        this.mContext = this.bHp.getPageContext();
        this.gow = new c(this.gos.getPageContext(), bdUniqueId);
        this.gou = new d(this.gos.getPageContext(), view);
        this.gou.a(this.goC);
        this.gov = new PersonPolymericModel(this.bHp, bdUniqueId, z);
        this.gov.a(this);
        this.gov.a(this.gow);
        this.gox = new BlackListModel(this.bHp.getPageContext(), bdUniqueId);
        this.goz = new g(this.bHp.getPageContext(), bdUniqueId, z);
        this.goz.a(this.gov);
        boQ();
        loadData();
    }

    public a boK() {
        return this.goy;
    }

    public g boL() {
        return this.goz;
    }

    public PersonPolymericModel boM() {
        return this.gov;
    }

    public BlackListModel boN() {
        return this.gox;
    }

    public c boO() {
        return this.gow;
    }

    public d boP() {
        return this.gou;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gou.aIM();
        } else if (j.kM()) {
            this.gou.h(false, -1);
            this.gou.lU(true);
            this.gov.cV(this.mUserId);
            this.gov.cU(this.mUserId);
        } else {
            this.gou.hideLoadingView();
            this.gou.ss(8);
            this.gou.M(this.gos.getString(e.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gou.aIM();
        } else if (j.kM()) {
            this.gov.cU(this.mUserId);
        } else {
            this.gou.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gou.ZK();
            this.gou.dr(arrayList);
            this.gou.boJ();
        }
    }

    public void lV(boolean z) {
        if (z) {
            this.goA = z;
            if (j.kM()) {
                this.gov.cU(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gou.hideLoadingView();
        if (this.goy != null) {
            this.goy.a(aVar);
        }
        if (this.goA && aVar != null && aVar.gpI != null && aVar.gpI.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gpI.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gou.f(aVar.getUserData());
        }
    }

    private void boQ() {
        this.goy = new i();
        this.goy.a(this.bHp, this, this.mPageId, this.mUserId, this.isHost, this.got);
        this.goy.lS(this.goB);
        this.goy.b(this.gos);
        this.goy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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
        if (this.dRW == null) {
            this.dRW = new com.baidu.tieba.c.f(this.bHp.getPageContext(), (NavigationBarCoverTip) this.bHp.findViewById(e.g.navigation_cover_tip));
        }
        this.dRW.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.goy != null) {
                this.goy.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.goy != null) {
            this.goy.onDestroy();
        }
        if (this.gov != null) {
            this.gov.destroy();
        }
    }

    public void gj(boolean z) {
        if (this.goy != null) {
            this.goy.gj(z);
        }
    }

    public void onResume() {
        if (this.goy != null) {
            this.goy.onResume();
        }
    }
}
