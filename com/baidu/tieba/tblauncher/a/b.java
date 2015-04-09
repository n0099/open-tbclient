package com.baidu.tieba.tblauncher.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.e.c> {
    private ImageView aCi;
    private ImageView aCn;
    private TextView aEx;
    private View axS;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEx = (TextView) view.findViewById(v.textview);
        this.aCi = (ImageView) view.findViewById(v.red_tip);
        this.aCn = (ImageView) view.findViewById(v.red_new_tip);
        this.axS = view.findViewById(v.divider);
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(com.baidu.tieba.tbadkCore.f.a aVar) {
        super.A(aVar);
        if (aVar != null) {
            if (this.aEx != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.anj());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aEx.setText(str);
                this.aEx.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(aVar.ank()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.anl()) {
                case 1:
                    this.aCi.setImageDrawable(null);
                    this.aCi.setVisibility(8);
                    ba.c(this.aCn, u.icon_news_head_new);
                    this.aCn.setVisibility(0);
                    break;
                case 2:
                    ba.c(this.aCi, u.icon_news_down_bar_one);
                    this.aCi.setVisibility(0);
                    this.aCn.setImageDrawable(null);
                    this.aCn.setVisibility(8);
                    break;
                default:
                    this.aCi.setImageDrawable(null);
                    this.aCi.setVisibility(8);
                    this.aCn.setImageDrawable(null);
                    this.aCn.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 4) {
                this.axS.setVisibility(0);
            } else {
                this.axS.setVisibility(8);
            }
        }
    }

    public TextView aoI() {
        return this.aEx;
    }
}
