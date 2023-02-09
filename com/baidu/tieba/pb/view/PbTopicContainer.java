package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.ap5;
import com.baidu.tieba.ej;
import com.baidu.tieba.no5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class PbTopicContainer extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbTopicContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            for (int i = 0; i < 3 && i < list.size(); i++) {
                RecommendTopicData.RecommendTopicListData recommendTopicListData = list.get(i);
                if (recommendTopicListData != null) {
                    a(recommendTopicListData);
                }
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        setOrientation(0);
    }

    public final void a(RecommendTopicData.RecommendTopicListData recommendTopicListData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, recommendTopicListData) != null) || recommendTopicListData == null) {
            return;
        }
        Context context = getContext();
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ej.g(context, R.dimen.tbds72));
        int g = ej.g(context, R.dimen.tbds22);
        layoutParams.rightMargin = g;
        textView.setTag(recommendTopicListData);
        textView.setText(no5.a(recommendTopicListData.getTopicName()));
        addView(textView, layoutParams);
        textView.setTextSize(0, ej.g(context, R.dimen.tbds33));
        textView.setGravity(17);
        textView.setOnClickListener(this);
        textView.setPadding(g, 0, g, 0);
        SkinManager.setBackgroundResource(textView, R.drawable.shape_corner_gray_tbds4);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (view2.getTag() instanceof RecommendTopicData.RecommendTopicListData)) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).param("obj_locate", TbadkCoreStatisticKey.HOT_TOPIC_CLICK_PB_BOTTOM));
            RecommendTopicData.RecommendTopicListData recommendTopicListData = (RecommendTopicData.RecommendTopicListData) view2.getTag();
            TbPageContext tbPageContext = this.b;
            if (tbPageContext != null && !no5.c(tbPageContext, false, true)) {
                if (recommendTopicListData.getIsVideoTopicInt() != 1 && NewWebHotTopicPageSwitch.isOn()) {
                    TbPageContext tbPageContext2 = this.b;
                    ap5.e(tbPageContext2, recommendTopicListData.getTopicId() + "", recommendTopicListData.getTopicName());
                    return;
                }
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(getContext());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicActivityConfig.createNormalConfig(recommendTopicListData.getTopicId() + "", recommendTopicListData.getTopicName(), "2")));
                return;
            }
            Context context = getContext();
            BrowserHelper.p(context, "https://tieba.baidu.com/mo/q/hotmessage?topic_id=" + recommendTopicListData.getTopicId() + "&topic_name=" + recommendTopicListData.getTopicName());
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
            int childCount = getChildCount();
            if (childCount > this.a) {
                while (true) {
                    childCount--;
                    if (childCount <= this.a) {
                        break;
                    }
                    removeViewAt(childCount);
                }
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < getChildCount()) {
                View childAt = getChildAt(i3);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                childAt.measure(LinearLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), LinearLayout.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                i4 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                if (i4 > size) {
                    break;
                }
                i3++;
            }
            for (int childCount2 = getChildCount() - 1; childCount2 >= i3; childCount2--) {
                removeViewAt(childCount2);
            }
            super.onMeasure(i, i2);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }
}
