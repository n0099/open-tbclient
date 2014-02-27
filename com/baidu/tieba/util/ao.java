package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class ao extends ClickableSpan {
    private Context a;

    public ao(Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public final Context a() {
        return this.a;
    }

    public final void a(String str) {
        UtilHelper.c(this.a, str);
    }

    public final void b(String str) {
        NewPbActivity.a(this.a, str, (String) null, (String) null);
    }
}
