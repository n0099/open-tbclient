package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes5.dex */
public class n87 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<g46> a;
    public st4 b;
    public long c;
    public int d;
    public List<wn> e;
    @Nullable
    public Map<String, Object> f;

    public n87() {
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
    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public n87(int i) {
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

    public final void j(List<g46> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            g46 g46Var = list.get(list.size() - 1);
            if (g46Var.getThreadData() != null) {
                this.c = wg.g(g46Var.getThreadData().getTid(), 0L);
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

    public ArrayList<wn> f(gu4 gu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gu4Var)) == null) {
            ArrayList<wn> arrayList = new ArrayList<>(this.e);
            l(arrayList, gu4Var);
            ArrayList<wn> arrayList2 = new ArrayList<>();
            Iterator<wn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        vu4 vu4Var = new vu4();
                        vu4Var.t = threadData;
                        vu4Var.position = i;
                        vu4Var.a = true;
                        arrayList2.add(vu4Var);
                        vu4 vu4Var2 = new vu4();
                        vu4Var2.t = threadData;
                        vu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            vu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            vu4Var2.d = true;
                            vu4Var2.u = imageWidthAndHeight[0];
                            vu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            vu4Var2.e = true;
                        } else {
                            vu4Var2.b = true;
                        }
                        arrayList2.add(vu4Var2);
                        if (threadData.getItem() != null) {
                            vu4 vu4Var3 = new vu4();
                            vu4Var3.n = true;
                            vu4Var3.t = threadData;
                            vu4Var3.position = i;
                            arrayList2.add(vu4Var3);
                        }
                        vu4 vu4Var4 = new vu4();
                        vu4Var4.m = true;
                        vu4Var4.t = threadData;
                        vu4Var4.position = i;
                        arrayList2.add(vu4Var4);
                        vu4 vu4Var5 = new vu4();
                        vu4Var5.g = true;
                        vu4Var5.t = threadData;
                        vu4Var5.position = i;
                        arrayList2.add(vu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        vu4 vu4Var6 = new vu4();
                        vu4Var6.t = threadData;
                        vu4Var6.position = i;
                        vu4Var6.a = true;
                        arrayList2.add(vu4Var6);
                        vu4 vu4Var7 = new vu4();
                        vu4Var7.t = threadData;
                        vu4Var7.position = i;
                        vu4Var7.i = true;
                        arrayList2.add(vu4Var7);
                        if (threadData.getItem() != null) {
                            vu4 vu4Var8 = new vu4();
                            vu4Var8.n = true;
                            vu4Var8.t = threadData;
                            vu4Var8.position = i;
                            arrayList2.add(vu4Var8);
                        }
                        vu4 vu4Var9 = new vu4();
                        vu4Var9.m = true;
                        vu4Var9.t = threadData;
                        vu4Var9.position = i;
                        arrayList2.add(vu4Var9);
                        vu4 vu4Var10 = new vu4();
                        vu4Var10.g = true;
                        vu4Var10.t = threadData;
                        vu4Var10.position = i;
                        arrayList2.add(vu4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (n46.W(threadData)) {
                        n46 n46Var = new n46(threadData);
                        n46Var.g = threadData.getTid();
                        arrayList2.add(n46Var);
                    } else {
                        vu4 vu4Var11 = new vu4();
                        vu4Var11.t = threadData;
                        vu4Var11.position = i;
                        arrayList2.add(vu4Var11);
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

    public final void l(ArrayList<wn> arrayList, gu4 gu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, gu4Var) == null) && gu4Var != null && !ListUtils.isEmpty(gu4Var.h())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (gu4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, gu4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, gu4Var);
            }
        }
    }

    public void n(DataRes dataRes) {
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
                    g46 g46Var = null;
                    if (p46.R(threadData)) {
                        g46Var = new p46(threadData);
                    } else if (o46.W(threadData)) {
                        g46Var = new o46();
                        g46Var.a = threadData;
                    }
                    if (g46Var != null && g46Var.isValid()) {
                        g46Var.L("c10816");
                        this.a.add(g46Var);
                    }
                }
            }
            j(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            st4 st4Var = new st4();
            this.b = st4Var;
            st4Var.j(dataRes.page);
        }
    }

    public void r(HotThread hotThread) {
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
                    g46 g46Var = null;
                    if (threadData.isShareThread) {
                        g46Var = new o46();
                        g46Var.a = threadData;
                    } else if (p46.R(threadData)) {
                        g46Var = new p46(threadData);
                    } else if (o46.W(threadData)) {
                        g46Var = new o46();
                        g46Var.a = threadData;
                    }
                    if (g46Var != null && g46Var.isValid()) {
                        g46Var.L("c10816");
                        this.a.add(g46Var);
                    }
                }
            }
            j(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            st4 st4Var = new st4();
            this.b = st4Var;
            st4Var.j(hotThread.page);
        }
    }
}
