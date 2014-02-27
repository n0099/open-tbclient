package com.baidu.tieba.view;

import android.content.Context;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements e {
    final /* synthetic */ BaseWebView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // com.baidu.tieba.view.e
    public final boolean a(String str) {
        Context context;
        if (str != null) {
            try {
                context = this.a.c;
                UtilHelper.e(context, str);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.a(getClass().getName(), "shouldOverrideUrlLoading", e.toString());
            }
        }
        return true;
    }
}
