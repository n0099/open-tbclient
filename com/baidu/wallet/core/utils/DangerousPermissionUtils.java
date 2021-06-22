package com.baidu.wallet.core.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class DangerousPermissionUtils {
    public static final String DPU_SOURCE_LANGBRIDGE = "wallet_langbridge";

    /* renamed from: a  reason: collision with root package name */
    public static final String f24068a = "dangerous_permission_utils";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, DangerousPermission> f24069b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f24070c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f24071d;

    /* renamed from: e  reason: collision with root package name */
    public int f24072e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24073f;

    /* renamed from: g  reason: collision with root package name */
    public BaiduWalletUtils.IRequestPermissionCallBack f24074g;

    /* renamed from: h  reason: collision with root package name */
    public DangerousPermissionDialog f24075h;

    /* loaded from: classes5.dex */
    public static class DangerousPermission {

        /* renamed from: a  reason: collision with root package name */
        public static final String f24082a = "dp_";

        /* renamed from: b  reason: collision with root package name */
        public Context f24083b;

        /* renamed from: c  reason: collision with root package name */
        public String f24084c;

        /* renamed from: d  reason: collision with root package name */
        public String f24085d;

        /* renamed from: e  reason: collision with root package name */
        public String f24086e;

        /* renamed from: f  reason: collision with root package name */
        public String f24087f;

        public DangerousPermission(Context context, String str, String str2, String str3, String str4) {
            this.f24083b = context.getApplicationContext();
            this.f24084c = str;
            this.f24085d = str2;
            this.f24086e = str3;
            this.f24087f = str4;
        }

        public boolean a() {
            Context context = this.f24083b;
            return ((Boolean) SharedPreferencesUtils.getParam(context, DangerousPermissionUtils.f24068a, f24082a + this.f24084c, Boolean.FALSE)).booleanValue();
        }

        public void b() {
            Context context = this.f24083b;
            SharedPreferencesUtils.setParam(context, DangerousPermissionUtils.f24068a, f24082a + this.f24084c, Boolean.TRUE);
        }

        public String c() {
            return TextUtils.isEmpty(this.f24087f) ? ResUtils.getString(this.f24083b, this.f24086e) : this.f24087f;
        }

        public String d() {
            String str;
            try {
                str = new JSONObject(this.f24085d).optString("positive");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.f24083b, "wallet_base_permission_positive") : str;
        }

        public String e() {
            String str;
            try {
                str = new JSONObject(this.f24085d).optString("negative");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.f24083b, "wallet_base_permission_negative") : str;
        }

        public String getPermission() {
            return this.f24084c;
        }

        public String getTitle() {
            String str;
            try {
                str = new JSONObject(this.f24085d).optString("title");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.f24083b, "wallet_base_permission_title") : str;
        }
    }

    /* loaded from: classes5.dex */
    public static class DangerousPermissionDialog extends PromptDialog {
        public DangerousPermissionDialog(Context context) {
            super(context);
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
        }

        @Override // android.app.Dialog
        public void show() {
            try {
                super.show();
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static DangerousPermissionUtils f24088a = new DangerousPermissionUtils();
    }

    public static DangerousPermissionUtils getInstance() {
        return a.f24088a;
    }

    public void requestPermissionsDialog(String str, Activity activity, String[] strArr, BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack) {
        a(activity);
        if (!a(str) || activity == null) {
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isAllAgree(Boolean.TRUE);
                return;
            }
            return;
        }
        this.f24070c = new WeakReference<>(activity);
        this.f24071d = strArr;
        this.f24072e = -1;
        this.f24073f = true;
        this.f24074g = iRequestPermissionCallBack;
        DangerousPermissionDialog dangerousPermissionDialog = this.f24075h;
        if (dangerousPermissionDialog != null) {
            dangerousPermissionDialog.dismiss();
            this.f24075h = null;
        }
        a();
    }

    public DangerousPermissionUtils() {
    }

    private void a(Context context) {
        if (this.f24069b != null || context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        this.f24069b = hashMap;
        hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
        this.f24069b.put("android.permission.ACCESS_FINE_LOCATION", new DangerousPermission(context, "android.permission.ACCESS_FINE_LOCATION", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
        this.f24069b.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
        this.f24069b.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
        this.f24069b.put(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new DangerousPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
        this.f24069b.put("android.permission.READ_EXTERNAL_STORAGE", new DangerousPermission(context, "android.permission.READ_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
    }

    private boolean a(String str) {
        if (DPU_SOURCE_LANGBRIDGE.equals(str)) {
            return "1".equals(SdkInitResponse.getInstance().langbridge_permission_dialog);
        }
        if ("1".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
            return true;
        }
        if ("0".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
            return false;
        }
        return BeanConstants.CHANNEL_ID_WALLET_APP.equals(BeanConstants.CHANNEL_ID) || "walletapppro".equals(BeanConstants.CHANNEL_ID) || "bdyouqianhuapro".equals(BeanConstants.CHANNEL_ID) || "bdlicai".equals(BeanConstants.CHANNEL_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i2 = this.f24072e + 1;
        this.f24072e = i2;
        String[] strArr = this.f24071d;
        if (i2 >= strArr.length) {
            a(true);
            return;
        }
        final DangerousPermission dangerousPermission = this.f24069b.get(strArr[i2]);
        if (dangerousPermission == null) {
            a();
            return;
        }
        Activity activity = this.f24070c.get();
        if (activity == null) {
            a(false);
            return;
        }
        final DangerousPermissionDialog dangerousPermissionDialog = new DangerousPermissionDialog(activity);
        dangerousPermissionDialog.setTitleText(dangerousPermission.getTitle());
        dangerousPermissionDialog.setMessage(dangerousPermission.c());
        dangerousPermissionDialog.setNegativeBtn(dangerousPermission.e(), new View.OnClickListener() { // from class: com.baidu.wallet.core.utils.DangerousPermissionUtils.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DangerousPermissionUtils.this.f24073f = false;
                if (DangerousPermissionUtils.this.f24074g != null) {
                    DangerousPermissionUtils.this.f24074g.requestResult(dangerousPermission.getPermission(), Boolean.FALSE);
                }
                dangerousPermissionDialog.dismiss();
                DangerousPermissionUtils.this.a();
            }
        });
        dangerousPermissionDialog.setPositiveBtn(dangerousPermission.d(), new View.OnClickListener() { // from class: com.baidu.wallet.core.utils.DangerousPermissionUtils.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DangerousPermissionUtils.this.f24074g != null) {
                    DangerousPermissionUtils.this.f24074g.requestResult(dangerousPermission.getPermission(), Boolean.TRUE);
                }
                dangerousPermissionDialog.dismiss();
                DangerousPermissionUtils.this.a();
            }
        });
        this.f24075h = dangerousPermissionDialog;
        dangerousPermissionDialog.show();
        BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f24074g;
        if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
        }
    }

    private void a(boolean z) {
        BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f24074g;
        if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.f24073f));
        }
        this.f24075h = null;
        this.f24074g = null;
    }
}
