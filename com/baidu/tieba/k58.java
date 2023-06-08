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
public class k58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<vn> a;
    public l58 b;
    public r58 c;
    public y35 d;
    public PostForumData e;
    public o58 f;
    public g58 g;
    public g58 h;
    public g58 i;
    public m58 j;
    public j58 k;
    public m58 l;
    public List<oo6> m;
    public List<vn> n;
    public k35 o;
    public int p;
    public RecomTopicList q;

    public k58() {
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

    public g58 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (g58) invokeV.objValue;
    }

    public g58 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (g58) invokeV.objValue;
    }

    public y35 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (y35) invokeV.objValue;
    }

    public o58 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (o58) invokeV.objValue;
    }

    public l58 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (l58) invokeV.objValue;
    }

    public List<vn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public g58 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (g58) invokeV.objValue;
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
            l58 l58Var = new l58();
            this.b = l58Var;
            l58Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            m58 m58Var = new m58();
            this.l = m58Var;
            m58Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                oo6 oo6Var = null;
                if (threadData.isShareThread) {
                    oo6Var = new wo6();
                    oo6Var.a = threadData;
                } else if (xo6.P(threadData)) {
                    oo6Var = new xo6(threadData);
                    oo6Var.s = true;
                } else if (wo6.X(threadData)) {
                    oo6Var = new wo6();
                    oo6Var.a = threadData;
                }
                if (oo6Var != null && oo6Var.isValid()) {
                    oo6Var.F("c10814");
                    this.m.add(oo6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            r58 r58Var = new r58();
            this.c = r58Var;
            r58Var.parserProtobuf(dataRes.relate_forum);
            y35 y35Var = new y35();
            this.d = y35Var;
            y35Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f1);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            y35 y35Var2 = this.d;
            y35Var2.e = R.color.CAM_X0108;
            ArrayList<x35> e = y35Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    x35 x35Var = new x35();
                    x35Var.w(relateForum.forum_id.intValue());
                    x35Var.x(relateForum.forum_name);
                    x35Var.u(relateForum.avatar);
                    x35Var.q(relateForum.desc);
                    x35Var.s(relateForum.thread_num.intValue());
                    x35Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    x35Var.n(z3);
                    e.add(x35Var);
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
            o58 o58Var = new o58();
            this.f = o58Var;
            o58Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            g58 g58Var = new g58();
            this.g = g58Var;
            g58Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            g58 g58Var2 = new g58();
            this.h = g58Var2;
            g58Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            g58 g58Var3 = new g58();
            this.i = g58Var3;
            g58Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            m58 m58Var2 = new m58();
            this.j = m58Var2;
            m58Var2.a(dataRes.hot_thread);
            j58 j58Var = new j58();
            this.k = j58Var;
            j58Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                k35 k35Var = new k35();
                this.o = k35Var;
                k35Var.j(dataRes.hot_thread.page);
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
                        qz8 qz8Var = new qz8(specialTopic.title);
                        if (!z) {
                            qz8Var.b = false;
                            z = true;
                        }
                        this.n.add(qz8Var);
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
                        pz8 pz8Var = new pz8(threadInfo2, z2);
                        pz8Var.c(i);
                        this.n.add(pz8Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<vn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            o58 o58Var = this.f;
            if (o58Var != null) {
                this.a.add(o58Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (oo6 oo6Var : this.m) {
                    this.a.add(oo6Var);
                }
            }
            r58 r58Var = this.c;
            if (r58Var != null && r58Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            j58 j58Var = this.k;
            if (j58Var != null && !ListUtils.isEmpty(j58Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((oo6) ListUtils.getItem(this.k.a, i));
                    r58 r58Var2 = this.c;
                    if (r58Var2 != null && r58Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
