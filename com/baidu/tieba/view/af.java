package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af implements View.OnClickListener {
    final /* synthetic */ ae a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.a = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        com.baidu.tieba.data.x xVar;
        com.baidu.tieba.data.x xVar2;
        com.baidu.tieba.data.x xVar3;
        com.baidu.tieba.data.x xVar4;
        com.baidu.tieba.data.x xVar5;
        com.baidu.tieba.data.x xVar6;
        Context context;
        Context context2;
        Pattern pattern;
        Context context3;
        Context context4;
        ah ahVar;
        ah ahVar2;
        textView = this.a.c;
        if (view != textView) {
            xVar = this.a.f;
            String c = xVar.c();
            xVar2 = this.a.f;
            if (xVar2 != null) {
                xVar3 = this.a.f;
                if (xVar3.a() == 1) {
                    context4 = this.a.d;
                    FacePackageDetailActivity.a(context4, c, false, "frs_banner");
                    return;
                }
                xVar4 = this.a.f;
                if (xVar4.a() != 2) {
                    xVar5 = this.a.f;
                    if (xVar5.a() == 3) {
                        context2 = this.a.d;
                        UtilHelper.c(context2, c);
                        return;
                    }
                    xVar6 = this.a.f;
                    if (xVar6.a() == 4) {
                        context = this.a.d;
                        FrsActivity.a(context, c, "frs_banner");
                        return;
                    }
                    return;
                } else if (c.contains("tieba.baidu.com")) {
                    pattern = ae.i;
                    Matcher matcher = pattern.matcher(c);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            context3 = this.a.d;
                            NewPbActivity.a(context3, group, (String) null, "frs_banner");
                            return;
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.e.b(getClass().getName(), "onClick", e.toString());
                            return;
                        }
                    }
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        this.a.g = true;
        this.a.setVisibility(8);
        TiebaApplication.g().e(System.currentTimeMillis());
        ahVar = this.a.h;
        if (ahVar != null) {
            ahVar2 = this.a.h;
            ahVar2.a(true);
        }
    }
}
