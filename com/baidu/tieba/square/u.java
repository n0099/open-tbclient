package com.baidu.tieba.square;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t a;
    private final /* synthetic */ ap b;
    private final /* synthetic */ TbImageView c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ap apVar, TbImageView tbImageView, int i) {
        this.a = tVar;
        this.b = apVar;
        this.c = tbImageView;
        this.d = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        boolean z;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        String b = this.b.b();
        qVar = this.a.b;
        z = qVar.m;
        if (z) {
            int a = com.baidu.tbadk.a.a.a(b);
            if (a == 2) {
                MessageManager messageManager = MessageManager.getInstance();
                context4 = this.a.f;
                context5 = this.a.f;
                messageManager.sendMessage(new CustomMessage(2002001, new cb(context4, context5.getResources().getString(com.baidu.tieba.x.game_center_title_detail), b, true)));
                return;
            } else if (a == 1) {
                String b2 = com.baidu.tbadk.a.a.b(b);
                if (!TextUtils.isEmpty(b2)) {
                    int intValue = ((Integer) this.c.getTag()).intValue();
                    context2 = this.a.f;
                    TiebaStatic.eventStat(context2, "screen_btn_" + intValue, "click", 1, new Object[0]);
                    MessageManager messageManager2 = MessageManager.getInstance();
                    context3 = this.a.f;
                    messageManager2.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.v(context3, b2)));
                    return;
                }
                return;
            } else {
                return;
            }
        }
        String a2 = af.a("carousel_recommend", String.valueOf(this.d));
        bg a3 = bg.a();
        context = this.a.f;
        String[] strArr = new String[3];
        strArr[0] = b;
        strArr[2] = a2;
        a3.a(context, strArr);
    }
}
