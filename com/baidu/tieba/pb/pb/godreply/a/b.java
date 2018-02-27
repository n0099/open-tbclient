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
    private TextView boy;
    private TriangleShapeView fKr;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.usertips_view, this);
        this.fKr = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.fKr.setColorId(d.C0141d.cp_link_tip_a);
        this.fKr.setAlpha(0.95f);
        this.boy = (TextView) findViewById(d.g.usertip_text);
        this.boy.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.boy.getBackground().setColorFilter(aj.getColor(d.C0141d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        aj.r(this.boy, d.C0141d.cp_cont_g);
    }
}
