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
/* loaded from: classes5.dex */
public class o87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<wn> a;
    public p87 b;
    public v87 c;
    public gu4 d;
    public PostForumData e;
    public s87 f;
    public k87 g;
    public k87 h;
    public k87 i;
    public q87 j;
    public n87 k;
    public q87 l;
    public List<g46> m;
    public List<wn> n;
    public st4 o;
    public int p;
    public RecomTopicList q;

    public o87() {
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

    public k87 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (k87) invokeV.objValue;
    }

    public k87 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (k87) invokeV.objValue;
    }

    public gu4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (gu4) invokeV.objValue;
    }

    public s87 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (s87) invokeV.objValue;
    }

    public p87 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (p87) invokeV.objValue;
    }

    public List<wn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public k87 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (k87) invokeV.objValue;
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
            p87 p87Var = new p87();
            this.b = p87Var;
            p87Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            q87 q87Var = new q87();
            this.l = q87Var;
            q87Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                g46 g46Var = null;
                if (threadData.isShareThread) {
                    g46Var = new o46();
                    g46Var.a = threadData;
                } else if (p46.R(threadData)) {
                    g46Var = new p46(threadData);
                    g46Var.s = true;
                } else if (o46.W(threadData)) {
                    g46Var = new o46();
                    g46Var.a = threadData;
                }
                if (g46Var != null && g46Var.isValid()) {
                    g46Var.L("c10814");
                    this.m.add(g46Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            v87 v87Var = new v87();
            this.c = v87Var;
            v87Var.parserProtobuf(dataRes.relate_forum);
            gu4 gu4Var = new gu4();
            this.d = gu4Var;
            gu4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08a8);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            gu4 gu4Var2 = this.d;
            gu4Var2.e = R.color.CAM_X0108;
            ArrayList<fu4> h = gu4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    fu4 fu4Var = new fu4();
                    fu4Var.D(relateForum.forum_id.intValue());
                    fu4Var.E(relateForum.forum_name);
                    fu4Var.C(relateForum.avatar);
                    fu4Var.A(relateForum.desc);
                    fu4Var.B(relateForum.thread_num.intValue());
                    fu4Var.z(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    fu4Var.w(z3);
                    h.add(fu4Var);
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
            s87 s87Var = new s87();
            this.f = s87Var;
            s87Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            k87 k87Var = new k87();
            this.g = k87Var;
            k87Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            k87 k87Var2 = new k87();
            this.h = k87Var2;
            k87Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            k87 k87Var3 = new k87();
            this.i = k87Var3;
            k87Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            q87 q87Var2 = new q87();
            this.j = q87Var2;
            q87Var2.a(dataRes.hot_thread);
            n87 n87Var = new n87();
            this.k = n87Var;
            n87Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                st4 st4Var = new st4();
                this.o = st4Var;
                st4Var.j(dataRes.hot_thread.page);
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
                        at7 at7Var = new at7(specialTopic.title);
                        if (!z) {
                            at7Var.b = false;
                            z = true;
                        }
                        this.n.add(at7Var);
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
                        zs7 zs7Var = new zs7(threadInfo2, z2);
                        zs7Var.c(i);
                        this.n.add(zs7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<wn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            s87 s87Var = this.f;
            if (s87Var != null) {
                this.a.add(s87Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (g46 g46Var : this.m) {
                    this.a.add(g46Var);
                }
            }
            v87 v87Var = this.c;
            if (v87Var != null && v87Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            n87 n87Var = this.k;
            if (n87Var != null && !ListUtils.isEmpty(n87Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((g46) ListUtils.getItem(this.k.a, i));
                    v87 v87Var2 = this.c;
                    if (v87Var2 != null && v87Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
