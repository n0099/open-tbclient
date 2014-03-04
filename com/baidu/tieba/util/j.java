package com.baidu.tieba.util;

import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.b> {
    final /* synthetic */ i a;
    private final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, l lVar) {
        this.a = iVar;
        this.b = lVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.String, com.baidu.adp.lib.e.f] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public final /* synthetic */ void a(com.baidu.adp.widget.ImageView.b bVar, String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        com.baidu.adp.widget.ImageView.b bVar2 = bVar;
        super.a(bVar2, str, fVar);
        linkedList = this.a.k;
        linkedList.remove(this.b);
        if (!this.b.o && !this.b.a() && this.b.b != null) {
            Iterator<com.baidu.tbadk.imageManager.d> it = this.b.b.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.imageManager.d next = it.next();
                if (next != null && this.b != null) {
                    if (bVar2 != null && this.b.i == null) {
                        cb.a("", -1008, "resource of onLoaded() is not null but task.img is null", bVar2.j());
                    }
                    next.a(this.b.i == null ? bVar2 : this.b.i, this.b.b(), this.b.f);
                }
            }
            this.b.a(true);
        }
        linkedList2 = this.a.l;
        if (linkedList2.size() > 0) {
            linkedList3 = this.a.l;
            k kVar = (k) linkedList3.remove(0);
            this.a.a(kVar.a, kVar.c, kVar.b, kVar.d, false, kVar.e, kVar.f, kVar.g, true);
        }
        if (this.b.f) {
            return;
        }
        new bp(this.b).execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public final void a(String str, com.baidu.adp.lib.e.f fVar) {
        super.a(str, fVar);
        l lVar = this.b;
        lVar.n = true;
        if (lVar.a != null) {
            lVar.a.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public final void b(String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.b(str, fVar);
        linkedList = this.a.k;
        linkedList.remove(this.b);
        linkedList2 = this.a.l;
        if (linkedList2.size() > 0) {
            linkedList3 = this.a.l;
            k kVar = (k) linkedList3.remove(0);
            if (kVar != null) {
                this.a.a(kVar.a, kVar.c, kVar.b, kVar.d, false, kVar.e, kVar.f, kVar.g, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public final void a(Object... objArr) {
        super.a(objArr);
        if ((this.b.o || this.b.i != null) && !this.b.a()) {
            this.b.o = false;
            if (this.b.b != null) {
                Iterator<com.baidu.tbadk.imageManager.d> it = this.b.b.iterator();
                while (it.hasNext()) {
                    it.next().a(this.b.i, this.b.b(), this.b.f);
                }
                this.b.a(true);
            }
        }
    }
}
