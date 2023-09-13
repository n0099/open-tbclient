package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class y3a {
    public static /* synthetic */ Interceptable $ic;
    public static y3a c;
    public static List<c> d;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public List<gf7> b;

    /* loaded from: classes8.dex */
    public static class c extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DownloadData a;
        public gf7 b;
        public List<gf7> c;
        public boolean d;
        public NetWork e;
        public Handler f;

        /* loaded from: classes8.dex */
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
                    if (message.what == 900002 && message.arg2 > 0 && this.a.a != null) {
                        this.a.a.setLength(message.arg1);
                        this.a.a.setSize(message.arg2);
                        if (this.a.a.getStatus() != 4 && this.a.a.getStatus() != 7) {
                            this.a.a.setStatus(1);
                        }
                        if (this.a.a.getCallback() != null) {
                            this.a.a.getCallback().onFileUpdateProgress(this.a.a);
                        }
                        if (this.a.b != null) {
                            this.a.b.e(this.a.a);
                        }
                        if (!ListUtils.isEmpty(this.a.c)) {
                            for (int i = 0; i < this.a.c.size(); i++) {
                                ((gf7) this.a.c.get(i)).e(this.a.a);
                            }
                        }
                    }
                }
            }
        }

        public c(DownloadData downloadData, gf7 gf7Var, List<gf7> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadData, gf7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = new NetWork();
            this.f = new a(this, Looper.getMainLooper());
            this.a = downloadData;
            this.b = gf7Var;
            this.c = list;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.e;
                if (netWork != null) {
                    netWork.setCancel();
                }
                cancel(true);
            }
        }

        public DownloadData h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return (DownloadData) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadDataArr)) == null) {
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
                    this.e.setUrl(downloadDataArr[0].getUrl());
                    NetWork netWork = this.e;
                    if (netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", this.f, TbConfig.NET_MSG_GETLENTH, 3, 3000)) {
                        File GetFile = FileHelper.GetFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                        if (GetFile == null) {
                            GetFile = FileHelper.GetFileInCache(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                        }
                        if (GetFile != null) {
                            try {
                                try {
                                    String parent = GetFile.getParent();
                                    String parent2 = file.getParent();
                                    synchronized (this) {
                                        if (parent.equals(parent2)) {
                                            GetFile.renameTo(new File(parent2, file.getName()));
                                        } else {
                                            ai.f(GetFile, file);
                                            ai.n(GetFile);
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return 7;
                                }
                            } catch (IOException unused) {
                                ai.n(file);
                                ai.n(GetFile);
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
                    if (!ei.isEmpty(downloadDataArr[0].getCheck())) {
                        try {
                            fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        } catch (FileNotFoundException e2) {
                            e = e2;
                        }
                        try {
                            if (!ki.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                ai.n(new File(downloadDataArr[0].getPath()));
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
            } else {
                return (Integer) invokeL.objValue;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
                this.e.setCancel();
                if (this.d) {
                    this.a.setStatus(6);
                } else {
                    this.a.setStatus(4);
                }
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
                int i = 0;
                if (num.intValue() == 0) {
                    this.a.setStatus(0);
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileUpdateProgress(this.a);
                    }
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileDownloadSucceed(this.a);
                    }
                    gf7 gf7Var = this.b;
                    if (gf7Var != null) {
                        gf7Var.b(this.a);
                    }
                    if (!ListUtils.isEmpty(this.c)) {
                        while (i < this.c.size()) {
                            this.c.get(i).b(this.a);
                            i++;
                        }
                    }
                } else {
                    String str = null;
                    int intValue = num.intValue();
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue != 3) {
                                if (intValue != 4) {
                                    if (intValue != 6) {
                                        if (intValue == 7) {
                                            str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                        }
                                    } else {
                                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                    }
                                } else {
                                    str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                }
                            } else {
                                str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                            }
                        } else {
                            str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                        }
                    } else {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
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
                    gf7 gf7Var2 = this.b;
                    if (gf7Var2 != null) {
                        gf7Var2.a(this.a);
                    }
                    if (!ListUtils.isEmpty(this.c)) {
                        while (i < this.c.size()) {
                            this.c.get(i).a(this.a);
                            i++;
                        }
                    }
                }
                y3a.d.remove(this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;
        public final /* synthetic */ gf7 b;
        public final /* synthetic */ y3a c;

        public a(y3a y3aVar, DownloadData downloadData, gf7 gf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y3aVar, downloadData, gf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y3aVar;
            this.a = downloadData;
            this.b = gf7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (y3a.d.size() >= this.c.a) {
                    this.a.setStatus(2);
                    this.a.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileUpdateProgress(this.a);
                    }
                    gf7 gf7Var = this.b;
                    if (gf7Var != null) {
                        gf7Var.a(this.a);
                    }
                    if (!ListUtils.isEmpty(this.c.b)) {
                        for (int i = 0; i < this.c.b.size(); i++) {
                            ((gf7) this.c.b.get(i)).a(this.a);
                        }
                        return;
                    }
                    return;
                }
                this.c.k(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ y3a c;

        public b(y3a y3aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y3aVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y3aVar;
            this.a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = y3a.d.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.h().getUrl().equals(this.a)) {
                        cVar.d = this.b;
                        cVar.h().setStatus(4);
                        int i = 0;
                        if (this.b) {
                            cVar.h().setStatus(6);
                            if (cVar.b != null) {
                                cVar.b.d(cVar.h());
                            }
                            if (!ListUtils.isEmpty(this.c.b)) {
                                while (i < this.c.b.size()) {
                                    ((gf7) this.c.b.get(i)).d(cVar.h());
                                    i++;
                                }
                            }
                        } else {
                            if (cVar.b != null) {
                                cVar.b.c(cVar.h());
                            }
                            if (!ListUtils.isEmpty(this.c.b)) {
                                while (i < this.c.b.size()) {
                                    ((gf7) this.c.b.get(i)).c(cVar.h());
                                    i++;
                                }
                            }
                        }
                        if (cVar.h().getCallback() != null) {
                            cVar.h().getCallback().onFileUpdateProgress(cVar.h());
                        }
                        it.remove();
                        cVar.f();
                        return;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280610, "Lcom/baidu/tieba/y3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280610, "Lcom/baidu/tieba/y3a;");
                return;
            }
        }
        c = new y3a();
        d = new LinkedList();
    }

    public y3a() {
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

    public static y3a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return c;
        }
        return (y3a) invokeV.objValue;
    }

    public List<gf7> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public void e(gf7 gf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gf7Var) == null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (!this.b.contains(gf7Var)) {
                this.b.add(gf7Var);
            }
        }
    }

    public void j(gf7 gf7Var) {
        List<gf7> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gf7Var) == null) && (list = this.b) != null) {
            list.remove(gf7Var);
        }
    }

    public void f(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            SafeHandler.getInst().post(new b(this, str, z));
        }
    }

    public void l(DownloadData downloadData, gf7 gf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, downloadData, gf7Var) == null) {
            SafeHandler.getInst().post(new a(this, downloadData, gf7Var));
        }
    }

    public List<DownloadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList linkedList = new LinkedList();
            for (c cVar : d) {
                linkedList.add(cVar.h());
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void k(DownloadData downloadData, gf7 gf7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, downloadData, gf7Var) != null) || downloadData == null) {
            return;
        }
        if (!FileHelper.checkSD()) {
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            downloadData.setStatus(2);
        }
        if (downloadData.getStatus() == 2) {
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
            }
            if (gf7Var != null) {
                gf7Var.a(downloadData);
            }
            if (!ListUtils.isEmpty(this.b)) {
                for (int i = 0; i < this.b.size(); i++) {
                    this.b.get(i).a(downloadData);
                }
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < d.size(); i2++) {
            DownloadData h = d.get(i2).h();
            if (h != null && h.getUrl().equals(downloadData.getUrl()) && h.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        if (downloadData.getCallback() != null) {
            downloadData.getCallback().onFileUpdateProgress(downloadData);
        }
        if (gf7Var != null) {
            gf7Var.f(downloadData, 1);
        }
        if (!ListUtils.isEmpty(this.b)) {
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                this.b.get(i3).f(downloadData, 1);
            }
        }
        c cVar = new c(downloadData, gf7Var, this.b);
        d.add(cVar);
        cVar.execute(downloadData);
    }
}
