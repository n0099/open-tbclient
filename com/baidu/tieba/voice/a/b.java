package com.baidu.tieba.voice.a;

import android.content.Context;
import com.baidu.tieba.util.ap;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.e.b<d> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2611a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.b = aVar;
        this.f2611a = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(d dVar, String str, com.baidu.adp.lib.e.f fVar) {
        Context context;
        LinkedList linkedList;
        super.a((b) dVar, str, fVar);
        if (dVar != null) {
            this.f2611a.a(dVar.b, dVar.f2612a, dVar.c, dVar.d);
        } else {
            c cVar = this.f2611a;
            context = this.b.b;
            cVar.a(null, null, 1, context.getString(R.string.voice_cache_error_internal));
        }
        linkedList = this.b.f2610a;
        linkedList.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void c(String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        ap apVar;
        super.c(str, fVar);
        if (fVar != null && (apVar = (ap) fVar.a("network")) != null) {
            apVar.h();
        }
        linkedList = this.b.f2610a;
        linkedList.remove(str);
    }
}
