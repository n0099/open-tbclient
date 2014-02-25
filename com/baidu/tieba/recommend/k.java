package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ h a;
    private final /* synthetic */ com.baidu.tieba.data.q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, com.baidu.tieba.data.q qVar) {
        this.a = hVar;
        this.b = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.a.i;
        UtilHelper.a(activity, this.b.a(), null, null);
    }
}
