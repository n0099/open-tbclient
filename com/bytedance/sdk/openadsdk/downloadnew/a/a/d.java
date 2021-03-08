package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.h;
import com.ss.android.a.a.a.h;
import com.ss.android.a.a.a.q;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f4703a;

    public d(Context context) {
        this.f4703a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.h
    public void a(@NonNull Activity activity, @NonNull final String[] strArr, final q qVar) {
        boolean z;
        TTCustomController e;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (!"android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i])) {
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z && (e = i.d().e()) != null && qVar != null && !e.isCanUseWriteExternal()) {
                qVar.a("android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && com.ss.android.downloadlib.f.i.a((Context) activity) < 23) {
            if (qVar != null) {
                qVar.a();
            }
        } else if (strArr == null || strArr.length <= 0) {
            if (qVar != null) {
                qVar.a();
            }
        } else {
            long hashCode = hashCode();
            for (String str : strArr) {
                hashCode += str.hashCode();
            }
            com.bytedance.sdk.openadsdk.utils.h.a(String.valueOf(hashCode), strArr, new h.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.d.1
                @Override // com.bytedance.sdk.openadsdk.utils.h.a
                public void a() {
                    if (qVar != null) {
                        qVar.a();
                    }
                    com.bytedance.sdk.openadsdk.g.a.a().a(true, strArr);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.h.a
                public void a(String str2) {
                    if (qVar != null) {
                        qVar.a(str2);
                    }
                    com.bytedance.sdk.openadsdk.g.a.a().a(false, new String[]{str2});
                }
            });
        }
    }

    @Override // com.ss.android.a.a.a.h
    public boolean a(@Nullable Context context, @NonNull String str) {
        TTCustomController e;
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) && (e = i.d().e()) != null && !e.isCanUseWriteExternal()) {
            return false;
        }
        if (context == null) {
            context = p.a();
        }
        return com.bytedance.sdk.openadsdk.core.f.d.a().a(context, str);
    }

    @Override // com.ss.android.a.a.a.h
    public void a(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }
}
