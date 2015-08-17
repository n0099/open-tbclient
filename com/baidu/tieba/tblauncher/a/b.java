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
    private View Xi;
    private ImageView aLK;
    private ImageView aLP;
    private TextView aOb;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOb = (TextView) view.findViewById(i.f.textview);
        this.aLK = (ImageView) view.findViewById(i.f.red_tip);
        this.aLP = (ImageView) view.findViewById(i.f.red_new_tip);
        this.Xi = view.findViewById(i.f.divider);
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(com.baidu.tieba.tbadkCore.f.a aVar) {
        super.A(aVar);
        if (aVar != null) {
            if (this.aOb != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.aqv());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aOb.setText(str);
                this.aOb.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(aVar.aqw()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.aqx()) {
                case 1:
                    this.aLK.setImageDrawable(null);
                    this.aLK.setVisibility(8);
                    al.c(this.aLP, i.e.icon_news_head_new);
                    this.aLP.setVisibility(0);
                    break;
                case 2:
                    al.c(this.aLK, i.e.icon_news_down_bar_one);
                    this.aLK.setVisibility(0);
                    this.aLP.setImageDrawable(null);
                    this.aLP.setVisibility(8);
                    break;
                default:
                    this.aLK.setImageDrawable(null);
                    this.aLK.setVisibility(8);
                    this.aLP.setImageDrawable(null);
                    this.aLP.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 4) {
                this.Xi.setVisibility(0);
            } else {
                this.Xi.setVisibility(8);
            }
        }
    }
}
