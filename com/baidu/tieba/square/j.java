package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
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
        at atVar;
        Context context;
        String str;
        Context context2;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof n) && (atVar = ((n) tag).d) != null) {
            int i = atVar.a;
            if (atVar.f.equals(SocialConstants.TRUE)) {
                context2 = this.a.b;
                cb.a(context2, "sq_all_category", "click", 1, new Object[0]);
                this.a.e = am.a("forum_browse", "all");
                str2 = this.a.e;
                BarFolderFirstDirActivity.a((Activity) this.a.a(), str2);
                return;
            }
            this.a.e = am.a("forum_browse", String.valueOf(i));
            context = this.a.b;
            String str3 = atVar.d;
            str = this.a.e;
            UtilHelper.a(context, str3, null, str);
        }
    }
}
