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
    private BaseFragment mvL;
    private f mvM;
    private final PersonPolymericModel mvN;
    private final d mvO;
    private final BlackListModel mvP;
    private k mvQ;
    private com.baidu.tieba.c.h mvR;
    private com.baidu.tieba.personPolymeric.event.c mvS;
    private h mvT;
    private boolean mvU;
    private boolean mvV;
    private final f.b mvW;
    private CustomMessageListener mvX;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mvU = false;
        this.mvW = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dX(View view2) {
                g.this.loadData();
            }
        };
        this.mvX = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mvL = baseFragment;
        this.iJr = this.mvL.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mvV = z2;
        this.eXu = this.iJr.getPageContext();
        MessageManager.getInstance().registerListener(this.mvX);
        this.mvO = new d(this.mvL.getPageContext(), bdUniqueId);
        this.mvM = new f(this.mvL.getPageContext(), view, z);
        this.mvM.a(this.mvW);
        this.mvS = new com.baidu.tieba.personPolymeric.event.c(this.eXu, this);
        this.mvN = new PersonPolymericModel(this.iJr, bdUniqueId, z);
        this.mvN.e(new p(z));
        this.mvN.a(this);
        this.mvN.a(this.mvO);
        this.mvP = new BlackListModel(this.iJr.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mvQ = new k(this.mvL, this, this.mPageId, this.mUserId, z);
            this.mvQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mvQ.a(this.mvS);
        }
        this.mvT = new h(this.eXu, this.mvO, this.mvP, bdUniqueId);
        loadData();
    }

    public b dzV() {
        return this.mvQ;
    }

    public h dzW() {
        return this.mvT;
    }

    public i dzX() {
        return null;
    }

    public PersonPolymericModel dzY() {
        return this.mvN;
    }

    public f dzZ() {
        return this.mvM;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mvM.cQE();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dzM().hr(System.currentTimeMillis());
            this.mvM.C(false, -1);
            this.mvM.wB(true);
            this.mvN.ht(this.mUserId);
            this.mvN.z(this.mUserId, this.mPortrait);
        } else {
            this.mvM.hideLoadingView();
            this.mvM.In(8);
            this.mvM.aR(this.mvL.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mvM.cQE();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mvN.z(this.mUserId, this.mPortrait);
        } else {
            this.mvM.hideLoadingView();
            l.showToast(this.eXu.getContext(), this.eXu.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mvM.bVG();
            this.mvM.fz(arrayList);
            this.mvM.dzU();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a wC(boolean z) {
        if (z) {
            this.mvU = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mvN.z(this.mUserId, this.mPortrait);
            }
        }
        return this.mvN.dAR();
    }

    public void dAa() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dAb());
                }
            }
        });
    }

    public List<n> dAb() {
        if (this.mvN.dAR() == null) {
            return null;
        }
        return this.mvN.dAR().dAb();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mvM.hideLoadingView();
        if (this.mvT != null) {
            this.mvT.d(aVar);
        }
        if (aVar != null) {
            this.mvM.b(aVar);
        }
        if (this.mvQ != null) {
            this.mvQ.d(aVar);
        } else {
            this.mvQ = new k(this.mvL, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mvQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mvQ.a(this.mvS);
            this.mvQ.d(aVar);
        }
        if (this.mvU && aVar != null && aVar.mwV != null && aVar.mwV.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mwV.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.iJr).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mvR == null) {
            this.mvR = new com.baidu.tieba.c.h(this.iJr.getPageContext(), (NavigationBarCoverTip) this.iJr.findViewById(R.id.navigation_cover_tip));
        }
        this.mvR.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mvQ != null) {
                this.mvQ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mvX);
        if (this.mvQ != null) {
            this.mvQ.onDestroy();
        }
        if (this.mvN != null) {
            this.mvN.destroy();
        }
    }

    public void ca(boolean z) {
        if (this.mvQ != null) {
            this.mvQ.ca(z);
        }
    }

    public void onResume() {
        if (this.mvQ != null) {
            this.mvQ.onResume();
        }
    }
}
