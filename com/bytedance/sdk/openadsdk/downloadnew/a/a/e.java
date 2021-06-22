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
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.u;
import d.o.a.a.a.a.k;
import d.o.a.a.a.d.c;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class e implements k {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f29135a;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface {
        public a() {
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }
    }

    public e(Context context) {
        this.f29135a = new WeakReference<>(context);
    }

    private void c(final d.o.a.a.a.d.c cVar) {
        g.a aVar = new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.6
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.b(new a());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.a(new a());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.c(new a());
                }
            }
        };
        if (cVar.j == 1) {
            g.a(this.f29135a.get(), String.valueOf(cVar.hashCode()), cVar.f70446b, cVar.f70447c, cVar.f70448d, cVar.f70449e, aVar);
        } else {
            g.a(this.f29135a.get(), String.valueOf(cVar.hashCode()), cVar.f70446b, cVar.f70447c, aVar);
        }
    }

    @Override // d.o.a.a.a.a.k
    public void a(int i2, @Nullable Context context, @Nullable d.o.a.a.a.c.d dVar, String str, Drawable drawable, int i3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Toast.makeText(context, str, 0).show();
        } catch (Exception e2) {
            u.f("LibUIFactory", "showToastWithDuration e " + e2.getMessage());
        }
    }

    private AlertDialog b(Activity activity, final d.o.a.a.a.d.c cVar) {
        return new com.bytedance.sdk.openadsdk.core.widget.e(activity).a(cVar.f70446b).b(cVar.f70447c).c(cVar.f70448d).d(cVar.f70449e).a(cVar.f70451g).a(new e.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
            public void a(Dialog dialog) {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.b(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.e.a
            public void b(Dialog dialog) {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.a(dialog);
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.c(dialogInterface);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.o.a.a.a.a.k
    /* renamed from: a */
    public AlertDialog b(@NonNull d.o.a.a.a.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        Context context = cVar.f70445a;
        if (context != null && (context instanceof Activity)) {
            return a((Activity) context, cVar);
        }
        c(cVar);
        return null;
    }

    private AlertDialog a(Activity activity, final d.o.a.a.a.d.c cVar) {
        if (cVar.j == 1) {
            AlertDialog b2 = b(activity, cVar);
            b2.show();
            return b2;
        }
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, ad.g(activity, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).setTitle(cVar.f70446b).setMessage(cVar.f70447c).setPositiveButton(cVar.f70448d, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.b(dialogInterface);
                }
            }
        }).setNegativeButton(cVar.f70449e, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.a(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.e.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.InterfaceC1923c interfaceC1923c = cVar.f70452h;
                if (interfaceC1923c != null) {
                    interfaceC1923c.c(dialogInterface);
                }
            }
        });
        Drawable drawable = cVar.f70451g;
        if (drawable != null) {
            onCancelListener.setIcon(drawable);
        }
        AlertDialog create = onCancelListener.create();
        create.show();
        return create;
    }
}
