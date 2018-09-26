package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class PbLongPressTipView extends LinearLayout {
    private LinearLayout aAJ;
    private ImageView ayi;
    private Context context;
    private TextView ddU;
    private TextView fQX;

    public PbLongPressTipView(Context context) {
        super(context);
        this.context = context;
        cf(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        cf(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        cf(context);
    }

    private void cf(Context context) {
        LayoutInflater.from(context).inflate(e.h.pb_long_press_tip_view, this);
        setOrientation(1);
        this.aAJ = (LinearLayout) findViewById(e.g.pb_long_tip_content);
        this.ayi = (ImageView) findViewById(e.g.pb_long_tip_image);
        this.ddU = (TextView) findViewById(e.g.long_hint_title);
        this.fQX = (TextView) findViewById(e.g.long_hint_text);
        al.c(this.ddU, e.d.cp_cont_b, 1);
        al.c(this.fQX, e.d.common_color_10037, 1);
        al.c(this.ayi, e.f.pic_pb_popup_longpress);
    }
}
