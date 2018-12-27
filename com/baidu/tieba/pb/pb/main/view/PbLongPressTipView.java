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
    private ImageView aHi;
    private LinearLayout aJI;
    private Context context;
    private TextView dwu;
    private TextView gjH;

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
        this.aJI = (LinearLayout) findViewById(e.g.pb_long_tip_content);
        this.aHi = (ImageView) findViewById(e.g.pb_long_tip_image);
        this.dwu = (TextView) findViewById(e.g.long_hint_title);
        this.gjH = (TextView) findViewById(e.g.long_hint_text);
        al.c(this.dwu, e.d.cp_cont_b, 1);
        al.c(this.gjH, e.d.common_color_10037, 1);
        al.c(this.aHi, e.f.pic_pb_popup_longpress);
    }
}
