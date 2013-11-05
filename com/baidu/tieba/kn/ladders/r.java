package com.baidu.tieba.kn.ladders;

import android.webkit.WebView;
import com.baidu.tieba.recommend.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.view.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(KnPkHomeFragment knPkHomeFragment) {
        this.f1756a = knPkHomeFragment;
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        return ae.a(this.f1756a.i(), str);
    }
}
