package com.baidu.tieba.util;

import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.b> {
    final /* synthetic */ i a;
    private final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, l lVar) {
        this.a = iVar;
        this.b = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(String str, com.baidu.adp.lib.e.h hVar) {
        super.a(str, hVar);
        this.b.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void c(String str, com.baidu.adp.lib.e.h hVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.c(str, hVar);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, com.baidu.adp.lib.e.h hVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.a((j) bVar, str, hVar);
        linkedList = this.a.k;
        linkedList.remove(this.b);
        if (!this.b.o && !this.b.a() && this.b.b != null) {
            Iterator<com.baidu.tbadk.imageManager.d> it = this.b.b.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.imageManager.d next = it.next();
                if (next != null && this.b != null) {
                    if (bVar != null && this.b.i == null) {
                        cb.a("", -1008, "resource of onLoaded() is not null but task.img is null", bVar.j());
                    }
                    next.a(this.b.i == null ? bVar : this.b.i, this.b.b(), this.b.f);
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
        if (!this.b.f) {
            new bp(this.b).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(Object... objArr) {
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
