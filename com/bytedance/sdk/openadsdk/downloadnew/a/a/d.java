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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.o.a.a.a.a.h;
import d.o.a.a.a.a.q;
import d.o.a.d.n.k;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class d implements h {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f28875a;

    public d(Context context) {
        this.f28875a = new WeakReference<>(context);
    }

    @Override // d.o.a.a.a.a.h
    public void a(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    @Override // d.o.a.a.a.a.h
    public void a(@NonNull Activity activity, @NonNull final String[] strArr, final q qVar) {
        boolean z;
        TTCustomController e2;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z && (e2 = i.d().e()) != null && qVar != null && !e2.isCanUseWriteExternal()) {
                qVar.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && k.a(activity) < 23) {
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
                    q qVar2 = qVar;
                    if (qVar2 != null) {
                        qVar2.a();
                    }
                    com.bytedance.sdk.openadsdk.h.a.a().a(true, strArr);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.h.a
                public void a(String str2) {
                    q qVar2 = qVar;
                    if (qVar2 != null) {
                        qVar2.a(str2);
                    }
                    com.bytedance.sdk.openadsdk.h.a.a().a(false, new String[]{str2});
                }
            });
        }
    }

    @Override // d.o.a.a.a.a.h
    public boolean a(@Nullable Context context, @NonNull String str) {
        TTCustomController e2;
        if (!StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(str) || (e2 = i.d().e()) == null || e2.isCanUseWriteExternal()) {
            if (context == null) {
                context = p.a();
            }
            return com.bytedance.sdk.openadsdk.core.f.d.a().a(context, str);
        }
        return false;
    }
}
