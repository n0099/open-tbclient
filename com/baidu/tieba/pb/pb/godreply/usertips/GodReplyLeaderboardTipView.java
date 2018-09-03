package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes2.dex */
public class GodReplyLeaderboardTipView extends LinearLayout {
    private TextView aIr;
    private TriangleShapeView fuK;

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
        LayoutInflater.from(context).inflate(f.h.usertips_view, this);
        this.fuK = (TriangleShapeView) findViewById(f.g.usertip_triangle);
        this.fuK.setColorId(f.d.cp_link_tip_a);
        this.fuK.setAlpha(0.95f);
        this.aIr = (TextView) findViewById(f.g.usertip_text);
        this.aIr.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.aIr.getBackground().setColorFilter(am.getColor(f.d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        am.h(this.aIr, f.d.cp_cont_g);
    }
}
