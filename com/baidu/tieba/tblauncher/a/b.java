package com.baidu.tieba.tblauncher.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.d.b> {
    private View Xr;
    private ImageView aLX;
    private ImageView aMc;
    private TextView aOo;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOo = (TextView) view.findViewById(i.f.textview);
        this.aLX = (ImageView) view.findViewById(i.f.red_tip);
        this.aMc = (ImageView) view.findViewById(i.f.red_new_tip);
        this.Xr = view.findViewById(i.f.divider);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.tbadkCore.f.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            if (this.aOo != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.auJ());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aOo.setText(str);
                this.aOo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(aVar.auK()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.auL()) {
                case 1:
                    this.aLX.setImageDrawable(null);
                    this.aLX.setVisibility(8);
                    al.c(this.aMc, i.e.icon_news_head_new);
                    this.aMc.setVisibility(0);
                    break;
                case 2:
                    al.c(this.aLX, i.e.icon_news_down_bar_one);
                    this.aLX.setVisibility(0);
                    this.aMc.setImageDrawable(null);
                    this.aMc.setVisibility(8);
                    break;
                default:
                    this.aLX.setImageDrawable(null);
                    this.aLX.setVisibility(8);
                    this.aMc.setImageDrawable(null);
                    this.aMc.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 4) {
                this.Xr.setVisibility(0);
            } else {
                this.Xr.setVisibility(8);
            }
        }
    }
}
