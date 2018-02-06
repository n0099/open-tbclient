package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private TbPageContext aRR;
    private com.baidu.tieba.d.e dSN;
    private final BaseFragmentActivity fAn;
    private BaseFragment gof;
    private final boolean gog;
    private d goh;
    private final PersonPolymericModel goi;
    private final c goj;
    private final BlackListModel gok;
    private a gol;
    private g gom;
    private boolean goo;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean gon = false;
    private final d.b gop = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cG(View view) {
            e.this.Wt();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gof = baseFragment;
        this.fAn = this.gof.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.goo = z3;
        this.isHost = z;
        this.gog = z2;
        this.aRR = this.fAn.getPageContext();
        this.goj = new c(this.gof.getPageContext(), bdUniqueId);
        this.goh = new d(this.gof.getPageContext(), view);
        this.goh.a(this.gop);
        this.goi = new PersonPolymericModel(this.fAn, bdUniqueId, z);
        this.goi.a(this);
        this.goi.a(this.goj);
        this.gok = new BlackListModel(this.fAn.getPageContext(), bdUniqueId);
        this.gom = new g(this.fAn.getPageContext(), bdUniqueId, z);
        this.gom.a(this.goi);
        bkf();
        Wt();
    }

    public a bjZ() {
        return this.gol;
    }

    public g bka() {
        return this.gom;
    }

    public PersonPolymericModel bkb() {
        return this.goi;
    }

    public BlackListModel bkc() {
        return this.gok;
    }

    public c bkd() {
        return this.goj;
    }

    public d bke() {
        return this.goh;
    }

    public void Wt() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.goh.aCh();
        } else if (com.baidu.adp.lib.util.j.ox()) {
            this.goh.k(false, -1);
            this.goh.lz(true);
            this.goi.cJ(this.mUserId);
            this.goi.cI(this.mUserId);
        } else {
            this.goh.VV();
            this.goh.tK(8);
            this.goh.I(this.gof.getString(d.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.goh.aCh();
        } else if (com.baidu.adp.lib.util.j.ox()) {
            this.goi.cI(this.mUserId);
        } else {
            this.goh.VV();
            l.showToast(this.aRR.getContext(), this.aRR.getString(d.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.goh.XQ();
            this.goh.dc(arrayList);
            this.goh.bjY();
        }
    }

    public void lA(boolean z) {
        if (z) {
            this.gon = z;
            if (com.baidu.adp.lib.util.j.ox()) {
                this.goi.cI(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.goh.VV();
        if (this.gol != null) {
            this.gol.a(aVar);
        }
        if (this.gon && aVar != null && aVar.gpD != null && aVar.gpD.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gpD.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.goh.f(aVar.getUserData());
        }
    }

    private void bkf() {
        this.gol = new i();
        this.gol.a(this.fAn, this, this.mPageId, this.mUserId, this.isHost, this.gog);
        this.gol.ly(this.goo);
        this.gol.b(this.gof);
        this.gol.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dSN == null) {
            this.dSN = new com.baidu.tieba.d.e(this.fAn.getPageContext(), (NavigationBarCoverTip) this.fAn.findViewById(d.g.navigation_cover_tip));
        }
        this.dSN.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gol != null) {
                this.gol.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gol != null) {
            this.gol.onDestroy();
        }
    }

    public void gr(boolean z) {
        if (this.gol != null) {
            this.gol.gr(z);
        }
    }

    public void onResume() {
        if (this.gol != null) {
            this.gol.onResume();
        }
    }
}
