package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.m;
import c.a.s0.s.q.e2;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.RecommendTopicData;
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
/* loaded from: classes12.dex */
public class VideoPbEnterForumAndTopicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f46919b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f46920c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f46921d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbEnterForumAndTopicViewHolder(Context context, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f46919b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f46920c;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.onChangeSkinType();
            }
            List<TopicEnterButton> list = this.f46921d;
            if (list != null) {
                for (TopicEnterButton topicEnterButton : list) {
                    topicEnterButton.onChangeSkinType();
                }
            }
        }
    }

    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || e2Var == null) {
            return;
        }
        this.f46919b.removeAllViews();
        List<TopicEnterButton> list = this.f46921d;
        if (list != null) {
            list.clear();
        }
        if (!m.isEmpty(e2Var.a0())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.a);
            this.f46920c = threadForumEnterButton;
            threadForumEnterButton.bindData(e2Var);
            this.f46919b.addView(this.f46920c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = e2Var.O2;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f46921d == null) {
            this.f46921d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : e2Var.O2.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.a);
            topicEnterButton.bindData(recommendTopicListData);
            this.f46919b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f46921d.add(topicEnterButton);
        }
    }
}
