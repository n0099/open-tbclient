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
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.e;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
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
/* loaded from: classes23.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private NavigationBar fUP;
    private VoiceManager iHo;
    private BdListView icT;
    private DataModel<PbChosenActivity> kvJ;
    private b llA;
    private a llB;
    private e llC;
    private boolean llD;
    private d llr;
    private com.baidu.tieba.pb.chosen.view.e lls;
    private c llt;
    private f llu;
    private TextView llv;
    private View llw;
    private com.baidu.tieba.pb.chosen.view.a llx;
    private LikeModel lly;
    private com.baidu.tieba.pb.chosen.net.zan.a llz;
    private RelativeLayout rootView;
    private long startTime;
    private String shareUrl = null;
    private boolean iwL = false;
    private boolean kPp = false;
    private int from = 1;
    private int llE = -1;
    private final AbsListView.OnScrollListener dpT = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.llC != null && PbChosenActivity.this.llC.bzx() != null) {
                PbChosenActivity.this.llC.bzx().hide();
                PbChosenActivity.this.llu.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fpP = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bAc() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener llF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.llC != null && PbChosenActivity.this.llC.bzx() != null) {
                PbChosenActivity.this.llC.bzx().display();
                PbChosenActivity.this.llu.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.llC.bzx().hide();
                PbChosenActivity.this.llu.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && ahVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.bR(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                    AntiHelper.bm(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).bpi();
                }
            }
        }
    };
    private c.a llG = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.view.c.a
        public void Po(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new aq("c10093").dR("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").dR("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).al("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dR("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener llH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new aq("pb_new_share").al("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dR("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.llB == null) {
                    PbChosenActivity.this.llB = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.llB.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener iIL = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener llI = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a llJ = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void w(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.llE)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new aq("pb_new_detail_btn").al("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dR("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void tN(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.llz == null) {
                    PbChosenActivity.this.llz = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.llz.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.llz.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new aq("pb_new_like").al("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dR("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b llK = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void fR(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void Pn(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new aq("pb_new_sourcefid").al("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dR("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void dia() {
            if (!j.isNetWorkAvailable()) {
                BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(R.string.neterror)).bpi();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.lly == null) {
                    PbChosenActivity.this.lly = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.lly.setFrom("from_frs");
                PbChosenActivity.this.lly.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void callback(Object obj) {
                        if (AntiHelper.bR(PbChosenActivity.this.lly.getErrorCode(), PbChosenActivity.this.lly.getErrorString())) {
                            AntiHelper.bm(PbChosenActivity.this.getActivity(), PbChosenActivity.this.lly.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.lly.gp(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new aq("c10322").dR("fid", PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").dR("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").al("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dR("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a fmI = new com.baidu.adp.framework.listener.a(1003006, CmdConfigSocket.CMD_GET_FINE_PB) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.kPp = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.rootView);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(R.string.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.iwL) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.rootView, PbChosenActivity.this.getResources().getString(R.string.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.llu.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener llL = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.lls.dif();
            PbChosenActivity.this.lls.lmw = !PbChosenActivity.this.lls.lmw;
            PbChosenActivity.this.lls.tQ(PbChosenActivity.this.lls.lmw);
            if (PbChosenActivity.this.lls.lmw) {
                PbChosenActivity.this.llE = 1;
            } else {
                PbChosenActivity.this.llE = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a llM = new com.baidu.adp.framework.listener.a(1003007, CmdConfigSocket.CMD_CHOSEN_PB_PRAISE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.lls.dif();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).bpi();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.lls.tQ(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.llE = 1;
                    } else {
                        PbChosenActivity.this.llE = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener llN = new CustomMessageListener(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.kPp = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.llA == null) {
                    PbChosenActivity.this.llA = new b();
                }
                PbChosenActivity.this.llA.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.llr.tP(z);
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
            if (this.llA == null) {
                this.llA = new b();
            }
            this.llA.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.rootView);
            showLoadingView(this.rootView, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.rootView);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.rootView, getResources().getString(R.string.error_unkown_try_again), true);
            setNetRefreshLayoutMarginTop(false);
            this.llu.setVisible(false);
            return;
        }
        this.iwL = true;
        this.llu.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.llr.a(userInfo);
        }
        if (this.llt != null) {
            this.llt.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.llv != null && threadInfo.post_num != null) {
                String numFormatOver10000 = at.numFormatOver10000(threadInfo.post_num.longValue());
                this.llv.setText(getResources().getString(R.string.chosen_pb_reply_number_text, numFormatOver10000));
                this.llu.Pq(getResources().getString(R.string.chosen_pb_reply_count_text, numFormatOver10000));
            }
            this.lls.a(threadInfo);
            this.llr.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.llx.fb(aVar2.getData());
            this.llx.notifyDataSetChanged();
        }
        this.icT.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(R.layout.chosen_pb_layout);
        this.rootView = (RelativeLayout) findViewById(R.id.chosen_pb_root);
        this.icT = (BdListView) findViewById(R.id.chosen_pb_listview);
        this.icT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.hideSoftKeyPad(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.llC != null && PbChosenActivity.this.llC.bzx() != null) {
                    PbChosenActivity.this.llC.bzx().hide();
                }
                PbChosenActivity.this.llu.setVisible(true);
                return false;
            }
        });
        this.icT.setOnScrollListener(this.dpT);
        this.llx = new com.baidu.tieba.pb.chosen.view.a(getPageContext().getPageActivity());
        this.icT.setAdapter((ListAdapter) this.llx);
        this.llu = new f(findViewById(R.id.chosen_pb_reply));
        this.llu.R(this.llF);
        this.llu.S(this.llH);
        this.llr = new d(getPageContext().getPageActivity());
        this.lls = new com.baidu.tieba.pb.chosen.view.e(getPageContext().getPageActivity());
        this.llt = new c(getPageContext().getPageActivity(), this.llG);
        this.llr.a(this.llK);
        this.lls.a(this.llJ);
        this.icT.addHeaderView(this.llr.did());
        BdListViewHelper.a(getActivity(), this.icT, BdListViewHelper.HeadType.DEFAULT);
        this.icT.addFooterView(this.lls.die());
        this.icT.addFooterView(this.llt.getView());
        bCV();
        registerListener(this.llM);
        registerListener(this.llL);
        this.llN.setSelfListener(true);
        registerListener(this.llN);
        registerListener(this.fmI);
        registerListener(this.iIL);
        registerListener(this.llI);
        dhY();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_ENTER_RECOMMEND_PB, true);
            this.iHo = new VoiceManager();
            this.iHo.onCreate(getPageContext());
            ar(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.llD && !this.kPp) {
            this.llD = true;
            showLoadingView(this.rootView, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.icT == null) {
            return null;
        }
        return this.icT.getPreLoadHandle();
    }

    private void bCV() {
        this.fUP = (NavigationBar) findViewById(R.id.view_navigation_bar);
        if (this.fUP != null) {
            this.fUP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.fUP.setTitleText(R.string.chosen_pb_title);
            this.llw = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.chosen_pb_reply_layout, (ViewGroup) null);
            this.llv = (TextView) this.llw.findViewById(R.id.chosen_pb_reply_number);
            this.fUP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.llw, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new aq("c10091").dR("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").dR("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).al("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dR("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.llE)));
                    }
                }
            });
        }
    }

    private void dhY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.llC != null) {
                this.llC.onActivityResult(i, i2, intent);
            }
            switch (i) {
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    a.a(this, this.chosenData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
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
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> dhZ() {
        if (this.kvJ == null) {
            this.kvJ = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean bzY() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData DK(String str) {
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
                public String bzZ() {
                    return null;
                }
            };
        }
        return this.kvJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().setNightMode(i == 1);
        getPageContext().getLayoutMode().onModeChanged(this.llr.did());
        getPageContext().getLayoutMode().onModeChanged(this.lls.die());
        this.llt.onChangeSkinType();
        this.llu.onChangeSkinType();
        if (this.fUP != null) {
            this.fUP.onChangeSkinType(getPageContext(), i);
        }
        if (this.llC != null && this.llC.bzx() != null) {
            this.llC.bzx().onChangeSkinType(i);
        }
        ap.setNavbarTitleColor(this.llv, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.llx.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.llC == null || this.llC.bzx() == null || !this.llC.bzx().bzB()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.llC.bzx().bxU();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.llC != null) {
            this.llC.onSaveInstanceState(bundle);
        }
        if (this.iHo != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.llC != null) {
            this.llC.onDestroy();
        }
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
    }

    private void ar(Bundle bundle) {
        g gVar = new g();
        gVar.a(dhZ());
        this.llC = (com.baidu.tbadk.editortools.pb.e) gVar.ei(getActivity());
        this.llC.a(getPageContext());
        this.llC.a(this.fpW);
        this.llC.a(this.fpP);
        this.llC.bzx().kb(true);
        this.llC.a(getPageContext(), bundle);
        d(this.llC);
    }

    private void d(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar.bzx() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.rootView.addView(eVar.bzx(), layoutParams);
            eVar.bzx().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iHo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_CHOOSEN;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum != null) {
            pageStayDurationItem.setFid(this.chosenData.getThreadInfo().forum.forum_id.longValue());
            pageStayDurationItem.setTid(this.chosenData.getThreadInfo().thread_id.longValue());
        }
        return pageStayDurationItem;
    }
}
