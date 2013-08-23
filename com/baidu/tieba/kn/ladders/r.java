package com.baidu.tieba.kn.ladders;

import android.webkit.WebView;
import com.baidu.tieba.recommend.ae;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.view.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(KnPkHomeFragment knPkHomeFragment) {
        this.f1227a = knPkHomeFragment;
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        return ae.a(this.f1227a.g(), str);
    }
}
