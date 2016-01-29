package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aJa;
    private TbImageView aZC;
    private View.OnClickListener agz;
    private com.baidu.tbadk.data.a cVh;

    public BaobaoTailView(Context context) {
        super(context);
        this.agz = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agz = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(t.h.baobao_tail_layout, this);
        this.aZC = (TbImageView) findViewById(t.g.baobao_icon);
        this.aJa = (TextView) findViewById(t.g.baobao_tail_text);
        setOnClickListener(this.agz);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.cVh = aVar;
        this.aJa.setText(aVar.getContent());
        this.aZC.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        ar.b(this.aJa, t.d.cp_link_tip_c, 1);
    }
}
