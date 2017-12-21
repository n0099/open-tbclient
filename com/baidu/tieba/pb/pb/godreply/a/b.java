package com.baidu.tieba.pb.pb.godreply.a;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView ayb;
    private TriangleShapeView eSJ;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.usertips_view, this);
        this.eSJ = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.eSJ.setColorId(d.C0095d.cp_link_tip_a);
        this.eSJ.setAlpha(0.95f);
        this.ayb = (TextView) findViewById(d.g.usertip_text);
        this.ayb.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.ayb.getBackground().setColorFilter(aj.getColor(d.C0095d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        aj.i(this.ayb, d.C0095d.cp_cont_g);
    }
}
