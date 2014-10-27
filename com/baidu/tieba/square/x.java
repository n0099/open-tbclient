package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    private final /* synthetic */ int aQe;
    final /* synthetic */ w bMI;
    private final /* synthetic */ ak bMJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, ak akVar, int i) {
        this.bMI = wVar;
        this.bMJ = akVar;
        this.aQe = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String link = this.bMJ.getLink();
        String aD = aa.aD("forum_topics_recommend", String.valueOf(this.aQe));
        bf mR = bf.mR();
        context = this.bMI.mContext;
        String[] strArr = new String[3];
        strArr[0] = link;
        strArr[2] = aD;
        mR.b(context, strArr);
    }
}
