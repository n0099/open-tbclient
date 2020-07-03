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
import com.baidu.tbadk.core.util.ar;
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
    private TbPageContext dPv;
    private com.baidu.tieba.c.h hTU;
    private final BaseFragmentActivity hep;
    private boolean kMA;
    private final e.b kMB;
    private CustomMessageListener kMC;
    private BaseFragment kMr;
    private e kMs;
    private final PersonPolymericModel kMt;
    private final c kMu;
    private final BlackListModel kMv;
    private j kMw;
    private com.baidu.tieba.personPolymeric.event.c kMx;
    private g kMy;
    private boolean kMz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.kMz = false;
        this.kMB = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cT(View view2) {
                f.this.loadData();
            }
        };
        this.kMC = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.kMr = baseFragment;
        this.hep = this.kMr.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.kMA = z2;
        this.dPv = this.hep.getPageContext();
        MessageManager.getInstance().registerListener(this.kMC);
        this.kMu = new c(this.kMr.getPageContext(), bdUniqueId);
        this.kMs = new e(this.kMr.getPageContext(), view, z);
        this.kMs.a(this.kMB);
        this.kMx = new com.baidu.tieba.personPolymeric.event.c(this.dPv, this);
        this.kMt = new PersonPolymericModel(this.hep, bdUniqueId, z);
        this.kMt.e(new p(z));
        this.kMt.a(this);
        this.kMt.a(this.kMu);
        this.kMv = new BlackListModel(this.hep.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.kMw = new j(this.kMr, this, this.mPageId, this.mUserId, z);
            this.kMw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.kMw.a(this.kMx);
        }
        this.kMy = new g(this.dPv, this.kMu, this.kMv, bdUniqueId);
        loadData();
    }

    public a cTv() {
        return this.kMw;
    }

    public g cTw() {
        return this.kMy;
    }

    public h cTx() {
        return null;
    }

    public PersonPolymericModel cTy() {
        return this.kMt;
    }

    public e cTz() {
        return this.kMs;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.kMs.chT();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kMs.A(false, -1);
            this.kMs.tm(true);
            this.kMt.fl(this.mUserId);
            this.kMt.v(this.mUserId, this.mPortrait);
        } else {
            this.kMs.hideLoadingView();
            this.kMs.Cw(8);
            this.kMs.aI(this.kMr.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.kMs.chT();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kMt.v(this.mUserId, this.mPortrait);
        } else {
            this.kMs.hideLoadingView();
            l.showToast(this.dPv.getContext(), this.dPv.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.kMs.buK();
            this.kMs.ex(arrayList);
            this.kMs.cTu();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a tn(boolean z) {
        if (z) {
            this.kMz = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.kMt.v(this.mUserId, this.mPortrait);
            }
        }
        return this.kMt.cUl();
    }

    public void cTA() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cTB());
                }
            }
        });
    }

    public List<q> cTB() {
        if (this.kMt.cUl() == null) {
            return null;
        }
        return this.kMt.cUl().cTB();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.kMs.hideLoadingView();
        if (this.kMy != null) {
            this.kMy.d(aVar);
        }
        if (aVar != null) {
            this.kMs.b(aVar);
        }
        if (this.kMw != null) {
            this.kMw.d(aVar);
        } else {
            this.kMw = new j(this.kMr, this, this.mPageId, this.mUserId, this.mIsHost);
            this.kMw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.kMw.a(this.kMx);
            this.kMw.d(aVar);
        }
        if (this.kMz && aVar != null && aVar.kNC != null && aVar.kNC.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.kNC.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ar.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.hep).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hTU == null) {
            this.hTU = new com.baidu.tieba.c.h(this.hep.getPageContext(), (NavigationBarCoverTip) this.hep.findViewById(R.id.navigation_cover_tip));
        }
        this.hTU.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kMw != null) {
                this.kMw.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.kMC);
        if (this.kMw != null) {
            this.kMw.onDestroy();
        }
        if (this.kMt != null) {
            this.kMt.destroy();
        }
    }

    public void bB(boolean z) {
        if (this.kMw != null) {
            this.kMw.bB(z);
        }
    }

    public void onResume() {
        if (this.kMw != null) {
            this.kMw.onResume();
        }
    }
}
