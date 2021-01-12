package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.bi;
import com.bytedance.embedapplog.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class ax<SERVICE> implements bi {

    /* renamed from: a  reason: collision with root package name */
    private final String f5790a;
    private aw<Boolean> pcr = new aw<Boolean>() { // from class: com.bytedance.embedapplog.ax.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.aw
        /* renamed from: N */
        public Boolean M(Object... objArr) {
            return Boolean.valueOf(bc.a((Context) objArr[0], ax.this.f5790a));
        }
    };

    protected abstract Intent c(Context context);

    protected abstract bp.b<SERVICE, String> elz();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(String str) {
        this.f5790a = str;
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.pcr.b(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.bi
    public bi.a hP(Context context) {
        return Xv((String) new bp(context, c(context), elz()).a());
    }

    private bi.a Xv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        bi.a aVar = new bi.a();
        aVar.f5801b = str;
        return aVar;
    }
}
