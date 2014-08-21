package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class BaobaoTailView extends LinearLayout {
    private TbImageView a;
    private TextView b;
    private com.baidu.tieba.data.b c;
    private View.OnClickListener d;

    public BaobaoTailView(Context context) {
        super(context);
        this.d = new a(this);
        a();
    }

    public BaobaoTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new a(this);
        a();
    }

    private void a() {
        setOrientation(0);
        com.baidu.adp.lib.e.b.a().a(getContext(), com.baidu.tieba.v.baobao_tail_layout, this);
        this.a = (TbImageView) findViewById(com.baidu.tieba.u.baobao_icon);
        this.b = (TextView) findViewById(com.baidu.tieba.u.baobao_tail_text);
        setOnClickListener(this.d);
    }

    public void setData(com.baidu.tieba.data.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.c().length() == 0) {
            setVisibility(8);
            return;
        }
        this.c = bVar;
        this.b.setText(bVar.c());
        this.a.a(bVar.a(), 10, false);
    }

    public void a(int i) {
        if (i == 1) {
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_link_tip_c_1));
        } else {
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_link_tip_c));
        }
    }
}
