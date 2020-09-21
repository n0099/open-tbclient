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
/* loaded from: classes23.dex */
public class k extends e implements com.baidu.tieba.model.a, b {
    private BdUniqueId aih;
    private TbPageContext ehG;
    private boolean fJY;
    private BaseFragmentActivity hEa;
    private com.baidu.tieba.personPolymeric.c.a luI;
    private g luY;
    private p luZ;
    private PersonPolymericModel luu;
    private f lva;
    private PersonPostModel lvb;
    private a lvc;
    PersonPostModel.b lvd;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes23.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.fJY = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.lvc = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.lvd = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.luZ.cvO();
                if (personPostModel != null) {
                    l.showToast(k.this.ehG.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.ehG.getContext(), k.this.ehG.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.lva.bIk();
                }
            }
        };
        this.hEa = baseFragment.getBaseFragmentActivity();
        this.ehG = this.hEa.getPageContext();
        this.mUserId = j;
        this.luY = gVar;
        this.aih = bdUniqueId;
        this.mView = gVar.mRootView;
        this.lvb = new PersonPostModel(this.ehG, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.luZ = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.luZ.a(this);
        resetData();
        this.luu = this.luY.dlW();
        this.lva = this.luY.dlX();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.luY != null) {
            this.luY.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.luY != null) {
            this.luY.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.lvb.resetThreadPn();
        if (this.luu != null) {
            this.luu.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.luI = aVar;
        this.luZ.cvO();
        this.hEa.hideLoadingView(this.mView);
        if (aVar == null) {
            this.lva.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.lva.bIk();
            this.lva.FS(8);
            return;
        }
        this.lva.bHn();
        if (aVar.coh() != null && aVar.getUserData() != null && aVar.getUserData().isBaijiahaoUser() && ((aVar.coh().getHide_stat() == 1 && aVar.coh().getBlock_stat() == 1) || (aVar.coh().getHide_stat() == 1 && aVar.coh().getBlock_stat() == 2))) {
            this.lva.uL(this.mIsHost);
            this.lva.FS(8);
            return;
        }
        this.lva.FS(0);
        aVar.dmj();
        if (aVar.cDN() != null) {
            z = aVar.cDN().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.fJY = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.btU().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.ba(aVar.cDN());
        eVar.uB(z);
        this.luZ.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.luZ != null) {
                this.luZ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aih);
        if (this.luZ != null) {
            this.luZ.onDestory();
        }
    }

    public void bL(boolean z) {
        if (z && this.fJY) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ehG.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.hEa.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void OZ(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void Pa(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dlO() {
        if (this.luZ != null) {
            this.luZ.dlO();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.luZ.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dlP() {
        return this.luZ;
    }
}
