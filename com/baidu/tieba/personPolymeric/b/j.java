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
    private BdUniqueId MP;
    private TbPageContext cVv;
    private boolean eoz;
    private BaseFragmentActivity gsB;
    private f jpL;
    private p jpM;
    private e jpN;
    private PersonPostModel jpO;
    private a jpP;
    PersonPostModel.b jpQ;
    private PersonPolymericModel jpf;
    private com.baidu.tieba.personPolymeric.c.a jpt;
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
        this.eoz = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.jpP = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.jpQ = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.jpM.bKb();
                if (personPostModel != null) {
                    l.showToast(j.this.cVv.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.cVv.getContext(), j.this.cVv.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.jpN.bdz();
                }
            }
        };
        this.gsB = baseFragment.getBaseFragmentActivity();
        this.cVv = this.gsB.getPageContext();
        this.mUserId = j;
        this.jpL = fVar;
        this.MP = bdUniqueId;
        this.mView = fVar.mRootView;
        this.jpO = new PersonPostModel(this.cVv, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.jpM = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.jpM.a(this);
        resetData();
        this.jpf = this.jpL.cxj();
        this.jpN = this.jpL.cxk();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.jpL != null) {
            this.jpL.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.jpL != null) {
            this.jpL.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.jpO.resetThreadPn();
        if (this.jpf != null) {
            this.jpf.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.jpt = aVar;
        this.jpM.bKb();
        this.gsB.hideLoadingView(this.mView);
        if (aVar == null) {
            this.jpN.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.jpN.bdz();
            this.jpN.Ag(8);
            return;
        }
        this.jpN.bcC();
        if (aVar.bDg() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bDg().getHide_stat() == 1 && aVar.bDg().getBlock_stat() == 1) || (aVar.bDg().getHide_stat() == 1 && aVar.bDg().getBlock_stat() == 2))) {
            this.jpN.rv(this.mIsHost);
            this.jpN.Ag(8);
            return;
        }
        this.jpN.Ag(0);
        aVar.cxw();
        if (aVar.bQQ() != null) {
            z = aVar.bQQ().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.eoz = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.aPO().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aN(aVar.bQQ());
        eVar.rl(z);
        this.jpM.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jpM != null) {
                this.jpM.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.MP);
        if (this.jpM != null) {
            this.jpM.onDestory();
        }
    }

    public void onPrimary(boolean z) {
        if (z && this.eoz) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.cVv.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.gsB.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GR(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GS(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cxb() {
        if (this.jpM != null) {
            this.jpM.cxb();
        }
    }

    public void a(com.baidu.tieba.view.e eVar) {
        this.jpM.setOnViewResponseListener(eVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cxc() {
        return this.jpM;
    }
}
