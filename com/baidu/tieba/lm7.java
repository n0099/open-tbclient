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
public class lm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<gn> a;
    public mm7 b;
    public sm7 c;
    public xy4 d;
    public PostForumData e;
    public pm7 f;
    public hm7 g;
    public hm7 h;
    public hm7 i;
    public nm7 j;
    public km7 k;
    public nm7 l;
    public List<sf6> m;
    public List<gn> n;
    public jy4 o;
    public int p;
    public RecomTopicList q;

    public lm7() {
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

    public hm7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (hm7) invokeV.objValue;
    }

    public hm7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (hm7) invokeV.objValue;
    }

    public xy4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (xy4) invokeV.objValue;
    }

    public pm7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (pm7) invokeV.objValue;
    }

    public mm7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (mm7) invokeV.objValue;
    }

    public List<gn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public hm7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (hm7) invokeV.objValue;
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
            mm7 mm7Var = new mm7();
            this.b = mm7Var;
            mm7Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            nm7 nm7Var = new nm7();
            this.l = nm7Var;
            nm7Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                sf6 sf6Var = null;
                if (threadData.isShareThread) {
                    sf6Var = new ag6();
                    sf6Var.a = threadData;
                } else if (bg6.R(threadData)) {
                    sf6Var = new bg6(threadData);
                    sf6Var.s = true;
                } else if (ag6.W(threadData)) {
                    sf6Var = new ag6();
                    sf6Var.a = threadData;
                }
                if (sf6Var != null && sf6Var.isValid()) {
                    sf6Var.I("c10814");
                    this.m.add(sf6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            sm7 sm7Var = new sm7();
            this.c = sm7Var;
            sm7Var.parserProtobuf(dataRes.relate_forum);
            xy4 xy4Var = new xy4();
            this.d = xy4Var;
            xy4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0932);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            xy4 xy4Var2 = this.d;
            xy4Var2.e = R.color.CAM_X0108;
            ArrayList<wy4> g = xy4Var2.g();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    wy4 wy4Var = new wy4();
                    wy4Var.w(relateForum.forum_id.intValue());
                    wy4Var.y(relateForum.forum_name);
                    wy4Var.v(relateForum.avatar);
                    wy4Var.t(relateForum.desc);
                    wy4Var.u(relateForum.thread_num.intValue());
                    wy4Var.s(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    wy4Var.r(z3);
                    g.add(wy4Var);
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
            pm7 pm7Var = new pm7();
            this.f = pm7Var;
            pm7Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            hm7 hm7Var = new hm7();
            this.g = hm7Var;
            hm7Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            hm7 hm7Var2 = new hm7();
            this.h = hm7Var2;
            hm7Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            hm7 hm7Var3 = new hm7();
            this.i = hm7Var3;
            hm7Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            nm7 nm7Var2 = new nm7();
            this.j = nm7Var2;
            nm7Var2.a(dataRes.hot_thread);
            km7 km7Var = new km7();
            this.k = km7Var;
            km7Var.m(dataRes.hot_thread);
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
                        me8 me8Var = new me8(specialTopic.title);
                        if (!z) {
                            me8Var.b = false;
                            z = true;
                        }
                        this.n.add(me8Var);
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
                        le8 le8Var = new le8(threadInfo2, z2);
                        le8Var.c(i);
                        this.n.add(le8Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<gn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            pm7 pm7Var = this.f;
            if (pm7Var != null) {
                this.a.add(pm7Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (sf6 sf6Var : this.m) {
                    this.a.add(sf6Var);
                }
            }
            sm7 sm7Var = this.c;
            if (sm7Var != null && sm7Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            km7 km7Var = this.k;
            if (km7Var != null && !ListUtils.isEmpty(km7Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((sf6) ListUtils.getItem(this.k.a, i));
                    sm7 sm7Var2 = this.c;
                    if (sm7Var2 != null && sm7Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
