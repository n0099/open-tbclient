package com.baidu.tieba.square;

import android.view.ViewGroup;
import com.baidu.tieba.util.bj;
import com.baidu.tieba.util.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f2366a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, ViewGroup viewGroup) {
        this.b = hVar;
        this.f2366a = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        bj.a(this.f2366a, false, (bo) new k(this, str, eVar));
    }
}
