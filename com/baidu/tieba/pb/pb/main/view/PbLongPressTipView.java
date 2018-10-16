package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class PbLongPressTipView extends LinearLayout {
    private ImageView aCR;
    private LinearLayout aFq;
    private Context context;
    private TextView dma;
    private TextView fYx;

    public PbLongPressTipView(Context context) {
        super(context);
        this.context = context;
        cs(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        cs(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        cs(context);
    }

    private void cs(Context context) {
        LayoutInflater.from(context).inflate(e.h.pb_long_press_tip_view, this);
        setOrientation(1);
        this.aFq = (LinearLayout) findViewById(e.g.pb_long_tip_content);
        this.aCR = (ImageView) findViewById(e.g.pb_long_tip_image);
        this.dma = (TextView) findViewById(e.g.long_hint_title);
        this.fYx = (TextView) findViewById(e.g.long_hint_text);
        al.c(this.dma, e.d.cp_cont_b, 1);
        al.c(this.fYx, e.d.common_color_10037, 1);
        al.c(this.aCR, e.f.pic_pb_popup_longpress);
    }
}
