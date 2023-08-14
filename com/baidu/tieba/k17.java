package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.l17;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class k17 implements j17 {
    public static /* synthetic */ Interceptable $ic;
    public static final String h;
    public transient /* synthetic */ FieldHolder $fh;
    public es6 a;
    public HashMap<String, String> b;
    public List<DownloadData> c;
    public b d;
    public QmStickerItem e;
    public List<l17> f;
    public gh5 g;

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str);

        void b();

        void c(QmStickerItem qmStickerItem);
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements gh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k17 a;

        @Override // com.baidu.tieba.gh5
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.gh5
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        /* renamed from: com.baidu.tieba.k17$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0370a implements l17.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ DownloadData c;
            public final /* synthetic */ a d;

            public C0370a(a aVar, String str, String str2, DownloadData downloadData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, str2, downloadData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = str;
                this.b = str2;
                this.c = downloadData;
            }

            @Override // com.baidu.tieba.l17.a
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (z) {
                        this.d.a.b.put(this.a, this.b);
                        this.d.a.e.localPath = this.b;
                        this.d.a.d.c(this.d.a.e);
                    } else {
                        this.d.a.d.a("解压失败，请点击重试");
                    }
                    FileHelper.deleteFileOrDir(new File(this.c.getPath()));
                }
            }
        }

        public a(k17 k17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k17Var;
        }

        @Override // com.baidu.tieba.gh5
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.a.m(downloadData);
                if (this.a.d != null && this.a.e != null && this.a.e.fileUrl != null && this.a.e.fileUrl.equals(downloadData.getUrl())) {
                    this.a.d.a(str);
                }
            }
        }

        @Override // com.baidu.tieba.gh5
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(k17.h)) {
                this.a.m(downloadData);
                if (this.a.d != null && this.a.e != null && this.a.e.fileUrl != null && this.a.e.fileUrl.equals(downloadData.getUrl()) && downloadData.getPath().endsWith(".zip")) {
                    String substring = downloadData.getPath().substring(k17.h.length() + 1, downloadData.getPath().lastIndexOf("."));
                    String str = k17.h + "/" + substring;
                    l17 l17Var = new l17(downloadData.getPath(), str, new C0370a(this, substring, str, downloadData));
                    l17Var.execute(new Void[0]);
                    this.a.f.add(l17Var);
                }
            }
        }

        @Override // com.baidu.tieba.gh5
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.a.m(downloadData);
                if (this.a.d != null && this.a.e != null && this.a.e.fileUrl != null && this.a.e.fileUrl.equals(downloadData.getUrl())) {
                    this.a.d.b();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        String str;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947860312, "Lcom/baidu/tieba/k17;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947860312, "Lcom/baidu/tieba/k17;");
                return;
            }
        }
        if (FileHelper.CreateFileIfNotFound(".stickers") != null) {
            str = FileHelper.CreateFileIfNotFound(".stickers").getAbsolutePath();
        } else {
            str = "";
        }
        h = str;
    }

    public k17(es6 es6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {es6Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new QmStickerItem();
        this.f = new ArrayList();
        this.g = new a(this);
        this.a = es6Var;
        k();
    }

    public final void m(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) && !ListUtils.isEmpty(this.c) && downloadData != null) {
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 < this.c.size()) {
                    if (this.c.get(i2) != null && this.c.get(i2).getUrl() != null && this.c.get(i2).getUrl().equals(downloadData.getUrl())) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            this.c.remove(i);
        }
    }

    @Override // com.baidu.tieba.j17
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.b == null) {
                this.b = new HashMap<>();
                e();
            }
            return this.b.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j17
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            n(qmStickerItem);
            if (qmStickerItem == null) {
                reset();
                return true;
            } else if (!StringUtils.isNull(qmStickerItem.localPath)) {
                es6 es6Var = this.a;
                if (es6Var == null) {
                    return true;
                }
                return es6Var.b(qmStickerItem);
            } else {
                reset();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.j17
    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void n(QmStickerItem qmStickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmStickerItem) == null) {
            if (qmStickerItem == null) {
                this.e = new QmStickerItem();
            } else {
                this.e = qmStickerItem;
            }
        }
    }

    @Override // com.baidu.tieba.j17
    public void d(QmStickerItem qmStickerItem) {
        QmStickerItem qmStickerItem2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qmStickerItem) == null) {
            n(qmStickerItem);
            if (qmStickerItem == null) {
                return;
            }
            if (!TextUtils.isEmpty(qmStickerItem.fileUrl) && !StringUtils.isNull(h)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(qmStickerItem.fileUrl);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(h);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(".");
                String str2 = qmStickerItem.fileUrl;
                sb.append(str2.substring(str2.lastIndexOf(".") + 1));
                String sb2 = sb.toString();
                if (this.c == null) {
                    this.c = new ArrayList();
                }
                if (l(qmStickerItem.fileUrl)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(qmStickerItem.fileUrl);
                downloadData.setPath(h + "/" + nameMd5FromUrl + sb2);
                downloadData.setCallback(this.g);
                this.c.add(downloadData);
                hh5.k().l(downloadData);
                return;
            }
            b(null);
            if (this.d != null && (qmStickerItem2 = this.e) != null && (str = qmStickerItem2.fileUrl) != null && str.equals(qmStickerItem.fileUrl)) {
                this.d.b();
            }
        }
    }

    @Override // com.baidu.tieba.j17
    public void e() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || StringUtils.isNull(h)) {
            return;
        }
        HashMap<String, String> hashMap = this.b;
        if (hashMap == null) {
            this.b = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(h);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null && file2.isDirectory()) {
                this.b.put(file2.getName(), file2.getAbsolutePath());
            }
        }
    }

    public final boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!ListUtils.isEmpty(this.c) && str != null) {
                for (DownloadData downloadData : this.c) {
                    if (downloadData != null && str.equals(downloadData.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.j17
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (int i = 0; i < this.f.size(); i++) {
                l17 l17Var = this.f.get(i);
                if (l17Var != null) {
                    l17Var.cancel(true);
                }
            }
        }
    }

    @Override // com.baidu.tieba.j17
    public void reset() {
        es6 es6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (es6Var = this.a) != null) {
            es6Var.b(null);
        }
    }
}
