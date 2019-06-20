package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
/* loaded from: classes4.dex */
public class GodReplyLeaderboardTipView extends LinearLayout {
    private TextView aif;
    private TriangleShapeView hDI;

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
        this.hDI = (TriangleShapeView) findViewById(R.id.usertip_triangle);
        this.hDI.setColorId(R.color.cp_link_tip_a);
        this.hDI.setAlpha(0.95f);
        this.aif = (TextView) findViewById(R.id.usertip_text);
        this.aif.setAlpha(0.95f);
    }

    public void onChangeSkinType(int i) {
        this.aif.getBackground().setColorFilter(al.getColor(R.color.cp_link_tip_a), PorterDuff.Mode.MULTIPLY);
        al.j(this.aif, R.color.cp_cont_g);
    }
}
