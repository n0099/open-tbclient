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
    private final c jmA;
    private final BlackListModel jmB;
    private j jmC;
    private com.baidu.tieba.personPolymeric.event.c jmD;
    private g jmE;
    private boolean jmF;
    private boolean jmG;
    private final e.b jmH;
    private CustomMessageListener jmI;
    private BaseFragment jmx;
    private e jmy;
    private final PersonPolymericModel jmz;
    private final BdUniqueId mPageId;
    public final View mRootView;
    private int mSkinType;
    private final long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        super(z);
        this.mSkinType = 3;
        this.jmF = false;
        this.jmH = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cI(View view2) {
                f.this.loadData();
            }
        };
        this.jmI = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jmx = baseFragment;
        this.gpB = this.jmx.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.jmG = z2;
        this.cRe = this.gpB.getPageContext();
        MessageManager.getInstance().registerListener(this.jmI);
        this.jmA = new c(this.jmx.getPageContext(), bdUniqueId);
        this.jmy = new e(this.jmx.getPageContext(), view, z);
        this.jmy.a(this.jmH);
        this.jmD = new com.baidu.tieba.personPolymeric.event.c(this.cRe, this);
        this.jmz = new PersonPolymericModel(this.gpB, bdUniqueId, z);
        this.jmz.e(new p(z));
        this.jmz.a(this);
        this.jmz.a(this.jmA);
        this.jmB = new BlackListModel(this.gpB.getPageContext(), bdUniqueId);
        this.jmC = new j(this.jmx, this, this.mPageId, this.mUserId, z);
        this.jmC.rp(this.jmG);
        this.jmC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jmC.a(this.jmD);
        this.jmE = new g(this.cRe, this.jmA, this.jmB, bdUniqueId);
        loadData();
    }

    public a cvr() {
        return this.jmC;
    }

    public g cvs() {
        return this.jmE;
    }

    public h cvt() {
        return null;
    }

    public PersonPolymericModel cvu() {
        return this.jmz;
    }

    public e cvv() {
        return this.jmy;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jmy.bLw();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jmy.t(false, -1);
            this.jmy.rm(true);
            this.jmz.ex(this.mUserId);
            this.jmz.ew(this.mUserId);
        } else {
            this.jmy.hideLoadingView();
            this.jmy.zR(8);
            this.jmy.an(this.jmx.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jmy.bLw();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jmz.ew(this.mUserId);
        } else {
            this.jmy.hideLoadingView();
            l.showToast(this.cRe.getContext(), this.cRe.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jmy.bbc();
            this.jmy.dU(arrayList);
            this.jmy.cvq();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a rn(boolean z) {
        if (z) {
            this.jmF = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jmz.ew(this.mUserId);
            }
        }
        return this.jmz.cwf();
    }

    public void cvw() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.p(str2, f.this.cvx());
                }
            }
        });
    }

    public List<m> cvx() {
        if (this.jmz.cwf() == null) {
            return null;
        }
        return this.jmz.cwf().cvx();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.jmy.hideLoadingView();
        if (this.jmE != null) {
            this.jmE.d(aVar);
        }
        if (aVar != null) {
            this.jmy.b(aVar);
        }
        if (this.jmC != null) {
            this.jmC.d(aVar);
        }
        if (this.jmF && aVar != null && aVar.jnH != null && aVar.jnH.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.jnH.left_days.intValue());
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
            if (this.jmC != null) {
                this.jmC.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public boolean onBackPressed() {
        if (this.jmC != null) {
            return this.jmC.onBackPressed();
        }
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jmI);
        if (this.jmC != null) {
            this.jmC.onDestroy();
        }
        if (this.jmz != null) {
            this.jmz.destroy();
        }
    }

    public void lg(boolean z) {
        if (this.jmC != null) {
            this.jmC.lg(z);
        }
    }

    public void onResume() {
        if (this.jmC != null) {
            this.jmC.onResume();
        }
    }
}
