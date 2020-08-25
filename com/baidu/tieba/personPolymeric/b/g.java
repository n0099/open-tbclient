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
/* loaded from: classes18.dex */
public class g extends e implements com.baidu.tieba.personPolymeric.mode.b {
    private TbPageContext efn;
    private final BaseFragmentActivity hwQ;
    private com.baidu.tieba.c.h iod;
    private BaseFragment llk;
    private f lll;
    private final PersonPolymericModel llm;
    private final d lln;
    private final BlackListModel llo;
    private k llp;
    private com.baidu.tieba.personPolymeric.event.c llq;
    private h llr;
    private boolean lls;
    private boolean llt;
    private final f.b llu;
    private CustomMessageListener llv;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public g(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.lls = false;
        this.llu = new f.b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
            @Override // com.baidu.tieba.personPolymeric.b.f.b
            public void dd(View view2) {
                g.this.loadData();
            }
        };
        this.llv = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.refreshData();
            }
        };
        this.llk = baseFragment;
        this.hwQ = this.llk.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.llt = z2;
        this.efn = this.hwQ.getPageContext();
        MessageManager.getInstance().registerListener(this.llv);
        this.lln = new d(this.llk.getPageContext(), bdUniqueId);
        this.lll = new f(this.llk.getPageContext(), view, z);
        this.lll.a(this.llu);
        this.llq = new com.baidu.tieba.personPolymeric.event.c(this.efn, this);
        this.llm = new PersonPolymericModel(this.hwQ, bdUniqueId, z);
        this.llm.e(new p(z));
        this.llm.a(this);
        this.llm.a(this.lln);
        this.llo = new BlackListModel(this.hwQ.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.llp = new k(this.llk, this, this.mPageId, this.mUserId, z);
            this.llp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.llp.a(this.llq);
        }
        this.llr = new h(this.efn, this.lln, this.llo, bdUniqueId);
        loadData();
    }

    public b dil() {
        return this.llp;
    }

    public h dim() {
        return this.llr;
    }

    public i din() {
        return null;
    }

    public PersonPolymericModel dio() {
        return this.llm;
    }

    public f dip() {
        return this.lll;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.lll.cwc();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lll.A(false, -1);
            this.lll.uC(true);
            this.llm.fL(this.mUserId);
            this.llm.w(this.mUserId, this.mPortrait);
        } else {
            this.lll.hideLoadingView();
            this.lll.Fr(8);
            this.lll.aK(this.llk.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.lll.cwc();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.llm.w(this.mUserId, this.mPortrait);
        } else {
            this.lll.hideLoadingView();
            l.showToast(this.efn.getContext(), this.efn.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.lll.bGT();
            this.lll.eL(arrayList);
            this.lll.dik();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a uD(boolean z) {
        if (z) {
            this.lls = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.llm.w(this.mUserId, this.mPortrait);
            }
        }
        return this.llm.djf();
    }

    public void diq() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    j.p(str2, g.this.dir());
                }
            }
        });
    }

    public List<q> dir() {
        if (this.llm.djf() == null) {
            return null;
        }
        return this.llm.djf().dir();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.lll.hideLoadingView();
        if (this.llr != null) {
            this.llr.d(aVar);
        }
        if (aVar != null) {
            this.lll.b(aVar);
        }
        if (this.llp != null) {
            this.llp.d(aVar);
        } else {
            this.llp = new k(this.llk, this, this.mPageId, this.mUserId, this.mIsHost);
            this.llp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.llp.a(this.llq);
            this.llp.d(aVar);
        }
        if (this.lls && aVar != null && aVar.lmt != null && aVar.lmt.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.lmt.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.hwQ).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.iod == null) {
            this.iod = new com.baidu.tieba.c.h(this.hwQ.getPageContext(), (NavigationBarCoverTip) this.hwQ.findViewById(R.id.navigation_cover_tip));
        }
        this.iod.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.llp != null) {
                this.llp.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.llv);
        if (this.llp != null) {
            this.llp.onDestroy();
        }
        if (this.llm != null) {
            this.llm.destroy();
        }
    }

    public void bJ(boolean z) {
        if (this.llp != null) {
            this.llp.bJ(z);
        }
    }

    public void onResume() {
        if (this.llp != null) {
            this.llp.onResume();
        }
    }
}
