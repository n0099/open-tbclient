package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.u;
import com.ss.android.a.a.a.k;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class e implements k {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f4705a;

    public e(Context context) {
        this.f4705a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.k
    public void a(int i, @Nullable Context context, @Nullable com.ss.android.a.a.b.c cVar, String str, Drawable drawable, int i2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Toast.makeText(context, str, 0).show();
            }
        } catch (Exception e) {
            u.f("LibUIFactory", "showToastWithDuration e " + e.getMessage());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.a.a.a.k
    /* renamed from: a */
    public AlertDialog b(@NonNull com.ss.android.a.a.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        if (cVar.f7674a != null && (cVar.f7674a instanceof Activity)) {
            return a((Activity) cVar.f7674a, cVar);
        }
        c(cVar);
        return null;
    }

    private AlertDialog a(Activity activity, final com.ss.android.a.a.d.c cVar) {
        if (cVar.j == 1) {
            AlertDialog b = b(activity, cVar);
            b.show();
            return b;
        }
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, Build.VERSION.SDK_INT >= 21 ? ac.g(activity, "Theme.Dialog.TTDownload") : ac.g(activity, "Theme.Dialog.TTDownloadOld")).setTitle(cVar.b).setMessage(cVar.c).setPositiveButton(cVar.d, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (cVar.qbM != null) {
                    cVar.qbM.a(dialogInterface);
                }
            }
        }).setNegativeButton(cVar.e, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (cVar.qbM != null) {
                    cVar.qbM.b(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.qbM != null) {
                    cVar.qbM.c(dialogInterface);
                }
            }
        });
        if (cVar.g != null) {
            onCancelListener.setIcon(cVar.g);
        }
        AlertDialog create = onCancelListener.create();
        create.show();
        return create;
    }

    private AlertDialog b(Activity activity, final com.ss.android.a.a.d.c cVar) {
        return new com.bytedance.sdk.openadsdk.core.widget.e(activity).a(cVar.b).b(cVar.c).c(cVar.d).d(cVar.e).a(cVar.g).a(new e.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
            public void a(Dialog dialog) {
                if (cVar.qbM != null) {
                    cVar.qbM.a(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
            public void b(Dialog dialog) {
                if (cVar.qbM != null) {
                    cVar.qbM.b(dialog);
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.qbM != null) {
                    cVar.qbM.c(dialogInterface);
                }
            }
        });
    }

    private void c(final com.ss.android.a.a.d.c cVar) {
        g.a aVar = new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.6
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                if (cVar.qbM != null) {
                    cVar.qbM.a(new a());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
                if (cVar.qbM != null) {
                    cVar.qbM.b(new a());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
                if (cVar.qbM != null) {
                    cVar.qbM.c(new a());
                }
            }
        };
        if (cVar.j == 1) {
            g.a(String.valueOf(cVar.hashCode()), cVar.b, cVar.c, cVar.d, cVar.e, aVar);
        } else {
            g.a(String.valueOf(cVar.hashCode()), cVar.b, cVar.c, aVar);
        }
    }

    /* loaded from: classes6.dex */
    class a implements DialogInterface {
        a() {
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }
    }
}
