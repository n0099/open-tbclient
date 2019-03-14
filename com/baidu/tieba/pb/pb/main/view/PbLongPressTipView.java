package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class PbLongPressTipView extends LinearLayout {
    private LinearLayout bFw;
    private ImageView bPT;
    private Context context;
    private TextView eBk;
    private TextView eKt;

    public PbLongPressTipView(Context context) {
        super(context);
        this.context = context;
        aX(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aX(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        aX(context);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.pb_long_press_tip_view, this);
        setOrientation(1);
        this.bFw = (LinearLayout) findViewById(d.g.pb_long_tip_content);
        this.bPT = (ImageView) findViewById(d.g.pb_long_tip_image);
        this.eKt = (TextView) findViewById(d.g.long_hint_title);
        this.eBk = (TextView) findViewById(d.g.long_hint_text);
        al.d(this.eKt, d.C0277d.cp_cont_b, 1);
        al.d(this.eBk, d.C0277d.common_color_10037, 1);
        al.c(this.bPT, d.f.pic_pb_popup_longpress);
    }
}
