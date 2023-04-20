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
public class jw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<in> a;
    public kw7 b;
    public qw7 c;
    public az4 d;
    public PostForumData e;
    public nw7 f;
    public fw7 g;
    public fw7 h;
    public fw7 i;
    public lw7 j;
    public iw7 k;
    public lw7 l;
    public List<fh6> m;
    public List<in> n;
    public my4 o;
    public int p;
    public RecomTopicList q;

    public jw7() {
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

    public fw7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (fw7) invokeV.objValue;
    }

    public fw7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (fw7) invokeV.objValue;
    }

    public az4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (az4) invokeV.objValue;
    }

    public nw7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (nw7) invokeV.objValue;
    }

    public kw7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (kw7) invokeV.objValue;
    }

    public List<in> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public fw7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (fw7) invokeV.objValue;
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
            kw7 kw7Var = new kw7();
            this.b = kw7Var;
            kw7Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            lw7 lw7Var = new lw7();
            this.l = lw7Var;
            lw7Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                fh6 fh6Var = null;
                if (threadData.isShareThread) {
                    fh6Var = new nh6();
                    fh6Var.a = threadData;
                } else if (oh6.R(threadData)) {
                    fh6Var = new oh6(threadData);
                    fh6Var.s = true;
                } else if (nh6.W(threadData)) {
                    fh6Var = new nh6();
                    fh6Var.a = threadData;
                }
                if (fh6Var != null && fh6Var.isValid()) {
                    fh6Var.H("c10814");
                    this.m.add(fh6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            qw7 qw7Var = new qw7();
            this.c = qw7Var;
            qw7Var.parserProtobuf(dataRes.relate_forum);
            az4 az4Var = new az4();
            this.d = az4Var;
            az4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092e);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            az4 az4Var2 = this.d;
            az4Var2.e = R.color.CAM_X0108;
            ArrayList<zy4> e = az4Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    zy4 zy4Var = new zy4();
                    zy4Var.w(relateForum.forum_id.intValue());
                    zy4Var.x(relateForum.forum_name);
                    zy4Var.v(relateForum.avatar);
                    zy4Var.s(relateForum.desc);
                    zy4Var.u(relateForum.thread_num.intValue());
                    zy4Var.q(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zy4Var.o(z3);
                    e.add(zy4Var);
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
            nw7 nw7Var = new nw7();
            this.f = nw7Var;
            nw7Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            fw7 fw7Var = new fw7();
            this.g = fw7Var;
            fw7Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            fw7 fw7Var2 = new fw7();
            this.h = fw7Var2;
            fw7Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            fw7 fw7Var3 = new fw7();
            this.i = fw7Var3;
            fw7Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            lw7 lw7Var2 = new lw7();
            this.j = lw7Var2;
            lw7Var2.a(dataRes.hot_thread);
            iw7 iw7Var = new iw7();
            this.k = iw7Var;
            iw7Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                my4 my4Var = new my4();
                this.o = my4Var;
                my4Var.j(dataRes.hot_thread.page);
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
                        lp8 lp8Var = new lp8(specialTopic.title);
                        if (!z) {
                            lp8Var.b = false;
                            z = true;
                        }
                        this.n.add(lp8Var);
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
                        kp8 kp8Var = new kp8(threadInfo2, z2);
                        kp8Var.c(i);
                        this.n.add(kp8Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<in> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            nw7 nw7Var = this.f;
            if (nw7Var != null) {
                this.a.add(nw7Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (fh6 fh6Var : this.m) {
                    this.a.add(fh6Var);
                }
            }
            qw7 qw7Var = this.c;
            if (qw7Var != null && qw7Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            iw7 iw7Var = this.k;
            if (iw7Var != null && !ListUtils.isEmpty(iw7Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((fh6) ListUtils.getItem(this.k.a, i));
                    qw7 qw7Var2 = this.c;
                    if (qw7Var2 != null && qw7Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
