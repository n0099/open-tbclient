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
public class wl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pi> a;
    public xl8 b;
    public dm8 c;
    public xy4 d;
    public PostForumData e;
    public am8 f;
    public sl8 g;
    public sl8 h;
    public sl8 i;
    public yl8 j;
    public vl8 k;
    public yl8 l;
    public List<um6> m;
    public List<pi> n;
    public jy4 o;
    public int p;
    public RecomTopicList q;

    public wl8() {
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

    public sl8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (sl8) invokeV.objValue;
    }

    public sl8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (sl8) invokeV.objValue;
    }

    public xy4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (xy4) invokeV.objValue;
    }

    public am8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (am8) invokeV.objValue;
    }

    public xl8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (xl8) invokeV.objValue;
    }

    public List<pi> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public sl8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (sl8) invokeV.objValue;
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
            xl8 xl8Var = new xl8();
            this.b = xl8Var;
            xl8Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            yl8 yl8Var = new yl8();
            this.l = yl8Var;
            yl8Var.a(dataRes.good_threads);
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
            dm8 dm8Var = new dm8();
            this.c = dm8Var;
            dm8Var.parserProtobuf(dataRes.relate_forum);
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
            am8 am8Var = new am8();
            this.f = am8Var;
            am8Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            sl8 sl8Var = new sl8();
            this.g = sl8Var;
            sl8Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            sl8 sl8Var2 = new sl8();
            this.h = sl8Var2;
            sl8Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            sl8 sl8Var3 = new sl8();
            this.i = sl8Var3;
            sl8Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            yl8 yl8Var2 = new yl8();
            this.j = yl8Var2;
            yl8Var2.a(dataRes.hot_thread);
            vl8 vl8Var = new vl8();
            this.k = vl8Var;
            vl8Var.k(dataRes.hot_thread);
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
                        dr9 dr9Var = new dr9(specialTopic.title);
                        if (!z) {
                            dr9Var.b = false;
                            z = true;
                        }
                        this.n.add(dr9Var);
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
                        cr9 cr9Var = new cr9(threadInfo2, z2);
                        cr9Var.c(i);
                        this.n.add(cr9Var);
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
            am8 am8Var = this.f;
            if (am8Var != null) {
                this.a.add(am8Var);
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
            dm8 dm8Var = this.c;
            if (dm8Var != null && dm8Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            vl8 vl8Var = this.k;
            if (vl8Var != null && !ListUtils.isEmpty(vl8Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((um6) ListUtils.getItem(this.k.a, i));
                    dm8 dm8Var2 = this.c;
                    if (dm8Var2 != null && dm8Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
