package com.baidu.tieba.pb.pb.godreply.a;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes2.dex */
public class b extends LinearLayout {
    private TextView bmx;
    private TriangleShapeView fHf;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.usertips_view, this);
        this.fHf = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.fHf.setColorId(d.C0108d.cp_link_tip_a);
        this.fHf.setAlpha(0.95f);
        this.bmx = (TextView) findViewById(d.g.usertip_text);
        this.bmx.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.bmx.getBackground().setColorFilter(aj.getColor(d.C0108d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        aj.r(this.bmx, d.C0108d.cp_cont_g);
    }
}
