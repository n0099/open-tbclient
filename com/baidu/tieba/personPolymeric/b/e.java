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
    private TbPageContext aRI;
    private com.baidu.tieba.d.e dSG;
    private final BaseFragmentActivity fAr;
    private BaseFragment gok;
    private final boolean gol;
    private d gom;
    private final PersonPolymericModel gon;
    private final c goo;
    private final BlackListModel gop;
    private a goq;
    private g gor;
    private boolean got;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean gos = false;
    private final d.b gou = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cG(View view) {
            e.this.Wt();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gok = baseFragment;
        this.fAr = this.gok.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.got = z3;
        this.isHost = z;
        this.gol = z2;
        this.aRI = this.fAr.getPageContext();
        this.goo = new c(this.gok.getPageContext(), bdUniqueId);
        this.gom = new d(this.gok.getPageContext(), view);
        this.gom.a(this.gou);
        this.gon = new PersonPolymericModel(this.fAr, bdUniqueId, z);
        this.gon.a(this);
        this.gon.a(this.goo);
        this.gop = new BlackListModel(this.fAr.getPageContext(), bdUniqueId);
        this.gor = new g(this.fAr.getPageContext(), bdUniqueId, z);
        this.gor.a(this.gon);
        bkf();
        Wt();
    }

    public a bjZ() {
        return this.goq;
    }

    public g bka() {
        return this.gor;
    }

    public PersonPolymericModel bkb() {
        return this.gon;
    }

    public BlackListModel bkc() {
        return this.gop;
    }

    public c bkd() {
        return this.goo;
    }

    public d bke() {
        return this.gom;
    }

    public void Wt() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gom.aCh();
        } else if (com.baidu.adp.lib.util.j.ox()) {
            this.gom.k(false, -1);
            this.gom.lE(true);
            this.gon.cJ(this.mUserId);
            this.gon.cI(this.mUserId);
        } else {
            this.gom.VV();
            this.gom.tL(8);
            this.gom.H(this.gok.getString(d.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gom.aCh();
        } else if (com.baidu.adp.lib.util.j.ox()) {
            this.gon.cI(this.mUserId);
        } else {
            this.gom.VV();
            l.showToast(this.aRI.getContext(), this.aRI.getString(d.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gom.XQ();
            this.gom.dc(arrayList);
            this.gom.bjY();
        }
    }

    public void lF(boolean z) {
        if (z) {
            this.gos = z;
            if (com.baidu.adp.lib.util.j.ox()) {
                this.gon.cI(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gom.VV();
        if (this.goq != null) {
            this.goq.a(aVar);
        }
        if (this.gos && aVar != null && aVar.gpI != null && aVar.gpI.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gpI.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gom.f(aVar.getUserData());
        }
    }

    private void bkf() {
        this.goq = new i();
        this.goq.a(this.fAr, this, this.mPageId, this.mUserId, this.isHost, this.gol);
        this.goq.lD(this.got);
        this.goq.b(this.gok);
        this.goq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dSG == null) {
            this.dSG = new com.baidu.tieba.d.e(this.fAr.getPageContext(), (NavigationBarCoverTip) this.fAr.findViewById(d.g.navigation_cover_tip));
        }
        this.dSG.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.goq != null) {
                this.goq.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.goq != null) {
            this.goq.onDestroy();
        }
    }

    public void gt(boolean z) {
        if (this.goq != null) {
            this.goq.gt(z);
        }
    }

    public void onResume() {
        if (this.goq != null) {
            this.goq.onResume();
        }
    }
}
