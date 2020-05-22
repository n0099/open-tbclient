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
    private boolean feJ;
    private BaseFragmentActivity gRv;
    private com.baidu.tieba.personPolymeric.c.a krE;
    private f krW;
    private p krX;
    private e krY;
    private PersonPostModel krZ;
    private PersonPolymericModel krq;
    private a ksa;
    PersonPostModel.b ksb;
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
        this.feJ = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.ksa = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.ksb = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.krX.caU();
                if (personPostModel != null) {
                    l.showToast(j.this.dIF.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.dIF.getContext(), j.this.dIF.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.krY.brM();
                }
            }
        };
        this.gRv = baseFragment.getBaseFragmentActivity();
        this.dIF = this.gRv.getPageContext();
        this.mUserId = j;
        this.krW = fVar;
        this.afZ = bdUniqueId;
        this.mView = fVar.mRootView;
        this.krZ = new PersonPostModel(this.dIF, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.krX = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.krX.a(this);
        resetData();
        this.krq = this.krW.cOR();
        this.krY = this.krW.cOS();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.krW != null) {
            this.krW.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.krW != null) {
            this.krW.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.krZ.resetThreadPn();
        if (this.krq != null) {
            this.krq.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.krE = aVar;
        this.krX.caU();
        this.gRv.hideLoadingView(this.mView);
        if (aVar == null) {
            this.krY.aG(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.krY.brM();
            this.krY.Bs(8);
            return;
        }
        this.krY.bqO();
        if (aVar.bUa() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bUa().getHide_stat() == 1 && aVar.bUa().getBlock_stat() == 1) || (aVar.bUa().getHide_stat() == 1 && aVar.bUa().getBlock_stat() == 2))) {
            this.krY.sX(this.mIsHost);
            this.krY.Bs(8);
            return;
        }
        this.krY.Bs(0);
        aVar.cPe();
        if (aVar.chO() != null) {
            z = aVar.chO().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.feJ = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bem().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aQ(aVar.chO());
        eVar.sN(z);
        this.krX.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.krX != null) {
                this.krX.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.afZ);
        if (this.krX != null) {
            this.krX.onDestory();
        }
    }

    public void bB(boolean z) {
        if (z && this.feJ) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.dIF.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.gRv.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Ko(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Kp(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cOJ() {
        if (this.krX != null) {
            this.krX.cOJ();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.krX.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cOK() {
        return this.krX;
    }
}
