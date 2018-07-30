package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes2.dex */
public class GodReplyLeaderboardTipView extends LinearLayout {
    private TextView aIt;
    private TriangleShapeView fuR;

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
        this.fuR = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.fuR.setColorId(d.C0140d.cp_link_tip_a);
        this.fuR.setAlpha(0.95f);
        this.aIt = (TextView) findViewById(d.g.usertip_text);
        this.aIt.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.aIt.getBackground().setColorFilter(am.getColor(d.C0140d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        am.h(this.aIt, d.C0140d.cp_cont_g);
    }
}
