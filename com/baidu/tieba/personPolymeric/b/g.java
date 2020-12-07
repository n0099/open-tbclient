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
    private final BaseFragmentActivity ixc;
    private com.baidu.tieba.d.h jrb;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;
    private final d mqA;
    private final BlackListModel mqB;
    private k mqC;
    private com.baidu.tieba.personPolymeric.event.c mqD;
    private h mqE;
    private boolean mqF;
    private boolean mqG;
    private final f.b mqH;
    private CustomMessageListener mqI;
    private BaseFragment mqx;
    private f mqy;
    private final PersonPolymericModel mqz;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mqF = false;
        this.mqH = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dN(View view2) {
                g.this.loadData();
            }
        };
        this.mqI = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mqx = baseFragment;
        this.ixc = this.mqx.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mqG = z2;
        this.eNx = this.ixc.getPageContext();
        MessageManager.getInstance().registerListener(this.mqI);
        this.mqA = new d(this.mqx.getPageContext(), bdUniqueId);
        this.mqy = new f(this.mqx.getPageContext(), view, z);
        this.mqy.a(this.mqH);
        this.mqD = new com.baidu.tieba.personPolymeric.event.c(this.eNx, this);
        this.mqz = new PersonPolymericModel(this.ixc, bdUniqueId, z);
        this.mqz.e(new p(z));
        this.mqz.a(this);
        this.mqz.a(this.mqA);
        this.mqB = new BlackListModel(this.ixc.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mqC = new k(this.mqx, this, this.mPageId, this.mUserId, z);
            this.mqC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mqC.a(this.mqD);
        }
        this.mqE = new h(this.eNx, this.mqA, this.mqB, bdUniqueId);
        loadData();
    }

    public b dAe() {
        return this.mqC;
    }

    public h dAf() {
        return this.mqE;
    }

    public i dAg() {
        return null;
    }

    public PersonPolymericModel dAh() {
        return this.mqz;
    }

    public f dAi() {
        return this.mqy;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mqy.cNw();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dzV().hw(System.currentTimeMillis());
            this.mqy.D(false, -1);
            this.mqy.wA(true);
            this.mqz.hy(this.mUserId);
            this.mqz.A(this.mUserId, this.mPortrait);
        } else {
            this.mqy.hideLoadingView();
            this.mqy.It(8);
            this.mqy.aR(this.mqx.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mqy.cNw();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mqz.A(this.mUserId, this.mPortrait);
        } else {
            this.mqy.hideLoadingView();
            l.showToast(this.eNx.getContext(), this.eNx.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mqy.bTa();
            this.mqy.fz(arrayList);
            this.mqy.dAd();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a wB(boolean z) {
        if (z) {
            this.mqF = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mqz.A(this.mUserId, this.mPortrait);
            }
        }
        return this.mqz.dBa();
    }

    public void dAj() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dAk());
                }
            }
        });
    }

    public List<q> dAk() {
        if (this.mqz.dBa() == null) {
            return null;
        }
        return this.mqz.dBa().dAk();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mqy.hideLoadingView();
        if (this.mqE != null) {
            this.mqE.d(aVar);
        }
        if (aVar != null) {
            this.mqy.b(aVar);
        }
        if (this.mqC != null) {
            this.mqC.d(aVar);
        } else {
            this.mqC = new k(this.mqx, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mqC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mqC.a(this.mqD);
            this.mqC.d(aVar);
        }
        if (this.mqF && aVar != null && aVar.mrG != null && aVar.mrG.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mrG.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.ixc).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jrb == null) {
            this.jrb = new com.baidu.tieba.d.h(this.ixc.getPageContext(), (NavigationBarCoverTip) this.ixc.findViewById(R.id.navigation_cover_tip));
        }
        this.jrb.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mqC != null) {
                this.mqC.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mqI);
        if (this.mqC != null) {
            this.mqC.onDestroy();
        }
        if (this.mqz != null) {
            this.mqz.destroy();
        }
    }

    public void cb(boolean z) {
        if (this.mqC != null) {
            this.mqC.cb(z);
        }
    }

    public void onResume() {
        if (this.mqC != null) {
            this.mqC.onResume();
        }
    }
}
