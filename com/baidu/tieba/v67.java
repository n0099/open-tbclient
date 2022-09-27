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
public class v67 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<p26> a;
    public zs4 b;
    public long c;
    public int d;
    public List<Cdo> e;
    @Nullable
    public Map<String, Object> f;

    public v67() {
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

    public ArrayList<Cdo> f(ot4 ot4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ot4Var)) == null) {
            ArrayList<Cdo> arrayList = new ArrayList<>(this.e);
            l(arrayList, ot4Var);
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        bu4 bu4Var = new bu4();
                        bu4Var.t = threadData;
                        bu4Var.position = i;
                        bu4Var.a = true;
                        arrayList2.add(bu4Var);
                        bu4 bu4Var2 = new bu4();
                        bu4Var2.t = threadData;
                        bu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            bu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            bu4Var2.d = true;
                            bu4Var2.u = imageWidthAndHeight[0];
                            bu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            bu4Var2.e = true;
                        } else {
                            bu4Var2.b = true;
                        }
                        arrayList2.add(bu4Var2);
                        if (threadData.getItem() != null) {
                            bu4 bu4Var3 = new bu4();
                            bu4Var3.n = true;
                            bu4Var3.t = threadData;
                            bu4Var3.position = i;
                            arrayList2.add(bu4Var3);
                        }
                        bu4 bu4Var4 = new bu4();
                        bu4Var4.m = true;
                        bu4Var4.t = threadData;
                        bu4Var4.position = i;
                        arrayList2.add(bu4Var4);
                        bu4 bu4Var5 = new bu4();
                        bu4Var5.g = true;
                        bu4Var5.t = threadData;
                        bu4Var5.position = i;
                        arrayList2.add(bu4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        bu4 bu4Var6 = new bu4();
                        bu4Var6.t = threadData;
                        bu4Var6.position = i;
                        bu4Var6.a = true;
                        arrayList2.add(bu4Var6);
                        bu4 bu4Var7 = new bu4();
                        bu4Var7.t = threadData;
                        bu4Var7.position = i;
                        bu4Var7.i = true;
                        arrayList2.add(bu4Var7);
                        if (threadData.getItem() != null) {
                            bu4 bu4Var8 = new bu4();
                            bu4Var8.n = true;
                            bu4Var8.t = threadData;
                            bu4Var8.position = i;
                            arrayList2.add(bu4Var8);
                        }
                        bu4 bu4Var9 = new bu4();
                        bu4Var9.m = true;
                        bu4Var9.t = threadData;
                        bu4Var9.position = i;
                        arrayList2.add(bu4Var9);
                        bu4 bu4Var10 = new bu4();
                        bu4Var10.g = true;
                        bu4Var10.t = threadData;
                        bu4Var10.position = i;
                        arrayList2.add(bu4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (w26.W(threadData)) {
                        w26 w26Var = new w26(threadData);
                        w26Var.g = threadData.getTid();
                        arrayList2.add(w26Var);
                    } else {
                        bu4 bu4Var11 = new bu4();
                        bu4Var11.t = threadData;
                        bu4Var11.position = i;
                        arrayList2.add(bu4Var11);
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

    @Nullable
    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (Map) invokeV.objValue;
    }

    public final void j(List<p26> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        p26 p26Var = list.get(list.size() - 1);
        if (p26Var.getThreadData() != null) {
            this.c = dh.g(p26Var.getThreadData().getTid(), 0L);
        }
    }

    public final void l(ArrayList<Cdo> arrayList, ot4 ot4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, ot4Var) == null) || ot4Var == null || ListUtils.isEmpty(ot4Var.h())) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (arrayList.get(i) instanceof ThreadData) {
                if (ot4Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, ot4Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, ot4Var);
        }
    }

    public void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
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
                    p26 p26Var = null;
                    if (y26.R(threadData)) {
                        p26Var = new y26(threadData);
                    } else if (x26.W(threadData)) {
                        p26Var = new x26();
                        p26Var.a = threadData;
                    }
                    if (p26Var != null && p26Var.isValid()) {
                        p26Var.L("c10816");
                        this.a.add(p26Var);
                    }
                }
            }
            j(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            zs4 zs4Var = new zs4();
            this.b = zs4Var;
            zs4Var.j(dataRes.page);
        }
    }

    public void r(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hotThread) == null) || hotThread == null) {
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
                    p26 p26Var = null;
                    if (threadData.isShareThread) {
                        p26Var = new x26();
                        p26Var.a = threadData;
                    } else if (y26.R(threadData)) {
                        p26Var = new y26(threadData);
                    } else if (x26.W(threadData)) {
                        p26Var = new x26();
                        p26Var.a = threadData;
                    }
                    if (p26Var != null && p26Var.isValid()) {
                        p26Var.L("c10816");
                        this.a.add(p26Var);
                    }
                }
            }
            j(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            zs4 zs4Var = new zs4();
            this.b = zs4Var;
            zs4Var.j(hotThread.page);
        }
    }

    public v67(int i) {
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
}
