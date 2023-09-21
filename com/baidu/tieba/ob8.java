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
/* loaded from: classes7.dex */
public class ob8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<bn> a;
    public pb8 b;
    public vb8 c;
    public s35 d;
    public PostForumData e;
    public sb8 f;
    public kb8 g;
    public kb8 h;
    public kb8 i;
    public qb8 j;
    public nb8 k;
    public qb8 l;
    public List<aq6> m;
    public List<bn> n;
    public e35 o;
    public int p;
    public RecomTopicList q;

    public ob8() {
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

    public kb8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (kb8) invokeV.objValue;
    }

    public kb8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (kb8) invokeV.objValue;
    }

    public s35 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (s35) invokeV.objValue;
    }

    public sb8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (sb8) invokeV.objValue;
    }

    public pb8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (pb8) invokeV.objValue;
    }

    public List<bn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public kb8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (kb8) invokeV.objValue;
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
            pb8 pb8Var = new pb8();
            this.b = pb8Var;
            pb8Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            qb8 qb8Var = new qb8();
            this.l = qb8Var;
            qb8Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                aq6 aq6Var = null;
                if (threadData.isShareThread) {
                    aq6Var = new iq6();
                    aq6Var.a = threadData;
                } else if (jq6.L(threadData)) {
                    aq6Var = new jq6(threadData);
                    aq6Var.s = true;
                } else if (iq6.R(threadData)) {
                    aq6Var = new iq6();
                    aq6Var.a = threadData;
                }
                if (aq6Var != null && aq6Var.isValid()) {
                    aq6Var.E("c10814");
                    this.m.add(aq6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            vb8 vb8Var = new vb8();
            this.c = vb8Var;
            vb8Var.parserProtobuf(dataRes.relate_forum);
            s35 s35Var = new s35();
            this.d = s35Var;
            s35Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a13);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            s35 s35Var2 = this.d;
            s35Var2.e = R.color.CAM_X0108;
            ArrayList<r35> e = s35Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    r35 r35Var = new r35();
                    r35Var.u(relateForum.forum_id.intValue());
                    r35Var.v(relateForum.forum_name);
                    r35Var.t(relateForum.avatar);
                    r35Var.q(relateForum.desc);
                    r35Var.s(relateForum.thread_num.intValue());
                    r35Var.p(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    r35Var.o(z3);
                    e.add(r35Var);
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
            sb8 sb8Var = new sb8();
            this.f = sb8Var;
            sb8Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            kb8 kb8Var = new kb8();
            this.g = kb8Var;
            kb8Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            kb8 kb8Var2 = new kb8();
            this.h = kb8Var2;
            kb8Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            kb8 kb8Var3 = new kb8();
            this.i = kb8Var3;
            kb8Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            qb8 qb8Var2 = new qb8();
            this.j = qb8Var2;
            qb8Var2.a(dataRes.hot_thread);
            nb8 nb8Var = new nb8();
            this.k = nb8Var;
            nb8Var.i(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                e35 e35Var = new e35();
                this.o = e35Var;
                e35Var.j(dataRes.hot_thread.page);
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
                        qf9 qf9Var = new qf9(specialTopic.title);
                        if (!z) {
                            qf9Var.b = false;
                            z = true;
                        }
                        this.n.add(qf9Var);
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
                        pf9 pf9Var = new pf9(threadInfo2, z2);
                        pf9Var.c(i);
                        this.n.add(pf9Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<bn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            sb8 sb8Var = this.f;
            if (sb8Var != null) {
                this.a.add(sb8Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (aq6 aq6Var : this.m) {
                    this.a.add(aq6Var);
                }
            }
            vb8 vb8Var = this.c;
            if (vb8Var != null && vb8Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            nb8 nb8Var = this.k;
            if (nb8Var != null && !ListUtils.isEmpty(nb8Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((aq6) ListUtils.getItem(this.k.a, i));
                    vb8 vb8Var2 = this.c;
                    if (vb8Var2 != null && vb8Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
