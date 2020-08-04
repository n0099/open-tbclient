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
public class j extends d implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId agB;
    private TbPageContext dVN;
    private boolean fvp;
    private BaseFragmentActivity hjZ;
    private com.baidu.tieba.personPolymeric.c.a kVJ;
    private f kVZ;
    private PersonPolymericModel kVv;
    private p kWa;
    private e kWb;
    private PersonPostModel kWc;
    private a kWd;
    PersonPostModel.b kWe;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes18.dex */
    public interface a {
    }

    public j(BaseFragment baseFragment, f fVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.fvp = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.kWd = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.kWe = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.kWa.chU();
                if (personPostModel != null) {
                    l.showToast(j.this.dVN.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.dVN.getContext(), j.this.dVN.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.kWb.bxU();
                }
            }
        };
        this.hjZ = baseFragment.getBaseFragmentActivity();
        this.dVN = this.hjZ.getPageContext();
        this.mUserId = j;
        this.kVZ = fVar;
        this.agB = bdUniqueId;
        this.mView = fVar.mRootView;
        this.kWc = new PersonPostModel(this.dVN, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.kWa = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.kWa.a(this);
        resetData();
        this.kVv = this.kVZ.cXp();
        this.kWb = this.kVZ.cXq();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.kVZ != null) {
            this.kVZ.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.kVZ != null) {
            this.kVZ.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.kWc.resetThreadPn();
        if (this.kVv != null) {
            this.kVv.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.kVJ = aVar;
        this.kWa.chU();
        this.hjZ.hideLoadingView(this.mView);
        if (aVar == null) {
            this.kWb.aG(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.kWb.bxU();
            this.kWb.CW(8);
            return;
        }
        this.kWb.bwX();
        if (aVar.cax() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.cax().getHide_stat() == 1 && aVar.cax().getBlock_stat() == 1) || (aVar.cax().getHide_stat() == 1 && aVar.cax().getBlock_stat() == 2))) {
            this.kWb.tR(this.mIsHost);
            this.kWb.CW(8);
            return;
        }
        this.kWb.CW(0);
        aVar.cXC();
        if (aVar.cpm() != null) {
            z = aVar.cpm().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.fvp = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bkd().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aS(aVar.cpm());
        eVar.tH(z);
        this.kWa.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kWa != null) {
                this.kWa.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.agB);
        if (this.kWa != null) {
            this.kWa.onDestory();
        }
    }

    public void bE(boolean z) {
        if (z && this.fvp) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.dVN.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.hjZ.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void LE(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void LF(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cXh() {
        if (this.kWa != null) {
            this.kWa.cXh();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.kWa.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cXi() {
        return this.kWa;
    }
}
