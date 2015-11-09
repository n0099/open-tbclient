package com.baidu.tieba.tbadkCore.f;

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
    private View Xo;
    private ImageView aJU;
    private ImageView aJY;
    private TextView aND;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aND = (TextView) view.findViewById(i.f.textview);
        this.aJU = (ImageView) view.findViewById(i.f.red_tip);
        this.aJY = (ImageView) view.findViewById(i.f.red_new_tip);
        this.Xo = view.findViewById(i.f.divider);
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
            if (this.aND != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.axU());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aND.setText(str);
                this.aND.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(aVar.axV()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.axW()) {
                case 1:
                    this.aJU.setImageDrawable(null);
                    this.aJU.setVisibility(8);
                    an.c(this.aJY, i.e.icon_news_head_new);
                    this.aJY.setVisibility(0);
                    break;
                case 2:
                    an.c(this.aJU, i.e.icon_news_down_bar_one);
                    this.aJU.setVisibility(0);
                    this.aJY.setImageDrawable(null);
                    this.aJY.setVisibility(8);
                    break;
                default:
                    this.aJU.setImageDrawable(null);
                    this.aJU.setVisibility(8);
                    this.aJY.setImageDrawable(null);
                    this.aJY.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 5) {
                this.Xo.setVisibility(0);
            } else {
                this.Xo.setVisibility(8);
            }
        }
    }
}
