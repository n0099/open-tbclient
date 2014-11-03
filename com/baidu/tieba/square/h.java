package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bMu = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ai aiVar;
        Context context;
        String str;
        Context context2;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof i) && (aiVar = ((i) tag).bMv) != null) {
            int i = aiVar.index;
            if (aiVar.bNm.equals("1")) {
                context2 = this.bMu.mContext;
                TiebaStatic.eventStat(context2, "sq_all_category", "click", 1, new Object[0]);
                this.bMu.stType = aa.aD("forum_browse", "all");
                str2 = this.bMu.stType;
                BarFolderFirstDirActivity.b((Activity) this.bMu.getContext(), str2);
                return;
            }
            this.bMu.stType = aa.aD("forum_browse", String.valueOf(i));
            bg mR = bg.mR();
            context = this.bMu.mContext;
            String[] strArr = new String[3];
            strArr[0] = aiVar.link;
            str = this.bMu.stType;
            strArr[2] = str;
            mR.b(context, strArr);
        }
    }
}
