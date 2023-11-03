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
/* loaded from: classes6.dex */
public class j56 implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements wd7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final vg0 a;
        @NonNull
        public final rh0 b;

        public a(@NonNull j56 j56Var, @NonNull vg0 vg0Var, rh0 rh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j56Var, vg0Var, rh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vg0Var;
            this.b = rh0Var;
        }

        @Override // com.baidu.tieba.wd7
        public void a(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) {
                dh0 dh0Var = new dh0();
                dh0Var.b = downloadData.getStatusMsg();
                if (TextUtils.equals(downloadData.getStatusMsg(), StopStatus.DOWNLOAD_FAIL.name())) {
                    dh0Var.c = true;
                }
                this.b.d(dh0Var);
            }
        }

        @Override // com.baidu.tieba.wd7
        public void b(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.h = m56.j(gf0.b(), this.a.k);
                this.b.onSuccess(this.a.b);
            }
        }

        @Override // com.baidu.tieba.wd7
        public void c(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) {
                this.b.c(this.a.b, downloadData.getProcess());
            }
        }

        @Override // com.baidu.tieba.wd7
        public void d(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                if (this.a.c == AdDownloadStatus.INSTALLED && ApkUtil.hasInstalled(gf0.b(), this.a.d)) {
                    return;
                }
                dh0 dh0Var = new dh0();
                dh0Var.b = "user_cancel";
                this.b.d(dh0Var);
            }
        }

        @Override // com.baidu.tieba.wd7
        public void e(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
                if (downloadData.getSize() > 0) {
                    wg0 wg0Var = this.a.q;
                    if (wg0Var.e <= 0) {
                        wg0Var.e = downloadData.getSize();
                    }
                }
                this.b.a(this.a.b, downloadData.getLength(), downloadData.getSize());
            }
        }

        @Override // com.baidu.tieba.wd7
        public void f(@NonNull DownloadData downloadData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
                Uri uri = downloadData.getUri();
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    vg0 vg0Var = this.a;
                    vg0Var.k = uri;
                    vg0Var.i = 0.0f;
                    vg0Var.j = 0.0f;
                }
                this.b.b(this.a.q.e, m56.j(gf0.b(), this.a.k));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947834334, "Lcom/baidu/tieba/j56;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947834334, "Lcom/baidu/tieba/j56;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
    }

    public j56() {
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
    public int a(@NonNull vg0 vg0Var, @NonNull rh0 rh0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vg0Var, rh0Var)) == null) {
            if (TextUtils.isEmpty(vg0Var.g)) {
                dh0 dh0Var = new dh0();
                dh0Var.b = "download url is null";
                rh0Var.d(dh0Var);
                return -1;
            }
            TbDownloadManagerEcom.i().g(e(vg0Var), new a(this, vg0Var, rh0Var));
            return vg0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(@NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vg0Var) == null) {
            TbDownloadManagerEcom.i().b(e(vg0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vg0Var) == null) {
            TbDownloadManagerEcom.i().f(e(vg0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull vg0 vg0Var, @NonNull rh0 rh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, vg0Var, rh0Var) == null) {
            a aVar = new a(this, vg0Var, rh0Var);
            TbDownloadManagerEcom.i().g(e(vg0Var), aVar);
        }
    }

    public final DownloadData e(vg0 vg0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vg0Var)) == null) {
            DownloadData downloadData = new DownloadData();
            downloadData.setUrl(vg0Var.g);
            downloadData.setName(vg0Var.p.h);
            downloadData.setSource(5);
            ItemData itemData = new ItemData();
            itemData.buttonLink = vg0Var.g;
            itemData.buttonName = a;
            itemData.buttonLinkType = 1;
            zg0 zg0Var = vg0Var.p;
            itemData.mTitle = zg0Var.h;
            itemData.pkgName = vg0Var.d;
            itemData.mIconUrl = zg0Var.g;
            itemData.mIconSize = 1.0d;
            itemData.fileType = "app";
            itemData.apkDetail = new ApkDetail.Builder().build(true);
            downloadData.setItemData(itemData);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }
}
