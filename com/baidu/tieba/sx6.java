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
public class sx6 extends qx6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public int c;
    public boolean d;
    public final ArrayList<ox6> e;
    public final ArrayList<ox6> f;
    public final ArrayList<String> g;
    public tx6 h;
    public DownloadManagerNetModel i;
    public TbDownloadManager j;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sx6 sx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx6Var, Integer.valueOf(i)};
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
            this.a = sx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ox6)) {
                ox6 ox6Var = (ox6) customResponsedMessage.getData();
                sx6 sx6Var = this.a;
                if (sx6Var.s(sx6Var.e, ox6Var)) {
                    return;
                }
                ox6Var.f = true;
                this.a.e.add(0, ox6Var);
                if (this.a.h != null) {
                    this.a.h.a(this.a.e, this.a.f, 0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<pg5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ sx6 b;

        public b(sx6 sx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sx6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<pg5> list) {
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

        public /* synthetic */ b(sx6 sx6Var, a aVar) {
            this(sx6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<pg5> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                ArrayList arrayList = null;
                xw6 m = this.b.r(null).m();
                List<wba> e = m.e();
                if (!ListUtils.isEmpty(e)) {
                    arrayList = new ArrayList(15);
                    if (this.b.b < e.size()) {
                        int i = this.b.b;
                        while (true) {
                            if (i >= e.size()) {
                                break;
                            }
                            wba wbaVar = e.get(i);
                            if (wbaVar != null) {
                                if (!StringUtils.isNull(wbaVar.g()) && !StringUtils.isNull(wbaVar.c())) {
                                    pg5 pg5Var = new pg5();
                                    pg5Var.a = wbaVar.g();
                                    wbaVar.q();
                                    pg5Var.d = wbaVar.p();
                                    pg5Var.c = wbaVar.c();
                                    ItemData d = d(wbaVar.c());
                                    pg5Var.b = d;
                                    if (d != null && d.apkDetail != null) {
                                        PackageInfo e2 = vm5.e(wbaVar.g());
                                        if (e2 != null && e2.versionCode >= pg5Var.b.apkDetail.version_code.intValue()) {
                                            DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, 已安装数据不需要展示，删除数据库对应数据");
                                            m.b(wbaVar);
                                        } else {
                                            DownloadData downloadData = new DownloadData();
                                            downloadData.setId(wbaVar.r());
                                            if (d != null) {
                                                downloadData.setName(d.mTitle);
                                                downloadData.setItemData(d);
                                            }
                                            if (this.b.r(downloadData).q(downloadData) == 3 && !new File(this.b.r(downloadData).o(downloadData)).exists()) {
                                                DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, 已下载完成，但是没有安装包的，删除数据库对应数据");
                                                m.b(wbaVar);
                                            } else {
                                                sx6.k(this.b);
                                                arrayList.add(pg5Var);
                                                this.b.g.add(pg5Var.a);
                                                if (arrayList.size() >= 15) {
                                                    if (i < e.size()) {
                                                        this.a = true;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, apkDetail为空，删除数据库对应数据");
                                        m.b(wbaVar);
                                    }
                                } else {
                                    DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, packageName或detailInfo为空，删除数据库对应数据");
                                    m.b(wbaVar);
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

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<List<pg5>, Integer, List<pg5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ sx6 b;

        public c(sx6 sx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sx6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<pg5> list) {
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

        public /* synthetic */ c(sx6 sx6Var, a aVar) {
            this(sx6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0139 A[EDGE_INSN: B:77:0x0139->B:62:0x0139 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0135 A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<pg5> doInBackground(List<pg5>... listArr) {
            InterceptResult invokeL;
            List<pg5> list;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                List<pg5> d = px6.e().d();
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
                        sx6.o(this.b);
                        pg5 pg5Var = d.get(i2);
                        ItemData d2 = d(pg5Var.c);
                        pg5Var.b = d2;
                        d2.isFromTbDownloaderTable = true;
                        if (this.b.u(list, pg5Var)) {
                            sx6.p(this.b);
                        } else if (pg5Var != null && !di.isEmpty(pg5Var.a) && !di.isEmpty(pg5Var.c)) {
                            ItemData itemData = pg5Var.b;
                            if (itemData != null && itemData.apkDetail != null) {
                                PackageInfo e = vm5.e(pg5Var.a);
                                if (e != null && e.versionCode >= pg5Var.b.apkDetail.version_code.intValue() && !ox6.e(pg5Var.d)) {
                                    px6.e().c(pg5Var.a);
                                    sx6.p(this.b);
                                } else if (pg5Var.d == 2) {
                                    if (!lh5.q().s(pg5Var.a) && vm5.d(pg5Var.a, pg5Var.b.appId) == 6) {
                                        px6.e().c(pg5Var.a);
                                        sx6.p(this.b);
                                    }
                                    arrayList.add(pg5Var);
                                    this.b.g.add(pg5Var.a);
                                    if (arrayList.size() + i < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData k = vm5.k(pg5Var.b);
                                    if (vm5.c(k) == 6 && !vm5.b(k) && !ox6.e(pg5Var.d)) {
                                        px6.e().c(pg5Var.a);
                                        sx6.p(this.b);
                                    }
                                    arrayList.add(pg5Var);
                                    this.b.g.add(pg5Var.a);
                                    if (arrayList.size() + i < 15) {
                                    }
                                }
                            } else {
                                px6.e().c(pg5Var.a);
                                sx6.p(this.b);
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
    public sx6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
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
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, new wx6(1, i));
        this.i = downloadManagerNetModel;
        downloadManagerNetModel.p0(this);
        this.i.setUniqueId(bdUniqueId);
        t(bdUniqueId);
    }

    public static /* synthetic */ int k(sx6 sx6Var) {
        int i = sx6Var.b;
        sx6Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int o(sx6 sx6Var) {
        int i = sx6Var.c;
        sx6Var.c = i + 1;
        return i;
    }

    public static /* synthetic */ int p(sx6 sx6Var) {
        int i = sx6Var.c;
        sx6Var.c = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.qx6
    public void d(tx6 tx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tx6Var) == null) {
            this.h = tx6Var;
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
    public void G(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.d = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            xx6 xx6Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                xx6Var = (xx6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (xx6Var != null && y(xx6Var)) {
                return;
            }
            x();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.d = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            xx6 xx6Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                xx6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (xx6Var != null && y(xx6Var)) {
                return;
            }
            x();
        }
    }

    @Override // com.baidu.tieba.qx6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d) {
            return;
        }
        q();
    }

    @Override // com.baidu.tieba.qx6
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
        tx6 tx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (tx6Var = this.h) != null) {
            tx6Var.a(this.e, null, 0);
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

    public final boolean y(xx6 xx6Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, xx6Var)) == null) {
            if (xx6Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(xx6Var.b)) {
                for (ox6 ox6Var : xx6Var.b) {
                    if (ox6Var != null && (itemData = ox6Var.a) != null && !this.g.contains(itemData.pkgName) && vm5.e(ox6Var.a.pkgName) == null) {
                        this.f.add(ox6Var);
                    }
                }
            }
            tx6 tx6Var = this.h;
            if (tx6Var != null) {
                tx6Var.a(this.e, this.f, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(ArrayList<ox6> arrayList, ox6 ox6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, ox6Var)) == null) {
            Iterator<ox6> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().d(ox6Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean u(List<pg5> list, pg5 pg5Var) {
        InterceptResult invokeLL;
        ItemData itemData;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, pg5Var)) == null) {
            if (!ListUtils.isEmpty(list) && pg5Var != null) {
                for (int i = 0; i < list.size(); i++) {
                    pg5 pg5Var2 = list.get(i);
                    if (pg5Var2 != null && (itemData = pg5Var2.b) != null && (itemData2 = pg5Var.b) != null && itemData.itemId == itemData2.itemId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void w(List<pg5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (pg5 pg5Var : list) {
                if (pg5Var != null && pg5Var.b != null) {
                    ox6 b2 = ox6.b(pg5Var);
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
            tx6 tx6Var = this.h;
            if (tx6Var != null) {
                tx6Var.a(this.e, null, z ? 1 : 0);
            }
        }
    }
}
