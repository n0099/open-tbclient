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
    private TbPageContext cVh;
    private com.baidu.tieba.c.g gGw;
    private final BaseFragmentActivity grE;
    private boolean jnA;
    private boolean jnB;
    private final e.b jnC;
    private CustomMessageListener jnD;
    private BaseFragment jns;
    private e jnt;
    private final PersonPolymericModel jnu;
    private final c jnv;
    private final BlackListModel jnw;
    private j jnx;
    private com.baidu.tieba.personPolymeric.event.c jny;
    private g jnz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.jnA = false;
        this.jnC = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cJ(View view2) {
                f.this.loadData();
            }
        };
        this.jnD = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jns = baseFragment;
        this.grE = this.jns.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.jnB = z2;
        this.cVh = this.grE.getPageContext();
        MessageManager.getInstance().registerListener(this.jnD);
        this.jnv = new c(this.jns.getPageContext(), bdUniqueId);
        this.jnt = new e(this.jns.getPageContext(), view, z);
        this.jnt.a(this.jnC);
        this.jny = new com.baidu.tieba.personPolymeric.event.c(this.cVh, this);
        this.jnu = new PersonPolymericModel(this.grE, bdUniqueId, z);
        this.jnu.e(new p(z));
        this.jnu.a(this);
        this.jnu.a(this.jnv);
        this.jnw = new BlackListModel(this.grE.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.jnx = new j(this.jns, this, this.mPageId, this.mUserId, z);
            this.jnx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jnx.a(this.jny);
        }
        this.jnz = new g(this.cVh, this.jnv, this.jnw, bdUniqueId);
        loadData();
    }

    public a cwM() {
        return this.jnx;
    }

    public g cwN() {
        return this.jnz;
    }

    public h cwO() {
        return null;
    }

    public PersonPolymericModel cwP() {
        return this.jnu;
    }

    public e cwQ() {
        return this.jnt;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jnt.bNb();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jnt.u(false, -1);
            this.jnt.rq(true);
            this.jnu.eu(this.mUserId);
            this.jnu.t(this.mUserId, this.mPortrait);
        } else {
            this.jnt.hideLoadingView();
            this.jnt.zY(8);
            this.jnt.an(this.jns.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jnt.bNb();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jnu.t(this.mUserId, this.mPortrait);
        } else {
            this.jnt.hideLoadingView();
            l.showToast(this.cVh.getContext(), this.cVh.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jnt.bdt();
            this.jnt.dQ(arrayList);
            this.jnt.cwL();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a rr(boolean z) {
        if (z) {
            this.jnA = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jnu.t(this.mUserId, this.mPortrait);
            }
        }
        return this.jnu.cxD();
    }

    public void cwR() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cwS());
                }
            }
        });
    }

    public List<m> cwS() {
        if (this.jnu.cxD() == null) {
            return null;
        }
        return this.jnu.cxD().cwS();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.jnt.hideLoadingView();
        if (this.jnz != null) {
            this.jnz.d(aVar);
        }
        if (aVar != null) {
            this.jnt.b(aVar);
        }
        if (this.jnx != null) {
            this.jnx.d(aVar);
        } else {
            this.jnx = new j(this.jns, this, this.mPageId, this.mUserId, this.mIsHost);
            this.jnx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jnx.a(this.jny);
            this.jnx.d(aVar);
        }
        if (this.jnA && aVar != null && aVar.joD != null && aVar.joD.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.joD.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.grE).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gGw == null) {
            this.gGw = new com.baidu.tieba.c.g(this.grE.getPageContext(), (NavigationBarCoverTip) this.grE.findViewById(R.id.navigation_cover_tip));
        }
        this.gGw.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jnx != null) {
                this.jnx.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jnD);
        if (this.jnx != null) {
            this.jnx.onDestroy();
        }
        if (this.jnu != null) {
            this.jnu.destroy();
        }
    }

    public void onPrimary(boolean z) {
        if (this.jnx != null) {
            this.jnx.onPrimary(z);
        }
    }

    public void onResume() {
        if (this.jnx != null) {
            this.jnx.onResume();
        }
    }
}
