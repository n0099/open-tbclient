package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.m;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.TopicEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
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

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f35218b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f35219c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f35220d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbEnterForumAndTopicViewHolder(Context context, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
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
        this.f35218b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f35219c;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.e();
            }
            List<TopicEnterButton> list = this.f35220d;
            if (list != null) {
                for (TopicEnterButton topicEnterButton : list) {
                    topicEnterButton.f();
                }
            }
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null) {
            return;
        }
        this.f35218b.removeAllViews();
        List<TopicEnterButton> list = this.f35220d;
        if (list != null) {
            list.clear();
        }
        if (!m.isEmpty(threadData.getForum_name())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.a);
            this.f35219c = threadForumEnterButton;
            threadForumEnterButton.a(threadData);
            this.f35218b.addView(this.f35219c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = threadData.worksInfoData;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f35220d == null) {
            this.f35220d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : threadData.worksInfoData.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.a);
            topicEnterButton.d(recommendTopicListData);
            this.f35218b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f35220d.add(topicEnterButton);
        }
    }
}
