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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.pb.DataModel;
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
/* loaded from: classes5.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private NavigationBar dkM;
    private BdListView eUY;
    private RelativeLayout ecG;
    private VoiceManager fvn;
    private DataModel<PbChosenActivity> gWY;
    private boolean hHA;
    private d hHo;
    private e hHp;
    private c hHq;
    private f hHr;
    private TextView hHs;
    private View hHt;
    private com.baidu.tieba.pb.chosen.view.a hHu;
    private LikeModel hHv;
    private com.baidu.tieba.pb.chosen.net.zan.a hHw;
    private b hHx;
    private a hHy;
    private com.baidu.tbadk.editortools.pb.d hHz;
    private long startTime;
    private String shareUrl = null;
    private boolean fkX = false;
    private boolean hpa = false;
    private int from = 1;
    private int hHB = -1;
    private final AbsListView.OnScrollListener bfd = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.hHz != null && PbChosenActivity.this.hHz.atZ() != null) {
                PbChosenActivity.this.hHz.atZ().hide();
                PbChosenActivity.this.hHr.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c cGY = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aux() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener hHC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.hHz != null && PbChosenActivity.this.hHz.atZ() != null) {
                PbChosenActivity.this.hHz.atZ().le();
                PbChosenActivity.this.hHr.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.hHz.atZ().hide();
                PbChosenActivity.this.hHr.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && yVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.aH(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                    AntiHelper.aS(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).akT();
                }
            }
        }
    };
    private c.a hHD = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.view.c.a
        public void Az(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new an("c10093").bS("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").bS("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).O("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bS("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener hHE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new an("pb_new_share").O("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bS("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.hHy == null) {
                    PbChosenActivity.this.hHy = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.hHy.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener fwC = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener hHF = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a hHG = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void q(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.hHB)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new an("pb_new_detail_btn").O("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bS("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void nM(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.hHw == null) {
                    PbChosenActivity.this.hHw = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.hHw.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.hHw.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new an("pb_new_like").O("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bS("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b hHH = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void dz(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void Ay(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new an("pb_new_sourcefid").O("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bS("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void bQm() {
            if (!j.isNetWorkAvailable()) {
                BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(R.string.neterror)).akT();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.hHv == null) {
                    PbChosenActivity.this.hHv = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.hHv.setFrom("from_frs");
                PbChosenActivity.this.hHv.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void callback(Object obj) {
                        if (AntiHelper.aH(PbChosenActivity.this.hHv.getErrorCode(), PbChosenActivity.this.hHv.getErrorString())) {
                            AntiHelper.aS(PbChosenActivity.this.getActivity(), PbChosenActivity.this.hHv.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.hHv.dY(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new an("c10322").bS("fid", PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").bS("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").O("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bS("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a cEu = new com.baidu.adp.framework.listener.a(1003006, CmdConfigSocket.CMD_GET_FINE_PB) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.hpa = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.ecG);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(R.string.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.fkX) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.ecG, PbChosenActivity.this.getResources().getString(R.string.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.hHr.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener hHI = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.hHp.bQr();
            PbChosenActivity.this.hHp.hIt = !PbChosenActivity.this.hHp.hIt;
            PbChosenActivity.this.hHp.nP(PbChosenActivity.this.hHp.hIt);
            if (PbChosenActivity.this.hHp.hIt) {
                PbChosenActivity.this.hHB = 1;
            } else {
                PbChosenActivity.this.hHB = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hHJ = new com.baidu.adp.framework.listener.a(1003007, CmdConfigSocket.CMD_CHOSEN_PB_PRAISE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.hHp.bQr();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).akT();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.hHp.nP(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.hHB = 1;
                    } else {
                        PbChosenActivity.this.hHB = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener hHK = new CustomMessageListener(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.hpa = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.hHx == null) {
                    PbChosenActivity.this.hHx = new b();
                }
                PbChosenActivity.this.hHx.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.hHo.nO(z);
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
            if (this.hHx == null) {
                this.hHx = new b();
            }
            this.hHx.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.ecG);
            showLoadingView(this.ecG, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.ecG);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.ecG, getResources().getString(R.string.error_unkown_try_again), true);
            setNetRefreshLayoutMarginTop(false);
            this.hHr.setVisible(false);
            return;
        }
        this.fkX = true;
        this.hHr.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.hHo.a(userInfo);
        }
        if (this.hHq != null) {
            this.hHq.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.hHs != null && threadInfo.post_num != null) {
                String numFormatOver10000 = aq.numFormatOver10000(threadInfo.post_num.longValue());
                this.hHs.setText(getResources().getString(R.string.chosen_pb_reply_number_text, numFormatOver10000));
                this.hHr.AB(getResources().getString(R.string.chosen_pb_reply_count_text, numFormatOver10000));
            }
            this.hHp.a(threadInfo);
            this.hHo.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.hHu.dT(aVar2.getData());
            this.hHu.notifyDataSetChanged();
        }
        this.eUY.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(R.layout.chosen_pb_layout);
        this.ecG = (RelativeLayout) findViewById(R.id.chosen_pb_root);
        this.eUY = (BdListView) findViewById(R.id.chosen_pb_listview);
        this.eUY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.hideSoftKeyPad(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.hHz != null && PbChosenActivity.this.hHz.atZ() != null) {
                    PbChosenActivity.this.hHz.atZ().hide();
                }
                PbChosenActivity.this.hHr.setVisible(true);
                return false;
            }
        });
        this.eUY.setOnScrollListener(this.bfd);
        this.hHu = new com.baidu.tieba.pb.chosen.view.a(getPageContext().getPageActivity());
        this.eUY.setAdapter((ListAdapter) this.hHu);
        this.hHr = new f(findViewById(R.id.chosen_pb_reply));
        this.hHr.M(this.hHC);
        this.hHr.N(this.hHE);
        this.hHo = new d(getPageContext().getPageActivity());
        this.hHp = new e(getPageContext().getPageActivity());
        this.hHq = new c(getPageContext().getPageActivity(), this.hHD);
        this.hHo.a(this.hHH);
        this.hHp.a(this.hHG);
        this.eUY.addHeaderView(this.hHo.bQp());
        BdListViewHelper.a(getActivity(), this.eUY, BdListViewHelper.HeadType.DEFAULT);
        this.eUY.addFooterView(this.hHp.bQq());
        this.eUY.addFooterView(this.hHq.getView());
        aJx();
        registerListener(this.hHJ);
        registerListener(this.hHI);
        this.hHK.setSelfListener(true);
        registerListener(this.hHK);
        registerListener(this.cEu);
        registerListener(this.fwC);
        registerListener(this.hHF);
        bQk();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.KEY_ENTER_RECOMMEND_PB, true);
            this.fvn = new VoiceManager();
            this.fvn.onCreate(getPageContext());
            R(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.hHA && !this.hpa) {
            this.hHA = true;
            showLoadingView(this.ecG, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.eUY == null) {
            return null;
        }
        return this.eUY.getPreLoadHandle();
    }

    private void aJx() {
        this.dkM = (NavigationBar) findViewById(R.id.view_navigation_bar);
        if (this.dkM != null) {
            this.dkM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.dkM.setTitleText(R.string.chosen_pb_title);
            this.hHt = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.chosen_pb_reply_layout, (ViewGroup) null);
            this.hHs = (TextView) this.hHt.findViewById(R.id.chosen_pb_reply_number);
            this.dkM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hHt, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new an("c10091").bS("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").bS("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).O("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).bS("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.hHB)));
                    }
                }
            });
        }
    }

    private void bQk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.hHz != null) {
                this.hHz.onActivityResult(i, i2, intent);
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
        if (this.fvn != null) {
            this.fvn.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> bQl() {
        if (this.gWY == null) {
            this.gWY = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean aut() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData pG(String str) {
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
                public String auu() {
                    return null;
                }
            };
        }
        return this.gWY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().setNightMode(i == 1);
        getPageContext().getLayoutMode().onModeChanged(this.hHo.bQp());
        getPageContext().getLayoutMode().onModeChanged(this.hHp.bQq());
        this.hHq.onChangeSkinType();
        this.hHr.onChangeSkinType();
        if (this.dkM != null) {
            this.dkM.onChangeSkinType(getPageContext(), i);
        }
        if (this.hHz != null && this.hHz.atZ() != null) {
            this.hHz.atZ().onChangeSkinType(i);
        }
        am.setNavbarTitleColor(this.hHs, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setBackgroundColor(this.ecG, R.color.cp_bg_line_d);
        this.hHu.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.hHz == null || this.hHz.atZ() == null || !this.hHz.atZ().aub()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.hHz.atZ().asC();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.hHz != null) {
            this.hHz.onSaveInstanceState(bundle);
        }
        if (this.fvn != null) {
            this.fvn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fvn != null) {
            this.fvn.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fvn != null) {
            this.fvn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fvn != null) {
            this.fvn.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hHz != null) {
            this.hHz.onDestroy();
        }
        if (this.fvn != null) {
            this.fvn.onDestory(getPageContext());
        }
    }

    private void R(Bundle bundle) {
        com.baidu.tbadk.editortools.pb.f fVar = new com.baidu.tbadk.editortools.pb.f();
        fVar.a(bQl());
        this.hHz = (com.baidu.tbadk.editortools.pb.d) fVar.cw(getActivity());
        this.hHz.b(this);
        this.hHz.a(this.cHf);
        this.hHz.a(this.cGY);
        this.hHz.atZ().fe(true);
        this.hHz.a(this, bundle);
        h(this.hHz);
    }

    private void h(com.baidu.tbadk.editortools.pb.d dVar) {
        if (dVar.atZ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ecG.addView(dVar.atZ(), layoutParams);
            dVar.atZ().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fvn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_CHOOSEN;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum != null) {
            pageStayDurationItem.setFid(this.chosenData.getThreadInfo().forum.forum_id.longValue());
            pageStayDurationItem.setTid(this.chosenData.getThreadInfo().thread_id.longValue());
        }
        return pageStayDurationItem;
    }
}
