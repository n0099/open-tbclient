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
    private TextView aLW;
    private View.OnClickListener afZ;
    private TbImageView bem;
    private com.baidu.tbadk.data.a dqc;

    public BaobaoTailView(Context context) {
        super(context);
        this.afZ = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afZ = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(t.h.baobao_tail_layout, this);
        this.bem = (TbImageView) findViewById(t.g.baobao_icon);
        this.aLW = (TextView) findViewById(t.g.baobao_tail_text);
        setOnClickListener(this.afZ);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.dqc = aVar;
        this.aLW.setText(aVar.getContent());
        this.bem.c(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        at.b(this.aLW, t.d.cp_link_tip_c, 1);
    }
}
