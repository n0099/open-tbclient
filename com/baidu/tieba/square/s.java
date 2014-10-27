package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r bMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.bMx = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        Context context;
        Object tag = view.getTag();
        if (!(view.getTag() instanceof u)) {
            uVar = null;
        } else {
            uVar = (u) tag;
        }
        String aD = aa.aD("forum_list_recommend", uVar.adq());
        if (uVar != null) {
            bf mR = bf.mR();
            context = this.bMx.mContext;
            String[] strArr = new String[3];
            strArr[0] = uVar.getLink();
            strArr[2] = aD;
            mR.b(context, strArr);
        }
    }
}
