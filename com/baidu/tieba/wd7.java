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
/* loaded from: classes6.dex */
public class wd7 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<g96> a;
    public gu4 b;
    public long c;
    public int d;
    public List<yn> e;
    @Nullable
    public Map<String, Object> f;

    public wd7() {
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
    public Map<String, Object> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public wd7(int i) {
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

    public final void i(List<g96> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            g96 g96Var = list.get(list.size() - 1);
            if (g96Var.getThreadData() != null) {
                this.c = yg.g(g96Var.getThreadData().getTid(), 0L);
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

    public ArrayList<yn> f(uu4 uu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uu4Var)) == null) {
            ArrayList<yn> arrayList = new ArrayList<>(this.e);
            k(arrayList, uu4Var);
            ArrayList<yn> arrayList2 = new ArrayList<>();
            Iterator<yn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        jv4 jv4Var = new jv4();
                        jv4Var.t = threadData;
                        jv4Var.position = i;
                        jv4Var.a = true;
                        arrayList2.add(jv4Var);
                        jv4 jv4Var2 = new jv4();
                        jv4Var2.t = threadData;
                        jv4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jv4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jv4Var2.d = true;
                            jv4Var2.u = imageWidthAndHeight[0];
                            jv4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jv4Var2.e = true;
                        } else {
                            jv4Var2.b = true;
                        }
                        arrayList2.add(jv4Var2);
                        if (threadData.getItem() != null) {
                            jv4 jv4Var3 = new jv4();
                            jv4Var3.n = true;
                            jv4Var3.t = threadData;
                            jv4Var3.position = i;
                            arrayList2.add(jv4Var3);
                        }
                        jv4 jv4Var4 = new jv4();
                        jv4Var4.m = true;
                        jv4Var4.t = threadData;
                        jv4Var4.position = i;
                        arrayList2.add(jv4Var4);
                        jv4 jv4Var5 = new jv4();
                        jv4Var5.g = true;
                        jv4Var5.t = threadData;
                        jv4Var5.position = i;
                        arrayList2.add(jv4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        jv4 jv4Var6 = new jv4();
                        jv4Var6.t = threadData;
                        jv4Var6.position = i;
                        jv4Var6.a = true;
                        arrayList2.add(jv4Var6);
                        jv4 jv4Var7 = new jv4();
                        jv4Var7.t = threadData;
                        jv4Var7.position = i;
                        jv4Var7.i = true;
                        arrayList2.add(jv4Var7);
                        if (threadData.getItem() != null) {
                            jv4 jv4Var8 = new jv4();
                            jv4Var8.n = true;
                            jv4Var8.t = threadData;
                            jv4Var8.position = i;
                            arrayList2.add(jv4Var8);
                        }
                        jv4 jv4Var9 = new jv4();
                        jv4Var9.m = true;
                        jv4Var9.t = threadData;
                        jv4Var9.position = i;
                        arrayList2.add(jv4Var9);
                        jv4 jv4Var10 = new jv4();
                        jv4Var10.g = true;
                        jv4Var10.t = threadData;
                        jv4Var10.position = i;
                        arrayList2.add(jv4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (n96.W(threadData)) {
                        n96 n96Var = new n96(threadData);
                        n96Var.g = threadData.getTid();
                        arrayList2.add(n96Var);
                    } else {
                        jv4 jv4Var11 = new jv4();
                        jv4Var11.t = threadData;
                        jv4Var11.position = i;
                        arrayList2.add(jv4Var11);
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

    public final void k(ArrayList<yn> arrayList, uu4 uu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, uu4Var) == null) && uu4Var != null && !ListUtils.isEmpty(uu4Var.g())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (uu4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, uu4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, uu4Var);
            }
        }
    }

    public void m(DataRes dataRes) {
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
                    g96 g96Var = null;
                    if (p96.R(threadData)) {
                        g96Var = new p96(threadData);
                    } else if (o96.W(threadData)) {
                        g96Var = new o96();
                        g96Var.a = threadData;
                    }
                    if (g96Var != null && g96Var.isValid()) {
                        g96Var.L("c10816");
                        this.a.add(g96Var);
                    }
                }
            }
            i(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            gu4 gu4Var = new gu4();
            this.b = gu4Var;
            gu4Var.j(dataRes.page);
        }
    }

    public void o(HotThread hotThread) {
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
                    g96 g96Var = null;
                    if (threadData.isShareThread) {
                        g96Var = new o96();
                        g96Var.a = threadData;
                    } else if (p96.R(threadData)) {
                        g96Var = new p96(threadData);
                    } else if (o96.W(threadData)) {
                        g96Var = new o96();
                        g96Var.a = threadData;
                    }
                    if (g96Var != null && g96Var.isValid()) {
                        g96Var.L("c10816");
                        this.a.add(g96Var);
                    }
                }
            }
            i(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            gu4 gu4Var = new gu4();
            this.b = gu4Var;
            gu4Var.j(hotThread.page);
        }
    }
}
