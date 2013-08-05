package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.LabelActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FindInterestFragment f1642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FindInterestFragment findInterestFragment) {
        this.f1642a = findInterestFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        aq aqVar2;
        aq aqVar3;
        Activity activity;
        Activity activity2;
        aq aqVar4;
        Activity activity3;
        com.baidu.tieba.model.o oVar;
        Activity activity4;
        aq aqVar5;
        aqVar = this.f1642a.b;
        if (view == aqVar.d()) {
            oVar = this.f1642a.f1627a;
            oVar.a("get_all_interest", "", 2);
            activity4 = this.f1642a.d;
            StatService.onEvent(activity4, "findinterest_pull", "pulldate");
            aqVar5 = this.f1642a.b;
            aqVar5.g();
            return;
        }
        aqVar2 = this.f1642a.b;
        if (view == aqVar2.e()) {
            aqVar4 = this.f1642a.b;
            StatService.onEvent(aqVar4.a(), "findinterest_add", "click");
            activity3 = this.f1642a.d;
            this.f1642a.a(new Intent(activity3, LabelActivity.class), 16002);
            return;
        }
        int id = view.getId();
        aqVar3 = this.f1642a.b;
        if (id == aqVar3.i()) {
            String str = (String) ((TextView) view).getText();
            activity = this.f1642a.d;
            String string = activity.getString(R.string.bar);
            if (str.lastIndexOf(string) > 0) {
                str = str.substring(0, str.lastIndexOf(string));
            }
            if (str != null) {
                activity2 = this.f1642a.d;
                FrsActivity.a(activity2, str, "");
            }
        }
    }
}
