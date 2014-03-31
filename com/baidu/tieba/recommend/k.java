package com.baidu.tieba.recommend;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements com.baidu.tieba.view.f {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.tieba.view.f
    public final void a() {
        v vVar;
        v vVar2;
        com.baidu.tieba.view.e eVar;
        v vVar3;
        com.baidu.tieba.view.e eVar2;
        Activity activity;
        Activity activity2;
        vVar = this.a.g;
        if (vVar != null) {
            vVar2 = this.a.g;
            int size = vVar2.a.size();
            eVar = this.a.f;
            if (size > eVar.getCurrentItem()) {
                vVar3 = this.a.g;
                ArrayList<View> arrayList = vVar3.a;
                eVar2 = this.a.f;
                String str = (String) arrayList.get(eVar2.getCurrentItem()).getTag();
                if (!TextUtils.isEmpty(str)) {
                    bg a = bg.a();
                    activity = this.a.i;
                    a.a(activity, new String[]{str});
                    activity2 = this.a.i;
                    TiebaStatic.a(activity2, "recommend_banner", "click");
                }
            }
        }
    }
}
