package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aDG;
    private TbImageView aOH;
    private View.OnClickListener aeB;
    private com.baidu.tbadk.data.a chi;

    public BaobaoTailView(Context context) {
        super(context);
        this.aeB = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeB = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(i.g.baobao_tail_layout, this);
        this.aOH = (TbImageView) findViewById(i.f.baobao_icon);
        this.aDG = (TextView) findViewById(i.f.baobao_tail_text);
        setOnClickListener(this.aeB);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.chi = aVar;
        this.aDG.setText(aVar.getContent());
        this.aOH.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        al.b(this.aDG, i.c.cp_link_tip_c, 1);
    }
}
