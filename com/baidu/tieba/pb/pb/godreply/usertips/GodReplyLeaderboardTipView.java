package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes2.dex */
public class GodReplyLeaderboardTipView extends LinearLayout {
    private TextView azb;
    private TriangleShapeView ffq;

    public GodReplyLeaderboardTipView(Context context) {
        super(context);
        init(context);
    }

    public GodReplyLeaderboardTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public GodReplyLeaderboardTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.i.usertips_view, this);
        this.ffq = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.ffq.setColorId(d.C0126d.cp_link_tip_a);
        this.ffq.setAlpha(0.95f);
        this.azb = (TextView) findViewById(d.g.usertip_text);
        this.azb.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.azb.getBackground().setColorFilter(ak.getColor(d.C0126d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        ak.h(this.azb, d.C0126d.cp_cont_g);
    }
}
