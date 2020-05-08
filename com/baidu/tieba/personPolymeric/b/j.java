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
    private BdUniqueId afD;
    private TbPageContext duK;
    private boolean eSb;
    private BaseFragmentActivity gCM;
    private com.baidu.tieba.personPolymeric.c.a jZL;
    private PersonPolymericModel jZx;
    private f kad;
    private p kae;
    private e kaf;
    private PersonPostModel kag;
    private a kah;
    PersonPostModel.b kai;
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
        this.eSb = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.kah = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.kai = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.kae.bUw();
                if (personPostModel != null) {
                    l.showToast(j.this.duK.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.duK.getContext(), j.this.duK.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.kaf.bmo();
                }
            }
        };
        this.gCM = baseFragment.getBaseFragmentActivity();
        this.duK = this.gCM.getPageContext();
        this.mUserId = j;
        this.kad = fVar;
        this.afD = bdUniqueId;
        this.mView = fVar.mRootView;
        this.kag = new PersonPostModel(this.duK, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.kae = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.kae.a(this);
        resetData();
        this.jZx = this.kad.cHR();
        this.kaf = this.kad.cHS();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.kad != null) {
            this.kad.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.kad != null) {
            this.kad.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.kag.resetThreadPn();
        if (this.jZx != null) {
            this.jZx.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.jZL = aVar;
        this.kae.bUw();
        this.gCM.hideLoadingView(this.mView);
        if (aVar == null) {
            this.kaf.at(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.kaf.bmo();
            this.kaf.AH(8);
            return;
        }
        this.kaf.blr();
        if (aVar.bNE() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.bNE().getHide_stat() == 1 && aVar.bNE().getBlock_stat() == 1) || (aVar.bNE().getHide_stat() == 1 && aVar.bNE().getBlock_stat() == 2))) {
            this.kaf.sz(this.mIsHost);
            this.kaf.AH(8);
            return;
        }
        this.kaf.AH(0);
        aVar.cIe();
        if (aVar.cbo() != null) {
            z = aVar.cbo().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.eSb = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.aYd().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aP(aVar.cbo());
        eVar.sp(z);
        this.kae.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kae != null) {
                this.kae.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.afD);
        if (this.kae != null) {
            this.kae.onDestory();
        }
    }

    public void jb(boolean z) {
        if (z && this.eSb) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.duK.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.gCM.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void IC(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ID(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cHJ() {
        if (this.kae != null) {
            this.kae.cHJ();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.kae.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cHK() {
        return this.kae;
    }
}
