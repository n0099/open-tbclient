package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView ayt;
    private TextView cXR;
    private HeadImageView dka;
    private ImageView eyR;
    private TextView eyS;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dka = (HeadImageView) view.findViewById(d.g.photo);
        this.dka.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ayt = (TextView) view.findViewById(d.g.user_name);
        this.eyR = (ImageView) view.findViewById(d.g.fans_reply);
        this.cXR = (TextView) view.findViewById(d.g.time);
        this.eyS = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.dka.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.JT().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.JT().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(FeedData feedData) {
        super.G(feedData);
        if (feedData.getReplyer() != null) {
            this.ayt.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                al.h(this.ayt, d.C0141d.cp_cont_r);
            } else {
                al.h(this.ayt, d.C0141d.cp_cont_c);
            }
            this.dka.setShowV(feedData.getReplyer().isBigV());
            this.dka.setIsRound(true);
            this.dka.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dka.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dka.startLoad(portrait, 12, false);
            } else {
                this.dka.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eyR.setVisibility(0);
            } else {
                this.eyR.setVisibility(8);
            }
        }
        this.cXR.setText(ao.v(feedData.getTime()));
        this.eyS.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.i(getRootView(), d.f.list_selector);
        al.j(this.mLine, d.C0141d.cp_bg_line_b);
        al.h(this.cXR, d.C0141d.cp_cont_d);
        al.i(this.eyR, d.f.icon_pb_fans);
        al.h(this.eyS, d.C0141d.cp_cont_b);
        this.cXR.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
