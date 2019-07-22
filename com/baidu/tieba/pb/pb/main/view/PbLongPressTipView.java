package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbLongPressTipView extends LinearLayout {
    private LinearLayout bOb;
    private ImageView bYN;
    private Context context;
    private TextView eVC;
    private TextView ffr;

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
        this.bOb = (LinearLayout) findViewById(R.id.pb_long_tip_content);
        this.bYN = (ImageView) findViewById(R.id.pb_long_tip_image);
        this.ffr = (TextView) findViewById(R.id.long_hint_title);
        this.eVC = (TextView) findViewById(R.id.long_hint_text);
        am.f(this.ffr, R.color.cp_cont_b, 1);
        am.f(this.eVC, R.color.common_color_10037, 1);
        am.c(this.bYN, (int) R.drawable.pic_pb_popup_longpress);
    }
}
