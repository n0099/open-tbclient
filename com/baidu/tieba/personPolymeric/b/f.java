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
    private TbPageContext cVv;
    private com.baidu.tieba.c.g gHG;
    private final BaseFragmentActivity gsB;
    private BaseFragment jpd;
    private e jpe;
    private final PersonPolymericModel jpf;
    private final c jpg;
    private final BlackListModel jph;
    private j jpi;
    private com.baidu.tieba.personPolymeric.event.c jpj;
    private g jpk;
    private boolean jpl;
    private boolean jpm;
    private final e.b jpn;
    private CustomMessageListener jpo;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.jpl = false;
        this.jpn = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cJ(View view2) {
                f.this.loadData();
            }
        };
        this.jpo = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jpd = baseFragment;
        this.gsB = this.jpd.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.jpm = z2;
        this.cVv = this.gsB.getPageContext();
        MessageManager.getInstance().registerListener(this.jpo);
        this.jpg = new c(this.jpd.getPageContext(), bdUniqueId);
        this.jpe = new e(this.jpd.getPageContext(), view, z);
        this.jpe.a(this.jpn);
        this.jpj = new com.baidu.tieba.personPolymeric.event.c(this.cVv, this);
        this.jpf = new PersonPolymericModel(this.gsB, bdUniqueId, z);
        this.jpf.e(new p(z));
        this.jpf.a(this);
        this.jpf.a(this.jpg);
        this.jph = new BlackListModel(this.gsB.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.jpi = new j(this.jpd, this, this.mPageId, this.mUserId, z);
            this.jpi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jpi.a(this.jpj);
        }
        this.jpk = new g(this.cVv, this.jpg, this.jph, bdUniqueId);
        loadData();
    }

    public a cxg() {
        return this.jpi;
    }

    public g cxh() {
        return this.jpk;
    }

    public h cxi() {
        return null;
    }

    public PersonPolymericModel cxj() {
        return this.jpf;
    }

    public e cxk() {
        return this.jpe;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jpe.bNq();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jpe.u(false, -1);
            this.jpe.rw(true);
            this.jpf.ev(this.mUserId);
            this.jpf.t(this.mUserId, this.mPortrait);
        } else {
            this.jpe.hideLoadingView();
            this.jpe.Ag(8);
            this.jpe.an(this.jpd.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jpe.bNq();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jpf.t(this.mUserId, this.mPortrait);
        } else {
            this.jpe.hideLoadingView();
            l.showToast(this.cVv.getContext(), this.cVv.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jpe.bdz();
            this.jpe.dQ(arrayList);
            this.jpe.cxf();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a rx(boolean z) {
        if (z) {
            this.jpl = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jpf.t(this.mUserId, this.mPortrait);
            }
        }
        return this.jpf.cxX();
    }

    public void cxl() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cxm());
                }
            }
        });
    }

    public List<m> cxm() {
        if (this.jpf.cxX() == null) {
            return null;
        }
        return this.jpf.cxX().cxm();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.jpe.hideLoadingView();
        if (this.jpk != null) {
            this.jpk.d(aVar);
        }
        if (aVar != null) {
            this.jpe.b(aVar);
        }
        if (this.jpi != null) {
            this.jpi.d(aVar);
        } else {
            this.jpi = new j(this.jpd, this, this.mPageId, this.mUserId, this.mIsHost);
            this.jpi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jpi.a(this.jpj);
            this.jpi.d(aVar);
        }
        if (this.jpl && aVar != null && aVar.jqo != null && aVar.jqo.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.jqo.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.gsB).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gHG == null) {
            this.gHG = new com.baidu.tieba.c.g(this.gsB.getPageContext(), (NavigationBarCoverTip) this.gsB.findViewById(R.id.navigation_cover_tip));
        }
        this.gHG.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jpi != null) {
                this.jpi.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jpo);
        if (this.jpi != null) {
            this.jpi.onDestroy();
        }
        if (this.jpf != null) {
            this.jpf.destroy();
        }
    }

    public void onPrimary(boolean z) {
        if (this.jpi != null) {
            this.jpi.onPrimary(z);
        }
    }

    public void onResume() {
        if (this.jpi != null) {
            this.jpi.onResume();
        }
    }
}
