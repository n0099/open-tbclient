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
    private BdUniqueId afA;
    private TbPageContext duG;
    private boolean eRW;
    private BaseFragmentActivity gCG;
    private com.baidu.tieba.personPolymeric.c.a jZH;
    private f jZZ;
    private PersonPolymericModel jZt;
    private p kaa;
    private e kab;
    private PersonPostModel kac;
    private a kad;
    PersonPostModel.b kae;
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
        this.eRW = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.kad = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.kae = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.kaa.bUy();
                if (personPostModel != null) {
                    l.showToast(j.this.duG.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.duG.getContext(), j.this.duG.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.kab.bmq();
                }
            }
        };
        this.gCG = baseFragment.getBaseFragmentActivity();
        this.duG = this.gCG.getPageContext();
        this.mUserId = j;
        this.jZZ = fVar;
        this.afA = bdUniqueId;
        this.mView = fVar.mRootView;
        this.kac = new PersonPostModel(this.duG, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.kaa = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.kaa.a(this);
        resetData();
        this.jZt = this.jZZ.cHU();
        this.kab = this.jZZ.cHV();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.jZZ != null) {
            this.jZZ.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.jZZ != null) {
            this.jZZ.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.kac.resetThreadPn();
        if (this.jZt != null) {
            this.jZt.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.jZH = aVar;
        this.kaa.bUy();
        this.gCG.hideLoadingView(this.mView);
        if (aVar == null) {
            this.kab.at(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.kab.bmq();
            this.kab.AH(8);
            return;
        }
        this.kab.blt();
        if (aVar.bNG() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bNG().getHide_stat() == 1 && aVar.bNG().getBlock_stat() == 1) || (aVar.bNG().getHide_stat() == 1 && aVar.bNG().getBlock_stat() == 2))) {
            this.kab.sz(this.mIsHost);
            this.kab.AH(8);
            return;
        }
        this.kab.AH(0);
        aVar.cIh();
        if (aVar.cbq() != null) {
            z = aVar.cbq().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.eRW = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.aYf().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aP(aVar.cbq());
        eVar.sp(z);
        this.kaa.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kaa != null) {
                this.kaa.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.afA);
        if (this.kaa != null) {
            this.kaa.onDestory();
        }
    }

    public void jb(boolean z) {
        if (z && this.eRW) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.duG.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.gCG.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Iz(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void IA(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cHM() {
        if (this.kaa != null) {
            this.kaa.cHM();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.kaa.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cHN() {
        return this.kaa;
    }
}
