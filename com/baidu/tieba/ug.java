package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes6.dex */
public interface ug<T> {
    BdAsyncTaskParallel getAsyncTaskParallel();

    int getAsyncTaskPriority();

    T getFromLocal(String str, String str2, int i, int i2, rg rgVar, Object... objArr);

    T getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr);

    T getFromRemote(String str, String str2, int i, int i2, rg rgVar, Object... objArr);

    boolean isNeedLoad();

    void updateMemory(String str, Object obj, int i, int i2, Object... objArr);
}
