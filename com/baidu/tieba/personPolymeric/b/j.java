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
    private com.baidu.tieba.personPolymeric.c.a kVH;
    private f kVX;
    private p kVY;
    private e kVZ;
    private PersonPolymericModel kVt;
    private PersonPostModel kWa;
    private a kWb;
    PersonPostModel.b kWc;
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
        this.kWb = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.kWc = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.kVY.chU();
                if (personPostModel != null) {
                    l.showToast(j.this.dVN.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.dVN.getContext(), j.this.dVN.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.kVZ.bxU();
                }
            }
        };
        this.hjZ = baseFragment.getBaseFragmentActivity();
        this.dVN = this.hjZ.getPageContext();
        this.mUserId = j;
        this.kVX = fVar;
        this.agB = bdUniqueId;
        this.mView = fVar.mRootView;
        this.kWa = new PersonPostModel(this.dVN, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.kVY = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.kVY.a(this);
        resetData();
        this.kVt = this.kVX.cXp();
        this.kVZ = this.kVX.cXq();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.kVX != null) {
            this.kVX.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.kVX != null) {
            this.kVX.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.kWa.resetThreadPn();
        if (this.kVt != null) {
            this.kVt.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.kVH = aVar;
        this.kVY.chU();
        this.hjZ.hideLoadingView(this.mView);
        if (aVar == null) {
            this.kVZ.aG(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.kVZ.bxU();
            this.kVZ.CW(8);
            return;
        }
        this.kVZ.bwX();
        if (aVar.cax() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.cax().getHide_stat() == 1 && aVar.cax().getBlock_stat() == 1) || (aVar.cax().getHide_stat() == 1 && aVar.cax().getBlock_stat() == 2))) {
            this.kVZ.tR(this.mIsHost);
            this.kVZ.CW(8);
            return;
        }
        this.kVZ.CW(0);
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
        this.kVY.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kVY != null) {
                this.kVY.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.agB);
        if (this.kVY != null) {
            this.kVY.onDestory();
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
        if (this.kVY != null) {
            this.kVY.cXh();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.kVY.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cXi() {
        return this.kVY;
    }
}
