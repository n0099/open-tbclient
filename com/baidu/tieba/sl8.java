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
public class sl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pi> a;
    public tl8 b;
    public zl8 c;
    public uy4 d;
    public PostForumData e;
    public wl8 f;
    public ol8 g;
    public ol8 h;
    public ol8 i;
    public ul8 j;
    public rl8 k;
    public ul8 l;
    public List<qm6> m;
    public List<pi> n;
    public gy4 o;
    public int p;
    public RecomTopicList q;

    public sl8() {
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

    public ol8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (ol8) invokeV.objValue;
    }

    public ol8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (ol8) invokeV.objValue;
    }

    public uy4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (uy4) invokeV.objValue;
    }

    public wl8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (wl8) invokeV.objValue;
    }

    public tl8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (tl8) invokeV.objValue;
    }

    public List<pi> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public ol8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (ol8) invokeV.objValue;
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
            tl8 tl8Var = new tl8();
            this.b = tl8Var;
            tl8Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            ul8 ul8Var = new ul8();
            this.l = ul8Var;
            ul8Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                qm6 qm6Var = null;
                if (threadData.isShareThread) {
                    qm6Var = new zm6();
                    qm6Var.a = threadData;
                } else if (an6.L(threadData)) {
                    qm6Var = new an6(threadData);
                    qm6Var.s = true;
                } else if (zm6.R(threadData)) {
                    qm6Var = new zm6();
                    qm6Var.a = threadData;
                }
                if (qm6Var != null && qm6Var.isValid()) {
                    qm6Var.E("c10814");
                    this.m.add(qm6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            zl8 zl8Var = new zl8();
            this.c = zl8Var;
            zl8Var.parserProtobuf(dataRes.relate_forum);
            uy4 uy4Var = new uy4();
            this.d = uy4Var;
            uy4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a35);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            uy4 uy4Var2 = this.d;
            uy4Var2.e = R.color.CAM_X0108;
            ArrayList<ty4> e = uy4Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    ty4 ty4Var = new ty4();
                    ty4Var.u(relateForum.forum_id.intValue());
                    ty4Var.x(relateForum.forum_name);
                    ty4Var.t(relateForum.avatar);
                    ty4Var.q(relateForum.desc);
                    ty4Var.s(relateForum.thread_num.intValue());
                    ty4Var.p(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    ty4Var.o(z3);
                    e.add(ty4Var);
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
            wl8 wl8Var = new wl8();
            this.f = wl8Var;
            wl8Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            ol8 ol8Var = new ol8();
            this.g = ol8Var;
            ol8Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            ol8 ol8Var2 = new ol8();
            this.h = ol8Var2;
            ol8Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            ol8 ol8Var3 = new ol8();
            this.i = ol8Var3;
            ol8Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            ul8 ul8Var2 = new ul8();
            this.j = ul8Var2;
            ul8Var2.a(dataRes.hot_thread);
            rl8 rl8Var = new rl8();
            this.k = rl8Var;
            rl8Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                gy4 gy4Var = new gy4();
                this.o = gy4Var;
                gy4Var.j(dataRes.hot_thread.page);
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
                        zq9 zq9Var = new zq9(specialTopic.title);
                        if (!z) {
                            zq9Var.b = false;
                            z = true;
                        }
                        this.n.add(zq9Var);
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
                        yq9 yq9Var = new yq9(threadInfo2, z2);
                        yq9Var.c(i);
                        this.n.add(yq9Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<pi> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            wl8 wl8Var = this.f;
            if (wl8Var != null) {
                this.a.add(wl8Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (qm6 qm6Var : this.m) {
                    this.a.add(qm6Var);
                }
            }
            zl8 zl8Var = this.c;
            if (zl8Var != null && zl8Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            rl8 rl8Var = this.k;
            if (rl8Var != null && !ListUtils.isEmpty(rl8Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((qm6) ListUtils.getItem(this.k.a, i));
                    zl8 zl8Var2 = this.c;
                    if (zl8Var2 != null && zl8Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
