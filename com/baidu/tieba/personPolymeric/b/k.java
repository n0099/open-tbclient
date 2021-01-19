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
    private BdUniqueId agN;
    private TbPageContext eSJ;
    private boolean gAr;
    private BaseFragmentActivity iEK;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;
    private g mrN;
    private p mrO;
    private f mrP;
    private PersonPostModel mrQ;
    private a mrR;
    PersonPostModel.b mrS;
    private PersonPolymericModel mri;
    private com.baidu.tieba.personPolymeric.c.a mrx;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.gAr = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.mrR = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.mrS = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.mrO.cIV();
                if (personPostModel != null) {
                    l.showToast(k.this.eSJ.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.eSJ.getContext(), k.this.eSJ.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.mrP.bRO();
                }
            }
        };
        this.iEK = baseFragment.getBaseFragmentActivity();
        this.eSJ = this.iEK.getPageContext();
        this.mUserId = j;
        this.mrN = gVar;
        this.agN = bdUniqueId;
        this.mView = gVar.mRootView;
        this.mrQ = new PersonPostModel(this.eSJ, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.mrO = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.mrO.a(this);
        resetData();
        this.mri = this.mrN.dwg();
        this.mrP = this.mrN.dwh();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.mrN != null) {
            this.mrN.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.mrN != null) {
            this.mrN.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.mrQ.resetThreadPn();
        if (this.mri != null) {
            this.mri.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.mrx = aVar;
        this.mrO.cIV();
        this.iEK.hideLoadingView(this.mView);
        if (aVar == null) {
            this.mrP.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.mrP.bRO();
            this.mrP.GG(8);
            return;
        }
        this.mrP.Vq();
        if (aVar.cAh() != null && ((aVar.cAh().getHide_stat() == 1 && aVar.cAh().getBlock_stat() == 1) || (aVar.cAh().getHide_stat() == 1 && aVar.cAh().getBlock_stat() == 2))) {
            this.mrP.ww(this.mIsHost);
            this.mrP.GG(8);
            return;
        }
        this.mrP.GG(0);
        aVar.dwt();
        if (aVar.cRp() != null) {
            z = aVar.cRp().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.gAr = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bCq().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.bb(aVar.cRp());
        eVar.wm(z);
        this.mrO.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mrO != null) {
                this.mrO.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.agN);
        if (this.mrO != null) {
            this.mrO.onDestory();
        }
    }

    public void bW(boolean z) {
        if (z && this.gAr) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eSJ.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.iEK.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void PF(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void PG(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dvY() {
        if (this.mrO != null) {
            this.mrO.dvY();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.mrO.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dvZ() {
        return this.mrO;
    }
}
