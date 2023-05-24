package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipException;
/* loaded from: classes8.dex */
public class zv6 implements aw6 {
    public static /* synthetic */ Interceptable $ic;
    public static final String i;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoControllerLayout a;
    public vn6 b;
    public fn6 c;
    public HashMap<String, String> d;
    public List<DownloadData> e;
    public b f;
    public QmFilterItem g;
    public ne5 h;

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str);

        void b();

        void c(QmFilterItem qmFilterItem);
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements ne5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv6 a;

        @Override // com.baidu.tieba.ne5
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.ne5
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public a(zv6 zv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv6Var;
        }

        @Override // com.baidu.tieba.ne5
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.a.o(downloadData);
                if (this.a.f != null && this.a.g != null && this.a.g.fileUrl != null && this.a.g.fileUrl.equals(downloadData.getUrl())) {
                    this.a.f.a(str);
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0089 */
        @Override // com.baidu.tieba.ne5
        public void onFileDownloadSucceed(DownloadData downloadData) {
            File file;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && downloadData != null && !StringUtils.isNull(downloadData.getPath()) && !StringUtils.isNull(zv6.i)) {
                this.a.o(downloadData);
                if (this.a.f != null && this.a.g != null && this.a.g.fileUrl != null && this.a.g.fileUrl.equals(downloadData.getUrl()) && downloadData.getPath().endsWith(".zip")) {
                    String substring = downloadData.getPath().substring(zv6.i.length() + 1, downloadData.getPath().lastIndexOf("."));
                    String str = zv6.i + "/" + substring;
                    try {
                        try {
                            w55.c(new File(downloadData.getPath()), str);
                            this.a.d.put(substring, str);
                            this.a.g.localPath = str;
                            this.a.f.c(this.a.g);
                            String path = downloadData.getPath();
                            file = new File(path);
                            downloadData = path;
                        } catch (ZipException e) {
                            this.a.f.a("解压失败，请点击重试");
                            FileHelper.deleteFileOrDir(new File(str));
                            BdLog.e(e);
                            String path2 = downloadData.getPath();
                            file = new File(path2);
                            downloadData = path2;
                        } catch (IOException e2) {
                            this.a.f.a("解压失败，请点击重试");
                            FileHelper.deleteFileOrDir(new File(str));
                            BdLog.e(e2);
                            String path3 = downloadData.getPath();
                            file = new File(path3);
                            downloadData = path3;
                        }
                        FileHelper.deleteFileOrDir(file);
                    } catch (Throwable th) {
                        FileHelper.deleteFileOrDir(new File(downloadData.getPath()));
                        throw th;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ne5
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && downloadData.getStatus() == 4) {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.a.o(downloadData);
                if (this.a.f != null && this.a.g != null && this.a.g.fileUrl != null && this.a.g.fileUrl.equals(downloadData.getUrl())) {
                    this.a.f.b();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        String str;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948373455, "Lcom/baidu/tieba/zv6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948373455, "Lcom/baidu/tieba/zv6;");
                return;
            }
        }
        if (FileHelper.CreateFileIfNotFound(".filters") != null) {
            str = FileHelper.CreateFileIfNotFound(".filters").getAbsolutePath();
        } else {
            str = "";
        }
        i = str;
    }

    public zv6(vn6 vn6Var, fn6 fn6Var, VideoControllerLayout videoControllerLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vn6Var, fn6Var, videoControllerLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new QmFilterItem();
        this.h = new a(this);
        this.b = vn6Var;
        this.c = fn6Var;
        this.a = videoControllerLayout;
        m();
    }

    @Override // com.baidu.tieba.aw6
    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f = bVar;
        }
    }

    @Override // com.baidu.tieba.aw6
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl == null) {
                return null;
            }
            if (this.d == null) {
                this.d = new HashMap<>();
                h();
            }
            return this.d.get(nameMd5FromUrl);
        }
        return (String) invokeL.objValue;
    }

    public void p(QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, qmFilterItem) == null) {
            if (qmFilterItem == null) {
                this.g = new QmFilterItem();
            } else {
                this.g = qmFilterItem;
            }
        }
    }

    @Override // com.baidu.tieba.aw6
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            p(qmFilterItem);
            if (qmFilterItem == null) {
                reset();
                return true;
            } else if (!StringUtils.isNull(qmFilterItem.localPath)) {
                vn6 vn6Var = this.b;
                if (vn6Var != null) {
                    vn6Var.a(qmFilterItem);
                    return true;
                }
                fn6 fn6Var = this.c;
                if (fn6Var != null) {
                    fn6Var.a(qmFilterItem);
                }
                return true;
            } else {
                reset();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!ListUtils.isEmpty(this.e) && str != null) {
                for (DownloadData downloadData : this.e) {
                    if (downloadData != null && str.equals(downloadData.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.aw6
    public QmFilterItem b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (QmFilterItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.aw6
    public void e() {
        VideoControllerLayout videoControllerLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (videoControllerLayout = this.a) != null) {
            videoControllerLayout.setSelectedToRightIndex();
        }
    }

    @Override // com.baidu.tieba.aw6
    public void g() {
        VideoControllerLayout videoControllerLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (videoControllerLayout = this.a) != null) {
            videoControllerLayout.setSelectedToLeftIndex();
        }
    }

    @Override // com.baidu.tieba.aw6
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            vn6 vn6Var = this.b;
            if (vn6Var != null) {
                vn6Var.a(null);
            }
            fn6 fn6Var = this.c;
            if (fn6Var != null) {
                fn6Var.a(null);
            }
        }
    }

    @Override // com.baidu.tieba.aw6
    public void c(QmFilterItem qmFilterItem) {
        QmFilterItem qmFilterItem2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
            p(qmFilterItem);
            if (qmFilterItem == null) {
                return;
            }
            if (!TextUtils.isEmpty(qmFilterItem.fileUrl) && !StringUtils.isNull(i)) {
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(qmFilterItem.fileUrl);
                if (nameMd5FromUrl == null) {
                    return;
                }
                File file = new File(i);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(".");
                String str2 = qmFilterItem.fileUrl;
                sb.append(str2.substring(str2.lastIndexOf(".") + 1));
                String sb2 = sb.toString();
                if (this.e == null) {
                    this.e = new ArrayList();
                }
                if (n(qmFilterItem.fileUrl)) {
                    return;
                }
                DownloadData downloadData = new DownloadData();
                downloadData.setType(10);
                downloadData.setUrl(qmFilterItem.fileUrl);
                downloadData.setPath(i + "/" + nameMd5FromUrl + sb2);
                downloadData.setCallback(this.h);
                this.e.add(downloadData);
                oe5.k().l(downloadData);
                return;
            }
            a(null);
            if (this.f != null && (qmFilterItem2 = this.g) != null && (str = qmFilterItem2.fileUrl) != null && str.equals(qmFilterItem.fileUrl)) {
                this.f.b();
            }
        }
    }

    @Override // com.baidu.tieba.aw6
    public void h() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || StringUtils.isNull(i)) {
            return;
        }
        HashMap<String, String> hashMap = this.d;
        if (hashMap == null) {
            this.d = new HashMap<>();
        } else {
            hashMap.clear();
        }
        File file = new File(i);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    this.d.put(file2.getName(), file2.getAbsolutePath());
                }
            }
        }
    }

    public final void o(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) && !ListUtils.isEmpty(this.e) && downloadData != null) {
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 < this.e.size()) {
                    if (this.e.get(i3) != null && this.e.get(i3).getUrl() != null && this.e.get(i3).getUrl().equals(downloadData.getUrl())) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            this.e.remove(i2);
        }
    }
}
