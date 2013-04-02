package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.zeus.WebChromeClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.t tVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        LinearLayout linearLayout7;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.b.t tVar3;
        com.baidu.tieba.b.t tVar4;
        com.baidu.tieba.b.t tVar5;
        com.baidu.tieba.b.t tVar6;
        com.baidu.tieba.b.t tVar7;
        com.baidu.tieba.b.t tVar8;
        com.baidu.tieba.b.t tVar9;
        com.baidu.tieba.b.t tVar10;
        com.baidu.tieba.b.t tVar11;
        com.baidu.tieba.b.t tVar12;
        com.baidu.tieba.b.t tVar13;
        com.baidu.tieba.b.t tVar14;
        tVar = this.a.p;
        if (tVar != null) {
            linearLayout = this.a.x;
            if (view == linearLayout) {
                tVar14 = this.a.p;
                if (tVar14.b()) {
                    new com.baidu.tieba.account.ak("mention").start();
                    MentionActivity.a(this.a, (int) WebChromeClient.STRING_DLG_TITLE_TIME);
                    return;
                }
            }
            linearLayout2 = this.a.y;
            if (view == linearLayout2) {
                tVar13 = this.a.p;
                if (tVar13.b()) {
                    if (TiebaApplication.b().l()) {
                        StatService.onEvent(this.a, "personal_my_collect", "personclick", 1);
                    }
                    EditMarkActivity.a(this.a, (int) WebChromeClient.STRING_DLG_TITLE_WEEK);
                    return;
                }
            }
            linearLayout3 = this.a.z;
            if (view == linearLayout3) {
                tVar10 = this.a.p;
                if (!tVar10.b()) {
                    tVar11 = this.a.p;
                    if (tVar11.c() != null) {
                        PersonInfoActivity personInfoActivity = this.a;
                        tVar12 = this.a.p;
                        EditBarActivity.a(personInfoActivity, 103, tVar12.c().a());
                        return;
                    }
                    return;
                }
                new com.baidu.tieba.account.ak("tb_mytieba").start();
                EditBarActivity.a(this.a, 103, null);
                return;
            }
            linearLayout4 = this.a.A;
            if (view == linearLayout4) {
                tVar7 = this.a.p;
                if (!tVar7.b()) {
                    tVar8 = this.a.p;
                    if (tVar8.c() != null) {
                        PersonInfoActivity personInfoActivity2 = this.a;
                        tVar9 = this.a.p;
                        PersonListActivity.a(personInfoActivity2, true, tVar9.c().a());
                        return;
                    }
                    return;
                }
                PersonListActivity.a(this.a, true, TiebaApplication.y());
                return;
            }
            linearLayout5 = this.a.B;
            if (view == linearLayout5) {
                tVar4 = this.a.p;
                if (!tVar4.b()) {
                    tVar5 = this.a.p;
                    if (tVar5.c() != null) {
                        PersonInfoActivity personInfoActivity3 = this.a;
                        tVar6 = this.a.p;
                        PersonListActivity.a(personInfoActivity3, false, tVar6.c().a());
                        return;
                    }
                    return;
                }
                PersonListActivity.a(this.a, false, TiebaApplication.y());
                return;
            }
            linearLayout6 = this.a.C;
            if (view == linearLayout6) {
                tVar3 = this.a.p;
                if (tVar3.b()) {
                    this.a.startActivity(new Intent(this.a, MyPostActivity.class));
                    return;
                }
            }
            linearLayout7 = this.a.D;
            if (view == linearLayout7) {
                if (TiebaApplication.b().l()) {
                    StatService.onEvent(this.a, "personal_lbs_post", "personclick", 1);
                }
                PersonInfoActivity personInfoActivity4 = this.a;
                tVar2 = this.a.p;
                PersonLbsActivity.a(personInfoActivity4, tVar2.a());
            }
        }
    }
}
