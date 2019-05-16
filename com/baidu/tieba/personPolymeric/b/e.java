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
    private final BaseFragmentActivity djr;
    private com.baidu.tieba.c.f fGQ;
    private BaseFragment ijc;
    private final boolean ijd;
    private d ije;
    private final PersonPolymericModel ijf;
    private final c ijg;
    private final BlackListModel ijh;
    private a iji;
    private g ijj;
    private boolean ijl;
    private final boolean isHost;
    private TbPageContext mContext;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean ijk = false;
    private final d.b ijm = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cG(View view) {
            e.this.loadData();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.ijc = baseFragment;
        this.djr = this.ijc.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.ijl = z3;
        this.isHost = z;
        this.ijd = z2;
        this.mContext = this.djr.getPageContext();
        this.ijg = new c(this.ijc.getPageContext(), bdUniqueId);
        this.ije = new d(this.ijc.getPageContext(), view);
        this.ije.a(this.ijm);
        this.ijf = new PersonPolymericModel(this.djr, bdUniqueId, z);
        this.ijf.a(this);
        this.ijf.a(this.ijg);
        this.ijh = new BlackListModel(this.djr.getPageContext(), bdUniqueId);
        this.ijj = new g(this.djr.getPageContext(), bdUniqueId, z);
        this.ijj.a(this.ijf);
        bZT();
        loadData();
    }

    public a bZN() {
        return this.iji;
    }

    public g bZO() {
        return this.ijj;
    }

    public PersonPolymericModel bZP() {
        return this.ijf;
    }

    public BlackListModel bZQ() {
        return this.ijh;
    }

    public c bZR() {
        return this.ijg;
    }

    public d bZS() {
        return this.ije;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ije.bsL();
        } else if (j.jG()) {
            this.ije.o(false, -1);
            this.ije.px(true);
            this.ijf.ef(this.mUserId);
            this.ijf.ee(this.mUserId);
        } else {
            this.ije.hideLoadingView();
            this.ije.yj(8);
            this.ije.aj(this.ijc.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.ije.bsL();
        } else if (j.jG()) {
            this.ijf.ee(this.mUserId);
        } else {
            this.ije.hideLoadingView();
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.ije.aIG();
            this.ije.dQ(arrayList);
            this.ije.bZM();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a py(boolean z) {
        if (z) {
            this.ijk = z;
            if (j.jG()) {
                this.ijf.ee(this.mUserId);
            }
        }
        return this.ijf.cap();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ije.hideLoadingView();
        if (this.iji != null) {
            this.iji.a(aVar);
        }
        if (this.ijk && aVar != null && aVar.iks != null && aVar.iks.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.iks.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.ije.e(aVar.getUserData());
        }
    }

    private void bZT() {
        this.iji = new i();
        this.iji.a(this.djr, this, this.mPageId, this.mUserId, this.isHost, this.ijd);
        this.iji.pv(this.ijl);
        this.iji.b(this.ijc);
        this.iji.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.djr).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fGQ == null) {
            this.fGQ = new com.baidu.tieba.c.f(this.djr.getPageContext(), (NavigationBarCoverTip) this.djr.findViewById(R.id.navigation_cover_tip));
        }
        this.fGQ.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iji != null) {
                this.iji.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.iji != null) {
            this.iji.onDestroy();
        }
        if (this.ijf != null) {
            this.ijf.destroy();
        }
    }

    public void jI(boolean z) {
        if (this.iji != null) {
            this.iji.jI(z);
        }
    }

    public void onResume() {
        if (this.iji != null) {
            this.iji.onResume();
        }
    }
}
