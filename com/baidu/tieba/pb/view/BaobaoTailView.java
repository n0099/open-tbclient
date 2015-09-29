package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aEt;
    private TbImageView aNQ;
    private View.OnClickListener adX;
    private com.baidu.tbadk.data.a cnC;

    public BaobaoTailView(Context context) {
        super(context);
        this.adX = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adX = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(i.g.baobao_tail_layout, this);
        this.aNQ = (TbImageView) findViewById(i.f.baobao_icon);
        this.aEt = (TextView) findViewById(i.f.baobao_tail_text);
        setOnClickListener(this.adX);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.cnC = aVar;
        this.aEt.setText(aVar.getContent());
        this.aNQ.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        am.b(this.aEt, i.c.cp_link_tip_c, 1);
    }
}
