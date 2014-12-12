package com.baidu.tieba.tblauncher.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<a, com.baidu.tbadk.mvc.e.c> {
    private View aaQ;
    private ImageView avq;
    private ImageView avv;
    private TextView cci;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cci = (TextView) view.findViewById(w.textview);
        this.avq = (ImageView) view.findViewById(w.red_tip);
        this.avv = (ImageView) view.findViewById(w.red_new_tip);
        this.aaQ = view.findViewById(w.divider);
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
            if (this.cci != null) {
                this.cci.setText(aVar.aji());
                this.cci.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(aVar.ajh()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.ajj()) {
                case 1:
                    this.avq.setImageDrawable(null);
                    this.avq.setVisibility(8);
                    ax.c(this.avv, v.icon_news_head_new);
                    this.avv.setVisibility(0);
                    break;
                case 2:
                    ax.c(this.avq, v.icon_news_down_bar_one);
                    this.avq.setVisibility(0);
                    this.avv.setImageDrawable(null);
                    this.avv.setVisibility(8);
                    break;
                default:
                    this.avq.setImageDrawable(null);
                    this.avq.setVisibility(8);
                    this.avv.setImageDrawable(null);
                    this.avv.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 3) {
                this.aaQ.setVisibility(0);
            } else {
                this.aaQ.setVisibility(8);
            }
        }
    }
}
