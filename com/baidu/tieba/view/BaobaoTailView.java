package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private View.OnClickListener Ie;
    private TextView aey;
    private TbImageView anF;
    private com.baidu.tieba.data.b bQi;

    public BaobaoTailView(Context context) {
        super(context);
        this.Ie = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ie = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.ek().inflate(getContext(), com.baidu.tieba.w.baobao_tail_layout, this);
        this.anF = (TbImageView) findViewById(com.baidu.tieba.v.baobao_icon);
        this.aey = (TextView) findViewById(com.baidu.tieba.v.baobao_tail_text);
        setOnClickListener(this.Ie);
    }

    public void setData(com.baidu.tieba.data.b bVar) {
        if (bVar == null || bVar.getContent() == null || bVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.bQi = bVar;
        this.aey.setText(bVar.getContent());
        this.anF.c(bVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        aw.b(this.aey, com.baidu.tieba.s.cp_link_tip_c, 1);
    }
}
