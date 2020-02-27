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
    private TbPageContext cVg;
    private boolean enT;
    private BaseFragmentActivity grC;
    private com.baidu.tieba.personPolymeric.c.a jnG;
    private f jnY;
    private p jnZ;
    private PersonPolymericModel jns;
    private e joa;
    private PersonPostModel job;
    private a joc;
    PersonPostModel.b jod;
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
        this.enT = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.joc = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.jod = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.jnZ.bJL();
                if (personPostModel != null) {
                    l.showToast(j.this.cVg.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.cVg.getContext(), j.this.cVg.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.joa.bdr();
                }
            }
        };
        this.grC = baseFragment.getBaseFragmentActivity();
        this.cVg = this.grC.getPageContext();
        this.mUserId = j;
        this.jnY = fVar;
        this.MO = bdUniqueId;
        this.mView = fVar.mRootView;
        this.job = new PersonPostModel(this.cVg, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.jnZ = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.jnZ.a(this);
        resetData();
        this.jns = this.jnY.cwN();
        this.joa = this.jnY.cwO();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.jnY != null) {
            this.jnY.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.jnY != null) {
            this.jnY.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.job.resetThreadPn();
        if (this.jns != null) {
            this.jns.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.jnG = aVar;
        this.jnZ.bJL();
        this.grC.hideLoadingView(this.mView);
        if (aVar == null) {
            this.joa.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.joa.bdr();
            this.joa.zY(8);
            return;
        }
        this.joa.bcv();
        if (aVar.bCW() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bCW().getHide_stat() == 1 && aVar.bCW().getBlock_stat() == 1) || (aVar.bCW().getHide_stat() == 1 && aVar.bCW().getBlock_stat() == 2))) {
            this.joa.rp(this.mIsHost);
            this.joa.zY(8);
            return;
        }
        this.joa.zY(0);
        aVar.cxa();
        if (aVar.bQv() != null) {
            z = aVar.bQv().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.enT = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.aPH().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aN(aVar.bQv());
        eVar.rf(z);
        this.jnZ.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jnZ != null) {
                this.jnZ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.MO);
        if (this.jnZ != null) {
            this.jnZ.onDestory();
        }
    }

    public void onPrimary(boolean z) {
        if (z && this.enT) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.cVg.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.grC.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GR(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GS(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cwF() {
        if (this.jnZ != null) {
            this.jnZ.cwF();
        }
    }

    public void a(com.baidu.tieba.view.e eVar) {
        this.jnZ.setOnViewResponseListener(eVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cwG() {
        return this.jnZ;
    }
}
