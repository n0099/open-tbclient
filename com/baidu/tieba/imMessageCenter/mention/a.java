package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView azm;
    private TextView cVU;
    private HeadImageView dmh;
    private ImageView eCG;
    private TextView eCH;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dmh = (HeadImageView) view.findViewById(d.g.photo);
        this.dmh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.azm = (TextView) view.findViewById(d.g.user_name);
        this.eCG = (ImageView) view.findViewById(d.g.fans_reply);
        this.cVU = (TextView) view.findViewById(d.g.time);
        this.eCH = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.dmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Kl().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Kl().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(FeedData feedData) {
        super.G(feedData);
        if (feedData.getReplyer() != null) {
            this.azm.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                am.h(this.azm, d.C0142d.cp_cont_r);
            } else {
                am.h(this.azm, d.C0142d.cp_cont_c);
            }
            this.dmh.setShowV(feedData.getReplyer().isBigV());
            this.dmh.setIsRound(true);
            this.dmh.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dmh.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dmh.startLoad(portrait, 12, false);
            } else {
                this.dmh.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eCG.setVisibility(0);
            } else {
                this.eCG.setVisibility(8);
            }
        }
        this.cVU.setText(ap.w(feedData.getTime()));
        this.eCH.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.i(getRootView(), d.f.list_selector);
        am.j(this.mLine, d.C0142d.cp_bg_line_b);
        am.h(this.cVU, d.C0142d.cp_cont_d);
        am.i(this.eCG, d.f.icon_pb_fans);
        am.h(this.eCH, d.C0142d.cp_cont_b);
        this.cVU.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
