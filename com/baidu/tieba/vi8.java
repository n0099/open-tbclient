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
public class vi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<oi> a;
    public wi8 b;
    public cj8 c;
    public sy4 d;
    public PostForumData e;
    public zi8 f;
    public ri8 g;
    public ri8 h;
    public ri8 i;
    public xi8 j;
    public ui8 k;
    public xi8 l;
    public List<gm6> m;
    public List<oi> n;
    public ey4 o;
    public int p;
    public RecomTopicList q;

    public vi8() {
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

    public ri8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (ri8) invokeV.objValue;
    }

    public ri8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (ri8) invokeV.objValue;
    }

    public sy4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (sy4) invokeV.objValue;
    }

    public zi8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (zi8) invokeV.objValue;
    }

    public wi8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (wi8) invokeV.objValue;
    }

    public List<oi> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public ri8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (ri8) invokeV.objValue;
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
            wi8 wi8Var = new wi8();
            this.b = wi8Var;
            wi8Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            xi8 xi8Var = new xi8();
            this.l = xi8Var;
            xi8Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                gm6 gm6Var = null;
                if (threadData.isShareThread) {
                    gm6Var = new om6();
                    gm6Var.a = threadData;
                } else if (pm6.L(threadData)) {
                    gm6Var = new pm6(threadData);
                    gm6Var.s = true;
                } else if (om6.R(threadData)) {
                    gm6Var = new om6();
                    gm6Var.a = threadData;
                }
                if (gm6Var != null && gm6Var.isValid()) {
                    gm6Var.E("c10814");
                    this.m.add(gm6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            cj8 cj8Var = new cj8();
            this.c = cj8Var;
            cj8Var.parserProtobuf(dataRes.relate_forum);
            sy4 sy4Var = new sy4();
            this.d = sy4Var;
            sy4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a2b);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            sy4 sy4Var2 = this.d;
            sy4Var2.e = R.color.CAM_X0108;
            ArrayList<ry4> e = sy4Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    ry4 ry4Var = new ry4();
                    ry4Var.u(relateForum.forum_id.intValue());
                    ry4Var.v(relateForum.forum_name);
                    ry4Var.t(relateForum.avatar);
                    ry4Var.q(relateForum.desc);
                    ry4Var.s(relateForum.thread_num.intValue());
                    ry4Var.p(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    ry4Var.o(z3);
                    e.add(ry4Var);
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
            zi8 zi8Var = new zi8();
            this.f = zi8Var;
            zi8Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            ri8 ri8Var = new ri8();
            this.g = ri8Var;
            ri8Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            ri8 ri8Var2 = new ri8();
            this.h = ri8Var2;
            ri8Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            ri8 ri8Var3 = new ri8();
            this.i = ri8Var3;
            ri8Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            xi8 xi8Var2 = new xi8();
            this.j = xi8Var2;
            xi8Var2.a(dataRes.hot_thread);
            ui8 ui8Var = new ui8();
            this.k = ui8Var;
            ui8Var.i(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                ey4 ey4Var = new ey4();
                this.o = ey4Var;
                ey4Var.j(dataRes.hot_thread.page);
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
                        jn9 jn9Var = new jn9(specialTopic.title);
                        if (!z) {
                            jn9Var.b = false;
                            z = true;
                        }
                        this.n.add(jn9Var);
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
                        in9 in9Var = new in9(threadInfo2, z2);
                        in9Var.c(i);
                        this.n.add(in9Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<oi> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            zi8 zi8Var = this.f;
            if (zi8Var != null) {
                this.a.add(zi8Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (gm6 gm6Var : this.m) {
                    this.a.add(gm6Var);
                }
            }
            cj8 cj8Var = this.c;
            if (cj8Var != null && cj8Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            ui8 ui8Var = this.k;
            if (ui8Var != null && !ListUtils.isEmpty(ui8Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((gm6) ListUtils.getItem(this.k.a, i));
                    cj8 cj8Var2 = this.c;
                    if (cj8Var2 != null && cj8Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
