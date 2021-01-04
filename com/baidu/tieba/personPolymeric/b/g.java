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
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes8.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext eXu;
    private final BaseFragmentActivity iJr;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;
    private BaseFragment mvM;
    private f mvN;
    private final PersonPolymericModel mvO;
    private final d mvP;
    private final BlackListModel mvQ;
    private k mvR;
    private com.baidu.tieba.c.h mvS;
    private com.baidu.tieba.personPolymeric.event.c mvT;
    private h mvU;
    private boolean mvV;
    private boolean mvW;
    private final f.b mvX;
    private CustomMessageListener mvY;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mvV = false;
        this.mvX = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dX(View view2) {
                g.this.loadData();
            }
        };
        this.mvY = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mvM = baseFragment;
        this.iJr = this.mvM.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mvW = z2;
        this.eXu = this.iJr.getPageContext();
        MessageManager.getInstance().registerListener(this.mvY);
        this.mvP = new d(this.mvM.getPageContext(), bdUniqueId);
        this.mvN = new f(this.mvM.getPageContext(), view, z);
        this.mvN.a(this.mvX);
        this.mvT = new com.baidu.tieba.personPolymeric.event.c(this.eXu, this);
        this.mvO = new PersonPolymericModel(this.iJr, bdUniqueId, z);
        this.mvO.e(new p(z));
        this.mvO.a(this);
        this.mvO.a(this.mvP);
        this.mvQ = new BlackListModel(this.iJr.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mvR = new k(this.mvM, this, this.mPageId, this.mUserId, z);
            this.mvR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mvR.a(this.mvT);
        }
        this.mvU = new h(this.eXu, this.mvP, this.mvQ, bdUniqueId);
        loadData();
    }

    public b dzU() {
        return this.mvR;
    }

    public h dzV() {
        return this.mvU;
    }

    public i dzW() {
        return null;
    }

    public PersonPolymericModel dzX() {
        return this.mvO;
    }

    public f dzY() {
        return this.mvN;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mvN.cQD();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dzL().hr(System.currentTimeMillis());
            this.mvN.C(false, -1);
            this.mvN.wB(true);
            this.mvO.ht(this.mUserId);
            this.mvO.z(this.mUserId, this.mPortrait);
        } else {
            this.mvN.hideLoadingView();
            this.mvN.In(8);
            this.mvN.aR(this.mvM.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mvN.cQD();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mvO.z(this.mUserId, this.mPortrait);
        } else {
            this.mvN.hideLoadingView();
            l.showToast(this.eXu.getContext(), this.eXu.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mvN.bVF();
            this.mvN.fz(arrayList);
            this.mvN.dzT();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a wC(boolean z) {
        if (z) {
            this.mvV = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mvO.z(this.mUserId, this.mPortrait);
            }
        }
        return this.mvO.dAQ();
    }

    public void dzZ() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dAa());
                }
            }
        });
    }

    public List<n> dAa() {
        if (this.mvO.dAQ() == null) {
            return null;
        }
        return this.mvO.dAQ().dAa();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mvN.hideLoadingView();
        if (this.mvU != null) {
            this.mvU.d(aVar);
        }
        if (aVar != null) {
            this.mvN.b(aVar);
        }
        if (this.mvR != null) {
            this.mvR.d(aVar);
        } else {
            this.mvR = new k(this.mvM, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mvR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mvR.a(this.mvT);
            this.mvR.d(aVar);
        }
        if (this.mvV && aVar != null && aVar.mwW != null && aVar.mwW.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mwW.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.iJr).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mvS == null) {
            this.mvS = new com.baidu.tieba.c.h(this.iJr.getPageContext(), (NavigationBarCoverTip) this.iJr.findViewById(R.id.navigation_cover_tip));
        }
        this.mvS.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mvR != null) {
                this.mvR.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mvY);
        if (this.mvR != null) {
            this.mvR.onDestroy();
        }
        if (this.mvO != null) {
            this.mvO.destroy();
        }
    }

    public void ca(boolean z) {
        if (this.mvR != null) {
            this.mvR.ca(z);
        }
    }

    public void onResume() {
        if (this.mvR != null) {
            this.mvR.onResume();
        }
    }
}
