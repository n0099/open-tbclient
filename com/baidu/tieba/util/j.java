package com.baidu.tieba.util;

import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.e> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f2606a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, l lVar) {
        this.b = iVar;
        this.f2606a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(String str, com.baidu.adp.lib.e.f fVar) {
        super.a(str, fVar);
        this.f2606a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void c(String str, com.baidu.adp.lib.e.f fVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        super.c(str, fVar);
        linkedList = this.b.k;
        linkedList.remove(this.f2606a);
        if (this.b.d) {
            linkedList2 = this.b.l;
            if (linkedList2.size() > 0) {
                linkedList3 = this.b.l;
                k kVar = (k) linkedList3.remove(0);
                if (kVar != null) {
                    this.b.a(kVar.f2607a, kVar.c, Integer.valueOf(kVar.b), kVar.d, false, kVar.e, kVar.f);
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
        super.a((j) eVar, str, fVar);
        linkedList = this.b.k;
        linkedList.remove(this.f2606a);
        if (this.f2606a.k && this.f2606a.b != null) {
            Iterator<com.baidu.tbadk.imageManager.c> it = this.f2606a.b.iterator();
            while (it.hasNext()) {
                it.next().a(this.f2606a.i, this.f2606a.c, this.f2606a.f);
            }
        }
        if (this.b.d) {
            linkedList2 = this.b.l;
            if (linkedList2.size() > 0) {
                linkedList3 = this.b.l;
                k kVar = (k) linkedList3.remove(0);
                this.b.a(kVar.f2607a, kVar.c, Integer.valueOf(kVar.b), kVar.d, false, kVar.e, kVar.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.b
    public void a(Object... objArr) {
        super.a(objArr);
        if (this.f2606a.k || this.f2606a.i != null) {
            this.f2606a.k = false;
            if (this.f2606a.b != null) {
                Iterator<com.baidu.tbadk.imageManager.c> it = this.f2606a.b.iterator();
                while (it.hasNext()) {
                    it.next().a(this.f2606a.i, this.f2606a.c, this.f2606a.f);
                }
            }
        }
    }
}
