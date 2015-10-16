package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aEE;
    private TbImageView aOb;
    private View.OnClickListener adY;
    private com.baidu.tbadk.data.a cnN;

    public BaobaoTailView(Context context) {
        super(context);
        this.adY = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adY = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(i.g.baobao_tail_layout, this);
        this.aOb = (TbImageView) findViewById(i.f.baobao_icon);
        this.aEE = (TextView) findViewById(i.f.baobao_tail_text);
        setOnClickListener(this.adY);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.cnN = aVar;
        this.aEE.setText(aVar.getContent());
        this.aOb.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        an.b(this.aEE, i.c.cp_link_tip_c, 1);
    }
}
