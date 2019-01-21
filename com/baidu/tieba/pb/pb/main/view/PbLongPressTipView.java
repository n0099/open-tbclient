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
    private ImageView aHL;
    private LinearLayout aKl;
    private Context context;
    private TextView dxe;
    private TextView gkL;

    public PbLongPressTipView(Context context) {
        super(context);
        this.context = context;
        cr(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        cr(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        cr(context);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.pb_long_press_tip_view, this);
        setOrientation(1);
        this.aKl = (LinearLayout) findViewById(e.g.pb_long_tip_content);
        this.aHL = (ImageView) findViewById(e.g.pb_long_tip_image);
        this.dxe = (TextView) findViewById(e.g.long_hint_title);
        this.gkL = (TextView) findViewById(e.g.long_hint_text);
        al.c(this.dxe, e.d.cp_cont_b, 1);
        al.c(this.gkL, e.d.common_color_10037, 1);
        al.c(this.aHL, e.f.pic_pb_popup_longpress);
    }
}
