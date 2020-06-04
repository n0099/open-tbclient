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
    private BdUniqueId afZ;
    private TbPageContext dIF;
    private boolean feU;
    private BaseFragmentActivity gRG;
    private com.baidu.tieba.personPolymeric.c.a ksK;
    private PersonPolymericModel ksw;
    private f ktc;
    private p ktd;
    private e kte;
    private PersonPostModel ktf;
    private a ktg;
    PersonPostModel.b kth;
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
        this.feU = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.ktg = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.kth = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.ktd.cbc();
                if (personPostModel != null) {
                    l.showToast(j.this.dIF.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.dIF.getContext(), j.this.dIF.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.kte.brO();
                }
            }
        };
        this.gRG = baseFragment.getBaseFragmentActivity();
        this.dIF = this.gRG.getPageContext();
        this.mUserId = j;
        this.ktc = fVar;
        this.afZ = bdUniqueId;
        this.mView = fVar.mRootView;
        this.ktf = new PersonPostModel(this.dIF, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.ktd = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.ktd.a(this);
        resetData();
        this.ksw = this.ktc.cPh();
        this.kte = this.ktc.cPi();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.ktc != null) {
            this.ktc.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.ktc != null) {
            this.ktc.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.ktf.resetThreadPn();
        if (this.ksw != null) {
            this.ksw.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.ksK = aVar;
        this.ktd.cbc();
        this.gRG.hideLoadingView(this.mView);
        if (aVar == null) {
            this.kte.aG(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.kte.brO();
            this.kte.Bu(8);
            return;
        }
        this.kte.bqQ();
        if (aVar.bUc() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bUc().getHide_stat() == 1 && aVar.bUc().getBlock_stat() == 1) || (aVar.bUc().getHide_stat() == 1 && aVar.bUc().getBlock_stat() == 2))) {
            this.kte.sX(this.mIsHost);
            this.kte.Bu(8);
            return;
        }
        this.kte.Bu(0);
        aVar.cPu();
        if (aVar.chX() != null) {
            z = aVar.chX().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.feU = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.ben().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aQ(aVar.chX());
        eVar.sN(z);
        this.ktd.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ktd != null) {
                this.ktd.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.afZ);
        if (this.ktd != null) {
            this.ktd.onDestory();
        }
    }

    public void bB(boolean z) {
        if (z && this.feU) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.dIF.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.gRG.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Kp(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Kq(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cOZ() {
        if (this.ktd != null) {
            this.ktd.cOZ();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.ktd.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cPa() {
        return this.ktd;
    }
}
