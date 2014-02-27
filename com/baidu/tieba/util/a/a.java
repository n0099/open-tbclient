package com.baidu.tieba.util.a;

import com.baidu.adp.lib.e.h;
import com.baidu.adp.lib.e.i;
import com.baidu.tieba.util.l;
/* loaded from: classes.dex */
public abstract class a implements i {
    protected abstract Object a(String str, com.baidu.adp.lib.e.e eVar, com.baidu.tieba.util.i iVar, l lVar);

    protected abstract Object a(String str, com.baidu.tieba.util.i iVar);

    protected abstract Object b(String str, com.baidu.adp.lib.e.e eVar, com.baidu.tieba.util.i iVar, l lVar);

    @Override // com.baidu.adp.lib.e.i
    public final Object a(String str, h hVar) {
        if (hVar == null) {
            return null;
        }
        com.baidu.tieba.util.i iVar = (com.baidu.tieba.util.i) hVar.a("AsyncImageLoader");
        l lVar = (l) hVar.a("ImageAsyncTaskInfo");
        if (iVar == null || lVar == null) {
            return null;
        }
        if (lVar.n) {
            return null;
        }
        return a(str, iVar);
    }

    @Override // com.baidu.adp.lib.e.i
    public final Object a(String str, com.baidu.adp.lib.e.e eVar) {
        h e = eVar.e();
        if (e == null) {
            return null;
        }
        com.baidu.tieba.util.i iVar = (com.baidu.tieba.util.i) e.a("AsyncImageLoader");
        l lVar = (l) e.a("ImageAsyncTaskInfo");
        if (iVar == null || lVar == null) {
            return null;
        }
        if (lVar.g && !lVar.n) {
            return a(str, eVar, iVar, lVar);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.i
    public final Object b(String str, com.baidu.adp.lib.e.e eVar) {
        h e = eVar.e();
        if (e == null) {
            return null;
        }
        com.baidu.tieba.util.i iVar = (com.baidu.tieba.util.i) e.a("AsyncImageLoader");
        l lVar = (l) e.a("ImageAsyncTaskInfo");
        if (iVar == null || lVar == null) {
            return null;
        }
        if (lVar.n) {
            return null;
        }
        return b(str, eVar, iVar, lVar);
    }
}
