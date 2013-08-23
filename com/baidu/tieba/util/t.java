package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class t extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f1808a;

    public t(Context context) {
        this.f1808a = null;
        this.f1808a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.f1808a;
    }

    public void a(String str) {
        UtilHelper.c(this.f1808a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.f1808a, str, null, null);
    }
}
