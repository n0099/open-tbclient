package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
import d.a.d.e.p.k;
import d.a.p0.s.q.b2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoPbEnterForumAndTopicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f19957a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f19958b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f19959c;

    /* renamed from: d  reason: collision with root package name */
    public List<TopicEnterButton> f19960d;

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
        this.f19957a = context;
        this.f19958b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadForumEnterButton threadForumEnterButton = this.f19959c;
            if (threadForumEnterButton != null) {
                threadForumEnterButton.e();
            }
            List<TopicEnterButton> list = this.f19960d;
            if (list != null) {
                for (TopicEnterButton topicEnterButton : list) {
                    topicEnterButton.f();
                }
            }
        }
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.f19958b.removeAllViews();
        List<TopicEnterButton> list = this.f19960d;
        if (list != null) {
            list.clear();
        }
        if (!k.isEmpty(b2Var.X())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f19957a);
            this.f19959c = threadForumEnterButton;
            threadForumEnterButton.a(b2Var);
            this.f19958b.addView(this.f19959c, new ViewGroup.LayoutParams(-2, -2));
        }
        WorksInfoData worksInfoData = b2Var.I2;
        if (worksInfoData == null || ListUtils.isEmpty(worksInfoData.topicListData)) {
            return;
        }
        if (this.f19960d == null) {
            this.f19960d = new LinkedList();
        }
        for (RecommendTopicData.RecommendTopicListData recommendTopicListData : b2Var.I2.topicListData) {
            TopicEnterButton topicEnterButton = new TopicEnterButton(this.f19957a);
            topicEnterButton.d(recommendTopicListData);
            this.f19958b.addView(topicEnterButton, new ViewGroup.LayoutParams(-2, -2));
            this.f19960d.add(topicEnterButton);
        }
    }
}
