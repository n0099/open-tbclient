package com.baidu.wallet.personal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.f;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.widget.NoScrollViewPager;
import com.baidu.wallet.paysdk.ui.widget.tablayout.CommonTabLayout;
import com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity;
import com.baidu.wallet.paysdk.ui.widget.tablayout.callback.OnTabSelectListener;
import com.baidu.wallet.personal.datamodel.BankCardTabEntity;
import com.baidu.wallet.personal.datamodel.CardRedEemMasResp;
import com.baidu.wallet.personal.storage.CardListCache;
import com.baidu.wallet.personal.storage.a;
import com.baidu.wallet.personal.ui.fragment.BankCardListFragment;
import com.baidu.wallet.personal.ui.fragment.EemCardListFragment;
import com.baidu.wallet.personal.ui.fragment.adapter.CardListFragmentPageAdapter;
import com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class BankCardListActivity extends PayBaseBeanActivity implements View.OnClickListener, OnTabSelectListener, CardListBaseFragment.a {
    public static final String BEAN_TAG = "BankCardListActivity";
    public static final String EVENT_BANK_CARD_BIND_SUCCESS = "ev_bank_card_bind_success";
    public static final String EVT_PAY_PWD_CHANGE = "walletpay_forgot_password";

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f27088a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27089b;

    /* renamed from: e  reason: collision with root package name */
    public CommonTabLayout f27092e;

    /* renamed from: f  reason: collision with root package name */
    public f f27093f;

    /* renamed from: g  reason: collision with root package name */
    public NoScrollViewPager f27094g;
    public List<CardListBaseFragment> k;

    /* renamed from: c  reason: collision with root package name */
    public String[] f27090c = {"银行卡", "电子卡"};

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ICustomTabEntity> f27091d = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f27095h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27096i = false;
    public boolean j = false;
    public boolean l = false;
    public boolean m = false;
    public BaiduPay.IBindCardCallback n = new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.personal.ui.BankCardListActivity.1
        @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
        public void onChangeFailed(String str) {
        }

        @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
        public void onChangeSucceed(String str) {
            if (BankCardListActivity.this.f27096i && BankCardListActivity.this.f27088a != null && BankCardListActivity.this.f27088a.getVisibility() == 0) {
                BankCardListActivity.this.f27088a.setVisibility(8);
            }
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            eventBus.post(new EventBus.Event(BankCardListActivity.EVENT_BANK_CARD_BIND_SUCCESS, str));
        }
    };

    private void c() {
        if (this.f27093f == null) {
            this.f27093f = (f) PayBeanFactory.getInstance().getBean((Context) getActivity(), 606, BEAN_TAG);
        }
        this.f27093f.setResponseCallback(this);
        this.f27093f.execBean();
    }

    private void d() {
        int i2 = 0;
        while (true) {
            String[] strArr = this.f27090c;
            if (i2 >= strArr.length) {
                return;
            }
            this.f27091d.add(new BankCardTabEntity(i2, strArr[i2]));
            i2++;
        }
    }

    private void e() {
        Activity activity = getActivity();
        boolean b2 = a.b(activity, "key_user_click_card_eem_msg" + CardListCache.getInstance().getUserId(), Boolean.FALSE);
        Activity activity2 = getActivity();
        boolean b3 = a.b(activity2, "key_user_click_card_eem_msg" + CardListCache.getInstance().getUserIdV2(), Boolean.FALSE);
        if (b2 && !b3) {
            Activity activity3 = getActivity();
            a.a(activity3, "key_user_click_card_eem_msg" + CardListCache.getInstance().getUserIdV2(), Boolean.TRUE);
            Activity activity4 = getActivity();
            a.a(activity4, "key_user_click_card_eem_msg" + CardListCache.getInstance().getUserId(), Boolean.FALSE);
        }
        if (!b2 && !b3) {
            Activity activity5 = getActivity();
            String d2 = a.d(activity5, "key_card_eem_msg" + CardListCache.getInstance().getUserId(), "");
            Activity activity6 = getActivity();
            String d3 = a.d(activity6, "key_card_eem_msg" + CardListCache.getInstance().getUserIdV2(), "");
            if (TextUtils.isEmpty(d2) || !TextUtils.isEmpty(d3)) {
                d2 = d3;
            } else {
                Activity activity7 = getActivity();
                a.c(activity7, "key_card_eem_msg" + CardListCache.getInstance().getUserIdV2(), d2);
                Activity activity8 = getActivity();
                a.c(activity8, "key_card_eem_msg" + CardListCache.getInstance().getUserId(), "");
            }
            this.f27092e.setTabTitleTipMsg(1, true, d2);
            return;
        }
        this.f27092e.setTabTitleTipMsg(1, false, "");
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.a
    public void bindCard() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.BDL_KEY_BANKINFO_EXTRA, !this.f27095h);
        BaiduPay.getInstance().bindCard(this.mAct, this.n, PayRequestCache.BindCategory.Initiative, 1, "", null, bundle, null, true, BeanConstants.FROM_BIND);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 606) {
            LogUtil.i(BEAN_TAG, str);
        } else {
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        if (i2 != 606 || obj == null) {
            return;
        }
        CardRedEemMasResp cardRedEemMasResp = (CardRedEemMasResp) obj;
        if (TextUtils.isEmpty(cardRedEemMasResp.msgCode)) {
            return;
        }
        Activity activity = getActivity();
        String b2 = a.b(activity, "key_card_eem_msg_code" + CardListCache.getInstance().getUserId(), "");
        Activity activity2 = getActivity();
        String b3 = a.b(activity2, "key_card_eem_msg_code" + CardListCache.getInstance().getUserIdV2(), "");
        if (TextUtils.isEmpty(b2) || !TextUtils.isEmpty(b3)) {
            b2 = b3;
        } else {
            Activity activity3 = getActivity();
            a.a(activity3, "key_card_eem_msg_code" + CardListCache.getInstance().getUserIdV2(), b2);
            Activity activity4 = getActivity();
            a.a(activity4, "key_card_eem_msg_code" + CardListCache.getInstance().getUserId(), "");
        }
        if (!b2.equals(cardRedEemMasResp.msgCode)) {
            this.f27092e.setTabTitleTipMsg(1, true, cardRedEemMasResp.notice_msg);
            if (TextUtils.isEmpty(CardListCache.getInstance().getUserIdV2())) {
                return;
            }
            Activity activity5 = getActivity();
            a.a(activity5, "key_card_eem_msg_code" + CardListCache.getInstance().getUserIdV2(), cardRedEemMasResp.msgCode);
            Activity activity6 = getActivity();
            a.c(activity6, "key_card_eem_msg" + CardListCache.getInstance().getUserIdV2(), cardRedEemMasResp.notice_msg);
            Activity activity7 = getActivity();
            a.a(activity7, "key_user_click_card_eem_msg" + CardListCache.getInstance().getUserIdV2(), Boolean.FALSE);
            Activity activity8 = getActivity();
            a.a(activity8, "key_user_click_card_eem_msg" + CardListCache.getInstance().getUserId(), Boolean.FALSE);
            return;
        }
        e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f27089b) {
            this.m = true;
            BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
            Activity activity = getActivity();
            baiduWalletDelegate.openH5Module(activity, DomainConfig.getInstance().getMHost() + BeanConstants.API_FIND_PASS, false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CommonTabLayout commonTabLayout = this.f27092e;
        if (commonTabLayout != null) {
            commonTabLayout.setIsFirstDraw(true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this, "wallet_personal_bank_cards"));
        d();
        b();
        initActionBar("wallet_base_my_bank_card");
        getBdActionBar().setTitleSize(DisplayUtils.dip2px(getActivity(), 18.0f));
        ((ImageView) findViewById(ResUtils.id(this.mAct, "title_bottom_seperator"))).setVisibility(8);
        CommonTabLayout commonTabLayout = (CommonTabLayout) findViewById(ResUtils.id(getActivity(), "bank_card_list_tab_layout"));
        this.f27092e = commonTabLayout;
        commonTabLayout.setTabData(this.f27091d);
        this.f27092e.setOnTabSelectListener(this);
        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) findViewById(ResUtils.id(getActivity(), "bank_card_list_view_pager"));
        this.f27094g = noScrollViewPager;
        noScrollViewPager.setScanScroll(false);
        this.f27088a = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "bd_wallet_pwd_set_layout"));
        TextView textView = (TextView) findViewById(ResUtils.id(this.mAct, "bd_wallet_setpwd_img"));
        this.f27089b = textView;
        textView.setOnClickListener(this);
        c();
        a();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(BEAN_TAG);
        PayRequestCache.getInstance().removeBeanRequestFromCache(PayRequestCache.BindCategory.Initiative.name());
        if (this.j) {
            PasswordController.getPassWordInstance().clearBindCardCallback();
        }
        if (this.l) {
            PasswordController.getPassWordInstance().clearCheckPwdListener();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.m) {
            this.m = false;
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            eventBus.post(new EventBus.Event(CardListBaseFragment.EVENT_NEED_SYNC_SERVER_DATA, ""));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.tablayout.callback.OnTabSelectListener
    public void onTabSelect(int i2) {
        CommonTabLayout commonTabLayout;
        NoScrollViewPager noScrollViewPager = this.f27094g;
        if (noScrollViewPager != null) {
            noScrollViewPager.setCurrentItem(i2);
        }
        if (i2 == 1 && (commonTabLayout = this.f27092e) != null && commonTabLayout.isMsgTipsShowing(i2)) {
            this.f27092e.setTabTitleTipMsg(i2, false, "");
            Activity activity = getActivity();
            a.a(activity, "key_user_click_card_eem_msg" + CardListCache.getInstance().getUserIdV2(), Boolean.TRUE);
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.a
    public void setBankCardDetectEnabled(boolean z) {
        this.f27095h = z;
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.a
    public void setNoBankCardAndPwdFlag(boolean z) {
        this.f27096i = z;
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.a
    public void showPwdLayout(boolean z) {
        RelativeLayout relativeLayout = this.f27088a;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
    }

    private void a() {
        this.f27094g.setAdapter(new CardListFragmentPageAdapter(getSupportFragmentManager(), this.k));
    }

    private void b() {
        this.k = new ArrayList();
        BankCardListFragment bankCardListFragment = new BankCardListFragment();
        bankCardListFragment.setCallback(this);
        EemCardListFragment eemCardListFragment = new EemCardListFragment();
        eemCardListFragment.setCallback(this);
        this.k.add(bankCardListFragment);
        this.k.add(eemCardListFragment);
    }
}
