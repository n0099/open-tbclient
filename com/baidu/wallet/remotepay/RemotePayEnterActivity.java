package com.baidu.wallet.remotepay;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.a.a;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
public class RemotePayEnterActivity extends PayBaseBeanActivity {
    public static final String TAG = "RemotePayEnterActivity";

    /* renamed from: a  reason: collision with root package name */
    public IRemoteServiceCallback f26473a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f26474b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f26475c;

    /* renamed from: d  reason: collision with root package name */
    public String f26476d;

    public void getBundleData(Intent intent) {
        Bundle bundle;
        ArrayList arrayList;
        if (intent == null) {
            return;
        }
        IBinder iBinder = null;
        try {
            bundle = intent.getBundleExtra("caller");
        } catch (Exception unused) {
            bundle = null;
        }
        if (bundle == null) {
            return;
        }
        this.f26476d = bundle.getString("order_info");
        String str = "";
        if (Build.VERSION.SDK_INT < 18) {
            try {
                iBinder = (IBinder) bundle.getClass().getDeclaredMethod("getIBinder", String.class).invoke(bundle, "callback");
            } catch (Exception e2) {
                String str2 = this.f26476d;
                String[] strArr = new String[2];
                Map<String, String> map = this.f26475c;
                strArr[0] = (map == null || map.isEmpty()) ? "" : this.f26475c.get(Constants.KEY_REMOTE_PKG_NAME);
                strArr[1] = e2.getMessage();
                PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_BINDER_CATCH, a.a(str2, strArr));
                e2.printStackTrace();
                finish();
            }
        } else {
            iBinder = bundle.getBinder("callback");
        }
        try {
            this.f26473a = IRemoteServiceCallback.Stub.asInterface(iBinder);
        } catch (Exception e3) {
            String str3 = this.f26476d;
            String[] strArr2 = new String[2];
            Map<String, String> map2 = this.f26475c;
            if (map2 != null && !map2.isEmpty()) {
                str = this.f26475c.get(Constants.KEY_REMOTE_PKG_NAME);
            }
            strArr2[0] = str;
            strArr2[1] = e3.getMessage();
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_INITCALLBACK_CATCH, a.a(str3, strArr2));
            e3.printStackTrace();
            finish();
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("map_params");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0 || (arrayList = (ArrayList) parcelableArrayList.get(0)) == null || arrayList.size() <= 0) {
            return;
        }
        this.f26474b = (Map) arrayList.get(0);
        this.f26475c = (Map) arrayList.get(1);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getBundleData(getIntent());
        String str = this.f26476d;
        String[] strArr = new String[2];
        Map<String, String> map = this.f26475c;
        strArr[0] = (map == null || map.isEmpty()) ? "" : this.f26475c.get(Constants.KEY_REMOTE_PKG_NAME);
        strArr[1] = "activity";
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY, a.a(str, strArr));
        BaiduPayDelegate.getInstance().doRemotePay(this, this.f26476d, new PayCallBack() { // from class: com.baidu.wallet.remotepay.RemotePayEnterActivity.1
            @Override // com.baidu.android.pay.PayCallBack
            public boolean isHideLoadingDialog() {
                try {
                    if (RemotePayEnterActivity.this.f26473a != null) {
                        try {
                            RemotePayEnterActivity.this.f26473a.isHideLoadingDialog();
                        } catch (RemoteException e2) {
                            String str2 = RemotePayEnterActivity.this.f26476d;
                            String[] strArr2 = new String[2];
                            strArr2[0] = (RemotePayEnterActivity.this.f26475c == null || RemotePayEnterActivity.this.f26475c.isEmpty()) ? "" : (String) RemotePayEnterActivity.this.f26475c.get(Constants.KEY_REMOTE_PKG_NAME);
                            strArr2[1] = e2.getMessage();
                            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_CATCH, a.a(str2, strArr2));
                            e2.printStackTrace();
                        }
                    }
                    return false;
                } finally {
                    RemotePayEnterActivity.this.finish();
                }
            }

            @Override // com.baidu.android.pay.PayCallBack
            public void onPayResult(int i, String str2) {
                if (1000 == i) {
                }
                try {
                    if (RemotePayEnterActivity.this.f26473a != null) {
                        try {
                            RemotePayEnterActivity.this.f26473a.onPayEnd(i, str2);
                        } catch (RemoteException e2) {
                            String str3 = RemotePayEnterActivity.this.f26476d;
                            String[] strArr2 = new String[2];
                            strArr2[0] = (RemotePayEnterActivity.this.f26475c == null || RemotePayEnterActivity.this.f26475c.isEmpty()) ? "" : (String) RemotePayEnterActivity.this.f26475c.get(Constants.KEY_REMOTE_PKG_NAME);
                            strArr2[1] = e2.getMessage();
                            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_CATCH, a.a(str3, strArr2));
                            PayCallBackManager.isClientDead = true;
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    RemotePayEnterActivity.this.finish();
                }
            }
        }, this.f26475c);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getBundleData(intent);
        String str = this.f26476d;
        String[] strArr = new String[2];
        Map<String, String> map = this.f26475c;
        strArr[0] = (map == null || map.isEmpty()) ? "" : this.f26475c.get(Constants.KEY_REMOTE_PKG_NAME);
        strArr[1] = "activity";
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY, a.a(str, strArr));
        BaiduPayDelegate.getInstance().doRemotePay(this, this.f26476d, new PayCallBack() { // from class: com.baidu.wallet.remotepay.RemotePayEnterActivity.2
            @Override // com.baidu.android.pay.PayCallBack
            public boolean isHideLoadingDialog() {
                try {
                    if (RemotePayEnterActivity.this.f26473a != null) {
                        try {
                            RemotePayEnterActivity.this.f26473a.isHideLoadingDialog();
                        } catch (RemoteException e2) {
                            String str2 = RemotePayEnterActivity.this.f26476d;
                            String[] strArr2 = new String[2];
                            strArr2[0] = (RemotePayEnterActivity.this.f26475c == null || RemotePayEnterActivity.this.f26475c.isEmpty()) ? "" : (String) RemotePayEnterActivity.this.f26475c.get(Constants.KEY_REMOTE_PKG_NAME);
                            strArr2[1] = e2.getMessage();
                            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_CATCH, a.a(str2, strArr2));
                            e2.printStackTrace();
                        }
                    }
                    return false;
                } finally {
                    RemotePayEnterActivity.this.finish();
                }
            }

            @Override // com.baidu.android.pay.PayCallBack
            public void onPayResult(int i, String str2) {
                if (1000 == i) {
                }
                try {
                    if (RemotePayEnterActivity.this.f26473a != null) {
                        try {
                            RemotePayEnterActivity.this.f26473a.onPayEnd(i, str2);
                        } catch (Exception e2) {
                            String str3 = RemotePayEnterActivity.this.f26476d;
                            String[] strArr2 = new String[2];
                            strArr2[0] = (RemotePayEnterActivity.this.f26475c == null || RemotePayEnterActivity.this.f26475c.isEmpty()) ? "" : (String) RemotePayEnterActivity.this.f26475c.get(Constants.KEY_REMOTE_PKG_NAME);
                            strArr2[1] = e2.getMessage();
                            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_CATCH, a.a(str3, strArr2));
                            PayCallBackManager.isClientDead = true;
                        }
                    }
                } finally {
                    RemotePayEnterActivity.this.finish();
                }
            }
        }, this.f26475c);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
