package com.baidu.tieba.util.a;

import com.baidu.adp.lib.e.g;
import com.baidu.tieba.util.i;
import com.baidu.tieba.util.l;
/* loaded from: classes.dex */
public abstract class a implements g {
    protected abstract Object a(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar);

    protected abstract Object a(String str, i iVar);

    protected abstract Object b(String str, com.baidu.adp.lib.e.e eVar, i iVar, l lVar);

    @Override // com.baidu.adp.lib.e.g
    public Object a(String str, com.baidu.adp.lib.e.f fVar) {
        if (fVar == null) {
            return null;
        }
        i iVar = (i) fVar.a("AsyncImageLoader");
        l lVar = (l) fVar.a("ImageAsyncTaskInfo");
        if (iVar == null || lVar == null) {
            return null;
        }
        if (lVar.j) {
            return null;
        }
        return a(str, iVar);
    }

    @Override // com.baidu.adp.lib.e.g
    public Object a(String str, com.baidu.adp.lib.e.e eVar) {
        com.baidu.adp.lib.e.f d = eVar.d();
        if (d == null) {
            return null;
        }
        i iVar = (i) d.a("AsyncImageLoader");
        l lVar = (l) d.a("ImageAsyncTaskInfo");
        if (iVar == null || lVar == null) {
            return null;
        }
        if (lVar.g && !lVar.j) {
            return a(str, eVar, iVar, lVar);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.g
    public Object b(String str, com.baidu.adp.lib.e.e eVar) {
        com.baidu.adp.lib.e.f d = eVar.d();
        if (d == null) {
            return null;
        }
        i iVar = (i) d.a("AsyncImageLoader");
        l lVar = (l) d.a("ImageAsyncTaskInfo");
        if (iVar == null || lVar == null) {
            return null;
        }
        if (lVar.j) {
            return null;
        }
        return b(str, eVar, iVar, lVar);
    }
}
