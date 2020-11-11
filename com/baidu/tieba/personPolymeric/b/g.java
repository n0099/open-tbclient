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
/* loaded from: classes24.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext eIc;
    private final BaseFragmentActivity ilu;
    private com.baidu.tieba.c.h jcL;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;
    private BaseFragment mbZ;
    private f mca;
    private final PersonPolymericModel mcb;
    private final d mcc;
    private final BlackListModel mcd;
    private k mce;
    private com.baidu.tieba.personPolymeric.event.c mcf;
    private h mcg;
    private boolean mch;
    private boolean mci;
    private final f.b mcj;
    private CustomMessageListener mck;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.mch = false;
        this.mcj = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dy(View view2) {
                g.this.loadData();
            }
        };
        this.mck = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.mbZ = baseFragment;
        this.ilu = this.mbZ.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.mci = z2;
        this.eIc = this.ilu.getPageContext();
        MessageManager.getInstance().registerListener(this.mck);
        this.mcc = new d(this.mbZ.getPageContext(), bdUniqueId);
        this.mca = new f(this.mbZ.getPageContext(), view, z);
        this.mca.a(this.mcj);
        this.mcf = new com.baidu.tieba.personPolymeric.event.c(this.eIc, this);
        this.mcb = new PersonPolymericModel(this.ilu, bdUniqueId, z);
        this.mcb.e(new p(z));
        this.mcb.a(this);
        this.mcb.a(this.mcc);
        this.mcd = new BlackListModel(this.ilu.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.mce = new k(this.mbZ, this, this.mPageId, this.mUserId, z);
            this.mce.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mce.a(this.mcf);
        }
        this.mcg = new h(this.eIc, this.mcc, this.mcd, bdUniqueId);
        loadData();
    }

    public b dvm() {
        return this.mce;
    }

    public h dvn() {
        return this.mcg;
    }

    public i dvo() {
        return null;
    }

    public PersonPolymericModel dvp() {
        return this.mcb;
    }

    public f dvq() {
        return this.mca;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mca.cIC();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.personPolymeric.b.dvd().gO(System.currentTimeMillis());
            this.mca.D(false, -1);
            this.mca.vT(true);
            this.mcb.gQ(this.mUserId);
            this.mcb.y(this.mUserId, this.mPortrait);
        } else {
            this.mca.hideLoadingView();
            this.mca.He(8);
            this.mca.aQ(this.mbZ.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.mca.cIC();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.mcb.y(this.mUserId, this.mPortrait);
        } else {
            this.mca.hideLoadingView();
            l.showToast(this.eIc.getContext(), this.eIc.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.mca.bPW();
            this.mca.fn(arrayList);
            this.mca.dvl();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a vU(boolean z) {
        if (z) {
            this.mch = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.mcb.y(this.mUserId, this.mPortrait);
            }
        }
        return this.mcb.dwi();
    }

    public void dvr() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dvs());
                }
            }
        });
    }

    public List<q> dvs() {
        if (this.mcb.dwi() == null) {
            return null;
        }
        return this.mcb.dwi().dvs();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mca.hideLoadingView();
        if (this.mcg != null) {
            this.mcg.d(aVar);
        }
        if (aVar != null) {
            this.mca.b(aVar);
        }
        if (this.mce != null) {
            this.mce.d(aVar);
        } else {
            this.mce = new k(this.mbZ, this, this.mPageId, this.mUserId, this.mIsHost);
            this.mce.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mce.a(this.mcf);
            this.mce.d(aVar);
        }
        if (this.mch && aVar != null && aVar.mdi != null && aVar.mdi.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.mdi.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.ilu).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jcL == null) {
            this.jcL = new com.baidu.tieba.c.h(this.ilu.getPageContext(), (NavigationBarCoverTip) this.ilu.findViewById(R.id.navigation_cover_tip));
        }
        this.jcL.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mce != null) {
                this.mce.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mck);
        if (this.mce != null) {
            this.mce.onDestroy();
        }
        if (this.mcb != null) {
            this.mcb.destroy();
        }
    }

    public void bQ(boolean z) {
        if (this.mce != null) {
            this.mce.bQ(z);
        }
    }

    public void onResume() {
        if (this.mce != null) {
            this.mce.onResume();
        }
    }
}
