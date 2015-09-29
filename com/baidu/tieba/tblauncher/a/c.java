package com.baidu.tieba.tblauncher.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<a, com.baidu.tbadk.mvc.d.b> {
    private View Xj;
    private ImageView aKP;
    private ImageView aKT;
    private TextView aNk;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNk = (TextView) view.findViewById(i.f.textview);
        this.aKP = (ImageView) view.findViewById(i.f.red_tip);
        this.aKT = (ImageView) view.findViewById(i.f.red_new_tip);
        this.Xj = view.findViewById(i.f.divider);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(a aVar) {
        super.B(aVar);
        if (aVar != null) {
            if (this.aNk != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.ayH());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aNk.setText(str);
                this.aNk.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(aVar.ayI()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.ayJ()) {
                case 1:
                    this.aKP.setImageDrawable(null);
                    this.aKP.setVisibility(8);
                    am.c(this.aKT, i.e.icon_news_head_new);
                    this.aKT.setVisibility(0);
                    break;
                case 2:
                    am.c(this.aKP, i.e.icon_news_down_bar_one);
                    this.aKP.setVisibility(0);
                    this.aKT.setImageDrawable(null);
                    this.aKT.setVisibility(8);
                    break;
                default:
                    this.aKP.setImageDrawable(null);
                    this.aKP.setVisibility(8);
                    this.aKT.setImageDrawable(null);
                    this.aKT.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 5) {
                this.Xj.setVisibility(0);
            } else {
                this.Xj.setVisibility(8);
            }
        }
    }
}
