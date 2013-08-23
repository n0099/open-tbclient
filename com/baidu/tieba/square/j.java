package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1745a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, ViewGroup viewGroup) {
        this.f1745a = hVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        av.a(this.b, false, (ba) new k(this, str, bVar));
    }
}
