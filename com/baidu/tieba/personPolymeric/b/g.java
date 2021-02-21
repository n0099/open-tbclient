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
/* loaded from: classes8.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext eUY;
    private final BaseFragmentActivity iKH;
    private k mAA;
    private com.baidu.tieba.c.h mAB;
    private com.baidu.tieba.personPolymeric.event.c mAC;
    private h mAD;
    private boolean mAE;
    private boolean mAF;
    private final f.b mAG;
    private CustomMessageListener mAH;
    private BaseFragment mAv;
    private f mAw;
    private final PersonPolymericModel mAx;
    private final d mAy;
    private final BlackListModel mAz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mAE = false;
        this.mAG = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dV(View view2) {
                g.this.loadData();
            }
        };
        this.mAH = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mAv = baseFragment;
        this.iKH = this.mAv.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mAF = z2;
        this.eUY = this.iKH.getPageContext();
        MessageManager.getInstance().registerListener(this.mAH);
        this.mAy = new d(this.mAv.getPageContext(), bdUniqueId);
        this.mAw = new f(this.mAv.getPageContext(), view, z);
        this.mAw.a(this.mAG);
        this.mAC = new com.baidu.tieba.personPolymeric.event.c(this.eUY, this);
        this.mAx = new PersonPolymericModel(this.iKH, bdUniqueId, z);
        this.mAx.e(new p(z));
        this.mAx.a(this);
        this.mAx.a(this.mAy);
        this.mAz = new BlackListModel(this.iKH.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mAA = new k(this.mAv, this, this.mPageId, this.mUserId, z);
            this.mAA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mAA.a(this.mAC);
        }
        this.mAD = new h(this.eUY, this.mAy, this.mAz, bdUniqueId);
        loadData();
    }

    public b dyt() {
        return this.mAA;
    }

    public h dyu() {
        return this.mAD;
    }

    public i dyv() {
        return null;
    }

    public PersonPolymericModel dyw() {
        return this.mAx;
    }

    public f dyx() {
        return this.mAw;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mAw.cOQ();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dyk().hw(System.currentTimeMillis());
            this.mAw.C(false, -1);
            this.mAw.wO(true);
            this.mAx.hy(this.mUserId);
            this.mAx.A(this.mUserId, this.mPortrait);
        } else {
            this.mAw.hideLoadingView();
            this.mAw.GY(8);
            this.mAw.aQ(this.mAv.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mAw.cOQ();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mAx.A(this.mUserId, this.mPortrait);
        } else {
            this.mAw.hideLoadingView();
            l.showToast(this.eUY.getContext(), this.eUY.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mAw.bSy();
            this.mAw.fx(arrayList);
            this.mAw.dys();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a wP(boolean z) {
        if (z) {
            this.mAE = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mAx.A(this.mUserId, this.mPortrait);
            }
        }
        return this.mAx.dzp();
    }

    public void dyy() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dyz());
                }
            }
        });
    }

    public List<n> dyz() {
        if (this.mAx.dzp() == null) {
            return null;
        }
        return this.mAx.dzp().dyz();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mAw.hideLoadingView();
        if (this.mAD != null) {
            this.mAD.d(aVar);
        }
        if (aVar != null) {
            this.mAw.b(aVar);
        }
        if (this.mAA != null) {
            this.mAA.d(aVar);
        } else {
            this.mAA = new k(this.mAv, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mAA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mAA.a(this.mAC);
            this.mAA.d(aVar);
        }
        if (this.mAE && aVar != null && aVar.mBG != null && aVar.mBG.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mBG.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.iKH).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mAB == null) {
            this.mAB = new com.baidu.tieba.c.h(this.iKH.getPageContext(), (NavigationBarCoverTip) this.iKH.findViewById(R.id.navigation_cover_tip));
        }
        this.mAB.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mAA != null) {
                this.mAA.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mAH);
        if (this.mAA != null) {
            this.mAA.onDestroy();
        }
        if (this.mAx != null) {
            this.mAx.destroy();
        }
    }

    public void cb(boolean z) {
        if (this.mAA != null) {
            this.mAA.cb(z);
        }
    }

    public void onResume() {
        if (this.mAA != null) {
            this.mAA.onResume();
        }
    }
}
