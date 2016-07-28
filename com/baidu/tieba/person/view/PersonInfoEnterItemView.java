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
import com.baidu.tieba.person.data.f;
import com.baidu.tieba.personInfo.d;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonInfoEnterItemView extends RelativeLayout implements com.baidu.tieba.person.a.a {
    private static int exq = -1;
    private TbImageView ER;
    private ImageView exp;
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
        this.ER = (TbImageView) findViewById(u.g.icon);
        this.title = (TextView) findViewById(u.g.title);
        this.exp = (ImageView) findViewById(u.g.red_tip);
        this.ER.setDefaultBgResource(0);
    }

    public void setTitle(String str) {
        if (this.title != null) {
            this.title.setText(str);
        }
    }

    public void iu(boolean z) {
        if (this.exp != null) {
            if (z) {
                this.exp.setVisibility(0);
            } else {
                this.exp.setVisibility(8);
            }
        }
    }

    public TbImageView getIcon() {
        return this.ER;
    }

    public TextView getTitle() {
        return this.title;
    }

    public void setIcon(int i) {
        av.c(this.ER, i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        av.k(this.ER, i);
    }

    public void a(f fVar, int i, d dVar) {
        exq = i;
        if (fVar == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.title.setText(fVar.erY);
            av.c(this.title, u.d.cp_cont_f, 1);
            av.c(this.ER, fVar.erX);
            av.c(this.exp, u.f.icon_news_down_bar_one);
        }
        setOnClickListener(new a(this, dVar, fVar));
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        av.c(this.title, u.d.cp_cont_f, 1);
        av.c(this.exp, u.f.icon_news_down_bar_one);
        setBackgroundResource(u.f.bg_icon_mine_selector);
    }

    public int getRedTipType() {
        return exq;
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        iu(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void m(boolean z, int i) {
    }
}
