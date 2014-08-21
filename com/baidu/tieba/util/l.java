package com.baidu.tieba.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bc;
/* loaded from: classes.dex */
public class l extends ClickableSpan {
    private Context a;

    public l(Context context) {
        this.a = null;
        this.a = context;
    }

    public Context a() {
        return this.a;
    }

    public void a(String str) {
        com.baidu.tbadk.browser.a.a(this.a, str);
    }

    public void b(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bc(this.a).a(str, null, null)));
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }
}
