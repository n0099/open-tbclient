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
    private TextView aGw;
    private TbImageView aTm;
    private View.OnClickListener afa;
    private com.baidu.tbadk.data.a cIq;

    public BaobaoTailView(Context context) {
        super(context);
        this.afa = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afa = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(n.g.baobao_tail_layout, this);
        this.aTm = (TbImageView) findViewById(n.f.baobao_icon);
        this.aGw = (TextView) findViewById(n.f.baobao_tail_text);
        setOnClickListener(this.afa);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.cIq = aVar;
        this.aGw.setText(aVar.getContent());
        this.aTm.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        as.b(this.aGw, n.c.cp_link_tip_c, 1);
    }
}
