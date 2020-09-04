package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class k extends e implements com.baidu.tieba.model.a, b {
    private BdUniqueId ahM;
    private TbPageContext efr;
    private boolean fGM;
    private BaseFragmentActivity hwW;
    private com.baidu.tieba.personPolymeric.c.a llL;
    private PersonPolymericModel llx;
    private g lmb;
    private p lmc;
    private f lmd;
    private PersonPostModel lme;
    private a lmf;
    PersonPostModel.b lmg;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes18.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.fGM = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.lmf = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.lmg = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.lmc.csz();
                if (personPostModel != null) {
                    l.showToast(k.this.efr.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.efr.getContext(), k.this.efr.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.lmd.bGU();
                }
            }
        };
        this.hwW = baseFragment.getBaseFragmentActivity();
        this.efr = this.hwW.getPageContext();
        this.mUserId = j;
        this.lmb = gVar;
        this.ahM = bdUniqueId;
        this.mView = gVar.mRootView;
        this.lme = new PersonPostModel(this.efr, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.lmc = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.lmc.a(this);
        resetData();
        this.llx = this.lmb.dir();
        this.lmd = this.lmb.dis();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.lmb != null) {
            this.lmb.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.lmb != null) {
            this.lmb.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.lme.resetThreadPn();
        if (this.llx != null) {
            this.llx.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.llL = aVar;
        this.lmc.csz();
        this.hwW.hideLoadingView(this.mView);
        if (aVar == null) {
            this.lmd.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.lmd.bGU();
            this.lmd.Fr(8);
            return;
        }
        this.lmd.bFX();
        if (aVar.ckU() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.ckU().getHide_stat() == 1 && aVar.ckU().getBlock_stat() == 1) || (aVar.ckU().getHide_stat() == 1 && aVar.ckU().getBlock_stat() == 2))) {
            this.lmd.uD(this.mIsHost);
            this.lmd.Fr(8);
            return;
        }
        this.lmd.Fr(0);
        aVar.diE();
        if (aVar.cAg() != null) {
            z = aVar.cAg().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.fGM = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bsQ().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aY(aVar.cAg());
        eVar.ut(z);
        this.lmc.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lmc != null) {
                this.lmc.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ahM);
        if (this.lmc != null) {
            this.lmc.onDestory();
        }
    }

    public void bJ(boolean z) {
        if (z && this.fGM) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.efr.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.hwW.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Oy(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Oz(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dij() {
        if (this.lmc != null) {
            this.lmc.dij();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.lmc.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dik() {
        return this.lmc;
    }
}
