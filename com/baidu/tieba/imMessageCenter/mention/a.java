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
import com.baidu.tieba.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView ayV;
    private TextView cYF;
    private HeadImageView doX;
    private ImageView eGv;
    private TextView eGw;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.doX = (HeadImageView) view.findViewById(f.g.photo);
        this.doX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ayV = (TextView) view.findViewById(f.g.user_name);
        this.eGv = (ImageView) view.findViewById(f.g.fans_reply);
        this.cYF = (TextView) view.findViewById(f.g.time);
        this.eGw = (TextView) view.findViewById(f.g.content);
        this.mLine = view.findViewById(f.g.line);
        this.doX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Kk().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Kk().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(FeedData feedData) {
        super.G(feedData);
        if (feedData.getReplyer() != null) {
            this.ayV.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                am.h(this.ayV, f.d.cp_cont_r);
            } else {
                am.h(this.ayV, f.d.cp_cont_c);
            }
            this.doX.setShowV(feedData.getReplyer().isBigV());
            this.doX.setIsRound(true);
            this.doX.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.doX.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.doX.startLoad(portrait, 12, false);
            } else {
                this.doX.setImageResource(f.C0146f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eGv.setVisibility(0);
            } else {
                this.eGv.setVisibility(8);
            }
        }
        this.cYF.setText(ap.w(feedData.getTime()));
        this.eGw.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.i(getRootView(), f.C0146f.list_selector);
        am.j(this.mLine, f.d.cp_bg_line_b);
        am.h(this.cYF, f.d.cp_cont_d);
        am.i(this.eGv, f.C0146f.icon_pb_fans);
        am.h(this.eGw, f.d.cp_cont_b);
        this.cYF.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
