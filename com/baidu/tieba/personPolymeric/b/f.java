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
    private TbPageContext duK;
    private final BaseFragmentActivity gCM;
    private com.baidu.tieba.c.g hrf;
    private j jZA;
    private com.baidu.tieba.personPolymeric.event.c jZB;
    private g jZC;
    private boolean jZD;
    private boolean jZE;
    private final e.b jZF;
    private CustomMessageListener jZG;
    private BaseFragment jZv;
    private e jZw;
    private final PersonPolymericModel jZx;
    private final c jZy;
    private final BlackListModel jZz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.jZD = false;
        this.jZF = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cR(View view2) {
                f.this.loadData();
            }
        };
        this.jZG = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jZv = baseFragment;
        this.gCM = this.jZv.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.jZE = z2;
        this.duK = this.gCM.getPageContext();
        MessageManager.getInstance().registerListener(this.jZG);
        this.jZy = new c(this.jZv.getPageContext(), bdUniqueId);
        this.jZw = new e(this.jZv.getPageContext(), view, z);
        this.jZw.a(this.jZF);
        this.jZB = new com.baidu.tieba.personPolymeric.event.c(this.duK, this);
        this.jZx = new PersonPolymericModel(this.gCM, bdUniqueId, z);
        this.jZx.e(new p(z));
        this.jZx.a(this);
        this.jZx.a(this.jZy);
        this.jZz = new BlackListModel(this.gCM.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.jZA = new j(this.jZv, this, this.mPageId, this.mUserId, z);
            this.jZA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jZA.a(this.jZB);
        }
        this.jZC = new g(this.duK, this.jZy, this.jZz, bdUniqueId);
        loadData();
    }

    public a cHO() {
        return this.jZA;
    }

    public g cHP() {
        return this.jZC;
    }

    public h cHQ() {
        return null;
    }

    public PersonPolymericModel cHR() {
        return this.jZx;
    }

    public e cHS() {
        return this.jZw;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jZw.bXP();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jZw.v(false, -1);
            this.jZw.sA(true);
            this.jZx.fh(this.mUserId);
            this.jZx.v(this.mUserId, this.mPortrait);
        } else {
            this.jZw.hideLoadingView();
            this.jZw.AH(8);
            this.jZw.at(this.jZv.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jZw.bXP();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jZx.v(this.mUserId, this.mPortrait);
        } else {
            this.jZw.hideLoadingView();
            l.showToast(this.duK.getContext(), this.duK.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jZw.bmo();
            this.jZw.eb(arrayList);
            this.jZw.cHN();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a sB(boolean z) {
        if (z) {
            this.jZD = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jZx.v(this.mUserId, this.mPortrait);
            }
        }
        return this.jZx.cIE();
    }

    public void cHT() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cHU());
                }
            }
        });
    }

    public List<m> cHU() {
        if (this.jZx.cIE() == null) {
            return null;
        }
        return this.jZx.cIE().cHU();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.jZw.hideLoadingView();
        if (this.jZC != null) {
            this.jZC.d(aVar);
        }
        if (aVar != null) {
            this.jZw.b(aVar);
        }
        if (this.jZA != null) {
            this.jZA.d(aVar);
        } else {
            this.jZA = new j(this.jZv, this, this.mPageId, this.mUserId, this.mIsHost);
            this.jZA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jZA.a(this.jZB);
            this.jZA.d(aVar);
        }
        if (this.jZD && aVar != null && aVar.kaH != null && aVar.kaH.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.kaH.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.gCM).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hrf == null) {
            this.hrf = new com.baidu.tieba.c.g(this.gCM.getPageContext(), (NavigationBarCoverTip) this.gCM.findViewById(R.id.navigation_cover_tip));
        }
        this.hrf.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jZA != null) {
                this.jZA.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jZG);
        if (this.jZA != null) {
            this.jZA.onDestroy();
        }
        if (this.jZx != null) {
            this.jZx.destroy();
        }
    }

    public void jb(boolean z) {
        if (this.jZA != null) {
            this.jZA.jb(z);
        }
    }

    public void onResume() {
        if (this.jZA != null) {
            this.jZA.onResume();
        }
    }
}
