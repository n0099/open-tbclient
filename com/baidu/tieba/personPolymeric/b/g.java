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
/* loaded from: classes24.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext eCn;
    private com.baidu.tieba.c.h iWO;
    private final BaseFragmentActivity ifx;
    private BaseFragment lWa;
    private f lWb;
    private final PersonPolymericModel lWc;
    private final d lWd;
    private final BlackListModel lWe;
    private k lWf;
    private com.baidu.tieba.personPolymeric.event.c lWg;
    private h lWh;
    private boolean lWi;
    private boolean lWj;
    private final f.b lWk;
    private CustomMessageListener lWl;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.lWi = false;
        this.lWk = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dt(View view2) {
                g.this.loadData();
            }
        };
        this.lWl = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.lWa = baseFragment;
        this.ifx = this.lWa.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.lWj = z2;
        this.eCn = this.ifx.getPageContext();
        MessageManager.getInstance().registerListener(this.lWl);
        this.lWd = new d(this.lWa.getPageContext(), bdUniqueId);
        this.lWb = new f(this.lWa.getPageContext(), view, z);
        this.lWb.a(this.lWk);
        this.lWg = new com.baidu.tieba.personPolymeric.event.c(this.eCn, this);
        this.lWc = new PersonPolymericModel(this.ifx, bdUniqueId, z);
        this.lWc.e(new p(z));
        this.lWc.a(this);
        this.lWc.a(this.lWd);
        this.lWe = new BlackListModel(this.ifx.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.lWf = new k(this.lWa, this, this.mPageId, this.mUserId, z);
            this.lWf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.lWf.a(this.lWg);
        }
        this.lWh = new h(this.eCn, this.lWd, this.lWe, bdUniqueId);
        loadData();
    }

    public b dsK() {
        return this.lWf;
    }

    public h dsL() {
        return this.lWh;
    }

    public i dsM() {
        return null;
    }

    public PersonPolymericModel dsN() {
        return this.lWc;
    }

    public f dsO() {
        return this.lWb;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.lWb.cGb();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dsB().gs(System.currentTimeMillis());
            this.lWb.D(false, -1);
            this.lWb.vK(true);
            this.lWc.gu(this.mUserId);
            this.lWc.x(this.mUserId, this.mPortrait);
        } else {
            this.lWb.hideLoadingView();
            this.lWb.GR(8);
            this.lWb.aQ(this.lWa.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.lWb.cGb();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lWc.x(this.mUserId, this.mPortrait);
        } else {
            this.lWb.hideLoadingView();
            l.showToast(this.eCn.getContext(), this.eCn.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.lWb.bNw();
            this.lWb.ff(arrayList);
            this.lWb.dsJ();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a vL(boolean z) {
        if (z) {
            this.lWi = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.lWc.x(this.mUserId, this.mPortrait);
            }
        }
        return this.lWc.dtG();
    }

    public void dsP() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dsQ());
                }
            }
        });
    }

    public List<q> dsQ() {
        if (this.lWc.dtG() == null) {
            return null;
        }
        return this.lWc.dtG().dsQ();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.lWb.hideLoadingView();
        if (this.lWh != null) {
            this.lWh.d(aVar);
        }
        if (aVar != null) {
            this.lWb.b(aVar);
        }
        if (this.lWf != null) {
            this.lWf.d(aVar);
        } else {
            this.lWf = new k(this.lWa, this, this.mPageId, this.mUserId, this.mIsHost);
            this.lWf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.lWf.a(this.lWg);
            this.lWf.d(aVar);
        }
        if (this.lWi && aVar != null && aVar.lXj != null && aVar.lXj.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.lXj.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.ifx).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.iWO == null) {
            this.iWO = new com.baidu.tieba.c.h(this.ifx.getPageContext(), (NavigationBarCoverTip) this.ifx.findViewById(R.id.navigation_cover_tip));
        }
        this.iWO.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lWf != null) {
                this.lWf.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lWl);
        if (this.lWf != null) {
            this.lWf.onDestroy();
        }
        if (this.lWc != null) {
            this.lWc.destroy();
        }
    }

    public void bP(boolean z) {
        if (this.lWf != null) {
            this.lWf.bP(z);
        }
    }

    public void onResume() {
        if (this.lWf != null) {
            this.lWf.onResume();
        }
    }
}
