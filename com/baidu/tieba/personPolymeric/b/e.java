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
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private final BaseFragmentActivity djs;
    private com.baidu.tieba.c.f fGU;
    private BaseFragment ijg;
    private final boolean ijh;
    private d iji;
    private final PersonPolymericModel ijj;
    private final c ijk;
    private final BlackListModel ijl;
    private a ijm;
    private g ijn;
    private boolean ijp;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean ijo = false;
    private final d.b ijq = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cG(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.ijg = baseFragment;
        this.djs = this.ijg.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.ijp = z3;
        this.isHost = z;
        this.ijh = z2;
        this.mContext = this.djs.getPageContext();
        this.ijk = new c(this.ijg.getPageContext(), bdUniqueId);
        this.iji = new d(this.ijg.getPageContext(), view);
        this.iji.a(this.ijq);
        this.ijj = new PersonPolymericModel(this.djs, bdUniqueId, z);
        this.ijj.a(this);
        this.ijj.a(this.ijk);
        this.ijl = new BlackListModel(this.djs.getPageContext(), bdUniqueId);
        this.ijn = new g(this.djs.getPageContext(), bdUniqueId, z);
        this.ijn.a(this.ijj);
        bZX();
        loadData();
    }

    public a bZR() {
        return this.ijm;
    }

    public g bZS() {
        return this.ijn;
    }

    public PersonPolymericModel bZT() {
        return this.ijj;
    }

    public BlackListModel bZU() {
        return this.ijl;
    }

    public c bZV() {
        return this.ijk;
    }

    public d bZW() {
        return this.iji;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.iji.bsQ();
        } else if (j.jG()) {
            this.iji.o(false, -1);
            this.iji.py(true);
            this.ijj.ef(this.mUserId);
            this.ijj.ee(this.mUserId);
        } else {
            this.iji.hideLoadingView();
            this.iji.yj(8);
            this.iji.aj(this.ijg.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.iji.bsQ();
        } else if (j.jG()) {
            this.ijj.ee(this.mUserId);
        } else {
            this.iji.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.iji.aIJ();
            this.iji.dQ(arrayList);
            this.iji.bZQ();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a pz(boolean z) {
        if (z) {
            this.ijo = z;
            if (j.jG()) {
                this.ijj.ee(this.mUserId);
            }
        }
        return this.ijj.cat();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.iji.hideLoadingView();
        if (this.ijm != null) {
            this.ijm.a(aVar);
        }
        if (this.ijo && aVar != null && aVar.ikw != null && aVar.ikw.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.ikw.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.iji.e(aVar.getUserData());
        }
    }

    private void bZX() {
        this.ijm = new i();
        this.ijm.a(this.djs, this, this.mPageId, this.mUserId, this.isHost, this.ijh);
        this.ijm.pw(this.ijp);
        this.ijm.b(this.ijg);
        this.ijm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.djs).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fGU == null) {
            this.fGU = new com.baidu.tieba.c.f(this.djs.getPageContext(), (NavigationBarCoverTip) this.djs.findViewById(R.id.navigation_cover_tip));
        }
        this.fGU.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ijm != null) {
                this.ijm.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ijm != null) {
            this.ijm.onDestroy();
        }
        if (this.ijj != null) {
            this.ijj.destroy();
        }
    }

    public void jI(boolean z) {
        if (this.ijm != null) {
            this.ijm.jI(z);
        }
    }

    public void onResume() {
        if (this.ijm != null) {
            this.ijm.onResume();
        }
    }
}
