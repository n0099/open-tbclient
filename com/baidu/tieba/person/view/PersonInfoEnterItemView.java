package com.baidu.tieba.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.data.d;
import com.baidu.tieba.personInfo.b;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonInfoEnterItemView extends RelativeLayout implements com.baidu.tieba.person.a.a {
    private static int dCb = -1;
    private TbImageView NV;
    private TextView apE;
    private ImageView dCa;

    public PersonInfoEnterItemView(Context context) {
        this(context, null);
    }

    public PersonInfoEnterItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(t.h.personinfo_enter_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.NV = (TbImageView) findViewById(t.g.icon);
        this.apE = (TextView) findViewById(t.g.title);
        this.dCa = (ImageView) findViewById(t.g.red_tip);
        this.NV.setDefaultBgResource(0);
    }

    public void setTitle(String str) {
        if (this.apE != null) {
            this.apE.setText(str);
        }
    }

    public void gK(boolean z) {
        if (this.dCa != null) {
            if (z) {
                this.dCa.setVisibility(0);
            } else {
                this.dCa.setVisibility(8);
            }
        }
    }

    public TbImageView getIcon() {
        return this.NV;
    }

    public TextView getTitle() {
        return this.apE;
    }

    public void setIcon(int i) {
        at.c(this.NV, i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        at.k(this.NV, i);
    }

    public void a(d dVar, int i, b bVar) {
        dCb = i;
        if (dVar == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.apE.setText(dVar.dwk);
            at.b(this.apE, t.d.cp_cont_f, 1);
            at.c(this.NV, dVar.dwj);
            at.c(this.dCa, t.f.icon_news_down_bar_one);
        }
        setOnClickListener(new a(this, bVar, dVar));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        at.b(this.apE, t.d.cp_cont_f, 1);
        at.c(this.dCa, t.f.icon_news_down_bar_one);
        setBackgroundResource(t.f.bg_icon_mine_selector);
    }

    public int getRedTipType() {
        return dCb;
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        gK(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void g(boolean z, int i) {
    }
}
