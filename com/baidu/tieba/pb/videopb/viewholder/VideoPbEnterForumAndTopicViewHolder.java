package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.e.p.k;
import c.a.o0.s.q.c2;
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
/* loaded from: classes7.dex */
public class VideoPbEnterForumAndTopicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f55319a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f55320b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f55321c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f55322d;

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
        this.f55319a = context;
        this.f55320b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f55321c;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.onChangeSkinType();
            }
            List<TopicEnterButton> list = this.f55322d;
            if (list != null) {
                for (TopicEnterButton topicEnterButton : list) {
                    topicEnterButton.onChangeSkinType();
                }
            }
        }
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) || c2Var == null) {
            return;
        }
        this.f55320b.removeAllViews();
        List<TopicEnterButton> list = this.f55322d;
        if (list != null) {
            list.clear();
        }
        if (!k.isEmpty(c2Var.Z())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f55319a);
            this.f55321c = threadForumEnterButton;
            threadForumEnterButton.bindData(c2Var);
            this.f55320b.addView(this.f55321c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = c2Var.J2;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f55322d == null) {
            this.f55322d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : c2Var.J2.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.f55319a);
            topicEnterButton.bindData(recommendTopicListData);
            this.f55320b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f55322d.add(topicEnterButton);
        }
    }
}
