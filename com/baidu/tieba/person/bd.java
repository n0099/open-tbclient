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
public class bd implements View.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PersonInfoActivity personInfoActivity) {
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
        com.baidu.tieba.b.t tVar;
        bg bgVar;
        com.baidu.tieba.b.t tVar2;
        bg bgVar2;
        bg bgVar3;
        com.baidu.tieba.b.t tVar3;
        com.baidu.tieba.b.t tVar4;
        com.baidu.tieba.b.t tVar5;
        com.baidu.tieba.b.t tVar6;
        com.baidu.tieba.b.t tVar7;
        button = this.a.c;
        if (view != button) {
            button2 = this.a.i;
            if (view != button2) {
                button3 = this.a.d;
                if (view == button3) {
                    tVar3 = this.a.p;
                    if (tVar3.c() != null) {
                        com.baidu.tieba.b.s sVar = new com.baidu.tieba.b.s();
                        tVar4 = this.a.p;
                        sVar.b(tVar4.c().c());
                        tVar5 = this.a.p;
                        sVar.a(tVar5.c().h());
                        tVar6 = this.a.p;
                        sVar.a(tVar6.c().i());
                        tVar7 = this.a.p;
                        sVar.c(tVar7.c().d());
                        PersonChangeActivity.a(this.a, WebChromeClient.STRING_DLG_TITLE_DATETIME, sVar);
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
                tVar = this.a.p;
                if (tVar.c() != null) {
                    bgVar = this.a.X;
                    if (bgVar == null) {
                        this.a.X = new bg(this.a, null);
                        tVar2 = this.a.p;
                        if (tVar2.c().m() == 1) {
                            bgVar3 = this.a.X;
                            bgVar3.execute(1);
                            return;
                        }
                        bgVar2 = this.a.X;
                        bgVar2.execute(0);
                        return;
                    }
                    return;
                }
                return;
            }
            String y = TiebaApplication.y();
            if ((y != null && y.length() > 0) || TiebaApplication.b().ai() >= 3) {
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
