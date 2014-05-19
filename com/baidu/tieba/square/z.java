package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y a;
    private final /* synthetic */ at b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, at atVar, int i) {
        this.a = yVar;
        this.b = atVar;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.b.b();
        String a = ak.a("carousel_recommend", String.valueOf(this.c));
        bi a2 = bi.a();
        context = this.a.f;
        String[] strArr = new String[3];
        strArr[0] = b;
        strArr[2] = a;
        a2.a(context, strArr);
    }
}
