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
public class oa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<bn> a;
    public pa8 b;
    public va8 c;
    public n35 d;
    public PostForumData e;
    public sa8 f;
    public ka8 g;
    public ka8 h;
    public ka8 i;
    public qa8 j;
    public na8 k;
    public qa8 l;
    public List<ro6> m;
    public List<bn> n;
    public z25 o;
    public int p;
    public RecomTopicList q;

    public oa8() {
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

    public ka8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (ka8) invokeV.objValue;
    }

    public ka8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (ka8) invokeV.objValue;
    }

    public n35 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (n35) invokeV.objValue;
    }

    public sa8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (sa8) invokeV.objValue;
    }

    public pa8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (pa8) invokeV.objValue;
    }

    public List<bn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public ka8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (ka8) invokeV.objValue;
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
            pa8 pa8Var = new pa8();
            this.b = pa8Var;
            pa8Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            qa8 qa8Var = new qa8();
            this.l = qa8Var;
            qa8Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                ro6 ro6Var = null;
                if (threadData.isShareThread) {
                    ro6Var = new zo6();
                    ro6Var.a = threadData;
                } else if (ap6.L(threadData)) {
                    ro6Var = new ap6(threadData);
                    ro6Var.s = true;
                } else if (zo6.R(threadData)) {
                    ro6Var = new zo6();
                    ro6Var.a = threadData;
                }
                if (ro6Var != null && ro6Var.isValid()) {
                    ro6Var.E("c10814");
                    this.m.add(ro6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            va8 va8Var = new va8();
            this.c = va8Var;
            va8Var.parserProtobuf(dataRes.relate_forum);
            n35 n35Var = new n35();
            this.d = n35Var;
            n35Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a0c);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            n35 n35Var2 = this.d;
            n35Var2.e = R.color.CAM_X0108;
            ArrayList<m35> e = n35Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    m35 m35Var = new m35();
                    m35Var.u(relateForum.forum_id.intValue());
                    m35Var.v(relateForum.forum_name);
                    m35Var.t(relateForum.avatar);
                    m35Var.q(relateForum.desc);
                    m35Var.r(relateForum.thread_num.intValue());
                    m35Var.o(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    m35Var.n(z3);
                    e.add(m35Var);
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
            sa8 sa8Var = new sa8();
            this.f = sa8Var;
            sa8Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            ka8 ka8Var = new ka8();
            this.g = ka8Var;
            ka8Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            ka8 ka8Var2 = new ka8();
            this.h = ka8Var2;
            ka8Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            ka8 ka8Var3 = new ka8();
            this.i = ka8Var3;
            ka8Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            qa8 qa8Var2 = new qa8();
            this.j = qa8Var2;
            qa8Var2.a(dataRes.hot_thread);
            na8 na8Var = new na8();
            this.k = na8Var;
            na8Var.i(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                z25 z25Var = new z25();
                this.o = z25Var;
                z25Var.j(dataRes.hot_thread.page);
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
                        dd9 dd9Var = new dd9(specialTopic.title);
                        if (!z) {
                            dd9Var.b = false;
                            z = true;
                        }
                        this.n.add(dd9Var);
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
                        cd9 cd9Var = new cd9(threadInfo2, z2);
                        cd9Var.c(i);
                        this.n.add(cd9Var);
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
            sa8 sa8Var = this.f;
            if (sa8Var != null) {
                this.a.add(sa8Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (ro6 ro6Var : this.m) {
                    this.a.add(ro6Var);
                }
            }
            va8 va8Var = this.c;
            if (va8Var != null && va8Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            na8 na8Var = this.k;
            if (na8Var != null && !ListUtils.isEmpty(na8Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((ro6) ListUtils.getItem(this.k.a, i));
                    va8 va8Var2 = this.c;
                    if (va8Var2 != null && va8Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
