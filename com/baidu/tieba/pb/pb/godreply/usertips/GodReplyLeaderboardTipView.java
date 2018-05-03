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
    private TextView aza;
    private TriangleShapeView fej;

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
        this.fej = (TriangleShapeView) findViewById(d.g.usertip_triangle);
        this.fej.setColorId(d.C0126d.cp_link_tip_a);
        this.fej.setAlpha(0.95f);
        this.aza = (TextView) findViewById(d.g.usertip_text);
        this.aza.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.aza.getBackground().setColorFilter(ak.getColor(d.C0126d.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        ak.h(this.aza, d.C0126d.cp_cont_g);
    }
}
