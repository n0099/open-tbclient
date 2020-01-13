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
/* loaded from: classes9.dex */
public class f extends d implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext cRe;
    private com.baidu.tieba.c.g gEv;
    private final BaseFragmentActivity gpB;
    private boolean jmA;
    private boolean jmB;
    private final e.b jmC;
    private CustomMessageListener jmD;
    private BaseFragment jms;
    private e jmt;
    private final PersonPolymericModel jmu;
    private final c jmv;
    private final BlackListModel jmw;
    private j jmx;
    private com.baidu.tieba.personPolymeric.event.c jmy;
    private g jmz;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private int mSkinType;
    private final long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        super(z);
        this.mSkinType = 3;
        this.jmA = false;
        this.jmC = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cI(View view2) {
                f.this.loadData();
            }
        };
        this.jmD = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jms = baseFragment;
        this.gpB = this.jms.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.jmB = z2;
        this.cRe = this.gpB.getPageContext();
        MessageManager.getInstance().registerListener(this.jmD);
        this.jmv = new c(this.jms.getPageContext(), bdUniqueId);
        this.jmt = new e(this.jms.getPageContext(), view, z);
        this.jmt.a(this.jmC);
        this.jmy = new com.baidu.tieba.personPolymeric.event.c(this.cRe, this);
        this.jmu = new PersonPolymericModel(this.gpB, bdUniqueId, z);
        this.jmu.e(new p(z));
        this.jmu.a(this);
        this.jmu.a(this.jmv);
        this.jmw = new BlackListModel(this.gpB.getPageContext(), bdUniqueId);
        this.jmx = new j(this.jms, this, this.mPageId, this.mUserId, z);
        this.jmx.rp(this.jmB);
        this.jmx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jmx.a(this.jmy);
        this.jmz = new g(this.cRe, this.jmv, this.jmw, bdUniqueId);
        loadData();
    }

    public a cvp() {
        return this.jmx;
    }

    public g cvq() {
        return this.jmz;
    }

    public h cvr() {
        return null;
    }

    public PersonPolymericModel cvs() {
        return this.jmu;
    }

    public e cvt() {
        return this.jmt;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jmt.bLw();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jmt.t(false, -1);
            this.jmt.rm(true);
            this.jmu.ex(this.mUserId);
            this.jmu.ew(this.mUserId);
        } else {
            this.jmt.hideLoadingView();
            this.jmt.zR(8);
            this.jmt.an(this.jms.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jmt.bLw();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jmu.ew(this.mUserId);
        } else {
            this.jmt.hideLoadingView();
            l.showToast(this.cRe.getContext(), this.cRe.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jmt.bbc();
            this.jmt.dU(arrayList);
            this.jmt.cvo();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a rn(boolean z) {
        if (z) {
            this.jmA = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jmu.ew(this.mUserId);
            }
        }
        return this.jmu.cwd();
    }

    public void cvu() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.p(str2, f.this.cvv());
                }
            }
        });
    }

    public List<m> cvv() {
        if (this.jmu.cwd() == null) {
            return null;
        }
        return this.jmu.cwd().cvv();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.jmt.hideLoadingView();
        if (this.jmz != null) {
            this.jmz.d(aVar);
        }
        if (aVar != null) {
            this.jmt.b(aVar);
        }
        if (this.jmx != null) {
            this.jmx.d(aVar);
        }
        if (this.jmA && aVar != null && aVar.jnC != null && aVar.jnC.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.jnC.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.gpB).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gEv == null) {
            this.gEv = new com.baidu.tieba.c.g(this.gpB.getPageContext(), (NavigationBarCoverTip) this.gpB.findViewById(R.id.navigation_cover_tip));
        }
        this.gEv.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jmx != null) {
                this.jmx.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public boolean onBackPressed() {
        if (this.jmx != null) {
            return this.jmx.onBackPressed();
        }
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jmD);
        if (this.jmx != null) {
            this.jmx.onDestroy();
        }
        if (this.jmu != null) {
            this.jmu.destroy();
        }
    }

    public void lg(boolean z) {
        if (this.jmx != null) {
            this.jmx.lg(z);
        }
    }

    public void onResume() {
        if (this.jmx != null) {
            this.jmx.onResume();
        }
    }
}
