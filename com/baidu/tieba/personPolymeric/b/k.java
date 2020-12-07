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
    private BdUniqueId ajD;
    private TbPageContext eNx;
    private boolean gtX;
    private BaseFragmentActivity ixc;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;
    private com.baidu.tieba.personPolymeric.c.a mqN;
    private PersonPolymericModel mqz;
    private g mrd;
    private p mre;
    private f mrf;
    private PersonPostModel mrg;
    private a mrh;
    PersonPostModel.b mri;

    /* loaded from: classes24.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.gtX = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.mrh = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.mri = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.mre.cJL();
                if (personPostModel != null) {
                    l.showToast(k.this.eNx.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.eNx.getContext(), k.this.eNx.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.mrf.bTa();
                }
            }
        };
        this.ixc = baseFragment.getBaseFragmentActivity();
        this.eNx = this.ixc.getPageContext();
        this.mUserId = j;
        this.mrd = gVar;
        this.ajD = bdUniqueId;
        this.mView = gVar.mRootView;
        this.mrg = new PersonPostModel(this.eNx, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.mre = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.mre.a(this);
        resetData();
        this.mqz = this.mrd.dAh();
        this.mrf = this.mrd.dAi();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.mrd != null) {
            this.mrd.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.mrd != null) {
            this.mrd.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.mrg.resetThreadPn();
        if (this.mqz != null) {
            this.mqz.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.mqN = aVar;
        this.mre.cJL();
        this.ixc.hideLoadingView(this.mView);
        if (aVar == null) {
            this.mrf.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.mrf.bTa();
            this.mrf.It(8);
            return;
        }
        this.mrf.Yb();
        if (aVar.cBe() != null && ((aVar.cBe().getHide_stat() == 1 && aVar.cBe().getBlock_stat() == 1) || (aVar.cBe().getHide_stat() == 1 && aVar.cBe().getBlock_stat() == 2))) {
            this.mrf.wz(this.mIsHost);
            this.mrf.It(8);
            return;
        }
        this.mrf.It(0);
        aVar.dAu();
        if (aVar.cRZ() != null) {
            z = aVar.cRZ().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.gtX = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bDO().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.bg(aVar.cRZ());
        eVar.wp(z);
        this.mre.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mre != null) {
                this.mre.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ajD);
        if (this.mre != null) {
            this.mre.onDestory();
        }
    }

    public void cb(boolean z) {
        if (z && this.gtX) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eNx.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.ixc.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Rh(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Ri(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dzZ() {
        if (this.mre != null) {
            this.mre.dzZ();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.mre.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dAa() {
        return this.mre;
    }
}
