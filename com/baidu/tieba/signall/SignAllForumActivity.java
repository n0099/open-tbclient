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
import d.a.c.j.e.q;
import d.a.m0.m0.k;
import d.a.m0.r.f0.f;
import d.a.m0.r.s.a;
import d.a.n0.a3.h;
import d.a.n0.a3.j;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class SignAllForumActivity extends BaseActivity<SignAllForumActivity> implements f.g {
    public boolean isBack;
    public boolean isDestory;
    public d.a.m0.r.s.a mDialog;
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
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || num.intValue() != 2) {
                return;
            }
            SignAllForumActivity.this.mView.m().setHasPrivilege(true);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.a3.c h2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (h2 = SignAllForumActivity.this.mView.h()) == null) {
                return;
            }
            h2.E((SignData) customResponsedMessage.getData());
            SignAllForumActivity.this.mView.g().notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements GetForumListModel.b {

        /* loaded from: classes5.dex */
        public class a implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f20555a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f20556b;

            public a(long j, long j2) {
                this.f20555a = j;
                this.f20556b = j2;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                SignAllForumActivity.this.logCostTimeLog(this.f20555a, this.f20556b);
                return false;
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.signall.GetForumListModel.b
        public void a(d.a.n0.a3.c cVar) {
            long currentTimeMillis = System.currentTimeMillis();
            SignAllForumActivity.this.mView.e();
            d.a.n0.a3.a i2 = cVar.i();
            if (i2 != null) {
                if (i2.a() == 0) {
                    SignAllForumActivity.this.mView.o(cVar, SignAllForumActivity.this.mGetForumListModel.z());
                } else {
                    SignAllForumActivity.this.showToast(i2.b(), false);
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
                if (SignAllForumActivity.this.mView == null || SignAllForumActivity.this.mView.m() == null) {
                    return;
                }
                SignAllForumActivity.this.mView.m().setSignBefore(0);
                return;
            }
            d.a.n0.a3.a b2 = hVar.b();
            if (b2 != null) {
                if (b2.a() == 0) {
                    d.a.n0.a3.c h2 = SignAllForumActivity.this.mView.h();
                    h2.D(hVar);
                    if (SignAllForumActivity.this.isBack) {
                        Intent intent = new Intent(SignAllForumActivity.this.getPageContext().getPageActivity(), SignAllForumActivity.class);
                        intent.addFlags(805306368);
                        intent.putExtra("signall_noyify_click", true);
                        SignAllForumActivity.this.showNotification(SignAllForumActivity.this.getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{Integer.valueOf(h2.s()), Integer.valueOf(h2.j())}), PendingIntent.getActivity(SignAllForumActivity.this.getPageContext().getPageActivity(), 0, intent, 134217728), false);
                        if (SignAllForumActivity.this.isDestory) {
                            return;
                        }
                    }
                    SignAllForumActivity.this.mView.g().notifyDataSetChanged();
                    SignAllForumProgressView m = SignAllForumActivity.this.mView.m();
                    if (!h2.A()) {
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
                    m.setSignSuccess();
                    SignAllForumActivity.this.showAdvert(h2);
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
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20560e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20561f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f20562g;

        public f(String str, String str2, boolean z) {
            this.f20560e = str;
            this.f20561f = str2;
            this.f20562g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SignAllForumActivity.this.sendMessage(new CustomMessage(2002001, new SignAllForumAdvertActivityConfig(SignAllForumActivity.this.getPageContext().getPageActivity(), this.f20560e, this.f20561f, Boolean.valueOf(this.f20562g))));
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    private void cancelNotification() {
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndShowTimePicker() {
        if (this.mView != null) {
            d.a.m0.s.d.f.c().a(getPageContext(), this.mView.n());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAlertDialog(String str) {
        d.a.m0.r.s.a positiveButton = new d.a.m0.r.s.a(getPageContext().getPageActivity()).setMessage(str).setPositiveButton(R.string.signallforum_signnow, new g());
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
        jVar.p(this);
        this.mView.r(this);
        SignAllForumModel signAllForumModel = this.mSignAllForumModel;
        if (signAllForumModel.isRunning) {
            this.mOnGetForumListDataCallBack.a(signAllForumModel.y());
            this.mView.m().setSigning(90);
            return;
        }
        this.mView.s();
    }

    private void moveToBack() {
        this.isBack = true;
        Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
        intent.addFlags(805306368);
        showNotification(getPageContext().getString(R.string.signallforum_back_signing), PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdvert(d.a.n0.a3.c cVar) {
        if (cVar == null) {
            return;
        }
        String d2 = cVar.d();
        String e2 = cVar.e();
        boolean B = cVar.B();
        if (cVar.C()) {
            this.mView.q(0);
            new Handler().postDelayed(new f(d2, e2, B), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotification(String str, PendingIntent pendingIntent, boolean z) {
        NotificationHelper.showNotification(getPageContext().getPageActivity(), R.drawable.singnallforum_progress, getPageContext().getString(R.string.app_name), str, str, pendingIntent, z);
    }

    private void signAllForum() {
        d.a.n0.a3.c h2 = this.mView.h();
        this.mView.m().setDuration(Math.max(h2.x().size() * 50, 2000));
        this.mView.m().setSigning(0);
        this.mSignAllForumModel.z(h2);
        this.mSignAllForumModel.LoadData();
        this.mView.g().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signFailed(String str) {
        if (this.isBack) {
            d.a.n0.a3.c h2 = this.mView.h();
            Intent intent = new Intent(getPageContext().getPageActivity(), SignAllForumActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("signall_noyify_click", true);
            PendingIntent activity = PendingIntent.getActivity(getPageContext().getPageActivity(), 0, intent, 134217728);
            str = getPageContext().getPageActivity().getString(R.string.signallforum_back_finish, new Object[]{0, Integer.valueOf(h2.x().size())});
            showNotification(str, activity, false);
            if (this.isDestory) {
                return;
            }
        }
        showToast(str);
        this.mView.m().setSignSuccess();
        ArrayList<d.a.n0.a3.d> x = this.mView.h().x();
        int size = x.size();
        for (int i2 = 0; i2 < size; i2++) {
            d.a.n0.a3.d dVar = x.get(i2);
            dVar.s(true);
            dVar.t(false);
            dVar.u(false);
        }
        this.mView.g().notifyDataSetChanged();
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

    @Override // com.baidu.tbadk.BaseActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a022";
    }

    public void logCostTimeLog(long j, long j2) {
        if (!k.d().g() || this.creatTime <= 0) {
            return;
        }
        new d.a.m0.m0.h(1009, true, this.mGetForumListModel.getResponsedMessage(), 0L, this.creatTime, j2, false, 0L, 0L, j).c();
        this.creatTime = 0L;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        j jVar;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 25050 && (jVar = this.mView) != null) {
            jVar.s();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.onChangeSkinType(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.n0.a3.c h2 = this.mView.h();
        if (view != this.mView.l()) {
            if (view == this.mView.j()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getPageContext().getPageActivity(), 2, "msign", 1);
                memberPayActivityConfig.setSceneId("4007001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_A_KEY_TO_SIGN, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
                sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        } else if (h2 == null) {
        } else {
            if (h2.f() != null) {
                if (h2.f().appeal_status == 1) {
                    BdToast.h(getPageContext().getPageActivity(), h2.f().appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                } else if (AntiHelper.t(getPageContext().getPageActivity(), h2.f(), this.mInjectListener) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
                }
            } else if (this.mView.m().getCurrentStatus() == 2) {
                showToast(R.string.signallforum_finished);
            } else {
                if (h2.o() != 0) {
                    createAlertDialog(h2.p());
                    this.mDialog.show();
                } else if (d.a.c.e.p.j.z()) {
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
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.c.a.b.f().h("MainTabActivity")) {
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
        d.a.n0.d0.a.a(getIntent(), getPageContext(), 25050);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestory = true;
        d.a.m0.r.s.a aVar = this.mDialog;
        if (aVar != null && aVar.isShowing()) {
            this.mDialog.dismiss();
        }
        GetForumListModel getForumListModel = this.mGetForumListModel;
        if (getForumListModel != null) {
            getForumListModel.cancelLoadData();
            this.mGetForumListModel = null;
        }
        j jVar = this.mView;
        if (jVar != null && jVar.g() != null) {
            this.mView.g().d();
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
        if (jVar == null || jVar.k() == null) {
            return null;
        }
        return this.mView.k().getPreLoadHandle();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        d.a.n0.a3.d dVar;
        if (this.mView.g().getItemViewType(i2) != 0 || this.mView.h() == null || this.mView.h().k() == null || this.mView.h().k().size() <= i2 || (dVar = this.mView.h().k().get(i2)) == null) {
            return;
        }
        sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(dVar.d(), "signallforum").setCallFrom(6)));
        TiebaStatic.log("signall_frs_click");
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.refrehStartTime = System.currentTimeMillis();
        if (!d.a.c.e.p.j.z()) {
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
