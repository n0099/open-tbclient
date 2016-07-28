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
    private TextView aMx;
    private View.OnClickListener acD;
    private TbImageView bym;
    private com.baidu.tbadk.data.b ekY;

    public BaobaoTailView(Context context) {
        super(context);
        this.acD = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acD = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(u.h.baobao_tail_layout, this);
        this.bym = (TbImageView) findViewById(u.g.baobao_icon);
        this.aMx = (TextView) findViewById(u.g.baobao_tail_text);
        setOnClickListener(this.acD);
    }

    public void setData(com.baidu.tbadk.data.b bVar) {
        if (bVar == null || bVar.getContent() == null || bVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.ekY = bVar;
        this.aMx.setText(bVar.getContent());
        this.bym.c(bVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        av.c(this.aMx, u.d.cp_link_tip_c, 1);
    }
}
