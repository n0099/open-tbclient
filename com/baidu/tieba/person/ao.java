package com.baidu.tieba.person;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.p pVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        com.baidu.tieba.b.p pVar2;
        pVar = this.a.k;
        if (pVar != null) {
            pVar2 = this.a.k;
            if (!pVar2.b()) {
                return;
            }
        }
        linearLayout = this.a.s;
        if (view == linearLayout) {
            new com.baidu.tieba.account.ak("mention").start();
            MentionActivity.a(this.a, 104);
            return;
        }
        linearLayout2 = this.a.t;
        if (view == linearLayout2) {
            EditMarkActivity.a(this.a, 102);
            return;
        }
        linearLayout3 = this.a.u;
        if (view == linearLayout3) {
            new com.baidu.tieba.account.ak("tb_mytieba").start();
            EditBarActivity.a(this.a, 103);
            return;
        }
        linearLayout4 = this.a.v;
        if (view == linearLayout4) {
            PersonListActivity.a(this.a, true, TiebaApplication.u());
            return;
        }
        linearLayout5 = this.a.w;
        if (view == linearLayout5) {
            PersonListActivity.a(this.a, false, TiebaApplication.u());
        }
    }
}
