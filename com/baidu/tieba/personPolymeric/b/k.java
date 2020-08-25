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
public class k extends e implements com.baidu.tieba.model.a, b {
    private BdUniqueId ahK;
    private TbPageContext efn;
    private boolean fGI;
    private BaseFragmentActivity hwQ;
    private com.baidu.tieba.personPolymeric.c.a llA;
    private g llQ;
    private p llR;
    private f llS;
    private PersonPostModel llT;
    private a llU;
    PersonPostModel.b llV;
    private PersonPolymericModel llm;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes18.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.fGI = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.llU = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.llV = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.llR.csy();
                if (personPostModel != null) {
                    l.showToast(k.this.efn.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.efn.getContext(), k.this.efn.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.llS.bGT();
                }
            }
        };
        this.hwQ = baseFragment.getBaseFragmentActivity();
        this.efn = this.hwQ.getPageContext();
        this.mUserId = j;
        this.llQ = gVar;
        this.ahK = bdUniqueId;
        this.mView = gVar.mRootView;
        this.llT = new PersonPostModel(this.efn, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.llR = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.llR.a(this);
        resetData();
        this.llm = this.llQ.dio();
        this.llS = this.llQ.dip();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.llQ != null) {
            this.llQ.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.llQ != null) {
            this.llQ.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.llT.resetThreadPn();
        if (this.llm != null) {
            this.llm.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.llA = aVar;
        this.llR.csy();
        this.hwQ.hideLoadingView(this.mView);
        if (aVar == null) {
            this.llS.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.llS.bGT();
            this.llS.Fr(8);
            return;
        }
        this.llS.bFW();
        if (aVar.ckT() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.ckT().getHide_stat() == 1 && aVar.ckT().getBlock_stat() == 1) || (aVar.ckT().getHide_stat() == 1 && aVar.ckT().getBlock_stat() == 2))) {
            this.llS.uB(this.mIsHost);
            this.llS.Fr(8);
            return;
        }
        this.llS.Fr(0);
        aVar.diB();
        if (aVar.cAf() != null) {
            z = aVar.cAf().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.fGI = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bsP().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aY(aVar.cAf());
        eVar.ur(z);
        this.llR.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.llR != null) {
                this.llR.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ahK);
        if (this.llR != null) {
            this.llR.onDestory();
        }
    }

    public void bJ(boolean z) {
        if (z && this.fGI) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.efn.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.hwQ.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Ox(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Oy(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dig() {
        if (this.llR != null) {
            this.llR.dig();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.llR.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dih() {
        return this.llR;
    }
}
