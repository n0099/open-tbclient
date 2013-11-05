package com.baidu.tieba.util;

import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.e> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f2436a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, d dVar) {
        this.b = aVar;
        this.f2436a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(String str, com.baidu.adp.lib.e.f fVar) {
        super.a(str, fVar);
        this.f2436a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void c(String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.c(str, fVar);
        linkedList = this.b.j;
        linkedList.remove(this.f2436a);
        if (this.b.d) {
            linkedList2 = this.b.k;
            if (linkedList2.size() > 0) {
                linkedList3 = this.b.k;
                c cVar = (c) linkedList3.remove(0);
                if (cVar != null) {
                    this.b.a(cVar.f2447a, cVar.c, Integer.valueOf(cVar.b), cVar.d, cVar.e, cVar.f);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.a((b) eVar, str, fVar);
        linkedList = this.b.j;
        linkedList.remove(this.f2436a);
        if (this.f2436a.k && this.f2436a.b != null) {
            Iterator<com.baidu.tbadk.imageManager.c> it = this.f2436a.b.iterator();
            while (it.hasNext()) {
                it.next().a(this.f2436a.i, this.f2436a.c, this.f2436a.f);
            }
        }
        if (this.b.d) {
            linkedList2 = this.b.k;
            if (linkedList2.size() > 0) {
                linkedList3 = this.b.k;
                c cVar = (c) linkedList3.remove(0);
                this.b.a(cVar.f2447a, cVar.c, Integer.valueOf(cVar.b), cVar.d, cVar.e, cVar.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(Object... objArr) {
        super.a(objArr);
        if (this.f2436a.k || this.f2436a.i != null) {
            this.f2436a.k = false;
            if (this.f2436a.b != null) {
                Iterator<com.baidu.tbadk.imageManager.c> it = this.f2436a.b.iterator();
                while (it.hasNext()) {
                    it.next().a(this.f2436a.i, this.f2436a.c, this.f2436a.f);
                }
            }
        }
    }
}
