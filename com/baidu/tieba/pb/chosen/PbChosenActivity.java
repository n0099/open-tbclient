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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.chosen.a.c;
import com.baidu.tieba.pb.chosen.a.d;
import com.baidu.tieba.pb.chosen.a.e;
import com.baidu.tieba.pb.chosen.a.f;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
import com.baidu.tieba.pb.chosen.net.b;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private NavigationBar bVs;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager dEn;
    private BdListView deR;
    private DataModel<PbChosenActivity> eTD;
    private RelativeLayout fFP;
    private d fFQ;
    private e fFR;
    private c fFS;
    private f fFT;
    private TextView fFU;
    private View fFV;
    private com.baidu.tieba.pb.chosen.a.a fFW;
    private LikeModel fFX;
    private com.baidu.tieba.pb.chosen.net.zan.a fFY;
    private b fFZ;
    private a fGa;
    private com.baidu.tbadk.editortools.pb.d fGb;
    private boolean fGc;
    private long startTime;
    private String shareUrl = null;
    private boolean duS = false;
    private boolean foD = false;
    private int from = 1;
    private int fGd = -1;
    private final AbsListView.OnScrollListener esF = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.fGb != null && PbChosenActivity.this.fGb.Lc() != null) {
                PbChosenActivity.this.fGb.Lc().hide();
                PbChosenActivity.this.fFT.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c bue = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void LA() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener fGe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.fGb != null && PbChosenActivity.this.fGb.Lc() != null) {
                PbChosenActivity.this.fGb.Lc().th();
                PbChosenActivity.this.fFT.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d bum = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.fGb.Lc().hide();
                PbChosenActivity.this.fFT.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && tVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.vR(postWriteCallBackData.getErrorCode())) {
                    AntiHelper.ar(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).Bd();
                }
            }
        }
    };
    private c.a fGf = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.a.c.a
        public void qg(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new ak("c10093").ab("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").ab("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ab("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener fGg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new ak("pb_new_share").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ab("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.fGa == null) {
                    PbChosenActivity.this.fGa = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.fGa.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener chk = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener fGh = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a fGi = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.a.e.a
        public void n(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.fGd)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new ak("pb_new_detail_btn").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ab("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.a.e.a
        public void jN(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.fFY == null) {
                    PbChosenActivity.this.fFY = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.fFY.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.fFY.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new ak("pb_new_like").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ab("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b fGj = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.a.d.b
        public void bF(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.a.d.b
        public void qf(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new ak("pb_new_sourcefid").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ab("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.a.d.b
        public void baf() {
            if (!j.oJ()) {
                BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(d.j.neterror)).Bd();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.fFX == null) {
                    PbChosenActivity.this.fFX = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.fFX.setFrom("from_frs");
                PbChosenActivity.this.fFX.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void ak(Object obj) {
                        if (AntiHelper.vR(PbChosenActivity.this.fFX.getErrorCode())) {
                            AntiHelper.ar(PbChosenActivity.this.getActivity(), PbChosenActivity.this.fFX.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.fFX.cc(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new ak("c10322").ab(ImageViewerConfig.FORUM_ID, PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").ab("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ab("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a brv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_FINE_PB, 309093) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.foD = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.fFP);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(d.j.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.duS) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.fFP, PbChosenActivity.this.getResources().getString(d.j.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.fFT.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener fGk = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.fFR.bak();
            PbChosenActivity.this.fFR.fGV = !PbChosenActivity.this.fFR.fGV;
            PbChosenActivity.this.fFR.jQ(PbChosenActivity.this.fFR.fGV);
            if (PbChosenActivity.this.fFR.fGV) {
                PbChosenActivity.this.fGd = 1;
            } else {
                PbChosenActivity.this.fGd = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fGl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.fFR.bak();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).Bd();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.fFR.jQ(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.fGd = 1;
                    } else {
                        PbChosenActivity.this.fGd = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener fGm = new CustomMessageListener(2001314) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.foD = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.fFZ == null) {
                    PbChosenActivity.this.fFZ = new b();
                }
                PbChosenActivity.this.fFZ.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.fFQ.jP(z);
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
            if (this.fFZ == null) {
                this.fFZ = new b();
            }
            this.fFZ.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.fFP);
            showLoadingView(this.fFP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.fFP);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.fFP, getResources().getString(d.j.error_unkown_try_again), true);
            setNetRefreshLayoutMarginTop(false);
            this.fFT.setVisible(false);
            return;
        }
        this.duS = true;
        this.fFT.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.fFQ.a(userInfo);
        }
        if (this.fFS != null) {
            this.fFS.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.fFU != null && threadInfo.post_num != null) {
                String H = am.H(threadInfo.post_num.longValue());
                this.fFU.setText(getResources().getString(d.j.chosen_pb_reply_number_text, H));
                this.fFT.qi(getResources().getString(d.j.chosen_pb_reply_count_text, H));
            }
            this.fFR.a(threadInfo);
            this.fFQ.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.fFW.cT(aVar2.getData());
            this.fFW.notifyDataSetChanged();
        }
        this.deR.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(d.h.chosen_pb_layout);
        this.fFP = (RelativeLayout) findViewById(d.g.chosen_pb_root);
        this.deR = (BdListView) findViewById(d.g.chosen_pb_listview);
        this.deR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.a(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.fGb != null && PbChosenActivity.this.fGb.Lc() != null) {
                    PbChosenActivity.this.fGb.Lc().hide();
                }
                PbChosenActivity.this.fFT.setVisible(true);
                return false;
            }
        });
        this.deR.setOnScrollListener(this.esF);
        this.fFW = new com.baidu.tieba.pb.chosen.a.a(getPageContext().getPageActivity());
        this.deR.setAdapter((ListAdapter) this.fFW);
        this.fFT = new f(findViewById(d.g.chosen_pb_reply));
        this.fFT.C(this.fGe);
        this.fFT.D(this.fGg);
        this.fFQ = new com.baidu.tieba.pb.chosen.a.d(getPageContext().getPageActivity());
        this.fFR = new e(getPageContext().getPageActivity());
        this.fFS = new c(getPageContext().getPageActivity(), this.fGf);
        this.fFQ.a(this.fGj);
        this.fFR.a(this.fGi);
        this.deR.addHeaderView(this.fFQ.bai());
        BdListViewHelper.a(getActivity(), this.deR, BdListViewHelper.HeadType.DEFAULT);
        this.deR.addFooterView(this.fFR.baj());
        this.deR.addFooterView(this.fFS.getView());
        awO();
        registerListener(this.fGl);
        registerListener(this.fGk);
        this.fGm.setSelfListener(true);
        registerListener(this.fGm);
        registerListener(this.brv);
        registerListener(this.chk);
        registerListener(this.fGh);
        bad();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_recommend_pb", true);
            this.dEn = new VoiceManager();
            this.dEn.onCreate(getPageContext());
            B(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.fGc && !this.foD) {
            this.fGc = true;
            showLoadingView(this.fFP, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.deR == null) {
            return null;
        }
        return this.deR.getPreLoadHandle();
    }

    private void awO() {
        this.bVs = (NavigationBar) findViewById(d.g.view_navigation_bar);
        if (this.bVs != null) {
            this.bVs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.bVs.setTitleText(d.j.chosen_pb_title);
            this.fFV = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.chosen_pb_reply_layout, (ViewGroup) null);
            this.fFU = (TextView) this.fFV.findViewById(d.g.chosen_pb_reply_number);
            this.bVs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fFV, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new ak("c10091").ab("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").ab("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ab("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.fGd)));
                    }
                }
            });
        }
    }

    private void bad() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(2001314);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.fGb != null) {
                this.fGb.onActivityResult(i, i2, intent);
            }
            switch (i) {
                case 23003:
                    a.a(this, this.chosenData, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
                    return;
                case 23007:
                    a.a(this, this.chosenData, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.shareUrl);
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
        if (this.dEn != null) {
            this.dEn.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> bae() {
        if (this.eTD == null) {
            this.eTD = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean Lw() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData gr(String str) {
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
                public String Lx() {
                    return null;
                }
            };
        }
        return this.eTD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().aQ(i == 1);
        getPageContext().getLayoutMode().aM(this.fFQ.bai());
        getPageContext().getLayoutMode().aM(this.fFR.baj());
        this.fFS.onChangeSkinType();
        this.fFT.onChangeSkinType();
        if (this.bVs != null) {
            this.bVs.onChangeSkinType(getPageContext(), i);
        }
        if (this.fGb != null && this.fGb.Lc() != null) {
            this.fGb.Lc().onChangeSkinType(i);
        }
        aj.d(this.fFU, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        aj.t(this.fFP, d.C0141d.cp_bg_line_d);
        this.fFW.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.fGb == null || this.fGb.Lc() == null || !this.fGb.Lc().Lf()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.fGb.Lc().Jm();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fGb != null) {
            this.fGb.onSaveInstanceState(bundle);
        }
        if (this.dEn != null) {
            this.dEn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dEn != null) {
            this.dEn.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dEn != null) {
            this.dEn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dEn != null) {
            this.dEn.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fGb != null) {
            this.fGb.onDestroy();
        }
        if (this.dEn != null) {
            this.dEn.onDestory(getPageContext());
        }
    }

    private void B(Bundle bundle) {
        g gVar = new g();
        gVar.a(bae());
        this.fGb = (com.baidu.tbadk.editortools.pb.d) gVar.bd(getActivity());
        this.fGb.b(this);
        this.fGb.a(this.bum);
        this.fGb.a(this.bue);
        this.fGb.Lc().cf(true);
        this.fGb.a(this, bundle);
        h(this.fGb);
    }

    private void h(com.baidu.tbadk.editortools.pb.d dVar) {
        if (dVar.Lc() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.fFP.addView(dVar.Lc(), layoutParams);
            dVar.Lc().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dEn;
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
