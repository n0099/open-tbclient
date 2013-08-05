package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1723a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, ViewGroup viewGroup) {
        this.f1723a = cVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ap.a(this.b, false, (au) new f(this, str));
    }
}
