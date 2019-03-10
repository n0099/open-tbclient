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
    private TextView ahH;
    private TriangleShapeView hmv;

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
        this.hmv = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.hmv.setColorId(d.C0236d.cp_link_tip_a);
        this.hmv.setAlpha(0.95f);
        this.ahH = (TextView) findViewById(d.g.usertip_text);
        this.ahH.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.ahH.getBackground().setColorFilter(al.getColor(d.C0236d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        al.j(this.ahH, d.C0236d.cp_cont_g);
    }
}
