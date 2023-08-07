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
/* loaded from: classes8.dex */
public class u88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ym> a;
    public v88 b;
    public b98 c;
    public h35 d;
    public PostForumData e;
    public y88 f;
    public q88 g;
    public q88 h;
    public q88 i;
    public w88 j;
    public t88 k;
    public w88 l;
    public List<jn6> m;
    public List<ym> n;
    public t25 o;
    public int p;
    public RecomTopicList q;

    public u88() {
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

    public q88 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (q88) invokeV.objValue;
    }

    public q88 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (q88) invokeV.objValue;
    }

    public h35 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (h35) invokeV.objValue;
    }

    public y88 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (y88) invokeV.objValue;
    }

    public v88 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (v88) invokeV.objValue;
    }

    public List<ym> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public q88 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (q88) invokeV.objValue;
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
            v88 v88Var = new v88();
            this.b = v88Var;
            v88Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            w88 w88Var = new w88();
            this.l = w88Var;
            w88Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                jn6 jn6Var = null;
                if (threadData.isShareThread) {
                    jn6Var = new rn6();
                    jn6Var.a = threadData;
                } else if (sn6.L(threadData)) {
                    jn6Var = new sn6(threadData);
                    jn6Var.s = true;
                } else if (rn6.R(threadData)) {
                    jn6Var = new rn6();
                    jn6Var.a = threadData;
                }
                if (jn6Var != null && jn6Var.isValid()) {
                    jn6Var.E("c10814");
                    this.m.add(jn6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            b98 b98Var = new b98();
            this.c = b98Var;
            b98Var.parserProtobuf(dataRes.relate_forum);
            h35 h35Var = new h35();
            this.d = h35Var;
            h35Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a04);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            h35 h35Var2 = this.d;
            h35Var2.e = R.color.CAM_X0108;
            ArrayList<g35> e = h35Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    g35 g35Var = new g35();
                    g35Var.u(relateForum.forum_id.intValue());
                    g35Var.v(relateForum.forum_name);
                    g35Var.t(relateForum.avatar);
                    g35Var.q(relateForum.desc);
                    g35Var.r(relateForum.thread_num.intValue());
                    g35Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    g35Var.n(z3);
                    e.add(g35Var);
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
            y88 y88Var = new y88();
            this.f = y88Var;
            y88Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            q88 q88Var = new q88();
            this.g = q88Var;
            q88Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            q88 q88Var2 = new q88();
            this.h = q88Var2;
            q88Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            q88 q88Var3 = new q88();
            this.i = q88Var3;
            q88Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            w88 w88Var2 = new w88();
            this.j = w88Var2;
            w88Var2.a(dataRes.hot_thread);
            t88 t88Var = new t88();
            this.k = t88Var;
            t88Var.i(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                t25 t25Var = new t25();
                this.o = t25Var;
                t25Var.j(dataRes.hot_thread.page);
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
                        x89 x89Var = new x89(specialTopic.title);
                        if (!z) {
                            x89Var.b = false;
                            z = true;
                        }
                        this.n.add(x89Var);
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
                        w89 w89Var = new w89(threadInfo2, z2);
                        w89Var.c(i);
                        this.n.add(w89Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<ym> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            y88 y88Var = this.f;
            if (y88Var != null) {
                this.a.add(y88Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (jn6 jn6Var : this.m) {
                    this.a.add(jn6Var);
                }
            }
            b98 b98Var = this.c;
            if (b98Var != null && b98Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            t88 t88Var = this.k;
            if (t88Var != null && !ListUtils.isEmpty(t88Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((jn6) ListUtils.getItem(this.k.a, i));
                    b98 b98Var2 = this.c;
                    if (b98Var2 != null && b98Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
