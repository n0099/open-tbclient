package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.bp;
import com.bytedance.embedapplog.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class an extends ax<e> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public an() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.ax
    protected bp.b<e, String> elz() {
        return new bp.b<e, String>() { // from class: com.bytedance.embedapplog.an.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            /* renamed from: a */
            public e e(IBinder iBinder) {
                return e.a.a(iBinder);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            public String a(e eVar) {
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }
        };
    }

    @Override // com.bytedance.embedapplog.ax
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
