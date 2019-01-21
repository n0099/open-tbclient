package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PbFirstFloorTopicView extends LinearLayout implements View.OnClickListener {
    private int dPC;
    private int dPF;
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
        this.dPF = l.h(this.mContext, e.C0210e.ds8);
        this.mWidth = l.aO(this.mContext);
        this.dPC = l.aO(this.mContext) / 2;
    }

    public void setData(ArrayList<String> arrayList) {
        LinearLayout linearLayout;
        if (!v.I(arrayList)) {
            if (getChildCount() > 0) {
                removeAllViews();
            }
            int H = v.H(arrayList);
            LinearLayout linearLayout2 = null;
            int i = 0;
            while (i < H) {
                if (i % 2 == 0) {
                    linearLayout = bnx();
                } else {
                    if (linearLayout2 != null) {
                        b(linearLayout2, (String) v.d(arrayList, i - 1));
                        b(linearLayout2, (String) v.d(arrayList, i));
                    }
                    linearLayout = linearLayout2;
                }
                i++;
                linearLayout2 = linearLayout;
            }
            if (linearLayout2 != null && linearLayout2.getChildCount() == 0) {
                this.dPC = this.mWidth;
                b(linearLayout2, (String) v.d(arrayList, H - 1));
            }
        }
    }

    private void b(LinearLayout linearLayout, String str) {
        TextView textView = new TextView(this.mContext);
        textView.setText(str);
        textView.setGravity(17);
        al.j(textView, e.d.cp_bg_line_c);
        al.h(textView, e.d.black_alpha100);
        textView.setTextSize(0, getResources().getDimension(e.C0210e.ds28));
        textView.setTypeface(null, 1);
        textView.setMinLines(1);
        textView.setMaxLines(1);
        textView.setWidth(this.dPC);
        textView.setOnClickListener(this);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.dPF;
        layoutParams.rightMargin = this.dPF;
    }

    private LinearLayout bnx() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        al.j(linearLayout, e.d.transparent);
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
