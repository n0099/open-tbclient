package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.l;
import c.a.r0.s.r.d2;
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
    public FlowLabelLayout f48519b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f48520c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f48521d;

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
        this.f48519b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f48520c;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.onChangeSkinType();
            }
            List<TopicEnterButton> list = this.f48521d;
            if (list != null) {
                for (TopicEnterButton topicEnterButton : list) {
                    topicEnterButton.onChangeSkinType();
                }
            }
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.f48519b.removeAllViews();
        List<TopicEnterButton> list = this.f48521d;
        if (list != null) {
            list.clear();
        }
        if (!l.isEmpty(d2Var.a0())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.a);
            this.f48520c = threadForumEnterButton;
            threadForumEnterButton.bindData(d2Var);
            this.f48519b.addView(this.f48520c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = d2Var.P2;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f48521d == null) {
            this.f48521d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : d2Var.P2.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.a);
            topicEnterButton.bindData(recommendTopicListData);
            this.f48519b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f48521d.add(topicEnterButton);
        }
    }
}
