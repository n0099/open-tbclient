package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f2425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f2425a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        as asVar;
        Context context;
        String str;
        String str2;
        Context context2;
        Object tag = view.getTag();
        if ((tag instanceof n) && (asVar = ((n) tag).d) != null) {
            int i = asVar.f2388a;
            if (!asVar.f.equals(SocialConstants.TRUE)) {
                this.f2425a.e = SquareActivity.a("forum_browse", String.valueOf(i));
                context = this.f2425a.b;
                String str3 = asVar.d;
                str = this.f2425a.e;
                UtilHelper.a(context, str3, null, str);
                return;
            }
            if (TiebaApplication.g().s()) {
                context2 = this.f2425a.b;
                StatService.onEvent(context2, "sq_all_category", "click", 1);
            }
            this.f2425a.e = SquareActivity.a("forum_browse", "all");
            str2 = this.f2425a.e;
            BarFolderFirstDirActivity.a((Activity) this.f2425a.a(), str2);
        }
    }
}
