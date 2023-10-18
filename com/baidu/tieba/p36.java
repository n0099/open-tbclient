package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.TbDownloadManagerEcom;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
/* loaded from: classes7.dex */
public class p36 implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements z97 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final eg0 a;
        @NonNull
        public final ah0 b;

        public a(@NonNull p36 p36Var, @NonNull eg0 eg0Var, ah0 ah0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p36Var, eg0Var, ah0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg0Var;
            this.b = ah0Var;
        }

        @Override // com.baidu.tieba.z97
        public void a(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) {
                mg0 mg0Var = new mg0();
                mg0Var.b = downloadData.getStatusMsg();
                if (TextUtils.equals(downloadData.getStatusMsg(), StopStatus.DOWNLOAD_FAIL.name())) {
                    mg0Var.c = true;
                }
                this.b.d(mg0Var);
            }
        }

        @Override // com.baidu.tieba.z97
        public void b(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.h = s36.j(pe0.b(), this.a.k);
                this.b.onSuccess(this.a.b);
            }
        }

        @Override // com.baidu.tieba.z97
        public void c(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) {
                this.b.c(this.a.b, downloadData.getProcess());
            }
        }

        @Override // com.baidu.tieba.z97
        public void d(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                if (this.a.c == AdDownloadStatus.INSTALLED && ApkUtil.hasInstalled(pe0.b(), this.a.d)) {
                    return;
                }
                mg0 mg0Var = new mg0();
                mg0Var.b = "user_cancel";
                this.b.d(mg0Var);
            }
        }

        @Override // com.baidu.tieba.z97
        public void e(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
                if (downloadData.getSize() > 0) {
                    fg0 fg0Var = this.a.q;
                    if (fg0Var.e <= 0) {
                        fg0Var.e = downloadData.getSize();
                    }
                }
                this.b.a(this.a.b, downloadData.getLength(), downloadData.getSize());
            }
        }

        @Override // com.baidu.tieba.z97
        public void f(@NonNull DownloadData downloadData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
                Uri uri = downloadData.getUri();
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    eg0 eg0Var = this.a;
                    eg0Var.k = uri;
                    eg0Var.i = 0.0f;
                    eg0Var.j = 0.0f;
                }
                this.b.b(this.a.q.e, s36.j(pe0.b(), this.a.k));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948011158, "Lcom/baidu/tieba/p36;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948011158, "Lcom/baidu/tieba/p36;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
    }

    public p36() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public int a(@NonNull eg0 eg0Var, @NonNull ah0 ah0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eg0Var, ah0Var)) == null) {
            if (TextUtils.isEmpty(eg0Var.g)) {
                mg0 mg0Var = new mg0();
                mg0Var.b = "download url is null";
                ah0Var.d(mg0Var);
                return -1;
            }
            TbDownloadManagerEcom.i().g(e(eg0Var), new a(this, eg0Var, ah0Var));
            return eg0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eg0Var) == null) {
            TbDownloadManagerEcom.i().b(e(eg0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eg0Var) == null) {
            TbDownloadManagerEcom.i().f(e(eg0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull eg0 eg0Var, @NonNull ah0 ah0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, eg0Var, ah0Var) == null) {
            a aVar = new a(this, eg0Var, ah0Var);
            TbDownloadManagerEcom.i().g(e(eg0Var), aVar);
        }
    }

    public final DownloadData e(eg0 eg0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eg0Var)) == null) {
            DownloadData downloadData = new DownloadData();
            downloadData.setUrl(eg0Var.g);
            downloadData.setName(eg0Var.p.h);
            downloadData.setSource(5);
            ItemData itemData = new ItemData();
            itemData.buttonLink = eg0Var.g;
            itemData.buttonName = a;
            itemData.buttonLinkType = 1;
            ig0 ig0Var = eg0Var.p;
            itemData.mTitle = ig0Var.h;
            itemData.pkgName = eg0Var.d;
            itemData.mIconUrl = ig0Var.g;
            itemData.mIconSize = 1.0d;
            itemData.fileType = "app";
            itemData.apkDetail = new ApkDetail.Builder().build(true);
            downloadData.setItemData(itemData);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }
}
