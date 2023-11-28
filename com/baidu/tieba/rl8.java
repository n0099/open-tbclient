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
public class rl8 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qm6> a;
    public gy4 b;
    public long c;
    public int d;
    public List<pi> e;
    @Nullable
    public Map<String, Object> f;

    public rl8() {
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

    public rl8(int i) {
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

    public final void f(List<qm6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            qm6 qm6Var = list.get(list.size() - 1);
            if (qm6Var.getThreadData() != null) {
                this.c = JavaTypesHelper.toLong(qm6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<pi> d(uy4 uy4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uy4Var)) == null) {
            ArrayList<pi> arrayList = new ArrayList<>(this.e);
            g(arrayList, uy4Var);
            ArrayList<pi> arrayList2 = new ArrayList<>();
            Iterator<pi> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                pi next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        jz4 jz4Var = new jz4();
                        jz4Var.t = threadData;
                        jz4Var.position = i;
                        jz4Var.a = true;
                        arrayList2.add(jz4Var);
                        jz4 jz4Var2 = new jz4();
                        jz4Var2.t = threadData;
                        jz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jz4Var2.d = true;
                            jz4Var2.u = imageWidthAndHeight[0];
                            jz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jz4Var2.e = true;
                        } else {
                            jz4Var2.b = true;
                        }
                        arrayList2.add(jz4Var2);
                        if (threadData.getItem() != null) {
                            jz4 jz4Var3 = new jz4();
                            jz4Var3.n = true;
                            jz4Var3.t = threadData;
                            jz4Var3.position = i;
                            arrayList2.add(jz4Var3);
                        }
                        jz4 jz4Var4 = new jz4();
                        jz4Var4.m = true;
                        jz4Var4.t = threadData;
                        jz4Var4.position = i;
                        arrayList2.add(jz4Var4);
                        jz4 jz4Var5 = new jz4();
                        jz4Var5.g = true;
                        jz4Var5.t = threadData;
                        jz4Var5.position = i;
                        arrayList2.add(jz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        jz4 jz4Var6 = new jz4();
                        jz4Var6.t = threadData;
                        jz4Var6.position = i;
                        jz4Var6.a = true;
                        arrayList2.add(jz4Var6);
                        jz4 jz4Var7 = new jz4();
                        jz4Var7.t = threadData;
                        jz4Var7.position = i;
                        jz4Var7.i = true;
                        arrayList2.add(jz4Var7);
                        if (threadData.getItem() != null) {
                            jz4 jz4Var8 = new jz4();
                            jz4Var8.n = true;
                            jz4Var8.t = threadData;
                            jz4Var8.position = i;
                            arrayList2.add(jz4Var8);
                        }
                        jz4 jz4Var9 = new jz4();
                        jz4Var9.m = true;
                        jz4Var9.t = threadData;
                        jz4Var9.position = i;
                        arrayList2.add(jz4Var9);
                        jz4 jz4Var10 = new jz4();
                        jz4Var10.g = true;
                        jz4Var10.t = threadData;
                        jz4Var10.position = i;
                        arrayList2.add(jz4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (ym6.R(threadData)) {
                        ym6 ym6Var = new ym6(threadData);
                        ym6Var.g = threadData.getTid();
                        arrayList2.add(ym6Var);
                    } else {
                        jz4 jz4Var11 = new jz4();
                        jz4Var11.t = threadData;
                        jz4Var11.position = i;
                        arrayList2.add(jz4Var11);
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

    public final void g(ArrayList<pi> arrayList, uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, uy4Var) == null) && uy4Var != null && !ListUtils.isEmpty(uy4Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (uy4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, uy4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, uy4Var);
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
                    qm6 qm6Var = null;
                    if (an6.L(threadData)) {
                        qm6Var = new an6(threadData);
                    } else if (zm6.R(threadData)) {
                        qm6Var = new zm6();
                        qm6Var.a = threadData;
                    }
                    if (qm6Var != null && qm6Var.isValid()) {
                        qm6Var.E("c10816");
                        this.a.add(qm6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            gy4 gy4Var = new gy4();
            this.b = gy4Var;
            gy4Var.j(dataRes.page);
        }
    }

    public void k(HotThread hotThread) {
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
                    qm6 qm6Var = null;
                    if (threadData.isShareThread) {
                        qm6Var = new zm6();
                        qm6Var.a = threadData;
                    } else if (an6.L(threadData)) {
                        qm6Var = new an6(threadData);
                    } else if (zm6.R(threadData)) {
                        qm6Var = new zm6();
                        qm6Var.a = threadData;
                    }
                    if (qm6Var != null && qm6Var.isValid()) {
                        qm6Var.E("c10816");
                        this.a.add(qm6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            gy4 gy4Var = new gy4();
            this.b = gy4Var;
            gy4Var.j(hotThread.page);
        }
    }
}
