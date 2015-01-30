package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private View.OnClickListener Nu;
    private TextView amR;
    private TbImageView awI;
    private com.baidu.tbadk.data.a ceG;

    public BaobaoTailView(Context context) {
        super(context);
        this.Nu = new f(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nu = new f(this);
        init();
    }

    private void init() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.ei().inflate(getContext(), x.baobao_tail_layout, this);
        this.awI = (TbImageView) findViewById(w.baobao_icon);
        this.amR = (TextView) findViewById(w.baobao_tail_text);
        setOnClickListener(this.Nu);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.ceG = aVar;
        this.amR.setText(aVar.getContent());
        this.awI.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        bc.b(this.amR, t.cp_link_tip_c, 1);
    }
}
