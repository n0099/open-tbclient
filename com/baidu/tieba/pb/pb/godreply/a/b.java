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
    private TextView axT;
    private TriangleShapeView eRB;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.usertips_view, this);
        this.eRB = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.eRB.setColorId(d.C0082d.cp_link_tip_a);
        this.eRB.setAlpha(0.95f);
        this.axT = (TextView) findViewById(d.g.usertip_text);
        this.axT.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.axT.getBackground().setColorFilter(aj.getColor(d.C0082d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        aj.i(this.axT, d.C0082d.cp_cont_g);
    }
}
