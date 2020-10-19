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
/* loaded from: classes24.dex */
public class k extends e implements com.baidu.tieba.model.a, b {
    private BdUniqueId aiy;
    private TbPageContext etO;
    private boolean fWp;
    private BaseFragmentActivity hSW;
    private PersonPolymericModel lJG;
    private com.baidu.tieba.personPolymeric.c.a lJU;
    private g lKk;
    private p lKl;
    private f lKm;
    private PersonPostModel lKn;
    private a lKo;
    PersonPostModel.b lKp;
    private List<com.baidu.tieba.person.data.e> mList;
    private int mSex;
    private int mSkinType;
    private long mUserId;
    private View mView;

    /* loaded from: classes24.dex */
    public interface a {
    }

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.fWp = true;
        this.mSex = 1;
        this.mSkinType = 3;
        this.lKo = new a() { // from class: com.baidu.tieba.personPolymeric.b.k.1
        };
        this.lKp = new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.k.2
            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
            public void a(PersonPostModel personPostModel, boolean z2) {
                k.this.lKl.czl();
                if (personPostModel != null) {
                    l.showToast(k.this.etO.getContext(), personPostModel.getErrorString());
                } else {
                    l.showToast(k.this.etO.getContext(), k.this.etO.getString(R.string.data_load_error));
                }
                if (z2) {
                    k.this.lKm.bKU();
                }
            }
        };
        this.hSW = baseFragment.getBaseFragmentActivity();
        this.etO = this.hSW.getPageContext();
        this.mUserId = j;
        this.lKk = gVar;
        this.aiy = bdUniqueId;
        this.mView = gVar.mRootView;
        this.lKn = new PersonPostModel(this.etO, bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.lKl = new p(baseFragment, gVar, bdUniqueId, z, this.mUserId);
        this.lKl.a(this);
        resetData();
        this.lJG = this.lKk.dpG();
        this.lKm = this.lKk.dpH();
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.lKk != null) {
            this.lKk.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.lKk != null) {
            this.lKk.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.lKn.resetThreadPn();
        if (this.lJG != null) {
            this.lJG.resetData();
        }
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.lJU = aVar;
        this.lKl.czl();
        this.hSW.hideLoadingView(this.mView);
        if (aVar == null) {
            this.lKm.aO(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.lKm.bKU();
            this.lKm.Gy(8);
            return;
        }
        this.lKm.SK();
        if (aVar.crF() != null && ((aVar.crF().getHide_stat() == 1 && aVar.crF().getBlock_stat() == 1) || (aVar.crF().getHide_stat() == 1 && aVar.crF().getBlock_stat() == 2))) {
            this.lKm.vs(this.mIsHost);
            this.lKm.Gy(8);
            return;
        }
        this.lKm.Gy(0);
        aVar.dpT();
        if (aVar.cHw() != null) {
            z = aVar.cHw().size() >= 20;
        } else {
            z = false;
        }
        if (aVar.getUserData() != null) {
            this.mSex = aVar.getUserData().getSex();
        }
        this.fWp = false;
        if (this.mIsHost && aVar.getUserData() != null) {
            aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            com.baidu.tbadk.getUserInfo.b.bwE().a(aVar.getUserData());
        }
        com.baidu.tieba.person.data.e eVar = this.mList.get(0);
        eVar.ba(aVar.cHw());
        eVar.vi(z);
        this.lKl.a(aVar, z, a(aVar));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lKl != null) {
                this.lKl.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aiy);
        if (this.lKl != null) {
            this.lKl.onDestory();
        }
    }

    public void bO(boolean z) {
        if (z && this.fWp) {
            loadData();
        }
    }

    public void onResume() {
        if (TbadkCoreApplication.isLogin() && !this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
            this.mIsHost = true;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.etO.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.hSW.finish();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void PO(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void PP(String str) {
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void dpy() {
        if (this.lKl != null) {
            this.lKl.dpy();
        }
    }

    public void a(com.baidu.tieba.view.f fVar) {
        this.lKl.setOnViewResponseListener(fVar);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public p dpz() {
        return this.lKl;
    }
}
