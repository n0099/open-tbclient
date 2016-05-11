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
import com.baidu.tieba.person.data.e;
import com.baidu.tieba.personInfo.b;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonInfoEnterItemView extends RelativeLayout implements com.baidu.tieba.person.a.a {
    private static int dFj = -1;
    private TbImageView El;
    private ImageView dFi;
    private TextView title;

    public PersonInfoEnterItemView(Context context) {
        this(context, null);
    }

    public PersonInfoEnterItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(t.h.personinfo_enter_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.El = (TbImageView) findViewById(t.g.icon);
        this.title = (TextView) findViewById(t.g.title);
        this.dFi = (ImageView) findViewById(t.g.red_tip);
        this.El.setDefaultBgResource(0);
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public void hq(boolean z) {
        if (this.dFi != null) {
            if (z) {
                this.dFi.setVisibility(0);
            } else {
                this.dFi.setVisibility(8);
            }
        }
    }

    public TbImageView getIcon() {
        return this.El;
    }

    public TextView getTitle() {
        return this.title;
    }

    public void setIcon(int i) {
        at.c(this.El, i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        at.k(this.El, i);
    }

    public void a(e eVar, int i, b bVar) {
        dFj = i;
        if (eVar == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.title.setText(eVar.dzo);
            at.c(this.title, t.d.cp_cont_f, 1);
            at.c(this.El, eVar.dzn);
            at.c(this.dFi, t.f.icon_news_down_bar_one);
        }
        setOnClickListener(new a(this, bVar, eVar));
    }

    public void g(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        at.c(this.title, t.d.cp_cont_f, 1);
        at.c(this.dFi, t.f.icon_news_down_bar_one);
        setBackgroundResource(t.f.bg_icon_mine_selector);
    }

    public int getRedTipType() {
        return dFj;
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        hq(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void i(boolean z, int i) {
    }
}
