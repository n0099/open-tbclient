package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.a;
import com.baidu.tieba.personPolymeric.b.f;
import com.baidu.tieba.personPolymeric.c.p;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext eWx;
    private final BaseFragmentActivity iMq;
    private f mCA;
    private final PersonPolymericModel mCB;
    private final d mCC;
    private final BlackListModel mCD;
    private k mCE;
    private com.baidu.tieba.c.h mCF;
    private com.baidu.tieba.personPolymeric.event.c mCG;
    private h mCH;
    private boolean mCI;
    private boolean mCJ;
    private final f.b mCK;
    private CustomMessageListener mCL;
    private BaseFragment mCz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mCI = false;
        this.mCK = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dV(View view2) {
                g.this.loadData();
            }
        };
        this.mCL = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mCz = baseFragment;
        this.iMq = this.mCz.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mCJ = z2;
        this.eWx = this.iMq.getPageContext();
        MessageManager.getInstance().registerListener(this.mCL);
        this.mCC = new d(this.mCz.getPageContext(), bdUniqueId);
        this.mCA = new f(this.mCz.getPageContext(), view, z);
        this.mCA.a(this.mCK);
        this.mCG = new com.baidu.tieba.personPolymeric.event.c(this.eWx, this);
        this.mCB = new PersonPolymericModel(this.iMq, bdUniqueId, z);
        this.mCB.e(new p(z));
        this.mCB.a(this);
        this.mCB.a(this.mCC);
        this.mCD = new BlackListModel(this.iMq.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mCE = new k(this.mCz, this, this.mPageId, this.mUserId, z);
            this.mCE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mCE.a(this.mCG);
        }
        this.mCH = new h(this.eWx, this.mCC, this.mCD, bdUniqueId);
        loadData();
    }

    public b dyC() {
        return this.mCE;
    }

    public h dyD() {
        return this.mCH;
    }

    public i dyE() {
        return null;
    }

    public PersonPolymericModel dyF() {
        return this.mCB;
    }

    public f dyG() {
        return this.mCA;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mCA.cOX();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dyt().hw(System.currentTimeMillis());
            this.mCA.C(false, -1);
            this.mCA.wO(true);
            this.mCB.hy(this.mUserId);
            this.mCB.A(this.mUserId, this.mPortrait);
        } else {
            this.mCA.hideLoadingView();
            this.mCA.Hb(8);
            this.mCA.aQ(this.mCz.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mCA.cOX();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mCB.A(this.mUserId, this.mPortrait);
        } else {
            this.mCA.hideLoadingView();
            l.showToast(this.eWx.getContext(), this.eWx.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mCA.bSE();
            this.mCA.fx(arrayList);
            this.mCA.dyB();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a wP(boolean z) {
        if (z) {
            this.mCI = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mCB.A(this.mUserId, this.mPortrait);
            }
        }
        return this.mCB.dzy();
    }

    public void dyH() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dyI());
                }
            }
        });
    }

    public List<n> dyI() {
        if (this.mCB.dzy() == null) {
            return null;
        }
        return this.mCB.dzy().dyI();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mCA.hideLoadingView();
        if (this.mCH != null) {
            this.mCH.d(aVar);
        }
        if (aVar != null) {
            this.mCA.b(aVar);
        }
        if (this.mCE != null) {
            this.mCE.d(aVar);
        } else {
            this.mCE = new k(this.mCz, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mCE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mCE.a(this.mCG);
            this.mCE.d(aVar);
        }
        if (this.mCI && aVar != null && aVar.mDM != null && aVar.mDM.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mDM.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.iMq).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mCF == null) {
            this.mCF = new com.baidu.tieba.c.h(this.iMq.getPageContext(), (NavigationBarCoverTip) this.iMq.findViewById(R.id.navigation_cover_tip));
        }
        this.mCF.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mCE != null) {
                this.mCE.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mCL);
        if (this.mCE != null) {
            this.mCE.onDestroy();
        }
        if (this.mCB != null) {
            this.mCB.destroy();
        }
    }

    public void cb(boolean z) {
        if (this.mCE != null) {
            this.mCE.cb(z);
        }
    }

    public void onResume() {
        if (this.mCE != null) {
            this.mCE.onResume();
        }
    }
}
