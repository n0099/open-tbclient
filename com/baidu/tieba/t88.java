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
public class t88 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<jn6> a;
    public t25 b;
    public long c;
    public int d;
    public List<ym> e;
    @Nullable
    public Map<String, Object> f;

    public t88() {
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

    public t88(int i) {
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

    public final void f(List<jn6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            jn6 jn6Var = list.get(list.size() - 1);
            if (jn6Var.getThreadData() != null) {
                this.c = JavaTypesHelper.toLong(jn6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<ym> d(h35 h35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h35Var)) == null) {
            ArrayList<ym> arrayList = new ArrayList<>(this.e);
            g(arrayList, h35Var);
            ArrayList<ym> arrayList2 = new ArrayList<>();
            Iterator<ym> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ym next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        w35 w35Var = new w35();
                        w35Var.t = threadData;
                        w35Var.position = i;
                        w35Var.a = true;
                        arrayList2.add(w35Var);
                        w35 w35Var2 = new w35();
                        w35Var2.t = threadData;
                        w35Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            w35Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            w35Var2.d = true;
                            w35Var2.u = imageWidthAndHeight[0];
                            w35Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            w35Var2.e = true;
                        } else {
                            w35Var2.b = true;
                        }
                        arrayList2.add(w35Var2);
                        if (threadData.getItem() != null) {
                            w35 w35Var3 = new w35();
                            w35Var3.n = true;
                            w35Var3.t = threadData;
                            w35Var3.position = i;
                            arrayList2.add(w35Var3);
                        }
                        w35 w35Var4 = new w35();
                        w35Var4.m = true;
                        w35Var4.t = threadData;
                        w35Var4.position = i;
                        arrayList2.add(w35Var4);
                        w35 w35Var5 = new w35();
                        w35Var5.g = true;
                        w35Var5.t = threadData;
                        w35Var5.position = i;
                        arrayList2.add(w35Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        w35 w35Var6 = new w35();
                        w35Var6.t = threadData;
                        w35Var6.position = i;
                        w35Var6.a = true;
                        arrayList2.add(w35Var6);
                        w35 w35Var7 = new w35();
                        w35Var7.t = threadData;
                        w35Var7.position = i;
                        w35Var7.i = true;
                        arrayList2.add(w35Var7);
                        if (threadData.getItem() != null) {
                            w35 w35Var8 = new w35();
                            w35Var8.n = true;
                            w35Var8.t = threadData;
                            w35Var8.position = i;
                            arrayList2.add(w35Var8);
                        }
                        w35 w35Var9 = new w35();
                        w35Var9.m = true;
                        w35Var9.t = threadData;
                        w35Var9.position = i;
                        arrayList2.add(w35Var9);
                        w35 w35Var10 = new w35();
                        w35Var10.g = true;
                        w35Var10.t = threadData;
                        w35Var10.position = i;
                        arrayList2.add(w35Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (qn6.R(threadData)) {
                        qn6 qn6Var = new qn6(threadData);
                        qn6Var.g = threadData.getTid();
                        arrayList2.add(qn6Var);
                    } else {
                        w35 w35Var11 = new w35();
                        w35Var11.t = threadData;
                        w35Var11.position = i;
                        arrayList2.add(w35Var11);
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

    public final void g(ArrayList<ym> arrayList, h35 h35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, h35Var) == null) && h35Var != null && !ListUtils.isEmpty(h35Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (h35Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, h35Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, h35Var);
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
                    jn6 jn6Var = null;
                    if (sn6.L(threadData)) {
                        jn6Var = new sn6(threadData);
                    } else if (rn6.R(threadData)) {
                        jn6Var = new rn6();
                        jn6Var.a = threadData;
                    }
                    if (jn6Var != null && jn6Var.isValid()) {
                        jn6Var.E("c10816");
                        this.a.add(jn6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            t25 t25Var = new t25();
            this.b = t25Var;
            t25Var.j(dataRes.page);
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
                    jn6 jn6Var = null;
                    if (threadData.isShareThread) {
                        jn6Var = new rn6();
                        jn6Var.a = threadData;
                    } else if (sn6.L(threadData)) {
                        jn6Var = new sn6(threadData);
                    } else if (rn6.R(threadData)) {
                        jn6Var = new rn6();
                        jn6Var.a = threadData;
                    }
                    if (jn6Var != null && jn6Var.isValid()) {
                        jn6Var.E("c10816");
                        this.a.add(jn6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            t25 t25Var = new t25();
            this.b = t25Var;
            t25Var.j(hotThread.page);
        }
    }
}
