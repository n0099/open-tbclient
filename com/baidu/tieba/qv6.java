package com.baidu.tieba;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerHttpResponseMessage;
import com.baidu.tieba.downloadmanager.net.DownloadManagerNetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerSocketResponseMessage;
import com.baidu.tieba.filedownloader.TbDownloadManager;
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
public class qv6 extends ov6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public int c;
    public boolean d;
    public final ArrayList<mv6> e;
    public final ArrayList<mv6> f;
    public final ArrayList<String> g;
    public rv6 h;
    public DownloadManagerNetModel i;
    public TbDownloadManager j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qv6 qv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof mv6)) {
                mv6 mv6Var = (mv6) customResponsedMessage.getData();
                qv6 qv6Var = this.a;
                if (qv6Var.s(qv6Var.e, mv6Var)) {
                    return;
                }
                mv6Var.f = true;
                this.a.e.add(0, mv6Var);
                if (this.a.h != null) {
                    this.a.h.a(this.a.e, this.a.f, 0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<wc5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ qv6 b;

        public b(qv6 qv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qv6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<wc5> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (!this.a) {
                    new c(this.b, null).execute(list);
                } else {
                    this.b.w(list, true);
                }
            }
        }

        public final ItemData d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (StringUtils.isNull(str)) {
                    return null;
                }
                ItemData itemData = new ItemData();
                itemData.parseJson(str);
                return itemData;
            }
            return (ItemData) invokeL.objValue;
        }

        public /* synthetic */ b(qv6 qv6Var, a aVar) {
            this(qv6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<wc5> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                ArrayList arrayList = null;
                vu6 m = this.b.r(null).m();
                List<ksa> g = m.g();
                if (!ListUtils.isEmpty(g)) {
                    arrayList = new ArrayList(15);
                    if (this.b.b < g.size()) {
                        int i = this.b.b;
                        while (true) {
                            if (i >= g.size()) {
                                break;
                            }
                            ksa ksaVar = g.get(i);
                            if (ksaVar != null) {
                                if (!StringUtils.isNull(ksaVar.h()) && !StringUtils.isNull(ksaVar.c())) {
                                    wc5 wc5Var = new wc5();
                                    wc5Var.a = ksaVar.h();
                                    ksaVar.s();
                                    wc5Var.d = ksaVar.r();
                                    wc5Var.c = ksaVar.c();
                                    ItemData d = d(ksaVar.c());
                                    wc5Var.b = d;
                                    if (d != null && d.apkDetail != null) {
                                        PackageInfo e = xj5.e(ksaVar.h());
                                        if (e != null && e.versionCode >= wc5Var.b.apkDetail.version_code.intValue()) {
                                            DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, 已安装数据不需要展示，删除数据库对应数据");
                                            m.c(ksaVar);
                                        } else {
                                            DownloadData downloadData = new DownloadData();
                                            downloadData.setId(ksaVar.t());
                                            if (d != null) {
                                                downloadData.setName(d.mTitle);
                                                downloadData.setItemData(d);
                                            }
                                            if (this.b.r(downloadData).q(downloadData) == 3 && !new File(this.b.r(downloadData).o(downloadData)).exists()) {
                                                DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, 已下载完成，但是没有安装包的，删除数据库对应数据");
                                                m.c(ksaVar);
                                            } else {
                                                qv6.k(this.b);
                                                arrayList.add(wc5Var);
                                                this.b.g.add(wc5Var.a);
                                                if (arrayList.size() >= 15) {
                                                    if (i < g.size()) {
                                                        this.a = true;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, apkDetail为空，删除数据库对应数据");
                                        m.c(ksaVar);
                                    }
                                } else {
                                    DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, packageName或detailInfo为空，删除数据库对应数据");
                                    m.c(ksaVar);
                                }
                            }
                            i++;
                        }
                    } else {
                        return arrayList;
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<List<wc5>, Integer, List<wc5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ qv6 b;

        public c(qv6 qv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qv6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<wc5> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) {
                return;
            }
            this.b.w(list, this.a);
        }

        public final ItemData d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                ItemData itemData = new ItemData();
                itemData.parseJson(str);
                return itemData;
            }
            return (ItemData) invokeL.objValue;
        }

        public /* synthetic */ c(qv6 qv6Var, a aVar) {
            this(qv6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0139 A[EDGE_INSN: B:77:0x0139->B:62:0x0139 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0135 A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<wc5> doInBackground(List<wc5>... listArr) {
            InterceptResult invokeL;
            List<wc5> list;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                List<wc5> d = nv6.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (listArr != null && listArr.length > 0) {
                    list = listArr[0];
                } else {
                    list = null;
                }
                if (!ListUtils.isEmpty(list)) {
                    i = list.size();
                } else {
                    i = 0;
                }
                if (this.b.c <= 0 || this.b.c < d.size()) {
                    int i2 = this.b.c;
                    while (i2 < d.size()) {
                        qv6.o(this.b);
                        wc5 wc5Var = d.get(i2);
                        ItemData d2 = d(wc5Var.c);
                        wc5Var.b = d2;
                        d2.isFromTbDownloaderTable = true;
                        if (this.b.v(list, wc5Var)) {
                            qv6.p(this.b);
                        } else if (wc5Var != null && !rd.isEmpty(wc5Var.a) && !rd.isEmpty(wc5Var.c)) {
                            ItemData itemData = wc5Var.b;
                            if (itemData != null && itemData.apkDetail != null) {
                                PackageInfo e = xj5.e(wc5Var.a);
                                if (e != null && e.versionCode >= wc5Var.b.apkDetail.version_code.intValue() && !mv6.e(wc5Var.d)) {
                                    nv6.e().c(wc5Var.a);
                                    qv6.p(this.b);
                                } else if (wc5Var.d == 2) {
                                    if (!td5.q().s(wc5Var.a) && xj5.d(wc5Var.a, wc5Var.b.appId) == 6) {
                                        nv6.e().c(wc5Var.a);
                                        qv6.p(this.b);
                                    }
                                    arrayList.add(wc5Var);
                                    this.b.g.add(wc5Var.a);
                                    if (arrayList.size() + i < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData k = xj5.k(wc5Var.b);
                                    if (xj5.c(k) == 6 && !xj5.b(k) && !mv6.e(wc5Var.d)) {
                                        nv6.e().c(wc5Var.a);
                                        qv6.p(this.b);
                                    }
                                    arrayList.add(wc5Var);
                                    this.b.g.add(wc5Var.a);
                                    if (arrayList.size() + i < 15) {
                                    }
                                }
                            } else {
                                nv6.e().c(wc5Var.a);
                                qv6.p(this.b);
                            }
                        }
                        i2++;
                    }
                    if (!ListUtils.isEmpty(list)) {
                        arrayList.addAll(0, list);
                    }
                    if (arrayList.size() >= 15 && i2 < d.size()) {
                        this.a = true;
                    } else {
                        this.a = false;
                    }
                    return arrayList;
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qv6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        super(tbPageContext, bdUniqueId, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, new uv6(1, i));
        this.i = downloadManagerNetModel;
        downloadManagerNetModel.q0(this);
        this.i.setUniqueId(bdUniqueId);
        t(bdUniqueId);
    }

    public static /* synthetic */ int k(qv6 qv6Var) {
        int i = qv6Var.b;
        qv6Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int o(qv6 qv6Var) {
        int i = qv6Var.c;
        qv6Var.c = i + 1;
        return i;
    }

    public static /* synthetic */ int p(qv6 qv6Var) {
        int i = qv6Var.c;
        qv6Var.c = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.ov6
    public void d(rv6 rv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rv6Var) == null) {
            this.h = rv6Var;
        }
    }

    public final void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void I(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.d = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            vv6 vv6Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                vv6Var = (vv6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (vv6Var != null && y(vv6Var)) {
                return;
            }
            x();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.d = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            vv6 vv6Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                vv6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (vv6Var != null && y(vv6Var)) {
                return;
            }
            x();
        }
    }

    @Override // com.baidu.tieba.ov6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d) {
            return;
        }
        q();
    }

    @Override // com.baidu.tieba.ov6
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.d) {
            return;
        }
        this.b = 0;
        this.c = 0;
        this.e.clear();
        this.f.clear();
        q();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final void x() {
        rv6 rv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (rv6Var = this.h) != null) {
            rv6Var.a(this.e, null, 0);
        }
    }

    public TbDownloadManager r(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, downloadData)) == null) {
            if (this.j == null) {
                this.j = new TbDownloadManager();
            }
            if (downloadData != null && downloadData.getItemData() != null) {
                if (downloadData.getItemData().isFromTbDownloaderTable) {
                    this.j.w(1);
                } else if (downloadData.getItemData().mTbFileDownloaderType > 0) {
                    this.j.w(downloadData.getItemData().mTbFileDownloaderType);
                }
            }
            return this.j;
        }
        return (TbDownloadManager) invokeL.objValue;
    }

    public final boolean y(vv6 vv6Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vv6Var)) == null) {
            if (vv6Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(vv6Var.b)) {
                for (mv6 mv6Var : vv6Var.b) {
                    if (mv6Var != null && (itemData = mv6Var.a) != null && !this.g.contains(itemData.pkgName) && xj5.e(mv6Var.a.pkgName) == null) {
                        this.f.add(mv6Var);
                    }
                }
            }
            rv6 rv6Var = this.h;
            if (rv6Var != null) {
                rv6Var.a(this.e, this.f, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(ArrayList<mv6> arrayList, mv6 mv6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, mv6Var)) == null) {
            Iterator<mv6> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().d(mv6Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean v(List<wc5> list, wc5 wc5Var) {
        InterceptResult invokeLL;
        ItemData itemData;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, list, wc5Var)) == null) {
            if (!ListUtils.isEmpty(list) && wc5Var != null) {
                for (int i = 0; i < list.size(); i++) {
                    wc5 wc5Var2 = list.get(i);
                    if (wc5Var2 != null && (itemData = wc5Var2.b) != null && (itemData2 = wc5Var.b) != null && itemData.itemId == itemData2.itemId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void w(List<wc5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (wc5 wc5Var : list) {
                if (wc5Var != null && wc5Var.b != null) {
                    mv6 b2 = mv6.b(wc5Var);
                    b2.f = true;
                    arrayList.add(b2);
                }
            }
            this.e.addAll(arrayList);
            if (ListUtils.getCount(this.e) <= 4) {
                this.i.loadData();
                return;
            }
            this.d = false;
            rv6 rv6Var = this.h;
            if (rv6Var != null) {
                rv6Var.a(this.e, null, z ? 1 : 0);
            }
        }
    }
}
