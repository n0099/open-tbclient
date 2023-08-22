package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class na8 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ro6> a;
    public z25 b;
    public long c;
    public int d;
    public List<bn> e;
    @Nullable
    public Map<String, Object> f;

    public na8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.e = new ArrayList();
        this.d = 1;
    }

    @Nullable
    public Map<String, Object> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public na8(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.e = new ArrayList();
        this.d = i;
    }

    public final void f(List<ro6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            ro6 ro6Var = list.get(list.size() - 1);
            if (ro6Var.getThreadData() != null) {
                this.c = JavaTypesHelper.toLong(ro6Var.getThreadData().getTid(), 0L);
            }
        }
    }

    public final void c(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.insertItemToTitleOrAbstractText();
                this.e.add(threadData);
            }
        }
    }

    public ArrayList<bn> d(n35 n35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n35Var)) == null) {
            ArrayList<bn> arrayList = new ArrayList<>(this.e);
            g(arrayList, n35Var);
            ArrayList<bn> arrayList2 = new ArrayList<>();
            Iterator<bn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                bn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        c45 c45Var = new c45();
                        c45Var.t = threadData;
                        c45Var.position = i;
                        c45Var.a = true;
                        arrayList2.add(c45Var);
                        c45 c45Var2 = new c45();
                        c45Var2.t = threadData;
                        c45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            c45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            c45Var2.d = true;
                            c45Var2.u = imageWidthAndHeight[0];
                            c45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            c45Var2.e = true;
                        } else {
                            c45Var2.b = true;
                        }
                        arrayList2.add(c45Var2);
                        if (threadData.getItem() != null) {
                            c45 c45Var3 = new c45();
                            c45Var3.n = true;
                            c45Var3.t = threadData;
                            c45Var3.position = i;
                            arrayList2.add(c45Var3);
                        }
                        c45 c45Var4 = new c45();
                        c45Var4.m = true;
                        c45Var4.t = threadData;
                        c45Var4.position = i;
                        arrayList2.add(c45Var4);
                        c45 c45Var5 = new c45();
                        c45Var5.g = true;
                        c45Var5.t = threadData;
                        c45Var5.position = i;
                        arrayList2.add(c45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        c45 c45Var6 = new c45();
                        c45Var6.t = threadData;
                        c45Var6.position = i;
                        c45Var6.a = true;
                        arrayList2.add(c45Var6);
                        c45 c45Var7 = new c45();
                        c45Var7.t = threadData;
                        c45Var7.position = i;
                        c45Var7.i = true;
                        arrayList2.add(c45Var7);
                        if (threadData.getItem() != null) {
                            c45 c45Var8 = new c45();
                            c45Var8.n = true;
                            c45Var8.t = threadData;
                            c45Var8.position = i;
                            arrayList2.add(c45Var8);
                        }
                        c45 c45Var9 = new c45();
                        c45Var9.m = true;
                        c45Var9.t = threadData;
                        c45Var9.position = i;
                        arrayList2.add(c45Var9);
                        c45 c45Var10 = new c45();
                        c45Var10.g = true;
                        c45Var10.t = threadData;
                        c45Var10.position = i;
                        arrayList2.add(c45Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (yo6.R(threadData)) {
                        yo6 yo6Var = new yo6(threadData);
                        yo6Var.g = threadData.getTid();
                        arrayList2.add(yo6Var);
                    } else {
                        c45 c45Var11 = new c45();
                        c45Var11.t = threadData;
                        c45Var11.position = i;
                        arrayList2.add(c45Var11);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void g(ArrayList<bn> arrayList, n35 n35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, n35Var) == null) && n35Var != null && !ListUtils.isEmpty(n35Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (n35Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, n35Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, n35Var);
            }
        }
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, dataRes) != null) || dataRes == null) {
            return;
        }
        this.f = DataExt.toMap(dataRes);
        if (dataRes.thread_list != null) {
            this.a = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.setResource(5);
                    ro6 ro6Var = null;
                    if (ap6.L(threadData)) {
                        ro6Var = new ap6(threadData);
                    } else if (zo6.R(threadData)) {
                        ro6Var = new zo6();
                        ro6Var.a = threadData;
                    }
                    if (ro6Var != null && ro6Var.isValid()) {
                        ro6Var.E("c10816");
                        this.a.add(ro6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            z25 z25Var = new z25();
            this.b = z25Var;
            z25Var.j(dataRes.page);
        }
    }

    public void i(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, hotThread) != null) || hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.a = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.setResource(5);
                    ro6 ro6Var = null;
                    if (threadData.isShareThread) {
                        ro6Var = new zo6();
                        ro6Var.a = threadData;
                    } else if (ap6.L(threadData)) {
                        ro6Var = new ap6(threadData);
                    } else if (zo6.R(threadData)) {
                        ro6Var = new zo6();
                        ro6Var.a = threadData;
                    }
                    if (ro6Var != null && ro6Var.isValid()) {
                        ro6Var.E("c10816");
                        this.a.add(ro6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            z25 z25Var = new z25();
            this.b = z25Var;
            z25Var.j(hotThread.page);
        }
    }
}
