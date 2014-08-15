package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        Context context;
        String str;
        Context context2;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof i) && (anVar = ((i) tag).d) != null) {
            int i = anVar.a;
            if (anVar.f.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
                context2 = this.a.b;
                TiebaStatic.eventStat(context2, "sq_all_category", "click", 1, new Object[0]);
                this.a.d = af.a("forum_browse", "all");
                str2 = this.a.d;
                BarFolderFirstDirActivity.a((Activity) this.a.a(), str2);
                return;
            }
            this.a.d = af.a("forum_browse", String.valueOf(i));
            bg a = bg.a();
            context = this.a.b;
            String[] strArr = new String[3];
            strArr[0] = anVar.d;
            str = this.a.d;
            strArr[2] = str;
            a.a(context, strArr);
        }
    }
}
