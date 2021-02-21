package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.bp;
import com.bytedance.embedapplog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class bo extends ax<c> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bo() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.ax
    protected bp.b<c, String> eoa() {
        return new bp.b<c, String>() { // from class: com.bytedance.embedapplog.bo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            /* renamed from: a */
            public c e(IBinder iBinder) {
                return c.a.a(iBinder);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            public String a(c cVar) {
                return cVar.a();
            }
        };
    }

    @Override // com.bytedance.embedapplog.ax
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
