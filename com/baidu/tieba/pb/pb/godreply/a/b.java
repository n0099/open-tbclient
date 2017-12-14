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
    private TextView axY;
    private TriangleShapeView eSE;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.usertips_view, this);
        this.eSE = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.eSE.setColorId(d.C0096d.cp_link_tip_a);
        this.eSE.setAlpha(0.95f);
        this.axY = (TextView) findViewById(d.g.usertip_text);
        this.axY.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.axY.getBackground().setColorFilter(aj.getColor(d.C0096d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        aj.i(this.axY, d.C0096d.cp_cont_g);
    }
}
