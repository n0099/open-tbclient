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
/* loaded from: classes23.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext ehG;
    private final BaseFragmentActivity hEa;
    private com.baidu.tieba.c.h ivz;
    private boolean luA;
    private boolean luB;
    private final f.b luC;
    private CustomMessageListener luD;
    private BaseFragment lus;
    private f lut;
    private final PersonPolymericModel luu;
    private final d luv;
    private final BlackListModel luw;
    private k lux;
    private com.baidu.tieba.personPolymeric.event.c luy;
    private h luz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.luA = false;
        this.luC = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dl(View view2) {
                g.this.loadData();
            }
        };
        this.luD = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.lus = baseFragment;
        this.hEa = this.lus.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.luB = z2;
        this.ehG = this.hEa.getPageContext();
        MessageManager.getInstance().registerListener(this.luD);
        this.luv = new d(this.lus.getPageContext(), bdUniqueId);
        this.lut = new f(this.lus.getPageContext(), view, z);
        this.lut.a(this.luC);
        this.luy = new com.baidu.tieba.personPolymeric.event.c(this.ehG, this);
        this.luu = new PersonPolymericModel(this.hEa, bdUniqueId, z);
        this.luu.e(new p(z));
        this.luu.a(this);
        this.luu.a(this.luv);
        this.luw = new BlackListModel(this.hEa.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.lux = new k(this.lus, this, this.mPageId, this.mUserId, z);
            this.lux.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.lux.a(this.luy);
        }
        this.luz = new h(this.ehG, this.luv, this.luw, bdUniqueId);
        loadData();
    }

    public b dlT() {
        return this.lux;
    }

    public h dlU() {
        return this.luz;
    }

    public i dlV() {
        return null;
    }

    public PersonPolymericModel dlW() {
        return this.luu;
    }

    public f dlX() {
        return this.lut;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.lut.czx();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dlK().fZ(System.currentTimeMillis());
            this.lut.A(false, -1);
            this.lut.uM(true);
            this.luu.gb(this.mUserId);
            this.luu.w(this.mUserId, this.mPortrait);
        } else {
            this.lut.hideLoadingView();
            this.lut.FS(8);
            this.lut.aK(this.lus.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.lut.czx();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.luu.w(this.mUserId, this.mPortrait);
        } else {
            this.lut.hideLoadingView();
            l.showToast(this.ehG.getContext(), this.ehG.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.lut.bIk();
            this.lut.eT(arrayList);
            this.lut.dlS();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a uN(boolean z) {
        if (z) {
            this.luA = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.luu.w(this.mUserId, this.mPortrait);
            }
        }
        return this.luu.dmN();
    }

    public void dlY() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dlZ());
                }
            }
        });
    }

    public List<q> dlZ() {
        if (this.luu.dmN() == null) {
            return null;
        }
        return this.luu.dmN().dlZ();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.lut.hideLoadingView();
        if (this.luz != null) {
            this.luz.d(aVar);
        }
        if (aVar != null) {
            this.lut.b(aVar);
        }
        if (this.lux != null) {
            this.lux.d(aVar);
        } else {
            this.lux = new k(this.lus, this, this.mPageId, this.mUserId, this.mIsHost);
            this.lux.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.lux.a(this.luy);
            this.lux.d(aVar);
        }
        if (this.luA && aVar != null && aVar.lvB != null && aVar.lvB.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.lvB.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.hEa).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.ivz == null) {
            this.ivz = new com.baidu.tieba.c.h(this.hEa.getPageContext(), (NavigationBarCoverTip) this.hEa.findViewById(R.id.navigation_cover_tip));
        }
        this.ivz.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.lux != null) {
                this.lux.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.luD);
        if (this.lux != null) {
            this.lux.onDestroy();
        }
        if (this.luu != null) {
            this.luu.destroy();
        }
    }

    public void bL(boolean z) {
        if (this.lux != null) {
            this.lux.bL(z);
        }
    }

    public void onResume() {
        if (this.lux != null) {
            this.lux.onResume();
        }
    }
}
