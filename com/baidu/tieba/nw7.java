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
public class nw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<rw7> b;
    public qw7 c;
    public List<gw7> d;
    public List<fw7> e;
    public List<TopicList> f;

    public nw7() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        List<TopicList> list;
        List<TopicList> list2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) != null) || dataRes == null) {
            return;
        }
        List<TabList> list3 = dataRes.tab_list;
        if (list3 != null && !ListUtils.isEmpty(list3)) {
            this.b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                rw7 rw7Var = new rw7();
                rw7Var.a(tabList);
                this.b.add(rw7Var);
            }
        }
        if (dataRes.media_topic != null) {
            qw7 qw7Var = new qw7();
            this.c = qw7Var;
            qw7Var.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                fw7 fw7Var = new fw7();
                fw7Var.b(dataRes.topic_manual);
                fw7Var.a(dataRes.topic_manual.topic_list.get(i));
                this.e.add(fw7Var);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                gw7 gw7Var = new gw7();
                gw7Var.b(dataRes.topic_bang);
                gw7Var.a(dataRes.topic_bang.topic_list.get(i2));
                this.d.add(gw7Var);
            }
        }
        this.f = dataRes.frs_tab_topic;
        List<NewTopicList> list4 = dataRes.topic_list;
    }
}
