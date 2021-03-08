package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.bi;
import com.bytedance.embedapplog.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ax<SERVICE> implements bi {

    /* renamed from: a  reason: collision with root package name */
    private final String f3909a;
    private aw<Boolean> ppq = new aw<Boolean>() { // from class: com.bytedance.embedapplog.ax.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.aw
        /* renamed from: M */
        public Boolean L(Object... objArr) {
            return Boolean.valueOf(bc.a((Context) objArr[0], ax.this.f3909a));
        }
    };

    protected abstract Intent c(Context context);

    protected abstract bp.b<SERVICE, String> eol();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(String str) {
        this.f3909a = str;
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.ppq.b(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.bi
    public bi.a hR(Context context) {
        return YQ((String) new bp(context, c(context), eol()).a());
    }

    private bi.a YQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        bi.a aVar = new bi.a();
        aVar.b = str;
        return aVar;
    }
}
