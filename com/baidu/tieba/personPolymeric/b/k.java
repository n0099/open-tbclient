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
    private boolean gDp;
    private BaseFragmentActivity iKH;
    private com.baidu.tieba.personPolymeric.c.a mAM;
    private PersonPolymericModel mAx;
    private g mBc;
    private p mBd;
    private f mBe;
    private PersonPostModel mBf;
    private a mBh;
    PersonPostModel.b mBi;
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
        this.gDp = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.mBh = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.mBi = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.mBd.cKp();
                if (personPostModel != null) {
                    l.showToast(k.this.eUY.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.eUY.getContext(), k.this.eUY.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.mBe.bSy();
                }
            }
        };
        this.iKH = baseFragment.getBaseFragmentActivity();
        this.eUY = this.iKH.getPageContext();
        this.mUserId = j;
        this.mBc = gVar;
        this.agC = bdUniqueId;
        this.mView = gVar.mRootView;
        this.mBf = new PersonPostModel(this.eUY, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.mBd = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.mBd.a(this);
        resetData();
        this.mAx = this.mBc.dyw();
        this.mBe = this.mBc.dyx();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.mBc != null) {
            this.mBc.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.mBc != null) {
            this.mBc.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.mBf.resetThreadPn();
        if (this.mAx != null) {
            this.mAx.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.mAM = aVar;
        this.mBd.cKp();
        this.iKH.hideLoadingView(this.mView);
        if (aVar == null) {
            this.mBe.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.mBe.bSy();
            this.mBe.GY(8);
            return;
        }
        this.mBe.WZ();
        if (aVar.cBz() != null && ((aVar.cBz().getHide_stat() == 1 && aVar.cBz().getBlock_stat() == 1) || (aVar.cBz().getHide_stat() == 1 && aVar.cBz().getBlock_stat() == 2))) {
            this.mBe.wN(this.mIsHost);
            this.mBe.GY(8);
            return;
        }
        this.mBe.GY(0);
        aVar.dyJ();
        if (aVar.cTv() != null) {
            z = aVar.cTv().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.gDp = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bCI().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.ba(aVar.cTv());
        eVar.wD(z);
        this.mBd.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mBd != null) {
                this.mBd.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.agC);
        if (this.mBd != null) {
            this.mBd.onDestory();
        }
    }

    public void cb(boolean z) {
        if (z && this.gDp) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eUY.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.iKH.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Qx(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Qy(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dyo() {
        if (this.mBd != null) {
            this.mBd.dyo();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.mBd.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dyp() {
        return this.mBd;
    }
}
