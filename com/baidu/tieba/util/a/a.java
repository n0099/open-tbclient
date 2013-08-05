package com.baidu.tieba.util.a;

import com.baidu.adp.lib.c.e;
import com.baidu.adp.lib.c.f;
import com.baidu.adp.lib.c.g;
/* loaded from: classes.dex */
public abstract class a implements g {
    protected abstract Object a(String str, e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar);

    protected abstract Object a(String str, com.baidu.tieba.util.a aVar);

    protected abstract Object b(String str, e eVar, com.baidu.tieba.util.a aVar, com.baidu.tieba.util.d dVar);

    @Override // com.baidu.adp.lib.c.g
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

    @Override // com.baidu.adp.lib.c.g
    public Object a(String str, e eVar) {
        f e = eVar.e();
        if (e == null) {
            return null;
        }
        com.baidu.tieba.util.a aVar = (com.baidu.tieba.util.a) e.a("AsyncImageLoader");
        com.baidu.tieba.util.d dVar = (com.baidu.tieba.util.d) e.a("ImageAsyncTaskInfo");
        if (aVar == null || dVar == null) {
            return null;
        }
        if (dVar.g && !dVar.j) {
            return a(str, eVar, aVar, dVar);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.c.g
    public Object b(String str, e eVar) {
        f e = eVar.e();
        if (e == null) {
            return null;
        }
        com.baidu.tieba.util.a aVar = (com.baidu.tieba.util.a) e.a("AsyncImageLoader");
        com.baidu.tieba.util.d dVar = (com.baidu.tieba.util.d) e.a("ImageAsyncTaskInfo");
        if (aVar == null || dVar == null) {
            return null;
        }
        if (dVar.j) {
            return null;
        }
        return b(str, eVar, aVar, dVar);
    }
}
