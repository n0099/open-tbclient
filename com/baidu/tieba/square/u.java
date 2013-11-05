package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f2377a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f2377a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.data.av avVar;
        com.baidu.tieba.data.av avVar2;
        com.baidu.tieba.data.av avVar3;
        com.baidu.tieba.data.av avVar4;
        Activity activity;
        Activity activity2;
        com.baidu.tieba.data.av avVar5;
        com.baidu.tieba.data.av avVar6;
        String str = "";
        String str2 = "";
        if (view.getId() == R.id.banner_big) {
            str = "sq_banner_big";
            avVar5 = this.f2377a.b;
            if (avVar5 != null) {
                avVar6 = this.f2377a.b;
                str2 = avVar6.a().b();
            } else {
                str2 = "";
            }
        } else if (view.getId() == R.id.banner_small_left) {
            str = "sq_banner_left";
            avVar3 = this.f2377a.b;
            if (avVar3 != null) {
                avVar4 = this.f2377a.b;
                str2 = avVar4.b().b();
            } else {
                str2 = "";
            }
        } else if (view.getId() == R.id.banner_small_right) {
            str = "sq_banner_right";
            avVar = this.f2377a.b;
            if (avVar != null) {
                avVar2 = this.f2377a.b;
                str2 = avVar2.c().b();
            } else {
                str2 = "";
            }
        }
        if (TiebaApplication.g().s()) {
            activity2 = this.f2377a.f2376a;
            StatService.onEvent(activity2, str, "click", 1);
        }
        activity = this.f2377a.f2376a;
        UtilHelper.a(activity, str2, (String) null);
    }
}
