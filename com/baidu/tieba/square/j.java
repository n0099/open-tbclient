package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        as asVar;
        Context context;
        String str;
        Context context2;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof n) && (asVar = ((n) tag).d) != null) {
            int i = asVar.a;
            if (asVar.f.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
                context2 = this.a.b;
                TiebaStatic.eventStat(context2, "sq_all_category", "click", 1, new Object[0]);
                this.a.e = ak.a("forum_browse", "all");
                str2 = this.a.e;
                BarFolderFirstDirActivity.a((Activity) this.a.a(), str2);
                return;
            }
            this.a.e = ak.a("forum_browse", String.valueOf(i));
            bk a = bk.a();
            context = this.a.b;
            String[] strArr = new String[3];
            strArr[0] = asVar.d;
            str = this.a.e;
            strArr[2] = str;
            a.a(context, strArr);
        }
    }
}
