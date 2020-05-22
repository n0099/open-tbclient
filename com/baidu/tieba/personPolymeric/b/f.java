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
    private final BaseFragmentActivity gRv;
    private com.baidu.tieba.c.g hFU;
    private BaseFragment kro;
    private e krp;
    private final PersonPolymericModel krq;
    private final c krr;
    private final BlackListModel krs;
    private j krt;
    private com.baidu.tieba.personPolymeric.event.c kru;
    private g krv;
    private boolean krw;
    private boolean krx;
    private final e.b kry;
    private CustomMessageListener krz;
    private final BdUniqueId mPageId;
    private String mPortrait;
    public final View mRootView;
    private int mSkinType;
    private long mUserId;

    public f(BaseFragment baseFragment, View view, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        this.mSkinType = 3;
        this.krw = false;
        this.kry = new e.b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
            @Override // com.baidu.tieba.personPolymeric.b.e.b
            public void cS(View view2) {
                f.this.loadData();
            }
        };
        this.krz = new CustomMessageListener(2921424) { // from class: com.baidu.tieba.personPolymeric.b.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.refreshData();
            }
        };
        this.kro = baseFragment;
        this.gRv = this.kro.getBaseFragmentActivity();
        this.mRootView = view;
        this.mPageId = bdUniqueId;
        this.mUserId = j;
        this.mPortrait = str;
        this.krx = z2;
        this.dIF = this.gRv.getPageContext();
        MessageManager.getInstance().registerListener(this.krz);
        this.krr = new c(this.kro.getPageContext(), bdUniqueId);
        this.krp = new e(this.kro.getPageContext(), view, z);
        this.krp.a(this.kry);
        this.kru = new com.baidu.tieba.personPolymeric.event.c(this.dIF, this);
        this.krq = new PersonPolymericModel(this.gRv, bdUniqueId, z);
        this.krq.e(new p(z));
        this.krq.a(this);
        this.krq.a(this.krr);
        this.krs = new BlackListModel(this.gRv.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.mPortrait)) {
            this.krt = new j(this.kro, this, this.mPageId, this.mUserId, z);
            this.krt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.krt.a(this.kru);
        }
        this.krv = new g(this.dIF, this.krr, this.krs, bdUniqueId);
        loadData();
    }

    public a cOO() {
        return this.krt;
    }

    public g cOP() {
        return this.krv;
    }

    public h cOQ() {
        return null;
    }

    public PersonPolymericModel cOR() {
        return this.krq;
    }

    public e cOS() {
        return this.krp;
    }

    public void loadData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.krp.ceo();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.krp.y(false, -1);
            this.krp.sY(true);
            this.krq.fi(this.mUserId);
            this.krq.v(this.mUserId, this.mPortrait);
        } else {
            this.krp.hideLoadingView();
            this.krp.Bs(8);
            this.krp.aG(this.kro.getString(R.string.neterror), true);
        }
    }

    public void refreshData() {
        if (!TbadkCoreApplication.isLogin() && this.mIsHost) {
            this.krp.ceo();
        } else if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.krq.v(this.mUserId, this.mPortrait);
        } else {
            this.krp.hideLoadingView();
            l.showToast(this.dIF.getContext(), this.dIF.getString(R.string.data_load_error));
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
            iVar.isHost = this.mIsHost;
            arrayList.add(iVar);
            this.krp.brM();
            this.krp.eh(arrayList);
            this.krp.cON();
        }
    }

    public com.baidu.tieba.personPolymeric.c.a sZ(boolean z) {
        if (z) {
            this.krw = z;
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.krq.v(this.mUserId, this.mPortrait);
            }
        }
        return this.krq.cPE();
    }

    public void cOT() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    i.q(str2, f.this.cOU());
                }
            }
        });
    }

    public List<o> cOU() {
        if (this.krq.cPE() == null) {
            return null;
        }
        return this.krq.cPE().cOU();
    }

    @Override // com.baidu.tieba.personPolymeric.mode.b
    public void c(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null && !StringUtils.isNull(this.mPortrait)) {
            this.mUserId = aVar.getUserData().getUserIdLong();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.mUserId)));
            this.mIsHost = this.mUserId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.krp.hideLoadingView();
        if (this.krv != null) {
            this.krv.d(aVar);
        }
        if (aVar != null) {
            this.krp.b(aVar);
        }
        if (this.krt != null) {
            this.krt.d(aVar);
        } else {
            this.krt = new j(this.kro, this, this.mPageId, this.mUserId, this.mIsHost);
            this.krt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.krt.a(this.kru);
            this.krt.d(aVar);
        }
        if (this.krw && aVar != null && aVar.ksz != null && aVar.ksz.left_days != null && aVar.getUserData() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            personChangeData.setMem(aVar.getUserData().getIsMem());
            personChangeData.setNickNameLeftDays(aVar.ksz.left_days.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER, personChangeData));
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.gRv).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hFU == null) {
            this.hFU = new com.baidu.tieba.c.g(this.gRv.getPageContext(), (NavigationBarCoverTip) this.gRv.findViewById(R.id.navigation_cover_tip));
        }
        this.hFU.b(postWriteCallBackData);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.krt != null) {
                this.krt.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.krz);
        if (this.krt != null) {
            this.krt.onDestroy();
        }
        if (this.krq != null) {
            this.krq.destroy();
        }
    }

    public void bB(boolean z) {
        if (this.krt != null) {
            this.krt.bB(z);
        }
    }

    public void onResume() {
        if (this.krt != null) {
            this.krt.onResume();
        }
    }
}
