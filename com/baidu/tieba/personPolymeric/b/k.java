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
/* loaded from: classes8.dex */
public class k extends e implements com.baidu.tieba.model.a, b {
    private BdUniqueId agC;
    private TbPageContext eUY;
    private boolean gDb;
    private BaseFragmentActivity iKt;
    private g mAN;
    private p mAO;
    private f mAP;
    private PersonPostModel mAQ;
    private a mAR;
    PersonPostModel.b mAS;
    private PersonPolymericModel mAi;
    private com.baidu.tieba.personPolymeric.c.a mAx;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.gDb = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.mAR = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.mAS = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.mAO.cKi();
                if (personPostModel != null) {
                    l.showToast(k.this.eUY.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.eUY.getContext(), k.this.eUY.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.mAP.bSr();
                }
            }
        };
        this.iKt = baseFragment.getBaseFragmentActivity();
        this.eUY = this.iKt.getPageContext();
        this.mUserId = j;
        this.mAN = gVar;
        this.agC = bdUniqueId;
        this.mView = gVar.mRootView;
        this.mAQ = new PersonPostModel(this.eUY, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.mAO = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.mAO.a(this);
        resetData();
        this.mAi = this.mAN.dyp();
        this.mAP = this.mAN.dyq();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.mAN != null) {
            this.mAN.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.mAN != null) {
            this.mAN.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.mAQ.resetThreadPn();
        if (this.mAi != null) {
            this.mAi.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.mAx = aVar;
        this.mAO.cKi();
        this.iKt.hideLoadingView(this.mView);
        if (aVar == null) {
            this.mAP.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.mAP.bSr();
            this.mAP.GY(8);
            return;
        }
        this.mAP.WZ();
        if (aVar.cBs() != null && ((aVar.cBs().getHide_stat() == 1 && aVar.cBs().getBlock_stat() == 1) || (aVar.cBs().getHide_stat() == 1 && aVar.cBs().getBlock_stat() == 2))) {
            this.mAP.wN(this.mIsHost);
            this.mAP.GY(8);
            return;
        }
        this.mAP.GY(0);
        aVar.dyC();
        if (aVar.cTo() != null) {
            z = aVar.cTo().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.gDb = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bCI().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.ba(aVar.cTo());
        eVar.wD(z);
        this.mAO.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mAO != null) {
                this.mAO.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.agC);
        if (this.mAO != null) {
            this.mAO.onDestory();
        }
    }

    public void cb(boolean z) {
        if (z && this.gDb) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eUY.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.iKt.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Qw(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Qx(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dyh() {
        if (this.mAO != null) {
            this.mAO.dyh();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.mAO.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dyi() {
        return this.mAO;
    }
}
