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
        linearLayout = this.a.b;
        if (view != linearLayout) {
            linearLayout2 = this.a.c;
            if (view != linearLayout2) {
                button = this.a.f;
                if (view != button) {
                    button2 = this.a.g;
                    if (view == button2) {
                        oVar = this.a.p;
                        if (oVar != o.FRS_IMAGE) {
                            TiebaApplication b = TiebaApplication.b();
                            str = this.a.q;
                            b.c(str);
                            activity = this.a.o;
                            str2 = this.a.q;
                            FrsImageActivity.a(activity, str2, null, 0);
                            activity2 = this.a.o;
                            activity2.finish();
                            return;
                        }
                        return;
                    }
                    return;
                }
                oVar2 = this.a.p;
                if (oVar2 != o.FRS_LIST) {
                    TiebaApplication b2 = TiebaApplication.b();
                    str3 = this.a.q;
                    b2.d(str3);
                    activity3 = this.a.o;
                    str4 = this.a.q;
                    FrsActivity.a(activity3, str4, (String) null);
                    activity4 = this.a.o;
                    activity4.finish();
                    return;
                }
                return;
            }
            this.a.b();
            return;
        }
        this.a.a();
    }
}
