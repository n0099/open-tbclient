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
    private TextView ccZ;
    private TextView dpV;
    private HeadImageView eef;
    private ImageView gUA;
    private TextView gUB;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eef = (HeadImageView) view.findViewById(R.id.photo);
        this.eef.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ccZ = (TextView) view.findViewById(R.id.user_name);
        this.gUA = (ImageView) view.findViewById(R.id.fans_reply);
        this.dpV = (TextView) view.findViewById(R.id.time);
        this.gUB = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.eef.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.auS().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.auS().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(FeedData feedData) {
        super.af(feedData);
        if (feedData.getReplyer() != null) {
            this.ccZ.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                am.j(this.ccZ, R.color.cp_cont_r);
            } else {
                am.j(this.ccZ, R.color.cp_cont_c);
            }
            this.eef.setShowV(feedData.getReplyer().isBigV());
            this.eef.setIsRound(true);
            this.eef.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.eef.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.eef.startLoad(portrait, 12, false);
            } else {
                this.eef.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.gUA.setVisibility(0);
            } else {
                this.gUA.setVisibility(8);
            }
        }
        this.dpV.setText(aq.aD(feedData.getTime()));
        this.gUB.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        am.k(getRootView(), R.drawable.list_selector);
        am.l(this.mLine, R.color.cp_bg_line_b);
        am.j(this.dpV, R.color.cp_cont_d);
        am.k(this.gUA, R.drawable.icon_pb_fans);
        am.j(this.gUB, R.color.cp_cont_b);
        this.dpV.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
