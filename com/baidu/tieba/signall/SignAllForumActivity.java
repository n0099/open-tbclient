package com.baidu.tieba.signall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.GetForumListModel;
import com.baidu.tieba.signall.SignAllForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.b.j.e.q;
import d.b.h0.m0.k;
import d.b.h0.r.f0.f;
import d.b.h0.r.s.a;
import d.b.i0.y2.h;
import d.b.i0.y2.j;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.g {
    public boolean isBack;
    public boolean isDestory;
    public d.b.h0.r.s.a mDialog;
    public GetForumListModel mGetForumListModel;
    public SignAllForumModel mSignAllForumModel;
    public j mView;
    public boolean isClickAllSign = false;
    public long beginTime = 0;
    public long creatTime = 0;
    public long refrehStartTime = 0;
    public boolean mIsFromSchema = false;
    public final CustomMessageListener mMemListener = new a(2001194);
    public final CustomMessageListener mRefreshSignStateListener = new b(2001222);
    public GetForumListModel.b mOnGetForumListDataCallBack = new c();
    public SignAllForumModel.a mOnSignAllForumCallback = new d();
    public AntiHelper.k mInjectListener = new e();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || num.intValue() != 2) {
                return;
            }
            SignAllForumActivity.this.mView.n().setHasPrivilege(true);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.i0.y2.c i;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (i = SignAllForumActivity.this.mView.i()) == null) {
                return;
            }
            i.E((SignData) customResponsedMessage.getData());
            SignAllForumActivity.this.mView.h().notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements GetForumListModel.b {

        /* loaded from: classes5.dex */
        public class a implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f21135a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f21136b;

            public a(long j, long j2) {
                this.f21135a = j;
                this.f21136b = j2;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                SignAllForumActivity.this.logCostTimeLog(this.f21135a, this.f21136b);
                return false;
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.b
        public void a(d.b.i0.y2.c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.mView.e();
            d.b.i0.y2.a i = cVar.i();
            if (i != null) {
                if (i.a() == 0) {
                    SignAllForumActivity.this.mView.q(cVar, SignAllForumActivity.this.mGetForumListModel.z());
                } else {
                    SignAllForumActivity.this.showToast(i.b(), false);
                    SignAllForumActivity.this.finish();
                }
            }
            Looper.myQueue().addIdleHandler(new a(SignAllForumActivity.this.beginTime > 0 ? System.currentTimeMillis() - SignAllForumActivity.this.beginTime : (System.currentTimeMillis() - SignAllForumActivity.this.refrehStartTime) + SignAllForumActivity.this.creatTime, System.currentTimeMillis() - currentTimeMillis));
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.b
        public void onNetError(String str) {
            SignAllForumActivity.this.mView.e();
            SignAllForumActivity.this.showToast(str, false);
            SignAllForumActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SignAllForumModel.a {
        public d() {
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void a(h hVar) {
            if (hVar == null) {
                return;
            }
            if (hVar.a() == 3250013 && SignAllForumActivity.this.isClickAllSign) {
                SignAllForumActivity.this.isClickAllSign = false;
                BdToast.h(TbadkCoreApplication.getInst().getContext(), hVar.c(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                if (SignAllForumActivity.this.mView == null || SignAllForumActivity.this.mView.n() == null) {
                    return;
                }
                SignAllForumActivity.this.mView.n().setSignBefore(0);
                return;
            }
            d.b.i0.y2.a b2 = hVar.b();
            if (b2 != null) {
                if (b2.a() == 0) {
                    d.b.i0.y2.c i = SignAllForumActivity.this.mView.i();
                    i.D(hVar);
                    if (SignAllForumActivity.this.isBack) {
                        Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                        intent.addFlags(805306368);
                        intent.putExtra("signall_noyify_click", true);
                        SignAllForumActivity.this.showNotification(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(i.s()), Integer.valueOf(i.j())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                        if (SignAllForumActivity.this.isDestory) {
                            return;
                        }
                    }
                    SignAllForumActivity.this.mView.h().notifyDataSetChanged();
                    SignAllForumProgressView n = SignAllForumActivity.this.mView.n();
                    if (!i.A()) {
                        if (hVar.h() != 0) {
                            SignAllForumActivity.this.createAlertDialog(hVar.f());
                            SignAllForumActivity.this.mDialog.show();
                        } else if (hVar.e() != 0) {
                            SignAllForumActivity.this.showToast(hVar.g());
                        } else {
                            SignAllForumActivity.this.showToast(R.string.signallforum_error);
                        }
                    }
                    if (SignAllForumActivity.this.mDialog == null || !SignAllForumActivity.this.mDialog.isShowing()) {
                        SignAllForumActivity.this.checkAndShowTimePicker();
                    }
                    n.setSignSuccess();
                    SignAllForumActivity.this.showAdvert(i);
                    return;
                }
                SignAllForumActivity.this.signFailed(b2.b());
            }
        }

        @Override // com.baidu.tieba.signall.SignAllForumModel.a
        public void onNetError(String str) {
            SignAllForumActivity.this.signFailed(str);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AntiHelper.k {
        public e() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f21141f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f21142g;

        public f(String str, String str2, boolean z) {
            this.f21140e = str;
            this.f21141f = str2;
            this.f21142g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), this.f21140e, this.f21141f, Boolean.valueOf(this.f21142g))));
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    private void cancelNotification() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndShowTimePicker() {
        if (this.mView != null) {
            d.b.h0.s.d.f.c().a(getPageContext(), this.mView.o());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAlertDialog(String str) {
        d.b.h0.r.s.a positiveButton = new d.b.h0.r.s.a(getPageContext().getPageActivity()).setMessage(str).setPositiveButton(R.string.signallforum_signnow, new g());
        this.mDialog = positiveButton;
        positiveButton.create(getPageContext());
    }

    private void initData() {
        GetForumListModel getForumListModel = new GetForumListModel(this);
        this.mGetForumListModel = getForumListModel;
        getForumListModel.A(this.mOnGetForumListDataCallBack);
        SignAllForumModel signAllForumModel = new SignAllForumModel(this);
        this.mSignAllForumModel = signAllForumModel;
        signAllForumModel.A(this.mOnSignAllForumCallback);
    }

    private void initUI() {
        j jVar = new j(this);
        this.mView = jVar;
        jVar.r(this);
        this.mView.u(this);
        SignAllForumModel signAllForumModel = this.mSignAllForumModel;
        if (signAllForumModel.isRunning) {
            this.mOnGetForumListDataCallBack.a(signAllForumModel.y());
            this.mView.n().setSigning(90);
            return;
        }
        this.mView.v();
    }

    private void moveToBack() {
        this.isBack = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        showNotification(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdvert(d.b.i0.y2.c cVar) {
        if (cVar == null) {
            return;
        }
        String d2 = cVar.d();
        String e2 = cVar.e();
        boolean B = cVar.B();
        if (cVar.C()) {
            this.mView.s(0);
            new Handler().postDelayed(new f(d2, e2, B), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotification(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void signAllForum() {
        d.b.i0.y2.c i = this.mView.i();
        this.mView.n().setDuration(Math.max(i.x().size() * 50, 2000));
        this.mView.n().setSigning(0);
        this.mSignAllForumModel.z(i);
        this.mSignAllForumModel.LoadData();
        this.mView.h().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signFailed(String str) {
        if (this.isBack) {
            d.b.i0.y2.c i = this.mView.i();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(i.x().size())});
            showNotification(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.mView.n().setSignSuccess();
        ArrayList<d.b.i0.y2.d> x = this.mView.i().x();
        int size = x.size();
        for (int i2 = 0; i2 < size; i2++) {
            d.b.i0.y2.d dVar = x.get(i2);
            dVar.s(true);
            dVar.t(false);
            dVar.u(false);
        }
        this.mView.h().notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a022";
    }

    public void logCostTimeLog(long j, long j2) {
        if (!k.d().g() || this.creatTime <= 0) {
            return;
        }
        new d.b.h0.m0.h(1009, true, this.mGetForumListModel.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j).c();
        this.creatTime = 0L;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        j jVar;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25050 && (jVar = this.mView) != null) {
            jVar.v();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.i0.y2.c i = this.mView.i();
        if (view != this.mView.m()) {
            if (view == this.mView.k()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
                memberPayActivityConfig.setSceneId("4007001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        } else if (i == null) {
        } else {
            if (i.f() != null) {
                if (i.f().appeal_status == 1) {
                    BdToast.h(getPageContext().getPageActivity(), i.f().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                } else if (AntiHelper.t(getPageContext().getPageActivity(), i.f(), this.mInjectListener) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
                }
            } else if (this.mView.n().getCurrentStatus() == 2) {
                showToast(R.string.signallforum_finished);
            } else {
                if (i.o() != 0) {
                    createAlertDialog(i.p());
                    this.mDialog.show();
                } else if (d.b.b.e.p.j.z()) {
                    this.isClickAllSign = true;
                    signAllForum();
                } else {
                    showToast(R.string.neterror);
                }
                TiebaStatic.log("signall_click");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.beginTime = System.currentTimeMillis();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.b.b.a.b.f().h("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getActivity());
            finish();
            return;
        }
        cancelNotification();
        Intent intent = getIntent();
        if (intent.hasExtra("signall_noyify_click") && intent.getBooleanExtra("signall_noyify_click", false)) {
            TiebaStatic.log("signall_noyify_click");
        }
        registerListener(this.mMemListener);
        registerListener(this.mRefreshSignStateListener);
        initData();
        initUI();
        this.creatTime = System.currentTimeMillis() - this.beginTime;
        d.b.i0.b0.a.a(getIntent(), getPageContext(), 25050);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        d.b.h0.r.s.a aVar = this.mDialog;
        if (aVar != null && aVar.isShowing()) {
            this.mDialog.dismiss();
        }
        GetForumListModel getForumListModel = this.mGetForumListModel;
        if (getForumListModel != null) {
            getForumListModel.cancelLoadData();
            this.mGetForumListModel = null;
        }
        j jVar = this.mView;
        if (jVar != null && jVar.h() != null) {
            this.mView.h().d();
        }
        SignAllForumModel signAllForumModel = this.mSignAllForumModel;
        if (signAllForumModel != null) {
            if (signAllForumModel.isRunning) {
                moveToBack();
            }
            this.mSignAllForumModel.cancelMessage();
            this.mSignAllForumModel = null;
        }
        GetForumListModel getForumListModel2 = this.mGetForumListModel;
        if (getForumListModel2 != null) {
            getForumListModel2.cancelLoadData();
            this.mGetForumListModel = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public q onGetPreLoadListView() {
        j jVar = this.mView;
        if (jVar == null || jVar.l() == null) {
            return null;
        }
        return this.mView.l().getPreLoadHandle();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d.b.i0.y2.d dVar;
        if (this.mView.h().getItemViewType(i) != 0 || this.mView.i() == null || this.mView.i().k() == null || this.mView.i().k().size() <= i || (dVar = this.mView.i().k().get(i)) == null) {
            return;
        }
        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.d(), "signallforum").setCallFrom(6)));
        TiebaStatic.log("signall_frs_click");
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.refrehStartTime = System.currentTimeMillis();
        if (!d.b.b.e.p.j.z()) {
            showToast(R.string.neterror);
            this.mView.e();
            return;
        }
        GetForumListModel getForumListModel = this.mGetForumListModel;
        if (getForumListModel == null) {
            showToast(R.string.neterror);
        } else if (getForumListModel.LoadData()) {
        } else {
            this.mView.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        SignAllForumModel signAllForumModel = this.mSignAllForumModel;
        if (signAllForumModel == null || !signAllForumModel.isRunning) {
            return;
        }
        moveToBack();
    }
}
