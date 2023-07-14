package com.baidu.tieba;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class wy6 extends uy6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<sy6> d;
    public final ArrayList<sy6> e;
    public final ArrayList<String> f;
    public xy6 g;
    public DownloadManagerNetModel h;

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
                if (wy6Var.o(wy6Var.d, sy6Var)) {
                    return;
                }
                this.a.d.add(0, sy6Var);
                wy6.h(this.a);
                if (this.a.g != null) {
                    this.a.g.a(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<wh5>> {
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
        public void onPostExecute(List<wh5> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) {
                return;
            }
            this.b.q(list, this.a);
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

        public /* synthetic */ b(wy6 wy6Var, a aVar) {
            this(wy6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:60:0x010a A[EDGE_INSN: B:60:0x010a->B:48:0x010a ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0106 A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<wh5> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<wh5> d = ty6.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b < d.size()) {
                    int i = this.b.b;
                    while (i < d.size()) {
                        wy6.h(this.b);
                        wh5 wh5Var = d.get(i);
                        if (wh5Var != null && !xi.isEmpty(wh5Var.a) && !xi.isEmpty(wh5Var.c)) {
                            ItemData d2 = d(wh5Var.c);
                            wh5Var.b = d2;
                            if (d2 != null && d2.apkDetail != null) {
                                PackageInfo e = un5.e(wh5Var.a);
                                if (e != null && e.versionCode >= wh5Var.b.apkDetail.version_code.intValue() && !sy6.e(wh5Var.d)) {
                                    ty6.e().c(wh5Var.a);
                                    wy6.i(this.b);
                                } else if (wh5Var.d == 2) {
                                    if (!si5.q().s(wh5Var.a) && un5.d(wh5Var.a, wh5Var.b.appId) == 6) {
                                        ty6.e().c(wh5Var.a);
                                        wy6.i(this.b);
                                    }
                                    arrayList.add(wh5Var);
                                    this.b.f.add(wh5Var.a);
                                    if (arrayList.size() < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData j = un5.j(wh5Var.b);
                                    if (un5.c(j) == 6 && !un5.b(j.getId()) && !sy6.e(wh5Var.d)) {
                                        ty6.e().c(wh5Var.a);
                                        wy6.i(this.b);
                                    }
                                    arrayList.add(wh5Var);
                                    this.b.f.add(wh5Var.a);
                                    if (arrayList.size() < 15) {
                                    }
                                }
                            } else {
                                ty6.e().c(wh5Var.a);
                                wy6.i(this.b);
                            }
                        }
                        i++;
                    }
                    if (arrayList.size() >= 15 && i < d.size()) {
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
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, new az6(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.x0(this);
        this.h.setUniqueId(bdUniqueId);
        p(bdUniqueId);
    }

    public static /* synthetic */ int h(wy6 wy6Var) {
        int i = wy6Var.b;
        wy6Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(wy6 wy6Var) {
        int i = wy6Var.b;
        wy6Var.b = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.uy6
    public void d(xy6 xy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xy6Var) == null) {
            this.g = xy6Var;
        }
    }

    public final void p(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void A(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            bz6 bz6Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                bz6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (bz6Var != null && s(bz6Var)) {
                return;
            }
            r();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void M(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            bz6 bz6Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                bz6Var = (bz6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (bz6Var != null && s(bz6Var)) {
                return;
            }
            r();
        }
    }

    @Override // com.baidu.tieba.uy6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.c) {
            return;
        }
        n();
    }

    @Override // com.baidu.tieba.uy6
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.c) {
            return;
        }
        this.b = 0;
        this.d.clear();
        this.e.clear();
        n();
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final void r() {
        xy6 xy6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (xy6Var = this.g) != null) {
            xy6Var.a(this.d, null, 0);
        }
    }

    public final boolean o(ArrayList<sy6> arrayList, sy6 sy6Var) {
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

    public final void q(List<wh5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (wh5 wh5Var : list) {
                if (wh5Var != null && wh5Var.b != null) {
                    arrayList.add(sy6.b(wh5Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            xy6 xy6Var = this.g;
            if (xy6Var != null) {
                xy6Var.a(this.d, null, z ? 1 : 0);
            }
        }
    }

    public final boolean s(bz6 bz6Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bz6Var)) == null) {
            if (bz6Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(bz6Var.b)) {
                for (sy6 sy6Var : bz6Var.b) {
                    if (sy6Var != null && (itemData = sy6Var.a) != null && !this.f.contains(itemData.pkgName) && un5.e(sy6Var.a.pkgName) == null) {
                        this.e.add(sy6Var);
                    }
                }
            }
            xy6 xy6Var = this.g;
            if (xy6Var != null) {
                xy6Var.a(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
