package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.a;
import com.baidu.tieba.personPolymeric.b.e;
import com.baidu.tieba.personPolymeric.c.p;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class f extends d implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext cVi;
    private com.baidu.tieba.c.g gGI;
    private final BaseFragmentActivity grR;
    private BaseFragment jnE;
    private e jnF;
    private final PersonPolymericModel jnG;
    private final c jnH;
    private final BlackListModel jnI;
    private j jnJ;
    private com.baidu.tieba.personPolymeric.event.c jnK;
    private g jnL;
    private boolean jnM;
    private boolean jnN;
    private final e.b jnO;
    private CustomMessageListener jnP;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.jnM = false;
        this.jnO = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cJ(View view2) {
                f.this.loadData();
            }
        };
        this.jnP = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jnE = baseFragment;
        this.grR = this.jnE.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.jnN = z2;
        this.cVi = this.grR.getPageContext();
        MessageManager.getInstance().registerListener(this.jnP);
        this.jnH = new c(this.jnE.getPageContext(), bdUniqueId);
        this.jnF = new e(this.jnE.getPageContext(), view, z);
        this.jnF.a(this.jnO);
        this.jnK = new com.baidu.tieba.personPolymeric.event.c(this.cVi, this);
        this.jnG = new PersonPolymericModel(this.grR, bdUniqueId, z);
        this.jnG.e(new p(z));
        this.jnG.a(this);
        this.jnG.a(this.jnH);
        this.jnI = new BlackListModel(this.grR.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.jnJ = new j(this.jnE, this, this.mPageId, this.mUserId, z);
            this.jnJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jnJ.a(this.jnK);
        }
        this.jnL = new g(this.cVi, this.jnH, this.jnI, bdUniqueId);
        loadData();
    }

    public a cwN() {
        return this.jnJ;
    }

    public g cwO() {
        return this.jnL;
    }

    public h cwP() {
        return null;
    }

    public PersonPolymericModel cwQ() {
        return this.jnG;
    }

    public e cwR() {
        return this.jnF;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jnF.bNc();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jnF.u(false, -1);
            this.jnF.rq(true);
            this.jnG.eu(this.mUserId);
            this.jnG.t(this.mUserId, this.mPortrait);
        } else {
            this.jnF.hideLoadingView();
            this.jnF.zY(8);
            this.jnF.an(this.jnE.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jnF.bNc();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jnG.t(this.mUserId, this.mPortrait);
        } else {
            this.jnF.hideLoadingView();
            l.showToast(this.cVi.getContext(), this.cVi.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jnF.bdu();
            this.jnF.dQ(arrayList);
            this.jnF.cwM();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a rr(boolean z) {
        if (z) {
            this.jnM = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jnG.t(this.mUserId, this.mPortrait);
            }
        }
        return this.jnG.cxE();
    }

    public void cwS() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cwT());
                }
            }
        });
    }

    public List<m> cwT() {
        if (this.jnG.cxE() == null) {
            return null;
        }
        return this.jnG.cxE().cwT();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.jnF.hideLoadingView();
        if (this.jnL != null) {
            this.jnL.d(aVar);
        }
        if (aVar != null) {
            this.jnF.b(aVar);
        }
        if (this.jnJ != null) {
            this.jnJ.d(aVar);
        } else {
            this.jnJ = new j(this.jnE, this, this.mPageId, this.mUserId, this.mIsHost);
            this.jnJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jnJ.a(this.jnK);
            this.jnJ.d(aVar);
        }
        if (this.jnM && aVar != null && aVar.joP != null && aVar.joP.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.joP.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.grR).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gGI == null) {
            this.gGI = new com.baidu.tieba.c.g(this.grR.getPageContext(), (NavigationBarCoverTip) this.grR.findViewById(R.id.navigation_cover_tip));
        }
        this.gGI.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jnJ != null) {
                this.jnJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jnP);
        if (this.jnJ != null) {
            this.jnJ.onDestroy();
        }
        if (this.jnG != null) {
            this.jnG.destroy();
        }
    }

    public void onPrimary(boolean z) {
        if (this.jnJ != null) {
            this.jnJ.onPrimary(z);
        }
    }

    public void onResume() {
        if (this.jnJ != null) {
            this.jnJ.onResume();
        }
    }
}
