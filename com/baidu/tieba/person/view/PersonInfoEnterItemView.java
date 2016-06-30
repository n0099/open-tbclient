package com.baidu.tieba.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.data.e;
import com.baidu.tieba.personInfo.b;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonInfoEnterItemView extends RelativeLayout implements com.baidu.tieba.person.a.a {
    private static int eon = -1;
    private TbImageView Er;
    private ImageView eom;
    private TextView title;

    public PersonInfoEnterItemView(Context context) {
        this(context, null);
    }

    public PersonInfoEnterItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(u.h.personinfo_enter_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.Er = (TbImageView) findViewById(u.g.icon);
        this.title = (TextView) findViewById(u.g.title);
        this.eom = (ImageView) findViewById(u.g.red_tip);
        this.Er.setDefaultBgResource(0);
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public void il(boolean z) {
        if (this.eom != null) {
            if (z) {
                this.eom.setVisibility(0);
            } else {
                this.eom.setVisibility(8);
            }
        }
    }

    public TbImageView getIcon() {
        return this.Er;
    }

    public TextView getTitle() {
        return this.title;
    }

    public void setIcon(int i) {
        av.c(this.Er, i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        av.k(this.Er, i);
    }

    public void a(e eVar, int i, b bVar) {
        eon = i;
        if (eVar == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.title.setText(eVar.ehS);
            av.c(this.title, u.d.cp_cont_f, 1);
            av.c(this.Er, eVar.ehR);
            av.c(this.eom, u.f.icon_news_down_bar_one);
        }
        setOnClickListener(new a(this, bVar, eVar));
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        av.c(this.title, u.d.cp_cont_f, 1);
        av.c(this.eom, u.f.icon_news_down_bar_one);
        setBackgroundResource(u.f.bg_icon_mine_selector);
    }

    public int getRedTipType() {
        return eon;
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        il(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void l(boolean z, int i) {
    }
}
