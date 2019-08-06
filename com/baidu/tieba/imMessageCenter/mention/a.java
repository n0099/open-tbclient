package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView cdg;
    private TextView dqc;
    private HeadImageView eem;
    private ImageView gVs;
    private TextView gVt;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eem = (HeadImageView) view.findViewById(R.id.photo);
        this.eem.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cdg = (TextView) view.findViewById(R.id.user_name);
        this.gVs = (ImageView) view.findViewById(R.id.fans_reply);
        this.dqc = (TextView) view.findViewById(R.id.time);
        this.gVt = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.eem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.auU().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.auU().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(FeedData feedData) {
        super.af(feedData);
        if (feedData.getReplyer() != null) {
            this.cdg.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                am.j(this.cdg, R.color.cp_cont_r);
            } else {
                am.j(this.cdg, R.color.cp_cont_c);
            }
            this.eem.setShowV(feedData.getReplyer().isBigV());
            this.eem.setIsRound(true);
            this.eem.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.eem.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.eem.startLoad(portrait, 12, false);
            } else {
                this.eem.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.gVs.setVisibility(0);
            } else {
                this.gVs.setVisibility(8);
            }
        }
        this.dqc.setText(aq.aD(feedData.getTime()));
        this.gVt.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.k(getRootView(), R.drawable.list_selector);
        am.l(this.mLine, R.color.cp_bg_line_b);
        am.j(this.dqc, R.color.cp_cont_d);
        am.k(this.gVs, R.drawable.icon_pb_fans);
        am.j(this.gVt, R.color.cp_cont_b);
        this.dqc.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
