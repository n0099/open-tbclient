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
    private static int cRA = -1;
    private TbImageView MW;
    private ImageView aOv;
    private TextView agd;

    public PersonInfoEnterItemView(Context context) {
        this(context, null);
    }

    public PersonInfoEnterItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(n.g.personinfo_enter_item, (ViewGroup) this, true);
        init();
    }

    private void init() {
        this.MW = (TbImageView) findViewById(n.f.icon);
        this.agd = (TextView) findViewById(n.f.title);
        this.aOv = (ImageView) findViewById(n.f.red_tip);
        this.MW.setDefaultBgResource(0);
    }

    public void setTitle(String str) {
        if (this.agd != null) {
            this.agd.setText(str);
        }
    }

    public void bW(boolean z) {
        if (this.aOv != null) {
            if (z) {
                this.aOv.setVisibility(0);
            } else {
                this.aOv.setVisibility(8);
            }
        }
    }

    public TbImageView getIcon() {
        return this.MW;
    }

    public TextView getTitle() {
        return this.agd;
    }

    public void setIcon(int i) {
        as.c(this.MW, i);
    }

    public void a(d dVar, int i, com.baidu.tieba.personInfo.a aVar) {
        cRA = i;
        if (dVar == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.agd.setText(dVar.cNp);
            as.b(this.agd, n.c.cp_cont_f, 1);
            as.c(this.MW, dVar.cNo);
            as.c(this.aOv, n.e.icon_news_down_bar_one);
        }
        setOnClickListener(new a(this, aVar, dVar));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        as.b(this.agd, n.c.cp_cont_f, 1);
        as.c(this.aOv, n.e.icon_news_down_bar_one);
    }

    public int getRedTipType() {
        return cRA;
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        bW(z);
    }
}
