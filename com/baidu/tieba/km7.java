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
/* loaded from: classes5.dex */
public class km7 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<sf6> a;
    public jy4 b;
    public long c;
    public int d;
    public List<gn> e;
    @Nullable
    public Map<String, Object> f;

    public km7() {
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

    public km7(int i) {
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

    public final void h(List<sf6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            sf6 sf6Var = list.get(list.size() - 1);
            if (sf6Var.getThreadData() != null) {
                this.c = gg.g(sf6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<gn> f(xy4 xy4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xy4Var)) == null) {
            ArrayList<gn> arrayList = new ArrayList<>(this.e);
            i(arrayList, xy4Var);
            ArrayList<gn> arrayList2 = new ArrayList<>();
            Iterator<gn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                gn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        mz4 mz4Var = new mz4();
                        mz4Var.t = threadData;
                        mz4Var.position = i;
                        mz4Var.a = true;
                        arrayList2.add(mz4Var);
                        mz4 mz4Var2 = new mz4();
                        mz4Var2.t = threadData;
                        mz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            mz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            mz4Var2.d = true;
                            mz4Var2.u = imageWidthAndHeight[0];
                            mz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            mz4Var2.e = true;
                        } else {
                            mz4Var2.b = true;
                        }
                        arrayList2.add(mz4Var2);
                        if (threadData.getItem() != null) {
                            mz4 mz4Var3 = new mz4();
                            mz4Var3.n = true;
                            mz4Var3.t = threadData;
                            mz4Var3.position = i;
                            arrayList2.add(mz4Var3);
                        }
                        mz4 mz4Var4 = new mz4();
                        mz4Var4.m = true;
                        mz4Var4.t = threadData;
                        mz4Var4.position = i;
                        arrayList2.add(mz4Var4);
                        mz4 mz4Var5 = new mz4();
                        mz4Var5.g = true;
                        mz4Var5.t = threadData;
                        mz4Var5.position = i;
                        arrayList2.add(mz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        mz4 mz4Var6 = new mz4();
                        mz4Var6.t = threadData;
                        mz4Var6.position = i;
                        mz4Var6.a = true;
                        arrayList2.add(mz4Var6);
                        mz4 mz4Var7 = new mz4();
                        mz4Var7.t = threadData;
                        mz4Var7.position = i;
                        mz4Var7.i = true;
                        arrayList2.add(mz4Var7);
                        if (threadData.getItem() != null) {
                            mz4 mz4Var8 = new mz4();
                            mz4Var8.n = true;
                            mz4Var8.t = threadData;
                            mz4Var8.position = i;
                            arrayList2.add(mz4Var8);
                        }
                        mz4 mz4Var9 = new mz4();
                        mz4Var9.m = true;
                        mz4Var9.t = threadData;
                        mz4Var9.position = i;
                        arrayList2.add(mz4Var9);
                        mz4 mz4Var10 = new mz4();
                        mz4Var10.g = true;
                        mz4Var10.t = threadData;
                        mz4Var10.position = i;
                        arrayList2.add(mz4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (zf6.W(threadData)) {
                        zf6 zf6Var = new zf6(threadData);
                        zf6Var.g = threadData.getTid();
                        arrayList2.add(zf6Var);
                    } else {
                        mz4 mz4Var11 = new mz4();
                        mz4Var11.t = threadData;
                        mz4Var11.position = i;
                        arrayList2.add(mz4Var11);
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

    public final void i(ArrayList<gn> arrayList, xy4 xy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, xy4Var) == null) && xy4Var != null && !ListUtils.isEmpty(xy4Var.g())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (xy4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, xy4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, xy4Var);
            }
        }
    }

    public void k(DataRes dataRes) {
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
                    sf6 sf6Var = null;
                    if (bg6.R(threadData)) {
                        sf6Var = new bg6(threadData);
                    } else if (ag6.W(threadData)) {
                        sf6Var = new ag6();
                        sf6Var.a = threadData;
                    }
                    if (sf6Var != null && sf6Var.isValid()) {
                        sf6Var.I("c10816");
                        this.a.add(sf6Var);
                    }
                }
            }
            h(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            jy4 jy4Var = new jy4();
            this.b = jy4Var;
            jy4Var.j(dataRes.page);
        }
    }

    public void m(HotThread hotThread) {
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
                    sf6 sf6Var = null;
                    if (threadData.isShareThread) {
                        sf6Var = new ag6();
                        sf6Var.a = threadData;
                    } else if (bg6.R(threadData)) {
                        sf6Var = new bg6(threadData);
                    } else if (ag6.W(threadData)) {
                        sf6Var = new ag6();
                        sf6Var.a = threadData;
                    }
                    if (sf6Var != null && sf6Var.isValid()) {
                        sf6Var.I("c10816");
                        this.a.add(sf6Var);
                    }
                }
            }
            h(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            jy4 jy4Var = new jy4();
            this.b = jy4Var;
            jy4Var.j(hotThread.page);
        }
    }
}
