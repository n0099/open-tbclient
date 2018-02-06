package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView bfg;
    private HeadImageView dGO;
    private TextView dvd;
    private ImageView eSd;
    private TextView eSe;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dGO = (HeadImageView) view.findViewById(d.g.photo);
        this.dGO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bfg = (TextView) view.findViewById(d.g.user_name);
        this.eSd = (ImageView) view.findViewById(d.g.fans_reply);
        this.dvd = (TextView) view.findViewById(d.g.time);
        this.eSe = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.dGO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.NL().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.NL().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(FeedData feedData) {
        super.aI(feedData);
        if (feedData.getReplyer() != null) {
            this.bfg.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.r(this.bfg, d.C0140d.cp_cont_r);
            } else {
                aj.r(this.bfg, d.C0140d.cp_cont_c);
            }
            this.dGO.setShowV(feedData.getReplyer().isBigV());
            this.dGO.setIsRound(true);
            this.dGO.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dGO.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dGO.startLoad(portrait, 12, false);
            } else {
                this.dGO.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eSd.setVisibility(0);
            } else {
                this.eSd.setVisibility(8);
            }
        }
        this.dvd.setText(am.z(feedData.getTime()));
        this.eSe.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(getRootView(), d.f.list_selector);
        aj.t(this.mLine, d.C0140d.cp_bg_line_b);
        aj.r(this.dvd, d.C0140d.cp_cont_d);
        aj.s(this.eSd, d.f.icon_pb_fans);
        aj.r(this.eSe, d.C0140d.cp_cont_b);
        this.dvd.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
