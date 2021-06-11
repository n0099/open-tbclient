package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BindCardPreCheckActivity extends PayBaseBeanActivity {
    public static final String PARAMS_KEY = "PARAMS_KEY";

    /* renamed from: a  reason: collision with root package name */
    public UserInfoBean f25743a;

    /* renamed from: b  reason: collision with root package name */
    public DirectPayContentResponse f25744b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25745c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f25746d;

    /* renamed from: e  reason: collision with root package name */
    public LoginBackListenerProxy f25747e;

    private void d() {
        String str = null;
        try {
            JSONObject jSONObject = new JSONObject(this.f25746d);
            if (jSONObject.optString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE) != null) {
                str = jSONObject.optString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        PasswordController.getPassWordInstance().checkPwd(this.mAct, BeanConstants.FROM_BIND, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.4
            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onFail(int i2, String str2) {
                BindCardPreCheckActivity.this.a(2, "");
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onSucceed(String str2) {
                BindCardPreCheckActivity.this.e();
            }
        }, str);
        this.f25745c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String str;
        String str2;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(this.f25746d)) {
            str2 = null;
            str3 = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(this.f25746d);
                str = jSONObject.getString(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID);
                try {
                    str4 = jSONObject.getString(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    str2 = str4;
                    str3 = str;
                    BaiduPay.getInstance().bindCard(this.mAct, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.5
                        @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                        public void onChangeFailed(String str5) {
                            BindCardPreCheckActivity.this.a(2, "");
                        }

                        @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                        public void onChangeSucceed(String str5) {
                            BindCardPreCheckActivity.this.a(0, "");
                        }
                    }, PayRequestCache.BindCategory.Initiative, 1, str2, str3, null, null, false, null);
                }
            } catch (JSONException e3) {
                e = e3;
                str = null;
            }
            str2 = str4;
            str3 = str;
        }
        BaiduPay.getInstance().bindCard(this.mAct, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.5
            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeFailed(String str5) {
                BindCardPreCheckActivity.this.a(2, "");
            }

            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeSucceed(String str5) {
                BindCardPreCheckActivity.this.a(0, "");
            }
        }, PayRequestCache.BindCategory.Initiative, 1, str2, str3, null, null, false, null);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 != 6) {
            super.handleFailure(i2, i3, str);
            a(2, "");
        } else if (i3 == 5003) {
            WalletLoginHelper.getInstance().handlerWalletError(5003);
            AccountManager.getInstance(this.mAct.getApplicationContext()).logout();
            WalletLoginHelper.getInstance().logout(false);
            GlobalUtils.toast(this.mAct, str);
            a(2, "");
        } else if (i3 == 100035 || i3 == 100036) {
            PassUtil.passNormalized(getActivity(), str, i3 != 100036 ? 1 : 2, new PassUtil.PassNormalize() { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.2
                @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                    if (super.onNormalize(context, i4, map)) {
                        BindCardPreCheckActivity.this.b();
                        return false;
                    }
                    BindCardPreCheckActivity.this.a(2, "");
                    return false;
                }
            });
        } else if (i3 != 5140 && i3 != 5139) {
            a(2, "");
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk_from", "4");
            hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, i3 == 5140 ? "9" : "0");
            BaiduPayDelegate.getInstance().doRNAuth(this.mAct, hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.3
                @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                public void onRNAuthResult(int i4, String str2) {
                    if (i4 == 0) {
                        BindCardPreCheckActivity.this.b();
                    } else {
                        BindCardPreCheckActivity.this.a(2, "");
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 6) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
            this.f25744b = directPayContentResponse;
            directPayContentResponse.user.decrypt();
            this.f25744b.pay.easypay.decrypt();
            this.f25744b.storeResponse(this.mAct);
            c();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        if (bundle == null) {
            this.f25746d = getIntent().getStringExtra(PARAMS_KEY);
        } else {
            this.f25746d = bundle.getString(PARAMS_KEY);
        }
        this.f25747e = new LoginBackListenerProxy(getActivity(), new ILoginBackListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardPreCheckActivity.1
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BindCardPreCheckActivity.this.f25747e);
                } else {
                    BindCardPreCheckActivity.this.a(2, "");
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                BindCardPreCheckActivity.this.b();
            }
        });
        WalletLoginHelper.getInstance().login(this.f25747e);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f25743a != null) {
            BeanManager.getInstance().removeBean(this.f25743a);
        }
        if (this.f25745c) {
            PasswordController.getPassWordInstance().clearCheckPwdListener();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(PARAMS_KEY, this.f25746d);
    }

    public void setImmersiveActivityMargeinTop() {
        BeanActivity beanActivity;
        if (Build.VERSION.SDK_INT >= 19 && (beanActivity = this.mAct) != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(beanActivity, "welcome_page"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(this.mAct), 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f25743a == null) {
            this.f25743a = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) this.mAct, 6, "BindCardPreCheckActivity");
        }
        this.f25743a.setResponseCallback(this);
        this.f25743a.setCheckPrePassSign(1, "4");
        this.f25743a.execBean();
    }

    private void c() {
        if ("1".equals(this.f25744b.can_bind_card_flag)) {
            if (this.f25744b.user.has_mobile_password == 1) {
                d();
                return;
            } else {
                e();
                return;
            }
        }
        BeanActivity beanActivity = this.mAct;
        GlobalUtils.toast(beanActivity, ResUtils.getString(beanActivity, "bd_wallet_bind_card_number_overrun"));
        a(2, "");
    }

    private void a() {
        setContentView(ResUtils.layout(getActivity(), "wallet_base_layout_loading"));
        AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setImmersiveActivityMargeinTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        finishWithoutAnim();
        if (BaiduPay.getInstance().getBindCallbackExt() != null) {
            BaiduPay.getInstance().getBindCallbackExt().onBindResult(i2, str);
            BaiduPay.getInstance().clearBindCallbackExt();
        }
    }
}
