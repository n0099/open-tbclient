package com.baidu.tieba.recommend;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements com.baidu.tieba.view.r {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // com.baidu.tieba.view.r
    public final void a() {
        t tVar;
        t tVar2;
        com.baidu.tieba.view.q qVar;
        t tVar3;
        com.baidu.tieba.view.q qVar2;
        Activity activity;
        Activity activity2;
        tVar = this.a.g;
        if (tVar != null) {
            tVar2 = this.a.g;
            int size = tVar2.a.size();
            qVar = this.a.f;
            if (size > qVar.getCurrentItem()) {
                tVar3 = this.a.g;
                ArrayList<View> arrayList = tVar3.a;
                qVar2 = this.a.f;
                String str = (String) arrayList.get(qVar2.getCurrentItem()).getTag();
                if (!TextUtils.isEmpty(str)) {
                    activity = this.a.i;
                    UtilHelper.a(activity, str, null, null);
                    activity2 = this.a.i;
                    cb.a(activity2, "recommend_banner", "click");
                }
            }
        }
    }
}
