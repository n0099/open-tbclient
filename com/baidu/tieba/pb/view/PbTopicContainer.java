package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.a.e.f.p.l;
import b.a.q0.m.a;
import b.a.q0.s0.b;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class PbTopicContainer extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f53844e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f53845f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbTopicContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(RecommendTopicData.RecommendTopicListData recommendTopicListData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, recommendTopicListData) == null) || recommendTopicListData == null) {
            return;
        }
        Context context = getContext();
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, g.tbds72));
        int g2 = l.g(context, g.tbds22);
        layoutParams.rightMargin = g2;
        textView.setTag(recommendTopicListData);
        textView.setText(b.a(recommendTopicListData.getTopicName()));
        addView(textView, layoutParams);
        textView.setTextSize(0, l.g(context, g.tbds33));
        textView.setGravity(17);
        textView.setOnClickListener(this);
        textView.setPadding(g2, 0, g2, 0);
        SkinManager.setBackgroundResource(textView, h.shape_corner_gray_tbds4);
        SkinManager.setViewTextColor(textView, f.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && (view.getTag() instanceof RecommendTopicData.RecommendTopicListData)) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).param("obj_locate", TbadkCoreStatisticKey.HOT_TOPIC_CLICK_PB_BOTTOM));
            RecommendTopicData.RecommendTopicListData recommendTopicListData = (RecommendTopicData.RecommendTopicListData) view.getTag();
            TbPageContext tbPageContext = this.f53845f;
            if (tbPageContext != null && !b.c(tbPageContext, false, true)) {
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(getContext());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicActivityConfig.createNormalConfig(recommendTopicListData.getTopicId() + "", recommendTopicListData.getTopicName(), "2")));
                return;
            }
            Context context = getContext();
            a.m(context, "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + recommendTopicListData.getTopicId() + "&topic_name=" + recommendTopicListData.getTopicName());
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int size = (View.MeasureSpec.getSize(i2) - getPaddingRight()) - getPaddingLeft();
            int childCount = getChildCount();
            if (childCount > this.f53844e) {
                while (true) {
                    childCount--;
                    if (childCount <= this.f53844e) {
                        break;
                    }
                    removeViewAt(childCount);
                }
            }
            int i4 = 0;
            int i5 = 0;
            while (i4 < getChildCount()) {
                View childAt = getChildAt(i4);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                childAt.measure(LinearLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), layoutParams.width), LinearLayout.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                i5 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                if (i5 > size) {
                    break;
                }
                i4++;
            }
            for (int childCount2 = getChildCount() - 1; childCount2 >= i4; childCount2--) {
                removeViewAt(childCount2);
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setData(List<RecommendTopicData.RecommendTopicListData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            removeAllViews();
            for (int i2 = 0; i2 < 3 && i2 < list.size(); i2++) {
                RecommendTopicData.RecommendTopicListData recommendTopicListData = list.get(i2);
                if (recommendTopicListData != null) {
                    a(recommendTopicListData);
                }
            }
        }
    }

    public void setMaxChildCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f53844e = i2;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.f53845f = tbPageContext;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbTopicContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53844e = 3;
        setOrientation(0);
    }
}
