package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aRR;
    private View.OnClickListener aft;
    private TbImageView bJO;
    private com.baidu.tbadk.data.b exg;

    public BaobaoTailView(Context context) {
        super(context);
        this.aft = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aft = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(t.h.baobao_tail_layout, this);
        this.bJO = (TbImageView) findViewById(t.g.baobao_icon);
        this.aRR = (TextView) findViewById(t.g.baobao_tail_text);
        setOnClickListener(this.aft);
    }

    public void setData(com.baidu.tbadk.data.b bVar) {
        if (bVar == null || bVar.getContent() == null || bVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.exg = bVar;
        this.aRR.setText(bVar.getContent());
        this.bJO.c(bVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        av.c(this.aRR, t.d.cp_link_tip_c, 1);
    }
}
