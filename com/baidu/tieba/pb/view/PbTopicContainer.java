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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class PbTopicContainer extends LinearLayout implements View.OnClickListener {
    private int fPn;
    private TbPageContext pageContext;

    public PbTopicContainer(Context context) {
        this(context, null);
    }

    public PbTopicContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPn = 3;
        setOrientation(0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int childCount = getChildCount();
        if (childCount > this.fPn) {
            while (true) {
                childCount--;
                if (childCount <= this.fPn) {
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

    public void setData(List<au.a> list) {
        int i = 0;
        if (w.z(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        while (true) {
            int i2 = i;
            if (i2 < 3 && i2 < list.size()) {
                au.a aVar = list.get(i2);
                if (aVar != null) {
                    b(aVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void b(au.a aVar) {
        if (aVar != null) {
            Context context = getContext();
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(context, d.e.tbds72));
            int f = l.f(context, d.e.tbds22);
            layoutParams.rightMargin = f;
            textView.setTag(aVar);
            textView.setText(com.baidu.tbadk.plugins.b.hq(aVar.getTopicName()));
            addView(textView, layoutParams);
            textView.setTextSize(0, l.f(context, d.e.tbds33));
            textView.setGravity(17);
            textView.setOnClickListener(this);
            textView.setPadding(f, 0, f, 0);
            am.i(textView, d.f.shape_corner_gray_tbds4);
            am.h(textView, d.C0140d.cp_cont_b);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setMaxChildCount(int i) {
        this.fPn = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof au.a) {
            TiebaStatic.log(new an("c11455").af("obj_locate", "pb_bottom"));
            au.a aVar = (au.a) view.getTag();
            if (this.pageContext != null && !com.baidu.tbadk.plugins.b.a(this.pageContext, false, true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getContext()).createNormalConfig(aVar.uE() + "", aVar.getTopicName(), "2")));
                return;
            }
            com.baidu.tbadk.browser.a.Q(getContext(), "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + aVar.uE() + "&topic_name=" + aVar.getTopicName());
        }
    }
}
