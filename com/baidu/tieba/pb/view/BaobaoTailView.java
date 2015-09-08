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
    private TextView aFo;
    private TbImageView aOU;
    private View.OnClickListener aeL;
    private com.baidu.tbadk.data.a cig;

    public BaobaoTailView(Context context) {
        super(context);
        this.aeL = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeL = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(i.g.baobao_tail_layout, this);
        this.aOU = (TbImageView) findViewById(i.f.baobao_icon);
        this.aFo = (TextView) findViewById(i.f.baobao_tail_text);
        setOnClickListener(this.aeL);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.cig = aVar;
        this.aFo.setText(aVar.getContent());
        this.aOU.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        al.b(this.aFo, i.c.cp_link_tip_c, 1);
    }
}
