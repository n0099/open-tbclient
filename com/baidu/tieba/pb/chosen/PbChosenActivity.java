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
    private NavigationBar bDS;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private RelativeLayout cig;
    private VoiceManager dKQ;
    private BdListView dfD;
    private d fRm;
    private e fRn;
    private c fRo;
    private f fRp;
    private TextView fRq;
    private View fRr;
    private com.baidu.tieba.pb.chosen.view.a fRs;
    private LikeModel fRt;
    private com.baidu.tieba.pb.chosen.net.zan.a fRu;
    private b fRv;
    private a fRw;
    private com.baidu.tbadk.editortools.pb.d fRx;
    private boolean fRy;
    private DataModel<PbChosenActivity> fii;
    private long startTime;
    private String shareUrl = null;
    private boolean cOG = false;
    private boolean fyX = false;
    private int from = 1;
    private int fRz = -1;
    private final AbsListView.OnScrollListener mScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.fRx != null && PbChosenActivity.this.fRx.LY() != null) {
                PbChosenActivity.this.fRx.LY().hide();
                PbChosenActivity.this.fRp.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c bab = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Mw() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener fRA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.fRx != null && PbChosenActivity.this.fRx.LY() != null) {
                PbChosenActivity.this.fRx.LY().pN();
                PbChosenActivity.this.fRp.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d bai = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.fRx.LY().hide();
                PbChosenActivity.this.fRp.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && wVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.aj(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                    AntiHelper.aJ(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).BN();
                }
            }
        }
    };
    private c.a fRB = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.view.c.a
        public void sL(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new am("c10093").aA("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").aA("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).aA("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener fRC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new am("pb_new_share").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).aA("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.fRw == null) {
                    PbChosenActivity.this.fRw = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.fRw.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener bVn = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener fRD = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a fRE = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void q(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.fRz)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new am("pb_new_detail_btn").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).aA("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void kt(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.fRu == null) {
                    PbChosenActivity.this.fRu = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.fRu.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.fRu.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new am("pb_new_like").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).aA("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b fRF = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void cm(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void sK(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new am("pb_new_sourcefid").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).aA("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void ahN() {
            if (!j.kV()) {
                BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(e.j.neterror)).BN();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.fRt == null) {
                    PbChosenActivity.this.fRt = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.fRt.setFrom("from_frs");
                PbChosenActivity.this.fRt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void m(Object obj) {
                        if (AntiHelper.aj(PbChosenActivity.this.fRt.getErrorCode(), PbChosenActivity.this.fRt.getErrorString())) {
                            AntiHelper.aJ(PbChosenActivity.this.getActivity(), PbChosenActivity.this.fRt.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.fRt.cK(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new am("c10322").aA(ImageViewerConfig.FORUM_ID, PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").aA("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).aA("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a aXC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_FINE_PB, 309093) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.fyX = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.cig);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(e.j.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.cOG) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.cig, PbChosenActivity.this.getResources().getString(e.j.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.fRp.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener fRG = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.fRn.bgM();
            PbChosenActivity.this.fRn.fSr = !PbChosenActivity.this.fRn.fSr;
            PbChosenActivity.this.fRn.kw(PbChosenActivity.this.fRn.fSr);
            if (PbChosenActivity.this.fRn.fSr) {
                PbChosenActivity.this.fRz = 1;
            } else {
                PbChosenActivity.this.fRz = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fRH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.fRn.bgM();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).BN();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.fRn.kw(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.fRz = 1;
                    } else {
                        PbChosenActivity.this.fRz = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener fRI = new CustomMessageListener(2001314) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.fyX = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.fRv == null) {
                    PbChosenActivity.this.fRv = new b();
                }
                PbChosenActivity.this.fRv.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.fRm.kv(z);
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
            if (this.fRv == null) {
                this.fRv = new b();
            }
            this.fRv.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.cig);
            showLoadingView(this.cig, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.cig);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.cig, getResources().getString(e.j.error_unkown_try_again), true);
            setNetRefreshLayoutMarginTop(false);
            this.fRp.setVisible(false);
            return;
        }
        this.cOG = true;
        this.fRp.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.fRm.a(userInfo);
        }
        if (this.fRo != null) {
            this.fRo.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.fRq != null && threadInfo.post_num != null) {
                String V = ao.V(threadInfo.post_num.longValue());
                this.fRq.setText(getResources().getString(e.j.chosen_pb_reply_number_text, V));
                this.fRp.sN(getResources().getString(e.j.chosen_pb_reply_count_text, V));
            }
            this.fRn.a(threadInfo);
            this.fRm.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.fRs.dl(aVar2.getData());
            this.fRs.notifyDataSetChanged();
        }
        this.dfD.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(e.h.chosen_pb_layout);
        this.cig = (RelativeLayout) findViewById(e.g.chosen_pb_root);
        this.dfD = (BdListView) findViewById(e.g.chosen_pb_listview);
        this.dfD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.b(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.fRx != null && PbChosenActivity.this.fRx.LY() != null) {
                    PbChosenActivity.this.fRx.LY().hide();
                }
                PbChosenActivity.this.fRp.setVisible(true);
                return false;
            }
        });
        this.dfD.setOnScrollListener(this.mScrollListener);
        this.fRs = new com.baidu.tieba.pb.chosen.view.a(getPageContext().getPageActivity());
        this.dfD.setAdapter((ListAdapter) this.fRs);
        this.fRp = new f(findViewById(e.g.chosen_pb_reply));
        this.fRp.G(this.fRA);
        this.fRp.H(this.fRC);
        this.fRm = new d(getPageContext().getPageActivity());
        this.fRn = new com.baidu.tieba.pb.chosen.view.e(getPageContext().getPageActivity());
        this.fRo = new c(getPageContext().getPageActivity(), this.fRB);
        this.fRm.a(this.fRF);
        this.fRn.a(this.fRE);
        this.dfD.addHeaderView(this.fRm.bgK());
        BdListViewHelper.a(getActivity(), this.dfD, BdListViewHelper.HeadType.DEFAULT);
        this.dfD.addFooterView(this.fRn.bgL());
        this.dfD.addFooterView(this.fRo.getView());
        azu();
        registerListener(this.fRH);
        registerListener(this.fRG);
        this.fRI.setSelfListener(true);
        registerListener(this.fRI);
        registerListener(this.aXC);
        registerListener(this.bVn);
        registerListener(this.fRD);
        bgG();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_recommend_pb", true);
            this.dKQ = new VoiceManager();
            this.dKQ.onCreate(getPageContext());
            E(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.fRy && !this.fyX) {
            this.fRy = true;
            showLoadingView(this.cig, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public k onGetPreLoadListView() {
        if (this.dfD == null) {
            return null;
        }
        return this.dfD.getPreLoadHandle();
    }

    private void azu() {
        this.bDS = (NavigationBar) findViewById(e.g.view_navigation_bar);
        if (this.bDS != null) {
            this.bDS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.bDS.setTitleText(e.j.chosen_pb_title);
            this.fRr = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.chosen_pb_reply_layout, (ViewGroup) null);
            this.fRq = (TextView) this.fRr.findViewById(e.g.chosen_pb_reply_number);
            this.bDS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fRr, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new am("c10091").aA("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").aA("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).aA("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.fRz)));
                    }
                }
            });
        }
    }

    private void bgG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(2001314);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.fRx != null) {
                this.fRx.onActivityResult(i, i2, intent);
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
        if (this.dKQ != null) {
            this.dKQ.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> bgH() {
        if (this.fii == null) {
            this.fii = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean Ms() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData hL(String str) {
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
                public String Mt() {
                    return null;
                }
            };
        }
        return this.fii;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().setNightMode(i == 1);
        getPageContext().getLayoutMode().onModeChanged(this.fRm.bgK());
        getPageContext().getLayoutMode().onModeChanged(this.fRn.bgL());
        this.fRo.onChangeSkinType();
        this.fRp.onChangeSkinType();
        if (this.bDS != null) {
            this.bDS.onChangeSkinType(getPageContext(), i);
        }
        if (this.fRx != null && this.fRx.LY() != null) {
            this.fRx.LY().onChangeSkinType(i);
        }
        al.b(this.fRq, e.d.navi_op_text, e.d.navi_op_text_skin);
        al.j(this.cig, e.d.cp_bg_line_d);
        this.fRs.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.fRx == null || this.fRx.LY() == null || !this.fRx.LY().Mb()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.fRx.LY().Kx();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fRx != null) {
            this.fRx.onSaveInstanceState(bundle);
        }
        if (this.dKQ != null) {
            this.dKQ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dKQ != null) {
            this.dKQ.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dKQ != null) {
            this.dKQ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dKQ != null) {
            this.dKQ.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fRx != null) {
            this.fRx.onDestroy();
        }
        if (this.dKQ != null) {
            this.dKQ.onDestory(getPageContext());
        }
    }

    private void E(Bundle bundle) {
        com.baidu.tbadk.editortools.pb.f fVar = new com.baidu.tbadk.editortools.pb.f();
        fVar.a(bgH());
        this.fRx = (com.baidu.tbadk.editortools.pb.d) fVar.bM(getActivity());
        this.fRx.b(this);
        this.fRx.a(this.bai);
        this.fRx.a(this.bab);
        this.fRx.LY().cq(true);
        this.fRx.a(this, bundle);
        h(this.fRx);
    }

    private void h(com.baidu.tbadk.editortools.pb.d dVar) {
        if (dVar.LY() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cig.addView(dVar.LY(), layoutParams);
            dVar.LY().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dKQ;
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
