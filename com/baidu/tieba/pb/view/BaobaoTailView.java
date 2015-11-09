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
    private TextView aDy;
    private TbImageView aOj;
    private View.OnClickListener aed;
    private com.baidu.tbadk.data.a cpe;

    public BaobaoTailView(Context context) {
        super(context);
        this.aed = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aed = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(i.g.baobao_tail_layout, this);
        this.aOj = (TbImageView) findViewById(i.f.baobao_icon);
        this.aDy = (TextView) findViewById(i.f.baobao_tail_text);
        setOnClickListener(this.aed);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.cpe = aVar;
        this.aDy.setText(aVar.getContent());
        this.aOj.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        an.b(this.aDy, i.c.cp_link_tip_c, 1);
    }
}
