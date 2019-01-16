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
    private ImageView aHK;
    private LinearLayout aKk;
    private Context context;
    private TextView dxd;
    private TextView gkK;

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
        this.aKk = (LinearLayout) findViewById(e.g.pb_long_tip_content);
        this.aHK = (ImageView) findViewById(e.g.pb_long_tip_image);
        this.dxd = (TextView) findViewById(e.g.long_hint_title);
        this.gkK = (TextView) findViewById(e.g.long_hint_text);
        al.c(this.dxd, e.d.cp_cont_b, 1);
        al.c(this.gkK, e.d.common_color_10037, 1);
        al.c(this.aHK, e.f.pic_pb_popup_longpress);
    }
}
