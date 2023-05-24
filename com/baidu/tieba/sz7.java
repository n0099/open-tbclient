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
/* loaded from: classes7.dex */
public class sz7 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<dk6> a;
    public l05 b;
    public long c;
    public int d;
    public List<rn> e;
    @Nullable
    public Map<String, Object> f;

    public sz7() {
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

    public sz7(int i) {
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

    public final void f(List<dk6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            dk6 dk6Var = list.get(list.size() - 1);
            if (dk6Var.getThreadData() != null) {
                this.c = pg.g(dk6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<rn> d(z05 z05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z05Var)) == null) {
            ArrayList<rn> arrayList = new ArrayList<>(this.e);
            h(arrayList, z05Var);
            ArrayList<rn> arrayList2 = new ArrayList<>();
            Iterator<rn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                rn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        o15 o15Var = new o15();
                        o15Var.t = threadData;
                        o15Var.position = i;
                        o15Var.a = true;
                        arrayList2.add(o15Var);
                        o15 o15Var2 = new o15();
                        o15Var2.t = threadData;
                        o15Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            o15Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            o15Var2.d = true;
                            o15Var2.u = imageWidthAndHeight[0];
                            o15Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            o15Var2.e = true;
                        } else {
                            o15Var2.b = true;
                        }
                        arrayList2.add(o15Var2);
                        if (threadData.getItem() != null) {
                            o15 o15Var3 = new o15();
                            o15Var3.n = true;
                            o15Var3.t = threadData;
                            o15Var3.position = i;
                            arrayList2.add(o15Var3);
                        }
                        o15 o15Var4 = new o15();
                        o15Var4.m = true;
                        o15Var4.t = threadData;
                        o15Var4.position = i;
                        arrayList2.add(o15Var4);
                        o15 o15Var5 = new o15();
                        o15Var5.g = true;
                        o15Var5.t = threadData;
                        o15Var5.position = i;
                        arrayList2.add(o15Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        o15 o15Var6 = new o15();
                        o15Var6.t = threadData;
                        o15Var6.position = i;
                        o15Var6.a = true;
                        arrayList2.add(o15Var6);
                        o15 o15Var7 = new o15();
                        o15Var7.t = threadData;
                        o15Var7.position = i;
                        o15Var7.i = true;
                        arrayList2.add(o15Var7);
                        if (threadData.getItem() != null) {
                            o15 o15Var8 = new o15();
                            o15Var8.n = true;
                            o15Var8.t = threadData;
                            o15Var8.position = i;
                            arrayList2.add(o15Var8);
                        }
                        o15 o15Var9 = new o15();
                        o15Var9.m = true;
                        o15Var9.t = threadData;
                        o15Var9.position = i;
                        arrayList2.add(o15Var9);
                        o15 o15Var10 = new o15();
                        o15Var10.g = true;
                        o15Var10.t = threadData;
                        o15Var10.position = i;
                        arrayList2.add(o15Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (kk6.W(threadData)) {
                        kk6 kk6Var = new kk6(threadData);
                        kk6Var.g = threadData.getTid();
                        arrayList2.add(kk6Var);
                    } else {
                        o15 o15Var11 = new o15();
                        o15Var11.t = threadData;
                        o15Var11.position = i;
                        arrayList2.add(o15Var11);
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

    public final void h(ArrayList<rn> arrayList, z05 z05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, z05Var) == null) && z05Var != null && !ListUtils.isEmpty(z05Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (z05Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, z05Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, z05Var);
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
                    dk6 dk6Var = null;
                    if (mk6.P(threadData)) {
                        dk6Var = new mk6(threadData);
                    } else if (lk6.W(threadData)) {
                        dk6Var = new lk6();
                        dk6Var.a = threadData;
                    }
                    if (dk6Var != null && dk6Var.isValid()) {
                        dk6Var.F("c10816");
                        this.a.add(dk6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            l05 l05Var = new l05();
            this.b = l05Var;
            l05Var.j(dataRes.page);
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
                    dk6 dk6Var = null;
                    if (threadData.isShareThread) {
                        dk6Var = new lk6();
                        dk6Var.a = threadData;
                    } else if (mk6.P(threadData)) {
                        dk6Var = new mk6(threadData);
                    } else if (lk6.W(threadData)) {
                        dk6Var = new lk6();
                        dk6Var.a = threadData;
                    }
                    if (dk6Var != null && dk6Var.isValid()) {
                        dk6Var.F("c10816");
                        this.a.add(dk6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            l05 l05Var = new l05();
            this.b = l05Var;
            l05Var.j(hotThread.page);
        }
    }
}
