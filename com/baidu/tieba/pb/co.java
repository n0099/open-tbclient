package com.baidu.tieba.pb;

import android.widget.LinearLayout;
import com.baidu.tieba.view.ClickableLayout;
import com.baidu.zeus.NotificationProxy;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements com.baidu.tieba.view.f {
    int a = 0;
    final /* synthetic */ bk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(bk bkVar) {
        this.b = bkVar;
    }

    @Override // com.baidu.tieba.view.f
    public void a() {
        this.b.a();
    }

    @Override // com.baidu.tieba.view.f
    public void b() {
        ClickableLayout clickableLayout;
        ClickableLayout clickableLayout2;
        LinearLayout linearLayout;
        com.baidu.tieba.g gVar;
        ClickableLayout clickableLayout3;
        ClickableLayout clickableLayout4;
        ClickableLayout clickableLayout5;
        LinearLayout linearLayout2;
        if (com.mofamulu.tieba.ch.bg.c().R()) {
            clickableLayout = this.b.d;
            int i = clickableLayout.getLayoutParams().height;
            if (i == 0) {
                clickableLayout5 = this.b.d;
                clickableLayout5.getLayoutParams().height = this.a;
                linearLayout2 = this.b.r;
                linearLayout2.setVisibility(0);
            } else {
                this.a = i;
                clickableLayout2 = this.b.d;
                clickableLayout2.getLayoutParams().height = 0;
                linearLayout = this.b.r;
                linearLayout.setVisibility(8);
                gVar = this.b.b;
                gVar.getWindow().setFlags(NotificationProxy.MAX_URL_LENGTH, NotificationProxy.MAX_URL_LENGTH);
            }
            clickableLayout3 = this.b.d;
            clickableLayout4 = this.b.d;
            clickableLayout3.setLayoutParams(clickableLayout4.getLayoutParams());
            return;
        }
        a();
    }
}
