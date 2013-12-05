package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.ai f2688a;
    final /* synthetic */ CommonImageLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CommonImageLayout commonImageLayout, com.baidu.tieba.data.ai aiVar) {
        this.b = commonImageLayout;
        this.f2688a = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.b.o;
        UtilHelper.b(context, this.f2688a.c());
    }
}
