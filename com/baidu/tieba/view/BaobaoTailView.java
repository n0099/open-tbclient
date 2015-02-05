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
    private View.OnClickListener Nr;
    private TextView amO;
    private TbImageView awF;
    private com.baidu.tbadk.data.a ceF;

    public BaobaoTailView(Context context) {
        super(context);
        this.Nr = new f(this);
        init();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nr = new f(this);
        init();
    }

    private void init() {
        setOrientation(0);
        com.baidu.adp.lib.g.b.ei().inflate(getContext(), x.baobao_tail_layout, this);
        this.awF = (TbImageView) findViewById(w.baobao_icon);
        this.amO = (TextView) findViewById(w.baobao_tail_text);
        setOnClickListener(this.Nr);
    }

    public void setData(com.baidu.tbadk.data.a aVar) {
        if (aVar == null || aVar.getContent() == null || aVar.getContent().length() == 0) {
            setVisibility(8);
            return;
        }
        this.ceF = aVar;
        this.amO.setText(aVar.getContent());
        this.awF.d(aVar.getIconUrl(), 10, false);
    }

    public void changeSkinType(int i) {
        bc.b(this.amO, t.cp_link_tip_c, 1);
    }
}
