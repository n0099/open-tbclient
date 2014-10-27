package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bMf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bMf = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ai aiVar;
        Context context;
        String str;
        Context context2;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof i) && (aiVar = ((i) tag).bMg) != null) {
            int i = aiVar.index;
            if (aiVar.bMX.equals("1")) {
                context2 = this.bMf.mContext;
                TiebaStatic.eventStat(context2, "sq_all_category", "click", 1, new Object[0]);
                this.bMf.stType = aa.aD("forum_browse", "all");
                str2 = this.bMf.stType;
                BarFolderFirstDirActivity.b((Activity) this.bMf.getContext(), str2);
                return;
            }
            this.bMf.stType = aa.aD("forum_browse", String.valueOf(i));
            bf mR = bf.mR();
            context = this.bMf.mContext;
            String[] strArr = new String[3];
            strArr[0] = aiVar.link;
            str = this.bMf.stType;
            strArr[2] = str;
            mR.b(context, strArr);
        }
    }
}
