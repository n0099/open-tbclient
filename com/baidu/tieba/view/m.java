package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Button button;
        Button button2;
        o oVar;
        String str;
        Activity activity;
        String str2;
        Activity activity2;
        o oVar2;
        String str3;
        Activity activity3;
        String str4;
        Activity activity4;
        linearLayout = this.a.a;
        if (view == linearLayout) {
            this.a.a();
            return;
        }
        linearLayout2 = this.a.b;
        if (view == linearLayout2) {
            this.a.b();
            return;
        }
        button = this.a.e;
        if (view == button) {
            oVar2 = this.a.o;
            if (oVar2 != o.FRS_LIST) {
                TiebaApplication a = TiebaApplication.a();
                str3 = this.a.p;
                a.d(str3);
                activity3 = this.a.n;
                str4 = this.a.p;
                FrsActivity.a(activity3, str4, (String) null);
                activity4 = this.a.n;
                activity4.finish();
                return;
            }
            return;
        }
        button2 = this.a.f;
        if (view == button2) {
            oVar = this.a.o;
            if (oVar != o.FRS_IMAGE) {
                TiebaApplication a2 = TiebaApplication.a();
                str = this.a.p;
                a2.c(str);
                activity = this.a.n;
                str2 = this.a.p;
                FrsImageActivity.a(activity, str2, null, 0);
                activity2 = this.a.n;
                activity2.finish();
            }
        }
    }
}
