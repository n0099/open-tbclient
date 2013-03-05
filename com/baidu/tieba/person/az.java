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
public class az implements View.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.s sVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        LinearLayout linearLayout7;
        com.baidu.tieba.b.s sVar2;
        com.baidu.tieba.b.s sVar3;
        com.baidu.tieba.b.s sVar4;
        com.baidu.tieba.b.s sVar5;
        com.baidu.tieba.b.s sVar6;
        com.baidu.tieba.b.s sVar7;
        com.baidu.tieba.b.s sVar8;
        com.baidu.tieba.b.s sVar9;
        com.baidu.tieba.b.s sVar10;
        com.baidu.tieba.b.s sVar11;
        com.baidu.tieba.b.s sVar12;
        com.baidu.tieba.b.s sVar13;
        com.baidu.tieba.b.s sVar14;
        sVar = this.a.p;
        if (sVar != null) {
            linearLayout = this.a.x;
            if (view == linearLayout) {
                sVar14 = this.a.p;
                if (sVar14.b()) {
                    new com.baidu.tieba.account.ak("mention").start();
                    MentionActivity.a(this.a, (int) WebChromeClient.STRING_DLG_TITLE_TIME);
                    return;
                }
            }
            linearLayout2 = this.a.y;
            if (view == linearLayout2) {
                sVar13 = this.a.p;
                if (sVar13.b()) {
                    EditMarkActivity.a(this.a, (int) WebChromeClient.STRING_DLG_TITLE_WEEK);
                    return;
                }
            }
            linearLayout3 = this.a.z;
            if (view == linearLayout3) {
                sVar10 = this.a.p;
                if (!sVar10.b()) {
                    sVar11 = this.a.p;
                    if (sVar11.d() != null) {
                        PersonInfoActivity personInfoActivity = this.a;
                        sVar12 = this.a.p;
                        EditBarActivity.a(personInfoActivity, 103, sVar12.d().a());
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
                sVar7 = this.a.p;
                if (!sVar7.b()) {
                    sVar8 = this.a.p;
                    if (sVar8.d() != null) {
                        PersonInfoActivity personInfoActivity2 = this.a;
                        sVar9 = this.a.p;
                        PersonListActivity.a(personInfoActivity2, true, sVar9.d().a());
                        return;
                    }
                    return;
                }
                PersonListActivity.a(this.a, true, TiebaApplication.x());
                return;
            }
            linearLayout5 = this.a.B;
            if (view == linearLayout5) {
                sVar4 = this.a.p;
                if (!sVar4.b()) {
                    sVar5 = this.a.p;
                    if (sVar5.d() != null) {
                        PersonInfoActivity personInfoActivity3 = this.a;
                        sVar6 = this.a.p;
                        PersonListActivity.a(personInfoActivity3, false, sVar6.d().a());
                        return;
                    }
                    return;
                }
                PersonListActivity.a(this.a, false, TiebaApplication.x());
                return;
            }
            linearLayout6 = this.a.C;
            if (view == linearLayout6) {
                sVar3 = this.a.p;
                if (sVar3.b()) {
                    this.a.startActivity(new Intent(this.a, MyPostActivity.class));
                    return;
                }
            }
            linearLayout7 = this.a.D;
            if (view == linearLayout7) {
                if (TiebaApplication.b().k()) {
                    StatService.onEvent(this.a, "personal_lbs_post", "personclick", 1);
                }
                PersonInfoActivity personInfoActivity4 = this.a;
                sVar2 = this.a.p;
                PersonLbsActivity.a(personInfoActivity4, sVar2.a());
            }
        }
    }
}
