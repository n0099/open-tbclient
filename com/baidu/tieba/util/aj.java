package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class aj extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f2465a;

    public aj(Context context) {
        this.f2465a = null;
        this.f2465a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.f2465a;
    }

    public void a(String str) {
        UtilHelper.c(this.f2465a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.f2465a, str, null, null);
    }
}
