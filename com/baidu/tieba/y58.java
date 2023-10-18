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
/* loaded from: classes8.dex */
public class y58 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<jk6> a;
    public mx4 b;
    public long c;
    public int d;
    public List<yh> e;
    @Nullable
    public Map<String, Object> f;

    public y58() {
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

    public y58(int i) {
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

    public final void f(List<jk6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            jk6 jk6Var = list.get(list.size() - 1);
            if (jk6Var.getThreadData() != null) {
                this.c = JavaTypesHelper.toLong(jk6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<yh> d(ay4 ay4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ay4Var)) == null) {
            ArrayList<yh> arrayList = new ArrayList<>(this.e);
            g(arrayList, ay4Var);
            ArrayList<yh> arrayList2 = new ArrayList<>();
            Iterator<yh> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yh next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        py4 py4Var = new py4();
                        py4Var.t = threadData;
                        py4Var.position = i;
                        py4Var.a = true;
                        arrayList2.add(py4Var);
                        py4 py4Var2 = new py4();
                        py4Var2.t = threadData;
                        py4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            py4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            py4Var2.d = true;
                            py4Var2.u = imageWidthAndHeight[0];
                            py4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            py4Var2.e = true;
                        } else {
                            py4Var2.b = true;
                        }
                        arrayList2.add(py4Var2);
                        if (threadData.getItem() != null) {
                            py4 py4Var3 = new py4();
                            py4Var3.n = true;
                            py4Var3.t = threadData;
                            py4Var3.position = i;
                            arrayList2.add(py4Var3);
                        }
                        py4 py4Var4 = new py4();
                        py4Var4.m = true;
                        py4Var4.t = threadData;
                        py4Var4.position = i;
                        arrayList2.add(py4Var4);
                        py4 py4Var5 = new py4();
                        py4Var5.g = true;
                        py4Var5.t = threadData;
                        py4Var5.position = i;
                        arrayList2.add(py4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        py4 py4Var6 = new py4();
                        py4Var6.t = threadData;
                        py4Var6.position = i;
                        py4Var6.a = true;
                        arrayList2.add(py4Var6);
                        py4 py4Var7 = new py4();
                        py4Var7.t = threadData;
                        py4Var7.position = i;
                        py4Var7.i = true;
                        arrayList2.add(py4Var7);
                        if (threadData.getItem() != null) {
                            py4 py4Var8 = new py4();
                            py4Var8.n = true;
                            py4Var8.t = threadData;
                            py4Var8.position = i;
                            arrayList2.add(py4Var8);
                        }
                        py4 py4Var9 = new py4();
                        py4Var9.m = true;
                        py4Var9.t = threadData;
                        py4Var9.position = i;
                        arrayList2.add(py4Var9);
                        py4 py4Var10 = new py4();
                        py4Var10.g = true;
                        py4Var10.t = threadData;
                        py4Var10.position = i;
                        arrayList2.add(py4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (qk6.R(threadData)) {
                        qk6 qk6Var = new qk6(threadData);
                        qk6Var.g = threadData.getTid();
                        arrayList2.add(qk6Var);
                    } else {
                        py4 py4Var11 = new py4();
                        py4Var11.t = threadData;
                        py4Var11.position = i;
                        arrayList2.add(py4Var11);
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

    public final void g(ArrayList<yh> arrayList, ay4 ay4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, ay4Var) == null) && ay4Var != null && !ListUtils.isEmpty(ay4Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (ay4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, ay4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, ay4Var);
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
                    jk6 jk6Var = null;
                    if (sk6.L(threadData)) {
                        jk6Var = new sk6(threadData);
                    } else if (rk6.R(threadData)) {
                        jk6Var = new rk6();
                        jk6Var.a = threadData;
                    }
                    if (jk6Var != null && jk6Var.isValid()) {
                        jk6Var.E("c10816");
                        this.a.add(jk6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            mx4 mx4Var = new mx4();
            this.b = mx4Var;
            mx4Var.j(dataRes.page);
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
                    jk6 jk6Var = null;
                    if (threadData.isShareThread) {
                        jk6Var = new rk6();
                        jk6Var.a = threadData;
                    } else if (sk6.L(threadData)) {
                        jk6Var = new sk6(threadData);
                    } else if (rk6.R(threadData)) {
                        jk6Var = new rk6();
                        jk6Var.a = threadData;
                    }
                    if (jk6Var != null && jk6Var.isValid()) {
                        jk6Var.E("c10816");
                        this.a.add(jk6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            mx4 mx4Var = new mx4();
            this.b = mx4Var;
            mx4Var.j(hotThread.page);
        }
    }
}
