package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class aa extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f2414a;

    public aa(Context context) {
        this.f2414a = null;
        this.f2414a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.f2414a;
    }

    public void a(String str) {
        UtilHelper.c(this.f2414a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.f2414a, str, null, null);
    }
}
