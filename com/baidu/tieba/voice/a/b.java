package com.baidu.tieba.voice.a;

import android.content.Context;
import com.baidu.adp.lib.e.h;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends com.baidu.adp.lib.e.b<d> {
    final /* synthetic */ a a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.String, com.baidu.adp.lib.e.h] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public final /* synthetic */ void a(d dVar, String str, h hVar) {
        Context context;
        LinkedList linkedList;
        d dVar2 = dVar;
        super.a((b) dVar2, str, hVar);
        if (dVar2 != null) {
            this.b.a(dVar2.b, dVar2.a, dVar2.c, dVar2.d);
        } else {
            c cVar = this.b;
            context = this.a.b;
            cVar.a(null, null, 1, context.getString(R.string.voice_cache_error_internal));
        }
        linkedList = this.a.a;
        linkedList.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public final void a(String str, h hVar) {
        LinkedList linkedList;
        ba baVar;
        super.a(str, hVar);
        if (hVar != null && (baVar = (ba) hVar.a("network")) != null) {
            baVar.j();
        }
        linkedList = this.a.a;
        linkedList.remove(str);
    }
}
