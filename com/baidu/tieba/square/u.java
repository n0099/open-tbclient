package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.av;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f1756a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        av avVar;
        av avVar2;
        av avVar3;
        av avVar4;
        Activity activity;
        Activity activity2;
        av avVar5;
        av avVar6;
        String str = "";
        String str2 = "";
        if (view.getId() == R.id.banner_big) {
            str = "sq_banner_big";
            avVar5 = this.f1756a.c;
            if (avVar5 != null) {
                avVar6 = this.f1756a.c;
                str2 = avVar6.a().b();
            } else {
                str2 = "";
            }
        } else if (view.getId() == R.id.banner_small_left) {
            str = "sq_banner_left";
            avVar3 = this.f1756a.c;
            if (avVar3 != null) {
                avVar4 = this.f1756a.c;
                str2 = avVar4.b().b();
            } else {
                str2 = "";
            }
        } else if (view.getId() == R.id.banner_small_right) {
            str = "sq_banner_right";
            avVar = this.f1756a.c;
            if (avVar != null) {
                avVar2 = this.f1756a.c;
                str2 = avVar2.c().b();
            } else {
                str2 = "";
            }
        }
        if (TiebaApplication.g().u()) {
            activity2 = this.f1756a.f1755a;
            StatService.onEvent(activity2, str, "click", 1);
        }
        activity = this.f1756a.f1755a;
        UtilHelper.a(activity, str2, (String) null);
    }
}
