package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes5.dex */
public class n67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<r67> b;
    public q67 c;
    public List<g67> d;
    public List<f67> e;
    public List<TopicList> f;
    public List<NewTopicList> g;

    public n67() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public List<TopicList> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        List<TopicList> list;
        List<TopicList> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        List<TabList> list3 = dataRes.tab_list;
        if (list3 != null && !ListUtils.isEmpty(list3)) {
            this.b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                r67 r67Var = new r67();
                r67Var.a(tabList);
                this.b.add(r67Var);
            }
        }
        if (dataRes.media_topic != null) {
            q67 q67Var = new q67();
            this.c = q67Var;
            q67Var.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                f67 f67Var = new f67();
                f67Var.b(dataRes.topic_manual);
                f67Var.a(dataRes.topic_manual.topic_list.get(i));
                this.e.add(f67Var);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                g67 g67Var = new g67();
                g67Var.b(dataRes.topic_bang);
                g67Var.a(dataRes.topic_bang.topic_list.get(i2));
                this.d.add(g67Var);
            }
        }
        this.f = dataRes.frs_tab_topic;
        this.g = dataRes.topic_list;
    }
}
