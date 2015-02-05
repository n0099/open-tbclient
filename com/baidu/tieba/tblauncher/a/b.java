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
    private View abo;
    private ImageView awn;
    private ImageView aws;
    private TextView cdA;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cdA = (TextView) view.findViewById(w.textview);
        this.awn = (ImageView) view.findViewById(w.red_tip);
        this.aws = (ImageView) view.findViewById(w.red_new_tip);
        this.abo = view.findViewById(w.divider);
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
            if (this.cdA != null) {
                this.cdA.setText(aVar.ajz());
                this.cdA.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(aVar.ajy()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.ajA()) {
                case 1:
                    this.awn.setImageDrawable(null);
                    this.awn.setVisibility(8);
                    bc.c(this.aws, v.icon_news_head_new);
                    this.aws.setVisibility(0);
                    break;
                case 2:
                    bc.c(this.awn, v.icon_news_down_bar_one);
                    this.awn.setVisibility(0);
                    this.aws.setImageDrawable(null);
                    this.aws.setVisibility(8);
                    break;
                default:
                    this.awn.setImageDrawable(null);
                    this.awn.setVisibility(8);
                    this.aws.setImageDrawable(null);
                    this.aws.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 3) {
                this.abo.setVisibility(0);
            } else {
                this.abo.setVisibility(8);
            }
        }
    }
}
