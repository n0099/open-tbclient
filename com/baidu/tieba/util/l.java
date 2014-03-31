package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tbadk.core.b.af;
/* loaded from: classes.dex */
public class l extends ClickableSpan {
    private Context a;

    public l(Context context) {
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
        com.baidu.tbadk.browser.a.a(this.a, str);
    }

    public final void b(String str) {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2004001, new af(this.a).a(str, null, null)));
    }
}
