package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
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
        com.baidu.tieba.b.r rVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        com.baidu.tieba.b.r rVar5;
        com.baidu.tieba.b.r rVar6;
        com.baidu.tieba.b.r rVar7;
        com.baidu.tieba.b.r rVar8;
        com.baidu.tieba.b.r rVar9;
        com.baidu.tieba.b.r rVar10;
        com.baidu.tieba.b.r rVar11;
        com.baidu.tieba.b.r rVar12;
        com.baidu.tieba.b.r rVar13;
        rVar = this.a.p;
        if (rVar != null) {
            linearLayout = this.a.x;
            if (view == linearLayout) {
                rVar13 = this.a.p;
                if (rVar13.b()) {
                    new com.baidu.tieba.account.ak("mention").start();
                    MentionActivity.a(this.a, (int) WebChromeClient.STRING_DLG_TITLE_TIME);
                    return;
                }
            }
            linearLayout2 = this.a.y;
            if (view == linearLayout2) {
                rVar12 = this.a.p;
                if (rVar12.b()) {
                    EditMarkActivity.a(this.a, (int) WebChromeClient.STRING_DLG_TITLE_WEEK);
                    return;
                }
            }
            linearLayout3 = this.a.z;
            if (view == linearLayout3) {
                rVar9 = this.a.p;
                if (!rVar9.b()) {
                    rVar10 = this.a.p;
                    if (rVar10.d() != null) {
                        PersonInfoActivity personInfoActivity = this.a;
                        rVar11 = this.a.p;
                        EditBarActivity.a(personInfoActivity, 103, rVar11.d().a());
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
                rVar6 = this.a.p;
                if (!rVar6.b()) {
                    rVar7 = this.a.p;
                    if (rVar7.d() != null) {
                        PersonInfoActivity personInfoActivity2 = this.a;
                        rVar8 = this.a.p;
                        PersonListActivity.a(personInfoActivity2, true, rVar8.d().a());
                        return;
                    }
                    return;
                }
                PersonListActivity.a(this.a, true, TiebaApplication.w());
                return;
            }
            linearLayout5 = this.a.B;
            if (view == linearLayout5) {
                rVar3 = this.a.p;
                if (!rVar3.b()) {
                    rVar4 = this.a.p;
                    if (rVar4.d() != null) {
                        PersonInfoActivity personInfoActivity3 = this.a;
                        rVar5 = this.a.p;
                        PersonListActivity.a(personInfoActivity3, false, rVar5.d().a());
                        return;
                    }
                    return;
                }
                PersonListActivity.a(this.a, false, TiebaApplication.w());
                return;
            }
            linearLayout6 = this.a.C;
            if (view == linearLayout6) {
                rVar2 = this.a.p;
                if (rVar2.b()) {
                    this.a.startActivity(new Intent(this.a, MyPostActivity.class));
                }
            }
        }
    }
}
