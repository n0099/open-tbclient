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
public class iw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<hn> a;
    public jw7 b;
    public pw7 c;
    public zy4 d;
    public PostForumData e;
    public mw7 f;
    public ew7 g;
    public ew7 h;
    public ew7 i;
    public kw7 j;
    public hw7 k;
    public kw7 l;
    public List<eh6> m;
    public List<hn> n;
    public ly4 o;
    public int p;
    public RecomTopicList q;

    public iw7() {
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

    public ew7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (ew7) invokeV.objValue;
    }

    public ew7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (ew7) invokeV.objValue;
    }

    public zy4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (zy4) invokeV.objValue;
    }

    public mw7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (mw7) invokeV.objValue;
    }

    public jw7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (jw7) invokeV.objValue;
    }

    public List<hn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public ew7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (ew7) invokeV.objValue;
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
            jw7 jw7Var = new jw7();
            this.b = jw7Var;
            jw7Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            kw7 kw7Var = new kw7();
            this.l = kw7Var;
            kw7Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                eh6 eh6Var = null;
                if (threadData.isShareThread) {
                    eh6Var = new mh6();
                    eh6Var.a = threadData;
                } else if (nh6.R(threadData)) {
                    eh6Var = new nh6(threadData);
                    eh6Var.s = true;
                } else if (mh6.W(threadData)) {
                    eh6Var = new mh6();
                    eh6Var.a = threadData;
                }
                if (eh6Var != null && eh6Var.isValid()) {
                    eh6Var.H("c10814");
                    this.m.add(eh6Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            pw7 pw7Var = new pw7();
            this.c = pw7Var;
            pw7Var.parserProtobuf(dataRes.relate_forum);
            zy4 zy4Var = new zy4();
            this.d = zy4Var;
            zy4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092e);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            zy4 zy4Var2 = this.d;
            zy4Var2.e = R.color.CAM_X0108;
            ArrayList<yy4> e = zy4Var2.e();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    yy4 yy4Var = new yy4();
                    yy4Var.w(relateForum.forum_id.intValue());
                    yy4Var.x(relateForum.forum_name);
                    yy4Var.v(relateForum.avatar);
                    yy4Var.s(relateForum.desc);
                    yy4Var.u(relateForum.thread_num.intValue());
                    yy4Var.q(relateForum.member_num.intValue());
                    if (relateForum.is_liked.intValue() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    yy4Var.o(z3);
                    e.add(yy4Var);
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
            mw7 mw7Var = new mw7();
            this.f = mw7Var;
            mw7Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            ew7 ew7Var = new ew7();
            this.g = ew7Var;
            ew7Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            ew7 ew7Var2 = new ew7();
            this.h = ew7Var2;
            ew7Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            ew7 ew7Var3 = new ew7();
            this.i = ew7Var3;
            ew7Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            kw7 kw7Var2 = new kw7();
            this.j = kw7Var2;
            kw7Var2.a(dataRes.hot_thread);
            hw7 hw7Var = new hw7();
            this.k = hw7Var;
            hw7Var.k(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                ly4 ly4Var = new ly4();
                this.o = ly4Var;
                ly4Var.j(dataRes.hot_thread.page);
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
                        dp8 dp8Var = new dp8(specialTopic.title);
                        if (!z) {
                            dp8Var.b = false;
                            z = true;
                        }
                        this.n.add(dp8Var);
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
                        cp8 cp8Var = new cp8(threadInfo2, z2);
                        cp8Var.c(i);
                        this.n.add(cp8Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<hn> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            mw7 mw7Var = this.f;
            if (mw7Var != null) {
                this.a.add(mw7Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (eh6 eh6Var : this.m) {
                    this.a.add(eh6Var);
                }
            }
            pw7 pw7Var = this.c;
            if (pw7Var != null && pw7Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            hw7 hw7Var = this.k;
            if (hw7Var != null && !ListUtils.isEmpty(hw7Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((eh6) ListUtils.getItem(this.k.a, i));
                    pw7 pw7Var2 = this.c;
                    if (pw7Var2 != null && pw7Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
