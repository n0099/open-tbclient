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
    private ImageView aCa;
    private ImageView aCf;
    private TextView aEp;
    private View axK;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEp = (TextView) view.findViewById(v.textview);
        this.aCa = (ImageView) view.findViewById(v.red_tip);
        this.aCf = (ImageView) view.findViewById(v.red_new_tip);
        this.axK = view.findViewById(v.divider);
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
            if (this.aEp != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.amU());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aEp.setText(str);
                this.aEp.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(aVar.amV()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.amW()) {
                case 1:
                    this.aCa.setImageDrawable(null);
                    this.aCa.setVisibility(8);
                    ba.c(this.aCf, u.icon_news_head_new);
                    this.aCf.setVisibility(0);
                    break;
                case 2:
                    ba.c(this.aCa, u.icon_news_down_bar_one);
                    this.aCa.setVisibility(0);
                    this.aCf.setImageDrawable(null);
                    this.aCf.setVisibility(8);
                    break;
                default:
                    this.aCa.setImageDrawable(null);
                    this.aCa.setVisibility(8);
                    this.aCf.setImageDrawable(null);
                    this.aCf.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 4) {
                this.axK.setVisibility(0);
            } else {
                this.axK.setVisibility(8);
            }
        }
    }

    public TextView aot() {
        return this.aEp;
    }
}
