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
    private boolean gtZ;
    private BaseFragmentActivity ixe;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;
    private PersonPolymericModel mqB;
    private com.baidu.tieba.personPolymeric.c.a mqP;
    private g mrf;
    private p mrg;
    private f mrh;
    private PersonPostModel mri;
    private a mrj;
    PersonPostModel.b mrk;

    /* loaded from: classes24.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.gtZ = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.mrj = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.mrk = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.mrg.cJM();
                if (personPostModel != null) {
                    l.showToast(k.this.eNx.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.eNx.getContext(), k.this.eNx.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.mrh.bTb();
                }
            }
        };
        this.ixe = baseFragment.getBaseFragmentActivity();
        this.eNx = this.ixe.getPageContext();
        this.mUserId = j;
        this.mrf = gVar;
        this.ajD = bdUniqueId;
        this.mView = gVar.mRootView;
        this.mri = new PersonPostModel(this.eNx, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.mrg = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.mrg.a(this);
        resetData();
        this.mqB = this.mrf.dAi();
        this.mrh = this.mrf.dAj();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.mrf != null) {
            this.mrf.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.mrf != null) {
            this.mrf.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.mri.resetThreadPn();
        if (this.mqB != null) {
            this.mqB.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.mqP = aVar;
        this.mrg.cJM();
        this.ixe.hideLoadingView(this.mView);
        if (aVar == null) {
            this.mrh.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.mrh.bTb();
            this.mrh.It(8);
            return;
        }
        this.mrh.Yb();
        if (aVar.cBf() != null && ((aVar.cBf().getHide_stat() == 1 && aVar.cBf().getBlock_stat() == 1) || (aVar.cBf().getHide_stat() == 1 && aVar.cBf().getBlock_stat() == 2))) {
            this.mrh.wz(this.mIsHost);
            this.mrh.It(8);
            return;
        }
        this.mrh.It(0);
        aVar.dAv();
        if (aVar.cSa() != null) {
            z = aVar.cSa().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.gtZ = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bDO().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.bg(aVar.cSa());
        eVar.wp(z);
        this.mrg.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mrg != null) {
                this.mrg.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ajD);
        if (this.mrg != null) {
            this.mrg.onDestory();
        }
    }

    public void cb(boolean z) {
        if (z && this.gtZ) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eNx.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.ixe.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Rh(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Ri(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dAa() {
        if (this.mrg != null) {
            this.mrg.dAa();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.mrg.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dAb() {
        return this.mrg;
    }
}
