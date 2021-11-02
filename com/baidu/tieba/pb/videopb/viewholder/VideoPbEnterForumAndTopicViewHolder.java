package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.e.p.k;
import b.a.q0.s.q.d2;
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
/* loaded from: classes9.dex */
public class VideoPbEnterForumAndTopicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52838a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f52839b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f52840c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f52841d;

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
        this.f52838a = context;
        this.f52839b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f52840c;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.onChangeSkinType();
            }
            List<TopicEnterButton> list = this.f52841d;
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
        this.f52839b.removeAllViews();
        List<TopicEnterButton> list = this.f52841d;
        if (list != null) {
            list.clear();
        }
        if (!k.isEmpty(d2Var.Z())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f52838a);
            this.f52840c = threadForumEnterButton;
            threadForumEnterButton.bindData(d2Var);
            this.f52839b.addView(this.f52840c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = d2Var.M2;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f52841d == null) {
            this.f52841d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : d2Var.M2.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.f52838a);
            topicEnterButton.bindData(recommendTopicListData);
            this.f52839b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f52841d.add(topicEnterButton);
        }
    }
}
