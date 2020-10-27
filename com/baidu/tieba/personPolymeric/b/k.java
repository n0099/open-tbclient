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
/* loaded from: classes24.dex */
public class k extends e implements com.baidu.tieba.model.a, b {
    private BdUniqueId aiz;
    private TbPageContext eCn;
    private boolean ggt;
    private BaseFragmentActivity ifx;
    private g lWG;
    private p lWH;
    private f lWI;
    private PersonPostModel lWJ;
    private a lWK;
    PersonPostModel.b lWL;
    private PersonPolymericModel lWc;
    private com.baidu.tieba.personPolymeric.c.a lWq;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes24.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.ggt = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.lWK = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.lWL = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.lWH.cCs();
                if (personPostModel != null) {
                    l.showToast(k.this.eCn.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.eCn.getContext(), k.this.eCn.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.lWI.bNw();
                }
            }
        };
        this.ifx = baseFragment.getBaseFragmentActivity();
        this.eCn = this.ifx.getPageContext();
        this.mUserId = j;
        this.lWG = gVar;
        this.aiz = bdUniqueId;
        this.mView = gVar.mRootView;
        this.lWJ = new PersonPostModel(this.eCn, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.lWH = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.lWH.a(this);
        resetData();
        this.lWc = this.lWG.dsN();
        this.lWI = this.lWG.dsO();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.lWG != null) {
            this.lWG.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.lWG != null) {
            this.lWG.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.lWJ.resetThreadPn();
        if (this.lWc != null) {
            this.lWc.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.lWq = aVar;
        this.lWH.cCs();
        this.ifx.hideLoadingView(this.mView);
        if (aVar == null) {
            this.lWI.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.lWI.bNw();
            this.lWI.GR(8);
            return;
        }
        this.lWI.TK();
        if (aVar.cuM() != null && ((aVar.cuM().getHide_stat() == 1 && aVar.cuM().getBlock_stat() == 1) || (aVar.cuM().getHide_stat() == 1 && aVar.cuM().getBlock_stat() == 2))) {
            this.lWI.vJ(this.mIsHost);
            this.lWI.GR(8);
            return;
        }
        this.lWI.GR(0);
        aVar.dta();
        if (aVar.cKD() != null) {
            z = aVar.cKD().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.ggt = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.byx().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.bd(aVar.cKD());
        eVar.vz(z);
        this.lWH.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lWH != null) {
                this.lWH.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aiz);
        if (this.lWH != null) {
            this.lWH.onDestory();
        }
    }

    public void bP(boolean z) {
        if (z && this.ggt) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eCn.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.ifx.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Qm(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Qn(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dsF() {
        if (this.lWH != null) {
            this.lWH.dsF();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.lWH.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dsG() {
        return this.lWH;
    }
}
