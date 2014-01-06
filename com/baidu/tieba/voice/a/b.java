package com.baidu.tieba.voice.a;

import android.content.Context;
import com.baidu.tieba.util.at;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.e.b<d> {
    final /* synthetic */ c a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(d dVar, String str, com.baidu.adp.lib.e.f fVar) {
        Context context;
        LinkedList linkedList;
        super.a((b) dVar, str, fVar);
        if (dVar != null) {
            this.a.a(dVar.b, dVar.a, dVar.c, dVar.d);
        } else {
            c cVar = this.a;
            context = this.b.b;
            cVar.a(null, null, 1, context.getString(R.string.voice_cache_error_internal));
        }
        linkedList = this.b.a;
        linkedList.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void c(String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        at atVar;
        super.c(str, fVar);
        if (fVar != null && (atVar = (at) fVar.a("network")) != null) {
            atVar.j();
        }
        linkedList = this.b.a;
        linkedList.remove(str);
    }
}
