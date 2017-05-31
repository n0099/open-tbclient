package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext aas;
    private final boolean bld;
    private final PersonPolymericModel bwC;
    private y bwE;
    private final BaseFragmentActivity bwL;
    private BaseFragment bwz;
    private i bxg;
    private final boolean eLa;
    private final b eLb;
    private final BlackListModel eLc;
    private a eLd;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private final long mUserId;
    private boolean bwA = true;
    private boolean bwB = false;
    private int mSkinType = 3;

    public n(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bwz = baseFragment;
        this.bwL = this.bwz.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.bld = z;
        this.eLa = z2;
        this.aas = this.bwL.getPageContext();
        this.eLb = new b(this.bwz.getPageContext());
        this.bxg = new i(this.bwz.getPageContext(), view);
        this.bxg.a(new o(this));
        this.bwC = new PersonPolymericModel(this.bwL, bdUniqueId, z);
        this.bwC.a(this);
        this.bwC.a(this.eLb);
        this.eLc = new BlackListModel(this.bwL.getPageContext(), bdUniqueId);
        this.bwE = new y(this.bwL.getPageContext(), bdUniqueId);
        this.bwE.a(this.bwC);
    }

    public a aQV() {
        return this.eLd;
    }

    public y aQW() {
        return this.bwE;
    }

    public PersonPolymericModel aQX() {
        return this.bwC;
    }

    public BlackListModel aQY() {
        return this.eLc;
    }

    public b aQZ() {
        return this.eLb;
    }

    public i aRa() {
        return this.bxg;
    }

    public void aRb() {
        if (this.bwz != null && this.bwA && !this.bwB) {
            this.bwB = true;
            NJ();
        }
    }

    public void NJ() {
        if (!TbadkCoreApplication.isLogin() && this.bld) {
            this.bxg.aQU();
        } else if (com.baidu.adp.lib.util.i.gY()) {
            if (this.bwA) {
                this.bxg.jt(true);
                this.bwC.ce(this.mUserId);
                this.bwL.showLoadingView(this.mRootView);
            }
            this.bwC.cd(this.mUserId);
        } else if (this.bwA) {
            this.bxg.E(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
        } else {
            com.baidu.adp.lib.util.k.showToast(this.aas.getContext(), this.aas.getString(w.l.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.bld = this.bld;
            arrayList.add(iVar);
            this.bxg.VD();
            this.bxg.cb(arrayList);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.bwA = false;
        if (this.eLd instanceof com.baidu.tieba.personPolymeric.mode.b) {
            ((com.baidu.tieba.personPolymeric.mode.b) this.eLd).a(aVar);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void dk(boolean z) {
        boolean z2;
        if (this.eLd == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && this.eLd == null) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_BIGV_PERSON_CENTER_CONTROLLER);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            this.eLd = (a) customMessage.getData();
        }
        if (this.eLd == null) {
            this.eLd = new aj();
        }
        if (!z2) {
            this.eLd.a(this.bwL, this, this.mPageId, this.mUserId, this.bld, this.eLa);
            this.eLd.a(this.bwz);
            this.eLd.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eLd != null) {
                this.eLd.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.eLd != null) {
            this.eLd.onDestroy();
        }
    }

    public void dj(boolean z) {
        if (z) {
            aRb();
        }
        if (this.eLd != null) {
            this.eLd.dj(z);
        }
    }

    public void onResume() {
        if (this.eLa) {
            aRb();
        }
        if (this.eLd != null) {
            this.eLd.onResume();
        }
    }
}
