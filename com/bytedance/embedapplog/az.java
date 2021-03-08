package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.a;
import com.bytedance.embedapplog.bi;
import com.bytedance.embedapplog.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class az extends ax<a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public az() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.ax, com.bytedance.embedapplog.bi
    public bi.a hR(Context context) {
        a(context, context.getPackageName());
        return super.hR(context);
    }

    @Override // com.bytedance.embedapplog.ax
    protected bp.b<a, String> eol() {
        return new bp.b<a, String>() { // from class: com.bytedance.embedapplog.az.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            /* renamed from: a */
            public a e(IBinder iBinder) {
                return a.AbstractBinderC0995a.a(iBinder);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            public String a(a aVar) {
                if (aVar == null) {
                    return null;
                }
                return aVar.c();
            }
        };
    }

    @Override // com.bytedance.embedapplog.ax
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
