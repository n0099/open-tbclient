package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private View.OnClickListener MY;
    private TextView alX;
    private TbImageView avI;
    private com.baidu.tbadk.data.a cdh;

    public BaobaoTailView(Context context) {
        super(context);
        this.MY = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MY = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.ek().inflate(getContext(), x.baobao_tail_layout, this);
        this.avI = (TbImageView) findViewById(w.baobao_icon);
        this.alX = (TextView) findViewById(w.baobao_tail_text);
        setOnClickListener(this.MY);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.cdh = aVar;
        this.alX.setText(aVar.getContent());
        this.avI.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        ax.b(this.alX, t.cp_link_tip_c, 1);
    }
}
