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
    private TbPageContext aRG;
    private com.baidu.tieba.d.e dSB;
    private final BaseFragmentActivity fAb;
    private BaseFragment gnT;
    private final boolean gnU;
    private d gnV;
    private final PersonPolymericModel gnW;
    private final c gnX;
    private final BlackListModel gnY;
    private a gnZ;
    private g goa;
    private boolean goc;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean gob = false;
    private final d.b goe = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void cG(View view) {
            e.this.Ws();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.gnT = baseFragment;
        this.fAb = this.gnT.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.goc = z3;
        this.isHost = z;
        this.gnU = z2;
        this.aRG = this.fAb.getPageContext();
        this.gnX = new c(this.gnT.getPageContext(), bdUniqueId);
        this.gnV = new d(this.gnT.getPageContext(), view);
        this.gnV.a(this.goe);
        this.gnW = new PersonPolymericModel(this.fAb, bdUniqueId, z);
        this.gnW.a(this);
        this.gnW.a(this.gnX);
        this.gnY = new BlackListModel(this.fAb.getPageContext(), bdUniqueId);
        this.goa = new g(this.fAb.getPageContext(), bdUniqueId, z);
        this.goa.a(this.gnW);
        bke();
        Ws();
    }

    public a bjY() {
        return this.gnZ;
    }

    public g bjZ() {
        return this.goa;
    }

    public PersonPolymericModel bka() {
        return this.gnW;
    }

    public BlackListModel bkb() {
        return this.gnY;
    }

    public c bkc() {
        return this.gnX;
    }

    public d bkd() {
        return this.gnV;
    }

    public void Ws() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gnV.aCg();
        } else if (com.baidu.adp.lib.util.j.ox()) {
            this.gnV.k(false, -1);
            this.gnV.lz(true);
            this.gnW.cJ(this.mUserId);
            this.gnW.cI(this.mUserId);
        } else {
            this.gnV.VU();
            this.gnV.tL(8);
            this.gnV.H(this.gnT.getString(d.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.gnV.aCg();
        } else if (com.baidu.adp.lib.util.j.ox()) {
            this.gnW.cI(this.mUserId);
        } else {
            this.gnV.VU();
            l.showToast(this.aRG.getContext(), this.aRG.getString(d.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.gnV.XP();
            this.gnV.dc(arrayList);
            this.gnV.bjX();
        }
    }

    public void lA(boolean z) {
        if (z) {
            this.gob = z;
            if (com.baidu.adp.lib.util.j.ox()) {
                this.gnW.cI(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gnV.VU();
        if (this.gnZ != null) {
            this.gnZ.a(aVar);
        }
        if (this.gob && aVar != null && aVar.gps != null && aVar.gps.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.gps.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
        }
        if (aVar != null) {
            this.gnV.f(aVar.getUserData());
        }
    }

    private void bke() {
        this.gnZ = new i();
        this.gnZ.a(this.fAb, this, this.mPageId, this.mUserId, this.isHost, this.gnU);
        this.gnZ.ly(this.goc);
        this.gnZ.b(this.gnT);
        this.gnZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dSB == null) {
            this.dSB = new com.baidu.tieba.d.e(this.fAb.getPageContext(), (NavigationBarCoverTip) this.fAb.findViewById(d.g.navigation_cover_tip));
        }
        this.dSB.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gnZ != null) {
                this.gnZ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gnZ != null) {
            this.gnZ.onDestroy();
        }
    }

    public void gr(boolean z) {
        if (this.gnZ != null) {
            this.gnZ.gr(z);
        }
    }

    public void onResume() {
        if (this.gnZ != null) {
            this.gnZ.onResume();
        }
    }
}
