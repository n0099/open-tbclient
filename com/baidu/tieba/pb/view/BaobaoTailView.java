package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private View.OnClickListener YC;
    private TbImageView aEZ;
    private TextView auM;
    private com.baidu.tbadk.data.a bOJ;

    public BaobaoTailView(Context context) {
        super(context);
        this.YC = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YC = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.hH().inflate(getContext(), w.baobao_tail_layout, this);
        this.aEZ = (TbImageView) findViewById(v.baobao_icon);
        this.auM = (TextView) findViewById(v.baobao_tail_text);
        setOnClickListener(this.YC);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.bOJ = aVar;
        this.auM.setText(aVar.getContent());
        this.aEZ.c(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        ba.b(this.auM, s.cp_link_tip_c, 1);
    }
}
