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
        com.baidu.tieba.b.s sVar;
        bb bbVar;
        com.baidu.tieba.b.s sVar2;
        bb bbVar2;
        bb bbVar3;
        com.baidu.tieba.b.s sVar3;
        com.baidu.tieba.b.s sVar4;
        com.baidu.tieba.b.s sVar5;
        com.baidu.tieba.b.s sVar6;
        com.baidu.tieba.b.s sVar7;
        button = this.a.c;
        if (view != button) {
            button2 = this.a.i;
            if (view != button2) {
                button3 = this.a.d;
                if (view == button3) {
                    sVar3 = this.a.p;
                    if (sVar3.d() != null) {
                        com.baidu.tieba.b.r rVar = new com.baidu.tieba.b.r();
                        sVar4 = this.a.p;
                        rVar.b(sVar4.d().c());
                        sVar5 = this.a.p;
                        rVar.a(sVar5.d().h());
                        sVar6 = this.a.p;
                        rVar.a(sVar6.d().i());
                        sVar7 = this.a.p;
                        rVar.c(sVar7.d().d());
                        PersonChangeActivity.a(this.a, WebChromeClient.STRING_DLG_TITLE_DATETIME, rVar);
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
                sVar = this.a.p;
                if (sVar.d() != null) {
                    bbVar = this.a.Y;
                    if (bbVar == null) {
                        this.a.Y = new bb(this.a, null);
                        sVar2 = this.a.p;
                        if (sVar2.d().m() == 1) {
                            bbVar3 = this.a.Y;
                            bbVar3.execute(1);
                            return;
                        }
                        bbVar2 = this.a.Y;
                        bbVar2.execute(0);
                        return;
                    }
                    return;
                }
                return;
            }
            String x = TiebaApplication.x();
            if ((x != null && x.length() > 0) || TiebaApplication.b().ah() >= 3) {
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
