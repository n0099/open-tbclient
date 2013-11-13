package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.aj f2587a;
    final /* synthetic */ CommonImageLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CommonImageLayout commonImageLayout, com.baidu.tieba.data.aj ajVar) {
        this.b = commonImageLayout;
        this.f2587a = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.b.o;
        UtilHelper.c(context, this.f2587a.c());
    }
}
