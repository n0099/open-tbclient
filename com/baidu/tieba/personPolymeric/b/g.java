package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes7.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext eSJ;
    private final BaseFragmentActivity iEK;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;
    private BaseFragment mrg;
    private f mrh;
    private final PersonPolymericModel mri;
    private final d mrj;
    private final BlackListModel mrk;
    private k mrl;
    private com.baidu.tieba.c.h mrm;
    private com.baidu.tieba.personPolymeric.event.c mrn;
    private h mro;
    private boolean mrp;
    private boolean mrq;
    private final f.b mrr;
    private CustomMessageListener mrs;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mrp = false;
        this.mrr = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dX(View view2) {
                g.this.loadData();
            }
        };
        this.mrs = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mrg = baseFragment;
        this.iEK = this.mrg.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mrq = z2;
        this.eSJ = this.iEK.getPageContext();
        MessageManager.getInstance().registerListener(this.mrs);
        this.mrj = new d(this.mrg.getPageContext(), bdUniqueId);
        this.mrh = new f(this.mrg.getPageContext(), view, z);
        this.mrh.a(this.mrr);
        this.mrn = new com.baidu.tieba.personPolymeric.event.c(this.eSJ, this);
        this.mri = new PersonPolymericModel(this.iEK, bdUniqueId, z);
        this.mri.e(new p(z));
        this.mri.a(this);
        this.mri.a(this.mrj);
        this.mrk = new BlackListModel(this.iEK.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mrl = new k(this.mrg, this, this.mPageId, this.mUserId, z);
            this.mrl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mrl.a(this.mrn);
        }
        this.mro = new h(this.eSJ, this.mrj, this.mrk, bdUniqueId);
        loadData();
    }

    public b dwd() {
        return this.mrl;
    }

    public h dwe() {
        return this.mro;
    }

    public i dwf() {
        return null;
    }

    public PersonPolymericModel dwg() {
        return this.mri;
    }

    public f dwh() {
        return this.mrh;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mrh.cMM();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dvU().hr(System.currentTimeMillis());
            this.mrh.C(false, -1);
            this.mrh.wx(true);
            this.mri.ht(this.mUserId);
            this.mri.z(this.mUserId, this.mPortrait);
        } else {
            this.mrh.hideLoadingView();
            this.mrh.GG(8);
            this.mrh.aR(this.mrg.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mrh.cMM();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mri.z(this.mUserId, this.mPortrait);
        } else {
            this.mrh.hideLoadingView();
            l.showToast(this.eSJ.getContext(), this.eSJ.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mrh.bRO();
            this.mrh.fz(arrayList);
            this.mrh.dwc();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a wy(boolean z) {
        if (z) {
            this.mrp = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mri.z(this.mUserId, this.mPortrait);
            }
        }
        return this.mri.dwZ();
    }

    public void dwi() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dwj());
                }
            }
        });
    }

    public List<n> dwj() {
        if (this.mri.dwZ() == null) {
            return null;
        }
        return this.mri.dwZ().dwj();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mrh.hideLoadingView();
        if (this.mro != null) {
            this.mro.d(aVar);
        }
        if (aVar != null) {
            this.mrh.b(aVar);
        }
        if (this.mrl != null) {
            this.mrl.d(aVar);
        } else {
            this.mrl = new k(this.mrg, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mrl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mrl.a(this.mrn);
            this.mrl.d(aVar);
        }
        if (this.mrp && aVar != null && aVar.msr != null && aVar.msr.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.msr.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.iEK).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mrm == null) {
            this.mrm = new com.baidu.tieba.c.h(this.iEK.getPageContext(), (NavigationBarCoverTip) this.iEK.findViewById(R.id.navigation_cover_tip));
        }
        this.mrm.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mrl != null) {
                this.mrl.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mrs);
        if (this.mrl != null) {
            this.mrl.onDestroy();
        }
        if (this.mri != null) {
            this.mri.destroy();
        }
    }

    public void bW(boolean z) {
        if (this.mrl != null) {
            this.mrl.bW(z);
        }
    }

    public void onResume() {
        if (this.mrl != null) {
            this.mrl.onResume();
        }
    }
}
