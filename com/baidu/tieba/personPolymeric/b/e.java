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
    private com.baidu.tieba.c.f fGR;
    private BaseFragment ijf;
    private final boolean ijg;
    private d ijh;
    private final PersonPolymericModel iji;
    private final c ijj;
    private final BlackListModel ijk;
    private a ijl;
    private g ijm;
    private boolean ijo;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean ijn = false;
    private final d.b ijp = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cG(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.ijf = baseFragment;
        this.djs = this.ijf.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.ijo = z3;
        this.isHost = z;
        this.ijg = z2;
        this.mContext = this.djs.getPageContext();
        this.ijj = new c(this.ijf.getPageContext(), bdUniqueId);
        this.ijh = new d(this.ijf.getPageContext(), view);
        this.ijh.a(this.ijp);
        this.iji = new PersonPolymericModel(this.djs, bdUniqueId, z);
        this.iji.a(this);
        this.iji.a(this.ijj);
        this.ijk = new BlackListModel(this.djs.getPageContext(), bdUniqueId);
        this.ijm = new g(this.djs.getPageContext(), bdUniqueId, z);
        this.ijm.a(this.iji);
        bZW();
        loadData();
    }

    public a bZQ() {
        return this.ijl;
    }

    public g bZR() {
        return this.ijm;
    }

    public PersonPolymericModel bZS() {
        return this.iji;
    }

    public BlackListModel bZT() {
        return this.ijk;
    }

    public c bZU() {
        return this.ijj;
    }

    public d bZV() {
        return this.ijh;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ijh.bsO();
        } else if (j.jG()) {
            this.ijh.o(false, -1);
            this.ijh.px(true);
            this.iji.ef(this.mUserId);
            this.iji.ee(this.mUserId);
        } else {
            this.ijh.hideLoadingView();
            this.ijh.yj(8);
            this.ijh.aj(this.ijf.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ijh.bsO();
        } else if (j.jG()) {
            this.iji.ee(this.mUserId);
        } else {
            this.ijh.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.ijh.aIJ();
            this.ijh.dQ(arrayList);
            this.ijh.bZP();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a py(boolean z) {
        if (z) {
            this.ijn = z;
            if (j.jG()) {
                this.iji.ee(this.mUserId);
            }
        }
        return this.iji.cas();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ijh.hideLoadingView();
        if (this.ijl != null) {
            this.ijl.a(aVar);
        }
        if (this.ijn && aVar != null && aVar.ikv != null && aVar.ikv.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.ikv.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.ijh.e(aVar.getUserData());
        }
    }

    private void bZW() {
        this.ijl = new i();
        this.ijl.a(this.djs, this, this.mPageId, this.mUserId, this.isHost, this.ijg);
        this.ijl.pv(this.ijo);
        this.ijl.b(this.ijf);
        this.ijl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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
        if (this.fGR == null) {
            this.fGR = new com.baidu.tieba.c.f(this.djs.getPageContext(), (NavigationBarCoverTip) this.djs.findViewById(R.id.navigation_cover_tip));
        }
        this.fGR.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ijl != null) {
                this.ijl.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ijl != null) {
            this.ijl.onDestroy();
        }
        if (this.iji != null) {
            this.iji.destroy();
        }
    }

    public void jI(boolean z) {
        if (this.ijl != null) {
            this.ijl.jI(z);
        }
    }

    public void onResume() {
        if (this.ijl != null) {
            this.ijl.onResume();
        }
    }
}
