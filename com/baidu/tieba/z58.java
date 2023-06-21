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
/* loaded from: classes8.dex */
public class z58 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<to6> a;
    public l35 b;
    public long c;
    public int d;
    public List<wn> e;
    @Nullable
    public Map<String, Object> f;

    public z58() {
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

    public z58(int i) {
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

    public final void f(List<to6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            to6 to6Var = list.get(list.size() - 1);
            if (to6Var.getThreadData() != null) {
                this.c = ug.g(to6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<wn> d(z35 z35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z35Var)) == null) {
            ArrayList<wn> arrayList = new ArrayList<>(this.e);
            h(arrayList, z35Var);
            ArrayList<wn> arrayList2 = new ArrayList<>();
            Iterator<wn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        o45 o45Var = new o45();
                        o45Var.t = threadData;
                        o45Var.position = i;
                        o45Var.a = true;
                        arrayList2.add(o45Var);
                        o45 o45Var2 = new o45();
                        o45Var2.t = threadData;
                        o45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            o45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            o45Var2.d = true;
                            o45Var2.u = imageWidthAndHeight[0];
                            o45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            o45Var2.e = true;
                        } else {
                            o45Var2.b = true;
                        }
                        arrayList2.add(o45Var2);
                        if (threadData.getItem() != null) {
                            o45 o45Var3 = new o45();
                            o45Var3.n = true;
                            o45Var3.t = threadData;
                            o45Var3.position = i;
                            arrayList2.add(o45Var3);
                        }
                        o45 o45Var4 = new o45();
                        o45Var4.m = true;
                        o45Var4.t = threadData;
                        o45Var4.position = i;
                        arrayList2.add(o45Var4);
                        o45 o45Var5 = new o45();
                        o45Var5.g = true;
                        o45Var5.t = threadData;
                        o45Var5.position = i;
                        arrayList2.add(o45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        o45 o45Var6 = new o45();
                        o45Var6.t = threadData;
                        o45Var6.position = i;
                        o45Var6.a = true;
                        arrayList2.add(o45Var6);
                        o45 o45Var7 = new o45();
                        o45Var7.t = threadData;
                        o45Var7.position = i;
                        o45Var7.i = true;
                        arrayList2.add(o45Var7);
                        if (threadData.getItem() != null) {
                            o45 o45Var8 = new o45();
                            o45Var8.n = true;
                            o45Var8.t = threadData;
                            o45Var8.position = i;
                            arrayList2.add(o45Var8);
                        }
                        o45 o45Var9 = new o45();
                        o45Var9.m = true;
                        o45Var9.t = threadData;
                        o45Var9.position = i;
                        arrayList2.add(o45Var9);
                        o45 o45Var10 = new o45();
                        o45Var10.g = true;
                        o45Var10.t = threadData;
                        o45Var10.position = i;
                        arrayList2.add(o45Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (ap6.X(threadData)) {
                        ap6 ap6Var = new ap6(threadData);
                        ap6Var.g = threadData.getTid();
                        arrayList2.add(ap6Var);
                    } else {
                        o45 o45Var11 = new o45();
                        o45Var11.t = threadData;
                        o45Var11.position = i;
                        arrayList2.add(o45Var11);
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

    public final void h(ArrayList<wn> arrayList, z35 z35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, z35Var) == null) && z35Var != null && !ListUtils.isEmpty(z35Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (z35Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, z35Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, z35Var);
            }
        }
    }

    public void i(DataRes dataRes) {
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
                    to6 to6Var = null;
                    if (cp6.P(threadData)) {
                        to6Var = new cp6(threadData);
                    } else if (bp6.X(threadData)) {
                        to6Var = new bp6();
                        to6Var.a = threadData;
                    }
                    if (to6Var != null && to6Var.isValid()) {
                        to6Var.F("c10816");
                        this.a.add(to6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            l35 l35Var = new l35();
            this.b = l35Var;
            l35Var.j(dataRes.page);
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
                    to6 to6Var = null;
                    if (threadData.isShareThread) {
                        to6Var = new bp6();
                        to6Var.a = threadData;
                    } else if (cp6.P(threadData)) {
                        to6Var = new cp6(threadData);
                    } else if (bp6.X(threadData)) {
                        to6Var = new bp6();
                        to6Var.a = threadData;
                    }
                    if (to6Var != null && to6Var.isValid()) {
                        to6Var.F("c10816");
                        this.a.add(to6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            l35 l35Var = new l35();
            this.b = l35Var;
            l35Var.j(hotThread.page);
        }
    }
}
