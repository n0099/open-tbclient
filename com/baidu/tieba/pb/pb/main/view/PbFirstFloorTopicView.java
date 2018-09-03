package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbFirstFloorTopicView extends LinearLayout implements View.OnClickListener {
    private int dqa;
    private int dqd;
    private Context mContext;
    private int mWidth;

    public PbFirstFloorTopicView(Context context) {
        super(context);
        this.mContext = null;
        init(context);
    }

    public PbFirstFloorTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        init(context);
    }

    public PbFirstFloorTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.mContext = context;
        this.dqd = l.f(this.mContext, f.e.ds8);
        this.mWidth = l.ah(this.mContext);
        this.dqa = l.ah(this.mContext) / 2;
    }

    public void setData(ArrayList<String> arrayList) {
        LinearLayout linearLayout;
        if (!w.z(arrayList)) {
            if (getChildCount() > 0) {
                removeAllViews();
            }
            int y = w.y(arrayList);
            LinearLayout linearLayout2 = null;
            int i = 0;
            while (i < y) {
                if (i % 2 == 0) {
                    linearLayout = beY();
                } else {
                    if (linearLayout2 != null) {
                        b(linearLayout2, (String) w.d(arrayList, i - 1));
                        b(linearLayout2, (String) w.d(arrayList, i));
                    }
                    linearLayout = linearLayout2;
                }
                i++;
                linearLayout2 = linearLayout;
            }
            if (linearLayout2 != null && linearLayout2.getChildCount() == 0) {
                this.dqa = this.mWidth;
                b(linearLayout2, (String) w.d(arrayList, y - 1));
            }
        }
    }

    private void b(LinearLayout linearLayout, String str) {
        TextView textView = new TextView(this.mContext);
        textView.setText(str);
        textView.setGravity(17);
        am.j(textView, f.d.cp_bg_line_c);
        am.h(textView, f.d.black_alpha100);
        textView.setTextSize(0, getResources().getDimension(f.e.ds28));
        textView.setTypeface(null, 1);
        textView.setMinLines(1);
        textView.setMaxLines(1);
        textView.setWidth(this.dqa);
        textView.setOnClickListener(this);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.dqd;
        layoutParams.rightMargin = this.dqd;
    }

    private LinearLayout beY() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        am.j(linearLayout, f.d.transparent);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.mWidth, -2));
        linearLayout.setGravity(17);
        addView(linearLayout);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TextView) && ((TextView) view).getText() != null) {
            ((TextView) view).getText().toString();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeAllViews();
        super.onDetachedFromWindow();
    }
}
