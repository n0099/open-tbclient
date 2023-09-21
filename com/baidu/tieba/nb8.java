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
public class nb8 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<aq6> a;
    public e35 b;
    public long c;
    public int d;
    public List<bn> e;
    @Nullable
    public Map<String, Object> f;

    public nb8() {
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

    public nb8(int i) {
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

    public final void f(List<aq6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            aq6 aq6Var = list.get(list.size() - 1);
            if (aq6Var.getThreadData() != null) {
                this.c = JavaTypesHelper.toLong(aq6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<bn> d(s35 s35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s35Var)) == null) {
            ArrayList<bn> arrayList = new ArrayList<>(this.e);
            g(arrayList, s35Var);
            ArrayList<bn> arrayList2 = new ArrayList<>();
            Iterator<bn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                bn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        h45 h45Var = new h45();
                        h45Var.t = threadData;
                        h45Var.position = i;
                        h45Var.a = true;
                        arrayList2.add(h45Var);
                        h45 h45Var2 = new h45();
                        h45Var2.t = threadData;
                        h45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            h45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            h45Var2.d = true;
                            h45Var2.u = imageWidthAndHeight[0];
                            h45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            h45Var2.e = true;
                        } else {
                            h45Var2.b = true;
                        }
                        arrayList2.add(h45Var2);
                        if (threadData.getItem() != null) {
                            h45 h45Var3 = new h45();
                            h45Var3.n = true;
                            h45Var3.t = threadData;
                            h45Var3.position = i;
                            arrayList2.add(h45Var3);
                        }
                        h45 h45Var4 = new h45();
                        h45Var4.m = true;
                        h45Var4.t = threadData;
                        h45Var4.position = i;
                        arrayList2.add(h45Var4);
                        h45 h45Var5 = new h45();
                        h45Var5.g = true;
                        h45Var5.t = threadData;
                        h45Var5.position = i;
                        arrayList2.add(h45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        h45 h45Var6 = new h45();
                        h45Var6.t = threadData;
                        h45Var6.position = i;
                        h45Var6.a = true;
                        arrayList2.add(h45Var6);
                        h45 h45Var7 = new h45();
                        h45Var7.t = threadData;
                        h45Var7.position = i;
                        h45Var7.i = true;
                        arrayList2.add(h45Var7);
                        if (threadData.getItem() != null) {
                            h45 h45Var8 = new h45();
                            h45Var8.n = true;
                            h45Var8.t = threadData;
                            h45Var8.position = i;
                            arrayList2.add(h45Var8);
                        }
                        h45 h45Var9 = new h45();
                        h45Var9.m = true;
                        h45Var9.t = threadData;
                        h45Var9.position = i;
                        arrayList2.add(h45Var9);
                        h45 h45Var10 = new h45();
                        h45Var10.g = true;
                        h45Var10.t = threadData;
                        h45Var10.position = i;
                        arrayList2.add(h45Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (hq6.R(threadData)) {
                        hq6 hq6Var = new hq6(threadData);
                        hq6Var.g = threadData.getTid();
                        arrayList2.add(hq6Var);
                    } else {
                        h45 h45Var11 = new h45();
                        h45Var11.t = threadData;
                        h45Var11.position = i;
                        arrayList2.add(h45Var11);
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

    public final void g(ArrayList<bn> arrayList, s35 s35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, s35Var) == null) && s35Var != null && !ListUtils.isEmpty(s35Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (s35Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, s35Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, s35Var);
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
                    aq6 aq6Var = null;
                    if (jq6.L(threadData)) {
                        aq6Var = new jq6(threadData);
                    } else if (iq6.R(threadData)) {
                        aq6Var = new iq6();
                        aq6Var.a = threadData;
                    }
                    if (aq6Var != null && aq6Var.isValid()) {
                        aq6Var.E("c10816");
                        this.a.add(aq6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            e35 e35Var = new e35();
            this.b = e35Var;
            e35Var.j(dataRes.page);
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
                    aq6 aq6Var = null;
                    if (threadData.isShareThread) {
                        aq6Var = new iq6();
                        aq6Var.a = threadData;
                    } else if (jq6.L(threadData)) {
                        aq6Var = new jq6(threadData);
                    } else if (iq6.R(threadData)) {
                        aq6Var = new iq6();
                        aq6Var.a = threadData;
                    }
                    if (aq6Var != null && aq6Var.isValid()) {
                        aq6Var.E("c10816");
                        this.a.add(aq6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            e35 e35Var = new e35();
            this.b = e35Var;
            e35Var.j(hotThread.page);
        }
    }
}
