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
    private TextView ayY;
    private TextView cYJ;
    private HeadImageView doZ;
    private ImageView eGA;
    private TextView eGB;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.doZ = (HeadImageView) view.findViewById(d.g.photo);
        this.doZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ayY = (TextView) view.findViewById(d.g.user_name);
        this.eGA = (ImageView) view.findViewById(d.g.fans_reply);
        this.cYJ = (TextView) view.findViewById(d.g.time);
        this.eGB = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.doZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Kg().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Kg().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(FeedData feedData) {
        super.G(feedData);
        if (feedData.getReplyer() != null) {
            this.ayY.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                am.h(this.ayY, d.C0140d.cp_cont_r);
            } else {
                am.h(this.ayY, d.C0140d.cp_cont_c);
            }
            this.doZ.setShowV(feedData.getReplyer().isBigV());
            this.doZ.setIsRound(true);
            this.doZ.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.doZ.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.doZ.startLoad(portrait, 12, false);
            } else {
                this.doZ.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eGA.setVisibility(0);
            } else {
                this.eGA.setVisibility(8);
            }
        }
        this.cYJ.setText(ap.w(feedData.getTime()));
        this.eGB.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.i(getRootView(), d.f.list_selector);
        am.j(this.mLine, d.C0140d.cp_bg_line_b);
        am.h(this.cYJ, d.C0140d.cp_cont_d);
        am.i(this.eGA, d.f.icon_pb_fans);
        am.h(this.eGB, d.C0140d.cp_cont_b);
        this.cYJ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
