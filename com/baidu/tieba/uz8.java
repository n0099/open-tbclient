package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class uz8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uz8 b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* loaded from: classes8.dex */
    public class b implements ph5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xz8 b;
        public final /* synthetic */ uz8 c;

        @Override // com.baidu.tieba.ph5
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.ph5
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
            }
        }

        @Override // com.baidu.tieba.ph5
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.onSuccess(this.a);
                }
            }
        }

        /* renamed from: com.baidu.tieba.uz8$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0483b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0483b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.onFail("rename failed");
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.onFail("download failed");
                }
            }
        }

        public b(uz8 uz8Var, String str, xz8 xz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz8Var, str, xz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uz8Var;
            this.a = str;
            this.b = xz8Var;
        }

        @Override // com.baidu.tieba.ph5
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) && this.b != null) {
                this.c.a.post(new c(this));
            }
        }

        @Override // com.baidu.tieba.ph5
        public void onFileDownloadSucceed(DownloadData downloadData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                if (FileHelper.isGif(null, this.a)) {
                    str = ".gif";
                } else {
                    str = ".jpg";
                }
                String str2 = downloadData.getPath() + str;
                if (FileHelper.renameTo(downloadData.getPath(), str2)) {
                    new MediaScannerClient(TbadkApplication.getInst().getContext()).saveImage(str2);
                    if (this.b != null) {
                        this.c.a.post(new a(this, str2));
                    }
                } else if (this.b != null) {
                    this.c.a.post(new RunnableC0483b(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz8 a;

        public a(uz8 uz8Var, xz8 xz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz8Var, xz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onFail("url null");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz8 a;

        public c(uz8 uz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<String> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                return this.a.h();
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && list != null && !list.isEmpty()) {
                NewFaceGroupDownloadModel newFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
                for (String str : list) {
                    newFaceGroupDownloadModel.U(str, Boolean.FALSE, null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948228406, "Lcom/baidu/tieba/uz8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948228406, "Lcom/baidu/tieba/uz8;");
                return;
            }
        }
        c = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/";
    }

    public uz8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
    }

    public static uz8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (uz8.class) {
                    if (b == null) {
                        b = new uz8();
                    }
                }
            }
            return b;
        }
        return (uz8) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new c(this).execute(new Void[0]);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            List<String> h = h();
            if (h.size() > 0) {
                if (z) {
                    c(h, false);
                }
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public MyEmotionGroupData g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return p17.c().d(TbadkCoreApplication.getCurrentAccount(), str);
        }
        return (MyEmotionGroupData) invokeL.objValue;
    }

    public boolean c(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z)) == null) {
            if (list != null && !list.isEmpty()) {
                int i = 0;
                for (String str : list) {
                    MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                    myEmotionGroupData.setGroupId(str);
                    myEmotionGroupData.setUid(TbadkCoreApplication.getCurrentAccount());
                    if (p17.c().b(myEmotionGroupData)) {
                        FileHelper.deleteFileOrDir(new File(c + str));
                        x17.o().k(str);
                        i++;
                    }
                }
                if (i > 0) {
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                    if (z) {
                        vz8.o().z();
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void d(String str, xz8 xz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, xz8Var) == null) {
            if (TextUtils.isEmpty(str)) {
                if (xz8Var != null) {
                    this.a.post(new a(this, xz8Var));
                    return;
                }
                return;
            }
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            DownloadData downloadData = new DownloadData(nameMd5FromUrl, nameMd5FromUrl, str, new b(this, nameMd5FromUrl, xz8Var));
            downloadData.setPath((FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/") + nameMd5FromUrl);
            qh5.k().l(downloadData);
        }
    }

    public List<MyEmotionGroupData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                List<MyEmotionGroupData> h = p17.c().h(TbadkCoreApplication.getCurrentAccount());
                Iterator<MyEmotionGroupData> it = h.iterator();
                while (it.hasNext()) {
                    MyEmotionGroupData next = it.next();
                    if (next.getGroupId() != null && next.getGroupId().contains("collect_")) {
                        it.remove();
                    }
                }
                return h;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (MyEmotionGroupData myEmotionGroupData : f()) {
                File file = new File(c + myEmotionGroupData.getGroupId());
                BdLog.e("getFileUnExistList Called:" + file.getName() + "   Exsists:" + file.exists());
                if (!file.exists()) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean j(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, list, z)) == null) {
            if (list != null && !list.isEmpty()) {
                try {
                    x17.o().s(list, TbadkCoreApplication.getCurrentAccount());
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                    if (z) {
                        vz8.o().z();
                        return true;
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }
}
