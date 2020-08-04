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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.editortools.pb.DataModel;
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
/* loaded from: classes17.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private NavigationBar ffK;
    private VoiceManager hFy;
    private BdListView hbF;
    private DataModel<PbChosenActivity> jqK;
    private d kfM;
    private e kfN;
    private c kfO;
    private f kfP;
    private TextView kfQ;
    private View kfR;
    private com.baidu.tieba.pb.chosen.view.a kfS;
    private LikeModel kfT;
    private com.baidu.tieba.pb.chosen.net.zan.a kfU;
    private b kfV;
    private a kfW;
    private com.baidu.tbadk.editortools.pb.e kfX;
    private boolean kfY;
    private RelativeLayout rootView;
    private long startTime;
    private String shareUrl = null;
    private boolean huV = false;
    private boolean jJI = false;
    private int from = 1;
    private int kfZ = -1;
    private final AbsListView.OnScrollListener cEp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.kfX != null && PbChosenActivity.this.kfX.biJ() != null) {
                PbChosenActivity.this.kfX.biJ().hide();
                PbChosenActivity.this.kfP.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c eBX = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bjj() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener kga = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.kfX != null && PbChosenActivity.this.kfX.biJ() != null) {
                PbChosenActivity.this.kfX.biJ().display();
                PbChosenActivity.this.kfP.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.kfX.biJ().hide();
                PbChosenActivity.this.kfP.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && adVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.bB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                    AntiHelper.aW(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).aYR();
                }
            }
        }
    };
    private c.a kgb = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.view.c.a
        public void Ko(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new ap("c10093").dn("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").dn("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).ah("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dn("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener kgc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new ap("pb_new_share").ah("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dn("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.kfW == null) {
                    PbChosenActivity.this.kfW = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.kfW.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener hGV = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener kgd = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a kge = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void v(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.kfZ)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new ap("pb_new_detail_btn").ah("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dn("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void rP(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.kfU == null) {
                    PbChosenActivity.this.kfU = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.kfU.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.kfU.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new ap("pb_new_like").ah("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dn("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b kgf = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void fa(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void Kn(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new ap("pb_new_sourcefid").ah("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dn("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void cKn() {
            if (!j.isNetWorkAvailable()) {
                BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(R.string.neterror)).aYR();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.kfT == null) {
                    PbChosenActivity.this.kfT = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.kfT.setFrom("from_frs");
                PbChosenActivity.this.kfT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void callback(Object obj) {
                        if (AntiHelper.bB(PbChosenActivity.this.kfT.getErrorCode(), PbChosenActivity.this.kfT.getErrorString())) {
                            AntiHelper.aW(PbChosenActivity.this.getActivity(), PbChosenActivity.this.kfT.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.kfT.fz(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new ap("c10322").dn("fid", PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").dn("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").ah("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dn("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a ezs = new com.baidu.adp.framework.listener.a(1003006, CmdConfigSocket.CMD_GET_FINE_PB) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.jJI = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.rootView);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(R.string.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.huV) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.rootView, PbChosenActivity.this.getResources().getString(R.string.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.kfP.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener kgg = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.kfN.cKs();
            PbChosenActivity.this.kfN.kgR = !PbChosenActivity.this.kfN.kgR;
            PbChosenActivity.this.kfN.rS(PbChosenActivity.this.kfN.kgR);
            if (PbChosenActivity.this.kfN.kgR) {
                PbChosenActivity.this.kfZ = 1;
            } else {
                PbChosenActivity.this.kfZ = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a kgh = new com.baidu.adp.framework.listener.a(1003007, CmdConfigSocket.CMD_CHOSEN_PB_PRAISE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.kfN.cKs();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).aYR();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.kfN.rS(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.kfZ = 1;
                    } else {
                        PbChosenActivity.this.kfZ = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener kgi = new CustomMessageListener(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.jJI = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.kfV == null) {
                    PbChosenActivity.this.kfV = new b();
                }
                PbChosenActivity.this.kfV.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.kfM.rR(z);
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
            if (this.kfV == null) {
                this.kfV = new b();
            }
            this.kfV.a(this, longExtra, longExtra2, longExtra3);
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
            this.kfP.setVisible(false);
            return;
        }
        this.huV = true;
        this.kfP.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.kfM.a(userInfo);
        }
        if (this.kfO != null) {
            this.kfO.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.kfQ != null && threadInfo.post_num != null) {
                String numFormatOver10000 = as.numFormatOver10000(threadInfo.post_num.longValue());
                this.kfQ.setText(getResources().getString(R.string.chosen_pb_reply_number_text, numFormatOver10000));
                this.kfP.Kq(getResources().getString(R.string.chosen_pb_reply_count_text, numFormatOver10000));
            }
            this.kfN.a(threadInfo);
            this.kfM.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.kfS.er(aVar2.getData());
            this.kfS.notifyDataSetChanged();
        }
        this.hbF.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(R.layout.chosen_pb_layout);
        this.rootView = (RelativeLayout) findViewById(R.id.chosen_pb_root);
        this.hbF = (BdListView) findViewById(R.id.chosen_pb_listview);
        this.hbF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.hideSoftKeyPad(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.kfX != null && PbChosenActivity.this.kfX.biJ() != null) {
                    PbChosenActivity.this.kfX.biJ().hide();
                }
                PbChosenActivity.this.kfP.setVisible(true);
                return false;
            }
        });
        this.hbF.setOnScrollListener(this.cEp);
        this.kfS = new com.baidu.tieba.pb.chosen.view.a(getPageContext().getPageActivity());
        this.hbF.setAdapter((ListAdapter) this.kfS);
        this.kfP = new f(findViewById(R.id.chosen_pb_reply));
        this.kfP.P(this.kga);
        this.kfP.Q(this.kgc);
        this.kfM = new d(getPageContext().getPageActivity());
        this.kfN = new e(getPageContext().getPageActivity());
        this.kfO = new c(getPageContext().getPageActivity(), this.kgb);
        this.kfM.a(this.kgf);
        this.kfN.a(this.kge);
        this.hbF.addHeaderView(this.kfM.cKq());
        BdListViewHelper.a(getActivity(), this.hbF, BdListViewHelper.HeadType.DEFAULT);
        this.hbF.addFooterView(this.kfN.cKr());
        this.hbF.addFooterView(this.kfO.getView());
        bmb();
        registerListener(this.kgh);
        registerListener(this.kgg);
        this.kgi.setSelfListener(true);
        registerListener(this.kgi);
        registerListener(this.ezs);
        registerListener(this.hGV);
        registerListener(this.kgd);
        cKl();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.KEY_ENTER_RECOMMEND_PB, true);
            this.hFy = new VoiceManager();
            this.hFy.onCreate(getPageContext());
            as(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.kfY && !this.jJI) {
            this.kfY = true;
            showLoadingView(this.rootView, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public t onGetPreLoadListView() {
        if (this.hbF == null) {
            return null;
        }
        return this.hbF.getPreLoadHandle();
    }

    private void bmb() {
        this.ffK = (NavigationBar) findViewById(R.id.view_navigation_bar);
        if (this.ffK != null) {
            this.ffK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.ffK.setTitleText(R.string.chosen_pb_title);
            this.kfR = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.chosen_pb_reply_layout, (ViewGroup) null);
            this.kfQ = (TextView) this.kfR.findViewById(R.id.chosen_pb_reply_number);
            this.ffK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kfR, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new ap("c10091").dn("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").dn("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).ah("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).dn("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.kfZ)));
                    }
                }
            });
        }
    }

    private void cKl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.kfX != null) {
                this.kfX.onActivityResult(i, i2, intent);
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
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> cKm() {
        if (this.jqK == null) {
            this.jqK = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean bjf() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData zE(String str) {
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
                public String bjg() {
                    return null;
                }
            };
        }
        return this.jqK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().setNightMode(i == 1);
        getPageContext().getLayoutMode().onModeChanged(this.kfM.cKq());
        getPageContext().getLayoutMode().onModeChanged(this.kfN.cKr());
        this.kfO.onChangeSkinType();
        this.kfP.onChangeSkinType();
        if (this.ffK != null) {
            this.ffK.onChangeSkinType(getPageContext(), i);
        }
        if (this.kfX != null && this.kfX.biJ() != null) {
            this.kfX.biJ().onChangeSkinType(i);
        }
        ao.setNavbarTitleColor(this.kfQ, R.color.navi_op_text, R.color.navi_op_text_skin);
        ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.kfS.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.kfX == null || this.kfX.biJ() == null || !this.kfX.biJ().biL()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.kfX.biJ().bhl();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kfX != null) {
            this.kfX.onSaveInstanceState(bundle);
        }
        if (this.hFy != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kfX != null) {
            this.kfX.onDestroy();
        }
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
    }

    private void as(Bundle bundle) {
        g gVar = new g();
        gVar.a(cKm());
        this.kfX = (com.baidu.tbadk.editortools.pb.e) gVar.dT(getActivity());
        this.kfX.a(getPageContext());
        this.kfX.a(this.eCe);
        this.kfX.a(this.eBX);
        this.kfX.biJ().iJ(true);
        this.kfX.a(getPageContext(), bundle);
        i(this.kfX);
    }

    private void i(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar.biJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.rootView.addView(eVar.biJ(), layoutParams);
            eVar.biJ().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hFy;
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
