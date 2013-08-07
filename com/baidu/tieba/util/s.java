package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class s extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f1771a;

    public s(Context context) {
        this.f1771a = null;
        this.f1771a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.f1771a;
    }

    public void a(String str) {
        am.c(this.f1771a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.f1771a, str, null, null);
    }
}
