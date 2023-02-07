package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.RelateThread;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicDetail;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class mg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public String c;
    public String d;
    public ng7 e;
    public List<Cdo> f;
    public boolean g;
    public boolean h;
    public boolean i;

    public mg7() {
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
        this.i = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) != null) || dataRes == null) {
            return;
        }
        boolean z = false;
        this.h = false;
        TopicDetail topicDetail = dataRes.topic_info;
        if (topicDetail != null) {
            this.a = topicDetail.topic_id.longValue();
            TopicDetail topicDetail2 = dataRes.topic_info;
            this.b = topicDetail2.topic_name;
            this.c = topicDetail2.share_title;
            this.d = topicDetail2.share_pic;
            ng7 ng7Var = new ng7();
            this.e = ng7Var;
            ng7Var.a(dataRes.topic_info);
            if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                this.h = true;
            }
        }
        if (dataRes.pk_module != null) {
            this.i = true;
            this.h = true;
            if (this.e == null) {
                this.e = new ng7();
            }
            this.e.b(dataRes.pk_module);
        } else {
            this.i = false;
        }
        if (dataRes.time_line != null) {
            this.h = true;
            if (this.e == null) {
                this.e = new ng7();
            }
            this.e.c(dataRes.time_line);
        }
        this.f = new ArrayList();
        if (!ListUtils.isEmpty(dataRes.special_topic)) {
            this.h = true;
            int i = 1;
            for (SpecialTopic specialTopic : dataRes.special_topic) {
                if (specialTopic != null && !ListUtils.isEmpty(specialTopic.thread_list)) {
                    boolean z2 = false;
                    for (ThreadInfo threadInfo : specialTopic.thread_list) {
                        if (threadInfo != null) {
                            pg7 pg7Var = new pg7();
                            if (!z2) {
                                pg7Var.a = true;
                                pg7Var.d = specialTopic.title;
                                z2 = true;
                            }
                            pg7Var.b = i;
                            pg7Var.c = this.a;
                            pg7Var.c(threadInfo);
                            this.f.add(pg7Var);
                            i++;
                        }
                    }
                }
            }
        }
        if (this.h) {
            dh7 dh7Var = new dh7();
            dh7Var.a = R.dimen.tbds78;
            dh7Var.b = R.color.CAM_X0201;
            this.f.add(dh7Var);
        }
        RelateThread relateThread = dataRes.relate_thread;
        if (relateThread != null && !ListUtils.isEmpty(relateThread.thread_list)) {
            dh7 dh7Var2 = new dh7();
            dh7Var2.a = R.dimen.tbds16;
            this.f.add(dh7Var2);
            if (dataRes.relate_thread.has_more.intValue() == 1) {
                z = true;
            }
            this.g = z;
            for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                if (topicThread != null) {
                    og7 og7Var = new og7();
                    og7Var.c(topicThread);
                    og7Var.c = this.a;
                    og7Var.f = this.i;
                    this.f.add(og7Var);
                }
            }
        }
    }
}
