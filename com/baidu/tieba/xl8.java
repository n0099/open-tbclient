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
public class xl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pi> a;
    public yl8 b;
    public em8 c;
    public xy4 d;
    public PostForumData e;
    public bm8 f;
    public tl8 g;
    public tl8 h;
    public tl8 i;
    public zl8 j;
    public wl8 k;
    public zl8 l;
    public List<um6> m;
    public List<pi> n;
    public jy4 o;
    public int p;
    public RecomTopicList q;

    public xl8() {
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

    public tl8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (tl8) invokeV.objValue;
    }

    public tl8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (tl8) invokeV.objValue;
    }

    public xy4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (xy4) invokeV.objValue;
    }

    public bm8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (bm8) invokeV.objValue;
    }

    public yl8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (yl8) invokeV.objValue;
    }

    public List<pi> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public tl8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (tl8) invokeV.objValue;
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
            yl8 yl8Var = new yl8();
            this.b = yl8Var;
            yl8Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            zl8 zl8Var = new zl8();
            this.l = zl8Var;
            zl8Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                um6 um6Var = null;
                if (threadData.isShareThread) {
                    um6Var = new dn6();
                    um6Var.a = threadData;
                } else if (en6.L(threadData)) {
                    um6Var = new en6(threadData);
                    um6Var.s = true;
                } else if (dn6.R(threadData)) {
                    um6Var = new dn6();
                    um6Var.a = threadData;
                }
                if (um6Var != null && um6Var.isValid()) {
                    um6Var.E("c10814");
                    this.m.add(um6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            em8 em8Var = new em8();
            this.c = em8Var;
            em8Var.parserProtobuf(dataRes.relate_forum);
            xy4 xy4Var = new xy4();
            this.d = xy4Var;
            xy4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a35);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            xy4 xy4Var2 = this.d;
            xy4Var2.e = R.color.CAM_X0108;
            ArrayList<wy4> e = xy4Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    wy4 wy4Var = new wy4();
                    wy4Var.u(relateForum.forum_id.intValue());
                    wy4Var.x(relateForum.forum_name);
                    wy4Var.t(relateForum.avatar);
                    wy4Var.q(relateForum.desc);
                    wy4Var.s(relateForum.thread_num.intValue());
                    wy4Var.p(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    wy4Var.o(z3);
                    e.add(wy4Var);
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
            bm8 bm8Var = new bm8();
            this.f = bm8Var;
            bm8Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            tl8 tl8Var = new tl8();
            this.g = tl8Var;
            tl8Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            tl8 tl8Var2 = new tl8();
            this.h = tl8Var2;
            tl8Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            tl8 tl8Var3 = new tl8();
            this.i = tl8Var3;
            tl8Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            zl8 zl8Var2 = new zl8();
            this.j = zl8Var2;
            zl8Var2.a(dataRes.hot_thread);
            wl8 wl8Var = new wl8();
            this.k = wl8Var;
            wl8Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                jy4 jy4Var = new jy4();
                this.o = jy4Var;
                jy4Var.j(dataRes.hot_thread.page);
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
                        er9 er9Var = new er9(specialTopic.title);
                        if (!z) {
                            er9Var.b = false;
                            z = true;
                        }
                        this.n.add(er9Var);
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
                        dr9 dr9Var = new dr9(threadInfo2, z2);
                        dr9Var.c(i);
                        this.n.add(dr9Var);
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
            bm8 bm8Var = this.f;
            if (bm8Var != null) {
                this.a.add(bm8Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (um6 um6Var : this.m) {
                    this.a.add(um6Var);
                }
            }
            em8 em8Var = this.c;
            if (em8Var != null && em8Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            wl8 wl8Var = this.k;
            if (wl8Var != null && !ListUtils.isEmpty(wl8Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((um6) ListUtils.getItem(this.k.a, i));
                    em8 em8Var2 = this.c;
                    if (em8Var2 != null && em8Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
