package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
final class az implements View.OnClickListener {
    final /* synthetic */ GroupBannerView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(GroupBannerView groupBannerView) {
        this.a = groupBannerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Button button;
        Context context;
        String str;
        Context context2;
        button = this.a.b;
        if (view == button) {
            context2 = this.a.c;
            com.baidu.tieba.ai.a(context2, "group_tab_banner_close");
            this.a.e = true;
            this.a.setVisibility(8);
            TiebaApplication.g().f(System.currentTimeMillis());
            return;
        }
        context = this.a.c;
        com.baidu.tieba.ai.a(context, "group_tab_banner_click");
        Context context3 = this.a.getContext();
        str = this.a.g;
        UtilHelper.a(context3, str, null, null);
    }
}
