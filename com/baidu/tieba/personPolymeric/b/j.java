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
/* loaded from: classes11.dex */
public class j extends d implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId MO;
    private TbPageContext cVi;
    private boolean eoi;
    private BaseFragmentActivity grR;
    private PersonPolymericModel jnG;
    private com.baidu.tieba.personPolymeric.c.a jnU;
    private f jom;
    private p jon;
    private e joo;
    private PersonPostModel jop;
    private a joq;
    PersonPostModel.b jor;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public j(BaseFragment baseFragment, f fVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.eoi = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.joq = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.jor = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.jon.bJO();
                if (personPostModel != null) {
                    l.showToast(j.this.cVi.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.cVi.getContext(), j.this.cVi.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.joo.bdu();
                }
            }
        };
        this.grR = baseFragment.getBaseFragmentActivity();
        this.cVi = this.grR.getPageContext();
        this.mUserId = j;
        this.jom = fVar;
        this.MO = bdUniqueId;
        this.mView = fVar.mRootView;
        this.jop = new PersonPostModel(this.cVi, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.jon = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.jon.a(this);
        resetData();
        this.jnG = this.jom.cwQ();
        this.joo = this.jom.cwR();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.jom != null) {
            this.jom.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.jom != null) {
            this.jom.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.jop.resetThreadPn();
        if (this.jnG != null) {
            this.jnG.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.jnU = aVar;
        this.jon.bJO();
        this.grR.hideLoadingView(this.mView);
        if (aVar == null) {
            this.joo.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.joo.bdu();
            this.joo.zY(8);
            return;
        }
        this.joo.bcy();
        if (aVar.bCZ() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bCZ().getHide_stat() == 1 && aVar.bCZ().getBlock_stat() == 1) || (aVar.bCZ().getHide_stat() == 1 && aVar.bCZ().getBlock_stat() == 2))) {
            this.joo.rp(this.mIsHost);
            this.joo.zY(8);
            return;
        }
        this.joo.zY(0);
        aVar.cxd();
        if (aVar.bQy() != null) {
            z = aVar.bQy().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.eoi = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.aPK().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aN(aVar.bQy());
        eVar.rf(z);
        this.jon.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jon != null) {
                this.jon.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.MO);
        if (this.jon != null) {
            this.jon.onDestory();
        }
    }

    public void onPrimary(boolean z) {
        if (z && this.eoi) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.cVi.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.grR.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GS(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GT(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cwI() {
        if (this.jon != null) {
            this.jon.cwI();
        }
    }

    public void a(com.baidu.tieba.view.e eVar) {
        this.jon.setOnViewResponseListener(eVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cwJ() {
        return this.jon;
    }
}
