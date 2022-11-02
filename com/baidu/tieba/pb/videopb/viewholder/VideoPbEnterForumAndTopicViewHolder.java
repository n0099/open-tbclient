package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.TopicEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPbEnterForumAndTopicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public FlowLabelLayout b;
    public ThreadForumEnterButton c;
    public List<TopicEnterButton> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbEnterForumAndTopicViewHolder(Context context, View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = (FlowLabelLayout) ((ViewGroup) view2).getChildAt(0);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.c;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.e();
            }
            List<TopicEnterButton> list = this.d;
            if (list != null) {
                for (TopicEnterButton topicEnterButton : list) {
                    topicEnterButton.c();
                }
            }
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) != null) || threadData == null) {
            return;
        }
        this.b.removeAllViews();
        List<TopicEnterButton> list = this.d;
        if (list != null) {
            list.clear();
        }
        if (!wi.isEmpty(threadData.getForum_name())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.a);
            this.c = threadForumEnterButton;
            threadForumEnterButton.a(threadData);
            this.b.addView(this.c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = threadData.worksInfoData;
        if (worksInfoData != null && !ListUtils.isEmpty(worksInfoData.topicListData)) {
            if (this.d == null) {
                this.d = new LinkedList();
            }
            for (RecommendTopicData.RecommendTopicListData recommendTopicListData : threadData.worksInfoData.topicListData) {
                TopicEnterButton topicEnterButton = new TopicEnterButton(this.a);
                topicEnterButton.a(recommendTopicListData);
                this.b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
                this.d.add(topicEnterButton);
            }
        }
    }
}
