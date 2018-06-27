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
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private final BaseFragmentActivity bsf;
    private com.baidu.tieba.c.f dAB;
    private BaseFragment fZi;
    private final boolean fZj;
    private d fZk;
    private final PersonPolymericModel fZl;
    private final c fZm;
    private final BlackListModel fZn;
    private a fZo;
    private g fZp;
    private boolean fZr;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fZq = false;
    private final d.b fZs = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bq(View view) {
            e.this.SK();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.fZi = baseFragment;
        this.bsf = this.fZi.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.fZr = z3;
        this.isHost = z;
        this.fZj = z2;
        this.mContext = this.bsf.getPageContext();
        this.fZm = new c(this.fZi.getPageContext(), bdUniqueId);
        this.fZk = new d(this.fZi.getPageContext(), view);
        this.fZk.a(this.fZs);
        this.fZl = new PersonPolymericModel(this.bsf, bdUniqueId, z);
        this.fZl.a(this);
        this.fZl.a(this.fZm);
        this.fZn = new BlackListModel(this.bsf.getPageContext(), bdUniqueId);
        this.fZp = new g(this.bsf.getPageContext(), bdUniqueId, z);
        this.fZp.a(this.fZl);
        bkN();
        SK();
    }

    public a bkH() {
        return this.fZo;
    }

    public g bkI() {
        return this.fZp;
    }

    public PersonPolymericModel bkJ() {
        return this.fZl;
    }

    public BlackListModel bkK() {
        return this.fZn;
    }

    public c bkL() {
        return this.fZm;
    }

    public d bkM() {
        return this.fZk;
    }

    public void SK() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fZk.aCC();
        } else if (j.jr()) {
            this.fZk.g(false, -1);
            this.fZk.lv(true);
            this.fZl.cO(this.mUserId);
            this.fZl.cN(this.mUserId);
        } else {
            this.fZk.hideLoadingView();
            this.fZk.rB(8);
            this.fZk.F(this.fZi.getString(d.k.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fZk.aCC();
        } else if (j.jr()) {
            this.fZl.cN(this.mUserId);
        } else {
            this.fZk.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fZk.Uf();
            this.fZk.dg(arrayList);
            this.fZk.bkG();
        }
    }

    public void lw(boolean z) {
        if (z) {
            this.fZq = z;
            if (j.jr()) {
                this.fZl.cN(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fZk.hideLoadingView();
        if (this.fZo != null) {
            this.fZo.a(aVar);
        }
        if (this.fZq && aVar != null && aVar.gaz != null && aVar.gaz.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gaz.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.fZk.f(aVar.getUserData());
        }
    }

    private void bkN() {
        this.fZo = new i();
        this.fZo.a(this.bsf, this, this.mPageId, this.mUserId, this.isHost, this.fZj);
        this.fZo.lt(this.fZr);
        this.fZo.b(this.fZi);
        this.fZo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.bsf).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dAB == null) {
            this.dAB = new com.baidu.tieba.c.f(this.bsf.getPageContext(), (NavigationBarCoverTip) this.bsf.findViewById(d.g.navigation_cover_tip));
        }
        this.dAB.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fZo != null) {
                this.fZo.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fZo != null) {
            this.fZo.onDestroy();
        }
        if (this.fZl != null) {
            this.fZl.destroy();
        }
    }

    public void fy(boolean z) {
        if (this.fZo != null) {
            this.fZo.fy(z);
        }
    }

    public void onResume() {
        if (this.fZo != null) {
            this.fZo.onResume();
        }
    }
}
