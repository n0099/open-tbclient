package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ ah a;
    private final /* synthetic */ at b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar, at atVar, int i) {
        this.a = ahVar;
        this.b = atVar;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.b.b();
        String a = ak.a("forum_topics_recommend", String.valueOf(this.c));
        bi a2 = bi.a();
        context = this.a.a;
        String[] strArr = new String[3];
        strArr[0] = b;
        strArr[2] = a;
        a2.a(context, strArr);
    }
}
