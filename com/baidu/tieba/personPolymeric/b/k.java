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
/* loaded from: classes7.dex */
public class k extends e implements com.baidu.tieba.model.a, b {
    private BdUniqueId ahU;
    private TbPageContext eWx;
    private boolean gEY;
    private BaseFragmentActivity iMq;
    private PersonPolymericModel mCB;
    private com.baidu.tieba.personPolymeric.c.a mCQ;
    private g mDh;
    private p mDi;
    private f mDj;
    private PersonPostModel mDk;
    private a mDl;
    PersonPostModel.b mDm;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.gEY = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.mDl = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.mDm = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.mDi.cKv();
                if (personPostModel != null) {
                    l.showToast(k.this.eWx.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.eWx.getContext(), k.this.eWx.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.mDj.bSE();
                }
            }
        };
        this.iMq = baseFragment.getBaseFragmentActivity();
        this.eWx = this.iMq.getPageContext();
        this.mUserId = j;
        this.mDh = gVar;
        this.ahU = bdUniqueId;
        this.mView = gVar.mRootView;
        this.mDk = new PersonPostModel(this.eWx, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.mDi = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.mDi.a(this);
        resetData();
        this.mCB = this.mDh.dyF();
        this.mDj = this.mDh.dyG();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.mDh != null) {
            this.mDh.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.mDh != null) {
            this.mDh.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.mDk.resetThreadPn();
        if (this.mCB != null) {
            this.mCB.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.mCQ = aVar;
        this.mDi.cKv();
        this.iMq.hideLoadingView(this.mView);
        if (aVar == null) {
            this.mDj.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.mDj.bSE();
            this.mDj.Hb(8);
            return;
        }
        this.mDj.Xc();
        if (aVar.cBF() != null && ((aVar.cBF().getHide_stat() == 1 && aVar.cBF().getBlock_stat() == 1) || (aVar.cBF().getHide_stat() == 1 && aVar.cBF().getBlock_stat() == 2))) {
            this.mDj.wN(this.mIsHost);
            this.mDj.Hb(8);
            return;
        }
        this.mDj.Hb(0);
        aVar.dyS();
        if (aVar.cTC() != null) {
            z = aVar.cTC().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.gEY = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bCL().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.ba(aVar.cTC());
        eVar.wD(z);
        this.mDi.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mDi != null) {
                this.mDi.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ahU);
        if (this.mDi != null) {
            this.mDi.onDestory();
        }
    }

    public void cb(boolean z) {
        if (z && this.gEY) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eWx.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.iMq.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void QD(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void QE(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dyx() {
        if (this.mDi != null) {
            this.mDi.dyx();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.mDi.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dyy() {
        return this.mDi;
    }
}
