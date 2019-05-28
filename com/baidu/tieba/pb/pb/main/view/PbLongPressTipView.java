package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbLongPressTipView extends LinearLayout {
    private LinearLayout bMZ;
    private ImageView bXK;
    private Context context;
    private TextView eQC;
    private TextView faq;

    public PbLongPressTipView(Context context) {
        super(context);
        this.context = context;
        ap(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        ap(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        ap(context);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pb_long_press_tip_view, this);
        setOrientation(1);
        this.bMZ = (LinearLayout) findViewById(R.id.pb_long_tip_content);
        this.bXK = (ImageView) findViewById(R.id.pb_long_tip_image);
        this.faq = (TextView) findViewById(R.id.long_hint_title);
        this.eQC = (TextView) findViewById(R.id.long_hint_text);
        al.f(this.faq, R.color.cp_cont_b, 1);
        al.f(this.eQC, R.color.common_color_10037, 1);
        al.c(this.bXK, (int) R.drawable.pic_pb_popup_longpress);
    }
}
