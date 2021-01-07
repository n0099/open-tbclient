package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.bp;
import com.bytedance.embedapplog.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class be extends ax<d> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public be() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.ax
    protected bp.b<d, String> epv() {
        return new bp.b<d, String>() { // from class: com.bytedance.embedapplog.be.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            /* renamed from: a */
            public d e(IBinder iBinder) {
                return d.a.a(iBinder);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            public String a(d dVar) {
                if (dVar == null) {
                    return null;
                }
                return dVar.a();
            }
        };
    }

    @Override // com.bytedance.embedapplog.ax
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
