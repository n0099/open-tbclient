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
public class wy6 extends uy6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public int c;
    public boolean d;
    public final ArrayList<sy6> e;
    public final ArrayList<sy6> f;
    public final ArrayList<String> g;
    public xy6 h;
    public DownloadManagerNetModel i;
    public TbDownloadManager j;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wy6 wy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy6Var, Integer.valueOf(i)};
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
            this.a = wy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof sy6)) {
                sy6 sy6Var = (sy6) customResponsedMessage.getData();
                wy6 wy6Var = this.a;
                if (wy6Var.s(wy6Var.e, sy6Var)) {
                    return;
                }
                sy6Var.f = true;
                this.a.e.add(0, sy6Var);
                if (this.a.h != null) {
                    this.a.h.a(this.a.e, this.a.f, 0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<ih5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ wy6 b;

        public b(wy6 wy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wy6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<ih5> list) {
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

        public /* synthetic */ b(wy6 wy6Var, a aVar) {
            this(wy6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<ih5> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                ArrayList arrayList = null;
                by6 m = this.b.r(null).m();
                List<pda> e = m.e();
                if (!ListUtils.isEmpty(e)) {
                    arrayList = new ArrayList(15);
                    if (this.b.b < e.size()) {
                        int i = this.b.b;
                        while (true) {
                            if (i >= e.size()) {
                                break;
                            }
                            pda pdaVar = e.get(i);
                            if (pdaVar != null) {
                                if (!StringUtils.isNull(pdaVar.g()) && !StringUtils.isNull(pdaVar.c())) {
                                    ih5 ih5Var = new ih5();
                                    ih5Var.a = pdaVar.g();
                                    pdaVar.q();
                                    ih5Var.d = pdaVar.p();
                                    ih5Var.c = pdaVar.c();
                                    ItemData d = d(pdaVar.c());
                                    ih5Var.b = d;
                                    if (d != null && d.apkDetail != null) {
                                        PackageInfo e2 = on5.e(pdaVar.g());
                                        if (e2 != null && e2.versionCode >= ih5Var.b.apkDetail.version_code.intValue()) {
                                            DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, 已安装数据不需要展示，删除数据库对应数据");
                                            m.b(pdaVar);
                                        } else {
                                            DownloadData downloadData = new DownloadData();
                                            downloadData.setId(pdaVar.r());
                                            if (d != null) {
                                                downloadData.setName(d.mTitle);
                                                downloadData.setItemData(d);
                                            }
                                            if (this.b.r(downloadData).q(downloadData) == 3 && !new File(this.b.r(downloadData).o(downloadData)).exists()) {
                                                DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, 已下载完成，但是没有安装包的，删除数据库对应数据");
                                                m.b(pdaVar);
                                            } else {
                                                wy6.k(this.b);
                                                arrayList.add(ih5Var);
                                                this.b.g.add(ih5Var.a);
                                                if (arrayList.size() >= 15) {
                                                    if (i < e.size()) {
                                                        this.a = true;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, apkDetail为空，删除数据库对应数据");
                                        m.b(pdaVar);
                                    }
                                } else {
                                    DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, packageName或detailInfo为空，删除数据库对应数据");
                                    m.b(pdaVar);
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
    public class c extends BdAsyncTask<List<ih5>, Integer, List<ih5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ wy6 b;

        public c(wy6 wy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wy6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<ih5> list) {
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

        public /* synthetic */ c(wy6 wy6Var, a aVar) {
            this(wy6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0139 A[EDGE_INSN: B:77:0x0139->B:62:0x0139 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0135 A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<ih5> doInBackground(List<ih5>... listArr) {
            InterceptResult invokeL;
            List<ih5> list;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                List<ih5> d = ty6.e().d();
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
                        wy6.o(this.b);
                        ih5 ih5Var = d.get(i2);
                        ItemData d2 = d(ih5Var.c);
                        ih5Var.b = d2;
                        d2.isFromTbDownloaderTable = true;
                        if (this.b.u(list, ih5Var)) {
                            wy6.p(this.b);
                        } else if (ih5Var != null && !ei.isEmpty(ih5Var.a) && !ei.isEmpty(ih5Var.c)) {
                            ItemData itemData = ih5Var.b;
                            if (itemData != null && itemData.apkDetail != null) {
                                PackageInfo e = on5.e(ih5Var.a);
                                if (e != null && e.versionCode >= ih5Var.b.apkDetail.version_code.intValue() && !sy6.e(ih5Var.d)) {
                                    ty6.e().c(ih5Var.a);
                                    wy6.p(this.b);
                                } else if (ih5Var.d == 2) {
                                    if (!ei5.q().s(ih5Var.a) && on5.d(ih5Var.a, ih5Var.b.appId) == 6) {
                                        ty6.e().c(ih5Var.a);
                                        wy6.p(this.b);
                                    }
                                    arrayList.add(ih5Var);
                                    this.b.g.add(ih5Var.a);
                                    if (arrayList.size() + i < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData k = on5.k(ih5Var.b);
                                    if (on5.c(k) == 6 && !on5.b(k) && !sy6.e(ih5Var.d)) {
                                        ty6.e().c(ih5Var.a);
                                        wy6.p(this.b);
                                    }
                                    arrayList.add(ih5Var);
                                    this.b.g.add(ih5Var.a);
                                    if (arrayList.size() + i < 15) {
                                    }
                                }
                            } else {
                                ty6.e().c(ih5Var.a);
                                wy6.p(this.b);
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
    public wy6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
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
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, new az6(1, i));
        this.i = downloadManagerNetModel;
        downloadManagerNetModel.o0(this);
        this.i.setUniqueId(bdUniqueId);
        t(bdUniqueId);
    }

    public static /* synthetic */ int k(wy6 wy6Var) {
        int i = wy6Var.b;
        wy6Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int o(wy6 wy6Var) {
        int i = wy6Var.c;
        wy6Var.c = i + 1;
        return i;
    }

    public static /* synthetic */ int p(wy6 wy6Var) {
        int i = wy6Var.c;
        wy6Var.c = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.uy6
    public void d(xy6 xy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xy6Var) == null) {
            this.h = xy6Var;
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
            bz6 bz6Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                bz6Var = (bz6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (bz6Var != null && y(bz6Var)) {
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
            bz6 bz6Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                bz6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (bz6Var != null && y(bz6Var)) {
                return;
            }
            x();
        }
    }

    @Override // com.baidu.tieba.uy6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d) {
            return;
        }
        q();
    }

    @Override // com.baidu.tieba.uy6
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
        xy6 xy6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (xy6Var = this.h) != null) {
            xy6Var.a(this.e, null, 0);
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

    public final boolean y(bz6 bz6Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bz6Var)) == null) {
            if (bz6Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(bz6Var.b)) {
                for (sy6 sy6Var : bz6Var.b) {
                    if (sy6Var != null && (itemData = sy6Var.a) != null && !this.g.contains(itemData.pkgName) && on5.e(sy6Var.a.pkgName) == null) {
                        this.f.add(sy6Var);
                    }
                }
            }
            xy6 xy6Var = this.h;
            if (xy6Var != null) {
                xy6Var.a(this.e, this.f, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(ArrayList<sy6> arrayList, sy6 sy6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, sy6Var)) == null) {
            Iterator<sy6> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().d(sy6Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean u(List<ih5> list, ih5 ih5Var) {
        InterceptResult invokeLL;
        ItemData itemData;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, ih5Var)) == null) {
            if (!ListUtils.isEmpty(list) && ih5Var != null) {
                for (int i = 0; i < list.size(); i++) {
                    ih5 ih5Var2 = list.get(i);
                    if (ih5Var2 != null && (itemData = ih5Var2.b) != null && (itemData2 = ih5Var.b) != null && itemData.itemId == itemData2.itemId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void w(List<ih5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (ih5 ih5Var : list) {
                if (ih5Var != null && ih5Var.b != null) {
                    sy6 b2 = sy6.b(ih5Var);
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
            xy6 xy6Var = this.h;
            if (xy6Var != null) {
                xy6Var.a(this.e, null, z ? 1 : 0);
            }
        }
    }
}
