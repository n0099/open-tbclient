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
    private TextView boB;
    private TriangleShapeView fKH;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.usertips_view, this);
        this.fKH = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.fKH.setColorId(d.C0141d.cp_link_tip_a);
        this.fKH.setAlpha(0.95f);
        this.boB = (TextView) findViewById(d.g.usertip_text);
        this.boB.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.boB.getBackground().setColorFilter(aj.getColor(d.C0141d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        aj.r(this.boB, d.C0141d.cp_cont_g);
    }
}
