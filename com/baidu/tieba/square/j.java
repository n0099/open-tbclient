package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1844a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, ViewGroup viewGroup) {
        this.f1844a = hVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        ba.a(this.b, false, (bf) new k(this, str, cVar));
    }
}
