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
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.pb.DataModel;
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
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.c {
    private RelativeLayout bMA;
    private NavigationBar bnG;
    private BdListView cGq;
    private com.baidu.tieba.pb.chosen.net.a chosenData;
    private VoiceManager dhB;
    private DataModel<PbChosenActivity> eAF;
    private d fmU;
    private e fmV;
    private c fmW;
    private f fmX;
    private TextView fmY;
    private View fmZ;
    private com.baidu.tieba.pb.chosen.view.a fna;
    private LikeModel fnb;
    private com.baidu.tieba.pb.chosen.net.zan.a fnc;
    private b fnd;
    private a fne;
    private com.baidu.tbadk.editortools.pb.d fnf;
    private boolean fng;
    private long startTime;
    private String shareUrl = null;
    private boolean cXP = false;
    private boolean eVQ = false;
    private int from = 1;
    private int fnh = -1;
    private final AbsListView.OnScrollListener dZK = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 && PbChosenActivity.this.fnf != null && PbChosenActivity.this.fnf.Hg() != null) {
                PbChosenActivity.this.fnf.Hg().hide();
                PbChosenActivity.this.fmX.setVisible(true);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c aNa = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.11
        @Override // com.baidu.tbadk.editortools.pb.c
        public void HE() {
            PbChosenActivity.this.showProgressBar();
        }
    };
    private View.OnClickListener fni = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.fnf != null && PbChosenActivity.this.fnf.Hg() != null) {
                PbChosenActivity.this.fnf.Hg().oD();
                PbChosenActivity.this.fmX.setVisible(false);
            }
        }
    };
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.fnf.Hg().hide();
                PbChosenActivity.this.fmX.setVisible(true);
                if (postWriteCallBackData != null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData != null && tVar == null && postWriteCallBackData.getErrorCode() != 227001) {
                if (AntiHelper.tE(postWriteCallBackData.getErrorCode())) {
                    AntiHelper.ao(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).xi();
                }
            }
        }
    };
    private c.a fnj = new c.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.14
        @Override // com.baidu.tieba.pb.chosen.view.c.a
        public void rd(String str) {
            if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && !StringUtils.isNull(str)) {
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new am("c10093").ah("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").ah("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ah("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
                PbChosenActivity.this.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
            }
        }
    };
    private View.OnClickListener fnk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new am("pb_new_share").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ah("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.fne == null) {
                    PbChosenActivity.this.fne = new a(PbChosenActivity.this);
                }
                PbChosenActivity.this.fne.a(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    };
    private CustomMessageListener bzI = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(true, customResponsedMessage);
        }
    };
    private CustomMessageListener fnl = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.a(false, customResponsedMessage);
        }
    };
    private e.a fnm = new e.a() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.18
        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void o(long j, String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.fnh)));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new am("pb_new_detail_btn").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ah("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.e.a
        public void jq(boolean z) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                if (PbChosenActivity.this.fnc == null) {
                    PbChosenActivity.this.fnc = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    PbChosenActivity.this.fnc.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
                } else {
                    PbChosenActivity.this.fnc.a(PbChosenActivity.this, PbChosenActivity.this.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new am("pb_new_like").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ah("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    };
    private d.b fnn = new d.b() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2
        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void bN(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void rc(String str) {
            if (!StringUtils.isNull(str)) {
                PbChosenActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().excid != null) {
                    TiebaStatic.log(new am("pb_new_sourcefid").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ah("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }

        @Override // com.baidu.tieba.pb.chosen.view.d.b
        public void baa() {
            if (!j.jD()) {
                BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(d.k.neterror)).xi();
            } else if (PbChosenActivity.this.checkUpIsLogin() && PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null && PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id != null) {
                if (PbChosenActivity.this.fnb == null) {
                    PbChosenActivity.this.fnb = new LikeModel(PbChosenActivity.this.getPageContext());
                }
                PbChosenActivity.this.fnb.setFrom("from_frs");
                PbChosenActivity.this.fnb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.2.1
                    @Override // com.baidu.adp.base.d
                    public void i(Object obj) {
                        if (AntiHelper.tE(PbChosenActivity.this.fnb.getErrorCode())) {
                            AntiHelper.ao(PbChosenActivity.this.getActivity(), PbChosenActivity.this.fnb.getErrorString());
                        }
                    }
                });
                PbChosenActivity.this.fnb.cj(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new am("c10322").ah(ImageViewerConfig.FORUM_ID, PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "").ah("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ah("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a aKt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_FINE_PB, 309093) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
                com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.eVQ = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.a(aVar);
                } else {
                    PbChosenActivity.this.hideLoadingView(PbChosenActivity.this.bMA);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(d.k.neterror) : aVar.getErrorText());
                }
                if (!PbChosenActivity.this.cXP) {
                    PbChosenActivity.this.showNetRefreshView(PbChosenActivity.this.bMA, PbChosenActivity.this.getResources().getString(d.k.error_unkown_try_again), true);
                    PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                    PbChosenActivity.this.fmX.setVisible(false);
                }
            }
        }
    };
    private CustomMessageListener fno = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.fmV.baf();
            PbChosenActivity.this.fmV.fnZ = !PbChosenActivity.this.fmV.fnZ;
            PbChosenActivity.this.fmV.jt(PbChosenActivity.this.fmV.fnZ);
            if (PbChosenActivity.this.fmV.fnZ) {
                PbChosenActivity.this.fnh = 1;
            } else {
                PbChosenActivity.this.fnh = 0;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fnp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.5
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage != null) {
                PbChosenActivity.this.fmV.baf();
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = PbChosenActivity.this.getResources().getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    BdToast.a(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).xi();
                    return;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ChosenZanNetMessage) {
                    ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                    PbChosenActivity.this.fmV.jt(chosenZanNetMessage.isPraise());
                    if (chosenZanNetMessage.isPraise()) {
                        PbChosenActivity.this.fnh = 1;
                    } else {
                        PbChosenActivity.this.fnh = 0;
                    }
                }
            }
        }
    };
    private CustomMessageListener fnq = new CustomMessageListener(2001314) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.eVQ = true;
                    PbChosenActivity.this.a(chosenData);
                }
                if (PbChosenActivity.this.fnd == null) {
                    PbChosenActivity.this.fnd = new b();
                }
                PbChosenActivity.this.fnd.a(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.chosenData != null && this.chosenData.getThreadInfo() != null && this.chosenData.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
                this.fmU.js(z);
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
            if (this.fnd == null) {
                this.fnd = new b();
            }
            this.fnd.a(this, longExtra, longExtra2, longExtra3);
            hideNetRefreshView(this.bMA);
            showLoadingView(this.bMA, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.chosen.net.a aVar) {
        hideLoadingView(this.bMA);
        if (aVar == null || aVar.isEmpty()) {
            showNetRefreshView(this.bMA, getResources().getString(d.k.error_unkown_try_again), true);
            setNetRefreshLayoutMarginTop(false);
            this.fmX.setVisible(false);
            return;
        }
        this.cXP = true;
        this.fmX.setVisible(true);
        this.chosenData = aVar;
        UserInfo userInfo = aVar.getUserInfo();
        if (userInfo != null) {
            this.fmU.a(userInfo);
        }
        if (this.fmW != null) {
            this.fmW.a(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
        }
        ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
        if (threadInfo != null) {
            if (this.fmY != null && threadInfo.post_num != null) {
                String C = ao.C(threadInfo.post_num.longValue());
                this.fmY.setText(getResources().getString(d.k.chosen_pb_reply_number_text, C));
                this.fmX.rf(getResources().getString(d.k.chosen_pb_reply_count_text, C));
            }
            this.fmV.a(threadInfo);
            this.fmU.a(getPageContext().getPageActivity(), threadInfo);
            com.baidu.tieba.pb.b.a aVar2 = new com.baidu.tieba.pb.b.a();
            aVar2.a(getPageContext(), aVar.getThreadInfo().content);
            this.fna.cT(aVar2.getData());
            this.fna.notifyDataSetChanged();
        }
        this.cGq.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(d.i.chosen_pb_layout);
        this.bMA = (RelativeLayout) findViewById(d.g.chosen_pb_root);
        this.cGq = (BdListView) findViewById(d.g.chosen_pb_listview);
        this.cGq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.b(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
                if (PbChosenActivity.this.fnf != null && PbChosenActivity.this.fnf.Hg() != null) {
                    PbChosenActivity.this.fnf.Hg().hide();
                }
                PbChosenActivity.this.fmX.setVisible(true);
                return false;
            }
        });
        this.cGq.setOnScrollListener(this.dZK);
        this.fna = new com.baidu.tieba.pb.chosen.view.a(getPageContext().getPageActivity());
        this.cGq.setAdapter((ListAdapter) this.fna);
        this.fmX = new f(findViewById(d.g.chosen_pb_reply));
        this.fmX.D(this.fni);
        this.fmX.E(this.fnk);
        this.fmU = new com.baidu.tieba.pb.chosen.view.d(getPageContext().getPageActivity());
        this.fmV = new e(getPageContext().getPageActivity());
        this.fmW = new c(getPageContext().getPageActivity(), this.fnj);
        this.fmU.a(this.fnn);
        this.fmV.a(this.fnm);
        this.cGq.addHeaderView(this.fmU.bad());
        BdListViewHelper.a(getActivity(), this.cGq, BdListViewHelper.HeadType.DEFAULT);
        this.cGq.addFooterView(this.fmV.bae());
        this.cGq.addFooterView(this.fmW.getView());
        avi();
        registerListener(this.fnp);
        registerListener(this.fno);
        this.fnq.setSelfListener(true);
        registerListener(this.fnq);
        registerListener(this.aKt);
        registerListener(this.bzI);
        registerListener(this.fnl);
        aZY();
        if (getIntent() != null) {
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_recommend_pb", true);
            this.dhB = new VoiceManager();
            this.dhB.onCreate(getPageContext());
            x(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.fng && !this.eVQ) {
            this.fng = true;
            showLoadingView(this.bMA, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public k onGetPreLoadListView() {
        if (this.cGq == null) {
            return null;
        }
        return this.cGq.getPreLoadHandle();
    }

    private void avi() {
        this.bnG = (NavigationBar) findViewById(d.g.view_navigation_bar);
        if (this.bnG != null) {
            this.bnG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PbChosenActivity.this.finish();
                }
            });
            this.bnG.setTitleText(d.k.chosen_pb_title);
            this.fmZ = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.chosen_pb_reply_layout, (ViewGroup) null);
            this.fmY = (TextView) this.fmZ.findViewById(d.g.chosen_pb_reply_number);
            this.bnG.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fmZ, new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                        TiebaStatic.log(new am("c10091").ah("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").ah("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).ah("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
                        PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.fnh)));
                    }
                }
            });
        }
    }

    private void aZY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new com.baidu.tieba.pb.chosen.cache.b());
        CustomMessage customMessage = new CustomMessage(2001314);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (this.fnf != null) {
                this.fnf.onActivityResult(i, i2, intent);
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
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
    }

    private DataModel<PbChosenActivity> aZZ() {
        if (this.eAF == null) {
            this.eAF = new DataModel<PbChosenActivity>(getPageContext()) { // from class: com.baidu.tieba.pb.chosen.PbChosenActivity.10
                @Override // com.baidu.adp.base.BdBaseModel
                public boolean cancelLoadData() {
                    return false;
                }

                @Override // com.baidu.adp.base.BdBaseModel
                protected boolean LoadData() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public boolean HA() {
                    return false;
                }

                @Override // com.baidu.tbadk.editortools.pb.DataModel
                public WriteData gH(String str) {
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
                public String HB() {
                    return null;
                }
            };
        }
        return this.eAF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getPageContext().getLayoutMode().setNightMode(i == 1);
        getPageContext().getLayoutMode().onModeChanged(this.fmU.bad());
        getPageContext().getLayoutMode().onModeChanged(this.fmV.bae());
        this.fmW.onChangeSkinType();
        this.fmX.onChangeSkinType();
        if (this.bnG != null) {
            this.bnG.onChangeSkinType(getPageContext(), i);
        }
        if (this.fnf != null && this.fnf.Hg() != null) {
            this.fnf.Hg().onChangeSkinType(i);
        }
        al.b(this.fmY, d.C0141d.navi_op_text, d.C0141d.navi_op_text_skin);
        al.j(this.bMA, d.C0141d.cp_bg_line_d);
        this.fna.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.fnf == null || this.fnf.Hg() == null || !this.fnf.Hg().Hj()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.fnf.Hg().FB();
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fnf != null) {
            this.fnf.onSaveInstanceState(bundle);
        }
        if (this.dhB != null) {
            this.dhB.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fnf != null) {
            this.fnf.onDestroy();
        }
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
    }

    private void x(Bundle bundle) {
        com.baidu.tbadk.editortools.pb.f fVar = new com.baidu.tbadk.editortools.pb.f();
        fVar.a(aZZ());
        this.fnf = (com.baidu.tbadk.editortools.pb.d) fVar.aY(getActivity());
        this.fnf.b(this);
        this.fnf.a(this.aNh);
        this.fnf.a(this.aNa);
        this.fnf.Hg().bB(true);
        this.fnf.a(this, bundle);
        h(this.fnf);
    }

    private void h(com.baidu.tbadk.editortools.pb.d dVar) {
        if (dVar.Hg() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bMA.addView(dVar.Hg(), layoutParams);
            dVar.Hg().hide();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dhB;
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
