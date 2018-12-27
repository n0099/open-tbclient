package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes6.dex */
public class GodReplyLeaderboardTipView extends LinearLayout {
    private TextView aiY;
    private TriangleShapeView fVl;

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
        LayoutInflater.from(context).inflate(e.h.usertips_view, this);
        this.fVl = (TriangleShapeView) findViewById(e.g.usertip_triangle);
        this.fVl.setColorId(e.d.cp_link_tip_a);
        this.fVl.setAlpha(0.95f);
        this.aiY = (TextView) findViewById(e.g.usertip_text);
        this.aiY.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.aiY.getBackground().setColorFilter(al.getColor(e.d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        al.h(this.aiY, e.d.cp_cont_g);
    }
}
