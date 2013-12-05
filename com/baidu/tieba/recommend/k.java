package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.p f2416a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, com.baidu.tieba.data.p pVar) {
        this.b = hVar;
        this.f2416a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UtilHelper.a(this.b.i, this.f2416a.a(), null, null);
    }
}
