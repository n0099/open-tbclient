package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ud5 {
    public static /* synthetic */ Interceptable $ic;
    public static eb0 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements eb0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.ud5$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0490a implements vd5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ db0 a;

            @Override // com.baidu.tieba.vd5
            public boolean onFileDownloaded(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            public C0490a(a aVar, db0 db0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, db0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = db0Var;
            }

            @Override // com.baidu.tieba.vd5
            public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
                db0 db0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) && (db0Var = this.a) != null) {
                    db0Var.onFailed(new Exception(str));
                }
            }

            @Override // com.baidu.tieba.vd5
            public void onFileDownloadSucceed(DownloadData downloadData) {
                db0 db0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && (db0Var = this.a) != null) {
                    db0Var.b(downloadData.getPath());
                }
            }

            @Override // com.baidu.tieba.vd5
            public void onFileUpdateProgress(DownloadData downloadData) {
                db0 db0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && (db0Var = this.a) != null) {
                    db0Var.a(0L, 100L, (int) (downloadData.getLength() / downloadData.getSize()));
                }
            }

            @Override // com.baidu.tieba.vd5
            public boolean onPreDownload(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                    db0 db0Var = this.a;
                    if (db0Var != null) {
                        db0Var.onStarted();
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

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

        @Override // com.baidu.tieba.eb0
        public void a(String str, String str2, String str3, db0 db0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, db0Var) == null) {
                DownloadData downloadData = new DownloadData();
                downloadData.setPath(str2 + "/" + str3);
                downloadData.setUrl(str);
                downloadData.setCallback(new C0490a(this, db0Var));
                wd5.k().l(downloadData);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948207171, "Lcom/baidu/tieba/ud5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948207171, "Lcom/baidu/tieba/ud5;");
                return;
            }
        }
        a = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            xa0.r(a);
        }
    }
}
