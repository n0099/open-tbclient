package com.baidu.tieba.util;

import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.d> {
    final /* synthetic */ l a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, l lVar) {
        this.b = iVar;
        this.a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(String str, com.baidu.adp.lib.e.f fVar) {
        super.a(str, fVar);
        this.a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void c(String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.c(str, fVar);
        linkedList = this.b.k;
        linkedList.remove(this.a);
        linkedList2 = this.b.l;
        if (linkedList2.size() > 0) {
            linkedList3 = this.b.l;
            k kVar = (k) linkedList3.remove(0);
            if (kVar != null) {
                this.b.a(kVar.a, kVar.c, kVar.b, kVar.d, false, kVar.e, kVar.f, kVar.g, true);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.a((j) dVar, str, fVar);
        linkedList = this.b.k;
        linkedList.remove(this.a);
        if (!this.a.o && !this.a.a() && this.a.b != null) {
            Iterator<com.baidu.tbadk.imageManager.c> it = this.a.b.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.imageManager.c next = it.next();
                if (next != null && this.a != null) {
                    if (dVar != null && this.a.i == null) {
                        by.a("", -1008, "resource of onLoaded() is not null but task.img is null", dVar.j());
                    }
                    next.a(this.a.i == null ? dVar : this.a.i, this.a.b(), this.a.f);
                }
            }
            this.a.a(true);
        }
        linkedList2 = this.b.l;
        if (linkedList2.size() > 0) {
            linkedList3 = this.b.l;
            k kVar = (k) linkedList3.remove(0);
            this.b.a(kVar.a, kVar.c, kVar.b, kVar.d, false, kVar.e, kVar.f, kVar.g, true);
        }
        if (!this.a.f) {
            new br(this.a).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(Object... objArr) {
        super.a(objArr);
        if ((this.a.o || this.a.i != null) && !this.a.a()) {
            this.a.o = false;
            if (this.a.b != null) {
                Iterator<com.baidu.tbadk.imageManager.c> it = this.a.b.iterator();
                while (it.hasNext()) {
                    it.next().a(this.a.i, this.a.b(), this.a.f);
                }
                this.a.a(true);
            }
        }
    }
}
