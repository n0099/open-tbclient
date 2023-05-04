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
/* loaded from: classes7.dex */
public class zp6 extends xp6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<vp6> d;
    public final ArrayList<vp6> e;
    public final ArrayList<String> f;
    public aq6 g;
    public DownloadManagerNetModel h;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zp6 zp6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp6Var, Integer.valueOf(i)};
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
            this.a = zp6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vp6)) {
                vp6 vp6Var = (vp6) customResponsedMessage.getData();
                zp6 zp6Var = this.a;
                if (zp6Var.o(zp6Var.d, vp6Var)) {
                    return;
                }
                this.a.d.add(0, vp6Var);
                zp6.h(this.a);
                if (this.a.g != null) {
                    this.a.g.a(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<ec5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ zp6 b;

        public b(zp6 zp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zp6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<ec5> list) {
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

        public /* synthetic */ b(zp6 zp6Var, a aVar) {
            this(zp6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:60:0x010a A[EDGE_INSN: B:60:0x010a->B:48:0x010a ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0106 A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<ec5> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<ec5> d = wp6.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b < d.size()) {
                    int i = this.b.b;
                    while (i < d.size()) {
                        zp6.h(this.b);
                        ec5 ec5Var = d.get(i);
                        if (ec5Var != null && !hi.isEmpty(ec5Var.a) && !hi.isEmpty(ec5Var.c)) {
                            ItemData d2 = d(ec5Var.c);
                            ec5Var.b = d2;
                            if (d2 != null && d2.apkDetail != null) {
                                PackageInfo e = ah5.e(ec5Var.a);
                                if (e != null && e.versionCode >= ec5Var.b.apkDetail.version_code.intValue() && !vp6.e(ec5Var.d)) {
                                    wp6.e().c(ec5Var.a);
                                    zp6.i(this.b);
                                } else if (ec5Var.d == 2) {
                                    if (!cd5.q().s(ec5Var.a) && ah5.d(ec5Var.a, ec5Var.b.appId) == 6) {
                                        wp6.e().c(ec5Var.a);
                                        zp6.i(this.b);
                                    }
                                    arrayList.add(ec5Var);
                                    this.b.f.add(ec5Var.a);
                                    if (arrayList.size() < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData j = ah5.j(ec5Var.b);
                                    if (ah5.c(j) == 6 && !ah5.b(j.getId()) && !vp6.e(ec5Var.d)) {
                                        wp6.e().c(ec5Var.a);
                                        zp6.i(this.b);
                                    }
                                    arrayList.add(ec5Var);
                                    this.b.f.add(ec5Var.a);
                                    if (arrayList.size() < 15) {
                                    }
                                }
                            } else {
                                wp6.e().c(ec5Var.a);
                                zp6.i(this.b);
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
    public zp6(BaseFragment baseFragment, int i) {
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
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new dq6(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.x0(this);
        this.h.setUniqueId(baseFragment.getUniqueId());
        p(baseFragment);
    }

    public static /* synthetic */ int h(zp6 zp6Var) {
        int i = zp6Var.b;
        zp6Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(zp6 zp6Var) {
        int i = zp6Var.b;
        zp6Var.b = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.xp6
    public void d(aq6 aq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aq6Var) == null) {
            this.g = aq6Var;
        }
    }

    public final void p(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, baseFragment) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(baseFragment.getUniqueId());
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
            eq6 eq6Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                eq6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (eq6Var != null && s(eq6Var)) {
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
            eq6 eq6Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                eq6Var = (eq6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (eq6Var != null && s(eq6Var)) {
                return;
            }
            r();
        }
    }

    @Override // com.baidu.tieba.xp6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.c) {
            return;
        }
        n();
    }

    @Override // com.baidu.tieba.xp6
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
        aq6 aq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (aq6Var = this.g) != null) {
            aq6Var.a(this.d, null, 0);
        }
    }

    public final boolean o(ArrayList<vp6> arrayList, vp6 vp6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, vp6Var)) == null) {
            Iterator<vp6> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().d(vp6Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(List<ec5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (ec5 ec5Var : list) {
                if (ec5Var != null && ec5Var.b != null) {
                    arrayList.add(vp6.b(ec5Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            aq6 aq6Var = this.g;
            if (aq6Var != null) {
                aq6Var.a(this.d, null, z ? 1 : 0);
            }
        }
    }

    public final boolean s(eq6 eq6Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, eq6Var)) == null) {
            if (eq6Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(eq6Var.b)) {
                for (vp6 vp6Var : eq6Var.b) {
                    if (vp6Var != null && (itemData = vp6Var.a) != null && !this.f.contains(itemData.pkgName) && ah5.e(vp6Var.a.pkgName) == null) {
                        this.e.add(vp6Var);
                    }
                }
            }
            aq6 aq6Var = this.g;
            if (aq6Var != null) {
                aq6Var.a(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
