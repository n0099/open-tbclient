package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aSW;
    private View.OnClickListener afS;
    private TbImageView bJP;
    private com.baidu.tbadk.data.b ezo;

    public BaobaoTailView(Context context) {
        super(context);
        this.afS = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afS = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(r.h.baobao_tail_layout, this);
        this.bJP = (TbImageView) findViewById(r.g.baobao_icon);
        this.aSW = (TextView) findViewById(r.g.baobao_tail_text);
        setOnClickListener(this.afS);
    }

    public void setData(com.baidu.tbadk.data.b bVar) {
        if (bVar == null || bVar.getContent() == null || bVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.ezo = bVar;
        this.aSW.setText(bVar.getContent());
        this.bJP.c(bVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        av.c(this.aSW, r.d.cp_link_tip_c, 1);
    }
}
