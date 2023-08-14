package com.baidu.tieba;

import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class k5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends d5b {
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

        @Override // com.baidu.tieba.d5b
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (g5b.a(com.baidu.ubs.analytics.d.a.b)) {
                    for (File file : k5b.a(com.baidu.ubs.analytics.d.a.b)) {
                        if (n4b.c(n4b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), null)) {
                            g5b.b(file.getPath());
                        }
                    }
                }
                if (g5b.a(com.baidu.ubs.analytics.d.a.c)) {
                    for (File file2 : k5b.a(com.baidu.ubs.analytics.d.a.c)) {
                        if (!file2.getName().equals(b5b.e()) && n4b.c(n4b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), null)) {
                            g5b.b(file2.getPath());
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
            c5b.a(new a());
        }
    }
}
