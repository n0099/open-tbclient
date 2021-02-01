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
    private final BaseFragmentActivity iKt;
    private BaseFragment mAg;
    private f mAh;
    private final PersonPolymericModel mAi;
    private final d mAj;
    private final BlackListModel mAk;
    private k mAl;
    private com.baidu.tieba.c.h mAm;
    private com.baidu.tieba.personPolymeric.event.c mAn;
    private h mAo;
    private boolean mAp;
    private boolean mAq;
    private final f.b mAr;
    private CustomMessageListener mAs;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mAp = false;
        this.mAr = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dV(View view2) {
                g.this.loadData();
            }
        };
        this.mAs = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mAg = baseFragment;
        this.iKt = this.mAg.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mAq = z2;
        this.eUY = this.iKt.getPageContext();
        MessageManager.getInstance().registerListener(this.mAs);
        this.mAj = new d(this.mAg.getPageContext(), bdUniqueId);
        this.mAh = new f(this.mAg.getPageContext(), view, z);
        this.mAh.a(this.mAr);
        this.mAn = new com.baidu.tieba.personPolymeric.event.c(this.eUY, this);
        this.mAi = new PersonPolymericModel(this.iKt, bdUniqueId, z);
        this.mAi.e(new p(z));
        this.mAi.a(this);
        this.mAi.a(this.mAj);
        this.mAk = new BlackListModel(this.iKt.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mAl = new k(this.mAg, this, this.mPageId, this.mUserId, z);
            this.mAl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mAl.a(this.mAn);
        }
        this.mAo = new h(this.eUY, this.mAj, this.mAk, bdUniqueId);
        loadData();
    }

    public b dym() {
        return this.mAl;
    }

    public h dyn() {
        return this.mAo;
    }

    public i dyo() {
        return null;
    }

    public PersonPolymericModel dyp() {
        return this.mAi;
    }

    public f dyq() {
        return this.mAh;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mAh.cOJ();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dyd().hw(System.currentTimeMillis());
            this.mAh.C(false, -1);
            this.mAh.wO(true);
            this.mAi.hy(this.mUserId);
            this.mAi.A(this.mUserId, this.mPortrait);
        } else {
            this.mAh.hideLoadingView();
            this.mAh.GY(8);
            this.mAh.aQ(this.mAg.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mAh.cOJ();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mAi.A(this.mUserId, this.mPortrait);
        } else {
            this.mAh.hideLoadingView();
            l.showToast(this.eUY.getContext(), this.eUY.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mAh.bSr();
            this.mAh.fx(arrayList);
            this.mAh.dyl();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a wP(boolean z) {
        if (z) {
            this.mAp = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mAi.A(this.mUserId, this.mPortrait);
            }
        }
        return this.mAi.dzi();
    }

    public void dyr() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dys());
                }
            }
        });
    }

    public List<n> dys() {
        if (this.mAi.dzi() == null) {
            return null;
        }
        return this.mAi.dzi().dys();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mAh.hideLoadingView();
        if (this.mAo != null) {
            this.mAo.d(aVar);
        }
        if (aVar != null) {
            this.mAh.b(aVar);
        }
        if (this.mAl != null) {
            this.mAl.d(aVar);
        } else {
            this.mAl = new k(this.mAg, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mAl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mAl.a(this.mAn);
            this.mAl.d(aVar);
        }
        if (this.mAp && aVar != null && aVar.mBr != null && aVar.mBr.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mBr.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.iKt).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mAm == null) {
            this.mAm = new com.baidu.tieba.c.h(this.iKt.getPageContext(), (NavigationBarCoverTip) this.iKt.findViewById(R.id.navigation_cover_tip));
        }
        this.mAm.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mAl != null) {
                this.mAl.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mAs);
        if (this.mAl != null) {
            this.mAl.onDestroy();
        }
        if (this.mAi != null) {
            this.mAi.destroy();
        }
    }

    public void cb(boolean z) {
        if (this.mAl != null) {
            this.mAl.cb(z);
        }
    }

    public void onResume() {
        if (this.mAl != null) {
            this.mAl.onResume();
        }
    }
}
