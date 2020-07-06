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
    private BdUniqueId agK;
    private TbPageContext dPv;
    private boolean fqf;
    private BaseFragmentActivity hep;
    private com.baidu.tieba.personPolymeric.c.a kMH;
    private f kMZ;
    private PersonPolymericModel kMt;
    private p kNa;
    private e kNb;
    private PersonPostModel kNc;
    private a kNd;
    PersonPostModel.b kNe;
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
        this.fqf = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.kNd = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.kNe = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.kNa.cev();
                if (personPostModel != null) {
                    l.showToast(j.this.dPv.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.dPv.getContext(), j.this.dPv.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.kNb.buL();
                }
            }
        };
        this.hep = baseFragment.getBaseFragmentActivity();
        this.dPv = this.hep.getPageContext();
        this.mUserId = j;
        this.kMZ = fVar;
        this.agK = bdUniqueId;
        this.mView = fVar.mRootView;
        this.kNc = new PersonPostModel(this.dPv, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.kNa = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.kNa.a(this);
        resetData();
        this.kMt = this.kMZ.cTz();
        this.kNb = this.kMZ.cTA();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.kMZ != null) {
            this.kMZ.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.kMZ != null) {
            this.kMZ.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.kNc.resetThreadPn();
        if (this.kMt != null) {
            this.kMt.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.kMH = aVar;
        this.kNa.cev();
        this.hep.hideLoadingView(this.mView);
        if (aVar == null) {
            this.kNb.aI(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.kNb.buL();
            this.kNb.Cw(8);
            return;
        }
        this.kNb.btO();
        if (aVar.bXe() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bXe().getHide_stat() == 1 && aVar.bXe().getBlock_stat() == 1) || (aVar.bXe().getHide_stat() == 1 && aVar.bXe().getBlock_stat() == 2))) {
            this.kNb.tl(this.mIsHost);
            this.kNb.Cw(8);
            return;
        }
        this.kNb.Cw(0);
        aVar.cTM();
        if (aVar.clM() != null) {
            z = aVar.clM().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.fqf = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bgs().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aR(aVar.clM());
        eVar.tb(z);
        this.kNa.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kNa != null) {
                this.kNa.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.agK);
        if (this.kNa != null) {
            this.kNa.onDestory();
        }
    }

    public void bB(boolean z) {
        if (z && this.fqf) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.dPv.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.hep.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void KQ(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void KR(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cTr() {
        if (this.kNa != null) {
            this.kNa.cTr();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.kNa.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cTs() {
        return this.kNa;
    }
}
