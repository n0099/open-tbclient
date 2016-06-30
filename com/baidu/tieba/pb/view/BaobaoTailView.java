package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TextView aLD;
    private View.OnClickListener abT;
    private TbImageView bvY;
    private com.baidu.tbadk.data.b dYw;

    public BaobaoTailView(Context context) {
        super(context);
        this.abT = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abT = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(u.h.baobao_tail_layout, this);
        this.bvY = (TbImageView) findViewById(u.g.baobao_icon);
        this.aLD = (TextView) findViewById(u.g.baobao_tail_text);
        setOnClickListener(this.abT);
    }

    public void setData(com.baidu.tbadk.data.b bVar) {
        if (bVar == null || bVar.getContent() == null || bVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.dYw = bVar;
        this.aLD.setText(bVar.getContent());
        this.bvY.c(bVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        av.c(this.aLD, u.d.cp_link_tip_c, 1);
    }
}
