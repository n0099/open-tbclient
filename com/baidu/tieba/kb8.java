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
public class kb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<cn> a;
    public lb8 b;
    public rb8 c;
    public s35 d;
    public PostForumData e;
    public ob8 f;
    public gb8 g;
    public gb8 h;
    public gb8 i;
    public mb8 j;
    public jb8 k;
    public mb8 l;
    public List<up6> m;
    public List<cn> n;
    public e35 o;
    public int p;
    public RecomTopicList q;

    public kb8() {
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

    public gb8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (gb8) invokeV.objValue;
    }

    public gb8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (gb8) invokeV.objValue;
    }

    public s35 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (s35) invokeV.objValue;
    }

    public ob8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (ob8) invokeV.objValue;
    }

    public lb8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (lb8) invokeV.objValue;
    }

    public List<cn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public gb8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (gb8) invokeV.objValue;
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
            lb8 lb8Var = new lb8();
            this.b = lb8Var;
            lb8Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            mb8 mb8Var = new mb8();
            this.l = mb8Var;
            mb8Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                up6 up6Var = null;
                if (threadData.isShareThread) {
                    up6Var = new cq6();
                    up6Var.a = threadData;
                } else if (dq6.L(threadData)) {
                    up6Var = new dq6(threadData);
                    up6Var.s = true;
                } else if (cq6.R(threadData)) {
                    up6Var = new cq6();
                    up6Var.a = threadData;
                }
                if (up6Var != null && up6Var.isValid()) {
                    up6Var.E("c10814");
                    this.m.add(up6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            rb8 rb8Var = new rb8();
            this.c = rb8Var;
            rb8Var.parserProtobuf(dataRes.relate_forum);
            s35 s35Var = new s35();
            this.d = s35Var;
            s35Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a12);
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
            ob8 ob8Var = new ob8();
            this.f = ob8Var;
            ob8Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            gb8 gb8Var = new gb8();
            this.g = gb8Var;
            gb8Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            gb8 gb8Var2 = new gb8();
            this.h = gb8Var2;
            gb8Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            gb8 gb8Var3 = new gb8();
            this.i = gb8Var3;
            gb8Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            mb8 mb8Var2 = new mb8();
            this.j = mb8Var2;
            mb8Var2.a(dataRes.hot_thread);
            jb8 jb8Var = new jb8();
            this.k = jb8Var;
            jb8Var.i(dataRes.hot_thread);
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
                        fe9 fe9Var = new fe9(specialTopic.title);
                        if (!z) {
                            fe9Var.b = false;
                            z = true;
                        }
                        this.n.add(fe9Var);
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
                        ee9 ee9Var = new ee9(threadInfo2, z2);
                        ee9Var.c(i);
                        this.n.add(ee9Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<cn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ob8 ob8Var = this.f;
            if (ob8Var != null) {
                this.a.add(ob8Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (up6 up6Var : this.m) {
                    this.a.add(up6Var);
                }
            }
            rb8 rb8Var = this.c;
            if (rb8Var != null && rb8Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            jb8 jb8Var = this.k;
            if (jb8Var != null && !ListUtils.isEmpty(jb8Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((up6) ListUtils.getItem(this.k.a, i));
                    rb8 rb8Var2 = this.c;
                    if (rb8Var2 != null && rb8Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
