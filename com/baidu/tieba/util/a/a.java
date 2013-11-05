package com.baidu.tieba.util.a;

import com.baidu.adp.lib.e.f;
import com.baidu.adp.lib.e.g;
/* loaded from: classes.dex */
public abstract class a implements g {
    protected abstract Object a(String str, com.baidu.adp.lib.e.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar);

    protected abstract Object a(String str, com.baidu.tieba.util.a aVar);

    protected abstract Object b(String str, com.baidu.adp.lib.e.e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar);

    @Override // com.baidu.adp.lib.e.g
    public Object a(String str, f fVar) {
        if (fVar == null) {
            return null;
        }
        com.baidu.tieba.util.a aVar = (com.baidu.tieba.util.a) fVar.a("AsyncImageLoader");
        com.baidu.tieba.util.d dVar = (com.baidu.tieba.util.d) fVar.a("ImageAsyncTaskInfo");
        if (aVar == null || dVar == null) {
            return null;
        }
        if (dVar.j) {
            return null;
        }
        return a(str, aVar);
    }

    @Override // com.baidu.adp.lib.e.g
    public Object a(String str, com.baidu.adp.lib.e.e eVar) {
        f d = eVar.d();
        if (d == null) {
            return null;
        }
        com.baidu.tieba.util.a aVar = (com.baidu.tieba.util.a) d.a("AsyncImageLoader");
        com.baidu.tieba.util.d dVar = (com.baidu.tieba.util.d) d.a("ImageAsyncTaskInfo");
        if (aVar == null || dVar == null) {
            return null;
        }
        if (dVar.g && !dVar.j) {
            return a(str, eVar, aVar, dVar);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.g
    public Object b(String str, com.baidu.adp.lib.e.e eVar) {
        f d = eVar.d();
        if (d == null) {
            return null;
        }
        com.baidu.tieba.util.a aVar = (com.baidu.tieba.util.a) d.a("AsyncImageLoader");
        com.baidu.tieba.util.d dVar = (com.baidu.tieba.util.d) d.a("ImageAsyncTaskInfo");
        if (aVar == null || dVar == null) {
            return null;
        }
        if (dVar.j) {
            return null;
        }
        return b(str, eVar, aVar, dVar);
    }
}
