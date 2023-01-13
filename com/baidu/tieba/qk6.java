package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.FileDownloaderProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class qk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements tk6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        @Override // com.baidu.tieba.tk6
        public void a(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        @Override // com.baidu.tieba.tk6
        public void b(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        @Override // com.baidu.tieba.tk6
        public void f(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        public a(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadData;
        }

        @Override // com.baidu.tieba.tk6
        public void c(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                oq4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_COMPLETION, String.valueOf(this.a.getSource()), this.a.getName(), this.a.getUrl());
            }
        }

        @Override // com.baidu.tieba.tk6
        public void d(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                oq4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_PAUSE, String.valueOf(this.a.getSource()), this.a.getName(), this.a.getUrl());
            }
        }

        @Override // com.baidu.tieba.tk6
        public void e(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                oq4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_DELETE, String.valueOf(this.a.getSource()), this.a.getName(), this.a.getUrl());
            }
        }
    }

    public qk6() {
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

    public final sk6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return FileDownloaderProxy.b.a();
        }
        return (sk6) invokeV.objValue;
    }

    public final boolean b(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData)) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            int c = a().c(downloadData);
            boolean a2 = a().a(downloadData, new a(downloadData));
            if (a2) {
                if (c == 7) {
                    oq4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_RESUME, String.valueOf(downloadData.getSource()), downloadData.getName(), downloadData.getUrl());
                } else {
                    oq4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_START, String.valueOf(downloadData.getSource()), downloadData.getName(), downloadData.getUrl());
                }
            }
            return a2;
        }
        return invokeL.booleanValue;
    }
}
