package com.baidu.tieba;

import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class wab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends pab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pab
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (sab.a(com.baidu.ubs.analytics.d.a.b)) {
                    for (File file : wab.a(com.baidu.ubs.analytics.d.a.b)) {
                        if (z9b.c(z9b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), null)) {
                            sab.b(file.getPath());
                        }
                    }
                }
                if (sab.a(com.baidu.ubs.analytics.d.a.c)) {
                    for (File file2 : wab.a(com.baidu.ubs.analytics.d.a.c)) {
                        if (!file2.getName().equals(nab.e()) && z9b.c(z9b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), null)) {
                            sab.b(file2.getPath());
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ List a(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (name.endsWith("txt") || name.endsWith(LocalFilesFilterKt.FILTER_NAME_LOG)) {
                    arrayList.add(listFiles[i]);
                }
            }
        }
        return arrayList;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            oab.a(new a());
        }
    }
}
