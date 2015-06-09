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
    private ImageView aEl;
    private ImageView aEq;
    private TextView aGB;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aGB = (TextView) view.findViewById(q.textview);
        this.aEl = (ImageView) view.findViewById(q.red_tip);
        this.aEq = (ImageView) view.findViewById(q.red_new_tip);
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
            if (this.aGB != null) {
                String str = "";
                try {
                    str = TbadkCoreApplication.m411getInst().getString(aVar.apb());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.aGB.setText(str);
                this.aGB.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(aVar.apc()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            switch (aVar.apd()) {
                case 1:
                    this.aEl.setImageDrawable(null);
                    this.aEl.setVisibility(8);
                    ay.c(this.aEq, com.baidu.tieba.p.icon_news_head_new);
                    this.aEq.setVisibility(0);
                    break;
                case 2:
                    ay.c(this.aEl, com.baidu.tieba.p.icon_news_down_bar_one);
                    this.aEl.setVisibility(0);
                    this.aEq.setImageDrawable(null);
                    this.aEq.setVisibility(8);
                    break;
                default:
                    this.aEl.setImageDrawable(null);
                    this.aEl.setVisibility(8);
                    this.aEq.setImageDrawable(null);
                    this.aEq.setVisibility(8);
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
