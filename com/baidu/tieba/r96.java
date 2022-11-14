package com.baidu.tieba;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
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
/* loaded from: classes5.dex */
public class r96 extends p96 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<n96> d;
    public final ArrayList<n96> e;
    public final ArrayList<String> f;
    public s96 g;
    public DownloadManagerNetModel h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r96 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r96 r96Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r96Var, Integer.valueOf(i)};
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
            this.a = r96Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof n96)) {
                n96 n96Var = (n96) customResponsedMessage.getData();
                r96 r96Var = this.a;
                if (r96Var.p(r96Var.d, n96Var)) {
                    return;
                }
                this.a.d.add(0, n96Var);
                r96.h(this.a);
                if (this.a.g != null) {
                    this.a.g.a(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<i55>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ r96 b;

        public b(r96 r96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r96Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<i55> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) {
                return;
            }
            this.b.r(list, this.a);
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

        public /* synthetic */ b(r96 r96Var, a aVar) {
            this(r96Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0103 A[EDGE_INSN: B:60:0x0103->B:48:0x0103 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00ff A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<i55> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<i55> d = o96.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b < d.size()) {
                    int i = this.b.b;
                    while (i < d.size()) {
                        r96.h(this.b);
                        i55 i55Var = d.get(i);
                        if (i55Var != null && !xi.isEmpty(i55Var.a) && !xi.isEmpty(i55Var.c)) {
                            ItemData d2 = d(i55Var.c);
                            i55Var.b = d2;
                            if (d2 != null && d2.apkDetail != null) {
                                PackageInfo e = aa5.e(i55Var.a);
                                if (e != null && e.versionCode >= i55Var.b.apkDetail.version_code.intValue() && i55Var.d != 3) {
                                    o96.e().c(i55Var.a);
                                    r96.i(this.b);
                                } else if (i55Var.d == 2) {
                                    if (!d65.q().s(i55Var.a) && aa5.d(i55Var.a, i55Var.b.appId) == 6) {
                                        o96.e().c(i55Var.a);
                                        r96.i(this.b);
                                    }
                                    arrayList.add(i55Var);
                                    this.b.f.add(i55Var.a);
                                    if (arrayList.size() < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData j = aa5.j(i55Var.b);
                                    if (aa5.c(j) == 6 && !aa5.b(j.getId()) && i55Var.d != 3) {
                                        o96.e().c(i55Var.a);
                                        r96.i(this.b);
                                    }
                                    arrayList.add(i55Var);
                                    this.b.f.add(i55Var.a);
                                    if (arrayList.size() < 15) {
                                    }
                                }
                            } else {
                                o96.e().c(i55Var.a);
                                r96.i(this.b);
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
    public r96(BaseFragment baseFragment, int i) {
        super(baseFragment, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragment) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new v96(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.b0(this);
        this.h.setUniqueId(baseFragment.getUniqueId());
        q(baseFragment);
    }

    public static /* synthetic */ int h(r96 r96Var) {
        int i = r96Var.b;
        r96Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(r96 r96Var) {
        int i = r96Var.b;
        r96Var.b = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.p96
    public void d(s96 s96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s96Var) == null) {
            this.g = s96Var;
        }
    }

    public final void q(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, baseFragment) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(baseFragment.getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tieba.p96
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c) {
            return;
        }
        o();
    }

    @Override // com.baidu.tieba.p96
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c) {
            return;
        }
        this.b = 0;
        this.d.clear();
        this.e.clear();
        o();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final void t() {
        s96 s96Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (s96Var = this.g) != null) {
            s96Var.a(this.d, null, 0);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            w96 w96Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                w96Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (w96Var != null && u(w96Var)) {
                return;
            }
            t();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            w96 w96Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                w96Var = (w96) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (w96Var != null && u(w96Var)) {
                return;
            }
            t();
        }
    }

    public final boolean p(ArrayList<n96> arrayList, n96 n96Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, n96Var)) == null) {
            Iterator<n96> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f(n96Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void r(List<i55> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (i55 i55Var : list) {
                if (i55Var != null && i55Var.b != null) {
                    arrayList.add(n96.b(i55Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            s96 s96Var = this.g;
            if (s96Var != null) {
                s96Var.a(this.d, null, z ? 1 : 0);
            }
        }
    }

    public final boolean u(w96 w96Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, w96Var)) == null) {
            if (w96Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(w96Var.b)) {
                for (n96 n96Var : w96Var.b) {
                    if (n96Var != null && (itemData = n96Var.a) != null && !this.f.contains(itemData.pkgName) && aa5.e(n96Var.a.pkgName) == null) {
                        this.e.add(n96Var);
                    }
                }
            }
            s96 s96Var = this.g;
            if (s96Var != null) {
                s96Var.a(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
