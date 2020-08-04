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
    private com.baidu.tieba.c.h hZV;
    private final BaseFragmentActivity hjZ;
    private g kVA;
    private boolean kVB;
    private boolean kVC;
    private final e.b kVD;
    private CustomMessageListener kVE;
    private BaseFragment kVt;
    private e kVu;
    private final PersonPolymericModel kVv;
    private final c kVw;
    private final BlackListModel kVx;
    private j kVy;
    private com.baidu.tieba.personPolymeric.event.c kVz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.kVB = false;
        this.kVD = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cZ(View view2) {
                f.this.loadData();
            }
        };
        this.kVE = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.kVt = baseFragment;
        this.hjZ = this.kVt.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.kVC = z2;
        this.dVN = this.hjZ.getPageContext();
        MessageManager.getInstance().registerListener(this.kVE);
        this.kVw = new c(this.kVt.getPageContext(), bdUniqueId);
        this.kVu = new e(this.kVt.getPageContext(), view, z);
        this.kVu.a(this.kVD);
        this.kVz = new com.baidu.tieba.personPolymeric.event.c(this.dVN, this);
        this.kVv = new PersonPolymericModel(this.hjZ, bdUniqueId, z);
        this.kVv.e(new p(z));
        this.kVv.a(this);
        this.kVv.a(this.kVw);
        this.kVx = new BlackListModel(this.hjZ.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.kVy = new j(this.kVt, this, this.mPageId, this.mUserId, z);
            this.kVy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.kVy.a(this.kVz);
        }
        this.kVA = new g(this.dVN, this.kVw, this.kVx, bdUniqueId);
        loadData();
    }

    public a cXm() {
        return this.kVy;
    }

    public g cXn() {
        return this.kVA;
    }

    public h cXo() {
        return null;
    }

    public PersonPolymericModel cXp() {
        return this.kVv;
    }

    public e cXq() {
        return this.kVu;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.kVu.clt();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kVu.A(false, -1);
            this.kVu.tS(true);
            this.kVv.fz(this.mUserId);
            this.kVv.x(this.mUserId, this.mPortrait);
        } else {
            this.kVu.hideLoadingView();
            this.kVu.CW(8);
            this.kVu.aG(this.kVt.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.kVu.clt();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kVv.x(this.mUserId, this.mPortrait);
        } else {
            this.kVu.hideLoadingView();
            l.showToast(this.dVN.getContext(), this.dVN.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.kVu.bxU();
            this.kVu.eD(arrayList);
            this.kVu.cXl();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a tT(boolean z) {
        if (z) {
            this.kVB = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.kVv.x(this.mUserId, this.mPortrait);
            }
        }
        return this.kVv.cYc();
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
        if (this.kVv.cYc() == null) {
            return null;
        }
        return this.kVv.cYc().cXs();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.kVu.hideLoadingView();
        if (this.kVA != null) {
            this.kVA.d(aVar);
        }
        if (aVar != null) {
            this.kVu.b(aVar);
        }
        if (this.kVy != null) {
            this.kVy.d(aVar);
        } else {
            this.kVy = new j(this.kVt, this, this.mPageId, this.mUserId, this.mIsHost);
            this.kVy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.kVy.a(this.kVz);
            this.kVy.d(aVar);
        }
        if (this.kVB && aVar != null && aVar.kWC != null && aVar.kWC.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.kWC.left_days.intValue());
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
        if (this.hZV == null) {
            this.hZV = new com.baidu.tieba.c.h(this.hjZ.getPageContext(), (NavigationBarCoverTip) this.hjZ.findViewById(R.id.navigation_cover_tip));
        }
        this.hZV.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.kVy != null) {
                this.kVy.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.kVE);
        if (this.kVy != null) {
            this.kVy.onDestroy();
        }
        if (this.kVv != null) {
            this.kVv.destroy();
        }
    }

    public void bE(boolean z) {
        if (this.kVy != null) {
            this.kVy.bE(z);
        }
    }

    public void onResume() {
        if (this.kVy != null) {
            this.kVy.onResume();
        }
    }
}
