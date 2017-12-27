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
    private TextView bmg;
    private TriangleShapeView fFk;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.usertips_view, this);
        this.fFk = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.fFk.setColorId(d.C0108d.cp_link_tip_a);
        this.fFk.setAlpha(0.95f);
        this.bmg = (TextView) findViewById(d.g.usertip_text);
        this.bmg.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.bmg.getBackground().setColorFilter(aj.getColor(d.C0108d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        aj.r(this.bmg, d.C0108d.cp_cont_g);
    }
}
