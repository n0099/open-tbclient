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
    private TbPageContext etO;
    private final BaseFragmentActivity hSW;
    private com.baidu.tieba.c.h iKs;
    private BaseFragment lJE;
    private f lJF;
    private final PersonPolymericModel lJG;
    private final d lJH;
    private final BlackListModel lJI;
    private k lJJ;
    private com.baidu.tieba.personPolymeric.event.c lJK;
    private h lJL;
    private boolean lJM;
    private boolean lJN;
    private final f.b lJO;
    private CustomMessageListener lJP;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.lJM = false;
        this.lJO = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dp(View view2) {
                g.this.loadData();
            }
        };
        this.lJP = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.lJE = baseFragment;
        this.hSW = this.lJE.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.lJN = z2;
        this.etO = this.hSW.getPageContext();
        MessageManager.getInstance().registerListener(this.lJP);
        this.lJH = new d(this.lJE.getPageContext(), bdUniqueId);
        this.lJF = new f(this.lJE.getPageContext(), view, z);
        this.lJF.a(this.lJO);
        this.lJK = new com.baidu.tieba.personPolymeric.event.c(this.etO, this);
        this.lJG = new PersonPolymericModel(this.hSW, bdUniqueId, z);
        this.lJG.e(new p(z));
        this.lJG.a(this);
        this.lJG.a(this.lJH);
        this.lJI = new BlackListModel(this.hSW.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.lJJ = new k(this.lJE, this, this.mPageId, this.mUserId, z);
            this.lJJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.lJJ.a(this.lJK);
        }
        this.lJL = new h(this.etO, this.lJH, this.lJI, bdUniqueId);
        loadData();
    }

    public b dpD() {
        return this.lJJ;
    }

    public h dpE() {
        return this.lJL;
    }

    public i dpF() {
        return null;
    }

    public PersonPolymericModel dpG() {
        return this.lJG;
    }

    public f dpH() {
        return this.lJF;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.lJF.cCU();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dpu().gr(System.currentTimeMillis());
            this.lJF.D(false, -1);
            this.lJF.vt(true);
            this.lJG.gt(this.mUserId);
            this.lJG.x(this.mUserId, this.mPortrait);
        } else {
            this.lJF.hideLoadingView();
            this.lJF.Gy(8);
            this.lJF.aO(this.lJE.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.lJF.cCU();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lJG.x(this.mUserId, this.mPortrait);
        } else {
            this.lJF.hideLoadingView();
            l.showToast(this.etO.getContext(), this.etO.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.lJF.bKU();
            this.lJF.eW(arrayList);
            this.lJF.dpC();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a vu(boolean z) {
        if (z) {
            this.lJM = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.lJG.x(this.mUserId, this.mPortrait);
            }
        }
        return this.lJG.dqz();
    }

    public void dpI() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dpJ());
                }
            }
        });
    }

    public List<q> dpJ() {
        if (this.lJG.dqz() == null) {
            return null;
        }
        return this.lJG.dqz().dpJ();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.lJF.hideLoadingView();
        if (this.lJL != null) {
            this.lJL.d(aVar);
        }
        if (aVar != null) {
            this.lJF.b(aVar);
        }
        if (this.lJJ != null) {
            this.lJJ.d(aVar);
        } else {
            this.lJJ = new k(this.lJE, this, this.mPageId, this.mUserId, this.mIsHost);
            this.lJJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.lJJ.a(this.lJK);
            this.lJJ.d(aVar);
        }
        if (this.lJM && aVar != null && aVar.lKN != null && aVar.lKN.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.lKN.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.hSW).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.iKs == null) {
            this.iKs = new com.baidu.tieba.c.h(this.hSW.getPageContext(), (NavigationBarCoverTip) this.hSW.findViewById(R.id.navigation_cover_tip));
        }
        this.iKs.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lJJ != null) {
                this.lJJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lJP);
        if (this.lJJ != null) {
            this.lJJ.onDestroy();
        }
        if (this.lJG != null) {
            this.lJG.destroy();
        }
    }

    public void bO(boolean z) {
        if (this.lJJ != null) {
            this.lJJ.bO(z);
        }
    }

    public void onResume() {
        if (this.lJJ != null) {
            this.lJJ.onResume();
        }
    }
}
