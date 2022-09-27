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
public class w67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Cdo> a;
    public x67 b;
    public d77 c;
    public ot4 d;
    public PostForumData e;
    public a77 f;
    public s67 g;
    public s67 h;
    public s67 i;
    public y67 j;
    public v67 k;
    public y67 l;
    public List<p26> m;
    public List<Cdo> n;
    public zs4 o;
    public int p;
    public RecomTopicList q;

    public w67() {
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

    public s67 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (s67) invokeV.objValue;
    }

    public s67 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (s67) invokeV.objValue;
    }

    public ot4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (ot4) invokeV.objValue;
    }

    public a77 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (a77) invokeV.objValue;
    }

    public x67 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (x67) invokeV.objValue;
    }

    public List<Cdo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public s67 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (s67) invokeV.objValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.is_new_url.intValue();
        if (dataRes.topic_info != null) {
            x67 x67Var = new x67();
            this.b = x67Var;
            x67Var.a(dataRes.topic_info);
        }
        HotThread hotThread = dataRes.good_threads;
        if (hotThread != null && !StringUtils.isNull(hotThread.hot_title) && ListUtils.getCount(dataRes.good_threads.thread_list) != 0) {
            y67 y67Var = new y67();
            this.l = y67Var;
            y67Var.a(dataRes.good_threads);
            this.m = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                ThreadData threadData = new ThreadData();
                threadData.setResource(5);
                threadData.parserProtobuf(threadInfo);
                p26 p26Var = null;
                if (threadData.isShareThread) {
                    p26Var = new x26();
                    p26Var.a = threadData;
                } else if (y26.R(threadData)) {
                    p26Var = new y26(threadData);
                    p26Var.s = true;
                } else if (x26.W(threadData)) {
                    p26Var = new x26();
                    p26Var.a = threadData;
                }
                if (p26Var != null && p26Var.isValid()) {
                    p26Var.L("c10814");
                    this.m.add(p26Var);
                }
            }
        }
        List<RelateForum> list = dataRes.relate_forum;
        if (list != null && list.size() != 0) {
            d77 d77Var = new d77();
            this.c = d77Var;
            d77Var.parserProtobuf(dataRes.relate_forum);
            ot4 ot4Var = new ot4();
            this.d = ot4Var;
            ot4Var.floorPosition = 2;
            if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                this.d.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0892);
            } else {
                this.d.d = dataRes.relate_forum_title;
            }
            ot4 ot4Var2 = this.d;
            ot4Var2.e = R.color.CAM_X0108;
            ArrayList<nt4> h = ot4Var2.h();
            for (RelateForum relateForum : dataRes.relate_forum) {
                if (!StringUtils.isNull(relateForum.forum_name)) {
                    nt4 nt4Var = new nt4();
                    nt4Var.D(relateForum.forum_id.intValue());
                    nt4Var.E(relateForum.forum_name);
                    nt4Var.C(relateForum.avatar);
                    nt4Var.A(relateForum.desc);
                    nt4Var.B(relateForum.thread_num.intValue());
                    nt4Var.z(relateForum.member_num.intValue());
                    nt4Var.w(relateForum.is_liked.intValue() != 0);
                    h.add(nt4Var);
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
            a77 a77Var = new a77();
            this.f = a77Var;
            a77Var.a(dataRes.pk_module);
        }
        if (dataRes.bless_module != null) {
            s67 s67Var = new s67();
            this.g = s67Var;
            s67Var.a(dataRes.bless_module);
        }
        if (dataRes.candle_module != null) {
            s67 s67Var2 = new s67();
            this.h = s67Var2;
            s67Var2.a(dataRes.candle_module);
        }
        if (dataRes.weiguan_module != null) {
            s67 s67Var3 = new s67();
            this.i = s67Var3;
            s67Var3.a(dataRes.weiguan_module);
        }
        HotThread hotThread2 = dataRes.hot_thread;
        if (hotThread2 != null && ListUtils.getCount(hotThread2.thread_list) != 0) {
            y67 y67Var2 = new y67();
            this.j = y67Var2;
            y67Var2.a(dataRes.hot_thread);
            v67 v67Var = new v67();
            this.k = v67Var;
            v67Var.r(dataRes.hot_thread);
            if (dataRes.hot_thread.page != null) {
                zs4 zs4Var = new zs4();
                this.o = zs4Var;
                zs4Var.j(dataRes.hot_thread.page);
                this.o.b();
            }
            dataRes.is_global_block.intValue();
        }
        this.q = dataRes.next_topic;
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.n = new ArrayList();
            boolean z = this.f != null;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (!ListUtils.isEmpty(specialTopic.thread_list)) {
                    if (!TextUtils.isEmpty(specialTopic.title)) {
                        gr7 gr7Var = new gr7(specialTopic.title);
                        if (!z) {
                            gr7Var.b = false;
                            z = true;
                        }
                        this.n.add(gr7Var);
                    }
                    int size = specialTopic.thread_list.size();
                    int i = 0;
                    while (i < size) {
                        ThreadInfo threadInfo2 = specialTopic.thread_list.get(i);
                        i++;
                        fr7 fr7Var = new fr7(threadInfo2, i == size);
                        fr7Var.c(i);
                        this.n.add(fr7Var);
                    }
                }
            }
        }
        i();
    }

    public final ArrayList<Cdo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a77 a77Var = this.f;
            if (a77Var != null) {
                this.a.add(a77Var);
            }
            if (ListUtils.getCount(this.m) > 0) {
                this.a.add(this.l);
                if (this.m.size() > 5) {
                    this.m = this.m.subList(0, 5);
                }
                for (p26 p26Var : this.m) {
                    this.a.add(p26Var);
                }
            }
            d77 d77Var = this.c;
            if (d77Var != null && d77Var.getCount() > 0 && this.p == 1) {
                this.a.add(this.c);
            }
            v67 v67Var = this.k;
            if (v67Var != null && !ListUtils.isEmpty(v67Var.a)) {
                this.a.add(this.j);
                for (int i = 0; i < this.k.a.size(); i++) {
                    this.a.add((p26) ListUtils.getItem(this.k.a, i));
                    d77 d77Var2 = this.c;
                    if (d77Var2 != null && d77Var2.getCount() > 0 && i == 2 && this.p == 0) {
                        this.a.add(this.c);
                    }
                }
            }
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }
}
