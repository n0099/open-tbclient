package com.baidu.tieba.tblauncher.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<a, com.baidu.tbadk.mvc.d.b> {
    private View Xl;
    private ImageView aLa;
    private ImageView aLe;
    private TextView aNv;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNv = (TextView) view.findViewById(i.f.textview);
        this.aLa = (ImageView) view.findViewById(i.f.red_tip);
        this.aLe = (ImageView) view.findViewById(i.f.red_new_tip);
        this.Xl = view.findViewById(i.f.divider);
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
            if (this.aNv != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.ayR());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aNv.setText(str);
                this.aNv.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(aVar.ayS()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.ayT()) {
                case 1:
                    this.aLa.setImageDrawable(null);
                    this.aLa.setVisibility(8);
                    an.c(this.aLe, i.e.icon_news_head_new);
                    this.aLe.setVisibility(0);
                    break;
                case 2:
                    an.c(this.aLa, i.e.icon_news_down_bar_one);
                    this.aLa.setVisibility(0);
                    this.aLe.setImageDrawable(null);
                    this.aLe.setVisibility(8);
                    break;
                default:
                    this.aLa.setImageDrawable(null);
                    this.aLa.setVisibility(8);
                    this.aLe.setImageDrawable(null);
                    this.aLe.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 5) {
                this.Xl.setVisibility(0);
            } else {
                this.Xl.setVisibility(8);
            }
        }
    }
}
