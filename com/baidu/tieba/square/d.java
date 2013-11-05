package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tieba.util.bj;
import com.baidu.tieba.util.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f2360a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, ViewGroup viewGroup) {
        this.b = cVar;
        this.f2360a = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        bj.a(this.f2360a, false, (bo) new e(this, str, eVar));
    }
}
