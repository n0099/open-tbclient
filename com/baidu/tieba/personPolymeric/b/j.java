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
public class j extends d implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId Mh;
    private TbPageContext cQU;
    private boolean eiV;
    private BaseFragmentActivity gms;
    private PersonPolymericModel jiS;
    private e jjA;
    private PersonPostModel jjB;
    private a jjC;
    PersonPostModel.b jjD;
    private com.baidu.tieba.personPolymeric.c.a jjg;
    private f jjy;
    private p jjz;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public j(BaseFragment baseFragment, f fVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.eiV = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.jjC = new a() { // from class: com.baidu.tieba.personPolymeric.b.j.1
        };
        this.jjD = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.j.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                j.this.jjz.bHh();
                if (personPostModel != null) {
                    l.showToast(j.this.cQU.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(j.this.cQU.getContext(), j.this.cQU.getString(R.string.data_load_error));
                }
                if (z2) {
                    j.this.jjz.aO(null);
                    j.this.jjA.baH();
                }
            }
        };
        this.gms = baseFragment.getBaseFragmentActivity();
        this.cQU = this.gms.getPageContext();
        this.mUserId = j;
        this.jjy = fVar;
        this.Mh = bdUniqueId;
        this.mView = fVar.mRootView;
        this.jjB = new PersonPostModel(this.cQU, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.jjz = new p(baseFragment, fVar, bdUniqueId, z, this.mUserId);
        this.jjz.a(this);
        resetData();
        this.jiS = this.jjy.cul();
        this.jjA = this.jjy.cum();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.jjy != null) {
            this.jjy.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.jjy != null) {
            this.jjy.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.jjB.resetThreadPn();
        if (this.jiS != null) {
            this.jiS.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.jjg = aVar;
        this.jjz.bHh();
        this.gms.hideLoadingView(this.mView);
        if (aVar == null) {
            this.jjA.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.jjA.baH();
            this.jjA.zM(8);
            return;
        }
        this.jjA.aZK();
        if (aVar.bAs() != null && aVar.getUserData() != null && aVar.getUserData().getBaijiahaoInfo() != null && ((aVar.bAs().getHide_stat() == 1 && aVar.bAs().getBlock_stat() == 1) || (aVar.bAs().getHide_stat() == 1 && aVar.bAs().getBlock_stat() == 2))) {
            this.jjA.qY(this.mIsHost);
            this.jjA.zM(8);
            return;
        }
        this.jjA.zM(0);
        aVar.cuy();
        if (aVar.bNL() != null) {
            z = aVar.bNL().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.eiV = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.aMS().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.aN(aVar.bNL());
        eVar.qO(z);
        this.jjz.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jjz != null) {
                this.jjz.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public boolean onBackPressed() {
        if (this.jjz != null) {
            return this.jjz.onBackPressed();
        }
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Mh);
        if (this.jjz != null) {
            this.jjz.onDestory();
        }
    }

    public void kV(boolean z) {
        if (z && this.eiV) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.cQU.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.gms.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Gt(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Gu(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cud() {
        if (this.jjz != null) {
            this.jjz.cud();
        }
    }

    public void rc(boolean z) {
        this.jjz.rc(z);
    }

    public void a(com.baidu.tieba.view.e eVar) {
        this.jjz.setOnViewResponseListener(eVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public p cue() {
        return this.jjz;
    }
}
