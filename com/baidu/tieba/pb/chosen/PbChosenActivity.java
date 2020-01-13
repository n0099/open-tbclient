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
import com.baidu.tbadk.coreExtra.data.z;
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
/* loaded from: classes8.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private NavigationBar dXN;
    private BdListView fLY;
    private VoiceManager gmi;
    private DataModel<PbChosenActivity> hNM;
    private d iyf;
    private e iyg;
    private c iyh;
    private f iyi;
    private TextView iyj;
    private View iyk;
    private com.baidu.tieba.pb.chosen.view.a iyl;
    private LikeModel iym;
    private com.baidu.tieba.pb.chosen.net.zan.a iyn;
    private b iyo;
    private a iyp;
    private com.baidu.tbadk.editortools.pb.e iyq;
    private boolean iyr;
    private RelativeLayout rootView;
    private long startTime;
    private String shareUrl = null;
    private boolean gbO = false;
    private boolean ifS = false;
    private int from = 1;
    private int iys = -1;
    private final AbsListView.OnScrollListener bIg = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.iyq != null && PbChosenActivity.this.iyq.aLV() != null) {
                PbChosenActivity.this.iyq.aLV().hide();
                PbChosenActivity.this.iyi.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dum = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aMt() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener iyt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.iyq != null && PbChosenActivity.this.iyq.aLV() != null) {
                PbChosenActivity.this.iyq.aLV().display();
                PbChosenActivity.this.iyi.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.iyq.aLV().hide();
                PbChosenActivity.this.iyi.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && zVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.bc(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                    AntiHelper.bn(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).aCu();
                }
            }
        }
    };
    private c.a iyu = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.view.c.a
        public void Fq(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new an("c10093").cp("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").cp("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).Z("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).cp("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener iyv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new an("pb_new_share").Z("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).cp("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.iyp == null) {
                    PbChosenActivity.this.iyp = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.iyp.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener gnq = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener iyw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a iyx = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void r(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.iys)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new an("pb_new_detail_btn").Z("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).cp("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void pm(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.iyn == null) {
                    PbChosenActivity.this.iyn = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.iyn.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.iyn.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new an("pb_new_like").Z("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).cp("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b iyy = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void dU(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void Fp(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new an("pb_new_sourcefid").Z("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).cp("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void ciD() {
            if (!j.isNetWorkAvailable()) {
                BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(R.string.neterror)).aCu();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.iym == null) {
                    PbChosenActivity.this.iym = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.iym.setFrom("from_frs");
                PbChosenActivity.this.iym.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void callback(Object obj) {
                        if (AntiHelper.bc(PbChosenActivity.this.iym.getErrorCode(), PbChosenActivity.this.iym.getErrorString())) {
                            AntiHelper.bn(PbChosenActivity.this.getActivity(), PbChosenActivity.this.iym.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.iym.et(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new an("c10322").cp("fid", PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").cp("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").Z("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).cp("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a drL = new com.baidu.adp.framework.listener.a(1003006, CmdConfigSocket.CMD_GET_FINE_PB) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.ifS = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.rootView);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(R.string.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.gbO) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.rootView, PbChosenActivity.this.getResources().getString(R.string.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.iyi.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener iyz = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.iyg.ciI();
            PbChosenActivity.this.iyg.izk = !PbChosenActivity.this.iyg.izk;
            PbChosenActivity.this.iyg.pp(PbChosenActivity.this.iyg.izk);
            if (PbChosenActivity.this.iyg.izk) {
                PbChosenActivity.this.iys = 1;
            } else {
                PbChosenActivity.this.iys = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iyA = new com.baidu.adp.framework.listener.a(1003007, CmdConfigSocket.CMD_CHOSEN_PB_PRAISE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.iyg.ciI();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.b(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).aCu();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.iyg.pp(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.iys = 1;
                    } else {
                        PbChosenActivity.this.iys = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener iyB = new CustomMessageListener(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.ifS = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.iyo == null) {
                    PbChosenActivity.this.iyo = new b();
                }
                PbChosenActivity.this.iyo.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.iyf.po(z);
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
            if (this.iyo == null) {
                this.iyo = new b();
            }
            this.iyo.a(this, longExtra, longExtra2, longExtra3);
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
            this.iyi.setVisible(false);
            return;
        }
        this.gbO = true;
        this.iyi.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.iyf.a(userInfo);
        }
        if (this.iyh != null) {
            this.iyh.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.iyj != null && threadInfo.post_num != null) {
                String numFormatOver10000 = aq.numFormatOver10000(threadInfo.post_num.longValue());
                this.iyj.setText(getResources().getString(R.string.chosen_pb_reply_number_text, numFormatOver10000));
                this.iyi.Fs(getResources().getString(R.string.chosen_pb_reply_count_text, numFormatOver10000));
            }
            this.iyg.a(threadInfo);
            this.iyf.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.iyl.dI(aVar2.getData());
            this.iyl.notifyDataSetChanged();
        }
        this.fLY.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(R.layout.chosen_pb_layout);
        this.rootView = (RelativeLayout) findViewById(R.id.chosen_pb_root);
        this.fLY = (BdListView) findViewById(R.id.chosen_pb_listview);
        this.fLY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.hideSoftKeyPad(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.iyq != null && PbChosenActivity.this.iyq.aLV() != null) {
                    PbChosenActivity.this.iyq.aLV().hide();
                }
                PbChosenActivity.this.iyi.setVisible(true);
                return false;
            }
        });
        this.fLY.setOnScrollListener(this.bIg);
        this.iyl = new com.baidu.tieba.pb.chosen.view.a(getPageContext().getPageActivity());
        this.fLY.setAdapter((ListAdapter) this.iyl);
        this.iyi = new f(findViewById(R.id.chosen_pb_reply));
        this.iyi.M(this.iyt);
        this.iyi.N(this.iyv);
        this.iyf = new d(getPageContext().getPageActivity());
        this.iyg = new e(getPageContext().getPageActivity());
        this.iyh = new c(getPageContext().getPageActivity(), this.iyu);
        this.iyf.a(this.iyy);
        this.iyg.a(this.iyx);
        this.fLY.addHeaderView(this.iyf.ciG());
        BdListViewHelper.a(getActivity(), this.fLY, BdListViewHelper.HeadType.DEFAULT);
        this.fLY.addFooterView(this.iyg.ciH());
        this.fLY.addFooterView(this.iyh.getView());
        bas();
        registerListener(this.iyA);
        registerListener(this.iyz);
        this.iyB.setSelfListener(true);
        registerListener(this.iyB);
        registerListener(this.drL);
        registerListener(this.gnq);
        registerListener(this.iyw);
        ciB();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_ENTER_RECOMMEND_PB, true);
            this.gmi = new VoiceManager();
            this.gmi.onCreate(getPageContext());
            ak(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.iyr && !this.ifS) {
            this.iyr = true;
            showLoadingView(this.rootView, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.fLY == null) {
            return null;
        }
        return this.fLY.getPreLoadHandle();
    }

    private void bas() {
        this.dXN = (NavigationBar) findViewById(R.id.view_navigation_bar);
        if (this.dXN != null) {
            this.dXN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.dXN.setTitleText(R.string.chosen_pb_title);
            this.iyk = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.chosen_pb_reply_layout, (ViewGroup) null);
            this.iyj = (TextView) this.iyk.findViewById(R.id.chosen_pb_reply_number);
            this.dXN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iyk, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new an("c10091").cp("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").cp("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).Z("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).cp("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.iys)));
                    }
                }
            });
        }
    }

    private void ciB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.iyq != null) {
                this.iyq.onActivityResult(i, i2, intent);
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
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> ciC() {
        if (this.hNM == null) {
            this.hNM = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean aMp() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData uR(String str) {
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
                public String aMq() {
                    return null;
                }
            };
        }
        return this.hNM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().setNightMode(i == 1);
        getPageContext().getLayoutMode().onModeChanged(this.iyf.ciG());
        getPageContext().getLayoutMode().onModeChanged(this.iyg.ciH());
        this.iyh.onChangeSkinType();
        this.iyi.onChangeSkinType();
        if (this.dXN != null) {
            this.dXN.onChangeSkinType(getPageContext(), i);
        }
        if (this.iyq != null && this.iyq.aLV() != null) {
            this.iyq.aLV().onChangeSkinType(i);
        }
        am.setNavbarTitleColor(this.iyj, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.iyl.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.iyq == null || this.iyq.aLV() == null || !this.iyq.aLV().aLX()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.iyq.aLV().aKs();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.iyq != null) {
            this.iyq.onSaveInstanceState(bundle);
        }
        if (this.gmi != null) {
            this.gmi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iyq != null) {
            this.iyq.onDestroy();
        }
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
    }

    private void ak(Bundle bundle) {
        g gVar = new g();
        gVar.a(ciC());
        this.iyq = (com.baidu.tbadk.editortools.pb.e) gVar.dR(getActivity());
        this.iyq.a(getPageContext());
        this.iyq.a(this.dut);
        this.iyq.a(this.dum);
        this.iyq.aLV().gu(true);
        this.iyq.a(getPageContext(), bundle);
        i(this.iyq);
    }

    private void i(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar.aLV() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.rootView.addView(eVar.aLV(), layoutParams);
            eVar.aLV().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gmi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
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
