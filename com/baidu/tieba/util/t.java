package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class t extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f1928a;

    public t(Context context) {
        this.f1928a = null;
        this.f1928a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.f1928a;
    }

    public void a(String str) {
        UtilHelper.c(this.f1928a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.f1928a, str, null, null);
    }
}
