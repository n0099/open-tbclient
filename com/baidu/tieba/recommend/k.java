package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.p f2299a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, com.baidu.tieba.data.p pVar) {
        this.b = hVar;
        this.f2299a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.b.i;
        UtilHelper.a(activity, this.f2299a.a(), null, null);
    }
}
