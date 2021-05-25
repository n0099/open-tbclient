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
    public static final String f23883a = "dangerous_permission_utils";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, DangerousPermission> f23884b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f23885c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f23886d;

    /* renamed from: e  reason: collision with root package name */
    public int f23887e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23888f;

    /* renamed from: g  reason: collision with root package name */
    public BaiduWalletUtils.IRequestPermissionCallBack f23889g;

    /* renamed from: h  reason: collision with root package name */
    public DangerousPermissionDialog f23890h;

    /* loaded from: classes5.dex */
    public static class DangerousPermission {

        /* renamed from: a  reason: collision with root package name */
        public static final String f23897a = "dp_";

        /* renamed from: b  reason: collision with root package name */
        public Context f23898b;

        /* renamed from: c  reason: collision with root package name */
        public String f23899c;

        /* renamed from: d  reason: collision with root package name */
        public String f23900d;

        /* renamed from: e  reason: collision with root package name */
        public String f23901e;

        /* renamed from: f  reason: collision with root package name */
        public String f23902f;

        public DangerousPermission(Context context, String str, String str2, String str3, String str4) {
            this.f23898b = context.getApplicationContext();
            this.f23899c = str;
            this.f23900d = str2;
            this.f23901e = str3;
            this.f23902f = str4;
        }

        public boolean a() {
            Context context = this.f23898b;
            return ((Boolean) SharedPreferencesUtils.getParam(context, DangerousPermissionUtils.f23883a, f23897a + this.f23899c, Boolean.FALSE)).booleanValue();
        }

        public void b() {
            Context context = this.f23898b;
            SharedPreferencesUtils.setParam(context, DangerousPermissionUtils.f23883a, f23897a + this.f23899c, Boolean.TRUE);
        }

        public String c() {
            return TextUtils.isEmpty(this.f23902f) ? ResUtils.getString(this.f23898b, this.f23901e) : this.f23902f;
        }

        public String d() {
            String str;
            try {
                str = new JSONObject(this.f23900d).optString("positive");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.f23898b, "wallet_base_permission_positive") : str;
        }

        public String e() {
            String str;
            try {
                str = new JSONObject(this.f23900d).optString("negative");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.f23898b, "wallet_base_permission_negative") : str;
        }

        public String getPermission() {
            return this.f23899c;
        }

        public String getTitle() {
            String str;
            try {
                str = new JSONObject(this.f23900d).optString("title");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.f23898b, "wallet_base_permission_title") : str;
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
        public static DangerousPermissionUtils f23903a = new DangerousPermissionUtils();
    }

    public static DangerousPermissionUtils getInstance() {
        return a.f23903a;
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
        this.f23885c = new WeakReference<>(activity);
        this.f23886d = strArr;
        this.f23887e = -1;
        this.f23888f = true;
        this.f23889g = iRequestPermissionCallBack;
        DangerousPermissionDialog dangerousPermissionDialog = this.f23890h;
        if (dangerousPermissionDialog != null) {
            dangerousPermissionDialog.dismiss();
            this.f23890h = null;
        }
        a();
    }

    public DangerousPermissionUtils() {
    }

    private void a(Context context) {
        if (this.f23884b != null || context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        this.f23884b = hashMap;
        hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
        this.f23884b.put("android.permission.ACCESS_FINE_LOCATION", new DangerousPermission(context, "android.permission.ACCESS_FINE_LOCATION", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
        this.f23884b.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
        this.f23884b.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
        this.f23884b.put(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new DangerousPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
        this.f23884b.put("android.permission.READ_EXTERNAL_STORAGE", new DangerousPermission(context, "android.permission.READ_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
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
        int i2 = this.f23887e + 1;
        this.f23887e = i2;
        String[] strArr = this.f23886d;
        if (i2 >= strArr.length) {
            a(true);
            return;
        }
        final DangerousPermission dangerousPermission = this.f23884b.get(strArr[i2]);
        if (dangerousPermission == null) {
            a();
            return;
        }
        Activity activity = this.f23885c.get();
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
                DangerousPermissionUtils.this.f23888f = false;
                if (DangerousPermissionUtils.this.f23889g != null) {
                    DangerousPermissionUtils.this.f23889g.requestResult(dangerousPermission.getPermission(), Boolean.FALSE);
                }
                dangerousPermissionDialog.dismiss();
                DangerousPermissionUtils.this.a();
            }
        });
        dangerousPermissionDialog.setPositiveBtn(dangerousPermission.d(), new View.OnClickListener() { // from class: com.baidu.wallet.core.utils.DangerousPermissionUtils.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DangerousPermissionUtils.this.f23889g != null) {
                    DangerousPermissionUtils.this.f23889g.requestResult(dangerousPermission.getPermission(), Boolean.TRUE);
                }
                dangerousPermissionDialog.dismiss();
                DangerousPermissionUtils.this.a();
            }
        });
        this.f23890h = dangerousPermissionDialog;
        dangerousPermissionDialog.show();
        BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f23889g;
        if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
        }
    }

    private void a(boolean z) {
        BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f23889g;
        if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.f23888f));
        }
        this.f23890h = null;
        this.f23889g = null;
    }
}
