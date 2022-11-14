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
public class y87 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<s46> a;
    public tt4 b;
    public long c;
    public int d;
    public List<xn> e;
    @Nullable
    public Map<String, Object> f;

    public y87() {
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

    public y87(int i) {
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

    public final void j(List<s46> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            s46 s46Var = list.get(list.size() - 1);
            if (s46Var.getThreadData() != null) {
                this.c = xg.g(s46Var.getThreadData().getTid(), 0L);
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

    public ArrayList<xn> f(hu4 hu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hu4Var)) == null) {
            ArrayList<xn> arrayList = new ArrayList<>(this.e);
            l(arrayList, hu4Var);
            ArrayList<xn> arrayList2 = new ArrayList<>();
            Iterator<xn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        wu4 wu4Var = new wu4();
                        wu4Var.t = threadData;
                        wu4Var.position = i;
                        wu4Var.a = true;
                        arrayList2.add(wu4Var);
                        wu4 wu4Var2 = new wu4();
                        wu4Var2.t = threadData;
                        wu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            wu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            wu4Var2.d = true;
                            wu4Var2.u = imageWidthAndHeight[0];
                            wu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            wu4Var2.e = true;
                        } else {
                            wu4Var2.b = true;
                        }
                        arrayList2.add(wu4Var2);
                        if (threadData.getItem() != null) {
                            wu4 wu4Var3 = new wu4();
                            wu4Var3.n = true;
                            wu4Var3.t = threadData;
                            wu4Var3.position = i;
                            arrayList2.add(wu4Var3);
                        }
                        wu4 wu4Var4 = new wu4();
                        wu4Var4.m = true;
                        wu4Var4.t = threadData;
                        wu4Var4.position = i;
                        arrayList2.add(wu4Var4);
                        wu4 wu4Var5 = new wu4();
                        wu4Var5.g = true;
                        wu4Var5.t = threadData;
                        wu4Var5.position = i;
                        arrayList2.add(wu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        wu4 wu4Var6 = new wu4();
                        wu4Var6.t = threadData;
                        wu4Var6.position = i;
                        wu4Var6.a = true;
                        arrayList2.add(wu4Var6);
                        wu4 wu4Var7 = new wu4();
                        wu4Var7.t = threadData;
                        wu4Var7.position = i;
                        wu4Var7.i = true;
                        arrayList2.add(wu4Var7);
                        if (threadData.getItem() != null) {
                            wu4 wu4Var8 = new wu4();
                            wu4Var8.n = true;
                            wu4Var8.t = threadData;
                            wu4Var8.position = i;
                            arrayList2.add(wu4Var8);
                        }
                        wu4 wu4Var9 = new wu4();
                        wu4Var9.m = true;
                        wu4Var9.t = threadData;
                        wu4Var9.position = i;
                        arrayList2.add(wu4Var9);
                        wu4 wu4Var10 = new wu4();
                        wu4Var10.g = true;
                        wu4Var10.t = threadData;
                        wu4Var10.position = i;
                        arrayList2.add(wu4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (z46.W(threadData)) {
                        z46 z46Var = new z46(threadData);
                        z46Var.g = threadData.getTid();
                        arrayList2.add(z46Var);
                    } else {
                        wu4 wu4Var11 = new wu4();
                        wu4Var11.t = threadData;
                        wu4Var11.position = i;
                        arrayList2.add(wu4Var11);
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

    public final void l(ArrayList<xn> arrayList, hu4 hu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, hu4Var) == null) && hu4Var != null && !ListUtils.isEmpty(hu4Var.h())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (hu4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, hu4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, hu4Var);
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
                    s46 s46Var = null;
                    if (b56.R(threadData)) {
                        s46Var = new b56(threadData);
                    } else if (a56.W(threadData)) {
                        s46Var = new a56();
                        s46Var.a = threadData;
                    }
                    if (s46Var != null && s46Var.isValid()) {
                        s46Var.L("c10816");
                        this.a.add(s46Var);
                    }
                }
            }
            j(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            tt4 tt4Var = new tt4();
            this.b = tt4Var;
            tt4Var.j(dataRes.page);
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
                    s46 s46Var = null;
                    if (threadData.isShareThread) {
                        s46Var = new a56();
                        s46Var.a = threadData;
                    } else if (b56.R(threadData)) {
                        s46Var = new b56(threadData);
                    } else if (a56.W(threadData)) {
                        s46Var = new a56();
                        s46Var.a = threadData;
                    }
                    if (s46Var != null && s46Var.isValid()) {
                        s46Var.L("c10816");
                        this.a.add(s46Var);
                    }
                }
            }
            j(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            tt4 tt4Var = new tt4();
            this.b = tt4Var;
            tt4Var.j(hotThread.page);
        }
    }
}
