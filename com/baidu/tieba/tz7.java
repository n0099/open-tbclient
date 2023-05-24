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
public class tz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<rn> a;
    public uz7 b;
    public a08 c;
    public z05 d;
    public PostForumData e;
    public xz7 f;
    public pz7 g;
    public pz7 h;
    public pz7 i;
    public vz7 j;
    public sz7 k;
    public vz7 l;
    public List<dk6> m;
    public List<rn> n;
    public l05 o;
    public int p;
    public RecomTopicList q;

    public tz7() {
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

    public pz7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (pz7) invokeV.objValue;
    }

    public pz7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (pz7) invokeV.objValue;
    }

    public z05 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (z05) invokeV.objValue;
    }

    public xz7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (xz7) invokeV.objValue;
    }

    public uz7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (uz7) invokeV.objValue;
    }

    public List<rn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public pz7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (pz7) invokeV.objValue;
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
            uz7 uz7Var = new uz7();
            this.b = uz7Var;
            uz7Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            vz7 vz7Var = new vz7();
            this.l = vz7Var;
            vz7Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                dk6 dk6Var = null;
                if (threadData.isShareThread) {
                    dk6Var = new lk6();
                    dk6Var.a = threadData;
                } else if (mk6.P(threadData)) {
                    dk6Var = new mk6(threadData);
                    dk6Var.s = true;
                } else if (lk6.W(threadData)) {
                    dk6Var = new lk6();
                    dk6Var.a = threadData;
                }
                if (dk6Var != null && dk6Var.isValid()) {
                    dk6Var.F("c10814");
                    this.m.add(dk6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            a08 a08Var = new a08();
            this.c = a08Var;
            a08Var.parserProtobuf(dataRes.relate_forum);
            z05 z05Var = new z05();
            this.d = z05Var;
            z05Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09b9);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            z05 z05Var2 = this.d;
            z05Var2.e = R.color.CAM_X0108;
            ArrayList<y05> e = z05Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    y05 y05Var = new y05();
                    y05Var.w(relateForum.forum_id.intValue());
                    y05Var.x(relateForum.forum_name);
                    y05Var.u(relateForum.avatar);
                    y05Var.q(relateForum.desc);
                    y05Var.s(relateForum.thread_num.intValue());
                    y05Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    y05Var.n(z3);
                    e.add(y05Var);
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
            xz7 xz7Var = new xz7();
            this.f = xz7Var;
            xz7Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            pz7 pz7Var = new pz7();
            this.g = pz7Var;
            pz7Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            pz7 pz7Var2 = new pz7();
            this.h = pz7Var2;
            pz7Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            pz7 pz7Var3 = new pz7();
            this.i = pz7Var3;
            pz7Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            vz7 vz7Var2 = new vz7();
            this.j = vz7Var2;
            vz7Var2.a(dataRes.hot_thread);
            sz7 sz7Var = new sz7();
            this.k = sz7Var;
            sz7Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                l05 l05Var = new l05();
                this.o = l05Var;
                l05Var.j(dataRes.hot_thread.page);
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
                        qt8 qt8Var = new qt8(specialTopic.title);
                        if (!z) {
                            qt8Var.b = false;
                            z = true;
                        }
                        this.n.add(qt8Var);
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
                        pt8 pt8Var = new pt8(threadInfo2, z2);
                        pt8Var.c(i);
                        this.n.add(pt8Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<rn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            xz7 xz7Var = this.f;
            if (xz7Var != null) {
                this.a.add(xz7Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (dk6 dk6Var : this.m) {
                    this.a.add(dk6Var);
                }
            }
            a08 a08Var = this.c;
            if (a08Var != null && a08Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            sz7 sz7Var = this.k;
            if (sz7Var != null && !ListUtils.isEmpty(sz7Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((dk6) ListUtils.getItem(this.k.a, i));
                    a08 a08Var2 = this.c;
                    if (a08Var2 != null && a08Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
