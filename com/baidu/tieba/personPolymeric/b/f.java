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
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes18.dex */
public class f extends d implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext dVN;
    private com.baidu.tieba.c.h hZT;
    private final BaseFragmentActivity hjZ;
    private boolean kVA;
    private final e.b kVB;
    private CustomMessageListener kVC;
    private BaseFragment kVr;
    private e kVs;
    private final PersonPolymericModel kVt;
    private final c kVu;
    private final BlackListModel kVv;
    private j kVw;
    private com.baidu.tieba.personPolymeric.event.c kVx;
    private g kVy;
    private boolean kVz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.kVz = false;
        this.kVB = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cZ(View view2) {
                f.this.loadData();
            }
        };
        this.kVC = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.kVr = baseFragment;
        this.hjZ = this.kVr.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.kVA = z2;
        this.dVN = this.hjZ.getPageContext();
        MessageManager.getInstance().registerListener(this.kVC);
        this.kVu = new c(this.kVr.getPageContext(), bdUniqueId);
        this.kVs = new e(this.kVr.getPageContext(), view, z);
        this.kVs.a(this.kVB);
        this.kVx = new com.baidu.tieba.personPolymeric.event.c(this.dVN, this);
        this.kVt = new PersonPolymericModel(this.hjZ, bdUniqueId, z);
        this.kVt.e(new p(z));
        this.kVt.a(this);
        this.kVt.a(this.kVu);
        this.kVv = new BlackListModel(this.hjZ.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.kVw = new j(this.kVr, this, this.mPageId, this.mUserId, z);
            this.kVw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.kVw.a(this.kVx);
        }
        this.kVy = new g(this.dVN, this.kVu, this.kVv, bdUniqueId);
        loadData();
    }

    public a cXm() {
        return this.kVw;
    }

    public g cXn() {
        return this.kVy;
    }

    public h cXo() {
        return null;
    }

    public PersonPolymericModel cXp() {
        return this.kVt;
    }

    public e cXq() {
        return this.kVs;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.kVs.clt();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kVs.A(false, -1);
            this.kVs.tS(true);
            this.kVt.fz(this.mUserId);
            this.kVt.x(this.mUserId, this.mPortrait);
        } else {
            this.kVs.hideLoadingView();
            this.kVs.CW(8);
            this.kVs.aG(this.kVr.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.kVs.clt();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kVt.x(this.mUserId, this.mPortrait);
        } else {
            this.kVs.hideLoadingView();
            l.showToast(this.dVN.getContext(), this.dVN.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.kVs.bxU();
            this.kVs.eD(arrayList);
            this.kVs.cXl();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a tT(boolean z) {
        if (z) {
            this.kVz = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.kVt.x(this.mUserId, this.mPortrait);
            }
        }
        return this.kVt.cYc();
    }

    public void cXr() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cXs());
                }
            }
        });
    }

    public List<q> cXs() {
        if (this.kVt.cYc() == null) {
            return null;
        }
        return this.kVt.cYc().cXs();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.kVs.hideLoadingView();
        if (this.kVy != null) {
            this.kVy.d(aVar);
        }
        if (aVar != null) {
            this.kVs.b(aVar);
        }
        if (this.kVw != null) {
            this.kVw.d(aVar);
        } else {
            this.kVw = new j(this.kVr, this, this.mPageId, this.mUserId, this.mIsHost);
            this.kVw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.kVw.a(this.kVx);
            this.kVw.d(aVar);
        }
        if (this.kVz && aVar != null && aVar.kWA != null && aVar.kWA.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.kWA.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || as.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.hjZ).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hZT == null) {
            this.hZT = new com.baidu.tieba.c.h(this.hjZ.getPageContext(), (NavigationBarCoverTip) this.hjZ.findViewById(R.id.navigation_cover_tip));
        }
        this.hZT.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kVw != null) {
                this.kVw.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.kVC);
        if (this.kVw != null) {
            this.kVw.onDestroy();
        }
        if (this.kVt != null) {
            this.kVt.destroy();
        }
    }

    public void bE(boolean z) {
        if (this.kVw != null) {
            this.kVw.bE(z);
        }
    }

    public void onResume() {
        if (this.kVw != null) {
            this.kVw.onResume();
        }
    }
}
