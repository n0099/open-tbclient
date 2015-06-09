package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private View.OnClickListener ZA;
    private TbImageView aHh;
    private TextView awp;
    private com.baidu.tbadk.data.a bQJ;

    public BaobaoTailView(Context context) {
        super(context);
        this.ZA = new a(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZA = new a(this);
        init();
    }

    private void init() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), r.baobao_tail_layout, this);
        this.aHh = (TbImageView) findViewById(q.baobao_icon);
        this.awp = (TextView) findViewById(q.baobao_tail_text);
        setOnClickListener(this.ZA);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.bQJ = aVar;
        this.awp.setText(aVar.getContent());
        this.aHh.c(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        ay.b(this.awp, n.cp_link_tip_c, 1);
    }
}
