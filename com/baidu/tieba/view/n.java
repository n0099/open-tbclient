package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.data.aj a;
    final /* synthetic */ CommonImageLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(CommonImageLayout commonImageLayout, com.baidu.tieba.data.aj ajVar) {
        this.b = commonImageLayout;
        this.a = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.b.o;
        UtilHelper.c(context, this.a.c());
    }
}
