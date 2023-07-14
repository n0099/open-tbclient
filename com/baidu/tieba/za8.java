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
public class za8 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<cq6> a;
    public w35 b;
    public long c;
    public int d;
    public List<yn> e;
    @Nullable
    public Map<String, Object> f;

    public za8() {
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

    public za8(int i) {
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

    public final void f(List<cq6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            cq6 cq6Var = list.get(list.size() - 1);
            if (cq6Var.getThreadData() != null) {
                this.c = wg.g(cq6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<yn> d(k45 k45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k45Var)) == null) {
            ArrayList<yn> arrayList = new ArrayList<>(this.e);
            g(arrayList, k45Var);
            ArrayList<yn> arrayList2 = new ArrayList<>();
            Iterator<yn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        z45 z45Var = new z45();
                        z45Var.t = threadData;
                        z45Var.position = i;
                        z45Var.a = true;
                        arrayList2.add(z45Var);
                        z45 z45Var2 = new z45();
                        z45Var2.t = threadData;
                        z45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            z45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            z45Var2.d = true;
                            z45Var2.u = imageWidthAndHeight[0];
                            z45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            z45Var2.e = true;
                        } else {
                            z45Var2.b = true;
                        }
                        arrayList2.add(z45Var2);
                        if (threadData.getItem() != null) {
                            z45 z45Var3 = new z45();
                            z45Var3.n = true;
                            z45Var3.t = threadData;
                            z45Var3.position = i;
                            arrayList2.add(z45Var3);
                        }
                        z45 z45Var4 = new z45();
                        z45Var4.m = true;
                        z45Var4.t = threadData;
                        z45Var4.position = i;
                        arrayList2.add(z45Var4);
                        z45 z45Var5 = new z45();
                        z45Var5.g = true;
                        z45Var5.t = threadData;
                        z45Var5.position = i;
                        arrayList2.add(z45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        z45 z45Var6 = new z45();
                        z45Var6.t = threadData;
                        z45Var6.position = i;
                        z45Var6.a = true;
                        arrayList2.add(z45Var6);
                        z45 z45Var7 = new z45();
                        z45Var7.t = threadData;
                        z45Var7.position = i;
                        z45Var7.i = true;
                        arrayList2.add(z45Var7);
                        if (threadData.getItem() != null) {
                            z45 z45Var8 = new z45();
                            z45Var8.n = true;
                            z45Var8.t = threadData;
                            z45Var8.position = i;
                            arrayList2.add(z45Var8);
                        }
                        z45 z45Var9 = new z45();
                        z45Var9.m = true;
                        z45Var9.t = threadData;
                        z45Var9.position = i;
                        arrayList2.add(z45Var9);
                        z45 z45Var10 = new z45();
                        z45Var10.g = true;
                        z45Var10.t = threadData;
                        z45Var10.position = i;
                        arrayList2.add(z45Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (jq6.X(threadData)) {
                        jq6 jq6Var = new jq6(threadData);
                        jq6Var.g = threadData.getTid();
                        arrayList2.add(jq6Var);
                    } else {
                        z45 z45Var11 = new z45();
                        z45Var11.t = threadData;
                        z45Var11.position = i;
                        arrayList2.add(z45Var11);
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

    public final void g(ArrayList<yn> arrayList, k45 k45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, k45Var) == null) && k45Var != null && !ListUtils.isEmpty(k45Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (k45Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, k45Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, k45Var);
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
                    cq6 cq6Var = null;
                    if (lq6.N(threadData)) {
                        cq6Var = new lq6(threadData);
                    } else if (kq6.X(threadData)) {
                        cq6Var = new kq6();
                        cq6Var.a = threadData;
                    }
                    if (cq6Var != null && cq6Var.isValid()) {
                        cq6Var.E("c10816");
                        this.a.add(cq6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            w35 w35Var = new w35();
            this.b = w35Var;
            w35Var.j(dataRes.page);
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
                    cq6 cq6Var = null;
                    if (threadData.isShareThread) {
                        cq6Var = new kq6();
                        cq6Var.a = threadData;
                    } else if (lq6.N(threadData)) {
                        cq6Var = new lq6(threadData);
                    } else if (kq6.X(threadData)) {
                        cq6Var = new kq6();
                        cq6Var.a = threadData;
                    }
                    if (cq6Var != null && cq6Var.isValid()) {
                        cq6Var.E("c10816");
                        this.a.add(cq6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            w35 w35Var = new w35();
            this.b = w35Var;
            w35Var.j(hotThread.page);
        }
    }
}
