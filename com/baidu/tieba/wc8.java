package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class wc8 {
    public static /* synthetic */ Interceptable $ic;
    public static wc8 b;
    public static List<c> c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;
        public final /* synthetic */ wc8 b;

        public a(wc8 wc8Var, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc8Var, downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wc8Var;
            this.a = downloadData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (wc8.c.size() < this.b.a) {
                    this.b.g(this.a);
                    return;
                }
                this.a.setStatus(2);
                this.a.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0507));
                if (this.a.getCallback() != null) {
                    this.a.getCallback().onFileUpdateProgress(this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(wc8 wc8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = wc8.c.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.e().getUrl().equals(this.a)) {
                        cVar.e().setStatus(4);
                        if (cVar.e().getCallback() != null) {
                            cVar.e().getCallback().onFileUpdateProgress(cVar.e());
                        }
                        it.remove();
                        cVar.c();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DownloadData a;
        public NetWork b;
        public Handler c;

        /* loaded from: classes6.dex */
        public class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, looper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (message.what != 900002 || message.arg2 <= 0 || this.a.a == null) {
                        return;
                    }
                    this.a.a.setLength(message.arg1);
                    this.a.a.setSize(message.arg2);
                    this.a.a.setStatus(1);
                    if (this.a.a.getCallback() != null) {
                        this.a.a.getCallback().onFileUpdateProgress(this.a.a);
                    }
                }
            }
        }

        public c(DownloadData downloadData) {
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
            this.b = new NetWork();
            this.c = new a(this, Looper.getMainLooper());
            this.a = downloadData;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.b;
                if (netWork != null) {
                    netWork.setCancel();
                }
                cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadDataArr)) != null) {
                return (Integer) invokeL.objValue;
            }
            FileInputStream fileInputStream2 = null;
            if (downloadDataArr[0] == null) {
                return null;
            }
            if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                return 0;
            }
            File file = new File(downloadDataArr[0].getPath());
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                this.b.setUrl(downloadDataArr[0].getUrl());
                NetWork netWork = this.b;
                if (netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", this.c, TbConfig.NET_MSG_GETLENTH, 3, 3000)) {
                    File GetFile = FileHelper.GetFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (GetFile == null) {
                        GetFile = FileHelper.GetFileInCache(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    }
                    if (GetFile != null) {
                        try {
                            try {
                                String parent = GetFile.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    GetFile.renameTo(new File(parent2, file.getName()));
                                } else {
                                    li.f(GetFile, file);
                                    li.n(GetFile);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                return 7;
                            }
                        } catch (IOException unused) {
                            li.n(file);
                            li.n(GetFile);
                            return 7;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    return 3;
                }
            }
            try {
                if (!qi.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    } catch (FileNotFoundException e2) {
                        e = e2;
                    }
                    try {
                        if (!xi.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            li.n(new File(downloadDataArr[0].getPath()));
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                BdLog.d(e3.getMessage());
                            }
                            return 4;
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            BdLog.d(e4.getMessage());
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        fileInputStream2 = fileInputStream;
                        BdLog.d(e.getMessage());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e6) {
                                BdLog.d(e6.getMessage());
                            }
                        }
                        return 6;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                                BdLog.d(e7.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) {
                    return 0;
                }
                return 2;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public DownloadData e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (DownloadData) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
                this.b.setCancel();
                this.a.setStatus(4);
                this.a.setStatusMsg(null);
                if (this.a.getCallback() != null) {
                    this.a.getCallback().onFileUpdateProgress(this.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, num) == null) {
                super.onPostExecute((c) num);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    this.a.setStatus(0);
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileUpdateProgress(this.a);
                    }
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileDownloadSucceed(this.a);
                    }
                } else {
                    String str = null;
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0504);
                    } else if (intValue == 2) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0504);
                    } else if (intValue == 3) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0505);
                    } else if (intValue == 4) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0504);
                    } else if (intValue == 6) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0504);
                    } else if (intValue == 7) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0504);
                    }
                    this.a.setStatusMsg(str);
                    this.a.setErrorCode(num.intValue());
                    this.a.setStatus(2);
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileUpdateProgress(this.a);
                    }
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileDownloadFailed(this.a, num.intValue(), str);
                    }
                }
                wc8.c.remove(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948265885, "Lcom/baidu/tieba/wc8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948265885, "Lcom/baidu/tieba/wc8;");
                return;
            }
        }
        b = new wc8();
        c = new LinkedList();
    }

    public wc8() {
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
        this.a = 5;
    }

    public static wc8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? b : (wc8) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            sg.a().post(new b(this, str));
        }
    }

    public List<DownloadData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedList linkedList = new LinkedList();
            for (c cVar : c) {
                linkedList.add(cVar.e());
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void g(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) || downloadData == null) {
            return;
        }
        if (!FileHelper.checkSD()) {
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0506));
            downloadData.setStatus(2);
        }
        if (downloadData.getStatus() == 2) {
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        for (int i = 0; i < c.size(); i++) {
            DownloadData e = c.get(i).e();
            if (e != null && e.getUrl().equals(downloadData.getUrl()) && e.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        if (downloadData.getCallback() != null) {
            downloadData.getCallback().onFileUpdateProgress(downloadData);
        }
        c cVar = new c(downloadData);
        c.add(cVar);
        cVar.execute(downloadData);
    }

    public void h(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
            sg.a().post(new a(this, downloadData));
        }
    }
}
