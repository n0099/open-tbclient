package com.baidu.tieba.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.data.d;
import com.baidu.tieba.personInfo.b;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonInfoEnterItemView extends RelativeLayout implements com.baidu.tieba.person.a.a {
    private static int dhA = -1;
    private TbImageView NM;
    private TextView apm;
    private ImageView dhz;

    public PersonInfoEnterItemView(Context context) {
        this(context, null);
    }

    public PersonInfoEnterItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(t.h.personinfo_enter_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.NM = (TbImageView) findViewById(t.g.icon);
        this.apm = (TextView) findViewById(t.g.title);
        this.dhz = (ImageView) findViewById(t.g.red_tip);
        this.NM.setDefaultBgResource(0);
    }

    public void setTitle(String str) {
        if (this.apm != null) {
            this.apm.setText(str);
        }
    }

    public void fX(boolean z) {
        if (this.dhz != null) {
            if (z) {
                this.dhz.setVisibility(0);
            } else {
                this.dhz.setVisibility(8);
            }
        }
    }

    public TbImageView getIcon() {
        return this.NM;
    }

    public TextView getTitle() {
        return this.apm;
    }

    public void setIcon(int i) {
        ar.c(this.NM, i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        ar.k(this.NM, i);
    }

    public void a(d dVar, int i, b bVar) {
        dhA = i;
        if (dVar == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.apm.setText(dVar.dbH);
            ar.b(this.apm, t.d.cp_cont_f, 1);
            ar.c(this.NM, dVar.dbG);
            ar.c(this.dhz, t.f.icon_news_down_bar_one);
        }
        setOnClickListener(new a(this, bVar, dVar));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        ar.b(this.apm, t.d.cp_cont_f, 1);
        ar.c(this.dhz, t.f.icon_news_down_bar_one);
        setBackgroundResource(t.f.bg_icon_mine_selector);
    }

    public int getRedTipType() {
        return dhA;
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        fX(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void e(boolean z, int i) {
    }
}
