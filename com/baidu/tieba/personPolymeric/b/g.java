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
/* loaded from: classes23.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext eGu;
    private final BaseFragmentActivity imj;
    private com.baidu.tieba.d.h jdy;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;
    private boolean mcA;
    private final f.b mcB;
    private CustomMessageListener mcC;
    private BaseFragment mcr;
    private f mcs;
    private final PersonPolymericModel mct;
    private final d mcu;
    private final BlackListModel mcv;
    private k mcw;
    private com.baidu.tieba.personPolymeric.event.c mcx;
    private h mcy;
    private boolean mcz;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mcz = false;
        this.mcB = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dC(View view2) {
                g.this.loadData();
            }
        };
        this.mcC = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mcr = baseFragment;
        this.imj = this.mcr.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mcA = z2;
        this.eGu = this.imj.getPageContext();
        MessageManager.getInstance().registerListener(this.mcC);
        this.mcu = new d(this.mcr.getPageContext(), bdUniqueId);
        this.mcs = new f(this.mcr.getPageContext(), view, z);
        this.mcs.a(this.mcB);
        this.mcx = new com.baidu.tieba.personPolymeric.event.c(this.eGu, this);
        this.mct = new PersonPolymericModel(this.imj, bdUniqueId, z);
        this.mct.e(new p(z));
        this.mct.a(this);
        this.mct.a(this.mcu);
        this.mcv = new BlackListModel(this.imj.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mcw = new k(this.mcr, this, this.mPageId, this.mUserId, z);
            this.mcw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mcw.a(this.mcx);
        }
        this.mcy = new h(this.eGu, this.mcu, this.mcv, bdUniqueId);
        loadData();
    }

    public b duM() {
        return this.mcw;
    }

    public h duN() {
        return this.mcy;
    }

    public i duO() {
        return null;
    }

    public PersonPolymericModel duP() {
        return this.mct;
    }

    public f duQ() {
        return this.mcs;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mcs.cIh();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.duD().gR(System.currentTimeMillis());
            this.mcs.D(false, -1);
            this.mcs.vW(true);
            this.mct.gT(this.mUserId);
            this.mct.y(this.mUserId, this.mPortrait);
        } else {
            this.mcs.hideLoadingView();
            this.mcs.HC(8);
            this.mcs.aQ(this.mcr.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mcs.cIh();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mct.y(this.mUserId, this.mPortrait);
        } else {
            this.mcs.hideLoadingView();
            l.showToast(this.eGu.getContext(), this.eGu.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mcs.bPp();
            this.mcs.fn(arrayList);
            this.mcs.duL();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a vX(boolean z) {
        if (z) {
            this.mcz = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mct.y(this.mUserId, this.mPortrait);
            }
        }
        return this.mct.dvI();
    }

    public void duR() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.duS());
                }
            }
        });
    }

    public List<q> duS() {
        if (this.mct.dvI() == null) {
            return null;
        }
        return this.mct.dvI().duS();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mcs.hideLoadingView();
        if (this.mcy != null) {
            this.mcy.d(aVar);
        }
        if (aVar != null) {
            this.mcs.b(aVar);
        }
        if (this.mcw != null) {
            this.mcw.d(aVar);
        } else {
            this.mcw = new k(this.mcr, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mcw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mcw.a(this.mcx);
            this.mcw.d(aVar);
        }
        if (this.mcz && aVar != null && aVar.mdA != null && aVar.mdA.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mdA.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.imj).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jdy == null) {
            this.jdy = new com.baidu.tieba.d.h(this.imj.getPageContext(), (NavigationBarCoverTip) this.imj.findViewById(R.id.navigation_cover_tip));
        }
        this.jdy.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mcw != null) {
                this.mcw.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mcC);
        if (this.mcw != null) {
            this.mcw.onDestroy();
        }
        if (this.mct != null) {
            this.mct.destroy();
        }
    }

    public void bS(boolean z) {
        if (this.mcw != null) {
            this.mcw.bS(z);
        }
    }

    public void onResume() {
        if (this.mcw != null) {
            this.mcw.onResume();
        }
    }
}
