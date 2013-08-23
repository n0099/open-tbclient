package com.baidu.tieba.util;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1796a;
    private final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, d dVar) {
        this.f1796a = aVar;
        this.b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.b
    public void a(String str, com.baidu.adp.lib.c.f fVar) {
        super.a(str, fVar);
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.b
    public void c(String str, com.baidu.adp.lib.c.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.c(str, fVar);
        linkedList = this.f1796a.j;
        linkedList.remove(this.b);
        if (this.f1796a.d) {
            linkedList2 = this.f1796a.k;
            if (linkedList2.size() > 0) {
                linkedList3 = this.f1796a.k;
                c cVar = (c) linkedList3.remove(0);
                if (cVar != null) {
                    this.f1796a.a(cVar.f1797a, cVar.c, Integer.valueOf(cVar.b), cVar.d);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.b
    public void a(com.baidu.adp.widget.a.b bVar, String str, com.baidu.adp.lib.c.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.a((Object) bVar, str, fVar);
        linkedList = this.f1796a.j;
        linkedList.remove(this.b);
        if (this.f1796a.d) {
            linkedList2 = this.f1796a.k;
            if (linkedList2.size() > 0) {
                linkedList3 = this.f1796a.k;
                c cVar = (c) linkedList3.remove(0);
                this.f1796a.a(cVar.f1797a, cVar.c, Integer.valueOf(cVar.b), cVar.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.b
    public void a(Object... objArr) {
        super.a(objArr);
        if (this.b.i != null && this.b.b != null) {
            this.b.b.a(this.b.i, this.b.c, this.b.f);
        }
    }
}
