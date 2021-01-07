package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.d.c;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.h;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TTDelegateActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private Intent f6418a;

    /* renamed from: b  reason: collision with root package name */
    private AlertDialog f6419b;
    private d c;
    private com.bytedance.sdk.openadsdk.core.widget.a d;
    private b e;

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
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

    public static void a(String str, String str2, String str3) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str2);
        intent.putExtra("dialog_content_key", str3);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(String str, String str2, String str3, String str4, boolean z) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str3);
        intent.putExtra("dialog_app_manage_model", str2);
        intent.putExtra("dialog_app_manage_model_icon_url", str4);
        intent.putExtra("dialog_app_detail_is_download_type", z);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 7);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str3);
        intent.putExtra("dialog_app_detail_is_download_type", z);
        intent.putExtra("dialog_app_manage_model", str2);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(String str) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 8);
        intent.putExtra("dialog_app_manage_model", str);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 5);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str2);
        intent.putExtra("dialog_content_key", str3);
        intent.putExtra("dialog_btn_yes_key", str4);
        intent.putExtra("dialog_btn_no_key", str5);
        if (p.a() != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(p.a(), intent, null);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
        this.f6418a = getIntent();
        if (p.a() == null) {
            p.a(this);
        }
        com.bytedance.sdk.openadsdk.h.a.a().a(this);
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (p.a() == null) {
            p.a(this);
        }
        try {
            setIntent(intent);
            this.f6418a = intent;
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            b();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.f6419b != null && this.f6419b.isShowing()) {
                this.f6419b.dismiss();
            }
            if (this.c != null && this.c.isShowing()) {
                this.c.dismiss();
            }
            if (this.d != null && this.d.isShowing()) {
                this.d.dismiss();
            }
            if (this.e != null && this.e.isShowing()) {
                this.e.dismiss();
            }
        } catch (Throwable th) {
        }
        super.onDestroy();
    }

    private void b() {
        try {
            int intExtra = this.f6418a.getIntExtra("type", 0);
            String stringExtra = this.f6418a.getStringExtra("app_download_url");
            this.f6418a.getStringExtra("app_name");
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    c();
                    break;
                case 3:
                    b(stringExtra, this.f6418a.getStringExtra("dialog_title_key"), this.f6418a.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    b(this.f6418a.getStringExtra("permission_id_key"), this.f6418a.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    b(stringExtra, this.f6418a.getStringExtra("dialog_title_key"), this.f6418a.getStringExtra("dialog_content_key"), this.f6418a.getStringExtra("dialog_btn_yes_key"), this.f6418a.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    if (this.f6418a != null) {
                        b(this.f6418a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f6418a.getStringExtra("dialog_title_key"), this.f6418a.getStringExtra("dialog_app_manage_model_icon_url"), this.f6418a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                        break;
                    }
                    break;
                case 7:
                    if (this.f6418a != null) {
                        b(this.f6418a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f6418a.getStringExtra("dialog_title_key"), this.f6418a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                        break;
                    }
                    break;
                case 8:
                    if (this.f6418a != null) {
                        c(this.f6418a.getStringExtra("dialog_app_manage_model"));
                        break;
                    }
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception e) {
            finish();
        }
    }

    private void b(final String str, final String str2, final String str3, String str4, final boolean z) {
        c b2;
        try {
            String str5 = "";
            String str6 = "";
            String str7 = "";
            if (!TextUtils.isEmpty(str) && (b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(str))) != null) {
                str5 = b2.b();
                str6 = b2.c();
                str7 = b2.g();
                if (TextUtils.isEmpty(str7)) {
                    str7 = str3;
                }
            }
            if (this.c == null || !this.c.isShowing()) {
                this.c = new d(this).a(str7).b(str5).c(str4).d(str6).a(new d.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.6
                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void a(Dialog dialog) {
                        g.b(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void b(Dialog dialog) {
                        TTDelegateActivity.this.c(str, str2, str3, z);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void c(Dialog dialog) {
                        g.d(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                    public void d(Dialog dialog) {
                        TTDelegateActivity.this.b(str);
                    }
                });
                this.c.show();
            }
        } catch (Throwable th) {
        }
    }

    private void b(final String str, final String str2, String str3, boolean z) {
        try {
            if (this.d == null || !this.d.isShowing()) {
                this.d = new com.bytedance.sdk.openadsdk.core.widget.a(this);
                this.d.a(str).b(str3).a(new a.InterfaceC1026a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.7
                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                    public void a(Dialog dialog) {
                        g.b(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                    public void b(Dialog dialog) {
                        g.d(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                    public void c(Dialog dialog) {
                        TTDelegateActivity.this.b(str);
                    }
                });
                this.d.a(z);
                this.d.show();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.e != null) {
                this.e.dismiss();
            }
            this.e = new com.bytedance.sdk.openadsdk.core.widget.b(this);
            this.e.a(str).a(new b.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.8
                @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                public void a(Dialog dialog) {
                    if (TTDelegateActivity.this.e != null) {
                        TTDelegateActivity.this.e.dismiss();
                    }
                }
            });
            this.e.show();
        } catch (Throwable th) {
        }
    }

    private void c(String str) {
        try {
            if (this.e != null) {
                this.e.dismiss();
            }
            this.e = new com.bytedance.sdk.openadsdk.core.widget.b(this);
            this.e.a(str).a(new b.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                public void a(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.e.show();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final String str2, String str3, boolean z) {
        try {
            if (this.d != null) {
                this.d.dismiss();
            }
            this.d = new com.bytedance.sdk.openadsdk.core.widget.a(this);
            this.d.a(str).b(str3).a(new a.InterfaceC1026a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.10
                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                public void a(Dialog dialog) {
                    g.b(str2);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                public void b(Dialog dialog) {
                    if (TTDelegateActivity.this.d != null) {
                        TTDelegateActivity.this.d.dismiss();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                public void c(Dialog dialog) {
                    TTDelegateActivity.this.b(str);
                }
            });
            this.d.a(z);
            this.d.show();
        } catch (Throwable th) {
        }
    }

    private void b(final String str, String str2, String str3, String str4, String str5) {
        if (this.f6419b != null) {
            this.f6419b.dismiss();
        }
        e a2 = new e(this).a(str2).b(str3).c(str4).d(str5).a(new e.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.12
            @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
            public void a(Dialog dialog) {
                g.b(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
            public void b(Dialog dialog) {
                g.c(str);
                TTDelegateActivity.this.finish();
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                g.d(str);
                TTDelegateActivity.this.finish();
            }
        });
        a2.show();
        this.f6419b = a2;
    }

    private void b(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
        } else if (Build.VERSION.SDK_INT >= 23) {
            try {
                com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.f.e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.13
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
            } catch (Exception e) {
                finish();
            }
        } else {
            u.b(TTAdConstant.TAG, "已经有权限");
            finish();
        }
    }

    private void b(final String str, String str2, String str3) {
        a(TextUtils.isEmpty(str2) ? ac.a(this, "tt_tip") : str2, TextUtils.isEmpty(str3) ? "" : str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g.b(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g.c(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                g.d(str);
                TTDelegateActivity.this.finish();
            }
        });
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                TTCustomController d = i.c().d();
                boolean isCanUseLocation = d.isCanUseLocation();
                boolean isCanUsePhoneState = d.isCanUsePhoneState();
                boolean isCanUseWriteExternal = d.isCanUseWriteExternal();
                ArrayList arrayList = new ArrayList();
                if (isCanUseLocation) {
                    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (isCanUsePhoneState) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (isCanUseWriteExternal) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.f.e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.5
                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a() {
                        com.bytedance.sdk.openadsdk.k.a.a().c(new a(), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a(String str) {
                        if ("android.permission.READ_PHONE_STATE".equals(str)) {
                        }
                        com.bytedance.sdk.openadsdk.k.a.a().c(new a(), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception e) {
                finish();
                return;
            }
        }
        u.b(TTAdConstant.TAG, "已经有Read phone state权限");
        finish();
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.f6419b == null) {
                this.f6419b = new AlertDialog.Builder(this, Build.VERSION.SDK_INT >= 21 ? ac.g(this, "Theme.Dialog.TTDownload") : ac.g(this, "Theme.Dialog.TTDownloadOld")).create();
            }
            this.f6419b.setTitle(String.valueOf(str));
            this.f6419b.setMessage(String.valueOf(str2));
            this.f6419b.setButton(-1, ac.a(this, "tt_label_ok"), onClickListener);
            this.f6419b.setButton(-2, ac.a(this, "tt_label_cancel"), onClickListener2);
            this.f6419b.setOnCancelListener(onCancelListener);
            if (!this.f6419b.isShowing()) {
                this.f6419b.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.downloadnew.a.e.a();
            k.j(p.a());
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, iArr);
        com.bytedance.sdk.openadsdk.k.a.a().c(new a(), 1);
        finish();
    }
}
