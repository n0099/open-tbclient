package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbFirstFloorTopicView extends LinearLayout implements View.OnClickListener {
    private int fdj;
    private int fdm;
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
        this.fdm = l.h(this.mContext, d.e.ds8);
        this.mWidth = l.aO(this.mContext);
        this.fdj = l.aO(this.mContext) / 2;
    }

    public void setData(ArrayList<String> arrayList) {
        LinearLayout linearLayout;
        if (!v.T(arrayList)) {
            if (getChildCount() > 0) {
                removeAllViews();
            }
            int S = v.S(arrayList);
            LinearLayout linearLayout2 = null;
            int i = 0;
            while (i < S) {
                if (i % 2 == 0) {
                    linearLayout = bNP();
                } else {
                    if (linearLayout2 != null) {
                        b(linearLayout2, (String) v.c(arrayList, i - 1));
                        b(linearLayout2, (String) v.c(arrayList, i));
                    }
                    linearLayout = linearLayout2;
                }
                i++;
                linearLayout2 = linearLayout;
            }
            if (linearLayout2 != null && linearLayout2.getChildCount() == 0) {
                this.fdj = this.mWidth;
                b(linearLayout2, (String) v.c(arrayList, S - 1));
            }
        }
    }

    private void b(LinearLayout linearLayout, String str) {
        TextView textView = new TextView(this.mContext);
        textView.setText(str);
        textView.setGravity(17);
        al.l(textView, d.C0277d.cp_bg_line_c);
        al.j(textView, d.C0277d.black_alpha100);
        textView.setTextSize(0, getResources().getDimension(d.e.ds28));
        textView.setTypeface(null, 1);
        textView.setMinLines(1);
        textView.setMaxLines(1);
        textView.setWidth(this.fdj);
        textView.setOnClickListener(this);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.fdm;
        layoutParams.rightMargin = this.fdm;
    }

    private LinearLayout bNP() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        al.l(linearLayout, d.C0277d.transparent);
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
