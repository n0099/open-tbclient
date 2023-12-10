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
/* loaded from: classes8.dex */
public class w56 implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements pe7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final wg0 a;
        @NonNull
        public final sh0 b;

        public a(@NonNull w56 w56Var, @NonNull wg0 wg0Var, sh0 sh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w56Var, wg0Var, sh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg0Var;
            this.b = sh0Var;
        }

        @Override // com.baidu.tieba.pe7
        public void a(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) {
                eh0 eh0Var = new eh0();
                eh0Var.b = downloadData.getStatusMsg();
                if (TextUtils.equals(downloadData.getStatusMsg(), StopStatus.DOWNLOAD_FAIL.name())) {
                    eh0Var.c = true;
                }
                this.b.d(eh0Var);
            }
        }

        @Override // com.baidu.tieba.pe7
        public void b(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.h = z56.j(hf0.b(), this.a.k);
                this.b.onSuccess(this.a.b);
            }
        }

        @Override // com.baidu.tieba.pe7
        public void c(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) {
                this.b.c(this.a.b, downloadData.getProcess());
            }
        }

        @Override // com.baidu.tieba.pe7
        public void d(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                if (this.a.c == AdDownloadStatus.INSTALLED && ApkUtil.hasInstalled(hf0.b(), this.a.d)) {
                    return;
                }
                eh0 eh0Var = new eh0();
                eh0Var.b = "user_cancel";
                this.b.d(eh0Var);
            }
        }

        @Override // com.baidu.tieba.pe7
        public void e(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
                if (downloadData.getSize() > 0) {
                    xg0 xg0Var = this.a.q;
                    if (xg0Var.e <= 0) {
                        xg0Var.e = downloadData.getSize();
                    }
                }
                this.b.a(this.a.b, downloadData.getLength(), downloadData.getSize());
            }
        }

        @Override // com.baidu.tieba.pe7
        public void f(@NonNull DownloadData downloadData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
                Uri uri = downloadData.getUri();
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    wg0 wg0Var = this.a;
                    wg0Var.k = uri;
                    wg0Var.i = 0.0f;
                    wg0Var.j = 0.0f;
                }
                this.b.b(this.a.q.e, z56.j(hf0.b(), this.a.k));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948221617, "Lcom/baidu/tieba/w56;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948221617, "Lcom/baidu/tieba/w56;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
    }

    public w56() {
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
    public int a(@NonNull wg0 wg0Var, @NonNull sh0 sh0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wg0Var, sh0Var)) == null) {
            if (TextUtils.isEmpty(wg0Var.g)) {
                eh0 eh0Var = new eh0();
                eh0Var.b = "download url is null";
                sh0Var.d(eh0Var);
                return -1;
            }
            TbDownloadManagerEcom.i().g(e(wg0Var), new a(this, wg0Var, sh0Var));
            return wg0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wg0Var) == null) {
            TbDownloadManagerEcom.i().b(e(wg0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wg0Var) == null) {
            TbDownloadManagerEcom.i().f(e(wg0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull wg0 wg0Var, @NonNull sh0 sh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, wg0Var, sh0Var) == null) {
            a aVar = new a(this, wg0Var, sh0Var);
            TbDownloadManagerEcom.i().g(e(wg0Var), aVar);
        }
    }

    public final DownloadData e(wg0 wg0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wg0Var)) == null) {
            DownloadData downloadData = new DownloadData();
            downloadData.setUrl(wg0Var.g);
            downloadData.setName(wg0Var.p.h);
            downloadData.setSource(5);
            ItemData itemData = new ItemData();
            itemData.buttonLink = wg0Var.g;
            itemData.buttonName = a;
            itemData.buttonLinkType = 1;
            ah0 ah0Var = wg0Var.p;
            itemData.mTitle = ah0Var.h;
            itemData.pkgName = wg0Var.d;
            itemData.mIconUrl = ah0Var.g;
            itemData.mIconSize = 1.0d;
            itemData.fileType = "app";
            itemData.apkDetail = new ApkDetail.Builder().build(true);
            downloadData.setItemData(itemData);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }
}
