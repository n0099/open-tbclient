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
/* loaded from: classes9.dex */
public class z58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<yh> a;
    public a68 b;
    public g68 c;
    public ay4 d;
    public PostForumData e;
    public d68 f;
    public v58 g;
    public v58 h;
    public v58 i;
    public b68 j;
    public y58 k;
    public b68 l;
    public List<jk6> m;
    public List<yh> n;
    public mx4 o;
    public int p;
    public RecomTopicList q;

    public z58() {
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

    public v58 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (v58) invokeV.objValue;
    }

    public v58 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (v58) invokeV.objValue;
    }

    public ay4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (ay4) invokeV.objValue;
    }

    public d68 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (d68) invokeV.objValue;
    }

    public a68 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (a68) invokeV.objValue;
    }

    public List<yh> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public v58 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (v58) invokeV.objValue;
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
            a68 a68Var = new a68();
            this.b = a68Var;
            a68Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            b68 b68Var = new b68();
            this.l = b68Var;
            b68Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                jk6 jk6Var = null;
                if (threadData.isShareThread) {
                    jk6Var = new rk6();
                    jk6Var.a = threadData;
                } else if (sk6.L(threadData)) {
                    jk6Var = new sk6(threadData);
                    jk6Var.s = true;
                } else if (rk6.R(threadData)) {
                    jk6Var = new rk6();
                    jk6Var.a = threadData;
                }
                if (jk6Var != null && jk6Var.isValid()) {
                    jk6Var.E("c10814");
                    this.m.add(jk6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            g68 g68Var = new g68();
            this.c = g68Var;
            g68Var.parserProtobuf(dataRes.relate_forum);
            ay4 ay4Var = new ay4();
            this.d = ay4Var;
            ay4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a1a);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            ay4 ay4Var2 = this.d;
            ay4Var2.e = R.color.CAM_X0108;
            ArrayList<zx4> e = ay4Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    zx4 zx4Var = new zx4();
                    zx4Var.u(relateForum.forum_id.intValue());
                    zx4Var.v(relateForum.forum_name);
                    zx4Var.t(relateForum.avatar);
                    zx4Var.q(relateForum.desc);
                    zx4Var.r(relateForum.thread_num.intValue());
                    zx4Var.p(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zx4Var.o(z3);
                    e.add(zx4Var);
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
            d68 d68Var = new d68();
            this.f = d68Var;
            d68Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            v58 v58Var = new v58();
            this.g = v58Var;
            v58Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            v58 v58Var2 = new v58();
            this.h = v58Var2;
            v58Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            v58 v58Var3 = new v58();
            this.i = v58Var3;
            v58Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            b68 b68Var2 = new b68();
            this.j = b68Var2;
            b68Var2.a(dataRes.hot_thread);
            y58 y58Var = new y58();
            this.k = y58Var;
            y58Var.i(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                mx4 mx4Var = new mx4();
                this.o = mx4Var;
                mx4Var.j(dataRes.hot_thread.page);
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
                        da9 da9Var = new da9(specialTopic.title);
                        if (!z) {
                            da9Var.b = false;
                            z = true;
                        }
                        this.n.add(da9Var);
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
                        ca9 ca9Var = new ca9(threadInfo2, z2);
                        ca9Var.c(i);
                        this.n.add(ca9Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<yh> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d68 d68Var = this.f;
            if (d68Var != null) {
                this.a.add(d68Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (jk6 jk6Var : this.m) {
                    this.a.add(jk6Var);
                }
            }
            g68 g68Var = this.c;
            if (g68Var != null && g68Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            y58 y58Var = this.k;
            if (y58Var != null && !ListUtils.isEmpty(y58Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((jk6) ListUtils.getItem(this.k.a, i));
                    g68 g68Var2 = this.c;
                    if (g68Var2 != null && g68Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
