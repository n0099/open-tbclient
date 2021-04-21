package com.baidu.tieba.pb.chosen;

import android.app.Activity;
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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.b.i0.s.c.h0;
import d.b.j0.d2.g.d.c;
import d.b.j0.d2.g.d.d;
import d.b.j0.d2.g.d.e;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.j {
    public static final String CHOSEN_PB_TABLE_NAME = "chosen_pb_page_cache";
    public static final String FROM_CHOSEN_PB = "from_chosen_pb";
    public static final String FROM_FRS = "from_frs";
    public static final String ST_TYPE = "pb_chosen";
    public d.b.j0.d2.g.d.a adapter;
    public LikeModel attentionModel;
    public d.b.j0.d2.g.c.a chosenData;
    public d.b.j0.d2.g.d.c commentView;
    public d.b.j0.d2.g.a dialog;
    public boolean isShowLoading;
    public BdListView listView;
    public DataModel<PbChosenActivity> mDataModel;
    public d.b.i0.w.w.e mEditor;
    public VoiceManager mVoiceManager;
    public NavigationBar navigationBar;
    public d.b.j0.d2.g.c.b pbModel;
    public d.b.j0.d2.g.d.d personInfoView;
    public d.b.j0.d2.g.d.e postInfoView;
    public View replyNumberRoot;
    public TextView replyNumberView;
    public d.b.j0.d2.g.d.f replyView;
    public RelativeLayout rootView;
    public long startTime;
    public d.b.j0.d2.g.c.c.a zanModel;
    public String shareUrl = null;
    public boolean hasData = false;
    public boolean isDataLoaded = false;
    public int from = 1;
    public int praiseData = -1;
    public final AbsListView.OnScrollListener mScrollListener = new j();
    public d.b.i0.w.w.c mPrePostCallBack = new k();
    public View.OnClickListener replyClickListener = new l();
    public final NewWriteModel.g mOnPostWriteCallback = new m();
    public c.a commentCallback = new n();
    public View.OnClickListener shareListener = new o();
    public CustomMessageListener attentionListener = new p(2001335);
    public CustomMessageListener unAttentionListener = new q(2001336);
    public e.c postCallback = new r();
    public d.e personInfoCallback = new a();
    public d.b.c.c.g.a netListener = new b(CmdConfigHttp.CMD_GET_FINE_PB, 309093);
    public CustomMessageListener pbNativeZanListener = new c(2004004);
    public d.b.c.c.g.a zanListener = new d(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095);
    public CustomMessageListener cacheReadListener = new e(2001314);

    /* loaded from: classes3.dex */
    public class a implements d.e {

        /* renamed from: com.baidu.tieba.pb.chosen.PbChosenActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0218a extends d.b.c.a.e {
            public C0218a() {
            }

            @Override // d.b.c.a.e
            public void c(Object obj) {
                if (AntiHelper.m(PbChosenActivity.this.attentionModel.getErrorCode(), PbChosenActivity.this.attentionModel.getErrorString())) {
                    AntiHelper.u(PbChosenActivity.this.getActivity(), PbChosenActivity.this.attentionModel.getErrorString());
                }
            }
        }

        public a() {
        }

        @Override // d.b.j0.d2.g.d.d.e
        public void a(String str) {
            if (StringUtils.isNull(str)) {
                return;
            }
            PbChosenActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createNormalCfg(str, PbChosenActivity.FROM_CHOSEN_PB)));
            if (PbChosenActivity.this.chosenData == null || PbChosenActivity.this.chosenData.getThreadInfo() == null || PbChosenActivity.this.chosenData.getThreadInfo().excid == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("pb_new_sourcefid").param("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).param("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
        }

        @Override // d.b.j0.d2.g.d.d.e
        public void b(String str, String str2) {
            PbChosenActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity(), str, str2)));
        }

        @Override // d.b.j0.d2.g.d.d.e
        public void c() {
            if (!d.b.c.e.p.j.z()) {
                BdToast.c(PbChosenActivity.this.getPageContext().getPageActivity(), PbChosenActivity.this.getResources().getString(R.string.neterror)).q();
            } else if (!PbChosenActivity.this.checkUpIsLogin() || PbChosenActivity.this.chosenData == null || PbChosenActivity.this.chosenData.getThreadInfo() == null || PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id == null) {
            } else {
                if (PbChosenActivity.this.attentionModel == null) {
                    PbChosenActivity pbChosenActivity = PbChosenActivity.this;
                    pbChosenActivity.attentionModel = new LikeModel(pbChosenActivity.getPageContext());
                }
                PbChosenActivity.this.attentionModel.setFrom("from_frs");
                PbChosenActivity.this.attentionModel.setLoadDataCallBack(new C0218a());
                PbChosenActivity.this.attentionModel.H(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_name, String.valueOf(PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id));
                if (PbChosenActivity.this.chosenData == null || PbChosenActivity.this.chosenData.getThreadInfo() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c10322");
                StatisticItem param = statisticItem.param("fid", PbChosenActivity.this.chosenData.getThreadInfo().forum.forum_id + "");
                TiebaStatic.log(param.param("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").param("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).param("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof d.b.j0.d2.g.c.a) {
                d.b.j0.d2.g.c.a aVar = (d.b.j0.d2.g.c.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                PbChosenActivity.this.isDataLoaded = true;
                if (erroCode == 0) {
                    PbChosenActivity.this.updateViews(aVar);
                } else {
                    PbChosenActivity pbChosenActivity = PbChosenActivity.this;
                    pbChosenActivity.hideLoadingView(pbChosenActivity.rootView);
                    PbChosenActivity.this.showToast(StringUtils.isNull(aVar.getErrorText()) ? PbChosenActivity.this.getResources().getString(R.string.neterror) : aVar.getErrorText());
                }
                if (PbChosenActivity.this.hasData) {
                    return;
                }
                String string = PbChosenActivity.this.getResources().getString(R.string.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = PbChosenActivity.this;
                pbChosenActivity2.showNetRefreshView(pbChosenActivity2.rootView, string, true);
                PbChosenActivity.this.setNetRefreshLayoutMarginTop(false);
                PbChosenActivity.this.replyView.e(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.postInfoView.n();
            PbChosenActivity.this.postInfoView.f54212h = !PbChosenActivity.this.postInfoView.f54212h;
            PbChosenActivity.this.postInfoView.m(PbChosenActivity.this.postInfoView.f54212h);
            if (PbChosenActivity.this.postInfoView.f54212h) {
                PbChosenActivity.this.praiseData = 1;
            } else {
                PbChosenActivity.this.praiseData = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.c.c.g.a {
        public d(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (responsedMessage == null) {
                return;
            }
            PbChosenActivity.this.postInfoView.n();
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = PbChosenActivity.this.getResources().getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                BdToast.c(PbChosenActivity.this.getPageContext().getPageActivity(), errorString).q();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                PbChosenActivity.this.postInfoView.m(chosenZanNetMessage.isPraise());
                if (chosenZanNetMessage.isPraise()) {
                    PbChosenActivity.this.praiseData = 1;
                } else {
                    PbChosenActivity.this.praiseData = 0;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && PbChosenActivity.this.getIntent() != null) {
                long longExtra = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = PbChosenActivity.this.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = PbChosenActivity.this.getIntent().getLongExtra("thread_id", 0L);
                d.b.j0.d2.g.c.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    PbChosenActivity.this.isDataLoaded = true;
                    PbChosenActivity.this.updateViews(chosenData);
                }
                if (PbChosenActivity.this.pbModel == null) {
                    PbChosenActivity.this.pbModel = new d.b.j0.d2.g.c.b();
                }
                PbChosenActivity.this.pbModel.c(PbChosenActivity.this, longExtra, longExtra2, longExtra3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            d.b.c.e.p.l.w(PbChosenActivity.this.getActivity(), PbChosenActivity.this.getCurrentFocus());
            if (PbChosenActivity.this.mEditor != null && PbChosenActivity.this.mEditor.a() != null) {
                PbChosenActivity.this.mEditor.a().o();
            }
            PbChosenActivity.this.replyView.e(true);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbChosenActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData == null || PbChosenActivity.this.chosenData.getThreadInfo() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c10091");
            TiebaStatic.log(statisticItem.param("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").param("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).param("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).param("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            PbActivityConfig pbActivityConfig = new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity());
            PbChosenActivity.this.sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPbChosen(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", PbChosenActivity.this.praiseData)));
        }
    }

    /* loaded from: classes3.dex */
    public class i extends DataModel<PbChosenActivity> {
        public i(d.b.c.a.f fVar) {
            super(fVar);
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean LoadData() {
            return false;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            return false;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String s() {
            return null;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData t(String str) {
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
        public boolean u() {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements AbsListView.OnScrollListener {
        public j() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 || PbChosenActivity.this.mEditor == null || PbChosenActivity.this.mEditor.a() == null) {
                return;
            }
            PbChosenActivity.this.mEditor.a().o();
            PbChosenActivity.this.replyView.e(true);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements d.b.i0.w.w.c {
        public k() {
        }

        @Override // d.b.i0.w.w.c
        public void a() {
            PbChosenActivity.this.showProgressBar();
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!PbChosenActivity.this.checkUpIsLogin() || PbChosenActivity.this.mEditor == null || PbChosenActivity.this.mEditor.a() == null) {
                return;
            }
            PbChosenActivity.this.mEditor.a().j();
            PbChosenActivity.this.replyView.e(false);
        }
    }

    /* loaded from: classes3.dex */
    public class m implements NewWriteModel.g {
        public m() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            PbChosenActivity.this.hideProgressBar();
            if (z) {
                PbChosenActivity.this.mEditor.a().o();
                PbChosenActivity.this.replyView.e(true);
                if (postWriteCallBackData != null) {
                    d.b.j0.d3.q0.g.b(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
            } else if (postWriteCallBackData == null || h0Var != null || postWriteCallBackData.getErrorCode() == 227001 || d.b.j0.n3.a.c(postWriteCallBackData.getErrorCode())) {
            } else {
                if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                    AntiHelper.u(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                } else {
                    BdToast.c(PbChosenActivity.this.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).q();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements c.a {
        public n() {
        }

        @Override // d.b.j0.d2.g.d.c.a
        public void a(String str) {
            if (!PbChosenActivity.this.checkUpIsLogin() || PbChosenActivity.this.chosenData == null || PbChosenActivity.this.chosenData.getThreadInfo() == null || StringUtils.isNull(str)) {
                return;
            }
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                StatisticItem statisticItem = new StatisticItem("c10093");
                TiebaStatic.log(statisticItem.param("tid", PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "").param("obj_name", PbChosenActivity.this.chosenData.getThreadInfo().tag_name).param("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).param("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            PbChosenActivity.this.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(PbChosenActivity.this.chosenData.getThreadInfo().thread_id + "", str, PbChosenActivity.ST_TYPE, true, null, true)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PbChosenActivity.this.chosenData != null && PbChosenActivity.this.chosenData.getThreadInfo() != null) {
                TiebaStatic.log(new StatisticItem("pb_new_share").param("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).param("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
            }
            if (PbChosenActivity.this.checkUpIsLogin()) {
                if (PbChosenActivity.this.from == 2) {
                    TiebaStatic.log("c10148");
                }
                if (PbChosenActivity.this.dialog == null) {
                    PbChosenActivity pbChosenActivity = PbChosenActivity.this;
                    pbChosenActivity.dialog = new d.b.j0.d2.g.a(pbChosenActivity);
                }
                PbChosenActivity.this.dialog.f(PbChosenActivity.this.chosenData, PbChosenActivity.this.shareUrl);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p extends CustomMessageListener {
        public p(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.handleAttentionResponse(true, customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public class q extends CustomMessageListener {
        public q(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PbChosenActivity.this.handleAttentionResponse(false, customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public class r implements e.c {
        public r() {
        }

        @Override // d.b.j0.d2.g.d.e.c
        public void a(long j, String str) {
            if (StringUtils.isNull(str)) {
                return;
            }
            PbChosenActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbChosenActivity.this.getPageContext().getPageActivity()).createCfgForPbChosen(str, PbChosenActivity.this.praiseData)));
            if (PbChosenActivity.this.chosenData == null || PbChosenActivity.this.chosenData.getThreadInfo() == null || PbChosenActivity.this.chosenData.getThreadInfo().excid == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("pb_new_detail_btn").param("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).param("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
        }

        @Override // d.b.j0.d2.g.d.e.c
        public void b(boolean z) {
            if (PbChosenActivity.this.chosenData == null || PbChosenActivity.this.chosenData.getThreadInfo() == null || PbChosenActivity.this.chosenData.getThreadInfo().excid == null) {
                return;
            }
            if (PbChosenActivity.this.zanModel == null) {
                PbChosenActivity.this.zanModel = new d.b.j0.d2.g.c.c.a();
            }
            if (z) {
                d.b.j0.d2.g.c.c.a aVar = PbChosenActivity.this.zanModel;
                PbChosenActivity pbChosenActivity = PbChosenActivity.this;
                aVar.c(pbChosenActivity, pbChosenActivity.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 2);
            } else {
                d.b.j0.d2.g.c.c.a aVar2 = PbChosenActivity.this.zanModel;
                PbChosenActivity pbChosenActivity2 = PbChosenActivity.this;
                aVar2.c(pbChosenActivity2, pbChosenActivity2.chosenData.getThreadInfo().excid.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().thread_id.longValue(), PbChosenActivity.this.chosenData.getThreadInfo().post_id.longValue(), 1);
            }
            TiebaStatic.log(new StatisticItem("pb_new_like").param("obj_source", PbChosenActivity.this.chosenData.getThreadInfo().source.intValue()).param("abtest", PbChosenActivity.this.chosenData.getThreadInfo().abtest));
        }
    }

    private DataModel<PbChosenActivity> getPbEditorModel() {
        if (this.mDataModel == null) {
            this.mDataModel = new i(getPageContext());
        }
        return this.mDataModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAttentionResponse(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        d.b.j0.d2.g.c.a aVar;
        if (customResponsedMessage == null || (aVar = this.chosenData) == null || aVar.getThreadInfo() == null || this.chosenData.getThreadInfo().forum.forum_id == null) {
            return;
        }
        Object data = customResponsedMessage.getData();
        if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
            this.personInfoView.f(z);
        }
    }

    private void initEditor(Bundle bundle) {
        d.b.i0.w.w.g gVar = new d.b.i0.w.w.g();
        gVar.q(getPbEditorModel());
        d.b.i0.w.w.e eVar = (d.b.i0.w.w.e) gVar.a(getActivity());
        this.mEditor = eVar;
        eVar.e0(getPageContext());
        this.mEditor.n0(this.mOnPostWriteCallback);
        this.mEditor.o0(this.mPrePostCallBack);
        this.mEditor.a().C(true);
        this.mEditor.F(getPageContext(), bundle);
        setEditor(this.mEditor);
    }

    private void initNavigationBar() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.navigationBar = navigationBar;
        if (navigationBar == null) {
            return;
        }
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g());
        this.navigationBar.setTitleText(R.string.chosen_pb_title);
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.chosen_pb_reply_layout, (ViewGroup) null);
        this.replyNumberRoot = inflate;
        this.replyNumberView = (TextView) inflate.findViewById(R.id.chosen_pb_reply_number);
        this.navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.replyNumberRoot, new h());
    }

    private void sendReadCacheMessage() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new d.b.j0.d2.g.b.b());
        CustomMessage customMessage = new CustomMessage(2001314);
        customMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
    }

    private void setEditor(d.b.i0.w.w.e eVar) {
        if (eVar.a() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.rootView.addView(eVar.a(), layoutParams);
            eVar.a().o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViews(d.b.j0.d2.g.c.a aVar) {
        Long l2;
        hideLoadingView(this.rootView);
        if (aVar != null && !aVar.isEmpty()) {
            this.hasData = true;
            this.replyView.e(true);
            this.chosenData = aVar;
            UserInfo userInfo = aVar.getUserInfo();
            if (userInfo != null) {
                this.personInfoView.j(userInfo);
            }
            d.b.j0.d2.g.d.c cVar = this.commentView;
            if (cVar != null) {
                cVar.d(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
            }
            ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
            if (threadInfo != null) {
                if (this.replyNumberView != null && (l2 = threadInfo.post_num) != null) {
                    String numFormatOver10000 = StringHelper.numFormatOver10000(l2.longValue());
                    this.replyNumberView.setText(getResources().getString(R.string.chosen_pb_reply_number_text, numFormatOver10000));
                    this.replyView.c(getResources().getString(R.string.chosen_pb_reply_count_text, numFormatOver10000));
                }
                this.postInfoView.o(threadInfo);
                this.personInfoView.k(getPageContext().getPageActivity(), threadInfo);
                d.b.j0.d2.l.a aVar2 = new d.b.j0.d2.l.a();
                aVar2.c(getPageContext(), aVar.getThreadInfo().content);
                this.adapter.d(aVar2.a());
                this.adapter.notifyDataSetChanged();
            }
            this.listView.setVisibility(0);
            return;
        }
        showNetRefreshView(this.rootView, getResources().getString(R.string.error_unkown_try_again), true);
        setNetRefreshLayoutMarginTop(false);
        this.replyView.e(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a013";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.b.i0.k0.d getPageStayDurationItem() {
        d.b.j0.d2.g.c.a aVar;
        d.b.i0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && (aVar = this.chosenData) != null && aVar.getThreadInfo() != null && this.chosenData.getThreadInfo().forum != null) {
            pageStayDurationItem.q(this.chosenData.getThreadInfo().forum.forum_id.longValue());
            pageStayDurationItem.y(this.chosenData.getThreadInfo().thread_id.longValue());
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            return;
        }
        d.b.i0.w.w.e eVar = this.mEditor;
        if (eVar != null) {
            eVar.H(i2, i3, intent);
        }
        if (i2 == 23003) {
            d.b.j0.d2.g.a.d(this, this.chosenData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
        } else if (i2 != 23007) {
        } else {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            d.b.j0.d2.g.a.e(this, this.chosenData, longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2, this.shareUrl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getPageContext().getLayoutMode().k(i2 == 1);
        getPageContext().getLayoutMode().j(this.personInfoView.c());
        getPageContext().getLayoutMode().j(this.postInfoView.h());
        this.commentView.c();
        this.replyView.a();
        NavigationBar navigationBar = this.navigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i2);
        }
        d.b.i0.w.w.e eVar = this.mEditor;
        if (eVar != null && eVar.a() != null) {
            this.mEditor.a().w(i2);
        }
        SkinManager.setNavbarTitleColor(this.replyNumberView, R.color.navi_op_text, R.color.navi_op_text_skin);
        SkinManager.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.adapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(true);
        setContentView(R.layout.chosen_pb_layout);
        this.rootView = (RelativeLayout) findViewById(R.id.chosen_pb_root);
        BdListView bdListView = (BdListView) findViewById(R.id.chosen_pb_listview);
        this.listView = bdListView;
        bdListView.setOnTouchListener(new f());
        this.listView.setOnScrollListener(this.mScrollListener);
        d.b.j0.d2.g.d.a aVar = new d.b.j0.d2.g.d.a(getPageContext().getPageActivity());
        this.adapter = aVar;
        this.listView.setAdapter((ListAdapter) aVar);
        d.b.j0.d2.g.d.f fVar = new d.b.j0.d2.g.d.f(findViewById(R.id.chosen_pb_reply));
        this.replyView = fVar;
        fVar.b(this.replyClickListener);
        this.replyView.d(this.shareListener);
        this.personInfoView = new d.b.j0.d2.g.d.d(getPageContext().getPageActivity());
        this.postInfoView = new d.b.j0.d2.g.d.e(getPageContext().getPageActivity());
        this.commentView = new d.b.j0.d2.g.d.c(getPageContext().getPageActivity(), this.commentCallback);
        this.personInfoView.g(this.personInfoCallback);
        this.postInfoView.i(this.postCallback);
        this.listView.addHeaderView(this.personInfoView.c());
        BdListViewHelper.d(getActivity(), this.listView, BdListViewHelper.HeadType.DEFAULT);
        this.listView.addFooterView(this.postInfoView.h());
        this.listView.addFooterView(this.commentView.b());
        initNavigationBar();
        registerListener(this.zanListener);
        registerListener(this.pbNativeZanListener);
        this.cacheReadListener.setSelfListener(true);
        registerListener(this.cacheReadListener);
        registerListener(this.netListener);
        registerListener(this.attentionListener);
        registerListener(this.unAttentionListener);
        sendReadCacheMessage();
        if (getIntent() == null) {
            return;
        }
        this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
        this.from = getIntent().getIntExtra("from", 1);
        this.startTime = SystemClock.elapsedRealtime();
        if (this.from == 2) {
            TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
        }
        d.b.i0.r.d0.b.j().t("key_enter_recommend_pb", true);
        VoiceManager voiceManager = new VoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onCreate(getPageContext());
        initEditor(bundle);
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.w.w.e eVar = this.mEditor;
        if (eVar != null) {
            eVar.I();
        }
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public d.b.c.j.e.q onGetPreLoadListView() {
        BdListView bdListView = this.listView;
        if (bdListView == null) {
            return null;
        }
        return bdListView.getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        d.b.i0.w.w.e eVar;
        if (i2 == 4 && (eVar = this.mEditor) != null && eVar.a() != null && this.mEditor.a().u()) {
            this.mEditor.a().q();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (getIntent() == null) {
            return;
        }
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        long longExtra2 = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
        long longExtra3 = getIntent().getLongExtra("thread_id", 0L);
        if (this.pbModel == null) {
            this.pbModel = new d.b.j0.d2.g.c.b();
        }
        this.pbModel.c(this, longExtra, longExtra2, longExtra3);
        hideNetRefreshView(this.rootView);
        showLoadingView(this.rootView, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        d.b.i0.w.w.e eVar = this.mEditor;
        if (eVar != null) {
            eVar.K(bundle);
        }
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        d.b.j0.d2.g.c.a aVar = this.chosenData;
        if (aVar != null && aVar.getThreadInfo() != null && this.chosenData.getThreadInfo().excid != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.startTime;
            Activity pageActivity = getPageContext().getPageActivity();
            TiebaStatic.eventStat(pageActivity, "pb_new_duration", null, 1, "duration", elapsedRealtime + "", PbChosenActivityConfig.KEY_TID, this.chosenData.getThreadInfo().excid);
        }
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.isShowLoading || this.isDataLoaded) {
            return;
        }
        this.isShowLoading = true;
        showLoadingView(this.rootView, true);
    }
}
