package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes4.dex */
public class GodReplyLeaderboardTipView extends LinearLayout {
    private TextView ajd;
    private TriangleShapeView hML;

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
        LayoutInflater.from(context).inflate(R.layout.usertips_view, this);
        this.hML = (TriangleShapeView) findViewById(R.id.usertip_triangle);
        this.hML.setColorId(R.color.cp_link_tip_a);
        this.hML.setAlpha(0.95f);
        this.ajd = (TextView) findViewById(R.id.usertip_text);
        this.ajd.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.ajd.getBackground().setColorFilter(am.getColor(R.color.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        am.j(this.ajd, R.color.cp_cont_g);
    }
}
