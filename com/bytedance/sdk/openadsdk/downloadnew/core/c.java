package com.bytedance.sdk.openadsdk.downloadnew.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements TTAppDownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<TTAppDownloadListener> f31180a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31180a = Collections.synchronizedList(new LinkedList());
    }

    public void a(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTAppDownloadListener) == null) || tTAppDownloadListener == null) {
            return;
        }
        for (TTAppDownloadListener tTAppDownloadListener2 : this.f31180a) {
            if (tTAppDownloadListener2 != null && tTAppDownloadListener2 == tTAppDownloadListener) {
                return;
            }
        }
        synchronized (this.f31180a) {
            this.f31180a.add(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            synchronized (this.f31180a) {
                Iterator<TTAppDownloadListener> it = this.f31180a.iterator();
                while (it.hasNext()) {
                    TTAppDownloadListener next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        next.onDownloadActive(j, j2, str, str2);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            synchronized (this.f31180a) {
                Iterator<TTAppDownloadListener> it = this.f31180a.iterator();
                while (it.hasNext()) {
                    TTAppDownloadListener next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        next.onDownloadFailed(j, j2, str, str2);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            synchronized (this.f31180a) {
                Iterator<TTAppDownloadListener> it = this.f31180a.iterator();
                while (it.hasNext()) {
                    TTAppDownloadListener next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        next.onDownloadFinished(j, str, str2);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            synchronized (this.f31180a) {
                Iterator<TTAppDownloadListener> it = this.f31180a.iterator();
                while (it.hasNext()) {
                    TTAppDownloadListener next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        next.onDownloadPaused(j, j2, str, str2);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f31180a) {
                Iterator<TTAppDownloadListener> it = this.f31180a.iterator();
                while (it.hasNext()) {
                    TTAppDownloadListener next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        next.onIdle();
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            synchronized (this.f31180a) {
                Iterator<TTAppDownloadListener> it = this.f31180a.iterator();
                while (it.hasNext()) {
                    TTAppDownloadListener next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        next.onInstalled(str, str2);
                    }
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f31180a.isEmpty()) {
            return;
        }
        this.f31180a.clear();
    }
}
