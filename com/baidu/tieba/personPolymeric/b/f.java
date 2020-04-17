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
    private TbPageContext duG;
    private final BaseFragmentActivity gCG;
    private com.baidu.tieba.c.g hqZ;
    private boolean jZA;
    private final e.b jZB;
    private CustomMessageListener jZC;
    private BaseFragment jZr;
    private e jZs;
    private final PersonPolymericModel jZt;
    private final c jZu;
    private final BlackListModel jZv;
    private j jZw;
    private com.baidu.tieba.personPolymeric.event.c jZx;
    private g jZy;
    private boolean jZz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.jZz = false;
        this.jZB = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cR(View view2) {
                f.this.loadData();
            }
        };
        this.jZC = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.jZr = baseFragment;
        this.gCG = this.jZr.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.jZA = z2;
        this.duG = this.gCG.getPageContext();
        MessageManager.getInstance().registerListener(this.jZC);
        this.jZu = new c(this.jZr.getPageContext(), bdUniqueId);
        this.jZs = new e(this.jZr.getPageContext(), view, z);
        this.jZs.a(this.jZB);
        this.jZx = new com.baidu.tieba.personPolymeric.event.c(this.duG, this);
        this.jZt = new PersonPolymericModel(this.gCG, bdUniqueId, z);
        this.jZt.e(new p(z));
        this.jZt.a(this);
        this.jZt.a(this.jZu);
        this.jZv = new BlackListModel(this.gCG.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.jZw = new j(this.jZr, this, this.mPageId, this.mUserId, z);
            this.jZw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jZw.a(this.jZx);
        }
        this.jZy = new g(this.duG, this.jZu, this.jZv, bdUniqueId);
        loadData();
    }

    public a cHR() {
        return this.jZw;
    }

    public g cHS() {
        return this.jZy;
    }

    public h cHT() {
        return null;
    }

    public PersonPolymericModel cHU() {
        return this.jZt;
    }

    public e cHV() {
        return this.jZs;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jZs.bXR();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jZs.v(false, -1);
            this.jZs.sA(true);
            this.jZt.fh(this.mUserId);
            this.jZt.v(this.mUserId, this.mPortrait);
        } else {
            this.jZs.hideLoadingView();
            this.jZs.AH(8);
            this.jZs.at(this.jZr.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.jZs.bXR();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jZt.v(this.mUserId, this.mPortrait);
        } else {
            this.jZs.hideLoadingView();
            l.showToast(this.duG.getContext(), this.duG.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.jZs.bmq();
            this.jZs.eb(arrayList);
            this.jZs.cHQ();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a sB(boolean z) {
        if (z) {
            this.jZz = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.jZt.v(this.mUserId, this.mPortrait);
            }
        }
        return this.jZt.cIH();
    }

    public void cHW() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cHX());
                }
            }
        });
    }

    public List<m> cHX() {
        if (this.jZt.cIH() == null) {
            return null;
        }
        return this.jZt.cIH().cHX();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.jZs.hideLoadingView();
        if (this.jZy != null) {
            this.jZy.d(aVar);
        }
        if (aVar != null) {
            this.jZs.b(aVar);
        }
        if (this.jZw != null) {
            this.jZw.d(aVar);
        } else {
            this.jZw = new j(this.jZr, this, this.mPageId, this.mUserId, this.mIsHost);
            this.jZw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.jZw.a(this.jZx);
            this.jZw.d(aVar);
        }
        if (this.jZz && aVar != null && aVar.kaD != null && aVar.kaD.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.kaD.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.gCG).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hqZ == null) {
            this.hqZ = new com.baidu.tieba.c.g(this.gCG.getPageContext(), (NavigationBarCoverTip) this.gCG.findViewById(R.id.navigation_cover_tip));
        }
        this.hqZ.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jZw != null) {
                this.jZw.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jZC);
        if (this.jZw != null) {
            this.jZw.onDestroy();
        }
        if (this.jZt != null) {
            this.jZt.destroy();
        }
    }

    public void jb(boolean z) {
        if (this.jZw != null) {
            this.jZw.jb(z);
        }
    }

    public void onResume() {
        if (this.jZw != null) {
            this.jZw.onResume();
        }
    }
}
