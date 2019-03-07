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
    private LinearLayout bFu;
    private ImageView bPS;
    private Context context;
    private TextView eBo;
    private TextView eKx;

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
        this.bFu = (LinearLayout) findViewById(d.g.pb_long_tip_content);
        this.bPS = (ImageView) findViewById(d.g.pb_long_tip_image);
        this.eKx = (TextView) findViewById(d.g.long_hint_title);
        this.eBo = (TextView) findViewById(d.g.long_hint_text);
        al.d(this.eKx, d.C0236d.cp_cont_b, 1);
        al.d(this.eBo, d.C0236d.common_color_10037, 1);
        al.c(this.bPS, d.f.pic_pb_popup_longpress);
    }
}
