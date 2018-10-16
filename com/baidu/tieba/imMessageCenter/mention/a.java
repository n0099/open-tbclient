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
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aGD;
    private HeadImageView dCV;
    private TextView dmH;
    private ImageView eVt;
    private TextView eVu;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dCV = (HeadImageView) view.findViewById(e.g.photo);
        this.dCV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aGD = (TextView) view.findViewById(e.g.user_name);
        this.eVt = (ImageView) view.findViewById(e.g.fans_reply);
        this.dmH = (TextView) view.findViewById(e.g.time);
        this.eVu = (TextView) view.findViewById(e.g.content);
        this.mLine = view.findViewById(e.g.line);
        this.dCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Ny().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Ny().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(FeedData feedData) {
        super.L(feedData);
        if (feedData.getReplyer() != null) {
            this.aGD.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                al.h(this.aGD, e.d.cp_cont_r);
            } else {
                al.h(this.aGD, e.d.cp_cont_c);
            }
            this.dCV.setShowV(feedData.getReplyer().isBigV());
            this.dCV.setIsRound(true);
            this.dCV.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dCV.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dCV.startLoad(portrait, 12, false);
            } else {
                this.dCV.setImageResource(e.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eVt.setVisibility(0);
            } else {
                this.eVt.setVisibility(8);
            }
        }
        this.dmH.setText(ao.C(feedData.getTime()));
        this.eVu.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.i(getRootView(), e.f.list_selector);
        al.j(this.mLine, e.d.cp_bg_line_b);
        al.h(this.dmH, e.d.cp_cont_d);
        al.i(this.eVt, e.f.icon_pb_fans);
        al.h(this.eVu, e.d.cp_cont_b);
        this.dmH.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
