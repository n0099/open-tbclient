package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class ag extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f2578a;

    public ag(Context context) {
        this.f2578a = null;
        this.f2578a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.f2578a;
    }

    public void a(String str) {
        UtilHelper.b(this.f2578a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.f2578a, str, null, null);
    }
}
