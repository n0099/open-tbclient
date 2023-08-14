package com.baidu.tieba;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.bigday.GetBigdayInfoHttpResMessage;
import com.baidu.tbadk.core.bigday.GetBigdayInfoReqMessage;
import com.baidu.tbadk.core.bigday.GetBigdayInfoSocketResMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes6.dex */
public class k05 {
    public static /* synthetic */ Interceptable $ic;
    public static k05 h;
    public transient /* synthetic */ FieldHolder $fh;
    public j05 a;
    public j05 b;
    public SparseArray<Long> c;
    public ArrayList<j05> d;
    public BdUniqueId e;
    public boolean f;
    public NetMessageListener g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947859289, "Lcom/baidu/tieba/k05;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947859289, "Lcom/baidu/tieba/k05;");
        }
    }

    /* loaded from: classes6.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k05 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k05 k05Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k05Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k05Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && !responsedMessage.hasError()) {
                this.a.f = true;
                ArrayList<j05> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                this.a.m(arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Void, Void, ArrayList<j05>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k05 a;

        public b(k05 k05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k05Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<j05> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                super.onPostExecute(arrayList);
                if (arrayList == null) {
                    return;
                }
                this.a.l(arrayList);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<j05> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                ArrayList<j05> arrayList = new ArrayList<>();
                l45.e();
                ne<byte[]> c = l45.c("tb.bigday_datas");
                if (c != null && (bArr = c.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    j05 j05Var = new j05();
                                    j05Var.b(bigdayInfo);
                                    if (j05Var.a()) {
                                        arrayList.add(j05Var);
                                    }
                                }
                            }
                            return arrayList;
                        }
                        return arrayList;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return arrayList;
            }
            return (ArrayList) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends DiskFileOperate implements rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<String> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, ArrayList<j05> arrayList) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList<>();
            Iterator<j05> it = arrayList.iterator();
            while (it.hasNext()) {
                j05 next = it.next();
                if (next != null) {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(next.a, 41);
                    if (!StringUtils.isNULL(genCacheKey)) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(genCacheKey);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.a.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.rb
        public boolean compare(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                if (file != null && !StringUtils.isNULL(file.getName())) {
                    return !this.a.contains(file.getName());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public k05() {
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
        this.f = false;
        this.g = new a(this, CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);
        aba.h(309609, GetBigdayInfoSocketResMessage.class, false, false);
        aba.c(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.g);
        this.c = new SparseArray<>();
    }

    public static k05 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (h == null) {
                h = new k05();
            }
            return h;
        }
        return (k05) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            new b(this).execute(new Void[0]);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f = false;
            GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
            getBigdayInfoReqMessage.setTag(this.e);
            MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
        }
    }

    public final void d(ArrayList<j05> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            ArrayList arrayList2 = new ArrayList();
            ListUtils.addAll(arrayList2, 0, arrayList);
            ListUtils.add(arrayList2, this.a);
            ListUtils.add(arrayList2, this.b);
            c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            ub.f().a(cVar);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || ListUtils.isEmpty(this.d)) {
            return;
        }
        Iterator<j05> it = this.d.iterator();
        while (it.hasNext()) {
            j05 next = it.next();
            if (!BigdayImageLoaderProc.isImageFileExist(next.a)) {
                BdResourceLoader.getInstance().loadResource(next.a, 41, null, this.e);
            }
        }
    }

    public final j05 g(List<j05> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, list, i)) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (j05 j05Var : list) {
                    if (j05Var.a() && j05Var.e == i) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        long j = j05Var.f;
                        if (j > currentTimeMillis) {
                            this.c.put(i, Long.valueOf(j));
                            return null;
                        } else if (j05Var.g >= currentTimeMillis) {
                            return j05Var;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (j05) invokeLI.objValue;
    }

    public j05 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (i == 1) {
                if (this.a == null && this.c.get(i, 0L).longValue() != 0 && this.c.get(i, 0L).longValue() < currentTimeMillis) {
                    this.a = g(this.d, 1);
                }
                j05 j05Var = this.a;
                if (j05Var != null && (currentTimeMillis < j05Var.f || currentTimeMillis > j05Var.g)) {
                    this.a = g(this.d, 1);
                }
                j05 j05Var2 = this.a;
                if (j05Var2 != null && BigdayImageLoaderProc.isImageFileExist(j05Var2.a)) {
                    return this.a;
                }
            } else if (i == 3) {
                if (this.b == null && this.c.get(i, 0L).longValue() != 0 && this.c.get(i, 0L).longValue() < currentTimeMillis) {
                    this.a = g(this.d, 3);
                }
                j05 j05Var3 = this.b;
                if (j05Var3 != null && (currentTimeMillis < j05Var3.f || currentTimeMillis > j05Var3.g)) {
                    this.b = g(this.d, 3);
                }
                j05 j05Var4 = this.b;
                if (j05Var4 != null && BigdayImageLoaderProc.isImageFileExist(j05Var4.a)) {
                    return this.b;
                }
            }
            return null;
        }
        return (j05) invokeI.objValue;
    }

    public final void l(ArrayList<j05> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, arrayList) != null) || ListUtils.isEmpty(arrayList) || this.f) {
            return;
        }
        this.a = g(arrayList, 1);
        this.b = g(arrayList, 3);
        this.d = arrayList;
        f();
        j05 j05Var = this.a;
        if (j05Var != null && BigdayImageLoaderProc.isImageFileExist(j05Var.a) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.a));
        }
    }

    public final void m(ArrayList<j05> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            j05 g = g(arrayList, 1);
            j05 g2 = g(arrayList, 3);
            d(arrayList);
            this.d = arrayList;
            if (g != null && g.a()) {
                this.a = g;
            }
            if (g2 != null && g2.a()) {
                this.b = g2;
            }
            f();
            j05 j05Var = this.a;
            if (j05Var != null && BigdayImageLoaderProc.isImageFileExist(j05Var.a) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.a));
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.e = bdUniqueId;
        }
    }
}
