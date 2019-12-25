package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes8.dex */
public class f extends d implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext cQU;
    private com.baidu.tieba.c.g gBl;
    private final BaseFragmentActivity gms;
    private BaseFragment jiQ;
    private e jiR;
    private final PersonPolymericModel jiS;
    private final c jiT;
    private final BlackListModel jiU;
    private j jiV;
    private com.baidu.tieba.personPolymeric.event.c jiW;
    private g jiX;
    private boolean jiY;
    private boolean jiZ;
    private final e.b jja;
    private CustomMessageListener jjb;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private int mSkinType;
    private final long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        super(z);
        this.mSkinType = 3;
        this.jiY = false;
        this.jja = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cD(View view2) {
                f.this.loadData();
            }
        };
        this.jjb = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jiQ = baseFragment;
        this.gms = this.jiQ.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.jiZ = z2;
        this.cQU = this.gms.getPageContext();
        MessageManager.getInstance().registerListener(this.jjb);
        this.jiT = new c(this.jiQ.getPageContext(), bdUniqueId);
        this.jiR = new e(this.jiQ.getPageContext(), view, z);
        this.jiR.a(this.jja);
        this.jiW = new com.baidu.tieba.personPolymeric.event.c(this.cQU, this);
        this.jiS = new PersonPolymericModel(this.gms, bdUniqueId, z);
        this.jiS.e(new p(z));
        this.jiS.a(this);
        this.jiS.a(this.jiT);
        this.jiU = new BlackListModel(this.gms.getPageContext(), bdUniqueId);
        this.jiV = new j(this.jiQ, this, this.mPageId, this.mUserId, z);
        this.jiV.rc(this.jiZ);
        this.jiV.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jiV.a(this.jiW);
        this.jiX = new g(this.cQU, this.jiT, this.jiU, bdUniqueId);
        loadData();
    }

    public a cui() {
        return this.jiV;
    }

    public g cuj() {
        return this.jiX;
    }

    public h cuk() {
        return null;
    }

    public PersonPolymericModel cul() {
        return this.jiS;
    }

    public e cum() {
        return this.jiR;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jiR.bKr();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jiR.s(false, -1);
            this.jiR.qZ(true);
            this.jiS.es(this.mUserId);
            this.jiS.er(this.mUserId);
        } else {
            this.jiR.hideLoadingView();
            this.jiR.zM(8);
            this.jiR.an(this.jiQ.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jiR.bKr();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jiS.er(this.mUserId);
        } else {
            this.jiR.hideLoadingView();
            l.showToast(this.cQU.getContext(), this.cQU.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jiR.baH();
            this.jiR.dU(arrayList);
            this.jiR.cuh();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a ra(boolean z) {
        if (z) {
            this.jiY = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jiS.er(this.mUserId);
            }
        }
        return this.jiS.cuW();
    }

    public void cun() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.p(str2, f.this.cuo());
                }
            }
        });
    }

    public List<m> cuo() {
        if (this.jiS.cuW() == null) {
            return null;
        }
        return this.jiS.cuW().cuo();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.jiR.hideLoadingView();
        if (this.jiX != null) {
            this.jiX.d(aVar);
        }
        if (aVar != null) {
            this.jiR.b(aVar);
        }
        if (this.jiV != null) {
            this.jiV.d(aVar);
        }
        if (this.jiY && aVar != null && aVar.jka != null && aVar.jka.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.jka.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.gms).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gBl == null) {
            this.gBl = new com.baidu.tieba.c.g(this.gms.getPageContext(), (NavigationBarCoverTip) this.gms.findViewById(R.id.navigation_cover_tip));
        }
        this.gBl.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jiV != null) {
                this.jiV.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public boolean onBackPressed() {
        if (this.jiV != null) {
            return this.jiV.onBackPressed();
        }
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jjb);
        if (this.jiV != null) {
            this.jiV.onDestroy();
        }
        if (this.jiS != null) {
            this.jiS.destroy();
        }
    }

    public void kV(boolean z) {
        if (this.jiV != null) {
            this.jiV.kV(z);
        }
    }

    public void onResume() {
        if (this.jiV != null) {
            this.jiV.onResume();
        }
    }
}
