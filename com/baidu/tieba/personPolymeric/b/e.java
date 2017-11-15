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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext abI;
    private final BaseFragmentActivity eBb;
    private BaseFragment fnQ;
    private final boolean fnR;
    private d fnS;
    private final PersonPolymericModel fnT;
    private final c fnU;
    private final BlackListModel fnV;
    private a fnW;
    private g fnX;
    private boolean fnZ;
    private final boolean isHost;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private int mSkinType = 3;
    private boolean fnY = false;
    private final d.b foa = new d.b() { // from class: com.baidu.tieba.personPolymeric.b.e.1
        @Override // com.baidu.tieba.personPolymeric.b.d.b
        public void bv(View view) {
            e.this.RG();
        }
    };

    public e(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, boolean z3) {
        this.fnQ = baseFragment;
        this.eBb = this.fnQ.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.fnZ = z3;
        this.isHost = z;
        this.fnR = z2;
        this.abI = this.eBb.getPageContext();
        this.fnU = new c(this.fnQ.getPageContext(), bdUniqueId);
        this.fnS = new d(this.fnQ.getPageContext(), view);
        this.fnS.a(this.foa);
        this.fnT = new PersonPolymericModel(this.eBb, bdUniqueId, z);
        this.fnT.a(this);
        this.fnT.a(this.fnU);
        this.fnV = new BlackListModel(this.eBb.getPageContext(), bdUniqueId);
        this.fnX = new g(this.eBb.getPageContext(), bdUniqueId, z);
        this.fnX.a(this.fnT);
        aZP();
        RG();
    }

    public a aZJ() {
        return this.fnW;
    }

    public g aZK() {
        return this.fnX;
    }

    public PersonPolymericModel aZL() {
        return this.fnT;
    }

    public BlackListModel aZM() {
        return this.fnV;
    }

    public c aZN() {
        return this.fnU;
    }

    public d aZO() {
        return this.fnS;
    }

    public void RG() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fnS.arz();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.fnS.g(false, -1);
            this.fnS.kj(true);
            this.fnT.cs(this.mUserId);
            this.fnT.cr(this.mUserId);
        } else {
            this.fnS.Nk();
            this.fnS.qD(8);
            this.fnS.H(this.fnQ.getString(d.j.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.isHost) {
            this.fnS.arz();
        } else if (com.baidu.adp.lib.util.j.gV()) {
            this.fnT.cr(this.mUserId);
        } else {
            this.fnS.Nk();
            l.showToast(this.abI.getContext(), this.abI.getString(d.j.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.isHost;
            arrayList.add(iVar);
            this.fnS.abo();
            this.fnS.cG(arrayList);
            this.fnS.aZI();
        }
    }

    public void kk(boolean z) {
        if (z) {
            this.fnY = z;
            if (com.baidu.adp.lib.util.j.gV()) {
                this.fnT.cr(this.mUserId);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fnS.Nk();
        if (this.fnW != null) {
            this.fnW.a(aVar);
        }
        if (this.fnY && aVar != null && aVar.fpw != null && aVar.fpw.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.fpw.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
        if (aVar != null) {
            this.fnS.e(aVar.getUserData());
        }
    }

    private void aZP() {
        this.fnW = new i();
        this.fnW.a(this.eBb, this, this.mPageId, this.mUserId, this.isHost, this.fnR);
        this.fnW.ki(this.fnZ);
        this.fnW.b(this.fnQ);
        this.fnW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fnW != null) {
                this.fnW.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fnW != null) {
            this.fnW.onDestroy();
        }
    }

    public void fj(boolean z) {
        if (this.fnW != null) {
            this.fnW.fj(z);
        }
    }

    public void onResume() {
        if (this.fnW != null) {
            this.fnW.onResume();
        }
    }
}
