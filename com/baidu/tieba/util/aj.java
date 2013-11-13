package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class aj extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f2482a;

    public aj(Context context) {
        this.f2482a = null;
        this.f2482a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.f2482a;
    }

    public void a(String str) {
        UtilHelper.c(this.f2482a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.f2482a, str, null, null);
    }
}
