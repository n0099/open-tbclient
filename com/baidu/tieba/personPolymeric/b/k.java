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
    private BdUniqueId ahE;
    private TbPageContext eXu;
    private boolean gEY;
    private BaseFragmentActivity iJr;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;
    private PersonPolymericModel mvN;
    private com.baidu.tieba.personPolymeric.c.a mwc;
    private g mws;
    private p mwt;
    private f mwu;
    private PersonPostModel mwv;
    private a mww;
    PersonPostModel.b mwx;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.gEY = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.mww = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.mwx = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.mwt.cMN();
                if (personPostModel != null) {
                    l.showToast(k.this.eXu.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.eXu.getContext(), k.this.eXu.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.mwu.bVG();
                }
            }
        };
        this.iJr = baseFragment.getBaseFragmentActivity();
        this.eXu = this.iJr.getPageContext();
        this.mUserId = j;
        this.mws = gVar;
        this.ahE = bdUniqueId;
        this.mView = gVar.mRootView;
        this.mwv = new PersonPostModel(this.eXu, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.mwt = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.mwt.a(this);
        resetData();
        this.mvN = this.mws.dzY();
        this.mwu = this.mws.dzZ();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.mws != null) {
            this.mws.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.mws != null) {
            this.mws.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.mwv.resetThreadPn();
        if (this.mvN != null) {
            this.mvN.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.mwc = aVar;
        this.mwt.cMN();
        this.iJr.hideLoadingView(this.mView);
        if (aVar == null) {
            this.mwu.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.mwu.bVG();
            this.mwu.In(8);
            return;
        }
        this.mwu.Zj();
        if (aVar.cDZ() != null && ((aVar.cDZ().getHide_stat() == 1 && aVar.cDZ().getBlock_stat() == 1) || (aVar.cDZ().getHide_stat() == 1 && aVar.cDZ().getBlock_stat() == 2))) {
            this.mwu.wA(this.mIsHost);
            this.mwu.In(8);
            return;
        }
        this.mwu.In(0);
        aVar.dAl();
        if (aVar.cVh() != null) {
            z = aVar.cVh().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.gEY = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bGj().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.bg(aVar.cVh());
        eVar.wq(z);
        this.mwt.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mwt != null) {
                this.mwt.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ahE);
        if (this.mwt != null) {
            this.mwt.onDestory();
        }
    }

    public void ca(boolean z) {
        if (z && this.gEY) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eXu.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.iJr.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void QM(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void QN(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dzQ() {
        if (this.mwt != null) {
            this.mwt.dzQ();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.mwt.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dzR() {
        return this.mwt;
    }
}
