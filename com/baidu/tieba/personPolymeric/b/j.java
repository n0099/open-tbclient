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
    private TbPageContext cVh;
    private boolean enU;
    private BaseFragmentActivity grE;
    private com.baidu.tieba.personPolymeric.c.a jnI;
    private PersonPolymericModel jnu;
    private f joa;
    private p job;
    private e joc;
    private PersonPostModel jod;
    private a joe;
    PersonPostModel.b jof;
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
        this.enU = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.joe = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.jof = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.job.bJN();
                if (personPostModel != null) {
                    l.showToast(j.this.cVh.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.cVh.getContext(), j.this.cVh.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.joc.bdt();
                }
            }
        };
        this.grE = baseFragment.getBaseFragmentActivity();
        this.cVh = this.grE.getPageContext();
        this.mUserId = j;
        this.joa = fVar;
        this.MO = bdUniqueId;
        this.mView = fVar.mRootView;
        this.jod = new PersonPostModel(this.cVh, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.job = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.job.a(this);
        resetData();
        this.jnu = this.joa.cwP();
        this.joc = this.joa.cwQ();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.joa != null) {
            this.joa.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.joa != null) {
            this.joa.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.jod.resetThreadPn();
        if (this.jnu != null) {
            this.jnu.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.jnI = aVar;
        this.job.bJN();
        this.grE.hideLoadingView(this.mView);
        if (aVar == null) {
            this.joc.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.joc.bdt();
            this.joc.zY(8);
            return;
        }
        this.joc.bcx();
        if (aVar.bCY() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bCY().getHide_stat() == 1 && aVar.bCY().getBlock_stat() == 1) || (aVar.bCY().getHide_stat() == 1 && aVar.bCY().getBlock_stat() == 2))) {
            this.joc.rp(this.mIsHost);
            this.joc.zY(8);
            return;
        }
        this.joc.zY(0);
        aVar.cxc();
        if (aVar.bQx() != null) {
            z = aVar.bQx().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.enU = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.aPJ().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aN(aVar.bQx());
        eVar.rf(z);
        this.job.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.job != null) {
                this.job.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.MO);
        if (this.job != null) {
            this.job.onDestory();
        }
    }

    public void onPrimary(boolean z) {
        if (z && this.enU) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.cVh.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.grE.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GR(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GS(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cwH() {
        if (this.job != null) {
            this.job.cwH();
        }
    }

    public void a(com.baidu.tieba.view.e eVar) {
        this.job.setOnViewResponseListener(eVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cwI() {
        return this.job;
    }
}
