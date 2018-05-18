package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aqm;
    private TextView cOM;
    private HeadImageView daK;
    private TextView enA;
    private ImageView enz;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        this.daK = (HeadImageView) view2.findViewById(d.g.photo);
        this.daK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aqm = (TextView) view2.findViewById(d.g.user_name);
        this.enz = (ImageView) view2.findViewById(d.g.fans_reply);
        this.cOM = (TextView) view2.findViewById(d.g.time);
        this.enA = (TextView) view2.findViewById(d.g.content);
        this.mLine = view2.findViewById(d.g.line);
        this.daK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                a.this.Gl().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                a.this.Gl().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.aqm.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                ak.h(this.aqm, d.C0126d.cp_cont_r);
            } else {
                ak.h(this.aqm, d.C0126d.cp_cont_c);
            }
            this.daK.setShowV(feedData.getReplyer().isBigV());
            this.daK.setIsRound(true);
            this.daK.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.daK.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.daK.startLoad(portrait, 12, false);
            } else {
                this.daK.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.enz.setVisibility(0);
            } else {
                this.enz.setVisibility(8);
            }
        }
        this.cOM.setText(an.s(feedData.getTime()));
        this.enA.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ak.i(getRootView(), d.f.list_selector);
        ak.j(this.mLine, d.C0126d.cp_bg_line_b);
        ak.h(this.cOM, d.C0126d.cp_cont_d);
        ak.i(this.enz, d.f.icon_pb_fans);
        ak.h(this.enA, d.C0126d.cp_cont_b);
        this.cOM.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
