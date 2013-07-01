package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class p extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f1465a;

    public p(Context context) {
        this.f1465a = null;
        this.f1465a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.f1465a;
    }

    public void a(String str) {
        ab.c(this.f1465a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.f1465a, str, null, null);
    }
}
