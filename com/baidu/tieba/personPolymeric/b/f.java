package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes11.dex */
public class f extends d implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext cVg;
    private com.baidu.tieba.c.g gGu;
    private final BaseFragmentActivity grC;
    private final e.b jnA;
    private CustomMessageListener jnB;
    private BaseFragment jnq;
    private e jnr;
    private final PersonPolymericModel jns;
    private final c jnt;
    private final BlackListModel jnu;
    private j jnv;
    private com.baidu.tieba.personPolymeric.event.c jnw;
    private g jnx;
    private boolean jny;
    private boolean jnz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.jny = false;
        this.jnA = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cJ(View view2) {
                f.this.loadData();
            }
        };
        this.jnB = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jnq = baseFragment;
        this.grC = this.jnq.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.jnz = z2;
        this.cVg = this.grC.getPageContext();
        MessageManager.getInstance().registerListener(this.jnB);
        this.jnt = new c(this.jnq.getPageContext(), bdUniqueId);
        this.jnr = new e(this.jnq.getPageContext(), view, z);
        this.jnr.a(this.jnA);
        this.jnw = new com.baidu.tieba.personPolymeric.event.c(this.cVg, this);
        this.jns = new PersonPolymericModel(this.grC, bdUniqueId, z);
        this.jns.e(new p(z));
        this.jns.a(this);
        this.jns.a(this.jnt);
        this.jnu = new BlackListModel(this.grC.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.jnv = new j(this.jnq, this, this.mPageId, this.mUserId, z);
            this.jnv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jnv.a(this.jnw);
        }
        this.jnx = new g(this.cVg, this.jnt, this.jnu, bdUniqueId);
        loadData();
    }

    public a cwK() {
        return this.jnv;
    }

    public g cwL() {
        return this.jnx;
    }

    public h cwM() {
        return null;
    }

    public PersonPolymericModel cwN() {
        return this.jns;
    }

    public e cwO() {
        return this.jnr;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jnr.bMZ();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jnr.u(false, -1);
            this.jnr.rq(true);
            this.jns.eu(this.mUserId);
            this.jns.t(this.mUserId, this.mPortrait);
        } else {
            this.jnr.hideLoadingView();
            this.jnr.zY(8);
            this.jnr.an(this.jnq.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jnr.bMZ();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jns.t(this.mUserId, this.mPortrait);
        } else {
            this.jnr.hideLoadingView();
            l.showToast(this.cVg.getContext(), this.cVg.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jnr.bdr();
            this.jnr.dQ(arrayList);
            this.jnr.cwJ();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a rr(boolean z) {
        if (z) {
            this.jny = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jns.t(this.mUserId, this.mPortrait);
            }
        }
        return this.jns.cxB();
    }

    public void cwP() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cwQ());
                }
            }
        });
    }

    public List<m> cwQ() {
        if (this.jns.cxB() == null) {
            return null;
        }
        return this.jns.cxB().cwQ();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.jnr.hideLoadingView();
        if (this.jnx != null) {
            this.jnx.d(aVar);
        }
        if (aVar != null) {
            this.jnr.b(aVar);
        }
        if (this.jnv != null) {
            this.jnv.d(aVar);
        } else {
            this.jnv = new j(this.jnq, this, this.mPageId, this.mUserId, this.mIsHost);
            this.jnv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jnv.a(this.jnw);
            this.jnv.d(aVar);
        }
        if (this.jny && aVar != null && aVar.joB != null && aVar.joB.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.joB.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.grC).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gGu == null) {
            this.gGu = new com.baidu.tieba.c.g(this.grC.getPageContext(), (NavigationBarCoverTip) this.grC.findViewById(R.id.navigation_cover_tip));
        }
        this.gGu.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jnv != null) {
                this.jnv.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jnB);
        if (this.jnv != null) {
            this.jnv.onDestroy();
        }
        if (this.jns != null) {
            this.jns.destroy();
        }
    }

    public void onPrimary(boolean z) {
        if (this.jnv != null) {
            this.jnv.onPrimary(z);
        }
    }

    public void onResume() {
        if (this.jnv != null) {
            this.jnv.onResume();
        }
    }
}
