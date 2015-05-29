package com.baidu.tieba.tblauncher.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.e.c> {
    private View So;
    private ImageView aEk;
    private ImageView aEp;
    private TextView aGA;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aGA = (TextView) view.findViewById(q.textview);
        this.aEk = (ImageView) view.findViewById(q.red_tip);
        this.aEp = (ImageView) view.findViewById(q.red_new_tip);
        this.So = view.findViewById(q.divider);
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(com.baidu.tieba.tbadkCore.f.a aVar) {
        super.z(aVar);
        if (aVar != null) {
            if (this.aGA != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.apa());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aGA.setText(str);
                this.aGA.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(aVar.apb()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.apc()) {
                case 1:
                    this.aEk.setImageDrawable(null);
                    this.aEk.setVisibility(8);
                    ay.c(this.aEp, com.baidu.tieba.p.icon_news_head_new);
                    this.aEp.setVisibility(0);
                    break;
                case 2:
                    ay.c(this.aEk, com.baidu.tieba.p.icon_news_down_bar_one);
                    this.aEk.setVisibility(0);
                    this.aEp.setImageDrawable(null);
                    this.aEp.setVisibility(8);
                    break;
                default:
                    this.aEk.setImageDrawable(null);
                    this.aEk.setVisibility(8);
                    this.aEp.setImageDrawable(null);
                    this.aEp.setVisibility(8);
                    break;
            }
            if (aVar.getType() == 4) {
                this.So.setVisibility(0);
            } else {
                this.So.setVisibility(8);
            }
        }
    }
}
