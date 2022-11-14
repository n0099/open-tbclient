package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.data.PostForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.RecomTopicList;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class z87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<xn> a;
    public a97 b;
    public g97 c;
    public hu4 d;
    public PostForumData e;
    public d97 f;
    public v87 g;
    public v87 h;
    public v87 i;
    public b97 j;
    public y87 k;
    public b97 l;
    public List<s46> m;
    public List<xn> n;
    public tt4 o;
    public int p;
    public RecomTopicList q;

    public z87() {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = new ArrayList<>();
    }

    public v87 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (v87) invokeV.objValue;
    }

    public v87 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (v87) invokeV.objValue;
    }

    public hu4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (hu4) invokeV.objValue;
    }

    public d97 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (d97) invokeV.objValue;
    }

    public a97 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (a97) invokeV.objValue;
    }

    public List<xn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public v87 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (v87) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, dataRes) != null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            a97 a97Var = new a97();
            this.b = a97Var;
            a97Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            b97 b97Var = new b97();
            this.l = b97Var;
            b97Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                s46 s46Var = null;
                if (threadData.isShareThread) {
                    s46Var = new a56();
                    s46Var.a = threadData;
                } else if (b56.R(threadData)) {
                    s46Var = new b56(threadData);
                    s46Var.s = true;
                } else if (a56.W(threadData)) {
                    s46Var = new a56();
                    s46Var.a = threadData;
                }
                if (s46Var != null && s46Var.isValid()) {
                    s46Var.L("c10814");
                    this.m.add(s46Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            g97 g97Var = new g97();
            this.c = g97Var;
            g97Var.parserProtobuf(dataRes.relate_forum);
            hu4 hu4Var = new hu4();
            this.d = hu4Var;
            hu4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08a9);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            hu4 hu4Var2 = this.d;
            hu4Var2.e = R.color.CAM_X0108;
            ArrayList<gu4> h = hu4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    gu4 gu4Var = new gu4();
                    gu4Var.D(relateForum.forum_id.intValue());
                    gu4Var.E(relateForum.forum_name);
                    gu4Var.C(relateForum.avatar);
                    gu4Var.A(relateForum.desc);
                    gu4Var.B(relateForum.thread_num.intValue());
                    gu4Var.z(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    gu4Var.w(z3);
                    h.add(gu4Var);
                }
            }
        }
        List<RelateForum> list2 = dataRes.post_forum;
        if (list2 != null && list2.size() != 0) {
            PostForumData postForumData = new PostForumData();
            this.e = postForumData;
            postForumData.parserProtobuf(dataRes.post_forum);
        }
        PkModule pkModule = dataRes.pk_module;
        if (pkModule != null && !StringUtils.isNull(pkModule.ques_desc)) {
            d97 d97Var = new d97();
            this.f = d97Var;
            d97Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            v87 v87Var = new v87();
            this.g = v87Var;
            v87Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            v87 v87Var2 = new v87();
            this.h = v87Var2;
            v87Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            v87 v87Var3 = new v87();
            this.i = v87Var3;
            v87Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            b97 b97Var2 = new b97();
            this.j = b97Var2;
            b97Var2.a(dataRes.hot_thread);
            y87 y87Var = new y87();
            this.k = y87Var;
            y87Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                tt4 tt4Var = new tt4();
                this.o = tt4Var;
                tt4Var.j(dataRes.hot_thread.page);
                this.o.b();
            }
            dataRes.is_global_block.intValue();
        }
        this.q = dataRes.next_topic;
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            if (this.f != null) {
                z = true;
            } else {
                z = false;
            }
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        lt7 lt7Var = new lt7(specialTopic.title);
                        if (!z) {
                            lt7Var.b = false;
                            z = true;
                        }
                        this.n.add(lt7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        if (i == size) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        kt7 kt7Var = new kt7(threadInfo2, z2);
                        kt7Var.c(i);
                        this.n.add(kt7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<xn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d97 d97Var = this.f;
            if (d97Var != null) {
                this.a.add(d97Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (s46 s46Var : this.m) {
                    this.a.add(s46Var);
                }
            }
            g97 g97Var = this.c;
            if (g97Var != null && g97Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            y87 y87Var = this.k;
            if (y87Var != null && !ListUtils.isEmpty(y87Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((s46) ListUtils.getItem(this.k.a, i));
                    g97 g97Var2 = this.c;
                    if (g97Var2 != null && g97Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
