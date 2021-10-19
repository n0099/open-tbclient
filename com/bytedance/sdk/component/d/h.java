package com.bytedance.sdk.component.d;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class h implements ThreadFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ThreadGroup f65412a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f65413b;

    /* renamed from: c  reason: collision with root package name */
    public final String f65414c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65415d;

    public h(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65413b = new AtomicInteger(1);
        this.f65415d = i2;
        this.f65412a = new ThreadGroup("tt_pangle_group_" + str);
        this.f65414c = "tt_pangle_thread_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            ThreadGroup threadGroup = this.f65412a;
            Thread thread = new Thread(threadGroup, runnable, this.f65414c + "_" + this.f65413b.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (this.f65415d == 1) {
                thread.setPriority(1);
            } else if (thread.getPriority() != 5) {
                thread.setPriority(3);
            } else {
                thread.setPriority(5);
            }
            return thread;
        }
        return (Thread) invokeL.objValue;
    }
}
