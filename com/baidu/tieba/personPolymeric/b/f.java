package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
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
/* loaded from: classes11.dex */
public class f extends d implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext dIF;
    private final BaseFragmentActivity gRG;
    private com.baidu.tieba.c.g hGH;
    private com.baidu.tieba.personPolymeric.event.c ksA;
    private g ksB;
    private boolean ksC;
    private boolean ksD;
    private final e.b ksE;
    private CustomMessageListener ksF;
    private BaseFragment ksu;
    private e ksv;
    private final PersonPolymericModel ksw;
    private final c ksx;
    private final BlackListModel ksy;
    private j ksz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.ksC = false;
        this.ksE = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cS(View view2) {
                f.this.loadData();
            }
        };
        this.ksF = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.ksu = baseFragment;
        this.gRG = this.ksu.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.ksD = z2;
        this.dIF = this.gRG.getPageContext();
        MessageManager.getInstance().registerListener(this.ksF);
        this.ksx = new c(this.ksu.getPageContext(), bdUniqueId);
        this.ksv = new e(this.ksu.getPageContext(), view, z);
        this.ksv.a(this.ksE);
        this.ksA = new com.baidu.tieba.personPolymeric.event.c(this.dIF, this);
        this.ksw = new PersonPolymericModel(this.gRG, bdUniqueId, z);
        this.ksw.e(new p(z));
        this.ksw.a(this);
        this.ksw.a(this.ksx);
        this.ksy = new BlackListModel(this.gRG.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.ksz = new j(this.ksu, this, this.mPageId, this.mUserId, z);
            this.ksz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.ksz.a(this.ksA);
        }
        this.ksB = new g(this.dIF, this.ksx, this.ksy, bdUniqueId);
        loadData();
    }

    public a cPe() {
        return this.ksz;
    }

    public g cPf() {
        return this.ksB;
    }

    public h cPg() {
        return null;
    }

    public PersonPolymericModel cPh() {
        return this.ksw;
    }

    public e cPi() {
        return this.ksv;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.ksv.cew();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.ksv.y(false, -1);
            this.ksv.sY(true);
            this.ksw.fi(this.mUserId);
            this.ksw.v(this.mUserId, this.mPortrait);
        } else {
            this.ksv.hideLoadingView();
            this.ksv.Bu(8);
            this.ksv.aG(this.ksu.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.ksv.cew();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.ksw.v(this.mUserId, this.mPortrait);
        } else {
            this.ksv.hideLoadingView();
            l.showToast(this.dIF.getContext(), this.dIF.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.ksv.brO();
            this.ksv.ej(arrayList);
            this.ksv.cPd();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a sZ(boolean z) {
        if (z) {
            this.ksC = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.ksw.v(this.mUserId, this.mPortrait);
            }
        }
        return this.ksw.cPU();
    }

    public void cPj() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cPk());
                }
            }
        });
    }

    public List<o> cPk() {
        if (this.ksw.cPU() == null) {
            return null;
        }
        return this.ksw.cPU().cPk();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.ksv.hideLoadingView();
        if (this.ksB != null) {
            this.ksB.d(aVar);
        }
        if (aVar != null) {
            this.ksv.b(aVar);
        }
        if (this.ksz != null) {
            this.ksz.d(aVar);
        } else {
            this.ksz = new j(this.ksu, this, this.mPageId, this.mUserId, this.mIsHost);
            this.ksz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.ksz.a(this.ksA);
            this.ksz.d(aVar);
        }
        if (this.ksC && aVar != null && aVar.ktF != null && aVar.ktF.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.ktF.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.gRG).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hGH == null) {
            this.hGH = new com.baidu.tieba.c.g(this.gRG.getPageContext(), (NavigationBarCoverTip) this.gRG.findViewById(R.id.navigation_cover_tip));
        }
        this.hGH.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ksz != null) {
                this.ksz.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ksF);
        if (this.ksz != null) {
            this.ksz.onDestroy();
        }
        if (this.ksw != null) {
            this.ksw.destroy();
        }
    }

    public void bB(boolean z) {
        if (this.ksz != null) {
            this.ksz.bB(z);
        }
    }

    public void onResume() {
        if (this.ksz != null) {
            this.ksz.onResume();
        }
    }
}
