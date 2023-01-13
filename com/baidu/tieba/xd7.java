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
public class xd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<yn> a;
    public yd7 b;
    public ee7 c;
    public uu4 d;
    public PostForumData e;
    public be7 f;
    public td7 g;
    public td7 h;
    public td7 i;
    public zd7 j;
    public wd7 k;
    public zd7 l;
    public List<g96> m;
    public List<yn> n;
    public gu4 o;
    public int p;
    public RecomTopicList q;

    public xd7() {
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

    public td7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (td7) invokeV.objValue;
    }

    public td7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (td7) invokeV.objValue;
    }

    public uu4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (uu4) invokeV.objValue;
    }

    public be7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (be7) invokeV.objValue;
    }

    public yd7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (yd7) invokeV.objValue;
    }

    public List<yn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public td7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (td7) invokeV.objValue;
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
            yd7 yd7Var = new yd7();
            this.b = yd7Var;
            yd7Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            zd7 zd7Var = new zd7();
            this.l = zd7Var;
            zd7Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                g96 g96Var = null;
                if (threadData.isShareThread) {
                    g96Var = new o96();
                    g96Var.a = threadData;
                } else if (p96.R(threadData)) {
                    g96Var = new p96(threadData);
                    g96Var.s = true;
                } else if (o96.W(threadData)) {
                    g96Var = new o96();
                    g96Var.a = threadData;
                }
                if (g96Var != null && g96Var.isValid()) {
                    g96Var.L("c10814");
                    this.m.add(g96Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            ee7 ee7Var = new ee7();
            this.c = ee7Var;
            ee7Var.parserProtobuf(dataRes.relate_forum);
            uu4 uu4Var = new uu4();
            this.d = uu4Var;
            uu4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08ef);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            uu4 uu4Var2 = this.d;
            uu4Var2.e = R.color.CAM_X0108;
            ArrayList<tu4> g = uu4Var2.g();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    tu4 tu4Var = new tu4();
                    tu4Var.z(relateForum.forum_id.intValue());
                    tu4Var.C(relateForum.forum_name);
                    tu4Var.y(relateForum.avatar);
                    tu4Var.v(relateForum.desc);
                    tu4Var.x(relateForum.thread_num.intValue());
                    tu4Var.s(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    tu4Var.r(z3);
                    g.add(tu4Var);
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
            be7 be7Var = new be7();
            this.f = be7Var;
            be7Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            td7 td7Var = new td7();
            this.g = td7Var;
            td7Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            td7 td7Var2 = new td7();
            this.h = td7Var2;
            td7Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            td7 td7Var3 = new td7();
            this.i = td7Var3;
            td7Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            zd7 zd7Var2 = new zd7();
            this.j = zd7Var2;
            zd7Var2.a(dataRes.hot_thread);
            wd7 wd7Var = new wd7();
            this.k = wd7Var;
            wd7Var.o(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                gu4 gu4Var = new gu4();
                this.o = gu4Var;
                gu4Var.j(dataRes.hot_thread.page);
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
                        b18 b18Var = new b18(specialTopic.title);
                        if (!z) {
                            b18Var.b = false;
                            z = true;
                        }
                        this.n.add(b18Var);
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
                        a18 a18Var = new a18(threadInfo2, z2);
                        a18Var.c(i);
                        this.n.add(a18Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<yn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            be7 be7Var = this.f;
            if (be7Var != null) {
                this.a.add(be7Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (g96 g96Var : this.m) {
                    this.a.add(g96Var);
                }
            }
            ee7 ee7Var = this.c;
            if (ee7Var != null && ee7Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            wd7 wd7Var = this.k;
            if (wd7Var != null && !ListUtils.isEmpty(wd7Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((g96) ListUtils.getItem(this.k.a, i));
                    ee7 ee7Var2 = this.c;
                    if (ee7Var2 != null && ee7Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
