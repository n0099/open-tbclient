package com.baidu.tieba.pb.chosen;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
import com.baidu.tieba.pb.chosen.net.b;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.tieba.pb.chosen.view.c;
import com.baidu.tieba.pb.chosen.view.d;
import com.baidu.tieba.pb.chosen.view.e;
import com.baidu.tieba.pb.chosen.view.f;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private NavigationBar bAs;
    private BdListView cWb;
    private RelativeLayout ceh;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager dBD;
    private DataModel<PbChosenActivity> eYB;
    private d fHE;
    private e fHF;
    private c fHG;
    private f fHH;
    private TextView fHI;
    private View fHJ;
    private com.baidu.tieba.pb.chosen.view.a fHK;
    private LikeModel fHL;
    private com.baidu.tieba.pb.chosen.net.zan.a fHM;
    private b fHN;
    private a fHO;
    private com.baidu.tbadk.editortools.pb.d fHP;
    private boolean fHQ;
    private long startTime;
    private String shareUrl = null;
    private boolean dnK = false;
    private boolean fpn = false;
    private int from = 1;
    private int fHR = -1;
    private final AbsListView.OnScrollListener mScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.fHP != null && PbChosenActivity.this.fHP.KT() != null) {
                PbChosenActivity.this.fHP.KT().hide();
                PbChosenActivity.this.fHH.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c aWB = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Lr() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener fHS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.fHP != null && PbChosenActivity.this.fHP.KT() != null) {
                PbChosenActivity.this.fHP.KT().pO();
                PbChosenActivity.this.fHH.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.fHP.KT().hide();
                PbChosenActivity.this.fHH.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && wVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                    AntiHelper.aG(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).AJ();
                }
            }
        }
    };
    private c.a fHT = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.view.c.a
        public void sf(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new am("c10093").ax("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").ax("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ax("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener fHU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new am("pb_new_share").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ax("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.fHO == null) {
                    PbChosenActivity.this.fHO = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.fHO.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener bRt = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener fHV = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a fHW = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void q(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.fHR)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new am("pb_new_detail_btn").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ax("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void kn(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.fHM == null) {
                    PbChosenActivity.this.fHM = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.fHM.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.fHM.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new am("pb_new_like").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ax("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b fHX = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void ch(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void se(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new am("pb_new_sourcefid").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ax("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void agx() {
            if (!j.kV()) {
                BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(e.j.neterror)).AJ();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.fHL == null) {
                    PbChosenActivity.this.fHL = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.fHL.setFrom("from_frs");
                PbChosenActivity.this.fHL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void m(Object obj) {
                        if (AntiHelper.ai(PbChosenActivity.this.fHL.getErrorCode(), PbChosenActivity.this.fHL.getErrorString())) {
                            AntiHelper.aG(PbChosenActivity.this.getActivity(), PbChosenActivity.this.fHL.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.fHL.cF(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new am("c10322").ax(ImageViewerConfig.FORUM_ID, PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").ax("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ax("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a aUc = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_FINE_PB, 309093) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.fpn = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.ceh);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(e.j.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.dnK) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.ceh, PbChosenActivity.this.getResources().getString(e.j.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.fHH.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener fHY = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.fHF.bek();
            PbChosenActivity.this.fHF.fIJ = !PbChosenActivity.this.fHF.fIJ;
            PbChosenActivity.this.fHF.kq(PbChosenActivity.this.fHF.fIJ);
            if (PbChosenActivity.this.fHF.fIJ) {
                PbChosenActivity.this.fHR = 1;
            } else {
                PbChosenActivity.this.fHR = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fHZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.fHF.bek();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).AJ();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.fHF.kq(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.fHR = 1;
                    } else {
                        PbChosenActivity.this.fHR = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener fIa = new CustomMessageListener(2001314) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.fpn = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.fHN == null) {
                    PbChosenActivity.this.fHN = new b();
                }
                PbChosenActivity.this.fHN.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.fHE.kp(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (getIntent() != null) {
            long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            long longExtra2 = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
            long longExtra3 = getIntent().getLongExtra("thread_id", 0L);
            if (this.fHN == null) {
                this.fHN = new b();
            }
            this.fHN.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.ceh);
            showLoadingView(this.ceh, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.ceh);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.ceh, getResources().getString(e.j.error_unkown_try_again), true);
            setNetRefreshLayoutMarginTop(false);
            this.fHH.setVisible(false);
            return;
        }
        this.dnK = true;
        this.fHH.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.fHE.a(userInfo);
        }
        if (this.fHG != null) {
            this.fHG.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.fHI != null && threadInfo.post_num != null) {
                String N = ao.N(threadInfo.post_num.longValue());
                this.fHI.setText(getResources().getString(e.j.chosen_pb_reply_number_text, N));
                this.fHH.sh(getResources().getString(e.j.chosen_pb_reply_count_text, N));
            }
            this.fHF.a(threadInfo);
            this.fHE.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.fHK.dg(aVar2.getData());
            this.fHK.notifyDataSetChanged();
        }
        this.cWb.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(e.h.chosen_pb_layout);
        this.ceh = (RelativeLayout) findViewById(e.g.chosen_pb_root);
        this.cWb = (BdListView) findViewById(e.g.chosen_pb_listview);
        this.cWb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.b(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.fHP != null && PbChosenActivity.this.fHP.KT() != null) {
                    PbChosenActivity.this.fHP.KT().hide();
                }
                PbChosenActivity.this.fHH.setVisible(true);
                return false;
            }
        });
        this.cWb.setOnScrollListener(this.mScrollListener);
        this.fHK = new com.baidu.tieba.pb.chosen.view.a(getPageContext().getPageActivity());
        this.cWb.setAdapter((ListAdapter) this.fHK);
        this.fHH = new f(findViewById(e.g.chosen_pb_reply));
        this.fHH.G(this.fHS);
        this.fHH.H(this.fHU);
        this.fHE = new d(getPageContext().getPageActivity());
        this.fHF = new com.baidu.tieba.pb.chosen.view.e(getPageContext().getPageActivity());
        this.fHG = new c(getPageContext().getPageActivity(), this.fHT);
        this.fHE.a(this.fHX);
        this.fHF.a(this.fHW);
        this.cWb.addHeaderView(this.fHE.bei());
        BdListViewHelper.a(getActivity(), this.cWb, BdListViewHelper.HeadType.DEFAULT);
        this.cWb.addFooterView(this.fHF.bej());
        this.cWb.addFooterView(this.fHG.getView());
        awU();
        registerListener(this.fHZ);
        registerListener(this.fHY);
        this.fIa.setSelfListener(true);
        registerListener(this.fIa);
        registerListener(this.aUc);
        registerListener(this.bRt);
        registerListener(this.fHV);
        bee();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_recommend_pb", true);
            this.dBD = new VoiceManager();
            this.dBD.onCreate(getPageContext());
            B(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.fHQ && !this.fpn) {
            this.fHQ = true;
            showLoadingView(this.ceh, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public k onGetPreLoadListView() {
        if (this.cWb == null) {
            return null;
        }
        return this.cWb.getPreLoadHandle();
    }

    private void awU() {
        this.bAs = (NavigationBar) findViewById(e.g.view_navigation_bar);
        if (this.bAs != null) {
            this.bAs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.bAs.setTitleText(e.j.chosen_pb_title);
            this.fHJ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.chosen_pb_reply_layout, (ViewGroup) null);
            this.fHI = (TextView) this.fHJ.findViewById(e.g.chosen_pb_reply_number);
            this.bAs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fHJ, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new am("c10091").ax("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").ax("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ax("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.fHR)));
                    }
                }
            });
        }
    }

    private void bee() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(2001314);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.fHP != null) {
                this.fHP.onActivityResult(i, i2, intent);
            }
            switch (i) {
                case 23003:
                    a.a(this, this.chosenData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
                    return;
                case 23007:
                    long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
                    String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
                    String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
                    a.a(this, this.chosenData, longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2, this.shareUrl);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().excid != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_new_duration", null, 1, "duration", (SystemClock.elapsedRealtime() - this.startTime) + "", PbChosenActivityConfig.KEY_TID, this.chosenData.getThreadInfo().excid);
        }
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> bef() {
        if (this.eYB == null) {
            this.eYB = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean Ln() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData hs(String str) {
                    if (PbChosenActivity.this.chosenData == null || PbChosenActivity.this.chosenData.getThreadInfo() == null) {
                        return null;
                    }
                    WriteData writeData = new WriteData();
                    writeData.setForumId(String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                    writeData.setForumName(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name);
                    writeData.setThreadId(String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().thread_id));
                    writeData.setIsAd(false);
                    writeData.setType(1);
                    return writeData;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public String Lo() {
                    return null;
                }
            };
        }
        return this.eYB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().setNightMode(i == 1);
        getPageContext().getLayoutMode().onModeChanged(this.fHE.bei());
        getPageContext().getLayoutMode().onModeChanged(this.fHF.bej());
        this.fHG.onChangeSkinType();
        this.fHH.onChangeSkinType();
        if (this.bAs != null) {
            this.bAs.onChangeSkinType(getPageContext(), i);
        }
        if (this.fHP != null && this.fHP.KT() != null) {
            this.fHP.KT().onChangeSkinType(i);
        }
        al.b(this.fHI, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.j(this.ceh, e.d.cp_bg_line_d);
        this.fHK.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.fHP == null || this.fHP.KT() == null || !this.fHP.KT().KW()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.fHP.KT().Js();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fHP != null) {
            this.fHP.onSaveInstanceState(bundle);
        }
        if (this.dBD != null) {
            this.dBD.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fHP != null) {
            this.fHP.onDestroy();
        }
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
    }

    private void B(Bundle bundle) {
        com.baidu.tbadk.editortools.pb.f fVar = new com.baidu.tbadk.editortools.pb.f();
        fVar.a(bef());
        this.fHP = (com.baidu.tbadk.editortools.pb.d) fVar.bJ(getActivity());
        this.fHP.b(this);
        this.fHP.a(this.aWI);
        this.fHP.a(this.aWB);
        this.fHP.KT().cp(true);
        this.fHP.a(this, bundle);
        h(this.fHP);
    }

    private void h(com.baidu.tbadk.editortools.pb.d dVar) {
        if (dVar.KT() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ceh.addView(dVar.KT(), layoutParams);
            dVar.KT().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dBD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a013";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum != null) {
            pageStayDurationItem.setFid(this.chosenData.getThreadInfo().forum.forum_id.longValue());
            pageStayDurationItem.setTid(this.chosenData.getThreadInfo().thread_id.longValue());
        }
        return pageStayDurationItem;
    }
}
