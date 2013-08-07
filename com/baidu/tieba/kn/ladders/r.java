package com.baidu.tieba.kn.ladders;

import android.webkit.WebView;
import com.baidu.tieba.recommend.bf;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.view.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(KnPkHomeFragment knPkHomeFragment) {
        this.f1195a = knPkHomeFragment;
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        return bf.a(this.f1195a.g(), str);
    }
}
