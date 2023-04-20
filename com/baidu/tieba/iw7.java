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
public class iw7 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<fh6> a;
    public my4 b;
    public long c;
    public int d;
    public List<in> e;
    @Nullable
    public Map<String, Object> f;

    public iw7() {
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

    public iw7(int i) {
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

    public final void f(List<fh6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            fh6 fh6Var = list.get(list.size() - 1);
            if (fh6Var.getThreadData() != null) {
                this.c = gg.g(fh6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<in> d(az4 az4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, az4Var)) == null) {
            ArrayList<in> arrayList = new ArrayList<>(this.e);
            h(arrayList, az4Var);
            ArrayList<in> arrayList2 = new ArrayList<>();
            Iterator<in> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                in next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        pz4 pz4Var = new pz4();
                        pz4Var.t = threadData;
                        pz4Var.position = i;
                        pz4Var.a = true;
                        arrayList2.add(pz4Var);
                        pz4 pz4Var2 = new pz4();
                        pz4Var2.t = threadData;
                        pz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            pz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            pz4Var2.d = true;
                            pz4Var2.u = imageWidthAndHeight[0];
                            pz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            pz4Var2.e = true;
                        } else {
                            pz4Var2.b = true;
                        }
                        arrayList2.add(pz4Var2);
                        if (threadData.getItem() != null) {
                            pz4 pz4Var3 = new pz4();
                            pz4Var3.n = true;
                            pz4Var3.t = threadData;
                            pz4Var3.position = i;
                            arrayList2.add(pz4Var3);
                        }
                        pz4 pz4Var4 = new pz4();
                        pz4Var4.m = true;
                        pz4Var4.t = threadData;
                        pz4Var4.position = i;
                        arrayList2.add(pz4Var4);
                        pz4 pz4Var5 = new pz4();
                        pz4Var5.g = true;
                        pz4Var5.t = threadData;
                        pz4Var5.position = i;
                        arrayList2.add(pz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        pz4 pz4Var6 = new pz4();
                        pz4Var6.t = threadData;
                        pz4Var6.position = i;
                        pz4Var6.a = true;
                        arrayList2.add(pz4Var6);
                        pz4 pz4Var7 = new pz4();
                        pz4Var7.t = threadData;
                        pz4Var7.position = i;
                        pz4Var7.i = true;
                        arrayList2.add(pz4Var7);
                        if (threadData.getItem() != null) {
                            pz4 pz4Var8 = new pz4();
                            pz4Var8.n = true;
                            pz4Var8.t = threadData;
                            pz4Var8.position = i;
                            arrayList2.add(pz4Var8);
                        }
                        pz4 pz4Var9 = new pz4();
                        pz4Var9.m = true;
                        pz4Var9.t = threadData;
                        pz4Var9.position = i;
                        arrayList2.add(pz4Var9);
                        pz4 pz4Var10 = new pz4();
                        pz4Var10.g = true;
                        pz4Var10.t = threadData;
                        pz4Var10.position = i;
                        arrayList2.add(pz4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (mh6.W(threadData)) {
                        mh6 mh6Var = new mh6(threadData);
                        mh6Var.g = threadData.getTid();
                        arrayList2.add(mh6Var);
                    } else {
                        pz4 pz4Var11 = new pz4();
                        pz4Var11.t = threadData;
                        pz4Var11.position = i;
                        arrayList2.add(pz4Var11);
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

    public final void h(ArrayList<in> arrayList, az4 az4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, az4Var) == null) && az4Var != null && !ListUtils.isEmpty(az4Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (az4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, az4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, az4Var);
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
                    fh6 fh6Var = null;
                    if (oh6.R(threadData)) {
                        fh6Var = new oh6(threadData);
                    } else if (nh6.W(threadData)) {
                        fh6Var = new nh6();
                        fh6Var.a = threadData;
                    }
                    if (fh6Var != null && fh6Var.isValid()) {
                        fh6Var.H("c10816");
                        this.a.add(fh6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            my4 my4Var = new my4();
            this.b = my4Var;
            my4Var.j(dataRes.page);
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
                    fh6 fh6Var = null;
                    if (threadData.isShareThread) {
                        fh6Var = new nh6();
                        fh6Var.a = threadData;
                    } else if (oh6.R(threadData)) {
                        fh6Var = new oh6(threadData);
                    } else if (nh6.W(threadData)) {
                        fh6Var = new nh6();
                        fh6Var.a = threadData;
                    }
                    if (fh6Var != null && fh6Var.isValid()) {
                        fh6Var.H("c10816");
                        this.a.add(fh6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            my4 my4Var = new my4();
            this.b = my4Var;
            my4Var.j(hotThread.page);
        }
    }
}
