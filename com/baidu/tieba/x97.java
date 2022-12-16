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
public class x97 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<o56> a;
    public vt4 b;
    public long c;
    public int d;
    public List<xn> e;
    @Nullable
    public Map<String, Object> f;

    public x97() {
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

    public x97(int i) {
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

    public final void i(List<o56> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            o56 o56Var = list.get(list.size() - 1);
            if (o56Var.getThreadData() != null) {
                this.c = xg.g(o56Var.getThreadData().getTid(), 0L);
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

    public ArrayList<xn> f(ju4 ju4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ju4Var)) == null) {
            ArrayList<xn> arrayList = new ArrayList<>(this.e);
            k(arrayList, ju4Var);
            ArrayList<xn> arrayList2 = new ArrayList<>();
            Iterator<xn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        yu4 yu4Var = new yu4();
                        yu4Var.t = threadData;
                        yu4Var.position = i;
                        yu4Var.a = true;
                        arrayList2.add(yu4Var);
                        yu4 yu4Var2 = new yu4();
                        yu4Var2.t = threadData;
                        yu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            yu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            yu4Var2.d = true;
                            yu4Var2.u = imageWidthAndHeight[0];
                            yu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            yu4Var2.e = true;
                        } else {
                            yu4Var2.b = true;
                        }
                        arrayList2.add(yu4Var2);
                        if (threadData.getItem() != null) {
                            yu4 yu4Var3 = new yu4();
                            yu4Var3.n = true;
                            yu4Var3.t = threadData;
                            yu4Var3.position = i;
                            arrayList2.add(yu4Var3);
                        }
                        yu4 yu4Var4 = new yu4();
                        yu4Var4.m = true;
                        yu4Var4.t = threadData;
                        yu4Var4.position = i;
                        arrayList2.add(yu4Var4);
                        yu4 yu4Var5 = new yu4();
                        yu4Var5.g = true;
                        yu4Var5.t = threadData;
                        yu4Var5.position = i;
                        arrayList2.add(yu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        yu4 yu4Var6 = new yu4();
                        yu4Var6.t = threadData;
                        yu4Var6.position = i;
                        yu4Var6.a = true;
                        arrayList2.add(yu4Var6);
                        yu4 yu4Var7 = new yu4();
                        yu4Var7.t = threadData;
                        yu4Var7.position = i;
                        yu4Var7.i = true;
                        arrayList2.add(yu4Var7);
                        if (threadData.getItem() != null) {
                            yu4 yu4Var8 = new yu4();
                            yu4Var8.n = true;
                            yu4Var8.t = threadData;
                            yu4Var8.position = i;
                            arrayList2.add(yu4Var8);
                        }
                        yu4 yu4Var9 = new yu4();
                        yu4Var9.m = true;
                        yu4Var9.t = threadData;
                        yu4Var9.position = i;
                        arrayList2.add(yu4Var9);
                        yu4 yu4Var10 = new yu4();
                        yu4Var10.g = true;
                        yu4Var10.t = threadData;
                        yu4Var10.position = i;
                        arrayList2.add(yu4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (v56.W(threadData)) {
                        v56 v56Var = new v56(threadData);
                        v56Var.g = threadData.getTid();
                        arrayList2.add(v56Var);
                    } else {
                        yu4 yu4Var11 = new yu4();
                        yu4Var11.t = threadData;
                        yu4Var11.position = i;
                        arrayList2.add(yu4Var11);
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

    public final void k(ArrayList<xn> arrayList, ju4 ju4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, ju4Var) == null) && ju4Var != null && !ListUtils.isEmpty(ju4Var.g())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (ju4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, ju4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, ju4Var);
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
                    o56 o56Var = null;
                    if (x56.R(threadData)) {
                        o56Var = new x56(threadData);
                    } else if (w56.W(threadData)) {
                        o56Var = new w56();
                        o56Var.a = threadData;
                    }
                    if (o56Var != null && o56Var.isValid()) {
                        o56Var.L("c10816");
                        this.a.add(o56Var);
                    }
                }
            }
            i(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            vt4 vt4Var = new vt4();
            this.b = vt4Var;
            vt4Var.j(dataRes.page);
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
                    o56 o56Var = null;
                    if (threadData.isShareThread) {
                        o56Var = new w56();
                        o56Var.a = threadData;
                    } else if (x56.R(threadData)) {
                        o56Var = new x56(threadData);
                    } else if (w56.W(threadData)) {
                        o56Var = new w56();
                        o56Var.a = threadData;
                    }
                    if (o56Var != null && o56Var.isValid()) {
                        o56Var.L("c10816");
                        this.a.add(o56Var);
                    }
                }
            }
            i(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            vt4 vt4Var = new vt4();
            this.b = vt4Var;
            vt4Var.j(hotThread.page);
        }
    }
}
