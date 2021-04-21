package com.baidu.wallet.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.paysdk.ui.PassNormalizeActivity;
import java.util.Map;
/* loaded from: classes5.dex */
public final class PassUtil {
    public static final String NORMALIZE_URL = "normalize_url";
    public static final String PASS_ACCOUNT = "pass_account";
    public static final String PASS_ACCOUNT_TYPE = "pass_account_type";
    public static final String PASS_AUTH_SID = "pass_auth_sid";
    public static final String PASS_BDUSS = "pass_bduss";
    public static final String PASS_DISPLAY_NAME = "pass_display_name";
    public static final String PASS_ERROR_CODE = "pass_error_code";
    public static final String PASS_ERROR_MSG = "pass_error_msg";
    public static final String PASS_NEW_REQ = "pass_new_req";
    public static final String PASS_OPEN_BDUSS = "pass_open_bduss";
    public static final String PASS_PASSWORD = "pass_code";
    public static final String PASS_PTOKEN = "pass_ptoken";
    public static final String PASS_SID = "pass_sid";
    public static final String PASS_STOKEN = "pass_stoken";
    public static final String PASS_TYPE = "pass_util_type";
    public static final String PASS_UBI = "pass_ubi";
    public static final String PASS_UID = "pass_uid";
    public static final String PASS_UNION_ID = "pass_union_id";
    public static final String PASS_USER_NAEME = "pass_user_name";
    public static final int TYPE_COMPLETED = 1;
    public static final int TYPE_VERIFY = 2;

    /* renamed from: a  reason: collision with root package name */
    public static IPassNormalize f23993a;

    /* renamed from: b  reason: collision with root package name */
    public static long f23994b;

    /* renamed from: c  reason: collision with root package name */
    public static IPassNormalize f23995c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f23996d = new Object();

    /* loaded from: classes5.dex */
    public interface IPassNormalize {
        boolean onNormalize(Context context, int i, Map<String, String> map);
    }

    /* loaded from: classes5.dex */
    public static class PassNormalize implements IPassNormalize {
        @Override // com.baidu.wallet.core.utils.PassUtil.IPassNormalize
        public boolean onNormalize(Context context, int i, Map<String, String> map) {
            StringBuilder sb = new StringBuilder();
            sb.append("统一处理正常化 type=");
            sb.append(i);
            sb.append("#map=");
            sb.append(map == null);
            LogUtil.logd(sb.toString());
            if (i == 1 && map != null) {
                String str = map.get("pass_open_bduss");
                if ("0".equals(map.get("pass_error_code")) && !TextUtils.isEmpty(str)) {
                    IPassNormalize iPassNormalize = PassUtil.f23993a;
                    if (iPassNormalize != null) {
                        iPassNormalize.onNormalize(context, i, map);
                    }
                    return true;
                }
            }
            return i == 2 && map != null;
        }
    }

    public static long b() {
        long currentTimeMillis = System.currentTimeMillis() - f23994b;
        LogUtil.logd("wait =" + currentTimeMillis);
        if (currentTimeMillis < 500 && currentTimeMillis > 0) {
            LogUtil.logd("需要wait =" + currentTimeMillis);
            return currentTimeMillis;
        }
        LogUtil.logd("不需要wait");
        return 0L;
    }

    public static void backNormalized(final Context context, final int i, final Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("pass_error_code")) && "0".equals(map.get("pass_error_code"))) {
            SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() { // from class: com.baidu.wallet.core.utils.PassUtil.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                /* renamed from: a */
                public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                    if (PassUtil.f23995c != null) {
                        PassUtil.f23995c.onNormalize(context, i, map);
                    }
                    IPassNormalize unused = PassUtil.f23995c = null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                    WalletLoginHelper.getInstance().getOpenBduss(true, new ILoginBackListener() { // from class: com.baidu.wallet.core.utils.PassUtil.1.1
                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onFail(int i2, String str) {
                            if (PassUtil.f23995c != null) {
                                IPassNormalize iPassNormalize = PassUtil.f23995c;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                iPassNormalize.onNormalize(context, i, map);
                            }
                            IPassNormalize unused = PassUtil.f23995c = null;
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onSuccess(int i2, String str) {
                            map.put("pass_open_bduss", str);
                            if (PassUtil.f23995c != null) {
                                IPassNormalize iPassNormalize = PassUtil.f23995c;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                iPassNormalize.onNormalize(context, i, map);
                            }
                            IPassNormalize unused = PassUtil.f23995c = null;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: c */
                public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                    if (PassUtil.f23995c != null) {
                        PassUtil.f23995c.onNormalize(context, i, map);
                    }
                    IPassNormalize unused = PassUtil.f23995c = null;
                }

                @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
                public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                    if (PassUtil.f23995c != null) {
                        PassUtil.f23995c.onNormalize(context, i, map);
                    }
                    IPassNormalize unused = PassUtil.f23995c = null;
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }
            }, true);
            return;
        }
        IPassNormalize iPassNormalize = f23995c;
        if (iPassNormalize != null) {
            iPassNormalize.onNormalize(context, i, map);
        }
        f23995c = null;
    }

    public static void onCreate() {
        f23994b = System.currentTimeMillis();
    }

    public static void passNormalized(Context context, String str, int i, IPassNormalize iPassNormalize) {
        if (iPassNormalize == null || context == null) {
            return;
        }
        long b2 = b();
        if (b2 > 0) {
            try {
                synchronized (f23996d) {
                    LogUtil.logd("before wait");
                    f23996d.wait(b2);
                    LogUtil.logd("after wait");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        f23995c = iPassNormalize;
        Intent intent = new Intent(context, PassNormalizeActivity.class);
        intent.putExtra("normalize_url", str);
        intent.putExtra("pass_util_type", i);
        context.startActivity(intent);
    }

    public static void registerPassNormalize(IPassNormalize iPassNormalize) {
        f23993a = iPassNormalize;
    }
}
