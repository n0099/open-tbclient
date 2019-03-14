package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes4.dex */
public class GodReplyLeaderboardTipView extends LinearLayout {
    private TextView ahI;
    private TriangleShapeView hmq;

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
        LayoutInflater.from(context).inflate(d.h.usertips_view, this);
        this.hmq = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.hmq.setColorId(d.C0277d.cp_link_tip_a);
        this.hmq.setAlpha(0.95f);
        this.ahI = (TextView) findViewById(d.g.usertip_text);
        this.ahI.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.ahI.getBackground().setColorFilter(al.getColor(d.C0277d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        al.j(this.ahI, d.C0277d.cp_cont_g);
    }
}
