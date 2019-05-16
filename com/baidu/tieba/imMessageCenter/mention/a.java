package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView cbV;
    private TextView faW;
    private HeadImageView frU;
    private ImageView gOn;
    private TextView gOo;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.frU = (HeadImageView) view.findViewById(R.id.photo);
        this.frU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cbV = (TextView) view.findViewById(R.id.user_name);
        this.gOn = (ImageView) view.findViewById(R.id.fans_reply);
        this.faW = (TextView) view.findViewById(R.id.time);
        this.gOo = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.frU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.atK().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.atK().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(FeedData feedData) {
        super.af(feedData);
        if (feedData.getReplyer() != null) {
            this.cbV.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                al.j(this.cbV, R.color.cp_cont_r);
            } else {
                al.j(this.cbV, R.color.cp_cont_c);
            }
            this.frU.setShowV(feedData.getReplyer().isBigV());
            this.frU.setIsRound(true);
            this.frU.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.frU.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.frU.startLoad(portrait, 12, false);
            } else {
                this.frU.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.gOn.setVisibility(0);
            } else {
                this.gOn.setVisibility(8);
            }
        }
        this.faW.setText(ap.aC(feedData.getTime()));
        this.gOo.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.k(getRootView(), R.drawable.list_selector);
        al.l(this.mLine, R.color.cp_bg_line_b);
        al.j(this.faW, R.color.cp_cont_d);
        al.k(this.gOn, R.drawable.icon_pb_fans);
        al.j(this.gOo, R.color.cp_cont_b);
        this.faW.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
