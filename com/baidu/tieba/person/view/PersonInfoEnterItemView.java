package com.baidu.tieba.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.data.d;
/* loaded from: classes.dex */
public class PersonInfoEnterItemView extends RelativeLayout implements com.baidu.tieba.person.a.a {
    private static int cWb = -1;
    private TbImageView Nm;
    private ImageView aSn;
    private TextView ahk;

    public PersonInfoEnterItemView(Context context) {
        this(context, null);
    }

    public PersonInfoEnterItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(n.h.personinfo_enter_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.Nm = (TbImageView) findViewById(n.g.icon);
        this.ahk = (TextView) findViewById(n.g.title);
        this.aSn = (ImageView) findViewById(n.g.red_tip);
        this.Nm.setDefaultBgResource(0);
    }

    public void setTitle(String str) {
        if (this.ahk != null) {
            this.ahk.setText(str);
        }
    }

    public void bX(boolean z) {
        if (this.aSn != null) {
            if (z) {
                this.aSn.setVisibility(0);
            } else {
                this.aSn.setVisibility(8);
            }
        }
    }

    public TbImageView getIcon() {
        return this.Nm;
    }

    public TextView getTitle() {
        return this.ahk;
    }

    public void setIcon(int i) {
        as.c(this.Nm, i);
    }

    public void a(d dVar, int i, com.baidu.tieba.personInfo.a aVar) {
        cWb = i;
        if (dVar == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.ahk.setText(dVar.cRT);
            as.b(this.ahk, n.d.cp_cont_f, 1);
            as.c(this.Nm, dVar.cRS);
            as.c(this.aSn, n.f.icon_news_down_bar_one);
        }
        setOnClickListener(new a(this, aVar, dVar));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        as.b(this.ahk, n.d.cp_cont_f, 1);
        as.c(this.aSn, n.f.icon_news_down_bar_one);
    }

    public int getRedTipType() {
        return cWb;
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        bX(z);
    }
}
