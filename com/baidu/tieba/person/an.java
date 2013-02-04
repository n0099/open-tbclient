package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.MainTabActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PersonInfoActivity personInfoActivity) {
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
        com.baidu.tieba.b.p pVar;
        aq aqVar;
        com.baidu.tieba.b.p pVar2;
        aq aqVar2;
        aq aqVar3;
        com.baidu.tieba.b.p pVar3;
        com.baidu.tieba.b.p pVar4;
        com.baidu.tieba.b.p pVar5;
        com.baidu.tieba.b.p pVar6;
        com.baidu.tieba.b.p pVar7;
        button = this.a.b;
        if (view == button) {
            this.a.finish();
            return;
        }
        button2 = this.a.h;
        if (view == button2) {
            MainTabActivity.a(this.a, "goto_recommend");
            return;
        }
        button3 = this.a.c;
        if (view == button3) {
            pVar3 = this.a.k;
            if (pVar3.d() != null) {
                com.baidu.tieba.b.o oVar = new com.baidu.tieba.b.o();
                pVar4 = this.a.k;
                oVar.b(pVar4.d().c());
                pVar5 = this.a.k;
                oVar.a(pVar5.d().h());
                pVar6 = this.a.k;
                oVar.a(pVar6.d().i());
                pVar7 = this.a.k;
                oVar.c(pVar7.d().d());
                PersonChangeActivity.a(this.a, 101, oVar);
                return;
            }
            return;
        }
        linearLayout = this.a.q;
        if (view != linearLayout) {
            button4 = this.a.i;
            if (button4 == view) {
                progressBar = this.a.o;
                progressBar.setVisibility(0);
                this.a.a(false, true);
                return;
            }
            return;
        }
        pVar = this.a.k;
        if (pVar.d() != null) {
            aqVar = this.a.G;
            if (aqVar == null) {
                this.a.G = new aq(this.a, null);
                pVar2 = this.a.k;
                if (pVar2.d().m() == 1) {
                    aqVar3 = this.a.G;
                    aqVar3.execute(1);
                    return;
                }
                aqVar2 = this.a.G;
                aqVar2.execute(0);
            }
        }
    }
}
