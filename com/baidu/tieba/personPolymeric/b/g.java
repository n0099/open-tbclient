package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes24.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext eNx;
    private final BaseFragmentActivity ixe;
    private com.baidu.tieba.d.h jrd;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;
    private f mqA;
    private final PersonPolymericModel mqB;
    private final d mqC;
    private final BlackListModel mqD;
    private k mqE;
    private com.baidu.tieba.personPolymeric.event.c mqF;
    private h mqG;
    private boolean mqH;
    private boolean mqI;
    private final f.b mqJ;
    private CustomMessageListener mqK;
    private BaseFragment mqz;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mqH = false;
        this.mqJ = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dN(View view2) {
                g.this.loadData();
            }
        };
        this.mqK = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mqz = baseFragment;
        this.ixe = this.mqz.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mqI = z2;
        this.eNx = this.ixe.getPageContext();
        MessageManager.getInstance().registerListener(this.mqK);
        this.mqC = new d(this.mqz.getPageContext(), bdUniqueId);
        this.mqA = new f(this.mqz.getPageContext(), view, z);
        this.mqA.a(this.mqJ);
        this.mqF = new com.baidu.tieba.personPolymeric.event.c(this.eNx, this);
        this.mqB = new PersonPolymericModel(this.ixe, bdUniqueId, z);
        this.mqB.e(new p(z));
        this.mqB.a(this);
        this.mqB.a(this.mqC);
        this.mqD = new BlackListModel(this.ixe.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mqE = new k(this.mqz, this, this.mPageId, this.mUserId, z);
            this.mqE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mqE.a(this.mqF);
        }
        this.mqG = new h(this.eNx, this.mqC, this.mqD, bdUniqueId);
        loadData();
    }

    public b dAf() {
        return this.mqE;
    }

    public h dAg() {
        return this.mqG;
    }

    public i dAh() {
        return null;
    }

    public PersonPolymericModel dAi() {
        return this.mqB;
    }

    public f dAj() {
        return this.mqA;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mqA.cNx();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dzW().hw(System.currentTimeMillis());
            this.mqA.D(false, -1);
            this.mqA.wA(true);
            this.mqB.hy(this.mUserId);
            this.mqB.A(this.mUserId, this.mPortrait);
        } else {
            this.mqA.hideLoadingView();
            this.mqA.It(8);
            this.mqA.aR(this.mqz.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mqA.cNx();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mqB.A(this.mUserId, this.mPortrait);
        } else {
            this.mqA.hideLoadingView();
            l.showToast(this.eNx.getContext(), this.eNx.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mqA.bTb();
            this.mqA.fz(arrayList);
            this.mqA.dAe();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a wB(boolean z) {
        if (z) {
            this.mqH = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mqB.A(this.mUserId, this.mPortrait);
            }
        }
        return this.mqB.dBb();
    }

    public void dAk() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dAl());
                }
            }
        });
    }

    public List<q> dAl() {
        if (this.mqB.dBb() == null) {
            return null;
        }
        return this.mqB.dBb().dAl();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mqA.hideLoadingView();
        if (this.mqG != null) {
            this.mqG.d(aVar);
        }
        if (aVar != null) {
            this.mqA.b(aVar);
        }
        if (this.mqE != null) {
            this.mqE.d(aVar);
        } else {
            this.mqE = new k(this.mqz, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mqE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mqE.a(this.mqF);
            this.mqE.d(aVar);
        }
        if (this.mqH && aVar != null && aVar.mrI != null && aVar.mrI.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mrI.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.ixe).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jrd == null) {
            this.jrd = new com.baidu.tieba.d.h(this.ixe.getPageContext(), (NavigationBarCoverTip) this.ixe.findViewById(R.id.navigation_cover_tip));
        }
        this.jrd.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mqE != null) {
                this.mqE.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mqK);
        if (this.mqE != null) {
            this.mqE.onDestroy();
        }
        if (this.mqB != null) {
            this.mqB.destroy();
        }
    }

    public void cb(boolean z) {
        if (this.mqE != null) {
            this.mqE.cb(z);
        }
    }

    public void onResume() {
        if (this.mqE != null) {
            this.mqE.onResume();
        }
    }
}
