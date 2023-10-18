package com.baidu.tieba;

import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vt4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile TbDownloadManager a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948252307, "Lcom/baidu/tieba/vt4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948252307, "Lcom/baidu/tieba/vt4;");
        }
    }

    public static TbDownloadManager a(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, downloadData)) == null) {
            if (a == null) {
                synchronized (CommonTbJsBridge.class) {
                    if (a == null) {
                        a = new TbDownloadManager();
                    }
                }
            }
            a.w(2);
            if (a.p(downloadData) <= 0) {
                a.w(1);
                if (a.p(downloadData) <= 0) {
                    a.w(x97.a());
                }
            }
            return a;
        }
        return (TbDownloadManager) invokeL.objValue;
    }
}
