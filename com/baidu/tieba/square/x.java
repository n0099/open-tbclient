package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    private final /* synthetic */ int aQs;
    final /* synthetic */ w bMX;
    private final /* synthetic */ ak bMY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, ak akVar, int i) {
        this.bMX = wVar;
        this.bMY = akVar;
        this.aQs = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String link = this.bMY.getLink();
        String aD = aa.aD("forum_topics_recommend", String.valueOf(this.aQs));
        bg mR = bg.mR();
        context = this.bMX.mContext;
        String[] strArr = new String[3];
        strArr[0] = link;
        strArr[2] = aD;
        mR.b(context, strArr);
    }
}
