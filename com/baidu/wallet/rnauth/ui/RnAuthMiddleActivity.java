package com.baidu.wallet.rnauth.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.core.BaseActionBarActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.rnauth.bean.GetRnAuthQueryBean;
import com.baidu.wallet.rnauth.datamodel.RnAuthQueryBeanResponse;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class RnAuthMiddleActivity extends BaseActionBarActivity {

    /* renamed from: f  reason: collision with root package name */
    public static RNAuthCallBack f26489f;

    /* renamed from: a  reason: collision with root package name */
    public TextView f26490a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26491b;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f26493d;

    /* renamed from: c  reason: collision with root package name */
    public final String f26492c = RnAuthMiddleActivity.class.getSimpleName();
    public final int AUTH_STATE_PROCESS = 1;
    public final int AUTH_STATE_UNAUTH = 2;
    public final int AUTH_STATE_UPDATE = 3;

    /* renamed from: e  reason: collision with root package name */
    public int f26494e = 0;

    public static void clearRnAuthCallBack() {
        f26489f = null;
    }

    public static Intent getStartIntent(Context context, HashMap<String, String> hashMap) {
        Intent intent = new Intent(context, RnAuthMiddleActivity.class);
        intent.putExtra("params", hashMap);
        intent.putExtra("with_anim", false);
        return intent;
    }

    public static void setRnAuthCallBack(RNAuthCallBack rNAuthCallBack) {
        f26489f = rNAuthCallBack;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        closeLoadingDialog();
        if (i2 < 0) {
            getErrorViewDelegate().showLocalNetError(new WalletBaseEmptyView.EmptyBtnClickListener() { // from class: com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity.2
                @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                public void onBtnClick() {
                    RnAuthMiddleActivity.this.b();
                }
            });
            return;
        }
        getErrorViewDelegate().showServerNetError(str, new WalletBaseEmptyView.EmptyBtnClickListener() { // from class: com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity.3
            @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
            public void onBtnClick() {
                RnAuthMiddleActivity.this.b();
            }
        });
        super.handleFailure(i, i2, str);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        closeLoadingDialog();
        getErrorViewDelegate().showContentView();
        if (i == 48) {
            RnAuthQueryBeanResponse rnAuthQueryBeanResponse = (RnAuthQueryBeanResponse) obj;
            this.f26491b.setText(rnAuthQueryBeanResponse.button_msg);
            this.f26490a.setText(rnAuthQueryBeanResponse.display_msg);
        }
    }

    @Override // com.baidu.wallet.core.BaseActionBarActivity
    public void init(View view) {
        TextView textView = (TextView) findViewByIdExt(ResUtils.id(getApplicationContext(), "wallet_rn_auth_text_des"));
        this.f26490a = textView;
        textView.setText("");
        TextView textView2 = (TextView) findViewByIdExt(ResUtils.id(getApplicationContext(), "wallet_rn_auth_text_action"));
        this.f26491b = textView2;
        textView2.setText("");
        c();
        getBdActionBar().setTitle(ResUtils.string(getApplicationContext(), "bd_wallet_pay_security_auth"));
        this.f26493d = (HashMap) getIntent().getSerializableExtra("params");
        b();
        EventBus.getInstance().register(this, BeanConstants.EV_EXIT_MIDDLE_AUTH_PAGE, 0, EventBus.ThreadMode.MainThread);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        RNAuthCallBack rNAuthCallBack = f26489f;
        if (rNAuthCallBack != null) {
            rNAuthCallBack.onRNAuthResult(2, "实名认证取消");
            f26489f = null;
        }
    }

    @Override // com.baidu.wallet.core.BaseActionBarActivity
    public int onBindLayoutId() {
        return ResUtils.layout(getApplicationContext(), "wallet_rn_auth_mid_activity");
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LogUtil.e(this.f26492c, MissionEvent.MESSAGE_DESTROY, null);
        BeanManager.getInstance().removeAllBeans(this.f26492c);
        EventBus.getInstance().unregister(this);
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !TextUtils.equals(event.mEventKey, BeanConstants.EV_EXIT_MIDDLE_AUTH_PAGE)) {
            return;
        }
        finishWithoutAnim();
        LogUtil.e(this.f26492c, "onModuleEvent finishWithoutAnim", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        showLoadingDialog();
        GetRnAuthQueryBean getRnAuthQueryBean = (GetRnAuthQueryBean) PayBeanFactory.getInstance().getBean((Context) this, 48, this.f26492c);
        getRnAuthQueryBean.setResponseCallback(this);
        getRnAuthQueryBean.setParams(1);
        getRnAuthQueryBean.execBean();
    }

    private void c() {
        this.f26491b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaiduPayDelegate.getInstance().doRNAuth(RnAuthMiddleActivity.this.getActivity(), RnAuthMiddleActivity.this.f26493d, new RNAuthCallBack() { // from class: com.baidu.wallet.rnauth.ui.RnAuthMiddleActivity.1.1
                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i, String str) {
                        if (RnAuthMiddleActivity.f26489f != null) {
                            RnAuthMiddleActivity.f26489f.onRNAuthResult(i, str);
                            RNAuthCallBack unused = RnAuthMiddleActivity.f26489f = null;
                            RnAuthMiddleActivity.this.finishWithoutAnim();
                            LogUtil.e(RnAuthMiddleActivity.this.f26492c, "onRNAuthResult finishWithoutAnim", null);
                        }
                    }
                });
            }
        });
    }
}
