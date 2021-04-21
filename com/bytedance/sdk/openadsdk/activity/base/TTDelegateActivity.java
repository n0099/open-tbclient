package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.h;
import com.bytedance.sdk.openadsdk.utils.u;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TTDelegateActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public Intent f27070a;

    /* renamed from: b  reason: collision with root package name */
    public AlertDialog f27071b;

    /* renamed from: c  reason: collision with root package name */
    public TTAdDislike f27072c;

    /* renamed from: d  reason: collision with root package name */
    public e f27073d;

    /* renamed from: e  reason: collision with root package name */
    public d f27074e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.widget.a f27075f;

    /* renamed from: g  reason: collision with root package name */
    public b f27076g;

    /* loaded from: classes5.dex */
    public static class a extends g {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.downloadnew.a.g.a();
            k.j(p.a());
        }
    }

    private void c(String str) {
        if (str != null && this.f27072c == null) {
            try {
                com.bytedance.sdk.openadsdk.dislike.b bVar = new com.bytedance.sdk.openadsdk.dislike.b(this, c.a(new JSONObject(str)));
                this.f27072c = bVar;
                bVar.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.12
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onRefuse() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str2) {
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        TTAdDislike tTAdDislike = this.f27072c;
        if (tTAdDislike != null) {
            tTAdDislike.showDislikeDialog(0);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
        this.f27070a = getIntent();
        if (p.a() == null) {
            p.a(this);
        }
        com.bytedance.sdk.openadsdk.h.a.a().a(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            if (this.f27071b != null && this.f27071b.isShowing()) {
                this.f27071b.dismiss();
            }
            if (this.f27074e != null && this.f27074e.isShowing()) {
                this.f27074e.dismiss();
            }
            if (this.f27075f != null && this.f27075f.isShowing()) {
                this.f27075f.dismiss();
            }
            if (this.f27076g != null && this.f27076g.isShowing()) {
                this.f27076g.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (p.a() == null) {
            p.a(this);
        }
        try {
            setIntent(intent);
            this.f27070a = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, iArr);
        com.bytedance.sdk.openadsdk.l.e.a(new a("onRequestPermissionsResult"), 1);
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            b();
        }
    }

    private void b() {
        try {
            if (this.f27070a == null) {
                return;
            }
            int intExtra = this.f27070a.getIntExtra("type", 0);
            String stringExtra = this.f27070a.getStringExtra("app_download_url");
            this.f27070a.getStringExtra(DpStatConstants.KEY_APP_NAME);
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    c();
                    break;
                case 3:
                    a(stringExtra, this.f27070a.getStringExtra("dialog_title_key"), this.f27070a.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    b(this.f27070a.getStringExtra("permission_id_key"), this.f27070a.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    a(stringExtra, this.f27070a.getStringExtra("dialog_title_key"), this.f27070a.getStringExtra("dialog_content_key"), this.f27070a.getStringExtra("dialog_btn_yes_key"), this.f27070a.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    c(this.f27070a.getStringExtra("materialmeta"));
                    break;
                case 7:
                    if (this.f27070a != null) {
                        a(this.f27070a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f27070a.getStringExtra("dialog_title_key"), this.f27070a.getStringExtra("dialog_app_manage_model_icon_url"), this.f27070a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                        break;
                    }
                    break;
                case 8:
                    a(this.f27070a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f27070a.getStringExtra("dialog_title_key"), this.f27070a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                    break;
                case 9:
                    b(this.f27070a.getStringExtra("dialog_app_manage_model"));
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception unused) {
            finish();
        }
    }

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.1
                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a(Throwable th) {
                    u.b("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                TTCustomController e2 = i.d().e();
                boolean isCanUseLocation = e2.isCanUseLocation();
                boolean isCanUsePhoneState = e2.isCanUsePhoneState();
                boolean isCanUseWriteExternal = e2.isCanUseWriteExternal();
                ArrayList arrayList = new ArrayList();
                if (isCanUseLocation) {
                    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (isCanUsePhoneState) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (isCanUseWriteExternal) {
                    arrayList.add(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.f.e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.6
                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a() {
                        com.bytedance.sdk.openadsdk.l.e.a(new a("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a(String str) {
                        "android.permission.READ_PHONE_STATE".equals(str);
                        com.bytedance.sdk.openadsdk.l.e.a(new a("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        u.b(TTAdConstant.TAG, "已经有Read phone state权限");
        finish();
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = p.a();
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra("type", 3);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str2);
        intent.putExtra("dialog_content_key", str3);
        com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z) {
        if (context == null) {
            context = p.a();
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra("type", 7);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str3);
        intent.putExtra("dialog_app_manage_model", str2);
        intent.putExtra("dialog_app_manage_model_icon_url", str4);
        intent.putExtra("dialog_app_detail_is_download_type", z);
        com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
    }

    public static void a(Context context, String str, String str2, String str3, boolean z) {
        if (context == null) {
            context = p.a();
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra("type", 8);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str3);
        intent.putExtra("dialog_app_detail_is_download_type", z);
        intent.putExtra("dialog_app_manage_model", str2);
        com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
    }

    private void b(String str) {
        try {
            if (this.f27076g != null) {
                this.f27076g.dismiss();
            }
            com.bytedance.sdk.openadsdk.core.widget.b bVar = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
            this.f27076g = bVar;
            bVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.10
                @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                public void a(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.f27076g.show();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final String str2, String str3, boolean z) {
        try {
            if (this.f27075f != null) {
                this.f27075f.dismiss();
            }
            com.bytedance.sdk.openadsdk.core.widget.a aVar = new com.bytedance.sdk.openadsdk.core.widget.a(this, str);
            this.f27075f = aVar;
            aVar.a(str3).a(new a.InterfaceC0319a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.11
                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0319a
                public void a(Dialog dialog) {
                    com.bytedance.sdk.openadsdk.utils.g.a(str2);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0319a
                public void b(Dialog dialog) {
                    if (TTDelegateActivity.this.f27075f != null) {
                        TTDelegateActivity.this.f27075f.dismiss();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0319a
                public void c(Dialog dialog) {
                    TTDelegateActivity.this.a(str);
                }
            });
            this.f27075f.a(z);
            this.f27075f.show();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str) {
        if (context == null) {
            context = p.a();
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra("type", 9);
        intent.putExtra("dialog_app_manage_model", str);
        com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
    }

    private void b(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.f.e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.2
                        @Override // com.bytedance.sdk.openadsdk.core.f.e
                        public void a() {
                            h.a(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.f.e
                        public void a(String str2) {
                            h.a(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            }
            u.b(TTAdConstant.TAG, "已经有权限");
            finish();
            return;
        }
        finish();
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = p.a();
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra("type", 5);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str2);
        intent.putExtra("dialog_content_key", str3);
        intent.putExtra("dialog_btn_yes_key", str4);
        intent.putExtra("dialog_btn_no_key", str5);
        com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
    }

    public static void a(Context context, l lVar) {
        if (context == null) {
            context = p.a();
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra("type", 6);
        intent.putExtra("materialmeta", lVar.aL().toString());
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void a(final String str, final String str2, final String str3, String str4, final boolean z) {
        String str5;
        String str6;
        com.bytedance.sdk.openadsdk.core.d.c b2;
        try {
            String str7 = "";
            if (TextUtils.isEmpty(str) || (b2 = c.b(new JSONObject(str))) == null) {
                str5 = "";
                str6 = str5;
            } else {
                str7 = b2.b();
                str6 = b2.c();
                str5 = b2.g();
                if (TextUtils.isEmpty(str5)) {
                    str5 = str3;
                }
            }
            if (this.f27074e == null || !this.f27074e.isShowing()) {
                d a2 = new d(this).a(str5).b(str7).c(str4).d(str6).a(new d.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.7
                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void a(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.utils.g.a(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void b(Dialog dialog) {
                        TTDelegateActivity.this.b(str, str2, str3, z);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void c(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.utils.g.c(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void d(Dialog dialog) {
                        TTDelegateActivity.this.a(str);
                    }
                });
                this.f27074e = a2;
                a2.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void a(final String str, final String str2, String str3, boolean z) {
        try {
            if (this.f27075f == null || !this.f27075f.isShowing()) {
                com.bytedance.sdk.openadsdk.core.widget.a aVar = new com.bytedance.sdk.openadsdk.core.widget.a(this, str);
                this.f27075f = aVar;
                aVar.a(str3).a(new a.InterfaceC0319a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.8
                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0319a
                    public void a(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.utils.g.a(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0319a
                    public void b(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.utils.g.c(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0319a
                    public void c(Dialog dialog) {
                        TTDelegateActivity.this.a(str);
                    }
                });
                this.f27075f.a(z);
                this.f27075f.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            if (this.f27076g != null) {
                this.f27076g.dismiss();
            }
            com.bytedance.sdk.openadsdk.core.widget.b bVar = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
            this.f27076g = bVar;
            bVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                public void a(Dialog dialog) {
                    if (TTDelegateActivity.this.f27076g != null) {
                        TTDelegateActivity.this.f27076g.dismiss();
                    }
                }
            });
            this.f27076g.show();
        } catch (Throwable unused) {
        }
    }

    private void a(final String str, String str2, String str3, String str4, String str5) {
        AlertDialog alertDialog = this.f27071b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (this.f27073d == null) {
            this.f27073d = new e(this).a(str2).b(str3).c(str4).d(str5).a(new e.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.14
                @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                public void a(Dialog dialog) {
                    com.bytedance.sdk.openadsdk.utils.g.a(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
                public void b(Dialog dialog) {
                    com.bytedance.sdk.openadsdk.utils.g.b(str);
                    TTDelegateActivity.this.finish();
                }
            }).a(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.bytedance.sdk.openadsdk.utils.g.c(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
        if (!this.f27073d.isShowing()) {
            this.f27073d.show();
        }
        this.f27071b = this.f27073d;
    }

    private void a(final String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = ad.a(this, "tt_tip");
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        a(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.bytedance.sdk.openadsdk.utils.g.a(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.bytedance.sdk.openadsdk.utils.g.b(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                com.bytedance.sdk.openadsdk.utils.g.c(str);
                TTDelegateActivity.this.finish();
            }
        });
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.f27071b == null) {
                this.f27071b = new AlertDialog.Builder(this, ad.g(this, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).create();
            }
            this.f27071b.setTitle(String.valueOf(str));
            this.f27071b.setMessage(String.valueOf(str2));
            this.f27071b.setButton(-1, ad.a(this, "tt_label_ok"), onClickListener);
            this.f27071b.setButton(-2, ad.a(this, "tt_label_cancel"), onClickListener2);
            this.f27071b.setOnCancelListener(onCancelListener);
            if (this.f27071b.isShowing()) {
                return;
            }
            this.f27071b.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
