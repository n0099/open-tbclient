package com.baidu.tieba.tblauncher.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<a, com.baidu.tbadk.mvc.e.c> {
    private View abr;
    private ImageView awq;
    private ImageView awv;
    private TextView cdB;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cdB = (TextView) view.findViewById(w.textview);
        this.awq = (ImageView) view.findViewById(w.red_tip);
        this.awv = (ImageView) view.findViewById(w.red_new_tip);
        this.abr = view.findViewById(w.divider);
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(a aVar) {
        super.y(aVar);
        if (aVar != null) {
            if (this.cdB != null) {
                this.cdB.setText(aVar.ajE());
                this.cdB.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(aVar.ajD()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.ajF()) {
                case 1:
                    this.awq.setImageDrawable(null);
                    this.awq.setVisibility(8);
                    bc.c(this.awv, v.icon_news_head_new);
                    this.awv.setVisibility(0);
                    break;
                case 2:
                    bc.c(this.awq, v.icon_news_down_bar_one);
                    this.awq.setVisibility(0);
                    this.awv.setImageDrawable(null);
                    this.awv.setVisibility(8);
                    break;
                default:
                    this.awq.setImageDrawable(null);
                    this.awq.setVisibility(8);
                    this.awv.setImageDrawable(null);
                    this.awv.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 3) {
                this.abr.setVisibility(0);
            } else {
                this.abr.setVisibility(8);
            }
        }
    }
}
