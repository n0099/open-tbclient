package com.baidu.tieba.voice.a;

import android.content.Context;
import com.baidu.tieba.util.z;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.c.b<d> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2019a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.f2019a = aVar;
        this.b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.b
    public void a(d dVar, String str, com.baidu.adp.lib.c.f fVar) {
        Context context;
        LinkedList linkedList;
        super.a((b) dVar, str, fVar);
        if (dVar != null) {
            this.b.a(dVar.b, dVar.f2020a, dVar.c, dVar.d);
        } else {
            c cVar = this.b;
            context = this.f2019a.b;
            cVar.a(null, null, 1, context.getString(R.string.voice_cache_error_internal));
        }
        linkedList = this.f2019a.f2018a;
        linkedList.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.b
    public void c(String str, com.baidu.adp.lib.c.f fVar) {
        LinkedList linkedList;
        z zVar;
        super.c(str, fVar);
        if (fVar != null && (zVar = (z) fVar.a("network")) != null) {
            zVar.h();
        }
        linkedList = this.f2019a.f2018a;
        linkedList.remove(str);
    }
}
