package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.WebChromeClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        Button button3;
        LinearLayout linearLayout;
        Button button4;
        ProgressBar progressBar;
        com.baidu.tieba.b.r rVar;
        bb bbVar;
        com.baidu.tieba.b.r rVar2;
        bb bbVar2;
        bb bbVar3;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        com.baidu.tieba.b.r rVar5;
        com.baidu.tieba.b.r rVar6;
        com.baidu.tieba.b.r rVar7;
        button = this.a.c;
        if (view != button) {
            button2 = this.a.i;
            if (view != button2) {
                button3 = this.a.d;
                if (view == button3) {
                    rVar3 = this.a.p;
                    if (rVar3.d() != null) {
                        com.baidu.tieba.b.q qVar = new com.baidu.tieba.b.q();
                        rVar4 = this.a.p;
                        qVar.b(rVar4.d().c());
                        rVar5 = this.a.p;
                        qVar.a(rVar5.d().h());
                        rVar6 = this.a.p;
                        qVar.a(rVar6.d().i());
                        rVar7 = this.a.p;
                        qVar.c(rVar7.d().d());
                        PersonChangeActivity.a(this.a, WebChromeClient.STRING_DLG_TITLE_DATETIME, qVar);
                        return;
                    }
                    return;
                }
                linearLayout = this.a.v;
                if (view != linearLayout) {
                    button4 = this.a.j;
                    if (button4 == view) {
                        progressBar = this.a.t;
                        progressBar.setVisibility(0);
                        this.a.a(false, true);
                        return;
                    }
                    return;
                }
                rVar = this.a.p;
                if (rVar.d() != null) {
                    bbVar = this.a.V;
                    if (bbVar == null) {
                        this.a.V = new bb(this.a, null);
                        rVar2 = this.a.p;
                        if (rVar2.d().m() == 1) {
                            bbVar3 = this.a.V;
                            bbVar3.execute(1);
                            return;
                        }
                        bbVar2 = this.a.V;
                        bbVar2.execute(0);
                        return;
                    }
                    return;
                }
                return;
            }
            String w = TiebaApplication.w();
            if ((w != null && w.length() > 0) || TiebaApplication.b().ag() >= 3) {
                MainTabActivity.a(this.a, "goto_home");
                return;
            } else {
                MainTabActivity.a(this.a, "goto_recommend");
                return;
            }
        }
        this.a.finish();
    }
}
