package com.baidu.tieba.voice.a;

import android.content.Context;
import com.baidu.adp.lib.e.h;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.e.b<d> {
    final /* synthetic */ a a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(d dVar, String str, h hVar) {
        Context context;
        LinkedList linkedList;
        super.a((b) dVar, str, hVar);
        if (dVar != null) {
            this.b.a(dVar.b, dVar.a, dVar.c, dVar.d);
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
    public void c(String str, h hVar) {
        LinkedList linkedList;
        ba baVar;
        super.c(str, hVar);
        if (hVar != null && (baVar = (ba) hVar.a("network")) != null) {
            baVar.k();
        }
        linkedList = this.a.a;
        linkedList.remove(str);
    }
}
