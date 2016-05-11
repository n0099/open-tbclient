package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aIg;
    private View.OnClickListener abz;
    private TbImageView bab;
    private com.baidu.tbadk.data.b drL;

    public BaobaoTailView(Context context) {
        super(context);
        this.abz = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abz = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(t.h.baobao_tail_layout, this);
        this.bab = (TbImageView) findViewById(t.g.baobao_icon);
        this.aIg = (TextView) findViewById(t.g.baobao_tail_text);
        setOnClickListener(this.abz);
    }

    public void setData(com.baidu.tbadk.data.b bVar) {
        if (bVar == null || bVar.getContent() == null || bVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.drL = bVar;
        this.aIg.setText(bVar.getContent());
        this.bab.c(bVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        at.c(this.aIg, t.d.cp_link_tip_c, 1);
    }
}
