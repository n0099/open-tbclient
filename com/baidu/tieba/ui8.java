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
public class ui8 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<gm6> a;
    public ey4 b;
    public long c;
    public int d;
    public List<oi> e;
    @Nullable
    public Map<String, Object> f;

    public ui8() {
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

    public ui8(int i) {
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

    public final void f(List<gm6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            gm6 gm6Var = list.get(list.size() - 1);
            if (gm6Var.getThreadData() != null) {
                this.c = JavaTypesHelper.toLong(gm6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<oi> d(sy4 sy4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sy4Var)) == null) {
            ArrayList<oi> arrayList = new ArrayList<>(this.e);
            g(arrayList, sy4Var);
            ArrayList<oi> arrayList2 = new ArrayList<>();
            Iterator<oi> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                oi next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        hz4 hz4Var = new hz4();
                        hz4Var.t = threadData;
                        hz4Var.position = i;
                        hz4Var.a = true;
                        arrayList2.add(hz4Var);
                        hz4 hz4Var2 = new hz4();
                        hz4Var2.t = threadData;
                        hz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            hz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            hz4Var2.d = true;
                            hz4Var2.u = imageWidthAndHeight[0];
                            hz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            hz4Var2.e = true;
                        } else {
                            hz4Var2.b = true;
                        }
                        arrayList2.add(hz4Var2);
                        if (threadData.getItem() != null) {
                            hz4 hz4Var3 = new hz4();
                            hz4Var3.n = true;
                            hz4Var3.t = threadData;
                            hz4Var3.position = i;
                            arrayList2.add(hz4Var3);
                        }
                        hz4 hz4Var4 = new hz4();
                        hz4Var4.m = true;
                        hz4Var4.t = threadData;
                        hz4Var4.position = i;
                        arrayList2.add(hz4Var4);
                        hz4 hz4Var5 = new hz4();
                        hz4Var5.g = true;
                        hz4Var5.t = threadData;
                        hz4Var5.position = i;
                        arrayList2.add(hz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        hz4 hz4Var6 = new hz4();
                        hz4Var6.t = threadData;
                        hz4Var6.position = i;
                        hz4Var6.a = true;
                        arrayList2.add(hz4Var6);
                        hz4 hz4Var7 = new hz4();
                        hz4Var7.t = threadData;
                        hz4Var7.position = i;
                        hz4Var7.i = true;
                        arrayList2.add(hz4Var7);
                        if (threadData.getItem() != null) {
                            hz4 hz4Var8 = new hz4();
                            hz4Var8.n = true;
                            hz4Var8.t = threadData;
                            hz4Var8.position = i;
                            arrayList2.add(hz4Var8);
                        }
                        hz4 hz4Var9 = new hz4();
                        hz4Var9.m = true;
                        hz4Var9.t = threadData;
                        hz4Var9.position = i;
                        arrayList2.add(hz4Var9);
                        hz4 hz4Var10 = new hz4();
                        hz4Var10.g = true;
                        hz4Var10.t = threadData;
                        hz4Var10.position = i;
                        arrayList2.add(hz4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (nm6.R(threadData)) {
                        nm6 nm6Var = new nm6(threadData);
                        nm6Var.g = threadData.getTid();
                        arrayList2.add(nm6Var);
                    } else {
                        hz4 hz4Var11 = new hz4();
                        hz4Var11.t = threadData;
                        hz4Var11.position = i;
                        arrayList2.add(hz4Var11);
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

    public final void g(ArrayList<oi> arrayList, sy4 sy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, sy4Var) == null) && sy4Var != null && !ListUtils.isEmpty(sy4Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (sy4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, sy4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, sy4Var);
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
                    gm6 gm6Var = null;
                    if (pm6.L(threadData)) {
                        gm6Var = new pm6(threadData);
                    } else if (om6.R(threadData)) {
                        gm6Var = new om6();
                        gm6Var.a = threadData;
                    }
                    if (gm6Var != null && gm6Var.isValid()) {
                        gm6Var.E("c10816");
                        this.a.add(gm6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            ey4 ey4Var = new ey4();
            this.b = ey4Var;
            ey4Var.j(dataRes.page);
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
                    gm6 gm6Var = null;
                    if (threadData.isShareThread) {
                        gm6Var = new om6();
                        gm6Var.a = threadData;
                    } else if (pm6.L(threadData)) {
                        gm6Var = new pm6(threadData);
                    } else if (om6.R(threadData)) {
                        gm6Var = new om6();
                        gm6Var.a = threadData;
                    }
                    if (gm6Var != null && gm6Var.isValid()) {
                        gm6Var.E("c10816");
                        this.a.add(gm6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            ey4 ey4Var = new ey4();
            this.b = ey4Var;
            ey4Var.j(hotThread.page);
        }
    }
}
