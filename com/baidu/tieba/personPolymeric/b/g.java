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
/* loaded from: classes18.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext efr;
    private final BaseFragmentActivity hwW;
    private com.baidu.tieba.c.h ioj;
    private k llA;
    private com.baidu.tieba.personPolymeric.event.c llB;
    private h llC;
    private boolean llD;
    private boolean llE;
    private final f.b llF;
    private CustomMessageListener llG;
    private BaseFragment llv;
    private f llw;
    private final PersonPolymericModel llx;
    private final d lly;
    private final BlackListModel llz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.llD = false;
        this.llF = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dd(View view2) {
                g.this.loadData();
            }
        };
        this.llG = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.llv = baseFragment;
        this.hwW = this.llv.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.llE = z2;
        this.efr = this.hwW.getPageContext();
        MessageManager.getInstance().registerListener(this.llG);
        this.lly = new d(this.llv.getPageContext(), bdUniqueId);
        this.llw = new f(this.llv.getPageContext(), view, z);
        this.llw.a(this.llF);
        this.llB = new com.baidu.tieba.personPolymeric.event.c(this.efr, this);
        this.llx = new PersonPolymericModel(this.hwW, bdUniqueId, z);
        this.llx.e(new p(z));
        this.llx.a(this);
        this.llx.a(this.lly);
        this.llz = new BlackListModel(this.hwW.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.llA = new k(this.llv, this, this.mPageId, this.mUserId, z);
            this.llA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.llA.a(this.llB);
        }
        this.llC = new h(this.efr, this.lly, this.llz, bdUniqueId);
        loadData();
    }

    public b dio() {
        return this.llA;
    }

    public h dip() {
        return this.llC;
    }

    public i diq() {
        return null;
    }

    public PersonPolymericModel dir() {
        return this.llx;
    }

    public f dis() {
        return this.llw;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.llw.cwd();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dif().fL(System.currentTimeMillis());
            this.llw.A(false, -1);
            this.llw.uE(true);
            this.llx.fN(this.mUserId);
            this.llx.w(this.mUserId, this.mPortrait);
        } else {
            this.llw.hideLoadingView();
            this.llw.Fr(8);
            this.llw.aK(this.llv.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.llw.cwd();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.llx.w(this.mUserId, this.mPortrait);
        } else {
            this.llw.hideLoadingView();
            l.showToast(this.efr.getContext(), this.efr.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.llw.bGU();
            this.llw.eL(arrayList);
            this.llw.din();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a uF(boolean z) {
        if (z) {
            this.llD = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.llx.w(this.mUserId, this.mPortrait);
            }
        }
        return this.llx.dji();
    }

    public void dit() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.diu());
                }
            }
        });
    }

    public List<q> diu() {
        if (this.llx.dji() == null) {
            return null;
        }
        return this.llx.dji().diu();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.llw.hideLoadingView();
        if (this.llC != null) {
            this.llC.d(aVar);
        }
        if (aVar != null) {
            this.llw.b(aVar);
        }
        if (this.llA != null) {
            this.llA.d(aVar);
        } else {
            this.llA = new k(this.llv, this, this.mPageId, this.mUserId, this.mIsHost);
            this.llA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.llA.a(this.llB);
            this.llA.d(aVar);
        }
        if (this.llD && aVar != null && aVar.lmE != null && aVar.lmE.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.lmE.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.hwW).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.ioj == null) {
            this.ioj = new com.baidu.tieba.c.h(this.hwW.getPageContext(), (NavigationBarCoverTip) this.hwW.findViewById(R.id.navigation_cover_tip));
        }
        this.ioj.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.llA != null) {
                this.llA.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.llG);
        if (this.llA != null) {
            this.llA.onDestroy();
        }
        if (this.llx != null) {
            this.llx.destroy();
        }
    }

    public void bJ(boolean z) {
        if (this.llA != null) {
            this.llA.bJ(z);
        }
    }

    public void onResume() {
        if (this.llA != null) {
            this.llA.onResume();
        }
    }
}
