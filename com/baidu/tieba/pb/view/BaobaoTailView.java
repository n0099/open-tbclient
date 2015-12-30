package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aHX;
    private TbImageView aXo;
    private View.OnClickListener afM;
    private com.baidu.tbadk.data.a cMt;

    public BaobaoTailView(Context context) {
        super(context);
        this.afM = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afM = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(n.h.baobao_tail_layout, this);
        this.aXo = (TbImageView) findViewById(n.g.baobao_icon);
        this.aHX = (TextView) findViewById(n.g.baobao_tail_text);
        setOnClickListener(this.afM);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.cMt = aVar;
        this.aHX.setText(aVar.getContent());
        this.aXo.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        as.b(this.aHX, n.d.cp_link_tip_c, 1);
    }
}
