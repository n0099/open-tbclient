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
/* loaded from: classes9.dex */
public class j extends d implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId Mm;
    private TbPageContext cRe;
    private boolean ejJ;
    private BaseFragmentActivity gpB;
    private com.baidu.tieba.personPolymeric.c.a jmN;
    private PersonPolymericModel jmz;
    private f jnf;
    private p jng;
    private e jnh;
    private PersonPostModel jni;
    private a jnj;
    PersonPostModel.b jnk;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public j(BaseFragment baseFragment, f fVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.ejJ = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.jnj = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.jnk = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.jng.bIj();
                if (personPostModel != null) {
                    l.showToast(j.this.cRe.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.cRe.getContext(), j.this.cRe.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.jng.aO(null);
                    j.this.jnh.bbc();
                }
            }
        };
        this.gpB = baseFragment.getBaseFragmentActivity();
        this.cRe = this.gpB.getPageContext();
        this.mUserId = j;
        this.jnf = fVar;
        this.Mm = bdUniqueId;
        this.mView = fVar.mRootView;
        this.jni = new PersonPostModel(this.cRe, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.jng = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.jng.a(this);
        resetData();
        this.jmz = this.jnf.cvu();
        this.jnh = this.jnf.cvv();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.jnf != null) {
            this.jnf.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.jnf != null) {
            this.jnf.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.jni.resetThreadPn();
        if (this.jmz != null) {
            this.jmz.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.jmN = aVar;
        this.jng.bIj();
        this.gpB.hideLoadingView(this.mView);
        if (aVar == null) {
            this.jnh.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.jnh.bbc();
            this.jnh.zR(8);
            return;
        }
        this.jnh.baf();
        if (aVar.bBu() != null && aVar.getUserData() != null && aVar.getUserData().getBaijiahaoInfo() != null && ((aVar.bBu().getHide_stat() == 1 && aVar.bBu().getBlock_stat() == 1) || (aVar.bBu().getHide_stat() == 1 && aVar.bBu().getBlock_stat() == 2))) {
            this.jnh.rl(this.mIsHost);
            this.jnh.zR(8);
            return;
        }
        this.jnh.zR(0);
        aVar.cvH();
        if (aVar.bOU() != null) {
            z = aVar.bOU().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.ejJ = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.aNl().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aN(aVar.bOU());
        eVar.rb(z);
        this.jng.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jng != null) {
                this.jng.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public boolean onBackPressed() {
        if (this.jng != null) {
            return this.jng.onBackPressed();
        }
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Mm);
        if (this.jng != null) {
            this.jng.onDestory();
        }
    }

    public void lg(boolean z) {
        if (z && this.ejJ) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.cRe.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.gpB.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GD(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void GE(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cvm() {
        if (this.jng != null) {
            this.jng.cvm();
        }
    }

    public void rp(boolean z) {
        this.jng.rp(z);
    }

    public void a(com.baidu.tieba.view.e eVar) {
        this.jng.setOnViewResponseListener(eVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cvn() {
        return this.jng;
    }
}
