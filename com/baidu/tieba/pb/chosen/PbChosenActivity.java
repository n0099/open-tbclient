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
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.d;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
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
import com.baidu.ubc.UBC;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes5.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private NavigationBar cPK;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private RelativeLayout dxP;
    private VoiceManager eYR;
    private BdListView eql;
    private DataModel<PbChosenActivity> gyX;
    private f hiA;
    private TextView hiB;
    private View hiC;
    private com.baidu.tieba.pb.chosen.view.a hiD;
    private LikeModel hiE;
    private com.baidu.tieba.pb.chosen.net.zan.a hiF;
    private b hiG;
    private a hiH;
    private d hiI;
    private boolean hiJ;
    private com.baidu.tieba.pb.chosen.view.d hix;
    private e hiy;
    private c hiz;
    private long startTime;
    private String shareUrl = null;
    private boolean eKY = false;
    private boolean gQe = false;
    private int from = 1;
    private int hiK = -1;
    private final AbsListView.OnScrollListener aIM = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.hiI != null && PbChosenActivity.this.hiI.alS() != null) {
                PbChosenActivity.this.hiI.alS().hide();
                PbChosenActivity.this.hiA.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c ckl = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void amr() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener hiL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.hiI != null && PbChosenActivity.this.hiI.alS() != null) {
                PbChosenActivity.this.hiI.alS().qT();
                PbChosenActivity.this.hiA.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.hiI.alS().hide();
                PbChosenActivity.this.hiA.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && xVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                    AntiHelper.aU(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).abh();
                }
            }
        }
    };
    private c.a hiM = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.view.c.a
        public void zD(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new am("c10093").bJ("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").bJ("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bJ(ImageViewerConfig.ABTEST, PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener hiN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new am("pb_new_share").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bJ(ImageViewerConfig.ABTEST, PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.hiH == null) {
                    PbChosenActivity.this.hiH = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.hiH.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener ddn = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener hiO = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a hiP = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void q(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.hiK)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new am("pb_new_detail_btn").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bJ(ImageViewerConfig.ABTEST, PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void mU(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.hiF == null) {
                    PbChosenActivity.this.hiF = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.hiF.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.hiF.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new am("pb_new_like").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bJ(ImageViewerConfig.ABTEST, PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b hiQ = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void dx(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void zC(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new am("pb_new_sourcefid").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bJ(ImageViewerConfig.ABTEST, PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void aJf() {
            if (!j.kY()) {
                BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(d.j.neterror)).abh();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.hiE == null) {
                    PbChosenActivity.this.hiE = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.hiE.setFrom("from_frs");
                PbChosenActivity.this.hiE.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void m(Object obj) {
                        if (AntiHelper.aB(PbChosenActivity.this.hiE.getErrorCode(), PbChosenActivity.this.hiE.getErrorString())) {
                            AntiHelper.aU(PbChosenActivity.this.getActivity(), PbChosenActivity.this.hiE.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.hiE.dV(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new am("c10322").bJ(ImageViewerConfig.FORUM_ID, PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").bJ("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bJ(ImageViewerConfig.ABTEST, PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a chJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_FINE_PB, 309093) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.gQe = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.dxP);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(d.j.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.eKY) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.dxP, PbChosenActivity.this.getResources().getString(d.j.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.hiA.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener hiR = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.hiy.bHR();
            PbChosenActivity.this.hiy.hjC = !PbChosenActivity.this.hiy.hjC;
            PbChosenActivity.this.hiy.mX(PbChosenActivity.this.hiy.hjC);
            if (PbChosenActivity.this.hiy.hjC) {
                PbChosenActivity.this.hiK = 1;
            } else {
                PbChosenActivity.this.hiK = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hiS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.hiy.bHR();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).abh();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.hiy.mX(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.hiK = 1;
                    } else {
                        PbChosenActivity.this.hiK = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener hiT = new CustomMessageListener(2001314) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.gQe = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.hiG == null) {
                    PbChosenActivity.this.hiG = new b();
                }
                PbChosenActivity.this.hiG.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.hix.mW(z);
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
            if (this.hiG == null) {
                this.hiG = new b();
            }
            this.hiG.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.dxP);
            showLoadingView(this.dxP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.dxP);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.dxP, getResources().getString(d.j.error_unkown_try_again), true);
            setNetRefreshLayoutMarginTop(false);
            this.hiA.setVisible(false);
            return;
        }
        this.eKY = true;
        this.hiA.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.hix.a(userInfo);
        }
        if (this.hiz != null) {
            this.hiz.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.hiB != null && threadInfo.post_num != null) {
                String ax = ap.ax(threadInfo.post_num.longValue());
                this.hiB.setText(getResources().getString(d.j.chosen_pb_reply_number_text, ax));
                this.hiA.zF(getResources().getString(d.j.chosen_pb_reply_count_text, ax));
            }
            this.hiy.a(threadInfo);
            this.hix.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.hiD.dA(aVar2.getData());
            this.hiD.notifyDataSetChanged();
        }
        this.eql.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(d.h.chosen_pb_layout);
        this.dxP = (RelativeLayout) findViewById(d.g.chosen_pb_root);
        this.eql = (BdListView) findViewById(d.g.chosen_pb_listview);
        this.eql.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.b(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.hiI != null && PbChosenActivity.this.hiI.alS() != null) {
                    PbChosenActivity.this.hiI.alS().hide();
                }
                PbChosenActivity.this.hiA.setVisible(true);
                return false;
            }
        });
        this.eql.setOnScrollListener(this.aIM);
        this.hiD = new com.baidu.tieba.pb.chosen.view.a(getPageContext().getPageActivity());
        this.eql.setAdapter((ListAdapter) this.hiD);
        this.hiA = new f(findViewById(d.g.chosen_pb_reply));
        this.hiA.H(this.hiL);
        this.hiA.I(this.hiN);
        this.hix = new com.baidu.tieba.pb.chosen.view.d(getPageContext().getPageActivity());
        this.hiy = new e(getPageContext().getPageActivity());
        this.hiz = new c(getPageContext().getPageActivity(), this.hiM);
        this.hix.a(this.hiQ);
        this.hiy.a(this.hiP);
        this.eql.addHeaderView(this.hix.bHP());
        BdListViewHelper.a(getActivity(), this.eql, BdListViewHelper.HeadType.DEFAULT);
        this.eql.addFooterView(this.hiy.bHQ());
        this.eql.addFooterView(this.hiz.getView());
        aBB();
        registerListener(this.hiS);
        registerListener(this.hiR);
        this.hiT.setSelfListener(true);
        registerListener(this.hiT);
        registerListener(this.chJ);
        registerListener(this.ddn);
        registerListener(this.hiO);
        bHL();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_recommend_pb", true);
            this.eYR = new VoiceManager();
            this.eYR.onCreate(getPageContext());
            R(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.hiJ && !this.gQe) {
            this.hiJ = true;
            showLoadingView(this.dxP, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.eql == null) {
            return null;
        }
        return this.eql.getPreLoadHandle();
    }

    private void aBB() {
        this.cPK = (NavigationBar) findViewById(d.g.view_navigation_bar);
        if (this.cPK != null) {
            this.cPK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.cPK.setTitleText(d.j.chosen_pb_title);
            this.hiC = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.chosen_pb_reply_layout, (ViewGroup) null);
            this.hiB = (TextView) this.hiC.findViewById(d.g.chosen_pb_reply_number);
            this.cPK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hiC, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new am("c10091").bJ("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").bJ("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bJ(ImageViewerConfig.ABTEST, PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.hiK)));
                    }
                }
            });
        }
    }

    private void bHL() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(2001314);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.hiI != null) {
                this.hiI.onActivityResult(i, i2, intent);
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
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_new_duration", null, 1, UBC.CONTENT_KEY_DURATION, (SystemClock.elapsedRealtime() - this.startTime) + "", PbChosenActivityConfig.KEY_TID, this.chosenData.getThreadInfo().excid);
        }
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> bHM() {
        if (this.gyX == null) {
            this.gyX = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean amn() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData oN(String str) {
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
                public String amo() {
                    return null;
                }
            };
        }
        return this.gyX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().setNightMode(i == 1);
        getPageContext().getLayoutMode().onModeChanged(this.hix.bHP());
        getPageContext().getLayoutMode().onModeChanged(this.hiy.bHQ());
        this.hiz.onChangeSkinType();
        this.hiA.onChangeSkinType();
        if (this.cPK != null) {
            this.cPK.onChangeSkinType(getPageContext(), i);
        }
        if (this.hiI != null && this.hiI.alS() != null) {
            this.hiI.alS().onChangeSkinType(i);
        }
        al.c(this.hiB, d.C0277d.navi_op_text, d.C0277d.navi_op_text_skin);
        al.l(this.dxP, d.C0277d.cp_bg_line_d);
        this.hiD.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.hiI == null || this.hiI.alS() == null || !this.hiI.alS().alV()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.hiI.alS().akp();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.hiI != null) {
            this.hiI.onSaveInstanceState(bundle);
        }
        if (this.eYR != null) {
            this.eYR.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.eYR != null) {
            this.eYR.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eYR != null) {
            this.eYR.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eYR != null) {
            this.eYR.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hiI != null) {
            this.hiI.onDestroy();
        }
        if (this.eYR != null) {
            this.eYR.onDestory(getPageContext());
        }
    }

    private void R(Bundle bundle) {
        com.baidu.tbadk.editortools.pb.f fVar = new com.baidu.tbadk.editortools.pb.f();
        fVar.a(bHM());
        this.hiI = (com.baidu.tbadk.editortools.pb.d) fVar.dd(getActivity());
        this.hiI.b(this);
        this.hiI.a(this.cks);
        this.hiI.a(this.ckl);
        this.hiI.alS().eH(true);
        this.hiI.a(this, bundle);
        h(this.hiI);
    }

    private void h(com.baidu.tbadk.editortools.pb.d dVar) {
        if (dVar.alS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dxP.addView(dVar.alS(), layoutParams);
            dVar.alS().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYR;
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
