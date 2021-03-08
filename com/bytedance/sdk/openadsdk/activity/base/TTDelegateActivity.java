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
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.d.c;
import com.bytedance.sdk.openadsdk.core.d.l;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTDelegateActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private Intent f4108a;
    private AlertDialog b;
    private TTAdDislike c;
    private e d;
    private d e;
    private com.bytedance.sdk.openadsdk.core.widget.a f;
    private b g;

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
        intent.putExtra("type", 7);
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
        intent.putExtra("type", 8);
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
        intent.putExtra("type", 9);
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

    public static void a(l lVar) {
        Intent intent = new Intent(p.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("materialmeta", lVar.aE().toString());
        if (p.a() != null) {
            p.a().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
        this.f4108a = getIntent();
        if (p.a() == null) {
            p.a(this);
        }
        com.bytedance.sdk.openadsdk.g.a.a().a(this);
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
            this.f4108a = intent;
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
            if (this.b != null && this.b.isShowing()) {
                this.b.dismiss();
            }
            if (this.e != null && this.e.isShowing()) {
                this.e.dismiss();
            }
            if (this.f != null && this.f.isShowing()) {
                this.f.dismiss();
            }
            if (this.g != null && this.g.isShowing()) {
                this.g.dismiss();
            }
        } catch (Throwable th) {
        }
        super.onDestroy();
    }

    private void b() {
        try {
            if (this.f4108a != null) {
                int intExtra = this.f4108a.getIntExtra("type", 0);
                String stringExtra = this.f4108a.getStringExtra("app_download_url");
                this.f4108a.getStringExtra("app_name");
                switch (intExtra) {
                    case 1:
                        break;
                    case 2:
                        c();
                        break;
                    case 3:
                        b(stringExtra, this.f4108a.getStringExtra("dialog_title_key"), this.f4108a.getStringExtra("dialog_content_key"));
                        break;
                    case 4:
                        b(this.f4108a.getStringExtra("permission_id_key"), this.f4108a.getStringArrayExtra("permission_content_key"));
                        break;
                    case 5:
                        b(stringExtra, this.f4108a.getStringExtra("dialog_title_key"), this.f4108a.getStringExtra("dialog_content_key"), this.f4108a.getStringExtra("dialog_btn_yes_key"), this.f4108a.getStringExtra("dialog_btn_no_key"));
                        break;
                    case 6:
                        d(this.f4108a.getStringExtra("materialmeta"));
                        break;
                    case 7:
                        if (this.f4108a != null) {
                            b(this.f4108a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f4108a.getStringExtra("dialog_title_key"), this.f4108a.getStringExtra("dialog_app_manage_model_icon_url"), this.f4108a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                            break;
                        }
                        break;
                    case 8:
                        b(this.f4108a.getStringExtra("dialog_app_manage_model"), stringExtra, this.f4108a.getStringExtra("dialog_title_key"), this.f4108a.getBooleanExtra("dialog_app_detail_is_download_type", false));
                        break;
                    case 9:
                        c(this.f4108a.getStringExtra("dialog_app_manage_model"));
                        break;
                    default:
                        finish();
                        break;
                }
            }
        } catch (Exception e) {
            finish();
        }
    }

    private void b(final String str, final String str2, final String str3, String str4, final boolean z) {
        c b;
        try {
            String str5 = "";
            String str6 = "";
            String str7 = "";
            if (!TextUtils.isEmpty(str) && (b = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(str))) != null) {
                str5 = b.b();
                str6 = b.c();
                str7 = b.g();
                if (TextUtils.isEmpty(str7)) {
                    str7 = str3;
                }
            }
            if (this.e == null || !this.e.isShowing()) {
                this.e = new d(this).a(str7).b(str5).c(str4).d(str6).a(new d.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.7
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
                this.e.show();
            }
        } catch (Throwable th) {
        }
    }

    private void b(final String str, final String str2, String str3, boolean z) {
        try {
            if (this.f == null || !this.f.isShowing()) {
                this.f = new com.bytedance.sdk.openadsdk.core.widget.a(this, str);
                this.f.a(str3).a(new a.InterfaceC1026a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.8
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
                this.f.a(z);
                this.f.show();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.g != null) {
                this.g.dismiss();
            }
            this.g = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
            this.g.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                public void a(Dialog dialog) {
                    if (TTDelegateActivity.this.g != null) {
                        TTDelegateActivity.this.g.dismiss();
                    }
                }
            });
            this.g.show();
        } catch (Throwable th) {
        }
    }

    private void c(String str) {
        try {
            if (this.g != null) {
                this.g.dismiss();
            }
            this.g = new com.bytedance.sdk.openadsdk.core.widget.b(this, str);
            this.g.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.10
                @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
                public void a(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.g.show();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final String str2, String str3, boolean z) {
        try {
            if (this.f != null) {
                this.f.dismiss();
            }
            this.f = new com.bytedance.sdk.openadsdk.core.widget.a(this, str);
            this.f.a(str3).a(new a.InterfaceC1026a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.11
                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                public void a(Dialog dialog) {
                    g.b(str2);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                public void b(Dialog dialog) {
                    if (TTDelegateActivity.this.f != null) {
                        TTDelegateActivity.this.f.dismiss();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC1026a
                public void c(Dialog dialog) {
                    TTDelegateActivity.this.b(str);
                }
            });
            this.f.a(z);
            this.f.show();
        } catch (Throwable th) {
        }
    }

    private void d(String str) {
        if (str != null && this.c == null) {
            try {
                this.c = new com.bytedance.sdk.openadsdk.dislike.b(this, com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(str)));
                this.c.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.12
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str2) {
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onRefuse() {
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.c != null) {
            this.c.showDislikeDialog(0);
        }
    }

    private void b(final String str, String str2, String str3, String str4, String str5) {
        if (this.b != null) {
            this.b.dismiss();
        }
        if (this.d == null) {
            this.d = new e(this).a(str2).b(str3).c(str4).d(str5).a(new e.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.14
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
            }).a(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    g.d(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
        if (!this.d.isShowing()) {
            this.d.show();
        }
        this.b = this.d;
    }

    private void b(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
        } else if (Build.VERSION.SDK_INT >= 23) {
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
            } catch (Exception e) {
                finish();
            }
        } else {
            u.b(TTAdConstant.TAG, "已经有权限");
            finish();
        }
    }

    private void b(final String str, String str2, String str3) {
        a(TextUtils.isEmpty(str2) ? ac.a(this, "tt_tip") : str2, TextUtils.isEmpty(str3) ? "" : str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g.b(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g.c(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.5
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
                TTCustomController e = i.d().e();
                boolean isCanUseLocation = e.isCanUseLocation();
                boolean isCanUsePhoneState = e.isCanUsePhoneState();
                boolean isCanUseWriteExternal = e.isCanUseWriteExternal();
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
                com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, new com.bytedance.sdk.openadsdk.core.f.e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity.6
                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a() {
                        com.bytedance.sdk.openadsdk.j.e.a(new a(), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.f.e
                    public void a(String str) {
                        if ("android.permission.READ_PHONE_STATE".equals(str)) {
                        }
                        com.bytedance.sdk.openadsdk.j.e.a(new a(), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception e2) {
                finish();
                return;
            }
        }
        u.b(TTAdConstant.TAG, "已经有Read phone state权限");
        finish();
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.b == null) {
                this.b = new AlertDialog.Builder(this, Build.VERSION.SDK_INT >= 21 ? ac.g(this, "Theme.Dialog.TTDownload") : ac.g(this, "Theme.Dialog.TTDownloadOld")).create();
            }
            this.b.setTitle(String.valueOf(str));
            this.b.setMessage(String.valueOf(str2));
            this.b.setButton(-1, ac.a(this, "tt_label_ok"), onClickListener);
            this.b.setButton(-2, ac.a(this, "tt_label_cancel"), onClickListener2);
            this.b.setOnCancelListener(onCancelListener);
            if (!this.b.isShowing()) {
                this.b.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.downloadnew.a.g.a();
            k.j(p.a());
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        com.bytedance.sdk.openadsdk.core.f.d.a().a(this, strArr, iArr);
        com.bytedance.sdk.openadsdk.j.e.a(new a(), 1);
        finish();
    }
}
