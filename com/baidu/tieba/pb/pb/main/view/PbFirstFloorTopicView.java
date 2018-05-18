package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbFirstFloorTopicView extends LinearLayout implements View.OnClickListener {
    private int dbO;
    private Context mContext;
    private int mTextWidth;
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
        this.dbO = l.e(this.mContext, d.e.ds8);
        this.mWidth = l.af(this.mContext);
        this.mTextWidth = l.af(this.mContext) / 2;
    }

    public void setData(ArrayList<String> arrayList) {
        LinearLayout linearLayout;
        if (!v.w(arrayList)) {
            if (getChildCount() > 0) {
                removeAllViews();
            }
            int v = v.v(arrayList);
            LinearLayout linearLayout2 = null;
            int i = 0;
            while (i < v) {
                if (i % 2 == 0) {
                    linearLayout = bbd();
                } else {
                    if (linearLayout2 != null) {
                        a(linearLayout2, (String) v.c(arrayList, i - 1));
                        a(linearLayout2, (String) v.c(arrayList, i));
                    }
                    linearLayout = linearLayout2;
                }
                i++;
                linearLayout2 = linearLayout;
            }
            if (linearLayout2 != null && linearLayout2.getChildCount() == 0) {
                this.mTextWidth = this.mWidth;
                a(linearLayout2, (String) v.c(arrayList, v - 1));
            }
        }
    }

    private void a(LinearLayout linearLayout, String str) {
        TextView textView = new TextView(this.mContext);
        textView.setText(str);
        textView.setGravity(17);
        ak.j(textView, d.C0126d.cp_bg_line_c);
        ak.h(textView, d.C0126d.black_alpha100);
        textView.setTextSize(0, getResources().getDimension(d.e.ds28));
        textView.setTypeface(null, 1);
        textView.setMinLines(1);
        textView.setMaxLines(1);
        textView.setWidth(this.mTextWidth);
        textView.setOnClickListener(this);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.dbO;
        layoutParams.rightMargin = this.dbO;
    }

    private LinearLayout bbd() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        ak.j(linearLayout, d.C0126d.transparent);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.mWidth, -2));
        linearLayout.setGravity(17);
        addView(linearLayout);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if ((view2 instanceof TextView) && ((TextView) view2).getText() != null) {
            ((TextView) view2).getText().toString();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeAllViews();
        super.onDetachedFromWindow();
    }
}
