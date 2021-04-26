package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.l.a;
import d.a.i0.p0.b;
import java.util.List;
/* loaded from: classes3.dex */
public class PbTopicContainer extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f20354e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f20355f;

    public PbTopicContainer(Context context) {
        this(context, null);
    }

    public final void a(RecommendTopicData.RecommendTopicListData recommendTopicListData) {
        if (recommendTopicListData == null) {
            return;
        }
        Context context = getContext();
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, R.dimen.tbds72));
        int g2 = l.g(context, R.dimen.tbds22);
        layoutParams.rightMargin = g2;
        textView.setTag(recommendTopicListData);
        textView.setText(b.a(recommendTopicListData.getTopicName()));
        addView(textView, layoutParams);
        textView.setTextSize(0, l.g(context, R.dimen.tbds33));
        textView.setGravity(17);
        textView.setOnClickListener(this);
        textView.setPadding(g2, 0, g2, 0);
        SkinManager.setBackgroundResource(textView, R.drawable.shape_corner_gray_tbds4);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof RecommendTopicData.RecommendTopicListData) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).param("obj_locate", TbadkCoreStatisticKey.HOT_TOPIC_CLICK_PB_BOTTOM));
            RecommendTopicData.RecommendTopicListData recommendTopicListData = (RecommendTopicData.RecommendTopicListData) view.getTag();
            TbPageContext tbPageContext = this.f20355f;
            if (tbPageContext != null && !b.c(tbPageContext, false, true)) {
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(getContext());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicActivityConfig.createNormalConfig(recommendTopicListData.getTopicId() + "", recommendTopicListData.getTopicName(), "2")));
                return;
            }
            Context context = getContext();
            a.l(context, "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + recommendTopicListData.getTopicId() + "&topic_name=" + recommendTopicListData.getTopicName());
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = (View.MeasureSpec.getSize(i2) - getPaddingRight()) - getPaddingLeft();
        int childCount = getChildCount();
        if (childCount > this.f20354e) {
            while (true) {
                childCount--;
                if (childCount <= this.f20354e) {
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

    public void setData(List<RecommendTopicData.RecommendTopicListData> list) {
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

    public void setMaxChildCount(int i2) {
        this.f20354e = i2;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f20355f = tbPageContext;
    }

    public PbTopicContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20354e = 3;
        setOrientation(0);
    }
}
