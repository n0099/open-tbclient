package com.baidu.tieba.pb.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class PbTopicContainer extends LinearLayout implements View.OnClickListener {
    private int hYb;
    private TbPageContext pageContext;

    public PbTopicContainer(Context context) {
        this(context, null);
    }

    public PbTopicContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYb = 3;
        setOrientation(0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int childCount = getChildCount();
        if (childCount > this.hYb) {
            while (true) {
                childCount--;
                if (childCount <= this.hYb) {
                    break;
                }
                removeViewAt(childCount);
            }
        }
        int i4 = 0;
        while (i3 < getChildCount()) {
            View childAt = getChildAt(i3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
            i4 += layoutParams.rightMargin + childAt.getMeasuredWidth() + layoutParams.leftMargin;
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

    public void setData(List<ay.a> list) {
        int i = 0;
        if (v.aa(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        while (true) {
            int i2 = i;
            if (i2 < 3 && i2 < list.size()) {
                ay.a aVar = list.get(i2);
                if (aVar != null) {
                    b(aVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void b(ay.a aVar) {
        if (aVar != null) {
            Context context = getContext();
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(context, R.dimen.tbds72));
            int g = l.g(context, R.dimen.tbds22);
            layoutParams.rightMargin = g;
            textView.setTag(aVar);
            textView.setText(com.baidu.tbadk.plugins.b.qG(aVar.getTopicName()));
            addView(textView, layoutParams);
            textView.setTextSize(0, l.g(context, R.dimen.tbds33));
            textView.setGravity(17);
            textView.setOnClickListener(this);
            textView.setPadding(g, 0, g, 0);
            al.k(textView, R.drawable.shape_corner_gray_tbds4);
            al.j(textView, R.color.cp_cont_b);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setMaxChildCount(int i) {
        this.hYb = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ay.a) {
            TiebaStatic.log(new am("c11455").bT("obj_locate", "pb_bottom"));
            ay.a aVar = (ay.a) view.getTag();
            if (this.pageContext != null && !com.baidu.tbadk.plugins.b.a(this.pageContext, false, true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getContext()).createNormalConfig(aVar.acG() + "", aVar.getTopicName(), "2")));
                return;
            }
            com.baidu.tbadk.browser.a.af(getContext(), "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + aVar.acG() + "&topic_name=" + aVar.getTopicName());
        }
    }
}
